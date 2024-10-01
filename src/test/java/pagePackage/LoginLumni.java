package pagePackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import basePage.Base;

public class LoginLumni extends Base {

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
	By backButton = By.xpath(
			"//*[@id=\"__next\"]/div/div/div/div[2]/div/section/div/div[2]/div/div[3]/div/div[1]/div[2]/div/div[1]/button/svg");
	By forgotPassword = By
			.xpath("//*[@id=\"__next\"]/div/div/div/div[2]/div/section/div/div[2]/div/div[3]/div/div[2]/a/span");
	By loginButton = By.xpath("//*[@id=\"__next\"]/div/div/div/div[2]/div/section/div/div[2]/div/div[3]/div/div[1]/div[2]/div/div[2]/button");
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
			type("jacquelinevmc23+0804codeable@gmail.com", email);
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"radio-group-loginType-id-1\"]")));
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
			System.out.println("The button 'Siguiente' is disabled");
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
				System.out.println("The button 'Iniciar sesión' is disabled");
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
				System.out.println("The message is displayed");
			} else {
				System.out.println("The message is not displayed");
			}

		}

	}
}
