package l.miranda.appium.page.seuBarriga;

import l.miranda.appium.core.BasePage;

public class SBMenuPage extends BasePage
{
	public void acessarHome()
	{
		clicarPorTexto("HOME");
	}
	
	public void acessarContas()
	{
		clicarPorTexto("CONTAS");
	}
	
	public void acessarMovimentacao()
	{
		clicarPorTexto("MOV...");
	}
	
	public void acessarResumo()
	{
		clicarPorTexto("RESUMO");
	}
}
