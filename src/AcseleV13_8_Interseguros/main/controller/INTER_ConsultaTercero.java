package AcseleV13_8_Interseguros.main.controller;

import AcseleV13_8_Interseguros.beans.INTER_ConsultaTerceroBean;
import AcseleV13_8_Interseguros.main.controller.Inter_Terceros.Inter_BuscarTerceros;
import AcseleV13_8_Interseguros.main.controller.Interseguros_Menu.Interseguros_MenuMantenimiento;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;

/**
 * Created by rmontilla on 14/11/2016.
 */

/**
 * Modified by Kcolina on 09/02/2017
 * Implementando herencia de la clase Inter_Buscar_terceros
 */
public class INTER_ConsultaTercero extends Inter_BuscarTerceros {

    private final static Logger log = Logger.getLogger(INTER_ConsultaTercero.class);

    public String nombreAutomatizacion ="INTER Consulta Terceros";
    private WebDriver driver;

    public void testLink(INTER_ConsultaTerceroBean inter_consultaTerceroBean, int i, String folderName)throws Exception {

        try {

            // Instanciando clases
            Interseguros_Metodos a= new Interseguros_Metodos();   //implementando metodos.
            Interseguros_MenuMantenimiento interseguros_menuMantenimiento = new Interseguros_MenuMantenimiento();
            Inter_BuscarTerceros buscarTerceros = new Inter_BuscarTerceros();

            driver = a.entrarPagina();
            a.IniciarSesion(driver, nombreAutomatizacion, i, folderName); //iniciando sesion.
            a.ValidandoSesion(driver, nombreAutomatizacion, i, folderName); //validando sesion.
            Thread.sleep(3000);

            //Entrando en Menu
            interseguros_menuMantenimiento.MantTerc_BuscarTercero(driver,nombreAutomatizacion, i, 2, folderName);

            Thread.sleep(1000);
            a.cambiarVentana(driver); // Cambiar de ventana

            //llamada a metodo de clase Inter_BuscarTerceros
           buscarTerceros.BusquedaT(driver, a, inter_consultaTerceroBean, nombreAutomatizacion, i, folderName, 3,4,5,6);
            Thread.sleep(2000);
            driver.quit();

        }catch (Exception e) {
            e.printStackTrace();
            log.error("Test Case - " + nombreAutomatizacion + " - " + e);
            if (driver != null) {
                driver.quit();
            }
        }
    }
}
