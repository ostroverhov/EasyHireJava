package framework.drivers;

import framework.utils.ConfigReader;
import framework.utils.Logger;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

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
        Logger.getInstance().info("Browser [%s] init", ConfigReader.getParameter("Browser"));
        switch (ConfigReader.getParameter("Browser")) {
            case "chrome" -> {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            }
            case "firefox" -> {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            }
        }
        return driver;
    }

    public static void closeBrowser(WebDriver driver) {
        logger.info("Close browser");
        driver.quit();
    }

    public static void setImplicitlyWait(WebDriver driver) {
        logger.info("Set implicitly wait [%s]", ConfigReader.getParameter("ImplicitlyWait"));
        driver.manage().timeouts().implicitlyWait(Integer.parseInt(ConfigReader.getParameter("ImplicitlyWait")), TimeUnit.SECONDS);
    }

    public static void setMaxSizeWindow(WebDriver driver) {
        logger.info("Set max size window");
        driver.manage().window().maximize();
    }

    public static void setUrl(WebDriver driver) {
        logger.info("Set URL [%s]", ConfigReader.getParameter("Url"));
        driver.get(ConfigReader.getParameter("Url"));
    }
}
