package com.easyeat.userapp.testCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.easyeat.userapp.pageobjects.DineIn_Order;

public class TC_DineInOrder extends BaseClass{
	DineIn_Order DineIn = new DineIn_Order(getdriver());
	
	@Test(priority=1)
	public void open_URL() throws Exception {
		getdriver().get(dineIn);
		logger.info("Url Opened");
		if(getdriver().getCurrentUrl().contains("1")) {
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
		
		
		DineIn_Order dineIn = new DineIn_Order(getdriver());
		getdriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		if (dineIn.verify_text(dineIn.verify_onboardingscreen).equals("How to Order")) {
			Thread.sleep(2000);
			Assert.assertTrue(true);
			dineIn.click(dineIn.click_startordering);
			logger.info("Promotion screen enabled clicked on start ordering");
			dineIn.verify_text(dineIn.verify_restaurant).equals(rname);		
			logger.info("Verified Restaurant name");
			logger.info("Verify Order Type");
			if(dineIn.verify_text(dineIn.verify_ordertype).contains("Dine-In")) {
				Assert.assertTrue(true);
			logger.info("Order tyoe verified as dineIn");
			}
			else {
				logger.info("Order Type is changed");
				captureScreen(getdriver(), "order type");
				Assert.assertTrue(false);
			}
			
		}
		else if (dineIn.verify_text(dineIn.verify_restaurant).equals(rname)) {
			Thread.sleep(2000);
			Assert.assertTrue(true);
			logger.info("Restaurant Name Verified");
			logger.info("Verify Order Type");
			if(dineIn.verify_text(dineIn.verify_ordertype).equals("Dine-In ASAP")) {
				Assert.assertTrue(true);
			logger.info("Order tyoe verified as dineIn");
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
	public void DineIn_order001 () throws Exception{
		DineIn_Order dineIn1 = new DineIn_Order(getdriver());
		getdriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		dineIn1.select_action(dineIn1.click_openmenu);
		logger.info("Open menu is clicked");
		Thread.sleep(2000);
		dineIn1.select_action(dineIn1.menu);
		logger.info("Menu Category is Selected");
		Thread.sleep(2000);
		dineIn1.select_action(dineIn1.select_item);
	    logger.info("Item selected");
	    Thread.sleep(2000);
	    dineIn1.select_action(dineIn1.click_viewcart);
	    logger.info("View cart is clicked");
	    Thread.sleep(2000);
	    
	    
	    if(dineIn1.verify_text(dineIn1.verify_cartstatus).contains("Login")) {
	    dineIn1.select_action(dineIn1.click_logintopay);
	    logger.info("Click On Login to Pay");
	    Thread.sleep(2000);
	    dineIn1.enter_phoneno(phnum);
	    logger.info("Enter mobile Number");
	    dineIn1.click(dineIn1.click_signin);
	    logger.info("Signin to proceed");
	    Thread.sleep(5000);
	    dineIn1.click(dineIn1.click_placeorder);
	    logger.info("Place Order");
	    Thread.sleep(5000);
	    
	    if (dineIn1.verify_text(dineIn1.verify_orderstatus).contains("Order Placed")) {
			   Assert.assertTrue(true);
			logger.info("Order Placed Verified");
			Thread.sleep(2000);
		}
		   else {
			   logger.info("Order Placed screen not displayed");
		    	captureScreen(getdriver(), "order placed");
		    	Assert.assertTrue(false);
		   }
	    
	    dineIn1.click(dineIn1.click_paynoworderstatus);
	    Thread.sleep(2000);
	    logger.info("Clicked on Pay Now");
	    dineIn1.select_onlinefpx(uname,pwd);
		   logger.info("Payment completed");
		   Thread.sleep(3000);
		   if (dineIn1.verify_text(dineIn1.verify_orderstatus).equals("Order Placed")) {
			   Assert.assertTrue(true);
			logger.info("Order Placed Verified");
			Thread.sleep(2000);
			dineIn1.click(dineIn1.click_done);
		}
		   else {
			   logger.info("Order Placed screen not displayed");
		    	captureScreen(getdriver(), "order placed");
		    	Assert.assertTrue(false);
		   }
		   
		   dineIn1.select_action(dineIn1.click_addmore);
		   Thread.sleep(3000);
			}
	    
	    else if (dineIn1.verify_text(dineIn1.verify_cartstatus).contains("Place Order")) {
	    	dineIn1.click(dineIn1.click_placeorder);
		    logger.info("Place Order");
		    Thread.sleep(5000);
		    
		    if (dineIn1.verify_text(dineIn1.verify_orderstatus).contains("Order Placed")) {
				   Assert.assertTrue(true);
				logger.info("Order Placed Verified");
				Thread.sleep(2000);
			}
			   else {
				   logger.info("Order Placed screen not displayed");
			    	captureScreen(getdriver(), "order placed");
			    	Assert.assertTrue(false);
			   }
		    dineIn1.click(dineIn1.click_paynoworderstatus);
		    Thread.sleep(2000);
		    logger.info("Clicked on Pay Now");
		    dineIn1.select_onlinefpx(uname,pwd);
			   logger.info("Payment completed");
			   Thread.sleep(3000);
			   if (dineIn1.verify_text(dineIn1.verify_orderstatus).equals("Order Placed")) {
				   Assert.assertTrue(true);
				logger.info("Order Placed Verified");
				Thread.sleep(2000);
				dineIn1.click(dineIn1.click_done);
				
			}
			   else {
				   logger.info("Order Placed screen not displayed");
			    	captureScreen(getdriver(), "order placed");
			    	Assert.assertTrue(false);
			   }
			   
			   dineIn1.select_action(dineIn1.click_addmore);
			   Thread.sleep(3000);
				}
	    }
		
		
		
	}


