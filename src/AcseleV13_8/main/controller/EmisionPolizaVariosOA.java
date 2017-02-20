package AcseleV13_8.main.controller;

import AcseleV13_8.beans.EmisionPolizaVariosOABean;
import AcseleV13_8.main.controller.Menu.MenuOperaciones;
import AcseleV13_8.main.controller.PolizaEmision.*;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

/**
 * Created by agil on 20/07/2016.
 */
public class EmisionPolizaVariosOA {

    private final static Logger log = Logger.getLogger(EmisionPolizaVariosOA.class);

    public String nombreAutomatizacion = "Emision de Póliza con Varios OA";

    public void testLink(EmisionPolizaVariosOABean emisionPolizaVariosOABean, int i) throws IOException, InterruptedException {

        try {

            // Instanciando clases
            Metodos13_8 a = new Metodos13_8();
            MenuOperaciones menuOperaciones = new MenuOperaciones();
            //PrePoliza
            PrePoliza prePoliza = new PrePoliza();
            InformacionGeneralPoliza informacionGeneralPoliza = new InformacionGeneralPoliza();
            TerceroTomador terceroTomador = new TerceroTomador();
            UnidadesRiesgo unidadesRiesgo = new UnidadesRiesgo();
            ObjetoAsegurado objetoAsegurado = new ObjetoAsegurado();

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
            prePoliza.AdminPropuestaPoliza(a, driver, emisionPolizaVariosOABean, nombreAutomatizacion, i, 3);
            Thread.sleep(2000);
            prePoliza.EvAplicar(a, driver, emisionPolizaVariosOABean, nombreAutomatizacion, i, 4);
            Thread.sleep(2000);
            informacionGeneralPoliza.InformacionGeneral(a, driver, emisionPolizaVariosOABean, nombreAutomatizacion, i, 5);
            Thread.sleep(2000);
            //terceroTomador.TomadorTercero(a, driver, emisionPolizaVariosOABean, nombreAutomatizacion, i, 6, 7);
            //Thread.sleep(2000);
            unidadesRiesgo.UnidadesRiesgo(a, driver, emisionPolizaVariosOABean, nombreAutomatizacion, i, 8, 9);
            Thread.sleep(2000);
            objetoAsegurado.ObjetoAsegurado(a, driver, emisionPolizaVariosOABean, nombreAutomatizacion, i, 10);
            Thread.sleep(2000);
            objetoAsegurado.ObjetoAsegurado2(a, driver, emisionPolizaVariosOABean, nombreAutomatizacion, i, 11);

        } catch (Exception e) {
            e.printStackTrace();
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }

    }

}
