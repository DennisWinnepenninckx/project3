package ucll.project.db;
import ucll.project.domain.user.InvalidLogin;
import ucll.project.domain.user.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepositoryDb implements UserRepository {

    @Override
    public void createUser(User user) {
        try (Connection conn = ConnectionPool.getConnection();
             PreparedStatement stmt = conn.prepareStatement("INSERT INTO \"user\" " +
                     "(email, firstname, lastname, password, superuser, admin, manager, profilepic) VALUES (?, ?, ?, ?,?,?,?,?)",
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

    @Override
    public User loginUser(String email, String password) throws InvalidLogin {
        //just in case
        if(email==null || email.isEmpty()){
            if(password==null || password.isEmpty()){
                throw new InvalidLogin("No email nor password given");
            }
            throw new InvalidLogin("No email given");
        }
        if(password==null || password.isEmpty()){
            throw new InvalidLogin("No password given");
        }

        try (Connection conn = ConnectionPool.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM \"user\" WHERE email = ?"))
        {
            stmt.setString(1, email);
            try (ResultSet rs = stmt.executeQuery()) {
                if (!rs.next()) {
                    throw new InvalidLogin("Incorrect credentials");
                }

                User user = userFromResult(rs);
                if (!user.isCorrectPassword(password)) {
                    throw new InvalidLogin("Incorrect credentials");
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
    public void resetPassword(User user) {
        try (Connection conn = ConnectionPool.getConnection();
             PreparedStatement stmt = conn.prepareStatement("UPDATE \"user\" SET " +
                     "password = ? " +
                     "WHERE email = ? "))
        {
            stmt.setString(1, user.getHashedPassword());
            stmt.setString(2,user.getEmail());
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
    @Override
    public void deleteUsingEmail(String email){
        try (Connection conn = ConnectionPool.getConnection();
             PreparedStatement stmt = conn.prepareStatement("DELETE FROM \"user\" WHERE email = ?"))
        {
            stmt.setString(1, email);
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
        user.setSuperUser(rs.getBoolean("superuser"));
        user.setAdmin(rs.getBoolean("admin"));
        user.setManager(rs.getBoolean("manager"));
        user.setProfilepic(rs.getString("profilepic"));
        return user;
    }

    public void updatePic(User user) {
        try (Connection conn = ConnectionPool.getConnection();
             PreparedStatement stmt = conn.prepareStatement("update \"user\" SET profilepic = ? where email = ?",
                     Statement.RETURN_GENERATED_KEYS))
        {
            stmt.setString(1, user.getProfilepic());
            stmt.setString(2, user.getEmail());
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

    private static int stmtSetUser(PreparedStatement stmt, int i, User user) throws SQLException {
        stmt.setString(i++, user.getEmail());
        stmt.setString(i++, user.getFirstName());
        stmt.setString(i++, user.getLastname());
        stmt.setString(i++, user.getHashedPassword());
        stmt.setBoolean(i++, user.getSuperUser());
        stmt.setBoolean(i++, user.isAdmin());
        stmt.setBoolean(i++, user.isManager());
        stmt.setString(i++, user.getProfilepic());
        return i;
    }
}