package ucll.project.domain.star;

import ucll.project.domain.user.User;

public class Comment {
    private String user_email;
    private User user;
    private String comment;
    private int Star;

    public Comment(String user_email, User user, String comment, int star) {
        this.user_email = user_email;
        this.user = user;
        this.comment = comment;
        Star = star;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getStar() {
        return Star;
    }

    public void setStar(int star) {
        Star = star;
    }
}
