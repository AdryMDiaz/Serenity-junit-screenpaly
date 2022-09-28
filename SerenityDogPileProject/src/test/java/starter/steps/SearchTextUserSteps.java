package starter.steps;

import starter.search.DogPileHomePage;
import starter.search.DogPilePageResults;
import net.thucydides.core.annotations.Step;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;


public class SearchTextUserSteps {

	String actor;
	
	DogPileHomePage homePage;
	DogPilePageResults resultsPage;
	
	@Step("#actor ingresa a la pagina principal de dogpile")
    public void homeDogpile() {
		homePage.open();
    }

    @Step("#actor realiza una búsqueda de: {0}")
    public void searchToKeyword(String palabraClave) {
    	homePage.enterKeyWord(palabraClave);
    	homePage.toSearch();
    }


    @Step("#actor deberia ver el texto esperado: {1} en el resutado del titulo: {0}")
    public void should_see_title_result_with_correct_text(String tituloDeResultado, String textoDeResultadoEsperado) {
        String texto = resultsPage.obtenerTextoDeTituloResultado(tituloDeResultado);
        System.out.println(texto);
        System.out.println(textoDeResultadoEsperado);
        assertThat(texto, containsString(textoDeResultadoEsperado));
    }
}
