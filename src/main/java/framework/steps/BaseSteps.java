package framework.steps;

import framework.utils.Logger;
import humanize.Humanize;

public class BaseSteps {

    private static final Logger logger = Logger.getInstance();
    private static final int orderMethodInStackTrace = 2;

    protected void LogStep() {
        logger.info("\n### Step ### %s", Humanize.decamelize(Thread.currentThread().getStackTrace()[orderMethodInStackTrace].getMethodName()).toLowerCase());
    }

    protected void LogAssertion() {
        logger.info("\n### Assertion ### %s", Humanize.decamelize(Thread.currentThread().getStackTrace()[orderMethodInStackTrace].getMethodName()).toLowerCase());
    }
}
