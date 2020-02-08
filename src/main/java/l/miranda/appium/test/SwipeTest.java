package l.miranda.appium.test;

import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import l.miranda.appium.core.BaseTest;
import l.miranda.appium.page.MenuPage;

public class SwipeTest extends BaseTest
{
	private MenuPage menu = new MenuPage();
	
	@Before
	public void setup()
	{
		menu.acessarSwipe();
	}
	
	@Test
	public void deveRealizarSwipe()
	{
		assertTrue(menu.existeElementoPorTexto("a esquerda"));
		menu.swipeRight();
		assertTrue(menu.existeElementoPorTexto("E veja se"));
		menu.clicarPorTexto("›");
		assertTrue(menu.existeElementoPorTexto("Chegar até o fim!"));
		menu.swipeLeft();
		menu.clicarPorTexto("‹");
		assertTrue(menu.existeElementoPorTexto("a esquerda"));
	}
}
