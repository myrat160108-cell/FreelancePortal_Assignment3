import java.sql.*;

public class Main {
    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USER = "postgres";
    private static final String PASSWORD = "1234";

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            System.out.println("Успешное подключение!");
            Statement statement = connection.createStatement();


            statement.executeUpdate("INSERT INTO Freelancer (name, skill, experience_years) VALUES ('Murat', 'Java Developer', 1)");

            
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Freelancer");
            while (resultSet.next()) {
                System.out.println("Freelancer name: " + resultSet.getString("name"));
            }

        } catch (SQLException e) {
            System.out.println("Ошибка подключения:");
            e.printStackTrace();
        }
    }
}