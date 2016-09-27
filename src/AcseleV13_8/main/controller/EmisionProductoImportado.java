package AcseleV13_8.main.controller;

import AcseleV13_8.beans.EmisionProductoImportadoBean;
import AcseleV13_8.main.controller.Menu.MenuOperaciones;
import AcseleV13_8.main.controller.PolizaEmision.*;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

/**
 * Created by aazuaje on 27/09/2016.
 */
public class EmisionProductoImportado {


    private final static Logger log = Logger.getLogger(ImpresionDocumentosNivelPoliza.class);

    public String nombreAutomatizacion = "Emision Producto Importado";

    public void testLink(EmisionProductoImportadoBean emisionProductoImportadoBean, int i)throws Exception{

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
            prePoliza.AdminPropuestaPoliza(a, driver, emisionProductoImportadoBean, nombreAutomatizacion, i, 3);
            Thread.sleep(2000);
            prePoliza.EvAplicar(a, driver, emisionProductoImportadoBean, nombreAutomatizacion, i, 4);
            Thread.sleep(2000);
            informacionGeneralPoliza.InformacionGeneral(a, driver, emisionProductoImportadoBean, nombreAutomatizacion, i, 5);
            Thread.sleep(2000);
            terceroTomador.TomadorTercero(a, driver, emisionProductoImportadoBean, nombreAutomatizacion, i, 6, 7);
            //Thread.sleep(2000);
            unidadesRiesgo.UnidadesRiesgo(a, driver, emisionProductoImportadoBean, nombreAutomatizacion, i, 8, 9);
            Thread.sleep(2000);
            objetoAsegurado.ObjetoAsegurado(a, driver, emisionProductoImportadoBean, nombreAutomatizacion, i, 10);
            Thread.sleep(2000);
            aseguradoVida.AseguradoVida(a, driver, emisionProductoImportadoBean, nombreAutomatizacion, i, 11);
            Thread.sleep(2000);
           // Calcular(a, driver, i, 12, 13, 14, 15);


        }catch (Exception e) {
            e.printStackTrace();
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }

    }
}
