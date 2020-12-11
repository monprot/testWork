package selBase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base {
    protected final int driverWaitTime = 20;
    private final WebDriver driver;

    public Base(final WebDriver driver) {
        PageFactory.initElements(driver, this);

        this.driver = driver;
    }

    public WebDriver getDriver() {
        return driver;
    }

    /**
     * Ждем пока элемент отобразится на странице.
     *
     * @param element WebElement
     * @return Метод возвращает Boolean.
     */
    protected boolean waitVisibilityOfElement(final WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, driverWaitTime);
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Метод ждет пока элемент появится на странице.
     * Затем вводит текст в поле webElement.
     *
     * @param webElement WebElement
     * @param string     текст
     */
    protected void setText(final WebElement webElement, final String string) {
        waitVisibilityOfElement(webElement);

        webElement.sendKeys(string);

    }

    /**
     * Метод ждет пока элемент появится на странице.
     * Затем кликает по этому элементу.
     *
     * @param webElement WebElement
     */
    protected void click(final WebElement webElement) {

        waitVisibilityOfElement(webElement);

        webElement.click();

    }

}
