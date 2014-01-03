package de.fhdw.ify208.ticketmaster.dataaccess;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.*;
import java.util.Properties;

/**
 * @author ankariu
 */

public class JPATest {

    public static void main(String[] args) {

        try {
            testJpa();
        } catch (Exception e) {
            e.getMessage();
        }

    }

    public static void testJpa() {

        try {
            System.out.println("Setting props");

            // Use persistence.xml configuration
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("ticketmaster.dataaccess");
            // Retrieve an application managed entity manager
            EntityManager em = emf.createEntityManager();
            System.out.println("transaction begin");
            em.getTransaction().begin();

            System.out.println("setting usertype");
            Usertype ut = new Usertype();
            ut.setDescription("Test für JPA");
            ut.setDisplayname("JPA");

//		System.out.println("Persist");
//		em.persist(ut);
//		em.find(Usertype.class, 1);

            System.out.println("Commit");
            em.getTransaction().commit();

            em.close();
            emf.close();
            System.out.println("Closed");

        } catch (Exception e) {
            System.out.println("Fehlerchen!");
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Finally");
        }

    }

    public static void testJdbc() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Couldn't find the driver!");
            System.out.println("Let's print a stack trace, and exit.");
            cnfe.printStackTrace();
            System.exit(1);
        }
        String url = "jdbc:postgresql://localhost:5432/postgres";
        Properties props = new Properties();
        props.setProperty("user", "postgres");
        props.setProperty("password", "");
        Connection conn = null;
        try {

            conn = DriverManager.getConnection(url, props);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from t_usertype");
            while (rs.next()) {
                long id = rs.getLong(1);
                System.out.println("ID:" + id);
            }
            System.out.println(rs.getFetchSize());
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
