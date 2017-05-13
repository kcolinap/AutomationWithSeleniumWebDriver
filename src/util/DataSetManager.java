package util;

import org.dbunit.database.DatabaseConfig;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.database.QueryDataSet;
import org.dbunit.dataset.DataSetException;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.ext.oracle.OracleDataTypeFactory;
import org.dbunit.operation.DatabaseOperation;
import org.dbunit.util.fileloader.DataFileLoader;
import org.dbunit.util.fileloader.FlatXmlDataFileLoader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.*;
import java.net.MalformedURLException;

/**
 * Created by Administrador on 16/05/2016.
 */
public class DataSetManager {

    public static final int REFRESH_OPERATION = 1;
    public static final int DELETE_OPERATION = 2;
    public static final int CLEAN_INSERT_OPERATION = 3;
    public static final int INSERT_OPERATION = 4;
    public static final int UPDATE_OPERATION = 5;


    public static void createPartialDataSetAcsele(String query, String table, String fileName) throws Exception {

        IDatabaseConnection connection = DBUnitConnectionManager.createDBUnitAcseleConnection();

        QueryDataSet partialDataSet = new QueryDataSet(connection);
        partialDataSet.addTable(table, query);
        FlatXmlDataSet.write(partialDataSet, new FileOutputStream(fileName));
    }

    public static void createPartialDataSet(String query, String table, String fileName) throws Exception {

        IDatabaseConnection connection = DBUnitConnectionManager.createDBUnitSeleniumConnection();

        QueryDataSet partialDataSet = new QueryDataSet(connection);
        partialDataSet.addTable(table, query);
        FlatXmlDataSet.write(partialDataSet, new FileOutputStream(fileName));

    }

    public static void loadDataSet(String fileLocation, int operationType) throws Exception {

        IDatabaseConnection connection = DBUnitConnectionManager.createDBUnitSeleniumConnection();
        DataFileLoader loader = new FlatXmlDataFileLoader();
        IDataSet dataSet = loader.load(fileLocation);

        DatabaseConfig dbConfig = connection.getConfig();

        // added this line to get rid of the warning
        dbConfig.setProperty(DatabaseConfig.PROPERTY_DATATYPE_FACTORY, new OracleDataTypeFactory());

        switch (operationType) {

            case REFRESH_OPERATION:

                DatabaseOperation.REFRESH.execute(connection, dataSet);
                break;

            case DELETE_OPERATION:

                DatabaseOperation.DELETE.execute(connection, dataSet);
                break;

            case CLEAN_INSERT_OPERATION:

                DatabaseOperation.CLEAN_INSERT.execute(connection, dataSet);
                break;

            case INSERT_OPERATION:

                DatabaseOperation.INSERT.execute(connection, dataSet);
                break;

            case UPDATE_OPERATION:

                DatabaseOperation.UPDATE.execute(connection, dataSet);
                break;

            default:

                break;
        }
    }

    public static IDataSet createDataSet(String classPathResource) throws MalformedURLException, DataSetException, IOException {
        Resource resource = new ClassPathResource(classPathResource);
        IDataSet dataSet = new FlatXmlDataSetBuilder().build(resource.getFile());
        return dataSet;
    }


    public static String loadSQLFile(String fileName) {

        String s = new String();
        StringBuffer sb = new StringBuffer();
        FileReader fr = null;
        try {
            fr = new FileReader(new File(fileName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        // be sure to not have line starting with "--" or "/*" or any
        // other non aplhabetical character
        BufferedReader br = new BufferedReader(fr);
        try {
            while ((s = br.readLine()) != null) {
                sb.append(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
// here is our splitter ! We use ";" as a delimiter for each request
// then we are sure to have well formed statements
        String[] inst = sb.toString().split(";");

        return sb.toString();
    }
}
