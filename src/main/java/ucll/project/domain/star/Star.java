package ucll.project.domain.star;

import java.util.List;
import java.util.Random;

public class Star {
    private int id;
    private List<String> tags;
    private String description;
    private String sender, receiver;

    public Star(List<String> tags, String description, String sender, String receiver) {
        this.tags = tags;
        this.description = description;
        this.sender = sender;
        this.receiver = receiver;
        this.id = new Random().nextInt(1000000000);
    }

    public Star(int id, List<String> tags, String description, String sender, String receiver) {
        this.tags = tags;
        this.description = description;
        this.sender = sender;
        this.receiver = receiver;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }
}
