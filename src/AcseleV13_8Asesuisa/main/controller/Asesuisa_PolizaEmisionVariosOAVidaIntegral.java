package AcseleV13_8Asesuisa.main.controller;

import AcseleV13_8Asesuisa.beans.Asesuisa_PolizaEmisionVariosOAVidaIntegralBean;
import AcseleV13_8Asesuisa.main.controller.Asesuisa_Menu.Asesuisa_MenuOperaciones;
import AcseleV13_8Asesuisa.main.controller.polizaEmision.Asesuisa_InformacionGeneralPoliza;
import AcseleV13_8Asesuisa.main.controller.polizaEmision.Asesuisa_PrePoliza;
import AcseleV13_8Asesuisa.main.controller.polizaEmision.Asesuisa_Tomador;
import AcseleV13_8Asesuisa.main.controller.polizaEmision.*;

import metodo.Metodos;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

/**
 * Created by agil on 21/02/2017.
 */
public class Asesuisa_PolizaEmisionVariosOAVidaIntegral {

    private final static Logger log = Logger.getLogger(Asesuisa_PolizaEmisionVariosOAVidaIntegral.class);

    public String nombreAutomatizacion = "Asesuisa Poliza Emision Varios OA Vida Integral";
    private WebDriver driver;

    public void testLink(Asesuisa_PolizaEmisionVariosOAVidaIntegralBean bean, int i, String folderName){

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
            objetoAsegurado.ObjetoAsegurado2(a, driver, bean, nombreAutomatizacion, i, folderName, 14);
            Thread.sleep(2000);
            objetoAsegurado.Asegurado2(a, driver, bean, nombreAutomatizacion, i, folderName, 15, 16);
            Thread.sleep(2000);
            objetoAsegurado.Requisitos2(a, driver, bean, nombreAutomatizacion, i, folderName, 17);
            Thread.sleep(2000);
            finalizarPoliza.Calcular(a, driver, nombreAutomatizacion, i, folderName, 18, 19);
            Thread.sleep(2000);
            finalizarPoliza.ResumenAplicar(a, driver, nombreAutomatizacion, i, folderName, 20);
            Thread.sleep(2000);
            finalizarPoliza.ResumenPoliza(a, driver, nombreAutomatizacion, i, folderName, 21);

//            driver.quit();

        } catch (Exception e) {
            e.printStackTrace();
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
            if (driver != null){
//                driver.quit();
            }
        }
    }
}
