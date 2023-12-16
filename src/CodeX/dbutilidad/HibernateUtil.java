package CodeX.dbutilidad;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import java.util.HashMap;
import java.util.Map;

public class HibernateUtil {
   /*
   VERSION 1
   private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            // Crear la SessionFactory desde hibernate.cfg.xml
            return new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Falló la creación de la SessionFactory inicial." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    FIN VERSION 1
    */

    /*
    VERSION 2

    private static StandardServiceRegistry standardServiceRegistry;
    private  static  SessionFactory sessionFactory;

    static {
        try{
            if(sessionFactory==null){

                StandardServiceRegistryBuilder standardServiceRegistryBuilder = new StandardServiceRegistryBuilder();

                Map<String, String> databaseConfiguration = new HashMap<>();

                databaseConfiguration.put(Environment.URL,"jdbc:mysql://localhost:3306/dbonlineshop");
                databaseConfiguration.put(Environment.USER, "root");
                databaseConfiguration.put(Environment.PASS,"0618jm01");
                databaseConfiguration.put(Environment.DRIVER,"com.mysql.cj.jdbc.Driver");
                //databaseConfiguration.put(Environment.DIALECT,"org.hibernate.dialect.MySQL57Dialect");
                for (Map.Entry<String, String> entry : databaseConfiguration.entrySet()) {
                    standardServiceRegistryBuilder.applySetting(entry.getKey(), entry.getValue());
                }
                StandardServiceRegistry standardServiceRegistry = standardServiceRegistryBuilder.build();
                MetadataSources metadataSources = new MetadataSources(standardServiceRegistry);
                Metadata metadata = metadataSources.getMetadataBuilder().build();
                SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();

            }
        }catch (Exception e){
            if(standardServiceRegistry!=null){
                StandardServiceRegistryBuilder.destroy(standardServiceRegistry);
            }
        }
    }
    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }
    FIN VERSION 2
     */
    private static StandardServiceRegistry standardServiceRegistry;
    private  static  SessionFactory sessionFactory;

    static {
        try {
            StandardServiceRegistry standardServiceRegistry = new StandardServiceRegistryBuilder()
                    .configure("hibernate.cfg.xml") // o la ubicación de tu archivo de configuración
                    .build();
            Metadata metadata = new MetadataSources(standardServiceRegistry)
                    .getMetadataBuilder()
                    .build();
            sessionFactory = metadata.getSessionFactoryBuilder().build();
        } catch (Exception e) {
            e.printStackTrace(); // Maneja el error adecuadamente en tu aplicación
        }
    }
    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }


}

