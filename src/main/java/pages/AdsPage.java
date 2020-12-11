package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import selBase.Base;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Авито. Страница с результатами поиска
 */
public class AdsPage extends Base {
    @FindBy(xpath = "//*[text()=\"По дате\"]")
    private WebElement selectSortByDate;

    public AdsPage(WebDriver driver) {
        super(driver);
    }

    public void clickSelectSortByDate() {
        click(selectSortByDate);
    }


    /**
     * Возвращает цен и ссылок соотвутствующих объявлений отсортированных по возрастанию цены
     *
     * @param item   часть ссылки на объявление
     * @param amount кол-во объявлений
     * @return List<String>
     */
    public List<String> getAdsLinkText(String item, int amount) {
        List<String> priceAndLinkTexts = new ArrayList<>();

        List<WebElement> adsLink = getDriver().findElements
                (By.xpath("//a[contains(@href,\"" + item + "\") and @data-marker=\"item-title\" ]"));

        List<WebElement> adsPrice = getDriver().findElements
                (By.xpath("//a[contains(@href,\"" + item + "\") and @data-marker=\"item-title\" ]"
                        + "/../following-sibling::div//meta[@itemprop=\"price\"]"));

        int size = Math.min(adsLink.size(), amount);

        for (int i = 0; i < size; i++) {
            String linkText = adsPrice.get(i).getAttribute("content")
                    + "  " + adsLink.get(i).getAttribute("href");
            priceAndLinkTexts.add(linkText);
        }

        Collections.sort(priceAndLinkTexts);
        return priceAndLinkTexts;
    }
}