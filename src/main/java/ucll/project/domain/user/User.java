package ucll.project.domain.user;

import javax.xml.bind.DatatypeConverter;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.apache.poi.poifs.crypt.HashAlgorithm.sha512;

public class User {
    private String email, firstName, lastname, password;
    private boolean superUser,manager,admin;
    //comment
    // hashed password1
    private transient String hashedPassword;

    public User() {
    }

    public User(String email, String firstName, String lastName, String password, boolean superUser) {
        setFirstName(firstName);
        setEmail(email);
        setLastname(lastName);
        setNewPassword(password);;
        setSuperUser(superUser);
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public boolean isCorrectPassword(String password) {
        if(password.isEmpty()){
            throw new IllegalArgumentException("No password given");
        }
        String[] p = this.password.split("::");
        String salt = p[0];
        return this.password.equals(sha512(password, salt));
    }

    public void setPassword(String password) {
        if(password.isEmpty()){
            throw new IllegalArgumentException("No password given");
        }
        this.password = password;
    }

    public void setNewPassword(String password) {
        if (password.isEmpty()) {
            throw new IllegalArgumentException("No password given");
        }
        this.password = sha512(password, salt());
    }

    private static String sha512(String password, String salt) {
        try {
            MessageDigest crypt = MessageDigest.getInstance("SHA-512");
            crypt.reset();
            password += salt;
            byte[] passwordBytes = password.getBytes(StandardCharsets.UTF_8);
            crypt.update(passwordBytes);
            byte[] digest = crypt.digest();
            String p = new BigInteger(1, digest).toString(16);
            return salt + "::" + p;
        }
        catch (NoSuchAlgorithmException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    private static String salt() {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 16;
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int)
                    (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        return buffer.toString();
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

    public boolean getSuperUser() {
        return superUser;
    }

    public boolean isManager() {
        return manager;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setSuperUser(boolean superUser) {
        this.superUser = superUser;
    }

    public String getPassword() {
        return password;
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

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public void setManager(boolean manager) {
        this.manager = manager;
    }
}
