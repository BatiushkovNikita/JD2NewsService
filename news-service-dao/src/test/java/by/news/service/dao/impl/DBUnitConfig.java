package by.news.service.dao.impl;

import org.dbunit.DBTestCase;
import org.dbunit.DatabaseUnitException;
import org.dbunit.PropertiesBasedJdbcDatabaseTester;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUnitConfig extends DBTestCase {

	public void SampleTest(String name) {
		System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_DRIVER_CLASS, "com.mysql.jdbc.Driver");
		System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_CONNECTION_URL,
				"jdbc:mysql://localhost:3306/news_service_test");
		System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_USERNAME, "root");
		System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_PASSWORD, "admin123");
	}

	@Override
	protected IDataSet getDataSet() throws Exception {
		return new FlatXmlDataSetBuilder().build(new FileInputStream("src/test/resources/dataset.xml"));
	}

	protected IDatabaseConnection getDataSetConnection() {
		IDatabaseConnection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection jdbcConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/news_service_test",
					"root", "admin123");
			connection = new DatabaseConnection(jdbcConnection);
		} catch (SQLException | ClassNotFoundException | DatabaseUnitException e) {
			e.printStackTrace();
		}

		return connection;
	}
}
