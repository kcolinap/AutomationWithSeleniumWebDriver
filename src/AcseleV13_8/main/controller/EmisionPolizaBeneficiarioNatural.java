package AcseleV13_8.main.controller;

import AcseleV13_8.beans.EmisionPolizaBeneficiarioNaturalBean;
import AcseleV13_8.main.controller.Menu.MenuOperaciones;
import AcseleV13_8.main.controller.PolizaEmision.*;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.io.IOException;

/**
 * Created by agil on 02/08/2016.
 */
public class EmisionPolizaBeneficiarioNatural {

    private final static Logger log = Logger.getLogger(EmisionPolizaBeneficiarioNatural.class);

    public String nombreAutomatizacion = "Emision de Póliza Beneficiario Natural";

    public void testLink(EmisionPolizaBeneficiarioNaturalBean emisionPolizaBeneficiarioNaturalBean, int i) throws IOException, InterruptedException {

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
            BeneficiarioNatural beneficiarioNatural = new BeneficiarioNatural();

            WebDriver driver = a.entrarPagina();
            JavascriptExecutor jse = (JavascriptExecutor)driver;
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
            prePoliza.AdminPropuestaPoliza(a, driver, emisionPolizaBeneficiarioNaturalBean, nombreAutomatizacion, i, 3);
            Thread.sleep(2000);
            prePoliza.EvAplicar(a, driver, emisionPolizaBeneficiarioNaturalBean, nombreAutomatizacion, i, 4);
            Thread.sleep(2000);
            informacionGeneralPoliza.InformacionGeneral(a, driver, emisionPolizaBeneficiarioNaturalBean, nombreAutomatizacion, i, 5);
            Thread.sleep(2000);
            terceroTomador.TomadorTercero(a, driver, emisionPolizaBeneficiarioNaturalBean, nombreAutomatizacion, i, 6, 7);
            Thread.sleep(2000);
            unidadesRiesgo.UnidadesRiesgo(a, driver, emisionPolizaBeneficiarioNaturalBean, nombreAutomatizacion, i, 8, 9);
            Thread.sleep(2000);
            objetoAsegurado.ObjetoAsegurado(a, driver, emisionPolizaBeneficiarioNaturalBean, nombreAutomatizacion, i, 10);
            Thread.sleep(2000);
            jse.executeScript("window.scrollBy(0,500)", "");
            Thread.sleep(2000);
            beneficiarioNatural.AgregarBneficiarioNaturalBusquedaSimple(a, driver, emisionPolizaBeneficiarioNaturalBean, nombreAutomatizacion, i, 11, 12, 13);
            Thread.sleep(2000);
            beneficiarioNatural.EditarBeneficiarioNatural(a, driver, emisionPolizaBeneficiarioNaturalBean, nombreAutomatizacion, i, 14, 15);
            Thread.sleep(2000);
            beneficiarioNatural.EliminarBeneficiarioNatural(a, driver, nombreAutomatizacion, i, 16, 17, 18, 19);



        } catch (Exception e) {
            e.printStackTrace();
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }

}
