package ucll.project.domain.user;

import javax.xml.bind.DatatypeConverter;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class User {
    private String email, firstName, lastname, password;
    private boolean is_superuser;

    // hashed password1
    private transient String hashedPassword;

    public User() {
    }

    public User(String email, String firstName, String lastName, String password, boolean is_superuser) {
        setFirstName(firstName);
        setEmail(email);
        setLastname(lastName);
        setHashedPassword(getPasswordToHashedPassword(password));
        setIs_superuser(is_superuser);
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void hashAndSetPassword(String password) {
        if (password.length() < 4) {
            throw new IllegalArgumentException("Too short password!");
        }
        String hashed = getPasswordToHashedPassword(password);
        setHashedPassword(hashed);
    }

    // This function will hash the password
    protected String getPasswordToHashedPassword(String password) {
        MessageDigest digest = null;
        try {
            digest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException();
        }
        digest.update(password.getBytes(StandardCharsets.UTF_8));
        String hash = DatatypeConverter.printHexBinary(digest.digest()).toUpperCase();
        return hash;
    }

    public boolean isValidPassword(String password) {
        if (getHashedPassword() == null) {
            return false;
        }
        return getPasswordToHashedPassword(password).equals(getHashedPassword());
    }

    // Getters and setters and toString

    public String getFirstName() {
        return this.firstName;
    }


    public String getEmail() {
        return this.email;
    }

    public String getHashedPassword() {
        return this.hashedPassword;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public boolean isIs_superuser() {
        return is_superuser;
    }

    public void setIs_superuser(boolean is_superuser) {
        this.is_superuser = is_superuser;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        Pattern pattern = Pattern.compile("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}");
        Matcher mat = pattern.matcher(email);
        if (email.trim().isEmpty() || !mat.matches()) throw new IllegalArgumentException("invalid email");
        this.email = email;
    }

    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }

    public String toString() {
        return "User(firstName=" + this.getFirstName() + ", lastName=" + this.getLastname() + ", email=" + this.getEmail() + ", hashedPassword=" + this.getHashedPassword() + ")";
    }
}
