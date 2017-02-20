package AcseleV13_8_Interseguros.main.controller;

import AcseleV13_8_Interseguros.beans.INTER_ConsultaSimplePolizaBean;
import AcseleV13_8_Interseguros.main.controller.Interseguros_Menu.Interseguros_MenuOperaciones;
import metodo.Metodos;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.awt.*;
import java.io.IOException;

/**
 * Created by rmontilla on 26/12/2016.
 */
public class INTER_ConsultaSimplePoliza {

    private final static Logger log = Logger.getLogger(INTER_ConsultaSimplePoliza.class);

    public String nombreAutomatizacion = "INTER Consulta Poliza Simple";
    private WebDriver driver;


    public void testLink(INTER_ConsultaSimplePolizaBean inter_consultaSimplePolizaBean, int i, String folderName) throws Exception {

        try {

            // Instanciando Clases
            Metodos a = new Metodos();
            Interseguros_MenuOperaciones interseguros_menuOperaciones = new Interseguros_MenuOperaciones();

            driver = a.entrarPagina(a.UrlInterseguros());
            a.IniciarSesion(driver, nombreAutomatizacion, i, folderName); //iniciando sesion.
            a.ValidandoSesion(driver, nombreAutomatizacion, i, folderName); //validando sesion.
            Thread.sleep(5000);

            //Entrando en Menu
            interseguros_menuOperaciones.OpePol_CotizacionSuscripcionMantenimientoPolizas(driver, nombreAutomatizacion, 2);
            Thread.sleep(2000);
            a.cambiarVentana(driver); // Cambiar de ventana

            BuscarPolizaSimple(a, inter_consultaSimplePolizaBean, i, folderName);

            driver.quit();

        }catch (Exception e){
            e.printStackTrace();
            log.error("Test Case - " + nombreAutomatizacion + " - " + e);
            if (driver != null){
                driver.quit();
            }
        }
    }

    public void BuscarPolizaSimple(Metodos a, INTER_ConsultaSimplePolizaBean inter_consultaSimplePolizaBean, int i, String folderName) throws InterruptedException, IOException {

        try {

            //TipoElemento[@wicketpath='WicketpathElemento']

            Thread.sleep(3000);
            //Campo del num de la poliza
            WebElement fieldNumPoliza = driver.findElement(By.xpath("//input[@wicketpath='ConsultPolicy_searchForm_policyNumber']"));
            /*WebElement fieldNumPoliza = driver.findElement(By.xpath("//*[@id=\"idd\"]"));
            fieldNumPoliza.sendKeys(nPoliza.getNumPoliza());*/
            fieldNumPoliza.sendKeys(inter_consultaSimplePolizaBean.getNumPoliza());

            //Screenshot
            a.ScreenShotPool(driver, i, "screen3", nombreAutomatizacion, folderName);

            //Boton Buscar
            driver.findElement(By.xpath("//input[@wicketpath='ConsultPolicy_searchForm_searchButton']")).click();

            Thread.sleep(1000);

            a.waitSearchWicket(driver, "Espera 1");

            Thread.sleep(1000);
            //Seleccionar Poliza
            driver.findElement(By.xpath("//input[@wicketpath='ConsultPolicy_ResultSearchSimplePolicy_groupPolicies_resultSearchPolicyTable_1_policy']")).click();

            //Screenshot
            a.ScreenShotPool(driver, i, "screen4", nombreAutomatizacion, folderName);

            //Boton Consultar Poliza
            driver.findElement(By.xpath("//input[@wicketpath='ConsultPolicy_ResultSearchSimplePolicy_buttonsForm_container_ConsultPolicyButton']")).click();

            Thread.sleep(1000);

            a.waitSearchWicket(driver, "Espera 2");

            Thread.sleep(1000);
            // Si aparece un mensaje "El asegurado Presenta Cumulo"
            if (driver.findElement(By.xpath("//label[@wicketpath='modalWindowForm_EventSection_content_eventMessage']")).isDisplayed()) {
                //Screenshot
                Thread.sleep(2000);
                a.ScreenShotPool(driver, i, "screen6-2", nombreAutomatizacion, folderName);
                Toolkit.getDefaultToolkit().beep();
                Thread.sleep(1000);
                // Boton Continuar
                driver.findElement(By.xpath("//input[@wicketpath='modalWindowForm_EventSection_content_Form_continueButton']")).click();
            }

            Thread.sleep(1000);

            System.out.println("Fin de la prueba");

        }catch (Exception e){
            e.printStackTrace();
            log.error("Test Case - " + nombreAutomatizacion + " - " + e);
        }


    }

}
