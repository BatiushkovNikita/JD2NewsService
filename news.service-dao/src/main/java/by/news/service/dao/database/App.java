package by.news.service.dao.database;

import java.io.IOException;
import java.util.Scanner;

import by.news.service.dao.database.impl.UserDAOImpl;
import by.news.service.dao.database.interf.GenericDAO;
import by.news.service.entity.User;

public class App {
	public static void main(String[] args) {
		System.out.println("It's Alive!!!");
		System.out.println("Press something...");
		try {
			System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
