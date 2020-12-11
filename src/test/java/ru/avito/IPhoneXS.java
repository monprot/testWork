package ru.avito;

import lombok.extern.log4j.Log4j;
import org.testng.annotations.Test;
import pages.AdsPage;
import pages.MainPage;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Log4j
public class IPhoneXS extends Settings {
    @Test
    public void iPhoneXS() {
        log.info("Открытие Авито");
        getDriver().get("https://avito.ru/");
        MainPage mainPage = new MainPage(getDriver());
        AdsPage adsPage = new AdsPage(getDriver());
        log.info("Конфигурация поиска");
        mainPage.clickCBImagesOnly();
        mainPage.setInputSearch("iphone xs 256 gb -max");
        mainPage.clickListRegion();
        mainPage.setInputLocation("Москва");
        mainPage.clickSuggestLocation();
        log.info("Поиск по заданным параметрам");
        mainPage.clickBtnSaveLocation();
        log.info("Сортировка результатов по дате");
        adsPage.clickSelectSortByDate();

        log.info("Создание тектового файла с ссылками на объявления");
        LocalDateTime localDateTime = LocalDateTime.now();
        String dateTime = localDateTime.format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH mm"));
        try {
            try (FileWriter writer = new FileWriter("IPhones XS 256gb " + dateTime + ".txt", false)) {
                for (String s : adsPage.getAdsLinkText("iphone_xs_256", 10)) {
                    writer.write(s);
                    writer.append('\n');
                }
                writer.flush();
            }
        } catch (IOException ex) {

            log.error(ex.getMessage());
        }

    }

}
