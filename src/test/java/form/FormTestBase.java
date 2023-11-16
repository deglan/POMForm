package form;

import POP.form.FormPOP;
import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FormTestBase {

    WebDriver driver;
    FormPOP formPOP;
    FillForm fillFrom;
    WebDriverWait wait;

    @BeforeAll
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void driverSetUp() {
        ChromeOptions options = new ChromeOptions();
        //options.addArguments("--headless");
        driver = new ChromeDriver(options);
        driver.get("http://www.seleniumui.moderntester.pl/form.php");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        formPOP = new FormPOP(driver);
        fillFrom = new FillForm(formPOP);
    }


    @AfterEach
    public void closeDriver() {
        driver.quit();
    }
}
