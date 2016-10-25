package AcseleV13_8LBC.main.controller;

import AcseleV13_8LBC.beans.LBC_HistoricoSiniestrosBean;
import AcseleV13_8LBC.main.controller.LBC_Menu.LBC_MenuOperaciones;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;

/**
 * Created by aazuaje on 22/10/2016.
 */
public class LBC_HistoricoSiniestros {

    private final static Logger log = Logger.getLogger(LBC_HistoricoSiniestros.class);

    public String nombreAutomatizacion = "Historial Reclamos";

    public void testLink(LBC_HistoricoSiniestrosBean lbcHistoricoSiniestrosBean,int i) throws IOException, InterruptedException {

//implementando clase de metodos
        LBC_Metodos a = new LBC_Metodos();
        LBC_MenuOperaciones m = new LBC_MenuOperaciones();
        WebDriver driver = a.entrarPagina();
        a.IniciarSesion(driver, nombreAutomatizacion, i);
        a.ValidandoSesion(driver, nombreAutomatizacion, i);
        Thread.sleep(5000);

        m.OpeSini_HistorialReclamo(a, driver, nombreAutomatizacion, i);
        Thread.sleep(8000);
        a.cambiarVentana(driver);
        BuscarHistorialReclamos(driver, a, lbcHistoricoSiniestrosBean);

    }

    public void BuscarHistorialReclamos (WebDriver driver, LBC_Metodos a, LBC_HistoricoSiniestrosBean lbcHistoricoSiniestrosBean) throws IOException, InterruptedException {
        Thread.sleep(3000);
        WebElement numeroReclamo = driver.findElement(By.xpath("//*[@id=\"tableHeader\"]/tbody/tr[1]/td[2]/input"));
        numeroReclamo.sendKeys(lbcHistoricoSiniestrosBean.getNumeroReclamo());

        Thread.sleep(2000);
        a.ScreenShot(driver,"screen4",nombreAutomatizacion);

        WebElement btnBuscar = driver.findElement(By.xpath("//*[@id=\"idb_0402006_claimHistoryScrem_01\"]"));
        btnBuscar.click();

        Thread.sleep(4000);
        a.ScreenShot(driver,"screen5",nombreAutomatizacion);



    }




}
