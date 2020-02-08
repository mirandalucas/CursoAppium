package l.miranda.appium.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import l.miranda.appium.core.BaseTest;
import l.miranda.appium.page.MenuPage;
import l.miranda.appium.page.seuBarriga.SBContasPage;
import l.miranda.appium.page.seuBarriga.SBHomePage;
import l.miranda.appium.page.seuBarriga.SBLoginPage;
import l.miranda.appium.page.seuBarriga.SBMenuPage;
import l.miranda.appium.page.seuBarriga.SBMovimentacaoPage;
import l.miranda.appium.page.seuBarriga.SBResumoPage;

public class SBTest extends BaseTest
{
	private MenuPage           menu = new MenuPage();
	private SBLoginPage        login = new SBLoginPage();
	private SBMenuPage         menuSB = new SBMenuPage();
	private SBContasPage       contas = new SBContasPage();
	private SBMovimentacaoPage mov = new SBMovimentacaoPage();
	private SBHomePage         home = new SBHomePage();
	private SBResumoPage       resumo = new SBResumoPage();
	
	@Before
	public void setup()
	{
		menu.acessarSB();
		login.setEmail("lucas@lucas");
		login.setSenha("lucas");
		login.entrar();
	}
	
	@Test
	public void inserirContaComSucesso()
	{
		menuSB.acessarContas();
		contas.setConta("Conta de Teste");
		contas.salvar();
		assertTrue(contas.existeElementoPorTexto("Conta adicionada com sucesso"));
	}
	
	@Test
	public void excluiConta()
	{
		menuSB.acessarContas();
		contas.selecionarConta("666");
		contas.excluir();
		assertTrue(contas.existeElementoPorTexto("Conta exclu�da com sucesso"));
	}
	
	@Test
	public void validarInclusaoMov()
	{
		menuSB.acessarMovimentacao();
		mov.salvar();
		assertTrue(mov.existeElementoPorTexto("Descri��o � um campo obrigat�rio"));
		mov.setDescricao("Desc");
		mov.salvar();
		assertTrue(mov.existeElementoPorTexto("Interessado � um campo obrigat�rio"));
		mov.setInteressado("eu");
		mov.salvar();
		assertTrue(mov.existeElementoPorTexto("Valor � um campo obrigat�rio"));
		mov.setValor("100");
		mov.salvar();
		assertTrue(mov.existeElementoPorTexto("Conta � um campo obrigat�rio"));
		mov.setConta("Conta para alterar");
		mov.salvar();
		assertTrue(mov.existeElementoPorTexto("Movimenta��o cadastrada com sucesso"));
	}
	
	@Test
	public void atualizarSaldoAoExcluirMovimentacao()
	{
		assertEquals("534.00", home.obterSaldoConta("Conta para saldo"));
		menuSB.acessarResumo();
		resumo.excluirMovimentacao("Movimentacao 3, calculo saldo");
		assertTrue(resumo.existeElementoPorTexto("Movimenta��o removida com sucesso!"));
		menuSB.acessarHome();
		esperar(1500);
		home.scroll(0.2, 0.9);
		assertEquals("-1000.00", home.obterSaldoConta("Conta para saldo"));
	}
}
