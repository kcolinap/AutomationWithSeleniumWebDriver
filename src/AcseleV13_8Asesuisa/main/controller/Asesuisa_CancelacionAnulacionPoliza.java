package AcseleV13_8Asesuisa.main.controller;

import AcseleV13_8Asesuisa.beans.Asesuisa_CancelacionAnulacionPolizaBean;
import AcseleV13_8Asesuisa.main.controller.Asesuisa_Menu.Asesuisa_MenuOperaciones;

import metodo.Metodos;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;

/**
 * Created by kcolina on 29/03/2017.
 */
public class Asesuisa_CancelacionAnulacionPoliza {

    private final static Logger Log = Logger.getLogger(Asesuisa_ConsultaEdoCuentaTerceros.class);
    public String nombreAutomatizacion = "Cancelacion-Anulacion de Poliza";
    private WebDriver driver;

    public void testLink(Asesuisa_CancelacionAnulacionPolizaBean asesuisaCancelacionAnulacionPolizaBean, int i,
                         String folderName){
        try{

            Metodos m = new Metodos();
            Asesuisa_MenuOperaciones menuOperaciones = new Asesuisa_MenuOperaciones();

            //Inicio y valido sesion a la aplicacion
            driver=m.entrarPagina(m.UrlAsesuisa());
            m.IniciarSesion(driver, nombreAutomatizacion, i, folderName);
            m.ValidandoSesion(driver, nombreAutomatizacion, i, folderName);
            Thread.sleep(1000);

            //Ingreso a la opcion: Cotizacion-suscripcion-mantenimiento de edicion(FrontEnd)
            menuOperaciones.OpePol_CotizacionSuscripcionEdicion_MantenimientoEdicionFrontEnd(driver, nombreAutomatizacion,
                    2,i,folderName);
            Thread.sleep(1200);
            m.cambiarVentana(driver);
            Thread.sleep(1000);


            //Cierra navegador
            Thread.sleep(1000);
            driver.quit();

        }catch (Exception e){
            e.printStackTrace();
            Log.error("Test Case - " + nombreAutomatizacion + " - " + e);
            if (driver != null) {
                driver.quit();
            }
        }
    }
}
