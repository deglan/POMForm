package form;

import POP.form.FormPOP;
import lombok.AllArgsConstructor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Instant;
import java.util.List;
import java.util.Random;

@AllArgsConstructor
public class FillForm {

    private final FormPOP formPOP;

    public void fillForm(WebDriverWait wait) {

        formPOP.setUserLastname("Kowalski")
                .setUserEmail("jan.kowalski@example.com")
                .setUserName("Jan")
                .setSexCheckBoxes(getRandomIndex(formPOP.getSexCheckBoxes()))
                .setUserAge("30")
                .setExpCheckBoxes(getRandomIndex(formPOP.getExpCheckBoxes()))
                .setProfCheckBoxes(getRandomIndex(formPOP.getProfCheckBoxes()));
        wait.until(ExpectedConditions.elementToBeClickable(formPOP.getCountries()));
        formPOP.setCountries(getRandomIndexSkipOneRow(formPOP.getCountriesDropdown()));
        wait.until(ExpectedConditions.elementToBeClickable(formPOP.getCommands()));
        formPOP.setCommands(getRandomIndex(formPOP.getCommandsDropdown()));
        selectFile();
        formPOP.clickSubmitButton();
    }




    private void selectFile() {
        File file = new File("src/test/resources/test.txt");
        formPOP.getFile().sendKeys(file.getAbsolutePath());
    }

    private static int getRandomIndex(List<WebElement> elements) {
        return new Random().nextInt(elements.size());
    }

    private static int getRandomIndexSkipOneRow(List<WebElement> elements) {
        return new Random().nextInt(1,elements.size());
    }
}
