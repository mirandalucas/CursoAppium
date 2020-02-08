package l.miranda.appium.page;

import org.openqa.selenium.By;

import l.miranda.appium.core.BasePage;

public class AccordionPage extends BasePage
{
	public void selecionarOP1()
	{
		clicarPorTexto("Op��o 1");
	}
	
	public String obterValorOP1()
	{
		return obterTexto(By.xpath("//*[@text='Op��o 1']/../..//following-sibling::android.view.ViewGroup//android.widget.TextView"));
	}
}
