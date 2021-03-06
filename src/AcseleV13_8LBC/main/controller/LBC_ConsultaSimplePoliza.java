package AcseleV13_8LBC.main.controller;
import AcseleV13_8LBC.beans.LBC_ConsultaSimplePolizaBean;
import AcseleV13_8LBC.main.controller.LBC_Menu.LBC_MenuOperaciones;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.awt.*;
import java.io.IOException;

/**
 * Created by aazuaje on 10/10/2016.
 */
public class LBC_ConsultaSimplePoliza {

    private final static Logger log = Logger.getLogger(LBC_ConsultaSimplePoliza.class);

    public String nombreAutomatizacion = "Consulta Poliza Simple";
    //Pliza a buscar
    //String nPoliza = "EA00222";


    public void testLink(LBC_ConsultaSimplePolizaBean lbcConsultaSimplePolizaBean, int i) throws Exception {

        // Instanciando Clases
        LBC_Metodos a = new LBC_Metodos();
        LBC_MenuOperaciones lbcMenuOperaciones = new LBC_MenuOperaciones();

        WebDriver driver = a.entrarPagina();
        a.IniciarSesion(driver, nombreAutomatizacion, i); //iniciando sesion.
        a.ValidandoSesion(driver, nombreAutomatizacion, i); //validando sesion.
        Thread.sleep(5000);

        //Entrando en Menu
        lbcMenuOperaciones.OpePol_CotizacionSuscripcionMantenimientoPolizas(a, driver, nombreAutomatizacion, 2);
        Thread.sleep(2000);
        a.cambiarVentana(driver); // Cambiar de ventana

        BuscarPolizaSimple(a, driver, lbcConsultaSimplePolizaBean, i);
    }

    public void BuscarPolizaSimple(LBC_Metodos a, WebDriver driver, LBC_ConsultaSimplePolizaBean lbcConsultaSimplePolizaBean, int i) throws InterruptedException, IOException {

        //TipoElemento[@wicketpath='WicketpathElemento']

        Thread.sleep(3000);
        //Campo del num de la poliza
        WebElement fieldNumPoliza = driver.findElement(By.xpath("//input[@wicketpath='ConsultPolicy_searchForm_policyNumber']"));
//        WebElement fieldNumPoliza = driver.findElement(By.xpath("//*[@id=\"idd\"]"));
        //fieldNumPoliza.sendKeys(nPoliza.getNumPoliza());
        fieldNumPoliza.sendKeys(lbcConsultaSimplePolizaBean.getNumPoliza());

        //Screenshot
        a.ScreenShotPool(driver, i, "screen3", nombreAutomatizacion);

        //Boton Buscar
        driver.findElement(By.xpath("//input[@wicketpath='ConsultPolicy_searchForm_searchButton']")).click();

        Thread.sleep(1000);

        /** Espere **/
        WebElement mensajeEspera = driver.findElement(By.id("waitMessage"));
        while (mensajeEspera.isDisplayed()) {
            Thread.sleep(5000);
            System.out.println("Espera 1");
        }

        Thread.sleep(1000);
        //Seleccionar Poliza
        driver.findElement(By.xpath("//input[@wicketpath='ConsultPolicy_ResultSearchSimplePolicy_groupPolicies_resultSearchPolicyTable_1_policy']")).click();

        //Screenshot
        a.ScreenShotPool(driver, i, "screen4", nombreAutomatizacion);

        //Boton Consultar Poliza
        driver.findElement(By.xpath("//input[@wicketpath='ConsultPolicy_ResultSearchSimplePolicy_buttonsForm_container_ConsultPolicyButton']")).click();

        Thread.sleep(1000);

        /** Espere **/
        mensajeEspera = driver.findElement(By.id("waitMessage"));
        while (mensajeEspera.isDisplayed()) {
            Thread.sleep(5000);
            System.out.println("Espera 2");
        }

        Thread.sleep(1000);
        // Si aparece un mensaje "El asegurado Presenta Cumulo"
        if (driver.findElement(By.xpath("//label[@wicketpath='modalWindowForm_EventSection_content_eventMessage']")).isDisplayed()){
            //Screenshot
            Thread.sleep(2000);
            a.ScreenShotPool(driver, i, "screen6-2", nombreAutomatizacion);
            Toolkit.getDefaultToolkit().beep();
            Thread.sleep(1000);
            // Boton Continuar
            driver.findElement(By.xpath("//input[@wicketpath='modalWindowForm_EventSection_content_Form_continueButton']")).click();
        }

        Thread.sleep(1000);

        System.out.println("Fin de la prueba");



    }



}
