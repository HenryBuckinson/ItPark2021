package homework_24.classes;

import homework_24.interfaces.Cars;
import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

public class DataBaseLoader implements Cars {

    private static Properties dataBaseSettings;

    static {
        try {
            dataBaseSettings = new Properties();
            dataBaseSettings.load(new FileReader(Paths.get("G:\\Program Files\\IDEA_Projects\\homework-1\\src\\main\\resources\\homework_24_files\\db.properties").toFile()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param tableName - Название таблицы.
     * @param columns - название столбцов.
     *                Метод просто создает таблицу исходя из аргументов.
     */
    @SneakyThrows
    public void createTable(String tableName, Object... columns) {

        String readyColumns = setColumns(columns);

        try (final Connection connection = DriverManager.getConnection(
                dataBaseSettings.getProperty("jdbc.url"),
                dataBaseSettings.getProperty("db.login"),
                dataBaseSettings.getProperty("db.password"));

             final PreparedStatement statement = connection.prepareStatement(
                     """
                             create table if not exists""" + " " + tableName + """ 
                             (
                             	""" + readyColumns + """
                             );
                             """)
        ) {
            statement.execute();
        }
    }

    private String setColumns(Object[] columns) {
        StringBuilder setColumns = new StringBuilder();
        for (int i = 0; i < columns.length; i++) {
            setColumns.append(columns[i]).append(" VARCHAR(50),");
            if (i == columns.length - 1) {
                setColumns.deleteCharAt(setColumns.length() - 1);
            }
        }
        return setColumns.toString();
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
                             from `Cars`
                             where `Model`= ?
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
                             from `Cars`
                             where `Mark`= ?
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
