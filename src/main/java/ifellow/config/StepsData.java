package ifellow.config;

import ifellow.pages.*;
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Getter
abstract public class StepsData {
    private final AuthorizationPage authorization = new AuthorizationPage();
    private final DashboardPage dashboard = new DashboardPage();
    private final ProjectPage project = new ProjectPage();
    private final TaskSeleniumPage taskSelenium = new TaskSeleniumPage();
    private final BugRepoPage bugRepo = new BugRepoPage();
    private final CloseTaskPage closeTask = new CloseTaskPage();
    public static final Logger log = LoggerFactory.getLogger(StepsData.class);
}
