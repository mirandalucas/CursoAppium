package l.miranda.appium.core;

import org.junit.After;
import org.junit.AfterClass;

public class BaseTest
	{
		@AfterClass
		public static void finalizaClasse()
			{
				DriverFactory.killDriver();
			}
	
		@After
		public void tearDown()
			{
				DriverFactory.getDriver().resetApp();
			}
		
		public void esperar(long tempo)
			{
				try
					{
						Thread.sleep(tempo);
					} 
				catch (InterruptedException e)
					{
						e.printStackTrace();
					}
			}
	}
