package ifellow.hooks;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SetUpHook {
    private static final Logger log = LoggerFactory.getLogger(SetUpHook.class);
    @BeforeAll
    public void innit () { log.info("Start of test case."); }
    @After
    public void endOfTests() { log.info("Test end."); }
    @AfterAll
    public static void endOfTestCase() { log.info("End of test case."); }
}
