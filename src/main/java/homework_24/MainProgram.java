package homework_24;

import homework_24.classes.DataBaseConnector;
import homework_24.classes.DataBaseCreator;
import homework_24.classes.DataBaseFilter;
import homework_24.classes.DataBaseInserter;
import lombok.SneakyThrows;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MainProgram {

    @SneakyThrows
    public static void main(String[] args) {

        convertFromCsvToSql("Cars", "id", "Mark", "Model", "Year");

        DataBaseConnector connector = new DataBaseConnector();  //Объект для установления соединения
        DataBaseCreator creator = new DataBaseCreator(connector);  //Объект для создания тааблицы
        DataBaseInserter inserter = new DataBaseInserter(connector);   //Объект для вставки данных в БД
        DataBaseFilter filter = new DataBaseFilter(connector); //Объект для фильтрации данных в БД

        creator.createTable("Cars", "id", "Mark", "Model", "Year");
        inserter.insertValuesFromSqlFile(Path.of("src\\main\\resources\\homework_24-25_files\\result_file.sql"));
        filter.showMarks("Mazda");
        filter.showMarks("Ford");
        filter.showModels("Accord");


    }

    /**
     * @param tableName - Задаётся имя таблицы.
     * @param column    - Задаются названия колонок.
     *                  Метод конвертирует файл из формата csv. в формат sql.
     */
    @SneakyThrows
    public static void convertFromCsvToSql(String tableName, String... column) {
        String columnLines = columnConstructor(column);
        try (BufferedReader input = new BufferedReader(new FileReader(Paths.get("src\\main\\resources\\homework_24-25_files\\file.csv").toFile()));
             Writer output = new BufferedWriter(new FileWriter(Paths.get("src\\main\\resources\\homework_24-25_files\\result_file.sql").toFile()))) {
            String line;
            String[] st;
            while ((line = input.readLine()) != null) {
                st = line.replace("\"", "").split(",");

                output.write("INSERT INTO " + tableName + " "
                        + columnLines
                        + wrappingRowValues(st)
                        + ";\n");
            }
        }
    }

    private static String wrappingRowValues(String[] column) {
        StringBuilder wrappingRows = new StringBuilder();
        wrappingRows.append("(");
        for (int i = 0; i < column.length; i++) {
            wrappingRows.append("'").append(column[i]).append("'").append(", ");
            if (i == column.length - 1) {
                wrappingRows.deleteCharAt(wrappingRows.length() - 1);
                wrappingRows.deleteCharAt(wrappingRows.length() - 1);
            }
        }
        wrappingRows.append(")");
        return wrappingRows.toString();
    }

    private static String columnConstructor(String[] column) {
        StringBuilder columnLines = new StringBuilder();
        columnLines.append("(");
        for (int i = 0; i < column.length; i++) {
            columnLines.append("").append(column[i]).append(",").append(" ");
            if (i == column.length - 1) {
                columnLines.deleteCharAt(columnLines.length() - 1);
                columnLines.deleteCharAt(columnLines.length() - 1);
            }
        }
        columnLines.append(") VALUES");
        return columnLines.toString();
    }
}
