package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	static WebDriver driver;
	public LoginPage(WebDriver dr) {
		this.driver=dr;
		PageFactory.initElements(driver, this);
	}
}
//*[@id="mainPageContent"]/descendant::ul/child::li/following-sibling::ul/descendant::a/following::ul/descendant::li/child::a[@href='/b-cars-vehicles/mississauga-peel-region/c27l1700276']