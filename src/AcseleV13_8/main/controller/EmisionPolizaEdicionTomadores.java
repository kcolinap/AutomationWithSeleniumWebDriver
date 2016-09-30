package AcseleV13_8.main.controller;

import AcseleV13_8.beans.EmisionPolizaEdicionTomadoresBean;
import AcseleV13_8.main.controller.Menu.MenuOperaciones;
import AcseleV13_8.main.controller.PolizaEmision.InformacionGeneralPoliza;
import AcseleV13_8.main.controller.PolizaEmision.PrePoliza;
import AcseleV13_8.main.controller.PolizaEmision.TerceroTomador;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.io.IOException;

/**
 * Created by agil on 29/07/2016.
 */
public class EmisionPolizaEdicionTomadores {

    private final static Logger log = Logger.getLogger(EmisionPolizaEdicionTomadores.class);

    public String nombreAutomatizacion = "Edicion de Póliza Edicion Tomadores";

    public void testLink(EmisionPolizaEdicionTomadoresBean emisionPolizaInclusionTomadoresBean, int i) throws IOException, InterruptedException {

        try {

            // Instanciando clases
            Metodos a = new Metodos();
            MenuOperaciones menuOperaciones = new MenuOperaciones();
            //PrePoliza
            PrePoliza prePoliza = new PrePoliza();
            InformacionGeneralPoliza informacionGeneralPoliza = new InformacionGeneralPoliza();
            TerceroTomador terceroTomador = new TerceroTomador();

            WebDriver driver = a.entrarPagina();
            JavascriptExecutor jse = (JavascriptExecutor)driver;
            a.IniciarSesion(driver, nombreAutomatizacion, i);
            a.ValidandoSesion(driver, nombreAutomatizacion, i);
            Thread.sleep(5000);

            //Entrando en Menu
            menuOperaciones.OpePol_Crear(driver, nombreAutomatizacion, 2);

            Thread.sleep(2000);
            a.cambiarVentana(driver);
            Thread.sleep(2000);

            /** Creando la póliza */

            // PrePoliza
            Thread.sleep(2000);
            prePoliza.AdminPropuestaPoliza(a, driver, emisionPolizaInclusionTomadoresBean, nombreAutomatizacion, i, 3);
            Thread.sleep(2000);
            prePoliza.EvAplicar(a, driver, emisionPolizaInclusionTomadoresBean, nombreAutomatizacion, i, 4);
            Thread.sleep(2000);
            informacionGeneralPoliza.InformacionGeneral(a, driver, emisionPolizaInclusionTomadoresBean, nombreAutomatizacion, i, 5);
            Thread.sleep(2000);
            terceroTomador.TomadorTercero(a, driver, emisionPolizaInclusionTomadoresBean, nombreAutomatizacion, i, 6, 7);
            Thread.sleep(2000);
            terceroTomador.TomadorTercero2(a, driver, emisionPolizaInclusionTomadoresBean, nombreAutomatizacion, i, 8, 9);
            Thread.sleep(2000);
            terceroTomador.EditarTomadorTercero1(a, driver, emisionPolizaInclusionTomadoresBean, nombreAutomatizacion, i, 10, 11, 12);
            Thread.sleep(2000);
            terceroTomador.EditarTomadorTercero2(a, driver, emisionPolizaInclusionTomadoresBean, nombreAutomatizacion, i, 13, 14, 15);

        } catch (Exception e) {
            e.printStackTrace();
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }

    }

}
