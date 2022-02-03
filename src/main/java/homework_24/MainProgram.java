package homework_24;

import homework_24.classes.DataBaseLoader;
import lombok.SneakyThrows;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MainProgram {

    @SneakyThrows
    public static void main(String[] args) {
        convertFromCsvToSql("Cars", "id", "Mark", "Model", "Year");
        DataBaseLoader tableCars = new DataBaseLoader();
        tableCars.createTable("Cars", "id", "Mark", "Model", "Year");
        tableCars.insertValuesFromSqlFile(Path.of("G:\\Program Files\\IDEA_Projects\\homework-1\\src\\main\\resources\\homework_24_files\\result_file.sql"));
        tableCars.showMarks("Mazda");
        tableCars.showMarks("Ford");
        tableCars.showModels("Accord");
    }

    /**
     * @param tableName - Задаётся имя таблицы.
     * @param column    - Задаются названия колонок.
     *                  Метод конвертирует файл из формата csv. в формат sql.
     */
    @SneakyThrows
    public static void convertFromCsvToSql(String tableName, String... column) {
        String columnLines = columnConstructor(column);
        try (BufferedReader input = new BufferedReader(new FileReader(Paths.get("G:\\Program Files\\IDEA_Projects\\homework-1\\src\\main\\resources\\homework_24_files\\file.csv").toFile()));
             Writer output = new BufferedWriter(new FileWriter(Paths.get("G:\\Program Files\\IDEA_Projects\\homework-1\\src\\main\\resources\\homework_24_files\\result_file.sql").toFile()))) {
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
            wrappingRows.append("'" + column[i] + "'").append(", ");
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
            columnLines.append("" + column[i] + ",").append(" ");
            if (i == column.length - 1) {
                columnLines.deleteCharAt(columnLines.length() - 1);
                columnLines.deleteCharAt(columnLines.length() - 1);
            }
        }
        columnLines.append(") VALUES");
        return columnLines.toString();
    }
}
