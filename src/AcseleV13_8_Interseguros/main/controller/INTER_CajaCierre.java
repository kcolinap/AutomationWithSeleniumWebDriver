package AcseleV13_8_Interseguros.main.controller;

/*import AcseleV13_8LBC.beans.LBC_CajaCierreBean;
import AcseleV13_8LBC.main.controller.LBC_Caja.LBC_Caja;
import AcseleV13_8LBC.main.controller.LBC_Menu.LBC_MenuOperaciones;
import AcseleV13_8LBC.main.controller.LBC_Metodos;*/
import AcseleV13_8_Interseguros.beans.INTER_CajaCierreBean;
import AcseleV13_8_Interseguros.main.controller.INTER_Caja.INTER_Caja;
import AcseleV13_8_Interseguros.main.controller.Interseguros_Menu.Interseguros_MenuOperaciones;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

/**
 * Created by mchurion on 13/12/2016.
 */
public class INTER_CajaCierre {
    private final static Logger log = Logger.getLogger(INTER_CajaCierre.class);

    public String nombreAutomatizacion = "INTER Caja Cierre";

    public void testLink(INTER_CajaCierreBean interCajaCierreBean, int i) throws IOException, InterruptedException {

        try {

            // Instanciando clases
            Interseguros_Metodos a = new Interseguros_Metodos();
            Interseguros_MenuOperaciones interMenuOperaciones = new Interseguros_MenuOperaciones();
            //Aperturar Caja
            INTER_Caja interCaja = new INTER_Caja();


            WebDriver driver = a.entrarPagina();
            a.IniciarSesion(driver, nombreAutomatizacion, i);
            a.ValidandoSesion(driver, nombreAutomatizacion, i);
            Thread.sleep(5000);


            //Entrando en Menu
            interMenuOperaciones.UAA_Caja_CierreCaja(driver, nombreAutomatizacion, 2, i);

            Thread.sleep(2000);
            a.cambiarVentana(driver);
            Thread.sleep(2000);

            /** Asociar la Caja a Cajero */

            Thread.sleep(3000);
            interCaja.CierreCaja(a, driver, interCajaCierreBean, nombreAutomatizacion, i, 3, 4, 5);


        } catch (Exception e) {
            e.printStackTrace();
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }
}
