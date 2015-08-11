package by.news.service.dao.impl;

import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;

import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.database.search.TablesDependencyHelper;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;

import by.news.service.dao.pool.ConnectionPool;

public class DatabaseExportSample {
	public static void main(String[] args) throws Exception {
		// database connection
		// Connection conn = ConnectionPool.getInstance().getConnection();
		Class driverClass = Class.forName("com.mysql.jdbc.Driver");
		Connection jdbcConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/news_service_test", "root",
				"admin123");
		IDatabaseConnection connection = new DatabaseConnection(jdbcConnection);

		// partial database export
		// QueryDataSet partialDataSet = new QueryDataSet(connection);
		// partialDataSet.addTable("news", "SELECT * FROM news");
		// partialDataSet.addTable("BAR");
		// FlatXmlDataSet.write(partialDataSet, new
		// FileOutputStream("partial.xml"));

		// full database export
		IDataSet fullDataSet = connection.createDataSet();
		FlatXmlDataSet.write(fullDataSet, new FileOutputStream("src/test/resources/full.xml"));

		// dependent tables database export: export table X and all tables that
		// have a PK which is a FK on X, in the right order for insertion
		String[] depTableNames = TablesDependencyHelper.getAllDependentTables(connection, "users");
		IDataSet depDataset = connection.createDataSet(depTableNames);
		FlatXmlDataSet.write(depDataset, new FileOutputStream("src/test/resources/dependents.xml"));

	}

}
