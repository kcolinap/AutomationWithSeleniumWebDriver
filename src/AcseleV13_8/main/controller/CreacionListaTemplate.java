package AcseleV13_8.main.controller;

import AcseleV13_8.beans.CreacionListaTemplateBean;
import AcseleV13_8.main.controller.Menu.MenuConfiguracion;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;

/**
 * Created by kzambrano on 01/09/2016.
 */
public class CreacionListaTemplate {

    private final static Logger log = Logger.getLogger(Transformadores.class);

    public String nombreAutomatizacion = "Creacion listas Restrictivas Template";

    public void testLink (CreacionListaTemplateBean creacionListaTemplateBean, int i )  throws IOException, InterruptedException {

        //Metodos a = new Metodos();
        Metodos a = new Metodos();
        MenuConfiguracion m = new MenuConfiguracion();

        WebDriver driver = a.entrarPagina();
        a.IniciarSesion(driver, nombreAutomatizacion);
        a.ValidandoSesion(driver, nombreAutomatizacion);
        Thread.sleep(1500);
        System.out.println("prueba");

        m.NuevoPlantillasModoNoPrivilegiado(a, driver, nombreAutomatizacion);
        Thread.sleep(2000);
        a.cambiarVentana(driver);

    }

    public void CrearNuevaLista (WebDriver driver, Metodos a, CreacionListaTemplateBean creacionListaTemplateBean) throws IOException, InterruptedException{

        try{

            Thread.sleep(7000);

            a.ScreenShot(driver, "screen4", nombreAutomatizacion);
            Thread.sleep(1000);

            WebElement platillaListas = driver.findElement(By.xpath(""));


        }catch (Exception e) {
            e.printStackTrace();
//                log.info(e);
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);

        }
    }

    }
