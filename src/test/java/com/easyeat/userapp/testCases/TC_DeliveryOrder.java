package com.easyeat.userapp.testCases;

import java.util.concurrent.TimeUnit;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.easyeat.userapp.pageobjects.Delivery_order;

public class TC_DeliveryOrder extends BaseClass{
	Delivery_order delivery = new Delivery_order(getdriver());
	

	@Test(priority=1)
	public void open_URL() throws Exception {
		getdriver().get(baseURL);
		logger.info("Url Opened");
		if(getdriver().getCurrentUrl().equals(baseURL)) {
			Assert.assertTrue(true);
			logger.info("URL opened succcessfully");
			Thread.sleep(2000);
		}
		else {
			logger.info("Something went wrong unable to open URL succcessfully");
			captureScreen(getdriver(), "URL Test");
			Assert.assertTrue(false);
			Thread.sleep(2000);
		}
	}
		
	
	
	@Test(priority=2)
	public void verify_restaurant () throws Exception {
	
		
		Delivery_order delivery = new Delivery_order(getdriver());
		getdriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		if (delivery.verify_text(delivery.verify_onboardingscreen).equals("How to Order")) {
			Thread.sleep(2000);
			Assert.assertTrue(true);
			delivery.click(delivery.click_startordering);
			logger.info("Promotion screen enabled clicked on start ordering");
			delivery.verify_text(delivery.verify_restaurant).equals(rname);		
			logger.info("Verified Restaurant name");
			logger.info("Verify Order Type");
			if(delivery.verify_text(delivery.verify_ordertype).equals("Delivery")) {
				Assert.assertTrue(true);
			logger.info("Order tyoe verified as delivery");
			}
			else {
				logger.info("Order Type is changed");
				captureScreen(getdriver(), "order type");
				Assert.assertTrue(false);
			}
			
		}
		else if (delivery.verify_text(delivery.verify_restaurant).equals(rname)) {
			Thread.sleep(2000);
			Assert.assertTrue(true);
			logger.info("Restaurant Name Verified");
			logger.info("Verify Order Type");
			if(delivery.verify_text(delivery.verify_ordertype).equals("Delivery")) {
				Assert.assertTrue(true);
			logger.info("Order tyoe verified as delivery");
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
	public void delivery_Order001 () throws Exception{
		Delivery_order delivery1 = new Delivery_order(getdriver());
		getdriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//if (getdriver().getCurrentUrl().contains("r")) {
		delivery1.select_action(delivery1.click_openmenu);
		logger.info("Open menu is clicked");
		Thread.sleep(2000);
		delivery1.select_action(delivery1.menu);
		logger.info("Menu Category is Selected");
		Thread.sleep(2000);
		delivery1.select_action(delivery1.select_item);
	    logger.info("Item selected");
	    Thread.sleep(2000);
	    delivery1.select_action(delivery1.click_viewcart);
	    logger.info("View cart is clicked");
	    Thread.sleep(2000);
	    
	    
	    if(delivery1.verify_text(delivery1.verify_cartstatus).contains("Login")) {
	    delivery1.select_action(delivery1.click_logintopay);
	    logger.info("Click On Login to Pay");
	    Thread.sleep(2000);
	    delivery1.enter_phoneno(phnum);
	    logger.info("Enter mobile Number");
	    delivery1.click(delivery1.click_signin);
	    logger.info("Signin to proceed");
	    Thread.sleep(5000);
	    
	    delivery1.select_action(delivery1.proceedtopay);
	    logger.info("Proceed to pay");
	    Thread.sleep(10000);
	    delivery1.select_onlinefpx(uname,pwd);
	   logger.info("Payment completed");
	   
	   if (delivery1.verify_text(delivery1.verify_orderstatus).contains("Order Placed")) {
		   Assert.assertTrue(true);
		logger.info("Order Placed Verified");
		delivery1.click(delivery1.click_done);
		  if (delivery1.verify_text(delivery1.verify_orderType_statuspage).equals("Order Type: Delivery")) {
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
	   
	   delivery1.select_action(delivery1.click_back);
	   Thread.sleep(3000);
		}
	
	else if (delivery1.verify_text(delivery1.verify_cartstatus).contains("Proceed")) {
		
		 delivery1.select_action(delivery1.proceedtopay);
		    logger.info("Proceed to pay");
		    Thread.sleep(10000);
		    delivery1.select_onlinefpx(uname,pwd);
		   logger.info("Payment completed");
		   
		   if (delivery1.verify_text(delivery1.verify_orderstatus).contains("Order Placed")) {
			   Assert.assertTrue(true);
			logger.info("Order Placed Verified");
			delivery1.click(delivery1.click_done);
			  if (delivery1.verify_text(delivery1.verify_orderType_statuspage).equals("Order Type: Delivery")) {
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
		   
		   delivery1.select_action(delivery1.click_back);
		   Thread.sleep(3000);
			}
	    
	else {
		 logger.info("");
	    	captureScreen(getdriver(), "order placed");
	    	Assert.assertTrue(false);
	}
	}
	   
	 
		
		
		
	
	}
	


