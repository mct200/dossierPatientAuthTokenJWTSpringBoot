package sn.groupeisi.dp.config;



import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import sn.groupeisi.dp.domain.Antecedent;
import sn.groupeisi.dp.domain.Dossier;
import sn.groupeisi.dp.domain.Ordonnance;
import sn.groupeisi.dp.domain.Patient;
import sn.groupeisi.dp.domain.Prescripteur;
import sn.groupeisi.dp.domain.Rdv;
import sn.groupeisi.dp.domain.Role;
import sn.groupeisi.dp.domain.Secretaire;
import sn.groupeisi.dp.domain.Traitant;
import sn.groupeisi.dp.domain.User;

import java.util.Properties;

public class HibernateUtil {
    private static SessionFactory sessionFactory;
    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();

                Properties settings = new Properties();
                settings.put(Environment.DRIVER,
                        "com.mysql.jdbc.Driver");
                settings.put(Environment.URL, "jdbc:mysql://localhost:3306/gestionpatient?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDateti meCode=false&serverTimezone=UTC");
                        settings.put(Environment.USER, "root");
                settings.put(Environment.PASS, "");
                settings.put(Environment.DIALECT,
                        "org.hibernate.dialect.MySQL5Dialect");
                //cette ligne est très importante
                settings.put(Environment.HBM2DDL_AUTO,
                        "update");
                settings.put(Environment.SHOW_SQL, "true");
                settings.put(Environment.FORMAT_SQL, "true");
                settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS,
                        "thread");
                configuration.setProperties(settings);
                configuration.addAnnotatedClass(Antecedent.class);
                configuration.addAnnotatedClass(Patient.class);
                configuration.addAnnotatedClass(User.class);
                configuration.addAnnotatedClass(Dossier.class);
                configuration.addAnnotatedClass(Ordonnance.class);
                configuration.addAnnotatedClass(Prescripteur.class);
                configuration.addAnnotatedClass(Rdv.class);
                configuration.addAnnotatedClass(Role.class); 
                configuration.addAnnotatedClass(Traitant.class);
                configuration.addAnnotatedClass(Secretaire.class);
                
                ServiceRegistry serviceRegistry = new
                        StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties()).build();
                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
                return sessionFactory;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }
}

