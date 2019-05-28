package util.readers;

public class Message {
    String recepient;
    String subject;
    String message_text;

    public Message(String recepient, String subject, String message_text) {
        this.recepient = recepient;
        this.subject = subject;
        this.message_text = message_text;
    }

    public String getRecepient() {
        return recepient;
    }

    public void setRecepient(String recepient) {
        this.recepient = recepient;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage_text() {
        return message_text;
    }

    public void setMessage_text(String message_text) {
        this.message_text = message_text;
    }


}

