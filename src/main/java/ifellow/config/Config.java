package ifellow.config;

import java.util.ResourceBundle;

public enum Config {

    JIRA_URL("jira.url"),
    JIRA_LOGIN("jira.login"),
    JIRA_PASSWORD("jira.password"),
    SCREENSHOTS("do.screenshots"),
    SAVE_PAGES_SOURCE("do.savePagesSource"),
    DEBUG_LOGS("debug.logs");

    private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle("ifellow/config");
    private final String key;

    Config(String key) {
        this.key = key;
    }

    public String get() {
        return RESOURCE_BUNDLE.getString(key);
    }

    public Boolean getBool() {
        String value = RESOURCE_BUNDLE.getString(key);
        return Boolean.parseBoolean(value);
    }
}
