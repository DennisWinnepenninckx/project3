package ucll.project.domain.user;
import ucll.project.db.ConnectionPool;
import ucll.project.domain.star.Star;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepositoryDb implements UserRepository {

    @Override
    public void createUser(User user) {
        try (Connection conn = ConnectionPool.getConnection();
             PreparedStatement stmt = conn.prepareStatement("INSERT INTO \"user\" " +
                     "(email, firstname, lastname, password) VALUES (?, ?, ?, ?)",
                     Statement.RETURN_GENERATED_KEYS))
        {
            stmtSetUser(stmt, 1, user);
            if (stmt.executeUpdate() == 0) {
                throw new RuntimeException("Failed to create user");
            }

            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                generatedKeys.next();
                user.setEmail(generatedKeys.getString(1));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public User get(String email) {
        try (Connection conn = ConnectionPool.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM \"user\" WHERE email = ?"))
        {
            stmt.setString(1, email);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return userFromResult(rs);
                }
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<User> getAll() {
        try (Connection conn = ConnectionPool.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM \"user\""))
        {
            List<User> users = new ArrayList<>();
            while (rs.next()) {
                users.add(userFromResult(rs));
            }
            return users;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Star> getStars() {
        try (Connection conn = ConnectionPool.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM \"star\""))
        {
            List<Star> stars = new ArrayList<>();
            while (rs.next()) {
                //users.add(userFromResult(rs));
                stars.add(starFromResult(rs));
            }

            System.out.println(stars);
            return stars;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public User loginUser(String username, String password) throws InvalidLogin {
        if(username==null || username.isEmpty()){
            throw new InvalidLogin("No userid given");
        }
        if(password==null || password.isEmpty()){
            throw new InvalidLogin("No password given");
        }
        try (Connection conn = ConnectionPool.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM \"user\" WHERE username = ?"))
        {
            stmt.setString(1, username);
            try (ResultSet rs = stmt.executeQuery()) {
                if (!rs.next()) {
                    throw new InvalidLogin("Invalid username");
                }

                User user = userFromResult(rs);
                if (!user.isValidPassword(password)) {
                    throw new InvalidLogin("Invalid password");
                }

                return user;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(User user) {
        try (Connection conn = ConnectionPool.getConnection();
             PreparedStatement stmt = conn.prepareStatement("UPDATE \"user\" SET " +
                     "firstname = ?, lastname = ?, email = ?, password = ? " +
                     "WHERE email = ? "))
        {
            int i = stmtSetUser(stmt, 1, user);
            stmt.setString(i, user.getEmail());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(User user) {
        try (Connection conn = ConnectionPool.getConnection();
             PreparedStatement stmt = conn.prepareStatement("DELETE FROM \"user\" WHERE email = ?"))
        {
            stmt.setString(1, user.getEmail());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static User userFromResult(ResultSet rs) throws SQLException {
        User user = new User();
        user.setFirstName(rs.getString("firstname"));
        user.setLastname(rs.getString("lastname"));
        user.setEmail(rs.getString("email"));
        user.setHashedPassword(rs.getString("password"));
        user.setIs_superuser(rs.getString("superuser").equals("true"));
        return user;
    }

    private static Star starFromResult(ResultSet rs) throws SQLException {
        Star star = new Star();
        star.setId(rs.getInt("id"));
        star.setDescription(rs.getString("description"));
        star.setDescription(rs.getString("sender_email"));
        star.setDescription(rs.getString("receiver_email"));
        return star;
    }

    private static int stmtSetUser(PreparedStatement stmt, int i, User user) throws SQLException {
        stmt.setString(i++, user.getEmail());
        stmt.setString(i++, user.getFirstName());
        stmt.setString(i++, user.getLastname());
        stmt.setString(i++, user.getHashedPassword());
        return i;
    }
}