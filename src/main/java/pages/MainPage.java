package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import selBase.Base;

/**
 * Авито. Главная страница
 */
public class MainPage extends Base {

    @FindBy(id = "search")
    private WebElement inputSearch;

    @FindBy(xpath = "//span[text()='только с фото']")
    private WebElement checkBoxImagesOnly;

    @FindBy(xpath = "//*[@data-marker=\"search-form/region\"]")
    private WebElement listRegion;

    @FindBy(xpath = "//*[@data-marker=\"popup-location/region/input\"]")
    private WebElement inputLocation;

    @FindBy(xpath = "//ul[@data-marker=\"suggest-list\"]//*[text()=\"Москва\"]")
    private WebElement suggestLocation;

    @FindBy(xpath = "//*[@data-marker=\"popup-location/save-button\"]")
    private WebElement btnSaveLocation;


    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void setInputSearch(String text) {
        setText(inputSearch, text);
    }

    public void clickCBImagesOnly() {
        click(checkBoxImagesOnly);
    }

    public void clickListRegion() {
        click(listRegion);
    }

    public void setInputLocation(String text) {
        setText(inputLocation, text);
    }

    public void clickSuggestLocation() {
        click(suggestLocation);
    }

    public void clickBtnSaveLocation() {
        click(btnSaveLocation);
    }

}
