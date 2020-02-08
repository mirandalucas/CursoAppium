package l.miranda.appium.test;

import static org.junit.Assert.assertTrue;
import org.junit.Test;
import l.miranda.appium.core.BaseTest;
import l.miranda.appium.page.MenuPage;
import l.miranda.appium.page.SplashPage;

public class SplashTeste extends BaseTest
	{	
		private MenuPage menu = new MenuPage();
		private SplashPage splash = new SplashPage();
	
		@Test
		public void deveAguardarSplashSumir()
			{
				//acessar menu splash
				menu.acessarSplash();
				
				//verificar que splash esta sendo exibido
				splash.isTelaSplashVisivel();			
				//aguardar a saida do splash
				splash.aguardarSplashSumir();
			
				//verificar que o form está aparecendo
				assertTrue(splash.existeElementoPorTexto("Formulário"));
			}
		
	}
