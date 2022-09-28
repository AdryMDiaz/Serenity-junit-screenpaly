package starter.math;

import starter.steps.SearchWordUserSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
//import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Narrative;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
@Narrative(text={"Obtener los resultados más relevantes con base a una palabra clave en dogpile."})
public class WhenSearchWord {
	
	@Steps
    SearchWordUserSteps user;

    @Managed
    WebDriver driver;

    @Test
    public void relevantResults(){
        user.homeDogpile();

        user.searchToKeyword("rock nacional");

        user.seeResultsWithWord("rock");
    }
}