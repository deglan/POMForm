package form;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;

public class FormTest extends FormTestBase {

    @RepeatedTest(10)
    public void shouldFillFormWithSuccess() {
        fillFrom.fillForm(wait);

        Assertions.assertThat(formPOP.getSuccessMessage()).isEqualTo("Form send with success");
    }

}
