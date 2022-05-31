package com.easyeat.userapp.testCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import com.easyeat.userapp.utilities.Readconfig;



public class BaseClass {
	
	Readconfig readconfig=new Readconfig();
	
	public String Ta_url=readconfig.getTA_URL();
	public String Pu_url=readconfig.getPU_URL();
	public String URL=readconfig.getURL();
	public String baseURL=readconfig.getApplicationURL();
	public String dineIn=readconfig.getdineInqr();
	public String rname=readconfig.getrname();
	public String phnum=readconfig.getphnum();
	public String uname=readconfig.getuname();
	public String pwd=readconfig.getpwd();
	
	private static ThreadLocal<ChromeDriver> cdriver=new ThreadLocal<>();
	private static ThreadLocal<FirefoxDriver> fdriver=new ThreadLocal<>();
	private static ThreadLocal<InternetExplorerDriver> iedriver=new ThreadLocal<>();
	//public static WebDriver driver;
	public static SoftAssert softassert;
	public static Logger logger;
	
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String br) throws Exception {
		
		logger=Logger.getLogger("UserApp Test");
		PropertyConfigurator.configure("log4j.properties");
		
	if(br.equals("chrome")) {
		System.setProperty("webdriver.chrome.driver", readconfig.getChromePath());
		cdriver.set(new ChromeDriver());
		}
	else if (br.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", readconfig.getFirefoxPath());
			fdriver.set(new FirefoxDriver());	
		}
		else if (br.equals("ie")) {
			System.setProperty("webdriver.ie.driver", readconfig.getIEPath());
			iedriver.set(new InternetExplorerDriver());	
		}
		getdriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		getdriver().manage().window().maximize();
		
		
			
	}
	
	public WebDriver getdriver() {
		return cdriver.get();
		
	}
	
	@AfterClass
	public void teardown() {
		getdriver().quit();
		//logger.info("Driver Quit");
		
	}
	
	public void captureScreen(WebDriver driver , String tname) throws IOException{
		TakesScreenshot ts= (TakesScreenshot) driver;
		File source =ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screeshot taken");
	}
	
	
}
