package homework_25.hibernate.entity;

import homework_25.hibernate.entity.Cars;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.nio.file.Path;
import java.util.function.Consumer;

public class MainProgram {

    private static final Configuration CONFIG;

    static {
        CONFIG = new Configuration();
        CONFIG.configure(Path.of("src\\main\\resources\\homework_24-25_files\\hibernate.cfg.xml").toFile());
    }

    public static void main(String[] args) {
        runInsideSession(session -> {
            Query<Cars> searchQuery = session.createQuery("from Cars where mark like :value",Cars.class);
            searchQuery.setParameter("value", "Ford");
            System.out.println("Список автомобилей с маркой Ford...");
            searchQuery.getResultList().forEach(System.out::println);
        });
        System.out.println();
        runInsideSession(session -> {
            Query<Cars> searchQuery = session.createNativeQuery("select * from Cars",Cars.class);
            System.out.println("Список всех автомобилей из БД...");
            searchQuery.getResultList().forEach(System.out::println);
        });

    }

    public static void runInsideSession(Consumer<Session> consumer) {
        try (final Session session = getCurrentSessionFromConfig()) {
            Transaction transaction = session.beginTransaction();
            consumer.accept(session);
            transaction.commit();
        }
    }

    public static Session getCurrentSessionFromConfig() {
        SessionFactory sessionFactory = CONFIG.buildSessionFactory();
        return sessionFactory.getCurrentSession();
    }
}
