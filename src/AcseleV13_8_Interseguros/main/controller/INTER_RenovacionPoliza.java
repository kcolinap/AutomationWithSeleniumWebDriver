package AcseleV13_8_Interseguros.main.controller;

import AcseleV13_8_Interseguros.beans.INTER_RenovacionPolizaBean;
import AcseleV13_8_Interseguros.main.controller.Interseguros_Menu.Interseguros_MenuOperaciones;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;

/**
 * Created by rmontilla on 27/12/2016.
 */
public class INTER_RenovacionPoliza {

    private final static Logger log = Logger.getLogger(INTER_RenovacionPoliza.class);

    public static String nombreAutomatizacion ="INTER Renovacion de Poliza";
    //Pliza a buscar
    //String nPoliza = "F004"; //F0003, K514, D21, D22, K512, K510, LR270401, ED250406

    public void testLink(INTER_RenovacionPolizaBean inter_renovacionPolizaBean, int i, String folderName)throws Exception{

        try {

            Interseguros_Metodos a = new Interseguros_Metodos();   //implementando metodos.
            Interseguros_MenuOperaciones m = new Interseguros_MenuOperaciones();
            WebDriver driver = a.entrarPagina();
            a.IniciarSesion(driver, nombreAutomatizacion, i, folderName); //iniciando sesion.
            a.ValidandoSesion(driver, nombreAutomatizacion, i, folderName); //validando sesion.
            Thread.sleep(5000);

            m.OpePol_CotizacionSuscripcionMantenimientoPolizas(driver, nombreAutomatizacion, 2);

            Thread.sleep(2000);
            a.cambiarVentana(driver);
            BuscarPoliza(a, driver, inter_renovacionPolizaBean);

        }catch (Exception e) {
            e.printStackTrace();
            //             log.info(e);
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }

    }

    public void BuscarPoliza(Interseguros_Metodos a, WebDriver driver, INTER_RenovacionPolizaBean inter_renovacionPolizaBean) throws InterruptedException, IOException {

        try {

            Thread.sleep(3000); //TipoElemento[@wicketpath='WicketpathElemento']
            //Campo del num de la poliza
            WebElement fieldNumPoliza = driver.findElement(By.xpath("//input[@wicketpath='ConsultPolicy_searchForm_policyNumber']"));
//          WebElement fieldNumPoliza = driver.findElement(By.xpath("//*[@id=\"idd\"]"));
            //fieldNumPoliza.sendKeys(nPoliza.getNumPoliza());
            fieldNumPoliza.sendKeys(inter_renovacionPolizaBean.getNumPoliza());

            Thread.sleep(1000);
            //Screenshot
            a.ScreenShot(driver, "screen3", nombreAutomatizacion);

            //Boton Buscar
            driver.findElement(By.xpath("//input[@wicketpath='ConsultPolicy_searchForm_searchButton']")).click();

            //Thread.sleep(10000);
            Thread.sleep(1000);
            /** Espere **/
            WebElement mensajeEspera = driver.findElement(By.id("waitMessage"));
            while (mensajeEspera.isDisplayed()) {
                Thread.sleep(5000);
                System.out.println("Espera 1");
            }

            //Seleccionar Poliza
            driver.findElement(By.xpath("//input[@wicketpath='ConsultPolicy_ResultSearchSimplePolicy_groupPolicies_resultSearchPolicyTable_1_policy']")).click();

            Thread.sleep(1000);
            //Screenshot
            a.ScreenShot(driver, "screen4", nombreAutomatizacion);

            //Boton Renovar Poliza
            driver.findElement(By.xpath("//input[@wicketpath='ConsultPolicy_ResultSearchSimplePolicy_buttonsForm_container_RenewPolicyButton']")).click();

            //Thread.sleep(5000);

            Thread.sleep(1000);
            /** Espere **/
            mensajeEspera = driver.findElement(By.id("waitMessage"));
            while (mensajeEspera.isDisplayed()) {
                Thread.sleep(5000);
                System.out.println("Espera 2");
            }

            Thread.sleep(1000);
            //Screenshot
            a.ScreenShot(driver, "screen5", nombreAutomatizacion);
            Thread.sleep(1000);
            // Boton Continuar
            driver.findElement(By.xpath("//input[@wicketpath='modalWindowForm_EventSection_content_Form_continueButton']")).click();
            // Thread.sleep(15000);

            Thread.sleep(1000);
            /** Espere **/
            mensajeEspera = driver.findElement(By.id("waitMessage"));
            while (mensajeEspera.isDisplayed()) {
                Thread.sleep(5000);
                System.out.println("Espera 2");
            }


            //Screenshot
            a.ScreenShot(driver, "screen6", nombreAutomatizacion);
            // Boton Calcular
            driver.findElement(By.xpath("//input[@wicketpath='divCalculatePolicy_calculateForm_calculateButton']")).click();
            //Thread.sleep(5000);

            Thread.sleep(1000);
            /** Espere **/
            mensajeEspera = driver.findElement(By.id("waitMessage"));
            while (mensajeEspera.isDisplayed()) {
                Thread.sleep(5000);
                System.out.println("Espera 3");
            }

            //Screenshot
            a.ScreenShot(driver, "screen7", nombreAutomatizacion);
            // Boton Aplicar
            driver.findElement(By.xpath("//input[@wicketpath='modalWindowForm_EventSection_content_CloseForm_ApplyPolicy']")).click();
            //Thread.sleep(15000);

            Thread.sleep(1000);
            /** Espere **/
            mensajeEspera = driver.findElement(By.id("waitMessage"));
            while (mensajeEspera.isDisplayed()) {
                Thread.sleep(5000);
                System.out.println("Espera 4");
            }

            // Boton Ingnorar validaciones
            //driver.findElement(By.name("ErrorDialog:content:questionForm:check")).click();
            //Screenshot
            a.ScreenShot(driver, "screen8", nombreAutomatizacion);
            Thread.sleep(1000);
            // Boton Continuar
            driver.findElement(By.xpath("//TipoElemento[@wicketpath='WicketpathElemento']")).click();
            Thread.sleep(5000);

            //Screenshot
            a.ScreenShot(driver, "screen9", nombreAutomatizacion);

        }catch (Exception e) {
            e.printStackTrace();
            //             log.info(e);
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }

}
