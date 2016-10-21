package AcseleV13_8LBC.main.controller;

import AcseleV13_8LBC.beans.LBC_TercerosHabilitarDeshabilitarBean;
import AcseleV13_8LBC.main.controller.Menu.MenuMantenimiento;
import AcseleV13_8LBC.main.controller.Menu.MenuOperaciones;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.io.IOException;

/**
 * Created by agil on 20/10/2016.
 */
public class LBC_TercerosHabilitarDeshabilitar {

    private final static Logger log = Logger.getLogger(LBC_CajaApertura.class);

    public String nombreAutomatizacion = "LBC Terceros Habilitar Deshabilitar";

    public void testLink(LBC_TercerosHabilitarDeshabilitarBean lbcTercerosHabilitarDeshabilitarBean, int i) throws IOException, InterruptedException {

        try {

            // Instanciando clases
            MetodosLBC a = new MetodosLBC();
            MenuMantenimiento menuMantenimiento = new MenuMantenimiento();
            MenuOperaciones menuOperaciones = new MenuOperaciones();
            // Editar el Tercero


            WebDriver driver = a.entrarPagina();
            a.IniciarSesion(driver, nombreAutomatizacion, i);
            a.ValidandoSesion(driver, nombreAutomatizacion, i);
            Thread.sleep(5000);

            //Entrando en Menu
            menuMantenimiento.MantTerc_BuscarTercero(driver, nombreAutomatizacion, 2, i);

            Thread.sleep(2000);
            a.cambiarVentana(driver);
            Thread.sleep(2000);

            // Buscar el tercero
            BuscarTercero(driver, a, lbcTercerosHabilitarDeshabilitarBean, i, 3, 4, 5, 6);

            driver.close();

            Thread.sleep(1000);
            a.regresarVentana(driver);

            Thread.sleep(1000);
            //Entrando en Menu
            menuOperaciones.OpePol_Crear(driver, nombreAutomatizacion, 7, i);

            Thread.sleep(2000);
            a.cambiarVentana(driver);
            Thread.sleep(2000);

            /** Crear Poliza con el Tercero Habilitado/Deshabilitado */

            Thread.sleep(3000);



        } catch (Exception e) {
            e.printStackTrace();
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }

    public void BuscarTercero (WebDriver driver, MetodosLBC a, LBC_TercerosHabilitarDeshabilitarBean lbcTercerosHabilitarDeshabilitarBean, int i, int numScreenShoot, int numScreenShoot2, int numScreenShoot3, int numScreenShoot4){

        try { //TipoElemento[@wicketpath='WicketpathElemento']

            JavascriptExecutor jse = (JavascriptExecutor)driver;

            Thread.sleep(2000);
            //WebElement input = driver.findElement(By.xpath("//input[@wicketpath='WicketpathElemento']"));
            //Select select = new Select(driver.findElement(By.xpath("//select[@wicketpath='WicketpathElemento']")));

            //APELLIDO PATERNO
            if (lbcTercerosHabilitarDeshabilitarBean.getApellidoPaterno() != null){
                WebElement apellidoPaterno = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_1_fila_field']"));
                apellidoPaterno.sendKeys(lbcTercerosHabilitarDeshabilitarBean.getApellidoPaterno());
                Thread.sleep(1000);
            }

            //APELLIDO MATERNO
            if (lbcTercerosHabilitarDeshabilitarBean.getApellidoMaterno() != null){
                WebElement apellidoMaterno = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel2_1_fila_field']"));
                apellidoMaterno.sendKeys(lbcTercerosHabilitarDeshabilitarBean.getApellidoMaterno());
                Thread.sleep(1000);
            }

            //PRIMER NOMBRE
            if (lbcTercerosHabilitarDeshabilitarBean.getPrimerNombre() != null){
                WebElement primerNombre = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_2_fila_field']"));
                primerNombre.sendKeys(lbcTercerosHabilitarDeshabilitarBean.getPrimerNombre());
                Thread.sleep(1000);
            }

            //SEGUNDO NOMBRE
            if (lbcTercerosHabilitarDeshabilitarBean.getSegundoNombre() != null){
                WebElement segundoNombre = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel2_2_fila_field']"));
                segundoNombre.sendKeys(lbcTercerosHabilitarDeshabilitarBean.getSegundoNombre());
                Thread.sleep(1000);
            }

            //TERCER NOMBRE
            if (lbcTercerosHabilitarDeshabilitarBean.getTercerNombre() != null){
                WebElement tercerNombre = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_3_fila_field']"));
                tercerNombre.sendKeys(lbcTercerosHabilitarDeshabilitarBean.getTercerNombre());
                Thread.sleep(1000);
            }

            //TIPO DOC ID
            if (lbcTercerosHabilitarDeshabilitarBean.getTipoDocumentoId() != null){
                Select tipoDoc = new Select(driver.findElement(By.xpath("//select[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_4_fila_repeaterSelect_1_field']")));
                tipoDoc.selectByValue(lbcTercerosHabilitarDeshabilitarBean.getTipoDocumentoId());
                Thread.sleep(1000);

            }

            //NUM DOC ID
            if (lbcTercerosHabilitarDeshabilitarBean.getNumeroDocumentoId() != null){
                WebElement numDoc = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel2_4_fila_field']"));
                numDoc.sendKeys(lbcTercerosHabilitarDeshabilitarBean.getNumeroDocumentoId());
                Thread.sleep(1000);
            }

            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion);
            Toolkit.getDefaultToolkit().beep();
            Thread.sleep(1000);

            WebElement btnBuscar = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_searchButton']"));
            btnBuscar.click();

            /** Espere **/
            WebElement mensajeEspera = driver.findElement(By.id("waitMessage"));
            while (mensajeEspera.isDisplayed()) {
                Thread.sleep(5000);
                System.out.println("Espera Busqueda del Tercero");
            }

            WebElement selTercero = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_showDetailSearchTable_proof_ThirdPartyRadioGroup_resultsTable_1_thirdPartyRadio']"));
            selTercero.click();

            Thread.sleep(1000);
            jse.executeScript("window.scrollBy(0,1500)", "");
            Thread.sleep(1000);

            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot2, nombreAutomatizacion);
            Toolkit.getDefaultToolkit().beep();
            Thread.sleep(1000);

            // Habilitar/Deshabilitar el Tercero
            WebElement btnHabilitarDeshabilitar = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_showDetailSearchTable_proof_TableForm_EnableDisableThirdButton']"));
            btnHabilitarDeshabilitar.click();

            Thread.sleep(1000);
            jse.executeScript("window.scrollBy(0,1500)", "");
            Thread.sleep(1000);

            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot3, nombreAutomatizacion);
            Toolkit.getDefaultToolkit().beep();
            Thread.sleep(1000);

            WebElement btnAceptar = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_showDetailSearchTable_confirmDialog_content_questionForm_confirmButton']"));
            btnAceptar.click();

            /** Espere **/
            mensajeEspera = driver.findElement(By.id("waitMessage"));
            while (mensajeEspera.isDisplayed()) {
                Thread.sleep(5000);
                System.out.println("Espera Busqueda del Tercero");
            }

            Thread.sleep(1000);
            jse.executeScript("window.scrollBy(0,1500)", "");
            Thread.sleep(1000);

            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot4, nombreAutomatizacion);
            Toolkit.getDefaultToolkit().beep();
            Thread.sleep(1000);


        }catch (Exception e) {
            e.printStackTrace();
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);

        }
    }

}
