package AcseleV13_8Asesuisa.main.controller;

import AcseleV13_8Asesuisa.beans.Asesuisa_TercerosInformacionTecnicaBean;
import AcseleV13_8Asesuisa.main.controller.Asesuisa_Terceros.Asesuisa_BuscarTerceros;
import AcseleV13_8Asesuisa.main.controller.Asesuisa_Menu.Asesuisa_MenuMantenimiento;

import metodo.Metodos;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;

/**
 * Created by kcolina on 06/03/2017.
 */
public class Asesuisa_TercerosInformacionTecnica {

    private final static Logger Log = Logger.getLogger(Asesuisa_TercerosInformacionTecnica.class);
    public String nombreAutomatizacion = "Terceros - Informacion Tecnica";
    private WebDriver driver;

    public void testLink(Asesuisa_TercerosInformacionTecnicaBean asesuisaTercerosInformacionTecnicaBean, int i, String
                         folderName){
        try{
            Metodos m = new Metodos();
            Asesuisa_MenuMantenimiento menuMantenimiento = new Asesuisa_MenuMantenimiento();
            Asesuisa_BuscarTerceros buscarTerceros = new Asesuisa_BuscarTerceros();

            driver = m.entrarPagina(m.UrlAsesuisa());
            m.IniciarSesion(driver,nombreAutomatizacion, i, folderName);
            m.ValidandoSesion(driver,nombreAutomatizacion,i,folderName);
            Thread.sleep(1000);

            //Ingreso a la opcion consulta de terceros
            menuMantenimiento.MantTerc_BuscarTercero(driver,nombreAutomatizacion,2,i,folderName);
            Thread.sleep(1000);
            m.cambiarVentana(driver);
            Thread.sleep(500);

            //Buscar tercero
            buscarTerceros.BusquedaT(driver, m, asesuisaTercerosInformacionTecnicaBean,nombreAutomatizacion,i,folderName,
                    3,4,5,6);
            Thread.sleep(1500);

            //Llamada a metodo informacion tecnica
            InformacionTecnica(driver, m, i, folderName, 7,8,9);
            Thread.sleep(1000);

            //Salgo de la aplicacion
            driver.quit();

        }catch (Exception e){
            e.printStackTrace();
            Log.error("Test Case - " + nombreAutomatizacion + " - " + e);
            if (driver != null) {
                driver.quit();
            }
        }
    }

    public void InformacionTecnica(WebDriver driver, Metodos m, int i, String folderName, int screen, int screen2,
                                   int screen3){
        try {

            JavascriptExecutor jse = (JavascriptExecutor) driver;

            //Boton informacion tecnica
            WebElement btnInfTecnica = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_showDetailSearchTable_proof_TableForm_technicalDataButton']"));
            btnInfTecnica.click();
            m.waitSearchWicket(driver, "Consultando informacion tecnica");

            m.ScreenShotPool(driver,i, "screen"+screen, nombreAutomatizacion,folderName);
            Thread.sleep(1000);

            jse.executeScript("window.scrollBy(0,600)", "");
            Thread.sleep(500);

            m.ScreenShotPool(driver,i, "screen"+screen2, nombreAutomatizacion,folderName);
            Thread.sleep(1000);

            jse.executeScript("window.scrollBy(0,600)", "");
            Thread.sleep(500);

            m.ScreenShotPool(driver,i, "screen"+screen3, nombreAutomatizacion,folderName);
            Thread.sleep(1000);

        }catch (Exception e){

        }
    }
}
