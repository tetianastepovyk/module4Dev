import dto.MaxProjectsClientDto;
import dto.MaxSalaryWorkerDto;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DatabaseQueryService {
    public static void main(String[] args) {
        System.out.println(findMaxSalaryWorker());
    }

        public static List<MaxSalaryWorkerDto> findMaxSalaryWorker() {
        List<MaxSalaryWorkerDto> maxSalaryWorkerDtoList = new ArrayList<>();

        try (Statement statement = Database.getInstance().getConnection().createStatement()) {
            String sql = Files.readString(Path.of("sql/find_max_salary_worker.sql"));
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                maxSalaryWorkerDtoList.add(MaxSalaryWorkerDto.builder()
                        .name(resultSet.getString("NAME"))
                        .salary(resultSet.getInt("SALARY")).build());
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
        return maxSalaryWorkerDtoList;
    }


}
