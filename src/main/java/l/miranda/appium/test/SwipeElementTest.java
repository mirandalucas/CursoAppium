package l.miranda.appium.test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import l.miranda.appium.core.BaseTest;
import l.miranda.appium.page.MenuPage;
import l.miranda.appium.page.SwipeListPage;

public class SwipeElementTest extends BaseTest
{
	private MenuPage menu = new MenuPage();
	private SwipeListPage page = new SwipeListPage();
	
	@Test
	public void deveResolverDesafio()
	{
		//clicar swipelist
		menu.clicarSwipeList();
		//op1 direita
		page.swipeElementRight("Opção 1");
		//op1+
		page.clicarBotaoMais();
		//verificar op1+
		assertTrue(page.existeElementoPorTexto("Opção 1 (+)"));
		//op4 direito
		page.swipeElementRight("Opção 4");
		//op4-
		page.clicarPorTexto("(-)");
		//check op4-
		assertTrue(page.existeElementoPorTexto("Opção 4 (-)"));
		//op5 esquerdo
		page.swipeElementLeft("Opção 5 (-)");
		//check op5
		assertTrue(page.existeElementoPorTexto("Opção 5"));
	}
}
