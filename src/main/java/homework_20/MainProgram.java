package homework_20;

import homework_20.classes.Department;
import homework_20.classes.Employee;
import homework_20.classes.EmployeeList;
import homework_20.classes.Position;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import lombok.SneakyThrows;
import org.json.XML;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import java.io.FileInputStream;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainProgram {
    @SneakyThrows
    public static void main(String[] args) {
        System.out.println();
        Employee obj = new Employee(1234, "mattMess", "Matt", "Messenger",
                new Department("Human Resources", "New York"),
                new Position("KPI Dashboards", 20000));
        Employee obj1 = new Employee(5678, "angelLean", "Angelique", "Leander",
                new Department("Engineering", "Leiria"),
                new Position("Participant Observation", 30000));
        Employee obj2 = new Employee(9101, "vanNor", "Vanny", "Norvel",
                new Department("Services", "Bcharré"),
                new Position("TBS", 40000));
        Employee obj3 = new Employee(1213, "andMac", "Anders", "Maciocia",
                new Department("Accounting", "Hegarmanah"),
                new Position("GCCS", 50000));
        Employee obj4 = new Employee(1415, "fredThe", "Fredric", "Theobald",
                new Department("Business Development", "Cikalang"),
                new Position("Kinetics", 60000));


        EmployeeList list = new EmployeeList();
        EmployeeList oneEmployee = new EmployeeList();
        list.setEmployee(Arrays.asList(obj, obj1, obj2, obj3, obj4));//Список из всех работников
        oneEmployee.setEmployee(List.of(obj));//Список из одного работника

        writeToXML(list, "listOfEmployee.xml");//файл сформируется в папке resources
        writeToXML(oneEmployee, "theFirstEmployee.xml");//файл сформируется в папке resources

        listOfSalaryHigherThanAVG("listOfEmployee.xml");

        convertFromXmlToJson("listOfEmployee.xml");
        convertFromXmlToJson("theFirstEmployee.xml");

//        showObjectInXML(list);
    }

    @SneakyThrows
    private static void listOfSalaryHigherThanAVG(String fileName) {
        Path path = Path.of("G:\\Program Files\\IDEA_Projects\\homework-1\\src\\main\\resources\\homework_20_result\\" + fileName);
        Path pathRes = Paths.get(String.valueOf(path));
        try (FileInputStream fileIS = new FileInputStream(pathRes.toFile())) {
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            Document xmlDocument = builder.parse(fileIS);
            XPath xPath = XPathFactory.newInstance().newXPath();
            String avgSalary = "sum(/employeeList/employee/position/salary) div count(/employeeList/employee/position/salary)";
            NodeList evaluate = (NodeList) xPath.compile("/employeeList/employee[*]/position/salary[text() > " + avgSalary + "]/ancestor::employee/attribute::name").evaluate(xmlDocument, XPathConstants.NODESET);
            List<String> resultList = new ArrayList<>();
            for (int i = 0; i < evaluate.getLength(); i++) {
                resultList.add(evaluate.item(i).getNodeValue());
            }
            System.out.print("Работники у которых зарплата выше средней: ");
            System.out.println(resultList);
        }
    }

    @SneakyThrows
    private static void showObjectInXML(EmployeeList obj) {
        StringWriter strWrt = new StringWriter();
        JAXBContext jaxbContext = JAXBContext.newInstance(EmployeeList.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(obj, strWrt);
        System.out.println(strWrt);
    }

    /**
     * @param obj      - объект класса EmployeeList.
     * @param fileName - имя файла, которое далее сформируется в директории resources.
     */
    @SneakyThrows
    private static void writeToXML(EmployeeList obj, String fileName) {
        JAXBContext jaxbContext = JAXBContext.newInstance(EmployeeList.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        String filePath = "G:\\Program Files\\IDEA_Projects\\homework-1\\src\\main\\resources\\homework_20_result\\" + fileName;
        Path path = Paths.get(filePath);
        marshaller.marshal(obj, path.toFile());
        System.out.println("XML-файл \"" + fileName + "\" создан.");
    }

    @SneakyThrows
    private static void convertFromXmlToJson(String fileName) {
        String filePath = "G:\\Program Files\\IDEA_Projects\\homework-1\\src\\main\\resources\\homework_20_result\\" + fileName;
        Path path = Paths.get(filePath);
        String json = XML.toJSONObject(String.join("", Files.readAllLines(path))).toString();
        String substring = fileName.substring(0, fileName.length() - 4);
        Path jsonPath = Path.of("G:\\Program Files\\IDEA_Projects\\homework-1\\src\\main\\resources\\homework_20_result\\json_documents\\" + substring + ".json");
        Files.writeString(jsonPath, json, StandardOpenOption.CREATE, StandardOpenOption.WRITE);
    }

}

