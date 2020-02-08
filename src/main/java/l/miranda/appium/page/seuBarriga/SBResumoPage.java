package l.miranda.appium.page.seuBarriga;

import static l.miranda.appium.core.DriverFactory.getDriver;

import org.openqa.selenium.By;

import io.appium.java_client.MobileElement;
import l.miranda.appium.core.BasePage;

public class SBResumoPage extends BasePage
{
	public void excluirMovimentacao(String desc)
	{
		MobileElement el = getDriver().findElement(By.xpath("//*[@text='"+desc+"']/.."));
		swipeElement(el, 0.9, 0.1);
		clicarPorTexto("Del");
	}
}
