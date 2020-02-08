package l.miranda.appium.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;

import l.miranda.appium.core.BaseTest;
import l.miranda.appium.page.AlertaPage;
import l.miranda.appium.page.MenuPage;

public class AlertTest extends BaseTest
{
	private MenuPage menu = new MenuPage();
	private AlertaPage alerta = new AlertaPage();
	
	@Before
	public void setup()
	{
		menu.acessarAlertas();
	}
	
	@Test
	public void deveConfirmarAleta()
	{
		menu.acessarAlertas();
		alerta.clicarAlertaConfirm();
		assertEquals("Info", alerta.obterTituloAlerta());
		assertEquals("Confirma a operação?", alerta.obterMenssagemAlerta());
		alerta.confirmar();
		assertEquals("Confirmado", alerta.obterMenssagemAlerta());
		alerta.sair();
	}
	
	@Test
	public void deveClicarForaAlerta()
	{
		//clicar alerta simples
		alerta.clicarAlertaSimples();
		
		//clicar fora da caixa
//		esperar(1000);
		alerta.clicarForaCaixa();
		//verificar msg nao está mais presente
		assertFalse(alerta.existeElementoPorTexto("Pode clicar no OK ou fora para sair"));
	}
}
