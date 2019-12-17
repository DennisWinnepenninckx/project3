package ucll.project.domain.star;

import ucll.project.db.ConnectionPool;

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
                stmt2.setString(1, tag);
                stmt2.setInt(2, star.getId());
                stmt2.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Star> getAll() {
        List<Star> stars = new ArrayList<>();

        try (Connection conn = ConnectionPool.getConnection();
             PreparedStatement stmt2 = conn.prepareStatement("SELECT * FROM star", Statement.RETURN_GENERATED_KEYS)) {

            ResultSet starResult = stmt2.executeQuery();

            while (starResult.next()) {
                Star star = new Star(starResult.getInt("id"), getTagsOfStar(starResult.getInt("id")), starResult.getString("description"), starResult.getString("sender_email"), starResult.getString("receiver_email"));
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