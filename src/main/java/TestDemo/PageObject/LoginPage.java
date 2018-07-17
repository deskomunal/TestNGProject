package TestDemo.PageObject;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
    @FindBy(id = "login_field")
    private WebElement usernameTextField;

    @FindBy(id = "password")
    private WebElement passwordTextField;

    @FindBy(css="input.btn.btn-primary")
    private WebElement singupButton;

    public void setUsername(String email) {
        usernameTextField.clear();
        usernameTextField.sendKeys(email);
        usernameTextField.sendKeys(Keys.TAB);
    }

    public void setPassword(String password){
        passwordTextField.clear();
        passwordTextField.sendKeys(password);
        passwordTextField.sendKeys(Keys.TAB);
    }

    public void clickSingup(){
        singupButton.click();
    }
}
