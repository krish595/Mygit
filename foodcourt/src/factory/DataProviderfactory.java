package factory;

import dataProvider.ConfigDataProvider;
import dataProvider.ExcelDataProvider;

public  class DataProviderfactory {
	
	public static ConfigDataProvider getConfig()
	{
		ConfigDataProvider config=new ConfigDataProvider();
		return config;
	}
	
	public static ExcelDataProvider getExcel()
	{
		ExcelDataProvider excel=new ExcelDataProvider();
		return excel;
	}

}
