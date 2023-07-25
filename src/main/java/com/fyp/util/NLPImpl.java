package com.fyp.util;

import opennlp.tools.namefind.NameFinderME;
import opennlp.tools.namefind.TokenNameFinderModel;
import opennlp.tools.util.Span;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;

@Service
public class NLPImpl {

    public String[] extractNames(String cleanedText) {
        String[] names = new String[2];

        try {
            InputStream modelIn = NLPImpl.class.getResourceAsStream("/NamedEntityRecognitionModel/en-ner-person.bin");
            assert modelIn != null;
            TokenNameFinderModel model = new TokenNameFinderModel(modelIn);
            NameFinderME nameFinder = new NameFinderME(model);

            // Split the cleaned text into words (tokens)
            String[] tokens = cleanedText.split("\\s+");

            // Find the names in the text
            Span[] nameSpans = nameFinder.find(tokens);

            // Check if any names were found
            if (nameSpans.length > 0) {
                // Assuming the first name and last name are present in the first nameSpan
                String firstName = tokens[nameSpans[0].getStart()];
                String lastName = tokens[nameSpans[0].getEnd() - 1];

                names[0] = firstName;
                names[1] = lastName;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return names;
    }
}
