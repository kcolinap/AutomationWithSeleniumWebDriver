package AcseleV13_8.main.controller;

import AcseleV13_8.beans.EmisionPolizaAseguradoVidaBean;
import AcseleV13_8.main.controller.Menu.MenuOperaciones;
import AcseleV13_8.main.controller.PolizaEmision.*;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.io.IOException;

/**
 * Created by agil on 11/08/2016.
 */
public class EmisionPolizaAseguradoVida {

    private final static Logger log = Logger.getLogger(EmisionPolizaAseguradoVida.class);

    public String nombreAutomatizacion = "Emision de Póliza Asegurado Vida";

    public void testLink(EmisionPolizaAseguradoVidaBean emisionPolizaAseguradoVidaBean, int i) throws IOException, InterruptedException {

        try {

            // Instanciando clases
            Metodos a = new Metodos();
            MenuOperaciones menuOperaciones = new MenuOperaciones();
            //PrePoliza
            PrePoliza prePoliza = new PrePoliza();
            InformacionGeneralPoliza informacionGeneralPoliza = new InformacionGeneralPoliza();
            TerceroTomador terceroTomador = new TerceroTomador();
            UnidadesRiesgo unidadesRiesgo = new UnidadesRiesgo();
            ObjetoAsegurado objetoAsegurado = new ObjetoAsegurado();
            AseguradoVida aseguradoVida = new AseguradoVida();

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
            Thread.sleep(2000);
            prePoliza.AdminPropuestaPoliza(a, driver, emisionPolizaAseguradoVidaBean, nombreAutomatizacion, i, 3);
            Thread.sleep(2000);
            prePoliza.EvAplicar(a, driver, emisionPolizaAseguradoVidaBean, nombreAutomatizacion, i, 4);
            Thread.sleep(2000);
            informacionGeneralPoliza.InformacionGeneral(a, driver, emisionPolizaAseguradoVidaBean, nombreAutomatizacion, i, 5);
            Thread.sleep(2000);
            terceroTomador.TomadorTercero(a, driver, emisionPolizaAseguradoVidaBean, nombreAutomatizacion, i, 6, 7);
            //Thread.sleep(2000);
            unidadesRiesgo.UnidadesRiesgo(a, driver, emisionPolizaAseguradoVidaBean, nombreAutomatizacion, i, 8, 9);
            Thread.sleep(2000);
            objetoAsegurado.ObjetoAsegurado(a, driver, emisionPolizaAseguradoVidaBean, nombreAutomatizacion, i, 10);
            Thread.sleep(2000);
            aseguradoVida.AseguradoVida(a, driver, emisionPolizaAseguradoVidaBean, nombreAutomatizacion, i, 11);
            Thread.sleep(2000);
            aseguradoVida.EditarAseguradoVida(a, driver, emisionPolizaAseguradoVidaBean, nombreAutomatizacion, i, 12, 13, 14);
            Thread.sleep(2000);
            aseguradoVida.EliminarAseguradoVida(a, driver, emisionPolizaAseguradoVidaBean, nombreAutomatizacion, i, 15, 16, 17);

        } catch (Exception e) {
        e.printStackTrace();
        //             log.info(e);
        log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }

    }

}
