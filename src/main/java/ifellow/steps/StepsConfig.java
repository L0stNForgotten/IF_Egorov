package ifellow.steps;

import ifellow.pages.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

abstract class StepsConfig {
    protected final AuthorizationPage authorization = new AuthorizationPage();
    protected final DashboardPage dashboard = new DashboardPage();
    protected final ProjectPage project = new ProjectPage();
    protected final TaskSeleniumPage taskSelenium = new TaskSeleniumPage();
    protected final BugRepoPage bugRepo = new BugRepoPage();
    protected final CloseTaskPage closeTask = new CloseTaskPage();
    public static final Logger log = LoggerFactory.getLogger(StepsConfig.class);
}
