package com.primusbank.library;

import org.openqa.selenium.By;

import com.primusbank.constants.PrimusBankConstants;

public class CustomerHomePage extends PrimusBankConstants 
{

	public void customerLogout()
	{
		driver.findElement(By.xpath("//table/tbody/tr/td[3]/a/img")).click();
	}
	
}
