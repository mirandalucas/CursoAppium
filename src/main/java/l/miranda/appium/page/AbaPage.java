package l.miranda.appium.page;

import l.miranda.appium.core.BasePage;

public class AbaPage extends BasePage
{
	public boolean isAba1()
	{
		return existeElementoPorTexto("Este é o conteúdo da Aba 1");
	}
	
	public boolean isAba2()
	{
		return existeElementoPorTexto("Este é o conteúdo da Aba 2");
	}
	
	public void mudarAba2()
	{
		clicarPorTexto("ABA 2");
	}
}
