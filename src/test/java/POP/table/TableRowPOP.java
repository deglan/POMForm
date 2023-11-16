package POP.table;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;

public class TableRowPOP {

    public TableRowPOP(WebElement parent) {
        PageFactory.initElements(new DefaultElementLocatorFactory(parent),this);
    }

    @FindBy(css = "th")
    private WebElement rank;
    @FindBy(xpath = "./td[1]")
    private WebElement peak;
    @FindBy(xpath = "./td[2]")
    private WebElement mountainRange;
    @FindBy(xpath = "./td[3]")
    private WebElement state;
    @FindBy(xpath = "./td[4]")
    private WebElement height;

    public int getHeight() {
        return Integer.parseInt(height.getText());
    }

    public String getName() {
        return peak.getText();
    }

    public String getMountainRange() {
        return mountainRange.getText();
    }

    public String getState() {
        return state.getText();
    }
}
