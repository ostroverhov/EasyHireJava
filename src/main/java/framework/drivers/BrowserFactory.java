package framework.drivers;

import framework.utils.ConfigReader;
import framework.utils.Logger;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {

    private static final Logger logger = Logger.getInstance();
    private final WebDriver driver;

    public BrowserFactory() {
        driver = initBrowser();
    }

    public WebDriver getDriver() {
        return driver;
    }

    private WebDriver initBrowser() {
        WebDriver driver = null;
        var browser = System.getenv("browser") == null ? ConfigReader.getParameter("Browser") : System.getenv("browser");
        Logger.getInstance().info("Browser [%s] init", browser);
        switch (browser) {
            case "chrome" -> {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            }
            case "firefox" -> {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            }
        }
        assert driver != null;
        driver.manage().window().setSize(new Dimension(1920, 1080));
        return driver;
    }

    public static void closeBrowser(WebDriver driver) {
        logger.info("Close browser");
        driver.quit();
    }

    public static void setUrl(WebDriver driver) {
        logger.info("Set URL [%s]", ConfigReader.getParameter("Url"));
        driver.get(ConfigReader.getParameter("Url"));
    }
}
