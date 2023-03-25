package com.qedge.tests;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.primusbank.constants.PrimusBankConstants;
import com.primusbank.library.BankerHomePage;
import com.primusbank.library.PrimusBankHomePage;
import com.utils.XLUtils;

public class BankerLoginDDT extends PrimusBankConstants
{
	public String xlfile="D:\\Frameworks1130\\DDTProject\\src\\com\\primusbank\\testdata\\Testdata.xlsx";
	public String xlsheet="LoginData";
	public int j=1;
	XLUtils xl=new XLUtils();
	
	@Test(dataProvider="bankerlogindata")
	public void bankerLoginDDT(String brname,String uid,String pwd) throws IOException
	{
		boolean res;
		
		PrimusBankHomePage phome=new PrimusBankHomePage();
		res=phome.bankerLogin(brname, uid, pwd);
		BankerHomePage bhome=new BankerHomePage();
		bhome.bankerLogout();
		if (res) 
		{
			xl.setCellData(xlfile, xlsheet, j, 3, "Pass");
			xl.fillGreenColor(xlfile, xlsheet, j, 3);
		} else 
		{
			xl.setCellData(xlfile, xlsheet, j, 3, "Fail");
			xl.fillRedColor(xlfile, xlsheet, j, 3);
		}
		j++;
	}
	
	@DataProvider
 	public Object[][] bankerlogindata() throws IOException	
	{
 		 		
		int rc,cc;
 		
 		rc=xl.getRowCount(xlfile, xlsheet);
 		cc=xl.getCellCount(xlfile, xlsheet, 1);
 		Object[][] data=new Object[rc][cc];
 		for (int i = 1; i <= rc; i++) 
 		{
 			data[i-1][0]=xl.getCellData(xlfile, xlsheet, i, 0);
 			data[i-1][1]=xl.getCellData(xlfile, xlsheet, i, 1);
 			data[i-1][2]=xl.getCellData(xlfile, xlsheet, i, 2); 			
		}
 		return data; 		
 	}
	
	
}
