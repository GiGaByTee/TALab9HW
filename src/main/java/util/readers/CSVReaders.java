package util.readers;

import com.opencsv.CSVReader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CSVReaders {
    public static List<Message> readMessageFromCSV() {
        String csvFile = "src//main//resources//test-data//message.csv";
        List<Message> wordsList = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new FileReader(csvFile))) {
            String[] line;
            while ((line = reader.readNext()) != null) {
                wordsList.add(createMessage(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return wordsList;
    }

    private static Message createMessage(String[] metadata) {
        String recipient = metadata[0];
        String subject = metadata[1];
        String message_text = metadata[2];
        return new Message(recipient, subject, message_text);
    }

}
