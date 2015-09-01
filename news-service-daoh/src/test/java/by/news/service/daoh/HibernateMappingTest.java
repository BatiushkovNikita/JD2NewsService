package by.news.service.daoh;


import org.junit.Test;
import org.unitils.UnitilsJUnit4;
import org.unitils.orm.jpa.JpaUnitils;
import org.unitils.orm.jpa.annotation.JpaEntityManagerFactory;

@JpaEntityManagerFactory(persistenceUnit = "test2", configFile = "META-INF/persistence-test2.xml")
public class HibernateMappingTest extends UnitilsJUnit4 {

    @Test
    public void testMappingToDatabase() {
        JpaUnitils.assertMappingWithDatabaseConsistent();
    }
}
