package l.miranda.appium.page;

import static l.miranda.appium.core.DriverFactory.getDriver;

import org.openqa.selenium.By;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import l.miranda.appium.core.BasePage;

public class FormularioPage extends BasePage
	{
	
		public void escreverNome(String nome)
			{
				escrever(MobileBy.AccessibilityId("nome"), nome);
			}
		
		public String obterNome()
			{
				return obterTexto(MobileBy.AccessibilityId("nome"));
			}
	
		public void selecionarCombo(String valor)
			{
				selecionarCombo(MobileBy.AccessibilityId("console"), valor);
			}
		
		public String obterValorCombo()
			{
				return obterTexto(By.xpath("//android.widget.Spinner/android.widget.TextView"));
			}
		
		public void clicarCheck()
			{
				click(By.className("android.widget.CheckBox"));
			}
		
		public void clicarSwitch()
			{
				click(MobileBy.AccessibilityId("switch"));
			}
		
		public boolean isCheckMarcado()
			{
				return isCheckMarcado(By.className("android.widget.CheckBox"));
			}
		
		public boolean isSwitchMarcado()
			{
				return isCheckMarcado(MobileBy.AccessibilityId("switch"));
			}
		
		public void clicarSeekBar(double posicao)
		{
			int delta = 50;
			MobileElement seek = getDriver().findElement(MobileBy.AccessibilityId("slid"));
			int y = seek.getLocation().y + (seek.getSize().height / 2);
			System.out.println(y);
			
			int xInicial = seek.getLocation().x + delta;
			int x = (int) (xInicial + ((seek.getSize().width - 2 * delta) * posicao));
			System.out.println(x);
			
			tap(x, y);
		}
		
		public void salvar()
			{
				clicarPorTexto("SALVAR");
			}
		
		public void salvarDemorado()
			{
				clicarPorTexto("SALVAR DEMORADO");
			}
		
		public String obterNomeCadastrado()
			{
				return obterTexto(By.xpath("//android.widget.TextView[starts-with(@text, 'Nome:')]"));
			}
		
		public String obterConsoleCadastrado()
			{
				return obterTexto(By.xpath("//android.widget.TextView[starts-with(@text, 'Console:')]"));
			}
		
		public String obterCheckCadastrado()
			{
				return obterTexto(By.xpath("//android.widget.TextView[starts-with(@text, 'Switch:')]"));
			}
		
		public String obterSwitchCadastrado()
			{
				return obterTexto((By.xpath("//android.widget.TextView[starts-with(@text, 'Checkbox:')]")));
			}
		
		public void alterarMes()
			{
				click(By.id("android:id/prev"));
			}
	}