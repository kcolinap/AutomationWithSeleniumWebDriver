package AcseleV13_8.main.controller;

import AcseleV13_8.beans.ConsultaPolizaSimpleBean;
import AcseleV13_8.main.controller.Menu.MenuOperaciones;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.awt.*;
import java.io.IOException;

/**
 * Created by agil on 26/05/2016.
 */
public class ConsultaPolizaSimple {

    private final static Logger log = Logger.getLogger(ConsultaPolizaSimple.class);

    public String nombreAutomatizacion = "Consulta Poliza Simple";
    //Pliza a buscar
    //String nPoliza = "EA00222";


    public void testLink(ConsultaPolizaSimpleBean consultaPolizaSimpleBean, int i) throws Exception {

        // Instanciando Clases
        Metodos13_8 a = new Metodos13_8();
        MenuOperaciones menuOperaciones = new MenuOperaciones();

        WebDriver driver = a.entrarPagina();
        a.IniciarSesion(driver, nombreAutomatizacion, i); //iniciando sesion.
        a.ValidandoSesion(driver, nombreAutomatizacion, i); //validando sesion.
        Thread.sleep(5000);

        //Entrando en Menu
        menuOperaciones.OpePol_CotizacionSuscripcionMantenimientoPolizas(a, driver, nombreAutomatizacion, 2);
        Thread.sleep(2000);
        a.cambiarVentana(driver); // Cambiar de ventana

        BuscarPolizaSimple(a, driver, consultaPolizaSimpleBean, i);
    }

    public void BuscarPolizaSimple(Metodos13_8 a, WebDriver driver, ConsultaPolizaSimpleBean consultaPolizaSimpleBean, int i) throws InterruptedException, IOException {

        //TipoElemento[@wicketpath='WicketpathElemento']

        Thread.sleep(3000);
        //Campo del num de la poliza
        WebElement fieldNumPoliza = driver.findElement(By.xpath("//input[@wicketpath='ConsultPolicy_searchForm_policyNumber']"));
//        WebElement fieldNumPoliza = driver.findElement(By.xpath("//*[@id=\"idd\"]"));
        //fieldNumPoliza.sendKeys(nPoliza.getNumPoliza());
        fieldNumPoliza.sendKeys(consultaPolizaSimpleBean.getNumPoliza());

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
