package by.news.service.dao;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.dbunit.DatabaseUnitException;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.database.QueryDataSet;
import org.dbunit.database.search.TablesDependencyHelper;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatDtdDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;

public class DatabaseExport {
	public static void main(String[] args)
			throws DatabaseUnitException, SQLException, ClassNotFoundException, FileNotFoundException, IOException {
		/*Class driverClass = Class.forName("com.mysql.jdbc.Driver");
		Connection jdbcConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/news_service", "root",
				"admin123");
		IDatabaseConnection connection = new DatabaseConnection(jdbcConnection);
*/
		// write DTD file
		//FlatDtdDataSet.write(connection.createDataSet(), new FileOutputStream("test.dtd"));
	}

	/*
	 * // partial database export QueryDataSet partialDataSet = new
	 * QueryDataSet(connection); partialDataSet.addTable("users",
	 * "SELECT * FROM users WHERE COL='VALUE'"); partialDataSet.addTable("BAR");
	 * FlatXmlDataSet.write(partialDataSet, new
	 * FileOutputStream("partial.xml"));
	 * 
	 * // full database export IDataSet fullDataSet =
	 * connection.createDataSet(); FlatXmlDataSet.write(fullDataSet, new
	 * FileOutputStream("full.xml"));
	 * 
	 * // dependent tables database export: export table X and all tables that
	 * // have a PK which is a FK on X, in the right order for insertion
	 * String[] depTableNames =
	 * TablesDependencyHelper.getAllDependentTables(connection, "X"); IDataSet
	 * depDataset = connection.createDataSet(depTableNames);
	 * FlatXmlDataSet.write(depDataSet, new FileOutputStream("dependents.xml"));
	 */

}
