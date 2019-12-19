package ucll.project.db;

import ucll.project.domain.star.Comment;
import ucll.project.domain.star.Star;
import ucll.project.domain.user.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StarDB {

    public void createStar(Star star) {
        try (Connection conn = ConnectionPool.getConnection();
             PreparedStatement stmt = conn.prepareStatement("INSERT INTO \"star\" " +
                             "(id, description, sender_email, receiver_email) VALUES (?, ?, ?, ?)",
                     Statement.RETURN_GENERATED_KEYS);
             PreparedStatement stmt2 = conn.prepareStatement("INSERT INTO star_tag_link (tag, star) VALUES (?, ?)")) {
            stmt.setInt(1, star.getId());
            stmt.setString(2, star.getDescription());
            stmt.setString(3, star.getSender());
            stmt.setString(4, star.getReceiver());

            if (stmt.executeUpdate() == 0) {
                throw new RuntimeException("Failed to create star");
            }

            for (String tag :
                    star.getTags()) {
                addTag(tag, star.getId());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void addTag(String name, int starid) {
        try (Connection conn = ConnectionPool.getConnection();
             PreparedStatement stmt = conn.prepareStatement("INSERT INTO \"star_tag_link\" " +
                     "(tag, star) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS)) {

            stmt.setInt(2, starid);
            stmt.setString(1, name);
            if (stmt.executeUpdate() == 0) {
                throw new RuntimeException("Failed to create star");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int usersSendStarsThisMonth(User user) {
        try (Connection conn = ConnectionPool.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT count(*) FROM \"star\" WHERE sender_email = ? and extract(month from date) = extract(month from now()) and extract(year from date) = extract(year from now()) ")) {
            stmt.setString(1, user.getEmail());
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 3;
    }

    public List<Star> getAll() {
        List<Star> stars = new ArrayList<>();

        try (Connection conn = ConnectionPool.getConnection();
             PreparedStatement stmt2 = conn.prepareStatement("SELECT * FROM star order by date desc", Statement.RETURN_GENERATED_KEYS)) {

            ResultSet starResult = stmt2.executeQuery();

            while (starResult.next()) {
                Star star = starFromResult(starResult);
                stars.add(star);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return stars;
    }

    public void makeComment(Comment comment) {
        try (Connection conn = ConnectionPool.getConnection();
             PreparedStatement stmt = conn.prepareStatement("INSERT INTO \"comment\" " +
                             "(user_email, star, reaction) VALUES (?, ?, ?)",
                     Statement.RETURN_GENERATED_KEYS);
             PreparedStatement stmt2 = conn.prepareStatement("INSERT INTO star_tag_link (tag, star) VALUES (?, ?)")) {
            stmt.setString(1, comment.getUser_email());
            stmt.setInt(2, comment.getStar());
            stmt.setString(3, comment.getComment());

            if (stmt.executeUpdate() == 0) {
                throw new RuntimeException("Failed to create comment");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private Star starFromResult(ResultSet starResult) throws SQLException {
        Star star = new Star(starResult.getInt("id"), getTagsOfStar(starResult.getInt("id")), starResult.getString("description"), starResult.getString("sender_email"), starResult.getString("receiver_email"));
        star.setSenderUser(DBController.getInstance().getUser(star.getSender()));
        star.setReceiverUser(DBController.getInstance().getUser(star.getReceiver()));
        star.setDate(starResult.getDate("date"));
        star.setComments(getCommentsFromStar(star.getId()));
        return star;
    }

    public List<String> getTagsOfStar(int starId) {
        List<String> tags = new ArrayList<>();
        try (Connection conn = ConnectionPool.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM star_tag_link where star = ?", Statement.RETURN_GENERATED_KEYS)) {

            stmt.setInt(1, starId);
            ResultSet result = stmt.executeQuery();
            while (result.next()) {
                try {
                    tags.add(result.getString("tag"));
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return tags;
    }

    public List<Star> getAllGivenStarsUser(User user) {
        List<Star> stars = new ArrayList<>();

        try (Connection conn = ConnectionPool.getConnection();
             PreparedStatement stmt2 = conn.prepareStatement("SELECT * FROM star where sender_email = ? order by date desc", Statement.RETURN_GENERATED_KEYS)) {

            stmt2.setString(1, user.getEmail());
            ResultSet starResult = stmt2.executeQuery();

            while (starResult.next()) {
                Star star = starFromResult(starResult);
                stars.add(star);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return stars;
    }

    public List<Star> getAllReceivedStars(User user) {
        List<Star> stars = new ArrayList<>();

        try (Connection conn = ConnectionPool.getConnection();
             PreparedStatement stmt2 = conn.prepareStatement("SELECT * FROM star where receiver_email = ? order by date desc", Statement.RETURN_GENERATED_KEYS)) {

            stmt2.setString(1, user.getEmail());
            ResultSet starResult = stmt2.executeQuery();

            while (starResult.next()) {
                Star star = starFromResult(starResult);
                stars.add(star);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return stars;
    }

    private List<Comment> getCommentsFromStar(int starId) {
        List<Comment> comments = new ArrayList<>();

        try (Connection conn = ConnectionPool.getConnection();
             PreparedStatement stmt2 = conn.prepareStatement("SELECT * FROM comment where star = ? order by datetime desc", Statement.RETURN_GENERATED_KEYS)) {

            stmt2.setInt(1, starId);
            ResultSet starResult = stmt2.executeQuery();

            while (starResult.next()) {
                Comment comment = commentFromResult(starResult);
                comments.add(comment);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return comments;
    }

    public List<Star> searchStars(String searchTerm) {
        List<Star> stars = new ArrayList<>();
        searchTerm = "%" + searchTerm + "%";

        try (Connection conn = ConnectionPool.getConnection();
             PreparedStatement stmt2 = conn.prepareStatement("SELECT s.id, s.description, s.sender_email, s.receiver_email, s.date FROM star s left outer join star_tag_link t on(s.id = t.star) where lower(t.tag) like ? or lower(s.description) like ? or lower(s.sender_email) like ? or lower(s.receiver_email) like ? group by (s.id) order by s.date desc", Statement.RETURN_GENERATED_KEYS)) {

            stmt2.setString(1, searchTerm);
            stmt2.setString(2, searchTerm);
            stmt2.setString(3, searchTerm);
            stmt2.setString(4, searchTerm);
            ResultSet starResult = stmt2.executeQuery();

            while (starResult.next()) {
                Star star = starFromResult(starResult);
                stars.add(star);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return stars;
    }

    private Comment commentFromResult(ResultSet result) throws SQLException {
        Comment comment = new Comment(result.getString("user_email"), DBController.getInstance().getUser(result.getString("user_email")), result.getString("reaction"), result.getInt("star"), result.getTime("datetime"));
        return comment;
    }

    public List<String> getTags() {
        List<String> tags = new ArrayList<>();
        try (Connection conn = ConnectionPool.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM tags", Statement.RETURN_GENERATED_KEYS)) {

            ResultSet result = stmt.executeQuery();
            while (result.next()) {
                try {
                    tags.add(result.getString("name"));
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return tags;
    }
}