package ifellow.api;

import java.util.ResourceBundle;

public enum ApiConfig {
    RNM_URL("rnm.url"),
    REQRES_URL("reqres.url"),
    REQRES_API_HEADER_KEY("reqres.api.key"),
    REQRES_API_HEADER_VALUE("reqres.api.value");

    private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle("config");
    private final String key;

    ApiConfig(String key) {
        this.key = key;
    }

    public String get() { return RESOURCE_BUNDLE.getString(key); }
}