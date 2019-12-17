package ucll.project.domain.star;

import ucll.project.db.ConnectionPool;

import java.sql.*;

public class StarDB {
    public void createStar(Star star) {
        try (Connection conn = ConnectionPool.getConnection();
             PreparedStatement stmt = conn.prepareStatement("INSERT INTO \"star\" " +
                             "(id, description, sender, receiver) VALUES (?, ?, ?, ?)",
                     Statement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, star.getId());
            stmt.setString(2, star.getDescription());
            stmt.setString(3, star.getSender());
            stmt.setString(4, star.getReceiver());
            if (stmt.executeUpdate() == 0) {
                throw new RuntimeException("Failed to create star");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
