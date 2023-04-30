import java.sql.Connection;
import java.sql.DriverManager;

public class Database {
    private static final Database DATABASE = new Database();
    private Connection connection;

    private Database(){
        try {
            String connectionUrl = "jdbc:h2:./module4";//jdbc:h2:\Users\Tanya\project1\module4JavaDev\module4
            connection = DriverManager.getConnection(connectionUrl);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public static Database getInstance(){
        return DATABASE;
    }

    public Connection getConnection(){
        return connection;
    }

    public  void close(){
        try {
            connection.close();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
