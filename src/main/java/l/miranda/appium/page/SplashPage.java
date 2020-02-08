package l.miranda.appium.page;

import static l.miranda.appium.core.DriverFactory.getDriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import l.miranda.appium.core.BasePage;

public class SplashPage extends BasePage
	{
		public boolean isTelaSplashVisivel()
		{
			return existeElementoPorTexto("Splash!");
		}
		
		public void aguardarSplashSumir()
		{
			getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			WebDriverWait wait = new WebDriverWait(getDriver(), 10);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@text='Splash!']")));
		}
	}