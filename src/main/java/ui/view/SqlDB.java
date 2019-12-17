/*
public class SqlDB {
} */


package ui.view;

        import domain.model.Person;

        import javax.swing.*;
        import java.sql.Connection;
        import java.sql.DriverManager;
        import java.sql.ResultSet;
        import java.sql.SQLException;
        import java.sql.Statement;
        import java.util.Properties;

public class SqlDB {
    /*
    public static void main(String[] args) throws SQLException {
        String userid1= JOptionPane.showInputDialog("give id");
        String email1=JOptionPane.showInputDialog("give email");
        String pssw1= JOptionPane.showInputDialog("give passwoord");
        String firstname1= JOptionPane.showInputDialog("give voornaam");
        String lastname1= JOptionPane.showInputDialog("give achternaam");

        Properties properties = new Properties();
        String url = "jdbc:postgresql://databanken.ucll.be:51920/2TX35?currentSchema=MaartenPauwelsWeb3";
        properties.setProperty("user", "local_r0713839");
        properties.setProperty("password", "gç;8Shj!ù!H40²S");
        //Secret.setPass(properties);	// implements line 17 and 18
        properties.setProperty("ssl", "true");
        properties.setProperty("sslfactory", "org.postgresql.ssl.NonValidatingFactory");
        properties.setProperty("sslmode","prefer");

        Connection connection = DriverManager.getConnection(url,properties);
        Statement statement = connection.createStatement();

         statement.execute( "INSERT INTO \"MaartenPauwelsWeb3\".person (userid, email, password, \"firstName\", \"lastName\")\n" +
                "VALUES ("+userid1+", '"+email1+"' , '"+pssw1+"', '"+firstname1+"', '"+lastname1+"');" );
        ResultSet result = statement.executeQuery( "SELECT * FROM \"MaartenPauwelsWeb3\".person" );

        while(result.next()){
            String firstname = result.getString("firstName");
            String lastName = result.getString("lastName");
            String id = result.getString("userid");
            String email = result.getString("email");
            String password = result.getString("password");
            try {	// validation of data stored in database
                Person person = new Person(id, email, password, firstname, lastName);
                System.out.println(person.toString());
            }
            catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        statement.close();
        connection.close();
    }

     */
}