package ru.avito;

import org.testng.annotations.Test;
import pages.AdsPage;
import pages.MainPage;

import java.io.FileWriter;
import java.io.IOException;

public class IPhoneXS extends Settings {
    @Test
    public void iPhoneXS() {
        getDriver().get("https://avito.ru/");
        MainPage mainPage = new MainPage(getDriver());
        AdsPage adsPage = new AdsPage(getDriver());
        mainPage.clickCBImagesOnly();
        mainPage.setInputSearch("iphone xs 256 gb -max");
        mainPage.clickListRegion();
        mainPage.setInputLocation("Москва");
        mainPage.clickSuggestLocation();
        mainPage.clickBtnSaveLocation();
        adsPage.clickSelectSortByDate();


        try(FileWriter writer = new FileWriter("Iphones XS 256gb from Avito.txt", false))
        {
            for (String s : adsPage.getAdsLinkText
                    ("//a[contains(@href,\"iphone_xs_256\") and @data-marker=\"item-title\" ]")){
                writer.write(s);
                writer.append('\n');
            }
            writer.flush();
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }

    }

}
