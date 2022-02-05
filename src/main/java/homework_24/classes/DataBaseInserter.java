package homework_24.classes;

import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

/**
 * Класс для вставки данных в БД из сторонних SQL-файлов.
 */
public class DataBaseInserter {
    private DataBaseConnector connecter;
    private final Properties dataBaseSettings;

    public DataBaseInserter(DataBaseConnector connector) {
        this.connecter = connector;
        this.dataBaseSettings = connector.getDataBaseSettings();
    }

    /**
     * @param path - Путь до sql-файла.
     *             Метод переносит данные из файла в таблицу.
     */
    @SneakyThrows
    public void insertValuesFromSqlFile(Path path) {
        try (final Connection connection = DriverManager.getConnection(
                dataBaseSettings.getProperty("jdbc.url"),
                dataBaseSettings.getProperty("db.login"),
                dataBaseSettings.getProperty("db.password"));

             final Statement statement = connection.createStatement();

        ) {
            File file = path.toFile();
            ArrayList<String> stringValues = new ArrayList<>();
            try (BufferedReader input = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = input.readLine()) != null) {
                    stringValues.add(line);
                }
            }
            for (String line : stringValues) {
                statement.addBatch(line);
            }
            statement.executeBatch();
        }
    }
}
