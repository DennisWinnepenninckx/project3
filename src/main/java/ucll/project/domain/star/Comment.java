package ucll.project.domain.star;

import ucll.project.domain.user.User;

import java.util.Date;

public class Comment {
    private String user_email;
    private User user;
    private String comment;
    private Date datetime;
    private int star;

    public Comment(String user_email, User user, String comment, int star, Date datetime) {
        this.user_email = user_email;
        this.user = user;
        this.comment = comment;
        this.star = star;
        this.datetime = datetime;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
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
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }
}
