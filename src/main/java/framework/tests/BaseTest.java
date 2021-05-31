package framework.tests;

import framework.drivers.BrowserFactory;
import framework.utils.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;

public class BaseTest {

    private static final Logger logger = Logger.getInstance();
    protected final BrowserFactory browserFactory = new BrowserFactory();

    @BeforeEach
    public void setUpBrowser(TestInfo testInfo){
        logger.info("Start scenario " + testInfo.getDisplayName());
        BrowserFactory.setUrl(browserFactory.getDriver());
    }

    @AfterEach
    public void tearDown(TestInfo testInfo) {
        logger.info("Finish test scenario " + testInfo.getDisplayName());
        BrowserFactory.closeBrowser(browserFactory.getDriver());
    }
}
