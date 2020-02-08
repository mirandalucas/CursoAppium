package l.miranda.appium.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import l.miranda.appium.core.BaseTest;
import l.miranda.appium.page.CliquesPage;
import l.miranda.appium.page.MenuPage;

public class ClickTest extends BaseTest
{
	private static MenuPage menu = new MenuPage();
	private CliquesPage click = new CliquesPage();	
	
	@Before
	public void setup()
	{
		menu.acessarCliques();
	}
	
	@Test
	public void devoRealizarCliqueLongo()
	{
		click.cliqueLongo();
		assertEquals("Clique Longo", click.obterTextoCampo());
	}
	
	@Test
	public void devoRealizarCliqueDuplo()
	{
		click.clicarPorTexto("Clique duplo");
		click.clicarPorTexto("Clique duplo");
		assertEquals("Duplo Clique", click.obterTextoCampo());
	}
}
