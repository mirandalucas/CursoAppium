package l.miranda.appium.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import l.miranda.appium.core.BaseTest;
import l.miranda.appium.page.AccordionPage;
import l.miranda.appium.page.MenuPage;

public class AccordionTest extends BaseTest
{
	private MenuPage menu = new MenuPage();
	private AccordionPage acc = new AccordionPage();

	@Test
	public void deveInteragirComAccordion()
	{
		//acessar menu
		menu.acessarAccordion();
		
		//clicar op 1
		acc.selecionarOP1();
		
		// verificar texto op 1
		esperar(1000);
		assertEquals("Esta é a descrição da opção 1", acc.obterValorOP1());
	}
}
