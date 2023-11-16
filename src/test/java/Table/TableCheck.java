package Table;

import POP.table.TablePOP;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class TableCheck {

    private TablePOP tablePOP;

    public TableCheck(WebDriver driver) {
        this.tablePOP = new TablePOP(driver);
    }

    public void checkTableWithSwitzerlandAndHeight() {
        List<String> mountainInfo = tablePOP.getRows().stream()
                .filter(row -> row.getState().contains("Switzerland"))
                .filter(row -> row.getHeight() > 4000)
                .map(row -> String.format("Peak: %s, Mountain range: %s, Height: %d",
                        row.getName(), row.getMountainRange(), row.getHeight()))
                .toList();

        mountainInfo.forEach(System.out::println);
        Assertions.assertThat(mountainInfo.size()).isGreaterThan(0);
    }
}

