package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver;

    @FindBy(css = "input#username")
    private WebElement userNameField;
    @FindBy(css = "input#password")
    private WebElement userPasswordField;
    @FindBy(css = "button#submit")
    private WebElement submitButton;
    @FindBy(css = "div#error")
    private WebElement errorToaster;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public LoginPage enterUserName(String userName){
        userNameField.sendKeys(userName);
        return this;
    }

    public LoginPage enterUserPassword(String password){
        userPasswordField.sendKeys(password);
        return this;
    }

    public LoginPage clickSubmitButton(){
        submitButton.click();
        return this;
    }

    public boolean checkIfErrorToasterDisplayed(){
        return errorToaster.getText().equals("Your username is invalid!");
    }
}
