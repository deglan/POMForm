package POP.table;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.stream.Collectors;


public class TablePOP {

    public TablePOP(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "tbody tr")
    private List<WebElement> rows;

    public List<TableRowPOP> getRows() {
        return rows.stream()
                .map(TableRowPOP::new)
                .collect(Collectors.toList());
    }

    public List<String> getMountainHigherThan(int expectedHeight) {
        return getRows().stream()
                .filter(tableRowPOP -> tableRowPOP.getHeight() > expectedHeight)
                .map(TableRowPOP::getName)
                .collect(Collectors.toList());
    }
}
