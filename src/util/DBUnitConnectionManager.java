package util;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.SQLNestedException;
import org.apache.log4j.Logger;
import org.dbunit.DatabaseUnitException;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by Administrador on 16/05/2016.
 */
public class DBUnitConnectionManager {

    private final static Logger log = Logger.getLogger(DBUnitConnectionManager.class);

    private static Properties properties;
    private static final String DATABASE_DRIVER_SELENIUM = "driverDBSelenium";
    private static final String DATABASE_URL_SELENIUM = "urlDBSelenium";
    private static final String DATABASE_USER_SELENIUM = "userDBSelenium";
    private static final String DATABASE_PASSWORD_SELENIUM = "passwDBSelenium";
    private static final String DATABASE_SCHEMA_SELENIUM = "schemaDBSelenium";
    private static final String DATABASE_DRIVER_ACSELE = "driverDBAcsele";
    private static final String DATABASE_URL_ACSELE = "urlDBAcsele";
    private static final String DATABASE_USER_ACSELE = "userDBAcsele";
    private static final String DATABASE_PASSWORD_ACSELE = "passwDBAcsele";
    private static final String DATABASE_SCHEMA_ACSELE = "schemaDBAcsele";

    public static BasicDataSource getAcseleDataSource() {

        properties = SeleniumProperties.getProperties();

        BasicDataSource datasource = new BasicDataSource();
        datasource.setDriverClassName(String.valueOf(properties.get(DATABASE_DRIVER_ACSELE)));
        datasource.setUrl(String.valueOf(properties.get(DATABASE_URL_ACSELE)));
        datasource.setUsername(String.valueOf(properties.get(DATABASE_USER_ACSELE)));
        datasource.setPassword(String.valueOf(properties.get(DATABASE_PASSWORD_ACSELE)));

        return datasource;

    }

    public static BasicDataSource getSeleniumDataSource() {

        properties = SeleniumProperties.getProperties();

        BasicDataSource datasource = new BasicDataSource();
        datasource.setDriverClassName(String.valueOf(properties.get(DATABASE_DRIVER_SELENIUM)));
        datasource.setUrl(String.valueOf(properties.get(DATABASE_URL_SELENIUM)));
        datasource.setUsername(String.valueOf(properties.get(DATABASE_USER_SELENIUM)));
        datasource.setPassword(String.valueOf(properties.get(DATABASE_PASSWORD_SELENIUM)));

        return datasource;

    }


    public static IDatabaseConnection createDBUnitSeleniumConnection() throws SQLException {

        IDatabaseConnection dbConn = null;
        Connection conn = null;
        properties = SeleniumProperties.getProperties();

        try {
            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            dbConn = new DatabaseConnection(conn, String.valueOf(properties.get(DATABASE_SCHEMA_SELENIUM)));

        } catch (DatabaseUnitException e) {
            e.printStackTrace();


            e.printStackTrace();
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);
            sw.toString(); // stack trace as a string
            log.info("Test Case - " + sw.toString());
        } catch (SQLNestedException e){
            e.printStackTrace();


            e.printStackTrace();
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);
            sw.toString(); // stack trace as a string
            log.info("Test Case - " + sw.toString());
        }
        return dbConn;
    }

    public static IDatabaseConnection createDBUnitAcseleConnection() throws SQLException {

        IDatabaseConnection dbConn = null;
        Connection conn = null;
        properties = SeleniumProperties.getProperties();

        try {
            conn = DBUnitConnectionManager.getAcseleDataSource().getConnection();
            dbConn = new DatabaseConnection(conn, String.valueOf(properties.get(DATABASE_SCHEMA_ACSELE)));

        } catch (DatabaseUnitException e) {
            e.printStackTrace();
        }
        return dbConn;
    }

}
