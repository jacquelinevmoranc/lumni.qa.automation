package pagePackage;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import basePage.Base;

public class EditCVLumni extends Base {

	public EditCVLumni(WebDriver driver) {
		super(driver);
	}

	// Atributos
	By arrowDropdown = By.xpath("//header/div[2]/div[3]/button[1]/*[1]");
	By optionEditCV = By.xpath("//a[text()='Editar hoja de vida']");
	By textWelcome = By.xpath("//*[@id=\"__next\"]/div/div/div/div/main/div/div/section/div/div[1]");
	By textAttachedCV = By.xpath("//*[@id=\"__next\"]/div/div/div/div/main/div/div/section/div/div[2]/p");
	By buttonAttachedFile = By.xpath("//input[@type='file']");
	By buttonChangeFile = By.xpath("//*[@id=\"__next\"]/div/div/div/div/main/div/div/section/div/div[3]/div/button");
	By textDragHere = By.xpath("//*[@id=\"__next\"]/div/div/div/div/main/div/div/section/div/div[3]/div/p[1]");
	By textAllowPDForWORD = By.xpath("//*[@id=\"__next\"]/div/div/div/div/main/div/div/section/div/div[3]/div/p[2]");
	By textFileAttached = By.xpath("//*[@id=\"__next\"]/div/div/div/div/main/div/div/section/div/div[4]/p[1]");
	By textReplaceFile = By.xpath("//*[@id=\"__next\"]/div/div/div/div/main/div/div/section/div/p");
	By buttonSave = By.xpath("//*[@id=\"__next\"]/div/div/div/div/main/div/div/section/div/div[5]/button");
	By nameFileAttached = By.xpath("//p[text()='platzi_joha.pdf']");

	// Estos son los Métodos:

	// Validar arrow dropdown en el header
	public void displayedArrowDropdown() {
		isDisplayed(arrowDropdown);
	}

	// Hacer clic en "Editar HV"
	public void sectionEditCV() {
		if (isDisplayed(arrowDropdown)) {
			click(arrowDropdown);
			WebDriverWait await = new WebDriverWait(driver, Duration.ofSeconds(10));
			await.until(ExpectedConditions.elementToBeClickable(optionEditCV));
			click(optionEditCV);

		}
	}

	// Validar ingreso a sección "Editar hoja de vida"
	public boolean sectionEditHVSuccess() {
		return isDisplayed(textWelcome);
	}

	// Validar elementos visibles en sección "Editar HV"
	public void displayedElementsEditCV() {
		if (driver.findElement(textAttachedCV).isDisplayed()) {
			System.out.println("The principal message is displayed");
		} else {
			System.out.println("The principal message is not displayed");
		}
		
		if (driver.findElement(buttonAttachedFile).isDisplayed()) {
			System.out.println("The button 'Subir archivo' is displayed");
		} else {
			System.out.println("The button 'Subir archivo' is not displayed");
		}
		
		if (driver.findElement(textDragHere).isDisplayed()) {
			System.out.println("The message 'Arrástralo' is displayed");
		} else {
			System.out.println("The message 'Arrástralo' is not displayed");
		}
		
		if (driver.findElement(textAllowPDForWORD).isDisplayed()) {
			System.out.println("The message 'PDF o Word' is displayed");
		} else {
			System.out.println("The message 'PDF o Word' is not displayed");
		}
		
		if (driver.findElement(textFileAttached).isDisplayed()) {
			System.out.println("The message 'Archivo adjunto' is displayed");
		} else {
			System.out.println("The message 'Archivo adjunto' is not displayed");
		}
		
		if (driver.findElement(textReplaceFile).isDisplayed()) {
			System.out.println("The message 'Para cambiar este archivo' is displayed");
		} else {
			System.out.println("The message 'Para cambiar este archivo' is not displayed");
		}
		
		if (driver.findElement(buttonSave).isDisplayed()) {
			System.out.println("The button 'Guardar' is displayed");
		} else {
			System.out.println("The button 'Guardar' is not displayed");
		}

	}

	// Subir archivo en "Editar HV"
	public void uploadCV() {
		
		String file = "C:\\Users\\jacqu\\Downloads\\platzi_joha.pdf";
		driver.findElement(buttonAttachedFile).sendKeys(file);
		if (isDisplayed(buttonChangeFile)) {
			click(buttonSave);
			System.out.println("The file was changed");
		} else {
			System.out.println("The file is not allowed");
		}
		String text = driver.findElement(nameFileAttached).getText();
		assertEquals("platzi_joha.pdf", text);
	}
}
