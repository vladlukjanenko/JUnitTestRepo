package comTCL;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyInterests {

    public static final String PASSWORD_FIELD = "password-field";
    public static final String PASSWORD_FIELD_CLASS = PASSWORD_FIELD;
    public static final String EMAIL_FIELD = "email-field";
    public static final String EMAIL_FIELD1_CLASS = EMAIL_FIELD;
    public static final String EMAIL_FIELD_CLASS = EMAIL_FIELD1_CLASS;
    public static final String COOKIE_ATTR_LINK = "[href=\"#null\"]";
    public static final String LOGIN_BUTTON_LINK = "[href=\"/Login.html\"]";
    public static final String LOGIN_BOX_CLASS = "login-box";
    public static final String LOGIN_BTN_CLASS = "login-btn";
    public static final String NAVBAR_INVERSE_CLASS = "navbar-inverse";
    public static final String URL_MY_INTERESTS = "https://www.thecasuallounge.com/MyInterests.html";
    public static final String DATA_ID = "[data-id= fc8e881e-0d45-4242-8df7-c9b19e320e0a]";
    private ChromeDriver driver;
    private static final String USER_EMAIL = "anotheria.test+00@gmail.com";
    private static  final String USER_PASSWORD = "qwerty";
    public static final String URL_TCL = "https://www.thecasuallounge.com";
    private static final String CHROME_DRIVER_PATH = "c://chromedriver.exe";

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
        driver = new ChromeDriver();
    }

    @Test
    public void pictureUpload() {
        System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);

        driver.get(URL_TCL);
        driver.findElement(By.cssSelector(COOKIE_ATTR_LINK)).click();
        driver.findElement(By.cssSelector(LOGIN_BUTTON_LINK)).click();

        WebElement emailInput = driver.findElement(By.className(LOGIN_BOX_CLASS));
        emailInput.findElement(By.className(EMAIL_FIELD_CLASS)).sendKeys(USER_EMAIL);
        emailInput.findElement(By.className(PASSWORD_FIELD_CLASS)).sendKeys(USER_PASSWORD);
        driver.findElement(By.className(LOGIN_BTN_CLASS)).click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        /*WebElement navBar = driver.findElementByClassName(NAVBAR_INVERSE_CLASS);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(navBar));*/

        driver.get(URL_MY_INTERESTS);
        driver.findElementByCssSelector(DATA_ID).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @After
    public void closeDriver() {
        //driver.close();
    }
}
