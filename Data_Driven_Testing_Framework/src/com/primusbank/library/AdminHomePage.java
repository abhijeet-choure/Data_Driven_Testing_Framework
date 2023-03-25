package com.primusbank.library;

import org.openqa.selenium.By;

import com.primusbank.constants.PrimusBankConstants;

public class AdminHomePage extends PrimusBankConstants 
{

	public void adminLogout()
	{
		driver.findElement(By.xpath("//table/tbody/tr/td[3]/a/img")).click();		
	}
	
	public void navigateToBranchDetailsPage()
	{
		driver.findElement(By.xpath("//table/tbody/tr[2]/td/a/img")).click();
	}
	
}
