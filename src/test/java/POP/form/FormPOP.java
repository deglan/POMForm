package POP.form;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;


@Getter
@AllArgsConstructor
@RequiredArgsConstructor
public class FormPOP {

    public FormPOP(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#inputFirstName3")
    private WebElement userName;
    @FindBy(css = "#inputLastName3")
    private WebElement userLastname;
    @FindBy(css = "#inputEmail3")
    private WebElement userEmail;
    @FindBy(css = "[name='gridRadiosSex']")
    private List<WebElement> sexCheckBoxes;
    @FindBy(css = "#inputAge3")
    private WebElement userAge;
    @FindBy(css = "[name='gridRadiosExperience']")
    private List<WebElement> expCheckBoxes;
    @FindBy(css = "[name='gridCheckboxProfession']")
    private List<WebElement> profCheckBoxes;
    @FindBy(id = "selectContinents")
    private WebElement countries;
    @FindBy(id = "selectSeleniumCommands")
    private WebElement commands;
    @FindBy(xpath = "//button")
    private WebElement submitButton;
    @FindBy(id = "chooseFile")
    private WebElement file;
    @FindBy(id = "validator-message")
    private WebElement successMessage;

    public FormPOP setUserName(String name) {
        userName.sendKeys(name);
        return this;
    }

    public FormPOP setUserLastname(String lastname) {
        userLastname.sendKeys(lastname);
        return this;
    }

    public FormPOP setUserEmail(String email) {
        userEmail.sendKeys(email);
        return this;
    }

    public FormPOP setSexCheckBoxes(int index) {
        sexCheckBoxes.get(index).click();
        return this;
    }

    public FormPOP setUserAge(String age) {
        userAge.sendKeys(age);
        return this;
    }

    public FormPOP setExpCheckBoxes(int index) {
        expCheckBoxes.get(index).click();
        return this;
    }

    public FormPOP setProfCheckBoxes(int index) {
        profCheckBoxes.get(index).click();
        return this;
    }

    public FormPOP setCountries(int index) {
        Select countriesElement = new Select(countries);
        countriesElement.selectByIndex(index);
        return this;
    }

    public List<WebElement> getCountriesDropdown() {
        Select countriesElement = new Select(countries);
        return countriesElement.getOptions();

    }

    public FormPOP setCommands(int index) {
        Select commandsElement = new Select(commands);
        commandsElement.selectByIndex(index);
        return this;
    }

    public List<WebElement> getCommandsDropdown() {
        Select commandsElement = new Select(commands);
        return commandsElement.getOptions();

    }

    public FormPOP clickSubmitButton() {
        submitButton.click();
        return this;
    }

    public String getSuccessMessage() {
        return successMessage.getText();
    }
}
