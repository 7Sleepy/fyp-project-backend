package com.fyp.service.impl;

import com.fyp.entity.Enrollment;
import com.fyp.entity.Student;
import com.fyp.repository.EnrollmentRepository;
import com.fyp.repository.StudentRepository;
import com.fyp.response.UploadResponse;
import com.fyp.service.UploadService;
import com.fyp.util.NLPImpl;
import com.fyp.util.OCRImpl;
import com.fyp.util.RegularExpressionImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UploadServiceImpl implements UploadService {

    @Autowired
    OCRImpl ocrImpl;

    @Autowired
    RegularExpressionImpl regularExpressionImpl;

    @Autowired
    NLPImpl nlpImpl;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    EnrollmentRepository enrollmentRepository;

    @Override
    public UploadResponse sendImage(MultipartFile image, Long studentId, Long enrollmentId) {

        String finalFirstName = "";
        String finalLastName = "";
        String finalStudentIdNumber = "";

        // OCR Implementation
        String extractedText = ocrImpl.extractTextFromImage(image);

        UploadResponse response = new UploadResponse();
        // Regex Implementation
        String studentIDNumber = regularExpressionImpl.regexGetID(extractedText);
        finalStudentIdNumber = studentIDNumber;
        response.setStudentIDNumber(studentIDNumber);
        String cleanedText = regularExpressionImpl.regexDataCleaning(extractedText, studentIDNumber);

        // NLP Implementation
        String[] names = nlpImpl.extractNames(cleanedText);
        finalFirstName = names[0];
        finalLastName = names[1];
        response.setFirstName(names[0]);
        response.setLastName(names[1]);

        // Cross-checking with database
        Student student = studentRepository.findByStdnIdAndIsDeletedFalse(studentId);
        String actualStudentId = student.getStdn_id_number();
        String actualStudentFirstName = student.getStdn_firstname();
        String actualStudentLastName = student.getStdn_lastname();

        if (actualStudentId.equals(finalStudentIdNumber)) {
            if (actualStudentFirstName.equals(finalFirstName)) {
                if (actualStudentLastName.equals(finalLastName)) {

                    // ID matches Student in Database = Mark Present
                    Enrollment enrollmentToUpdate = enrollmentRepository.findByEnrollmentIdAndIsDeletedFalse(enrollmentId);
                    enrollmentToUpdate.setAttendance_status("Present");
                    enrollmentRepository.save(enrollmentToUpdate);
                    response.setAttendanceAttempt("Success");
                    response.setError(null);
                } else {
                    response.setAttendanceAttempt("3");
                    response.setError("Your account does not match this Student ID Card.");
                }

            } else {
                response.setAttendanceAttempt("2");
                response.setError("Your account does not match this Student ID Card.");
            }
        } else {
            response.setAttendanceAttempt("1");
            response.setError("Your account does not match this Student ID Card.");
        }

        return response;
    }
}
