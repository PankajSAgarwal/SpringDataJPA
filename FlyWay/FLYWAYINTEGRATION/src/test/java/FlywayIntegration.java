import org.apache.log4j.Logger;
import org.flywaydb.core.Flyway;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FlywayIntegration {
    Logger log = Logger.getLogger(this.getClass().getName());

    private EntityManagerFactory emf;

    @Before
    public void init() {
        emf = Persistence.createEntityManagerFactory("my-persistence-unit");
        migrateDatabase();
    }

    @After
    public void close() {
        emf.close();
    }

    private void migrateDatabase() {
        Flyway flyway = Flyway.configure()
                .dataSource("jdbc:postgresql://localhost:5432/test-flyway", "postgres", "postgres")
                .load();
        flyway.migrate();
    }

    @Test
    public void testMigration() {
        log.info("...testMigration...");

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        em.getTransaction().commit();
        em.close();
    }
}
