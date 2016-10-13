package AcseleV13_8.main.controller;

import AcseleV13_8.beans.EmisionPolizaVariasURBean;
import AcseleV13_8.main.controller.Menu.MenuOperaciones;
import AcseleV13_8.main.controller.PolizaEmision.*;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.io.IOException;

/**
 * Created by agil on 18/07/2016.
 */
public class EmisionPolizaVariasUR {

    private final static Logger log = Logger.getLogger(EmisionPolizaVariasUR.class);

    public String nombreAutomatizacion = "Emision de Póliza con Varias UR";

    public void testLink(EmisionPolizaVariasURBean emisionPolizaVariasURBean, int i) throws IOException, InterruptedException {

        try {

            // Instanciando clases
            Metodos a = new Metodos();
            MenuOperaciones menuOperaciones = new MenuOperaciones();
            //PrePoliza
            PrePoliza prePoliza = new PrePoliza();
            InformacionGeneralPoliza informacionGeneralPoliza = new InformacionGeneralPoliza();
            TerceroTomador terceroTomador = new TerceroTomador();
            UnidadesRiesgo unidadesRiesgo = new UnidadesRiesgo();

            WebDriver driver = a.entrarPagina();
            a.IniciarSesion(driver, nombreAutomatizacion, i);
            a.ValidandoSesion(driver, nombreAutomatizacion, i);
            Thread.sleep(5000);


            //Entrando en Menu
            menuOperaciones.OpePol_Crear(driver, nombreAutomatizacion, 2, i);

            Thread.sleep(2000);
            a.cambiarVentana(driver);
            Thread.sleep(2000);

            /** Creando la póliza */

            // PrePoliza
            Thread.sleep(3000);
            prePoliza.AdminPropuestaPoliza(a, driver, emisionPolizaVariasURBean, nombreAutomatizacion, i, 3);
            Thread.sleep(2000);
            prePoliza.EvAplicar(a, driver, emisionPolizaVariasURBean, nombreAutomatizacion, i, 4);
            Thread.sleep(2000);
            informacionGeneralPoliza.InformacionGeneral(a, driver, emisionPolizaVariasURBean, nombreAutomatizacion, i, 5);
            Thread.sleep(2000);
            //terceroTomador.TomadorTercero(a, driver, emisionPolizaVariasURBean, nombreAutomatizacion, i, 6, 7);
            Thread.sleep(2000);
            unidadesRiesgo.UnidadesRiesgo(a, driver, emisionPolizaVariasURBean, nombreAutomatizacion, i, 8, 9);
            Thread.sleep(2000);
            unidadesRiesgo.UnidadesRiesgo2(a, driver, emisionPolizaVariasURBean, nombreAutomatizacion, i, 10, 11);

        } catch (Exception e) {
            e.printStackTrace();
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }


    }

}
