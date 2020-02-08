package l.miranda.appium.test;

import static l.miranda.appium.core.DriverFactory.getDriver;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import l.miranda.appium.core.BaseTest;
import l.miranda.appium.page.MenuPage;

public class OpcaoEscondidaTest extends BaseTest
{
	private MenuPage menu = new MenuPage();
	
	@Test
	public void deveEncontrarOp�aoEscondida()
	{
		WebDriverWait wait = new WebDriverWait(getDriver(), 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Formul�rio']")));
		menu.scrollDown();
		menu.clicarPorTexto("Op��o bem escondida");
		assertEquals("Voc� achou essa op��o", menu.obterMenssagemAlerta());
		menu.clicarPorTexto("OK");
	}
}
