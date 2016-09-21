package AcseleV13_8.main.controller;

import AcseleV13_8.beans.AnulacionPolizaBean;
import AcseleV13_8.main.controller.Menu.MenuOperaciones;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;

/**
 * Created by agil on 26/05/2016.
 */
public class AnulacionPolizas {

    private final static Logger log = Logger.getLogger(AnulacionPolizas.class);

    public String nombreAutomatizacion ="Anulacion de Poliza";

    public void testLink(AnulacionPolizaBean anulacionPolizaBean, int i)throws Exception{

        try {

            // Instanciando clases
            Metodos a = new Metodos();
            MenuOperaciones m = new MenuOperaciones();

            WebDriver driver = a.entrarPagina();
            a.IniciarSesion(driver, nombreAutomatizacion, i); //iniciando sesion.
            a.ValidandoSesion(driver, nombreAutomatizacion, i); //validando sesion.
            Thread.sleep(3000);

            m.OpePol_CotizacionSuscripcionMantenimientoPolizas(a, driver, nombreAutomatizacion, 2);
            Thread.sleep(2000);
            a.cambiarVentana(driver); // Cambiar de ventana
            BuscarPoliza(a, driver, anulacionPolizaBean, i);
        }catch (Exception e) {
            e.printStackTrace();
            //             log.info(e);
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }


    }

    public void BuscarPoliza(Metodos a, WebDriver driver, AnulacionPolizaBean anulacionPolizaBean, int i) throws InterruptedException, IOException {

        try {

            //TipoElemento[@wicketpath='WicketpathElemento']

            Thread.sleep(4000);
            //Campo del num de la poliza
            WebElement fieldNumPoliza = driver.findElement(By.xpath("//input[@wicketpath='ConsultPolicy_searchForm_policyNumber']"));
            fieldNumPoliza.sendKeys(anulacionPolizaBean.getNumPoliza());

            Thread.sleep(1000);
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

            //Thread.sleep(10000);

            //Seleccionar Poliza
            driver.findElement(By.xpath("//input[@wicketpath='ConsultPolicy_ResultSearchSimplePolicy_groupPolicies_resultSearchPolicyTable_1_policy']")).click();

            Thread.sleep(1000);
            //Screenshot
            a.ScreenShotPool(driver, i,  "screen4", nombreAutomatizacion);

            //Boton Cancelar Poliza
            driver.findElement(By.xpath("//input[@wicketpath='ConsultPolicy_ResultSearchSimplePolicy_buttonsForm_container_CancelPolicyButton']")).click();

            Thread.sleep(1000);

            /** Espere **/
            mensajeEspera = driver.findElement(By.id("waitMessage"));
            while (mensajeEspera.isDisplayed()) {
                Thread.sleep(5000);
                System.out.println("Espera 2");
            }

            // Seleccionar Opcion = Anular
            Select menuOpcion = new Select(driver.findElement(By.xpath("//select[@wicketpath='modalWindowForm_EventSection_content_events_repeaterSelect_1_field']")));
            menuOpcion.selectByValue(anulacionPolizaBean.getOpcion());

            //Fecha   //TipoElemento[@wicketpath='WicketpathElemento']

            // Select MotivoAnulacion
            Select motivoAnulacion = new Select(driver.findElement(By.xpath("//select[@wicketpath='modalWindowForm_EventSection_content_Form_templateContainer_repeaterPanel_3_fila_repeaterSelect_1_field']")));
            motivoAnulacion.selectByValue(anulacionPolizaBean.getMotivoAnulacion()); //Voluntad del Tomador / Asegurado

            //Observacion
            driver.findElement(By.xpath("//textarea[@wicketpath='modalWindowForm_EventSection_content_Form_templateContainer_repeaterPanel_4_fila_field']")).sendKeys(anulacionPolizaBean.getObservacion());

            Thread.sleep(1000);
            //Screenshot
            a.ScreenShotPool(driver, i, "screen5", nombreAutomatizacion);

            //Boton Continuar
            driver.findElement(By.xpath("//input[@wicketpath='modalWindowForm_EventSection_content_Form_continueButton']")).click();

            Thread.sleep(5000);
            //Screenshot
            a.ScreenShotPool(driver, i, "screen6", nombreAutomatizacion);

            // Boton Calcular
            driver.findElement(By.xpath("//input[@wicketpath='divCalculatePolicy_formCalculate_calculate']")).click();
            Thread.sleep(1000);


            /** Espere **/
            mensajeEspera = driver.findElement(By.id("waitMessage"));
            while (mensajeEspera.isDisplayed()) {
                Thread.sleep(5000);
                System.out.println("Espera 3");
            }

            //Screenshot
            a.ScreenShotPool(driver, i, "screen7", nombreAutomatizacion);

            // Boton Aplicar
            WebElement btnAplicar = driver.findElement(By.xpath("//input[@wicketpath='modalWindowForm_EventSection_content_CloseForm_ApplyPolicy']"));
            btnAplicar.click();

            Thread.sleep(1000);
            /** Espere **/
            mensajeEspera = driver.findElement(By.id("waitMessage"));
            while (mensajeEspera.isDisplayed()) {
                Thread.sleep(5000);
                System.out.println("Espera 3");
            }

            //Thread.sleep(15000);
            //Screenshot
            a.ScreenShotPool(driver, i,  "screen8", nombreAutomatizacion);

            System.out.println("Fin de la prueba");

        }catch (Exception e) {
            e.printStackTrace();
            //             log.info(e);
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }

    }

}
