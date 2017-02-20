package AcseleV13_8.main.controller;

import AcseleV13_8.beans.HistorialReclamosBean;
import AcseleV13_8.main.controller.Menu.MenuOperaciones;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;

/**
 * Created by aazuaje on 02/08/2016.
 */
public class HistorialReclamos {

    private final static Logger log = Logger.getLogger(HistorialReclamos.class);

    public String nombreAutomatizacion = "Historial Reclamos";

    public void testLink(HistorialReclamosBean historialReclamosBean,int i) throws IOException, InterruptedException {

//implementando clase de metodos
        Metodos13_8 a = new Metodos13_8();
        MenuOperaciones m = new MenuOperaciones();
        WebDriver driver = a.entrarPagina();
        a.IniciarSesion(driver, nombreAutomatizacion, i);
        a.ValidandoSesion(driver, nombreAutomatizacion, i);
        Thread.sleep(5000);

        m.OpeSini_HistorialReclamo(a, driver, nombreAutomatizacion,i);
        Thread.sleep(8000);
        a.cambiarVentana(driver);
        BuscarHistorialReclamos(driver, a, historialReclamosBean);


    }


    public void BuscarHistorialReclamos (WebDriver driver, Metodos13_8 a, HistorialReclamosBean historialReclamosBean) throws IOException, InterruptedException {
        Thread.sleep(3000);
        WebElement numeroReclamo = driver.findElement(By.xpath("//*[@id=\"tableHeader\"]/tbody/tr[1]/td[2]/input"));
        numeroReclamo.sendKeys(historialReclamosBean.getNumeroReclamo());

        Thread.sleep(2000);
        a.ScreenShot(driver,"screen4",nombreAutomatizacion);

        WebElement btnBuscar = driver.findElement(By.xpath("//*[@id=\"idb_0402006_claimHistoryScrem_01\"]"));
        btnBuscar.click();

        Thread.sleep(4000);
        a.ScreenShot(driver,"screen5",nombreAutomatizacion);



    }
}




