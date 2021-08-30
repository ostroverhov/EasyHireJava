package framework.drivers;

import framework.utils.ConfigReader;
import framework.utils.Logger;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

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
                try {
                    driver = Boolean.parseBoolean(ConfigReader.getParameter("IsRemote"))
                            ? new RemoteWebDriver(new URL(ConfigReader.getParameter("RemoteUrl")), DesiredCapabilities.chrome())
                            : new ChromeDriver();
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }
            case "firefox" -> {
                WebDriverManager.firefoxdriver().setup();
                try {
                    driver = Boolean.parseBoolean(ConfigReader.getParameter("IsRemote"))
                            ? new RemoteWebDriver(new URL(ConfigReader.getParameter("RemoteUrl")), DesiredCapabilities.firefox())
                            : new FirefoxDriver();
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }
        }
        assert driver != null;
        driver.manage().window().maximize();
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
