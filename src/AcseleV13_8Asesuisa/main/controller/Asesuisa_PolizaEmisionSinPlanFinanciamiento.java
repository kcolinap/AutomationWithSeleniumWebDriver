package AcseleV13_8Asesuisa.main.controller;

import AcseleV13_8Asesuisa.beans.Asesuisa_PolizaEmisionSinPlanFinanciamientoBean;
import AcseleV13_8Asesuisa.main.controller.Asesuisa_Menu.Asesuisa_MenuOperaciones;
import AcseleV13_8Asesuisa.main.controller.polizaEmision.*;
import metodo.Metodos;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by agil on 01/05/2017.
 */
public class Asesuisa_PolizaEmisionSinPlanFinanciamiento {

    private final static Logger log = Logger.getLogger(Asesuisa_PolizaEmisionSinPlanFinanciamiento.class);

    public String nombreAutomatizacion = "Asesuisa Emision Poliza sin Plan de Financiamiento";
    private WebDriver driver;

    public void testLink(Asesuisa_PolizaEmisionSinPlanFinanciamientoBean bean, int i, String folderName){

        try {

            // Instanciando clases
            Metodos a = new Metodos();
            Asesuisa_MenuOperaciones menuOperaciones = new Asesuisa_MenuOperaciones();
            Asesuisa_PrePoliza prePoliza = new Asesuisa_PrePoliza();
            Asesuisa_InformacionGeneralPoliza informacionGeneralPoliza = new Asesuisa_InformacionGeneralPoliza();
            Asesuisa_Tomador tomador = new Asesuisa_Tomador();
            Asesuisa_UnidadRiesgo unidadRiesgo = new Asesuisa_UnidadRiesgo();
            Asesuisa_ObjetoAsegurado objetoAsegurado = new Asesuisa_ObjetoAsegurado();
            Asesuisa_FinalizarPoliza finalizarPoliza = new Asesuisa_FinalizarPoliza();

            driver = a.entrarPagina(a.UrlAsesuisa());
            a.IniciarSesion(driver, nombreAutomatizacion, i, folderName);
            a.ValidandoSesion(driver, nombreAutomatizacion, i, folderName);
            Thread.sleep(5000);


            //Entrando en Menu
            menuOperaciones.OpePol_CotizacionSuscripcionEdicionCrearFrontEnd(driver, nombreAutomatizacion, 2, i, folderName);

            Thread.sleep(2000);
            a.cambiarVentana(driver);
            Thread.sleep(2000);

            /** Crear Poliza */

            Thread.sleep(3000);
            prePoliza.AdministracionPropuestaPoliza(a, driver, bean, nombreAutomatizacion, i, folderName, 3);
            Thread.sleep(2000);
            prePoliza.EvAplicar(a, driver, bean, nombreAutomatizacion, i, folderName, 4);
            Thread.sleep(2000);
            informacionGeneralPoliza.InformacionGeneralVidaIntegral(a, driver, bean, nombreAutomatizacion, i, folderName, 4, 5, 6);
            Thread.sleep(2000);
            tomador.AgregarTomador(a, driver, bean, nombreAutomatizacion, i, folderName, 7, 8);
            Thread.sleep(2000);
            unidadRiesgo.UnidadesRiesgo1(a, driver, bean, nombreAutomatizacion, i, folderName, 9);
            Thread.sleep(2000);
            objetoAsegurado.ObjetoAsegurado1(a, driver, bean, nombreAutomatizacion, i, folderName, 10);
            Thread.sleep(2000);
            objetoAsegurado.Asegurado1(a, driver, bean, nombreAutomatizacion, i, folderName, 11, 12);
            Thread.sleep(2000);
            objetoAsegurado.Requisitos1(a, driver, bean, nombreAutomatizacion, i, folderName, 13);
            Thread.sleep(2000);
            finalizarPoliza.Calcular(a, driver, nombreAutomatizacion, i, folderName, 14);
            Thread.sleep(2000);

            boolean prueba = driver.findElements(By.xpath("//span[@wicketpath='modalWindowForm_ErrorDialog_content_text']")).size() > 0;

            if (!prueba) {

                Thread.sleep(1000);
                a.ScreenShotPool(driver, i, "screen" + 15, nombreAutomatizacion, folderName);
                System.out.println("failed");
            }
            else {
                Thread.sleep(1000);
                a.ScreenShotPool(driver, i, "screen" + 15, nombreAutomatizacion, folderName);
                WebElement mensaje = driver.findElement(By.xpath("//span[@wicketpath='modalWindowForm_ErrorDialog_content_text']"));
                System.out.println("Mensaje: " + mensaje.getText());
            }


            driver.quit();

        } catch (Exception e) {
            e.printStackTrace();
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
            if (driver != null){
                driver.quit();
            }
        }
    }
}
