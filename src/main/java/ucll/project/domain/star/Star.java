package ucll.project.domain.star;


import ucll.project.db.DBException;
import ucll.project.domain.user.User;
import ucll.project.domain.user.UserService;

import java.util.List;
import java.util.Random;

public class Star {
    private int id;
    private List<String> tags;
    private String description;
    private String sender, receiver;

    public Star() {
    }

    public Star(List<String> tags, String description, String sender, String receiver) {
        this.tags = tags;
        this.description = description;
        this.sender = sender;
        this.receiver = receiver;
        this.id = new Random().nextInt(1000000000);
    }

    public Star(List<String> tags, String description, String sender, String receiver, UserService userService) {
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
    public String getTagsInString(){
        String result = "";
        for (String s : tags){
            result += "-"+s + "\n";
        }
        return result;
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

    public User getUserReceiver(){
        for (User u: new UserService().getUsers()){
            if (u.getEmail().equals(receiver)){
                return u;
            }
        }
        throw new DBException("Did not find user with email " + receiver);
    }
    public User getUserSender(){
        for (User u: new UserService().getUsers()){
            if (u.getEmail().equals(sender)){
                return u;
            }
        }
        throw new DBException("Did not find user with email " + sender);
    }
}
