package pagePackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import basePage.Base;

public class LoginLumni extends Base {
	static WebDriverWait driverWait;

	// Constructor
	public LoginLumni(WebDriver driver) {
		super(driver);
	}

	// Atributos
	By loginTitle = By.xpath("//*[@id=\"__next\"]/div/div/div/div[2]/div/section/h1");
	By email = By.name("email");
	By enterPasswordButton = By.xpath("//*[@id=\"radio-group-loginType-id-1\"]");
	By nextButton = By.xpath(
			"//*[@id=\"__next\"]/div/div/div/div[2]/div/section/div/div[2]/div/div[1]/div/div/div[3]/div/button");
	By messageLoginWithPassword = By
			.xpath("//*[@id=\"__next\"]/div/div/div/div[2]/div/section/div/div[2]/div/div[3]/div/p");
	By password = By.xpath("//input[@type='password']");
	By sendCodeButton = By.id("radio-group-loginType-id-0");
	By messageLoginWithCode = By.xpath(
			"//*[@id=\"__next\"]/div/div/div/div[2]/div/section/div/div[2]/div/div[2]/div/p");
	By enterCode = By.xpath("//label[text()='Ingresa el código:']");
	By boxCode = By.id("dynamic-number-password-id");
	By modalCodeIncorrect = By.xpath("//h3[text()='Código incorrecto']");
	By buttonModalCodeIncorrect = By.xpath("//button[text()='Aceptar']");
	By modalCodeExpired = By.xpath("//h3[text()='El código ha caducado']");
	By buttonModalCodeExpired = By.xpath("//button[text()='Aceptar']");
	By backButton = By.xpath(
			"//*[@id=\"__next\"]/div/div/div/div[2]/div/section/div/div[2]/div/div[3]/div/div[1]/div[2]/div/div[1]/button");
	By backButtonWithCode = By.xpath(
			"//*[@id=\"__next\"]/div/div/div/div[2]/div/section/div/div[2]/div/div[2]/div/div[1]/div[2]/div/div[1]/button");
	By forgotPassword = By
			.xpath("//*[@id=\"__next\"]/div/div/div/div[2]/div/section/div/div[2]/div/div[3]/div/div[2]/a/span");
	By loginButton = By.xpath(
			"//*[@id=\"__next\"]/div/div/div/div[2]/div/section/div/div[2]/div/div[3]/div/div[1]/div[2]/div/div[2]/button");
	By loginButtonWithCode = By.xpath(
			"//body/div[@id='__next']/div[1]/div[1]/div[1]/div[2]/div[1]/section[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]/button[1]");
	By menuJobOffers = By.xpath("//*[@id=\"__next\"]/div/div/div/div/aside/article/main/div[1]/a[9]/div/span");

	// Estos son los Métodos:

	// Validar elementos visibles

	public void Login() {
		isDisplayed(email);
		isDisplayed(sendCodeButton);
		isDisplayed(enterPasswordButton);
		isDisplayed(nextButton);
	}

	// Iniciar sesión con el 1er usuario
	public void loginStandardUser() {

		if (isDisplayed(loginTitle)) {
			type("jacquelinevmc23+matricula@gmail.com", email);
			WebDriverWait ewait = new WebDriverWait(driver, Duration.ofSeconds(10));
			ewait.until(ExpectedConditions.elementToBeClickable(enterPasswordButton));
			click(enterPasswordButton);
			click(nextButton);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			type("12345678", password);
			click(loginButton);
		} else {
			System.out.println("Login page was not found");
		}
	}

	// Inicio de sesión exitoso
	public boolean loginSuccess() {
		return isDisplayed(menuJobOffers);
	}

	// Inicio de sesión sin email
	public void loginWithoutEmail() {
		if (driver.findElement(nextButton).isEnabled()) {
			System.out.println("The button 'Siguiente' is enabled");
		} else {
			System.out.println("The button 'Siguiente' is disabled because there isn't email");
		}

	}

	// Inicio de sesión sin contraseña
	public void loginWithoutPassword() {
		if (isDisplayed(loginTitle)) {
			type("jacquelinevmc23+0804codeable@gmail.com", email);
			click(enterPasswordButton);
			click(nextButton);

			if (driver.findElement(loginButton).isEnabled()) {
				System.out.println("The button 'Iniciar sesión' is enabled");
			} else {
				System.out.println("The button 'Iniciar sesión' is disabled because there isn't password");
			}

		}
	}

	// Mensaje luego de colocar email
	public void messageLoginWithPassword() {
		if (isDisplayed(loginTitle)) {
			type("jacquelinevmc23+01@gmail.com", email);
			click(enterPasswordButton);
			click(nextButton);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			type("12345678", password);

			if (driver.findElement(messageLoginWithPassword).isDisplayed()) {
				System.out.println("The message 'Iniciar sesión con tu usuario y contraseña' is displayed");
			} else {
				System.out.println("The message is not displayed");
			}

		}

	}

	// Validar opción "Envíar código"
	public void sendCode() {
		if (isDisplayed(loginTitle)) {
			type("jacquelinevmc23+01@gmail.com", email);
			click(sendCodeButton);
			click(nextButton);
		} else {
			System.out.println("The login is not displayed");
		}
		if (isDisplayed(messageLoginWithCode)) {
			System.out.println("The message 'Hemos enviado un código' is visible");
		} else {
			System.out.println("The message 'Hemos enviado un código' is not visible");
		}
		if (isDisplayed(enterCode)) {
			System.out.println("The text 'Ingresa el código' is visible");
		} else {
			System.out.println("The text 'Ingresa el código' is not visible");
		}
		WebDriverWait iwait = new WebDriverWait(driver, Duration.ofSeconds(10));
		iwait.until(ExpectedConditions.elementToBeClickable(boxCode));
		if (isDisplayed(boxCode)) {
			type("0000", boxCode);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			click(loginButtonWithCode);
			if (isDisplayed(modalCodeExpired)) {
				System.out.println("The modal 'Código expiró' is visible");
				click(buttonModalCodeExpired);
				click(backButtonWithCode);
				// driver.findElement(boxCode).clear();
			} else if (isDisplayed(modalCodeIncorrect)) {
				System.out.println("The modal 'Código incorrecto' is visible");
				click(buttonModalCodeIncorrect);
				click(backButtonWithCode);
			} else {
				System.out.println("The code is correct");
			}
		} else {
			System.out.println("The box for the code is not visible");
		}

	}

}
