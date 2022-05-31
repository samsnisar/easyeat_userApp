package com.easyeat.userapp.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class Readconfig {
	
	Properties prop;
	
	public Readconfig()
	{
		File src = new File("./Configurations/config.properties");

		try {
			FileInputStream file = new FileInputStream(src);
			prop = new Properties();
			prop.load(file);
		} catch (Exception e) {
			System.out.println("Exception is " + e.getMessage());
		}
	}
	
	public String getURL()
	{
		String url1=prop.getProperty("url");
		return url1;
	}
	
	public String getTA_URL()
	{
		String url2=prop.getProperty("Ta_url");
		return url2;
	}
	
	public String getPU_URL()
	{
		String url3=prop.getProperty("Pu_url");
		return url3;
	}
	
	public String getApplicationURL()
	{
		String url=prop.getProperty("baseURL");
		return url;
	}
	public String getrname()
	{
	String rname=prop.getProperty("rname");
	return rname;
	}
	
	public String getphnum()
	{
	String phnum=prop.getProperty("phnum");
	return phnum;
	}
	
	public String getuname()
	{
	String uname=prop.getProperty("uname");
	return uname;
	}
	
	public String getpwd()
	{
	String pwd=prop.getProperty("pwd");
	return pwd;
	}
	
	public String getdineInqr()
	{
	String dineIn=prop.getProperty("dineIn");
	return dineIn;
	}
	
	
	
	public String getChromePath()
	{
	String chromepath=prop.getProperty("chromepath");
	return chromepath;
	}
	
	public String getIEPath()
	{
	String iepath=prop.getProperty("iepath");
	return iepath;
	}
	
	public String getFirefoxPath()
	{
	String firefoxpath=prop.getProperty("firefoxpath");
	return firefoxpath;
	}
	

}