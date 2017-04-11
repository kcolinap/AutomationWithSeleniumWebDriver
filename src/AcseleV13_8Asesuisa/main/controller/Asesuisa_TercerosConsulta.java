package AcseleV13_8Asesuisa.main.controller;

import AcseleV13_8Asesuisa.beans.Asesuisa_TercerosConsultaBean;
import AcseleV13_8Asesuisa.main.controller.Asesuisa_Terceros.Asesuisa_BuscarTerceros;
import AcseleV13_8Asesuisa.main.controller.Asesuisa_Menu.Asesuisa_MenuMantenimiento;
import metodo.Metodos;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.awt.*;


/**
 * Created by kcolina on 21/02/2017.
 */
public class Asesuisa_TercerosConsulta extends Asesuisa_BuscarTerceros {

    private final static Logger log = Logger.getLogger(Asesuisa_TercerosConsulta.class);

    public String nombreAutomatizacion = "Consulta de terceros";
    private WebDriver driver;

    public void testLink(Asesuisa_TercerosConsultaBean asesuisaTercerosConsultaBean, int i, String folderName){

        try{

            Metodos m = new Metodos();
            Asesuisa_MenuMantenimiento asesuisaMenuMantenimiento = new Asesuisa_MenuMantenimiento();

            driver = m.entrarPagina(m.UrlAsesuisa());
            m.IniciarSesion(driver, nombreAutomatizacion,i,folderName);
            m.ValidandoSesion(driver, nombreAutomatizacion, i, folderName);
            Thread.sleep(1000);

            //Ingreso a la opcion consulta de terceros
            asesuisaMenuMantenimiento.MantTerc_BuscarTercero(driver, nombreAutomatizacion,2,i,folderName);

            Thread.sleep(2000);
            m.cambiarVentana(driver);
            Thread.sleep(2000);

            //buscar tercero
            BusquedaT(driver,m,asesuisaTercerosConsultaBean,nombreAutomatizacion,i,folderName,3,4,5,6, 7);
            Thread.sleep(1500);

            //Llamada al metodo consultar
            //ConsultaT(driver, m, i, folderName,8,9,10,11,12, 13);
            driver.quit();

        }catch (Exception e){
            e.printStackTrace();
            log.error("Test Case - " + nombreAutomatizacion + " - " + e);
            if (driver != null) {
                driver.quit();
            }
        }
    }


}
