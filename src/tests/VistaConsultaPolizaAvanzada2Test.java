package tests;

import beans.BusquedaPolizaAvanzadaBean;
import main.controller.ConsultaPolizaAvanzada;
import main.controller.ConsultaPolizaAvanzada2;
import main.controller.Login;
import main.controller.Metodos;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import util.DataSetManager;

import java.util.ArrayList;

/**
 * Created by agil on 26/05/2016.
 */
public class VistaConsultaPolizaAvanzada2Test {

    @Test
    //@Transactional
    public void mainTest() {

//        BusquedaPolizaAvanzadaBean busquedaPolizaAvanzadaBean = BusquedaPolizaAvanzadaBean.getBusquedaPolizaAvanzada();
//        ConsultaPolizaAvanzada a = new ConsultaPolizaAvanzada();
//        try {
//            a.testLink(busquedaPolizaAvanzadaBean);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        /***/
        System.setProperty("webdriver.chrome.driver", "C://chromedriver//chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        ArrayList polizas = BusquedaPolizaAvanzadaBean.getBusquedaPolizasAvanzadas();
        //login
        Login l = new Login();
        try {
            l.LoginA(driver);
        } catch (Exception e) {
            e.printStackTrace();
        }


        for(int i = 0; i < polizas.size(); i++) {

            BusquedaPolizaAvanzadaBean busquedaPolizaAvanzadaBean = (BusquedaPolizaAvanzadaBean) polizas.get(i);
            ConsultaPolizaAvanzada2 a = new ConsultaPolizaAvanzada2();
            try {

                a.testLink(driver, busquedaPolizaAvanzadaBean, i);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        //Logout

    }

    @Before
    public void setUp() throws Exception {

        /*DataSetManager.createPartialDataSet("select PRUEBA, NUM_POLIZA, FECHA_EMISION, PRODUCTO from BUSQUEDA_POLIZA",
                "BUSQUEDA_POLIZA",
                "C:/AcseleTests/AutomationTestAcsele/src/tests/consultaPolizaAvanzada2_dataset.xml");

        DataSetManager.createPartialDataSet("select PRUEBA, NUM_POLIZA, FECHA_EMISION, PRODUCTO from BUSQUEDA_POLIZA",
                "BUSQUEDA_POLIZA",
                "C:/AcseleTests/AutomationTestAcsele/target/classes/tests/consultaPolizaAvanzada2_dataset.xml");
        */

        DataSetManager.loadDataSet("/tests/consultaPolizaAvanzada2_dataset.xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown() throws Exception {

        DataSetManager.loadDataSet("/tests/consultaPolizaAvanzada2_dataset.xml", DataSetManager.DELETE_OPERATION);
    }
}
