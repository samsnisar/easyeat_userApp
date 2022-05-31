package com.easyeat.userapp.testCases;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.easyeat.userapp.pageobjects.RestaurantSearch;



public class TC_ReastaurantSearch_001 extends BaseClass{
	
	
	
	@Test(priority=1)
	public void open_URL() throws Exception {
		getdriver().get(URL);
		logger.info("Url Opened");
		if(getdriver().getCurrentUrl().equals("URL")) {
			Assert.assertTrue(true);
			logger.info("URL opened succcessfully");
			}
		else {
			logger.info("Something went wrong unable to open URL succcessfully");
			captureScreen(getdriver(), "URL Test");
			Assert.assertTrue(false);
			
		}
	}
	
	@Test(priority=2)
	public void restaurantsearch () throws Exception {
		
		RestaurantSearch search = new RestaurantSearch(getdriver());
		getdriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		search .setrestaurantSearch(rname);
		Thread.sleep(1000);
		logger.info("Enter Restaurant name");
		search.selectrestaurant(rname);
		logger.info("Select Restaurant");
		
	}

}
