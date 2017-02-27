package AcseleV13_8Asesuisa.main.controller;

import AcseleV13_8Asesuisa.beans.Asesuisa_TercerosCrearBean;
import AcseleV13_8Asesuisa.main.controller.Asesuisa_Menu.Asesuisa_MenuMantenimiento;
import AcseleV13_8Asesuisa.main.controller.Asesuisa_Terceros.Asesuisa_CrearTerceros;
import metodo.Metodos;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
/**
 * Created by kcolina on 27/02/2017.
 */
public class Asesuisa_TercerosCrear {

    private final static Logger log = Logger.getLogger(Asesuisa_TercerosCrear.class);

    public String nombreAutomatizacion = "Asesuisa Terceros Crear";
    private WebDriver driver;

    public void testLink(Asesuisa_TercerosCrearBean asesuisaTercerosCrearBean, int i, String folderName){
        try{
            Metodos m = new Metodos();
            Asesuisa_MenuMantenimiento asesuisaMenuMantenimiento = new Asesuisa_MenuMantenimiento();
            Asesuisa_CrearTerceros asesuisaCrearTerceros = new Asesuisa_CrearTerceros();

            driver = m.entrarPagina(m.UrlAsesuisa());
            m.IniciarSesion(driver, nombreAutomatizacion,i,folderName);
            m.ValidandoSesion(driver, nombreAutomatizacion,i,folderName);
            Thread.sleep(2000);

            //Entrando en Menu
            asesuisaMenuMantenimiento.MantTerc_IngresarTercero(driver,nombreAutomatizacion,2,i,folderName);
            Thread.sleep(1000);
            m.cambiarVentana(driver);
            Thread.sleep(1000);

            //Ingresar tercero
            Thread.sleep(1500);
            asesuisaCrearTerceros.CrearTerceroNatural(driver,m,asesuisaTercerosCrearBean,nombreAutomatizacion,folderName,i,
                    3,4,5,6);

            //validacion de tercero
            asesuisaCrearTerceros.ValidarCreacionTercero(driver,nombreAutomatizacion);

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
