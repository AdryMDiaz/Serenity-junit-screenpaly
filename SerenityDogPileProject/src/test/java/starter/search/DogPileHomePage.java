package starter.search;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://www.dogpile.com/")
public class DogPileHomePage extends PageObject{
	
	@FindBy(id = "q")
    WebElementFacade searchLocator;

    @FindBy(xpath = "//div[contains(text(),'Go Fetch')]")
    WebElementFacade btnSearchLocator;

	public void enterKeyWord(String palabraClave) {
		searchLocator.type(palabraClave);
    }

    public void toSearch() {
    	btnSearchLocator.click();
    }
}
