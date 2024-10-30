/* Actualmente no se puede interactuar con este módulo
500 Internal Server Error
If you are the administrator of this website, then please read this web 
application's log file and/or the web server's log file to find out what went wrong.
 */

package pagePackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import basePage.Base;

public class PaymentsLumni extends Base {

	// Constructor
	public PaymentsLumni(WebDriver driver) {
		super(driver);
	}

	// Atributos
	By paymentsButton = By.xpath("//*[@id=\"layout-sidenav\"]/ul/li[2]/a");
	By titleCollectionDocument = By.xpath("/html/body/div[3]/div/div/div[2]/div/div[2]/div[1]/h4");
	By timelyPaymentDate = By.xpath(
			"/html/body/div[3]/div/div/div[2]/div/div[2]/div[1]/div[1]/div/div[1]/div[1]/table/tbody/tr[1]/td[1]");
	By documentValue = By
			.xpath("/html/body/div[3]/div/div/div[2]/div/div/div[1]/div[1]/div/div[1]/div[1]/table/tbody/tr[2]/td[1]");
	By payButton = By.xpath("/html/body/div[3]/div/div/div[2]/div/div/div[1]/div[1]/div/div[2]/div/button");

	// Estos son los Métodos:

	// Cambio a sección "Pagos"
	public boolean sectionPayments() {
		click(paymentsButton);
		return isDisplayed(titleCollectionDocument);
	}

	// Validar elementos visibles
	public void sectionPaymentsDisplayed() {
		isDisplayed(timelyPaymentDate);
		isDisplayed(documentValue);
		isDisplayed(payButton);
	}

}
