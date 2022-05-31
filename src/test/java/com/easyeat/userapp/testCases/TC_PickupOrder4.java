package com.easyeat.userapp.testCases;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.easyeat.userapp.pageobjects.Delivery_order;
import com.easyeat.userapp.pageobjects.PickUp_Order;

public class TC_PickupOrder4 extends BaseClass{
	PickUp_Order pickup = new PickUp_Order(getdriver());
	

	@Test(priority=1)
	public void open_URL() throws Exception {
		getdriver().get(Pu_url);
		logger.info("Url Opened");
		if(getdriver().getCurrentUrl().equals(Pu_url)) {
			Assert.assertTrue(true);
			logger.info("URL opened succcessfully");
		}
		else {
			logger.info("Something went wrong unable to open URL succcessfully");
			captureScreen(getdriver(), "UserApp Test");
			Assert.assertTrue(false);
			
		}
	}
		
	
	
	@Test(priority=2)
	public void verify_restaurant () throws Exception {
	
		
		PickUp_Order pickup = new PickUp_Order(getdriver());
		getdriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		if (pickup.verify_text(pickup.verify_onboardingscreen).equals("How to Order")) {
			Thread.sleep(2000);
			Assert.assertTrue(true);
			pickup.click(pickup.click_startordering);
			logger.info("Promotion screen enabled clicked on start ordering");
			pickup.verify_text(pickup.verify_restaurant).equals(rname);		
			logger.info("Verified Restaurant name");
			pickup.click(pickup.change_ordertype);
			Thread.sleep(2000);
			pickup.click(pickup.select_pickup);
			pickup.click(pickup.click_continue);
			logger.info("Verify Order Type");
			if(pickup.verify_text(pickup.verify_ordertype).equals("PickUp")) {
				Assert.assertTrue(true);
			logger.info("Order Type Changed to PickUp");
			}
			else {
				logger.info("Unable to change order type");
				captureScreen(getdriver(), "order type");
				Assert.assertTrue(false);
			}
			
		}
		else if (pickup.verify_text(pickup.verify_restaurant).equals(rname)) {
			Thread.sleep(2000);
			Assert.assertTrue(true);
			logger.info("Restaurant Name Verified");
			pickup.click(pickup.change_ordertype);
			Thread.sleep(2000);
			pickup.click(pickup.select_pickup);
			pickup.click(pickup.click_continue);
			logger.info("Verify Order Type");
			if(pickup.verify_text(pickup.verify_ordertype).equals("PickUp")) {
				Assert.assertTrue(true);
			logger.info("Order Type Changed to PickUp");
			}
			else {
				logger.info("Unable to change order type");
				captureScreen(getdriver(), "Unable to change order type");
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
	public void pickup_Order001 () throws Exception{
		PickUp_Order pickup1 = new PickUp_Order(getdriver());
		getdriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//if (getdriver().getCurrentUrl().contains("r")) {
		pickup1.select_action(pickup1.click_openmenu);
		logger.info("Open menu is clicked");
		Thread.sleep(2000);
		pickup1.select_action(pickup1.menu);
		logger.info("Menu Category is Selected");
		Thread.sleep(2000);
		pickup1.select_action(pickup1.select_item);
	    logger.info("Item selected");
	    Thread.sleep(2000);
	    pickup1.select_action(pickup1.click_viewcart);
	    logger.info("View cart is clicked");
	    Thread.sleep(2000);
	    
	    
	    if(pickup1.verify_text(pickup1.verify_cartstatus).contains("Login")) {
	    pickup1.select_action(pickup1.click_logintopay);
	    logger.info("Click On Login to Pay");
	    Thread.sleep(2000);
	    pickup1.enter_phoneno(phnum);
	    logger.info("Enter mobile Number");
	    pickup1.click(pickup1.click_signin);
	    logger.info("Signin to proceed");
	    Thread.sleep(5000);
	    
	    pickup1.select_action(pickup1.proceedtopay);
	    logger.info("Proceed to pay");
	    Thread.sleep(10000);
	    pickup1.select_onlinefpx(uname,pwd);
	   logger.info("Payment completed");
	   
	   if (pickup1.verify_text(pickup1.verify_orderstatus).contains("Order Placed")) {
		   Assert.assertTrue(true);
		logger.info("Order Placed Verified");
		pickup1.click(pickup1.click_done);
		  if (pickup1.verify_text(pickup1.verify_orderType_statuspage).equals("Order Type: PickUp")) {
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
	   
	   pickup1.select_action(pickup1.click_back);
	   Thread.sleep(3000);
		}
	
	else if (pickup1.verify_text(pickup1.verify_cartstatus).contains("Proceed")) {
		
		 pickup1.select_action(pickup1.proceedtopay);
		    logger.info("Proceed to pay");
		    Thread.sleep(10000);
		    pickup1.select_onlinefpx(uname,pwd);
		   logger.info("Payment completed");
		   
		   if (pickup1.verify_text(pickup1.verify_orderstatus).contains("Order Placed")) {
			   Assert.assertTrue(true);
			logger.info("Order Placed Verified");
			pickup1.click(pickup1.click_done);
			  if (pickup1.verify_text(pickup1.verify_orderType_statuspage).equals("Order Type: PickUp")) {
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
		   
		   pickup1.select_action(pickup1.click_back);
		   Thread.sleep(3000);
			}
	    
	else {
		 logger.info("");
	    	captureScreen(getdriver(), "order placed");
	    	Assert.assertTrue(false);
	}
	}
	   
	 
		
		
		
	
	}
	


