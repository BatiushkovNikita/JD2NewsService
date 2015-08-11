package by.news.service.services;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		String passwordMD5 = DigestUtils.md5Hex("qwerty");
		System.out.println(passwordMD5);
	}
}











