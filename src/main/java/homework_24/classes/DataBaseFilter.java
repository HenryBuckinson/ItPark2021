package homework_24.classes;

import homework_24.interfaces.Cars;
import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

/**
 * Класс для фильтрации данных в БД.
 */
public class DataBaseFilter implements Cars {
    private DataBaseConnector connector;
    private final Properties dataBaseSettings;

    public DataBaseFilter(DataBaseConnector connector) {
        this.connector = connector;
        this.dataBaseSettings = connector.getDataBaseSettings();
    }

    @Override
    @SneakyThrows
    public void showModels(String model) {
        System.out.println("Поиск автомобилей с моделью " + model + "...");
        try (final Connection connection = DriverManager.getConnection(
                dataBaseSettings.getProperty("jdbc.url"),
                dataBaseSettings.getProperty("db.login"),
                dataBaseSettings.getProperty("db.password"));
             final PreparedStatement statement = connection.prepareStatement(
                     """
                             select id, Mark, Year\s
                             from Cars
                             where Model= ?
                             """)
        ) {
            statement.setString(1, model);
            final ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                System.out.printf("id: %s Mark: %s Year: %s\n",
                        resultSet.getString("id"),
                        resultSet.getString("Mark"),
                        resultSet.getString("Year"));
            }
        }
    }

    @Override
    @SneakyThrows
    public void showMarks(String mark) {
        System.out.println("Поиск автомобилей с маркой " + mark + "...");
        try (final Connection connection = DriverManager.getConnection(
                dataBaseSettings.getProperty("jdbc.url"),
                dataBaseSettings.getProperty("db.login"),
                dataBaseSettings.getProperty("db.password"));
             final PreparedStatement statement = connection.prepareStatement(
                     """
                             select id, Model, Year\s
                             from Cars
                             where Mark= ?
                             """)
        ) {
            statement.setString(1, mark);
            final ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                System.out.printf("id: %s Model: %s Year: %s\n",
                        resultSet.getString("id"),
                        resultSet.getString("Model"),
                        resultSet.getString("Year"));
            }
        }
    }
}
