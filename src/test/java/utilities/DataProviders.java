package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	
	@DataProvider (name="Logindata")
	public String [][] getData() throws IOException
	{
		
		String fpath = ".\\testdata\\logintestdata.xlsx";
		
		ExcellUtility exl = new ExcellUtility(fpath);
		
		int rcount = exl.getRowCount("Sheet1");
		int ccount = exl.getCellCount("Sheet1",1);
				
		String [][] logindata = new String [rcount][ccount];
		
		
		for(int r=1;r<=rcount;r++)
		{
			for(int c=0;c<ccount;c++ )
			{
				logindata[r-1][c] = exl.getCellData("Sheet1", r, c);
			}
		}
	
		return logindata;
	}

}
