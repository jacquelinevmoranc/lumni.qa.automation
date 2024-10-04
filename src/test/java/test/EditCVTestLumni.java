package test;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pagePackage.EditCVLumni;
import pagePackage.LoginLumni;

class EditCVTestLumni {
	private WebDriver driver;
	private LoginLumni loginLumni;
	private EditCVLumni editCVLumni;

	@BeforeEach
	public void setUp() throws Exception {
		// Conexión con Chrome
		driver = new ChromeDriver();

		// Crear el objeto y darle un valor al driver
		loginLumni = new LoginLumni(driver);
		editCVLumni = new EditCVLumni(driver);

		// Visitar la página...
		loginLumni.visit("https://login.qa.lumni.net/?app=LumniStudents");
	}

	@AfterEach
	void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	void sectionEditCV() {
		// Método para ingresar datos
		loginLumni.loginStandardUser();

		// Método para hacer un inicio de sesión exitoso
		loginLumni.loginSuccess();
		assertTrue(loginLumni.loginSuccess(), "No se encontró la página");
		
		// Método que valida que la flecha sea visible
		editCVLumni.displayedArrowDropdown();
		
		// Método que valida que se hace clic en opción "Editar HV"
		editCVLumni.sectionEditCV();

		// Método para validar que se ingresó a la sección
		editCVLumni.sectionEditHVSuccess();
		assertTrue(editCVLumni.sectionEditHVSuccess(), "No se encontró la página");
		
		// Método que valida que todos los elementos estén visibles
		editCVLumni.displayedElementsEditCV();
		
		// Método para subir archivo
		editCVLumni.uploadCV();
		
		
	}


}
