import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.Statement;

public class DatabasePopulateService {
    public static void main(String[] args) {
        Connection conn = Database.getInstance().getConnection();

        try (Statement statement = conn.createStatement()){
            String sql = Files.readString(Path.of("sql/populate_db.sql"));
            statement.executeUpdate(sql);
        }catch (Exception e) {
            e.printStackTrace();
        }

    }
}
