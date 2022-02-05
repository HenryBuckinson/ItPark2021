package homework_24.classes;

import lombok.SneakyThrows;

import java.io.FileReader;
import java.nio.file.Paths;
import java.util.Properties;

/**
 * Класс для установления соединения с БД.
 */
public class DataBaseConnector {

    public Properties getDataBaseSettings() {
        return dataBaseSettings;
    }

    private final Properties dataBaseSettings;

    @SneakyThrows
    public DataBaseConnector() {
        dataBaseSettings = new Properties();
        dataBaseSettings.load(new FileReader(Paths.get("src\\main\\resources\\homework_24-25_files\\db.properties").toFile()));
    }

}
