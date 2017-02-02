package AcseleV13_8_Interseguros.main.controller;

import AcseleV13_8_Interseguros.beans.INTER_CrearCoincidenciaBean;
import AcseleV13_8_Interseguros.main.controller.Interseguros_Menu.Interseguros_MenuMantenimiento;
import AcseleV13_8_Interseguros.main.controller.Interseguros_Menu.Interseguros_MenuOperaciones;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

/**
 * Created by aazuaje on 31/01/2017.
 */
public class INTER_CrearCoincidencia {

    private final static Logger log = Logger.getLogger(INTER_CrearCoincidencia.class);

    public String nombreAutomatizacion = "Crear Coincidencia";
    private WebDriver driver;

    public void testLink (INTER_CrearCoincidenciaBean inter_busquedaSiniestroAvanzadaBean, int i, String folderName)  throws IOException, InterruptedException {

        try{
            Interseguros_Metodos a = new Interseguros_Metodos();
            Interseguros_MenuMantenimiento m = new Interseguros_MenuMantenimiento();

            driver = a.entrarPagina();
            a.IniciarSesion(driver, nombreAutomatizacion, i, folderName);
            a.ValidandoSesion(driver, nombreAutomatizacion, i, folderName);
            Thread.sleep(1500);
            System.out.println("prueba");

            m.OpeSini_MantenimientoSiniestro(driver,a , nombreAutomatizacion,2, i, folderName);
            Thread.sleep(3000);
            a.cambiarVentana(driver);


            /*BuscarSiniestro(a, inter_busquedaSiniestroAvanzadaBean, i, folderName, 3, 4, 5);
            BuscarSiniestroPoliza (a, inter_busquedaSiniestroAvanzadaBean, i, folderName, 3, 4, 5);
            BuscarSiniestroTercero (a, inter_busquedaSiniestroAvanzadaBean, i, folderName, 3, 4, 5);*/
            Thread.sleep(2000);
            a.cambiarVentana(driver);
            // Thread.sleep(1500);

            driver.quit();
        }catch (Exception e){
            e.printStackTrace();
            log.error("Test Case - " + nombreAutomatizacion + " - " + e);
            if (driver != null){
                driver.quit();
            }
        }

    }
}
