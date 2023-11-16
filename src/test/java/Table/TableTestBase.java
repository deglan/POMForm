package Table;

import POP.table.TablePOP;
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
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TableTestBase {

    WebDriver driver;
    TableCheck tableCheck;
    TablePOP tablePOP;

    @BeforeAll
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void driverSetUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        driver.get("http://automation-practice.emilos.pl/table.php");
        tableCheck = new TableCheck(driver);
        tablePOP = new TablePOP(driver);
    }

    @AfterEach
    public void closeDriver() {
        driver.quit();
    }
}
