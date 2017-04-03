package AcseleV13_8Asesuisa.main.controller;

import AcseleV13_8Asesuisa.beans.Asesuisa_PolizaEmisionGeneral30282Bean;
import AcseleV13_8Asesuisa.main.controller.polizaEmision.*;
import AcseleV13_8Asesuisa.main.controller.Asesuisa_Menu.Asesuisa_MenuOperaciones;

import metodo.Metodos;
import org.apache.log4j.DailyRollingFileAppender;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;


/**
 * Created by kcolina on 03/04/2017.
 */
public class Asesuisa_PolizaEmisionGeneral30282 {

    private final static Logger log = Logger.getLogger(Asesuisa_PolizaEmisionGeneral30282.class);

    public String nombreAutomatizacion = "Emision poliza 30282";
    private WebDriver driver;

    public void testLink(Asesuisa_PolizaEmisionGeneral30282Bean bean, int i, String folderName){


        try{

            //instanciar clase metodos
            Metodos metodos = new Metodos();
            Asesuisa_PrePoliza prePoliza = new Asesuisa_PrePoliza();
            Asesuisa_InformacionGeneralPoliza informacionGeneralPoliza = new Asesuisa_InformacionGeneralPoliza();
            Asesuisa_MenuOperaciones menuOperaciones = new Asesuisa_MenuOperaciones();

            driver = metodos.entrarPagina(metodos.UrlAsesuisa());
            metodos.IniciarSesion(driver, nombreAutomatizacion, i, folderName);
            metodos.ValidandoSesion(driver, nombreAutomatizacion, i, folderName);
            Thread.sleep(1000);

            menuOperaciones.OpePol_CotizacionSuscripcionEdicionCrearFrontEnd(driver, nombreAutomatizacion, 2, i,
                    folderName);
            Thread.sleep(1500);
            metodos.cambiarVentana(driver);

            /******************************
             * Comienzo de generacion de poliza
             */
            /**
             * PREPOLIZA
             */
            prePoliza.AdministracionPropuestaPoliza(metodos,driver,bean, nombreAutomatizacion, i, folderName, 4);
            Thread.sleep(800);

            prePoliza.EvAplicar(metodos,driver,bean,nombreAutomatizacion,i,folderName,5);
            Thread.sleep(800);
            /**
             * **********************************
             */

            /**
             * INFORMACION GENERAL POLIZA
             */
            informacionGeneralPoliza.InformacionGeneralRoboYHurto(metodos, driver, bean, nombreAutomatizacion, i,
                    folderName,6,7,8);
            Thread.sleep(800);
            /**
             * *****************
             */

            /***
             * FIN GENERACION DE POLIZA
             */
            driver.quit();

        }catch (Exception e) {
            e.printStackTrace();
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
            if (driver != null){
                driver.quit();
            }
        }
    }
}
