/* Actualmente no se puede interactuar con este módulo
500 Internal Server Error
If you are the administrator of this website, then please read this web 
application's log file and/or the web server's log file to find out what went wrong.
 */

package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pagePackage.LoginLumni;
import pagePackage.PaymentsLumni;

class PaymentsTestLumni {
	private WebDriver driver;
	private LoginLumni loginLumni;
	private PaymentsLumni paymentsLumni;

	@BeforeEach
	public void setUp() throws Exception {

		// Conexión con Chrome
		driver = new ChromeDriver();

		// Crear el objeto y darle un valor al driver
		loginLumni = new LoginLumni(driver);
		paymentsLumni = new PaymentsLumni(driver);

		// Visitar la página...
		loginLumni.visit("https://login.qa.lumni.net/?app=LumniStudents");
		paymentsLumni.visit("https://codeable.qa.lumniportal.net/mains");

	}

	@AfterEach
	public void tearDown() throws Exception {
		if (driver != null) {
			driver.quit();
		}
	}

	@Test
	void sectionPayments() {
		// Método para ingresar datos
		loginLumni.loginStandardUser();

		// Método para hacer un inicio de sesión exitoso
		loginLumni.loginSuccess();
		assertTrue(loginLumni.loginSuccess(), "No se encontró la página");
		
		//Método para validar que se haya cambiado a la sección "Pagos"
		paymentsLumni.sectionPayments();
		
		// Método para ir al módulo "Pagos" y validar los elementos visibles
		paymentsLumni.sectionPaymentsDisplayed();
	}

}
