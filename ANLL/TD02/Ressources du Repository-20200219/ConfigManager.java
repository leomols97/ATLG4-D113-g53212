public class ConfigManager {

    private ConfigManager() {
        prop = new Properties();
        url = getClass().getClassLoader().getResource(FILE).getFile();
    }

    private static final String FILE = "./config/config.properties";

    private final Properties prop;

    private final String url ;

    public void load() throws IOException {
        try (InputStream input = new FileInputStream(url)) {
            prop.load(input);
        } catch (IOException ex) {
            throw new IOException("Chargement configuration impossible " + ex.getMessage());
        }
    }

    public String getProperties(String name) {
        return prop.getProperty(name);
    }

    public static ConfigManager getInstance() {
        return ConfigManagerHolder.INSTANCE;
    }

    private static class ConfigManagerHolder {

        private static final ConfigManager INSTANCE = new ConfigManager();
    }
}
