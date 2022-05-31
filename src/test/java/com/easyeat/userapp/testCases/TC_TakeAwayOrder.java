package com.easyeat.userapp.testCases;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.easyeat.userapp.pageobjects.Delivery_order;
import com.easyeat.userapp.pageobjects.TakeAway_Order;

public class TC_TakeAwayOrder extends BaseClass{
	TakeAway_Order takeaway = new TakeAway_Order(getdriver());
	

	@Test(priority=1)
	public void open_URL() throws Exception {
		getdriver().get(Ta_url);
		logger.info("Url Opened");
		if(getdriver().getCurrentUrl().equals(Ta_url)) {
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
	public void verify_restaurant () throws Exception {
	
		
		TakeAway_Order takeaway = new TakeAway_Order(getdriver());
		getdriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		if (takeaway.verify_text(takeaway.verify_onboardingscreen).equals("How to Order")) {
			Thread.sleep(2000);
			Assert.assertTrue(true);
			takeaway.click(takeaway.click_startordering);
			logger.info("Promotion screen enabled clicked on start ordering");
			takeaway.verify_text(takeaway.verify_restaurant).equals(rname);		
			logger.info("Verified Restaurant name");
			logger.info("Verify Order Type");
			if(takeaway.verify_text(takeaway.verify_ordertype).equals("TakeAway")) {
				Assert.assertTrue(true);
			logger.info("Order type verified as takeaway");
			}
			else {
				logger.info("Order Type is changed");
				captureScreen(getdriver(), "order type");
				Assert.assertTrue(false);
			}
			
		}
		else if (takeaway.verify_text(takeaway.verify_restaurant).equals(rname)) {
			Thread.sleep(2000);
			Assert.assertTrue(true);
			logger.info("Restaurant Name Verified");
			logger.info("Verify Order Type");
			if(takeaway.verify_text(takeaway.verify_ordertype).equals("TakeAway")) {
				Assert.assertTrue(true);
			logger.info("Order type verified as takeaway");
			}
			else {
				logger.info("Order Type is changed");
				captureScreen(getdriver(), "order type");
				Assert.assertTrue(false);
			}
		}
		else {
			logger.info("Verify restaurant detail Test Failed");
        	captureScreen(getdriver() , "Verify restaurant");
        	Assert.assertTrue(false);
		}
		
	}
	@Test(priority=3)
	public void takeaway_Order001 () throws Exception{
		TakeAway_Order takeaway1 = new TakeAway_Order(getdriver());
		getdriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		takeaway1.select_action(takeaway1.click_openmenu);
		logger.info("Open menu is clicked");
		Thread.sleep(2000);
		takeaway1.select_action(takeaway1.menu);
		logger.info("Menu Category is Selected");
		Thread.sleep(2000);
		takeaway1.select_action(takeaway1.select_item);
	    logger.info("Item selected");
	    Thread.sleep(2000);
	    takeaway1.select_action(takeaway1.click_viewcart);
	    logger.info("View cart is clicked");
	    Thread.sleep(2000);
	    
	    
	    if(takeaway1.verify_text(takeaway1.verify_cartstatus).contains("Login")) {
	    takeaway1.select_action(takeaway1.click_logintopay);
	    logger.info("Click On Login to Pay");
	    Thread.sleep(2000);
	    takeaway1.enter_phoneno(phnum);
	    logger.info("Enter mobile Number");
	    takeaway1.click(takeaway1.click_signin);
	    logger.info("Signin to proceed");
	    Thread.sleep(5000);
	    
	    takeaway1.select_action(takeaway1.proceedtopay);
	    logger.info("Proceed to pay");
	    Thread.sleep(10000);
	    logger.info("Selected onlinefpx to complete payment" );
	    takeaway1.select_onlinefpx(uname,pwd);
	   logger.info("Payment completed");
	   
	   if (takeaway1.verify_text(takeaway1.verify_orderstatus).contains("Order Placed")) {
		   Assert.assertTrue(true);
		logger.info("Order Placed Verified");
		takeaway1.click(takeaway1.click_done);
		  if (takeaway1.verify_text(takeaway1.verify_orderType_statuspage).equals("Order Type: TakeAway")) {
		    	Assert.assertTrue(true);
		    	logger.info("Order Type matched");
		    	Thread.sleep(3000);
		   }
		    else {
		    	logger.info("Order Type doesnot match");
		    	captureScreen(getdriver(), "order type failed");
		    	Assert.assertTrue(false);
			
		   }
	}
	   else {
		   logger.info("Order Placed screen not displayed");
	    	captureScreen(getdriver(), "order placed");
	    	Assert.assertTrue(false);
	   }
	   
	   takeaway1.select_action(takeaway1.click_back);
	   Thread.sleep(3000);
		}
	
	else if (takeaway1.verify_text(takeaway1.verify_cartstatus).contains("Proceed")) {
		
		 takeaway1.select_action(takeaway1.proceedtopay);
		    logger.info("Proceed to pay");
		    Thread.sleep(10000);
		    takeaway1.select_onlinefpx(uname,pwd);
		   logger.info("Payment completed");
		   
		   if (takeaway1.verify_text(takeaway1.verify_orderstatus).contains("Order Placed")) {
			   Assert.assertTrue(true);
			logger.info("Order Placed Verified");
			takeaway1.click(takeaway1.click_done);
			  if (takeaway1.verify_text(takeaway1.verify_orderType_statuspage).equals("Order Type: TakeAway")) {
			    	Assert.assertTrue(true);
			    	logger.info("Order Type matched");
			    	Thread.sleep(3000);
					
			   }
			    else {
			    	logger.info("Order Type doesnot match");
			    	captureScreen(getdriver(), "order type failed");
			    	Assert.assertTrue(false);
				
			   }
		}
		   else {
			   logger.info("Order Placed screen not displayed");
		    	captureScreen(getdriver(), "order placed");
		    	Assert.assertTrue(false);
		   }
		   
		   takeaway1.select_action(takeaway1.click_back);
		   Thread.sleep(3000);
			}
	    
	else {
		 logger.info("");
	    	captureScreen(getdriver(), "order placed");
	    	Assert.assertTrue(false);
	}
	}
	   
	 
		
		
		
	
	}
	


