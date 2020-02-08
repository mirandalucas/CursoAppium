package l.miranda.appium.test;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Before;
import org.junit.Test;

import l.miranda.appium.core.BaseTest;
import l.miranda.appium.page.DragNDropPage;
import l.miranda.appium.page.MenuPage;

public class DragNDropTest extends BaseTest
{
	private MenuPage menu = new MenuPage();
	private DragNDropPage page = new DragNDropPage();

	private String[] estadoInicial = new String[]
			{
					"Esta", "é uma lista", "Drag em Drop!", "Faça um clique longo,", "e arraste para", "qualquer local desejado."
			};
	
	private String[] estadoIntermediario = new String[]
			{
					"é uma lista", "Drag em Drop!", "Faça um clique longo,", "e arraste para", "Esta", "qualquer local desejado."
			};
	
	private String[] estadoFinal = new String[]
			{
				"Faça um clique longo,", "é uma lista", "Drag em Drop!", "e arraste para", "Esta", "qualquer local desejado."
			};
	
	@Before
	public void setup()
	{
		menu.clicarDragNDrop();
	}
	
	@Test
	public void deveEfetuarDragNDrop()
	{
		esperar(2000);
		assertArrayEquals(estadoInicial, page.obterLista());
		page.arrastar("Esta", "e arraste para");
		assertArrayEquals(estadoIntermediario, page.obterLista());
		page.arrastar("Faça um clique longo,", "é uma lista");
		assertArrayEquals(estadoFinal, page.obterLista());
	}
}
