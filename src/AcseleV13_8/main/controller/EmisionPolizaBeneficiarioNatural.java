package AcseleV13_8.main.controller;

import AcseleV13_8.beans.EmisionPolizaBeneficiarioNaturalBean;
import AcseleV13_8.main.controller.EmisionPoliza.*;
import AcseleV13_8.main.controller.Menu.MenuOperaciones;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
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

        // Instanciando clases
        Metodos a = new Metodos();
        MenuOperaciones menuOperaciones = new MenuOperaciones();
        AdminitracionPropuestaPoliza adminitracionPropuestaPoliza = new AdminitracionPropuestaPoliza();

        InformacionGeneralPoliza informacionGeneralPoliza = new InformacionGeneralPoliza();
        TerceroTomador terceroTomador = new TerceroTomador();
        UnidadRiesgo unidadRiesgo = new UnidadRiesgo();
        ObjetoAsegurado objetoAsegurado = new ObjetoAsegurado();
        BeneficiarioNatural beneficiarioNatural = new BeneficiarioNatural();

        WebDriver driver = a.entrarPagina();
        a.IniciarSesion(driver, nombreAutomatizacion);
        Thread.sleep(2000);
        a.ValidandoSesion(driver, nombreAutomatizacion);
        Thread.sleep(5000);

        // Creación de Póliza
        menuOperaciones.OpePol_Crear(driver, nombreAutomatizacion, 2);

        Thread.sleep(2000);
        a.cambiarVentana(driver);
        Thread.sleep(2000);
        CrearPoliza(a, driver, emisionPolizaBeneficiarioNaturalBean, adminitracionPropuestaPoliza,
                informacionGeneralPoliza, terceroTomador, unidadRiesgo, objetoAsegurado, beneficiarioNatural);
    }

    public void CrearPoliza(Metodos a, WebDriver driver, EmisionPolizaBeneficiarioNaturalBean emisionPolizaBeneficiarioNaturalBean,
                            AdminitracionPropuestaPoliza adminitracionPropuestaPoliza,
                            InformacionGeneralPoliza informacionGeneralPoliza, TerceroTomador terceroTomador,
                            UnidadRiesgo unidadRiesgo, ObjetoAsegurado objetoAsegurado,
                            BeneficiarioNatural beneficiarioNatural) throws InterruptedException {

        // //TipoElemento[@wicketpath='WicketpathElemento']
        Thread.sleep(2000);
        adminitracionPropuestaPoliza.AdminPropuestaPoliza(a, driver, emisionPolizaBeneficiarioNaturalBean, nombreAutomatizacion);

        /***Espera***/
        WebElement mensajeEspera = driver.findElement(By.id("waitMessage"));
        while (mensajeEspera.isDisplayed()){
            Thread.sleep(5000);
            System.out.println("Espera 1");
        }

        Thread.sleep(3000);
        adminitracionPropuestaPoliza.EvAplicar(a, driver, emisionPolizaBeneficiarioNaturalBean, nombreAutomatizacion);

        Thread.sleep(4000);
        informacionGeneralPoliza.InformacionGeneral(a, driver, emisionPolizaBeneficiarioNaturalBean, nombreAutomatizacion);

        Thread.sleep(4000);

        /***Espera***/
        WebElement mensajeEspera2 = driver.findElement(By.id("waitMessage"));
        while (mensajeEspera2.isDisplayed()){
            Thread.sleep(5000);
            System.out.println("Espera 2");
        }
        terceroTomador.TomadorTercero(a, driver, emisionPolizaBeneficiarioNaturalBean, nombreAutomatizacion);

        Thread.sleep(2000);
        unidadRiesgo.UnidadRiesgo(a, driver, emisionPolizaBeneficiarioNaturalBean, nombreAutomatizacion);

        Thread.sleep(2000);
        objetoAsegurado.ObjetoAsegurado(a, driver, emisionPolizaBeneficiarioNaturalBean, nombreAutomatizacion);

        Thread.sleep(2000);
        beneficiarioNatural.AgregarBeneficiarioNatural(a, driver, emisionPolizaBeneficiarioNaturalBean, nombreAutomatizacion);

        Thread.sleep(2000);
        beneficiarioNatural.EditarBeneficiarioNatural(a, driver, emisionPolizaBeneficiarioNaturalBean, nombreAutomatizacion);

        Thread.sleep(2000);
        beneficiarioNatural.EliminarBeneficiarioNatural(a, driver, emisionPolizaBeneficiarioNaturalBean, nombreAutomatizacion);
    }


    /**Poliza**/




}
