package pagePackage;

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
	By buttonAttachedFile = By.xpath("//*[@id=\"__next\"]/div/div/div/div/main/div/div/section/div/div[3]/div/button");
	By textDragHere = By.xpath("//*[@id=\"__next\"]/div/div/div/div/main/div/div/section/div/div[3]/div/p[1]");
	By textAllowPDForWORD = By.xpath("//*[@id=\"__next\"]/div/div/div/div/main/div/div/section/div/div[3]/div/p[2]");
	By textFileAttached = By.xpath("//*[@id=\"__next\"]/div/div/div/div/main/div/div/section/div/div[4]/p[1]");
	By textReplaceFile = By.xpath("//*[@id=\"__next\"]/div/div/div/div/main/div/div/section/div/p");
	By buttonSave = By.xpath("//*[@id=\"__next\"]/div/div/div/div/main/div/div/section/div/div[5]/button");

	// Estos son los Métodos:

	// Validar arrow dropdown en el header
	public void displayedArrowDropdown() {
		isDisplayed(arrowDropdown);
	}

	// Hacer clic en "Editar HV"
	public void sectionEditCV() {
		if (isDisplayed(arrowDropdown)) {
			click(arrowDropdown);
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Editar hoja de vida']")));
			click(optionEditCV);
			
		}
	}
	
	// Validar ingreso a sección "Editar hoja de vida"
	public boolean sectionEditHVSuccess() {
		return isDisplayed(textWelcome);
	}

	// Validar elementos visibles en sección "Editar HV"
	public void displayedElementsEditCV() {
		isDisplayed(textAttachedCV);
		isDisplayed(buttonAttachedFile);
		isDisplayed(textDragHere);
		isDisplayed(textAllowPDForWORD);
		isDisplayed(textFileAttached);
		isDisplayed(textReplaceFile);
		isDisplayed(buttonSave);

	}
}
