package com.qedge.tests;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.utils.XLUtils;

public class LoginDDT 
{

  @Test(dataProvider="logindata")	
  public void loginTest(String uname,String pword)
  {
	  System.out.println(uname+" "+pword);
  }	
	
  @DataProvider	
  public Object[][] logindata() throws IOException
  {
	  String xlfile,xlsheet;
	  xlfile="d:\\testdata.xlsx";
	  xlsheet="LoginData";
	  int rc,cc;
	  
	  XLUtils xl=new XLUtils();
	  rc=xl.getRowCount(xlfile,xlsheet);
	  cc=xl.getCellCount(xlfile, xlsheet, 1);
	  Object[][] data=new Object[rc][cc];
	  
	  for (int i = 1; i <= rc; i++) 
	  {
		  data[i-1][0]=xl.getCellData(xlfile, xlsheet, i, 0);
		  data[i-1][1]=xl.getCellData(xlfile, xlsheet, i, 1);
	  }
	  return data; 
	  
  }
	
	
	
	
	
}
