package by.news.service.dao.impl;

import java.io.File;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.dbunit.Assertion;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;

import junit.framework.TestCase;

public class SampleTest extends TestCase {

	public SampleTest(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
		DBUnitConfig dbUnitConfig = new DBUnitConfig();

		// initialize your database connection here
		IDatabaseConnection connection = dbUnitConfig.getDataSetConnection();
		// ...

		// initialize your dataset here
		IDataSet dataSet = dbUnitConfig.getDataSet();
		;
		// ...

		ITable actualJoinData = connection.createQueryTable("users_test", "SELECT * FROM users");
		

		try {
			DatabaseOperation.CLEAN_INSERT.execute(connection, dataSet);
		} finally {
			connection.close();
		}

	public void testMe() throws Exception {
		 // Fetch database data after executing your code
        IDataSet databaseDataSet = connection.createDataSet();
        ITable actualTable = databaseDataSet.getTable("TABLE_NAME");

        // Load expected data from an XML dataset
        IDataSet expectedDataSet = new FlatXmlDataSetBuilder().build(new File("expectedDataSet.xml"));
        ITable expectedTable = expectedDataSet.getTable("TABLE_NAME");

        // Assert actual database table match expected table
        Assertion.assertEquals(expectedTable, actualTable);
	}
	}

	
	
	
	
	
	
	
	
	
	
	
	
}
