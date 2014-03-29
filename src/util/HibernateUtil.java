/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import javax.swing.JOptionPane;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
  
/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author alexandre
 */
public class HibernateUtil {

    private static final SessionFactory sessionFactory;
    
    static {
        try {
            // Create the SessionFactory from standard (hibernate.cfg.xml) 
            // config file.
            Properties prop = new Properties();
            prop.load(new FileReader(new File("properties/hibernate.properties")));
            
            sessionFactory = new AnnotationConfiguration().configure("hibernate.cfg.xml").addProperties(prop).buildSessionFactory();
        } catch (IOException | HibernateException ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
    public static Connection getConnection() throws Exception {  
        try {  
            
            Connection conn;
            conn = DriverManager.getConnection("jdbc:mysql://localhost/acal","root" , "123");
  
            return conn;  
            
        } catch (HibernateException | SQLException e) {  
            
            JOptionPane.showMessageDialog(null, "Erro de conexão ao banco de dados utilizando jdbc");
            throw e;  
        }  
    }  
}
