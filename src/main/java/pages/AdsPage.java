package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import selBase.Base;

import java.util.*;

public class AdsPage extends Base {
    @FindBy(xpath = "//*[text()=\"По дате\"]")
    private WebElement selectSortByDate;

    public AdsPage(WebDriver driver) {
        super(driver);
    }

    public void clickSelectSortByDate() {
        click(selectSortByDate);
    }

    public List<String> getAdsLinkText(String xpath) {
        List<String> linkTexts = new ArrayList<>();
        List<WebElement> linkElements = getDriver().findElements(By.xpath(xpath));
        List<WebElement> adsPrice = getDriver().findElements(By.xpath
                (xpath+"/../following-sibling::div//meta[@itemprop=\"price\"]"));
        int size;
        if (linkElements.size() > 10) size = 10;
        else size = linkElements.size();

            for (int i = 0; i < size; i++) {
                String linkText = adsPrice.get(i).getAttribute("content")
                        + "  " + linkElements.get(i).getAttribute("href");
                linkTexts.add(linkText);
            }

        Collections.sort(linkTexts);
        return linkTexts;
    }
}