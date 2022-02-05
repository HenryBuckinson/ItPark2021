package homework_24.classes;

import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

/**
 * Класс для создания таблицы в БД.
 */
public class DataBaseCreator {

    private DataBaseConnector connector;
    private final Properties dataBaseSettings;

    public DataBaseCreator(DataBaseConnector connector) {
        this.connector = connector;
        this.dataBaseSettings = connector.getDataBaseSettings();
    }


    /**
     * @param tableName - Название таблицы.
     * @param columns   - название столбцов.
     *                  Метод просто создает таблицу исходя из аргументов.
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
}
