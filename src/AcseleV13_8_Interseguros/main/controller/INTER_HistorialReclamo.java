package AcseleV13_8_Interseguros.main.controller;

import AcseleV13_8_Interseguros.beans.INTER_HistorialReclamoBean;
import AcseleV13_8_Interseguros.main.controller.Interseguros_Menu.Interseguros_MenuOperaciones;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;

/**
 * Created by aazuaje on 27/12/2016.
 */
public class INTER_HistorialReclamo {

    private final static Logger log = Logger.getLogger(INTER_HistorialReclamo.class);

    public String nombreAutomatizacion = "Historial Reclamos";

    public void testLink(INTER_HistorialReclamoBean inter_historialReclamoBean, int i, String folderName) throws IOException, InterruptedException {

//implementando clase de metodos
        Interseguros_Metodos a = new Interseguros_Metodos();
        Interseguros_MenuOperaciones m = new Interseguros_MenuOperaciones();
        WebDriver driver = a.entrarPagina();
        a.IniciarSesion(driver, nombreAutomatizacion, i, folderName);
        a.ValidandoSesion(driver, nombreAutomatizacion, i, folderName);
        Thread.sleep(5000);

        m.OpeSini_HistorialReclamo(driver, a,  nombreAutomatizacion,3, i);
        Thread.sleep(8000);
        a.cambiarVentana(driver);
        BuscarHistorialReclamos(driver, a, inter_historialReclamoBean);


    }


    public void BuscarHistorialReclamos (WebDriver driver, Interseguros_Metodos  a, INTER_HistorialReclamoBean inter_historialReclamoBean) throws IOException, InterruptedException {

        try {

            Thread.sleep(3000);
            WebElement numReclamo = driver.findElement(By.xpath("//*[@id=\"tableHeader\"]/tbody/tr[1]/td[2]/input"));
            numReclamo.sendKeys(inter_historialReclamoBean.getNumReclamo());

            Thread.sleep(2000);
            a.ScreenShot(driver,"screen4",nombreAutomatizacion);

            WebElement btnBuscar = driver.findElement(By.xpath("//*[@id=\"idb_0402006_claimHistoryScrem_01\"]"));
            btnBuscar.click();

            Thread.sleep(2000);
            a.ScreenShot(driver,"screen5",nombreAutomatizacion);

        }catch (Exception e) {
            e.printStackTrace();
//                log.info(e);
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }

    }

}
