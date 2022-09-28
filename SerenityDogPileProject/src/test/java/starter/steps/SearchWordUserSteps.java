package starter.steps;

import starter.search.DogPileHomePage;
import starter.search.DogPilePageResults;
import net.thucydides.core.annotations.Step;
import org.hamcrest.Matchers;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

import java.util.List;

public class SearchWordUserSteps {

	String actor;
	
	DogPileHomePage homePage;
	DogPilePageResults pageResults;
	
	@Step("#actor ingresa a la pagina principal de dogpile")
    public void homeDogpile() {
		homePage.open();
    }

    @Step("#actor realiza una búsqueda de: {0}")
    public void searchToKeyword(String palabraClave) {
    	homePage.enterKeyWord(palabraClave);
    	homePage.toSearch();
    }

    @Step("#actor deberia poder ver resultados que contengan la palabra {0}")
	public void seeResultsWithWord(String palabraEsperada) {
    	List<String> resultados = pageResults.obtenerResultados();
        resultados.replaceAll(String::toLowerCase);
        for (int i = 0; i < resultados.size(); i++) {
            System.out.println(resultados.get(i));
        }
        assertThat(resultados, Matchers.everyItem(containsString(palabraEsperada)));
    }
}

