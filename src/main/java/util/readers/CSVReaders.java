package util.readers;

import com.opencsv.CSVReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class CSVReaders {
    public static Object[] readMessageFromCSV() {
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
        return wordsList.toArray();
    }

    private static Message createMessage(String[] metadata) {
        String recipient = metadata[0];
        String subject = metadata[1];
        String message_text = metadata[2];
        return new Message(recipient, subject, message_text);
    }

}
