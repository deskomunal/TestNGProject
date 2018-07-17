package TestDemo.PageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WellcomePage {
    @FindBy(css = ".shelf-title")
    private WebElement labelpage;

    public String getLabel(){
       return labelpage.getText();
    }
}
