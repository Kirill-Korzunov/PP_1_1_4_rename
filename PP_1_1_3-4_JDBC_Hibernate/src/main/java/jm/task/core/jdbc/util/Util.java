package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;


public class Util {

    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String HOSTNAME = "jdbc:mysql://localhost:3306/mydatabase?useSSL=false&serverTimezone=UTC";
    private static final String DIALECT = "org.hibernate.dialect.MySQL5Dialect";
    private static final String USERNAME = "user";
    private static final String PASSWORD = "user";
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                    .applySetting("hibernate.connection.driver_class", DRIVER)
                    .applySetting("hibernate.connection.url", HOSTNAME)
                    .applySetting("hibernate.connection.username", USERNAME)
                    .applySetting("hibernate.connection.password", PASSWORD)
                    .applySetting("hibernate.dialect", DIALECT)
                    .applySetting("hibernate.show_sql", "true")
                    .applySetting("hibernate.hbm2ddl.auto", "update")
                    .build();

            MetadataSources metadataSources = new MetadataSources(registry);
            metadataSources.addAnnotatedClass(User.class);

            Metadata metadata = metadataSources.getMetadataBuilder().build();
            sessionFactory = metadata.getSessionFactoryBuilder().build();
        }
        return sessionFactory;
    }
}
