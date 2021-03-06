package ucll.project.domain.star;


import ucll.project.db.DBException;
import ucll.project.domain.user.User;
import ucll.project.domain.user.UserService;

import java.util.Date;
import java.util.List;
import java.util.Random;

public class Star {
    private int id;
    private List<String> tags;
    private String description;
    private String sender, receiver;
    private User senderUser, receiverUser;
    private Date date;
    private List<Comment> comments;

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public User getSenderUser() {
        return senderUser;
    }

    public void setSenderUser(User senderUser) {
        this.senderUser = senderUser;
    }

    public User getReceiverUser() {
        return receiverUser;
    }

    public void setReceiverUser(User receiverUser) {
        this.receiverUser = receiverUser;
    }

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

    public String getTagsInString() {
        String result = "";
        for (String s : tags) {
            result += "-" + s + "\n";
        }
        return result;
    }

    @Override
    public String toString() {
        return "{" +
                "'id':" + id +
                ", 'tags':" + tagsToString() +
                ", 'description':'" + descriptionEscape() + '\'' +
                ", 'sender':'" + sender + '\'' +
                ", 'receiver':'" + receiver + '\'' +
                ", 'senderUserFirstname':'" + senderUser.getFirstName() + "'" +
                ", 'senderUserLastname':'" + senderUser.getLastname() + "'" +
                ", 'receiverPic':'" + receiverUser.getProfilepic() + "'" +
                ", 'receiverUserFirstname':'" + receiverUser.getFirstName() + "'" +
                ", 'receiverUserLastname':'" + receiverUser.getLastname() + "'" +
                ", 'date':'" + date + "'" +
                ", 'comments':" + comments +
                '}';
    }

    private String descriptionEscape() {
        String b = new String(description);
        b = b.replaceAll("&", "&amp;");
        b = b.replaceAll("'", "&apos;");
        b = b.replaceAll("\"", "&quot;");
        b = b.replaceAll("<", "&lt;");
        b = b.replaceAll(">", "&gt;");
        return b;
    }

    private String tagsToString() {
        StringBuilder tagst = new StringBuilder("[");
        for (int i = 0; i < tags.size(); i++) {
            tagst.append("'").append(tags.get(i)).append("'");
            if (i < tags.size() - 1) {
                tagst.append(",");
            }
        }
        tagst.append("]");
        return tagst.toString();
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

    public User getUserReceiver() {
        for (User u : new UserService().getUsers()) {
            if (u.getEmail().equals(receiver)) {
                return u;
            }
        }
        throw new DBException("Did not find user with email " + receiver);
    }

    public User getUserSender() {
        for (User u : new UserService().getUsers()) {
            if (u.getEmail().equals(sender)) {
                return u;
            }
        }
        throw new DBException("Did not find user with email " + sender);
    }
}
