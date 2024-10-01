package basePage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {
	//Declarar un objeto de tipo WebDriver
	
	//Atributo puede ser un objeto también
	public WebDriver driver;
	
	//Declarar el CONSTRUCTOR de nuestra clase base 
	
	//El constructor debe tener el mismo nombre de la clase que es "Base"
	public Base(WebDriver driver) {
		
		// "driver" debe tener el mismo nombre del "ATRIBUTO" que se creó arriba.
		this.driver = driver;
	}
	
	//Creando los MÉTODOS que vamos a utilizar en la clase Objeto
	
	//MÉTODO QUE REALIZA LA CONEXIÓN CON CHROMEDRIVER
	public WebDriver chromeDriverConnection() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\jacqu\\eclipse-workspace\\lumni.qa.automation\\src\\test\\resources\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		//Si no se coloca este return muestra error
		return driver;
	}
	
	//MÉTODO PARA ENCONTRAR Y CAPSULAR LOS ELEMENTOS
	public void findElement(By locator) {
		// LOS VOID NO NECESITAN UN RETURN
		driver.findElement(locator);
		
	}
	
	//SOBRECARGA DEL MÉTODO "findElement"
	public WebElement findAndReturnElement(By locator) {
		return driver.findElement(locator);
	}
	
	// Para hacer clic en un elemento
	public void click(By locator) {
		driver.findElement(locator).click();
	}
	
	//Esto es para los dropdowns y listas
	public List<WebElement> findElements(By locator){
		return driver.findElements(locator);
	}
	
	//Esto es para escribir texto
	public void type(String inputText, By locator) {
		driver.findElement(locator).sendKeys(inputText);
	}
	
	public String getText(WebElement element) {
		return element.getText();
	}
	
	public String getText(By locator) {
		return driver.findElement(locator).getText();
	}
	
	// Para validar si una página es visible
	public Boolean isDisplayed(By locator) {
		try {
			return driver.findElement(locator).isDisplayed();
		} catch (org.openqa.selenium.NoSuchElementException e) {
			return false;
		}
		 
	}
	
	//Para visitar una página
	public void visit(String url) {
		driver.get(url);
	}
	
	
}