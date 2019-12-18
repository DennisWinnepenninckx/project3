package ucll.project.db;

import ucll.project.db.ConnectionPool;
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
                Star star = new Star(starResult.getInt("id"), getTagsOfStar(starResult.getInt("id")), starResult.getString("description"), starResult.getString("sender_email"), starResult.getString("receiver_email"));
                star.setSenderUser(DBController.getInstance().getUser(star.getSender()));
                star.setReceiverUser(DBController.getInstance().getUser(star.getReceiver()));
                stars.add(star);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return stars;
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
                Star star = new Star(starResult.getInt("id"), getTagsOfStar(starResult.getInt("id")), starResult.getString("description"), starResult.getString("sender_email"), starResult.getString("receiver_email"));
                star.setSenderUser(DBController.getInstance().getUser(star.getSender()));
                star.setReceiverUser(DBController.getInstance().getUser(star.getReceiver()));
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
                Star star = new Star(starResult.getInt("id"), getTagsOfStar(starResult.getInt("id")), starResult.getString("description"), starResult.getString("sender_email"), starResult.getString("receiver_email"));
                star.setSenderUser(DBController.getInstance().getUser(star.getSender()));
                star.setReceiverUser(DBController.getInstance().getUser(star.getReceiver()));
                stars.add(star);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return stars;
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