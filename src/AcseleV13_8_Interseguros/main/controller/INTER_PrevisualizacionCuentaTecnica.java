package AcseleV13_8_Interseguros.main.controller;

import AcseleV13_8_Interseguros.beans.INTER_ConsultaCuentaTecnicaBean;
import AcseleV13_8_Interseguros.beans.INTER_PrevisualizacionCuentaTecnicaBean;
import AcseleV13_8_Interseguros.main.controller.Interseguros_Menu.Interseguros_MenuOperaciones;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

/**
 * Created by aazuaje on 09/12/2016.
 */
public class INTER_PrevisualizacionCuentaTecnica {

    private final static Logger log = Logger.getLogger(INTER_PrevisualizacionCuentaTecnica.class);
    public String nombreAutomatizacion ="Previsualizacion Cuenta Tecnica";

    public void testLink (INTER_PrevisualizacionCuentaTecnicaBean inter_previsualizacionCuentaTecnicaBean, int i )  throws Exception {

        //Metodos a = new Metodos();
        Interseguros_Metodos a = new Interseguros_Metodos();
        Interseguros_MenuOperaciones m = new Interseguros_MenuOperaciones();


        WebDriver driver = a.entrarPagina();
        a.IniciarSesion(driver, nombreAutomatizacion, i);
        a.ValidandoSesion(driver, nombreAutomatizacion, i);
        Thread.sleep(1500);
        System.out.println("prueba");

        m.CoaRea_CuentasTecnicas_PrevisualizacionCuentasTecnicas(driver, nombreAutomatizacion, 3, i);
        Thread.sleep(2000);
        a.cambiarVentana(driver);
        PrevisualizacionCuentaTecnica(driver, a, inter_previsualizacionCuentaTecnicaBean, i);


    }

    public void PrevisualizacionCuentaTecnica(WebDriver driver, Interseguros_Metodos a, INTER_PrevisualizacionCuentaTecnicaBean inter_previsualizacionCuentaTecnicaBean, int i) throws IOException, InterruptedException{

        try {
            Thread.sleep(1000);





        }catch (Exception e) {
            e.printStackTrace();
//                log.info(e);
            log.error("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }