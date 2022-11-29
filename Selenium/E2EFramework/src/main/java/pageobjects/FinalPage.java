package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractComponent.AbstractComponent;

public class FinalPage extends AbstractComponent {

	WebDriver driver;

	public FinalPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(css = ".hero-primary")
	WebElement gettext;

	By text = By.cssSelector(".hero-primary");

	public String getText() {

		waitforTextToAppear(text);
		return gettext.getText();

	}

}
