package ifellow;

import java.util.ResourceBundle;

public enum Config {

    JIRA_URL("jira.url"),
    JIRA_LOGIN("jira.login"),
    JIRA_PASSWORD("jira.password");

    private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle("ifellow/config");
    private final String key;

    Config(String key) {
        this.key = key;
    }

    public String get() {
        return RESOURCE_BUNDLE.getString(key);
    }
}
