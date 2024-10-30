package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import pagePackage.LoginLumni;

class LoginTestLumni {

	private WebDriver driver;
	LoginLumni loginLumni;

	@BeforeEach
	void setUp() throws Exception {

		// Crear el objeto y darle un valor al driver
		loginLumni = new LoginLumni(driver);

		// Conexión con Chrome
		driver = loginLumni.chromeDriverConnection();

		// Visitar la página ...
		loginLumni.visit("https://login.qa.lumni.net/?app=LumniStudents");
	}

	@AfterEach
	void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	void loginStandarUser() {

		// Método que valida que los elementos existan
		loginLumni.Login();

		// Método para ingresar datos
		loginLumni.loginStandardUser();

		// Método para hacer un inicio de sesión exitoso
		loginLumni.loginSuccess();
		assertTrue(loginLumni.loginSuccess(), "No se encontró la página");

	}

	@Test
	void loginWithoutEmail() {
		// Método que valida que los elementos existan
		loginLumni.Login();
		// Método para validar que no se ingresó email y no se puede continuar
		loginLumni.loginWithoutEmail();

	}

	@Test
	void loginWithoutPassword() {
		// Método que valida que los elementos existan
		loginLumni.Login();
		// Método para validar que se ingresó email, pero no contraseña.
		loginLumni.loginWithoutPassword();
	}

	@Test
	void messageLoginWithPassword() {
		// Método que valida el mensaje luego de haber ingresado el email.
		loginLumni.messageLoginWithPassword();
	}

	@Test
	//@RepeatedTest(5)
	void sendCode() {

		// Método que valida el ingreso por código
		loginLumni.sendCode();
	}

}
