package l.miranda.appium.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileBy;
import l.miranda.appium.core.BaseTest;
import l.miranda.appium.core.DriverFactory;
import l.miranda.appium.page.FormularioPage;
import l.miranda.appium.page.MenuPage;

public class FormularioTeste extends BaseTest {
	
	private MenuPage menu = new MenuPage();
	private FormularioPage form = new FormularioPage();
	
	@Before
	public void inicializarAppium() throws MalformedURLException
	{
		menu.acessarFormulario();
	}
	
	@Test
	public void devePeencherCampoTexto() throws MalformedURLException
	{
		form.escreverNome("Lucas");
		assertEquals("Lucas", form.obterNome());
	}

	@Test
	public void deveInteragirComCombo() throws MalformedURLException
	{
		form.selecionarCombo("PS4");
		assertEquals("PS4", form.obterValorCombo());
	}

	@Test
	public void deveInteragirComSwitchCheckBox() throws MalformedURLException
	{
		assertFalse(form.isCheckMarcado());
		assertTrue(form.isSwitchMarcado());
		
		form.clicarCheck();
		form.clicarSwitch();
		
		assertTrue(form.isCheckMarcado());
		assertFalse(form.isSwitchMarcado());
	}

	@Test
	public void deveRealizarCadastro() throws MalformedURLException
	{
		form.escreverNome("Lucas");
		form.clicarCheck();
		form.clicarSwitch();
		form.selecionarCombo("PS4");
		
		form.salvar();

		assertEquals("Nome: Lucas", form.obterNomeCadastrado());
		assertEquals("Console: ps4", form.obterConsoleCadastrado());
		assertTrue(form.obterCheckCadastrado().endsWith("Off"));
		assertTrue(form.obterSwitchCadastrado().endsWith("Marcado"));
	}
	
	@Test
	public void deveRealizarCadastroDemorado() throws MalformedURLException
	{
		form.escreverNome("Lucas");
	
		DriverFactory.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		form.salvarDemorado();
		
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Nome: Lucas']")));
		
		assertEquals("Nome: Lucas", form.obterNomeCadastrado());
	}
	
	@Test
	public void deveAlterarData()
	{
		form.clicarPorTexto("01/01/2000");
		form.alterarMes();
		form.clicarPorTexto("20");
		form.clicarPorTexto("OK");
		assertTrue(form.existeElementoPorTexto("20/1/2000"));
	}
	
	@Test
	public void deveAlterarHora()
	{
		form.clicarPorTexto("06:00");
		form.click(MobileBy.AccessibilityId("10"));
		form.click(MobileBy.AccessibilityId("40"));
		form.clicarPorTexto("OK");
		assertTrue(form.existeElementoPorTexto("10:40"));
	}
	
	@Test
	public void deveInteragirComSeekBar()
	{
		form.clicarSeekBar(0.65);
		form.salvar();
	}
}
