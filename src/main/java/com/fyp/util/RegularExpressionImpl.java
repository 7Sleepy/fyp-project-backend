package com.fyp.util;

import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class RegularExpressionImpl {

    public String regexGetID(String extractedText) {
        Pattern pattern = Pattern.compile("STU\\d{3}");
        Matcher matcher = pattern.matcher(extractedText);
        if (matcher.find()) {
            return matcher.group();
        } else {
            return "ID Not Found!";
        }
    }

    public String regexDataCleaning(String extractedText, String id) {

        return extractedText
                .replaceAll(id, "") // Remove the studentIDNumber from the text
                .replaceAll("[^a-zA-Z\\s]", "") // Remove all characters that are not alphabets or whitespaces
                .replaceAll("\\bSTUDENT\\b", "") // Remove the word "STUDENT" as a whole word
                .replaceAll("\\bID\\b", ""); // Remove the word "ID" as a whole word
    }
}
