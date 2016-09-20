package AcseleV13_8.main.controller;

import AcseleV13_8.beans.ImpresionDocumentosNivelPolizaBean;
import AcseleV13_8.main.controller.PolizaEmision.*;
import AcseleV13_8.main.controller.Menu.MenuOperaciones;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

/**
 * Created by agil on 16/09/2016.
 */
public class ImpresionDocumentosNivelPoliza {

    private final static Logger log = Logger.getLogger(ImpresionDocumentosNivelPoliza.class);

    public String nombreAutomatizacion = "Terceros Documentos";

    public void testLink(ImpresionDocumentosNivelPolizaBean impresionDocumentosNivelPolizaBean, int i)throws Exception{

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
            menuOperaciones.OpePol_Crear(driver, nombreAutomatizacion, 2);

            Thread.sleep(2000);
            a.cambiarVentana(driver);
            Thread.sleep(2000);

            /** Creando la póliza */

            // PrePoliza
            Thread.sleep(2000);
            prePoliza.AdminPropuestaPoliza(a, driver, impresionDocumentosNivelPolizaBean, nombreAutomatizacion, i, 3);
            Thread.sleep(2000);
            prePoliza.EvAplicar(a, driver, impresionDocumentosNivelPolizaBean, nombreAutomatizacion, i, 4);
            Thread.sleep(2000);
            informacionGeneralPoliza.InformacionGeneral(a, driver, impresionDocumentosNivelPolizaBean, nombreAutomatizacion, i, 5);
            Thread.sleep(2000);
            //terceroTomador.TomadorTercero(a, driver, impresionDocumentosNivelPolizaBean, nombreAutomatizacion, i, 6, 7);
            //Thread.sleep(2000);
            unidadesRiesgo.UnidadesRiesgo(a, driver, impresionDocumentosNivelPolizaBean, nombreAutomatizacion, i, 8, 9);
            Thread.sleep(2000);
            objetoAsegurado.ObjetoAsegurado(a, driver, impresionDocumentosNivelPolizaBean, nombreAutomatizacion, i, 10);
            Thread.sleep(2000);
            aseguradoVida.ObjetoAsegurado(a, driver, impresionDocumentosNivelPolizaBean, nombreAutomatizacion, i, 11);






        }catch (Exception e) {
            e.printStackTrace();
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }

    }
}
