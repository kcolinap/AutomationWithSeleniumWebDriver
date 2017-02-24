package AcseleV13_8Asesuisa.main.controller;

import AcseleV13_8Asesuisa.beans.Asesuisa_TercerosHabilitarDeshabilitarBean;
import AcseleV13_8Asesuisa.main.controller.Asesuisa_Terceros.Asesuisa_BuscarTerceros;
import AcseleV13_8Asesuisa.main.controller.Asesuisa_Menu.Asesuisa_MenuMantenimiento;

import metodo.Metodos;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;

import java.awt.*;

/**
 * Created by kcolina on 24/02/2017.
 */
public class Asesuisa_TercerosHabilitarDeshabilitar extends Asesuisa_BuscarTerceros {

    private final static Logger Log = Logger.getLogger(Asesuisa_TercerosHabilitarDeshabilitar.class);
    public String nombreAutomatizacion = "Habilitar-Deshabilitar-terceros";
    private WebDriver driver;

    public void testLink(Asesuisa_TercerosHabilitarDeshabilitarBean asesuisaTercerosHabilitarDeshabilitarBean, int i,
                         String folderName){

        try{
            Metodos m = new Metodos();
            Asesuisa_MenuMantenimiento asesuisaMenuMantenimiento = new Asesuisa_MenuMantenimiento();
            Asesuisa_BuscarTerceros asesuisaBuscarTerceros = new Asesuisa_BuscarTerceros();

            driver = m.entrarPagina(m.UrlAsesuisa());
            m.IniciarSesion(driver, nombreAutomatizacion,i,folderName);
            m.ValidandoSesion(driver, nombreAutomatizacion, i, folderName);
            Thread.sleep(1000);

            //Ingreso a la opcion consulta de terceros
            asesuisaMenuMantenimiento.MantTerc_BuscarTercero(driver, nombreAutomatizacion,2,i,folderName);

            Thread.sleep(2000);
            m.cambiarVentana(driver);
            Thread.sleep(2000);

            //buscar tercero
            asesuisaBuscarTerceros.BusquedaT(driver,m,asesuisaTercerosHabilitarDeshabilitarBean,nombreAutomatizacion,i,folderName,3,4,5,6);
            Thread.sleep(1500);

            //Llamada al metodo habilitar-deshabilitar
            HabilitarDeshabilitarT(driver, m, i, folderName, 7, 8);
            driver.quit();
        }catch (Exception e){
            e.printStackTrace();
            Log.error("Test Case - " + nombreAutomatizacion + " - " + e);
            if (driver != null) {
                driver.quit();
            }
        }
    }

    public void HabilitarDeshabilitarT(WebDriver driver, Metodos m, int i, String folderName, int numScreenShoot,
                                       int numScreenShot2){
        try{
            JavascriptExecutor jse = (JavascriptExecutor) driver;


            //Boton habilitar-deshabilitar
            WebElement btnHabdes = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_showDetailSearchTable_proof_TableForm_EnableDisableThirdButton']"));
            btnHabdes.click();
            Thread.sleep(2000);

            //ScreenShot para mostrar ventana de confirmacion
            m.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion, folderName);
            Toolkit.getDefaultToolkit().beep();
            Thread.sleep(1000);


            //Boton de confirmacion
            WebElement btnAceptar = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_showDetailSearchTable_confirmDialog_content_questionForm_confirmButton']"));
            btnAceptar.click();
            Thread.sleep(1500);

            jse.executeScript("window.scrollBy(0,1000)", "");
            Thread.sleep(1000);
            //screenShoot para mostrar nuevo estatus
            m.ScreenShotPool(driver, i, "screen" + numScreenShot2, nombreAutomatizacion, folderName);
            Toolkit.getDefaultToolkit().beep();
            Thread.sleep(2000);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
