package by.news.service.services.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.codec.digest.DigestUtils;

public final class Utills {

	private Utills() {

	}

	public static String getCurrentDate() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar calendar = Calendar.getInstance();
		return dateFormat.format(calendar.getTime());
	}
	
	public static String getMd5Message(String message) {
		String md5Hex = DigestUtils.md5Hex(message);
		return md5Hex;
	}
}
