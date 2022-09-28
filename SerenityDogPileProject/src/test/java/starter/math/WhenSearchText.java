package starter.math;

import starter.steps.SearchTextUserSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
//import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Narrative;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;


//@ExtendWith(SerenityJUnit5Extension.class)
@RunWith(SerenityRunner.class)
@Narrative(text={"Obtener los resultados más relevantes con base a una palabra clave en dogpile."})
public class WhenSearchText {
	
	@Steps
    SearchTextUserSteps users;

    @Managed
    WebDriver driver;

	@Test
    public void result_contains_correct_text(){
        users.homeDogpile();

        users.searchToKeyword("rock nacional");

        users.should_see_title_result_with_correct_text("Argentine rock - Wikipedia",
                "Argentine rock (known locally as rock nacional");
    }
}
