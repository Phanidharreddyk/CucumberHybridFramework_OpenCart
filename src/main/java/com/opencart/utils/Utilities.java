package com.opencart.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utilities {

	public static String generateEmail() {

		Date date = new Date();
		String timestamp = date.toString().replace(" ", "_").replace(":", "_");
		return "kotala" + timestamp + "@gmail.com";
	}	
	public static String takeScreenshot(WebDriver driver, String testname) {
		
		File screenshotfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String Destination = System.getProperty("user.dir") + "\\Screenshots\\"+ testname+"_"+ Utilities.getTimeStamp() + ".png";
		try {
			FileHandler.copy(screenshotfile, new File(Destination));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return Destination;
			
	}
	
	public static String getTimeStamp() {
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-M-yyyy_hh-mm-ss");
		String timestamp = formatter.format(date);
		return timestamp;
	}
}
