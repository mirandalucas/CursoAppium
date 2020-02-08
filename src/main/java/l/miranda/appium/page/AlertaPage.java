package l.miranda.appium.page;

import l.miranda.appium.core.BasePage;

public class AlertaPage extends BasePage
{
	public void clicarAlertaConfirm()
	{
		clicarPorTexto("ALERTA CONFIRM");
	}
	
	public void clicarAlertaSimples()
	{
		clicarPorTexto("ALERTA SIMPLES");
	}
	
	public void confirmar()
	{
		clicarPorTexto("CONFIRMAR");
	}
	
	public void sair()
	{
		clicarPorTexto("SAIR");
	}
	
	public void clicarForaCaixa()
	{
		tap(100, 150);
	}
}
