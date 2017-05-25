package AcseleV13_8Asesuisa.main.controller;

import AcseleV13_8Asesuisa.beans.Asesuisa_PolizaEmisionVariosOAAutomotoresBean;
import AcseleV13_8Asesuisa.main.controller.Asesuisa_Menu.Asesuisa_MenuOperaciones;
import AcseleV13_8Asesuisa.main.controller.polizaEmision.*;
import metodo.Metodos;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by agil on 10/05/2017.
 */
public class Asesuisa_PolizaEmisionVariosOAAutomotores {

    private final static Logger log = Logger.getLogger(Asesuisa_PolizaEmisionVariosOAAutomotores.class);

    public String nombreAutomatizacion = "Asesuisa Emision Poliza con Varios OA";
    private WebDriver driver;

    public void testLink(Asesuisa_PolizaEmisionVariosOAAutomotoresBean bean, int i, String folderName){

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
            informacionGeneralPoliza.InformacionGeneralAutomotores(a, driver, bean, nombreAutomatizacion, i, folderName, 5, 6, 7);
            Thread.sleep(2000);
            tomador.AgregarTomador(a, driver, bean, nombreAutomatizacion, i, folderName, 8, 9);
            Thread.sleep(2000);
            unidadRiesgo.UnidadesRiesgoAutomotores1(a, driver, bean, nombreAutomatizacion, i, folderName, 10);
            Thread.sleep(2000);
            objetoAsegurado.ObjetoAseguradoAutomotores1(a, driver, bean, nombreAutomatizacion, i, folderName, 11, 12, 13 ,14, 15, 16, 17, 18);
            Thread.sleep(2000);
            objetoAsegurado.Asegurado1(a, driver, bean, nombreAutomatizacion, i, folderName, 19, 20);
            Thread.sleep(2000);
            objetoAsegurado.ObjetoAseguradoAutomotores2(a, driver, bean, nombreAutomatizacion, i, folderName, 21, 22, 23, 24, 25, 26, 27, 28);
            Thread.sleep(2000);
            objetoAsegurado.Asegurado2(a, driver, bean, nombreAutomatizacion, i, folderName, 29, 30);
            Thread.sleep(2000);
            finalizarPoliza.Calcular(a, driver, nombreAutomatizacion, i, folderName, 31,32);
            Thread.sleep(2000);
            finalizarPoliza.ResumenAplicar(a, driver, nombreAutomatizacion, i, folderName, 33);
            Thread.sleep(2000);
            finalizarPoliza.ResumenPoliza(a, driver, nombreAutomatizacion, i, folderName, 34);

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
