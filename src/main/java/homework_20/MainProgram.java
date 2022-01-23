package homework_20;

import homework_20.classes.Department;
import homework_20.classes.Employee;
import homework_20.classes.EmployeeWrapper;
import homework_20.classes.Position;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import lombok.SneakyThrows;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import java.io.FileInputStream;
import java.io.StringWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
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


        EmployeeWrapper list = new EmployeeWrapper();
        list.setEmployee(Arrays.asList(obj, obj1, obj2, obj3, obj4));
        writeToXML(list);

        listOfSalaryHigherThanAVG(Paths.get("src\\main\\java\\homework_20\\files\\text.xml"));


    }

    @SneakyThrows
    private static void listOfSalaryHigherThanAVG(Path path) {
        System.out.print("Работники у которых зарплата выше средней: ");
        Path path1 = Paths.get(String.valueOf(path));
        try (FileInputStream fileIS = new FileInputStream(path1.toFile())) {
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            Document xmlDocument = builder.parse(fileIS);
            XPath xPath = XPathFactory.newInstance().newXPath();
            String avgSalary = "sum(/employeeWrapper/employee/position/salary) div count(/employeeWrapper/employee/position/salary)";
            NodeList evaluate = (NodeList) xPath.compile("/employeeWrapper/employee[*]/position/salary[text() > " + avgSalary + "]/ancestor::employee/attribute::name").evaluate(xmlDocument, XPathConstants.NODESET);
            List<String> resultList = new ArrayList<>();
            for (int i = 0; i < evaluate.getLength(); i++) {
                resultList.add(evaluate.item(i).getNodeValue());
            }
            System.out.println(resultList);
        }
    }

    @SneakyThrows
    private static void showObjectInXML(Employee obj) {
        StringWriter strWrt = new StringWriter();
        JAXBContext jaxbContext = JAXBContext.newInstance(Employee.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(obj, strWrt);
        System.out.println(strWrt);
    }

    @SneakyThrows
    private static void writeToXML(Employee obj) {
        JAXBContext jaxbContext = JAXBContext.newInstance(Employee.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        Path path = Paths.get("G:\\Program Files\\IDEA_Projects\\homework-1\\src\\main\\java\\homework_20\\files\\text.xml");
        marshaller.marshal(obj, path.toFile());
        System.out.println("Объект добавлен в XML-файл.");
    }

    @SneakyThrows
    private static void writeToXML(EmployeeWrapper obj) {
        JAXBContext jaxbContext = JAXBContext.newInstance(EmployeeWrapper.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        Path path = Paths.get("G:\\Program Files\\IDEA_Projects\\homework-1\\src\\main\\java\\homework_20\\files\\text.xml");
        marshaller.marshal(obj, path.toFile());
        System.out.println("Объект добавлен в XML-файл.");
    }
}

