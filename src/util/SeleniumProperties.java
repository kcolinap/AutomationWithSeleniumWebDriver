package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by Administrador on 16/05/2016.
 */
public class SeleniumProperties {

    private static final String CONFIGURATION_FILE_W = "C:/external/AcseleSeleniumTestConfigurationFile.properties";
    private static final String CONFIGURATION_FILE_L = "/home/Consisint/Automatizacion/external/AcseleSeleniumTestConfigurationFile.properties";
    public static final String COUNTRY = "country";
    public static final String LANGUAGE = "language";
    public static final String DATABASE_DRIVER_SELENIUM = "driverDBSelenium";
    public static final String DATABASE_URL_SELENIUM = "urlDBSelenium";
    public static final String DATABASE_USER_SELENIUM = "userDBSelenium";
    public static final String DATABASE_PASSWORD_SELENIUM = "passwDBSelenium";
    public static final String DATABASE_SCHEMA_SELENIUM = "schemaDBSelenium";
    public static final String DATABASE_DRIVER_ACSELE = "driverDBAcsele";
    public static final String DATABASE_URL_ACSELE = "urlDBAcsele";
    public static final String DATABASE_USER_ACSELE = "userDBAcsele";
    public static final String DATABASE_PASSWORD_ACSELE = "passwDBAcsele";
    public static final String DATABASE_SCHEMA_ACSELE = "schemaDBAcsele";


    public static Properties getProperties() {

        Properties properties = new Properties();
        InputStream input = null;

        try {

            String oS = System.getProperty("os.name");
            if (oS.equals("Windows 7")) {
                input = new FileInputStream(CONFIGURATION_FILE_W);

                if (input == null) {
                    System.out.println("Sorry, unable to find " + CONFIGURATION_FILE_W);
                }

                properties.load(input);
            }
            else if (oS.equals("Linux")){
                input = new FileInputStream(CONFIGURATION_FILE_L);

                if (input == null) {
                    System.out.println("Sorry, unable to find " + CONFIGURATION_FILE_L);
                }

                properties.load(input);
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return properties;
    }
}
