package l.miranda.appium.test;

import static org.junit.Assert.*;

import org.junit.Test;

import l.miranda.appium.core.BaseTest;
import l.miranda.appium.page.AbaPage;
import l.miranda.appium.page.MenuPage;

public class AbasTest extends BaseTest
{
	private MenuPage menu = new MenuPage();
	private AbaPage aba = new AbaPage();
	
	@Test
	public void deveInteragirComAbas()
	{
		menu.acessarAbas();
		assertTrue(aba.isAba1());
		aba.mudarAba2();
		assertTrue(aba.isAba2());
	}
}
