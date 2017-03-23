package AcseleV13_8_Interseguros.main.controller;

import AcseleV13_8_Interseguros.beans.INTER_CrearCoincidenciaBean;
import AcseleV13_8_Interseguros.main.controller.Interseguros_Menu.Interseguros_MenuMantenimiento;
import metodo.Metodos;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by aazuaje on 31/01/2017.
 */
public class INTER_CrearCoincidencia {

    private final static Logger log = Logger.getLogger(INTER_CrearCoincidencia.class);

    public String nombreAutomatizacion = "Crear Coincidencia";
    private WebDriver driver;

    public void testLink (INTER_CrearCoincidenciaBean inter_crearCoincidenciaBean, int i, String folderName)  throws IOException, InterruptedException {

        try{
            Metodos a = new Metodos();
            Interseguros_MenuMantenimiento m = new Interseguros_MenuMantenimiento();

            driver = a.entrarPagina(a.UrlInterseguros());
            a.IniciarSesion(driver, nombreAutomatizacion, i, folderName);
            a.ValidandoSesion(driver, nombreAutomatizacion, i, folderName);
            Thread.sleep(1500);
            System.out.println("prueba");

            m.AdminLisRest_CoincidenciaListasRestrictivas(driver, a, nombreAutomatizacion, 2, i, folderName);
            Thread.sleep(3000);
            a.cambiarVentana(driver);


            CrearCoincidencia(a, inter_crearCoincidenciaBean, i, folderName, 3, 4, 5,6);
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

    public void CrearCoincidencia (Metodos a, INTER_CrearCoincidenciaBean inter_crearCoincidenciaBean, int i, String folderName,
                                  int numScreenShoot, int numScreenShoot2, int numScreenShoot3, int numScreenShoot4){

        try{

            a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion, folderName);
            WebElement btnAgregar = driver.findElement(By.xpath("//*[@id=\"title\"]/div/div/span/span"));
            btnAgregar.click();

            Set<String> sid = driver.getWindowHandles();
            //Using iterator we can fetch the values from Set.
            Iterator<String> it = sid.iterator();
            String parentId = it.next();
            System.out.println("Prueba " + parentId);
            Thread.sleep(2000);
            String childId = it.next();
            //String childId2 = it.next();
            System.out.println("Prueba " + childId);
            //System.out.println("Prueba " + childId2);
            //swtiching control to child Window
            //driver.switchTo().window(childId2);

            Thread.sleep(6000);

            WebElement btnSeleccionar1 = driver.findElement(By.xpath("//*[@id=\"listName\"]/div"));
            btnSeleccionar1.click();
            Thread.sleep(1000);

            WebElement nombreLista = (driver.findElement(By.xpath("/*//*[@id=\"VAADIN_COMBOBOX_OPTIONLIST\"]/div/div[2]/table/tbody/tr[2]/td")));
            nombreLista.click();
            Thread.sleep(1000);

            WebElement btnSeleccionar2 = driver.findElement(By.xpath("//*[@id=\"listCoincidenceType\"]/div"));
            btnSeleccionar2.click();
            Thread.sleep(1000);

            WebElement tipoCoindicencia = (driver.findElement(By.xpath("/*//*[@id=\"VAADIN_COMBOBOX_OPTIONLIST\"]/div/div[2]/table/tbody/tr[2]/td")));
            tipoCoindicencia.click();
            Thread.sleep(2000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot2, nombreAutomatizacion, folderName);

            WebElement seleccionar = driver.findElement(By.xpath("//*[@id=\"WControllervaadinservlet-1750660287-window-overlays\"]/div[5]/div/div/div[5]/div/div/div[1]/div/div[2]/div/div[2]/div/div[4]/div/select/option[1]"));
            seleccionar.click();
            Thread.sleep(1000);

            WebElement flecha = driver.findElement(By.xpath("//*[@id=\"WControllervaadinservlet-1750660287-window-overlays\"]/div[5]/div/div/div[5]/div/div/div[1]/div/div[2]/div/div[2]/div/div[5]/div/div[1]/div/span"));
            flecha.click();
            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot3, nombreAutomatizacion, folderName);

            Thread.sleep(3000);
            WebElement btnSalvar = driver.findElement(By.xpath("/html/body/div[3]/div[5]/div/div/div[5]/div/div/div[2]/div/div[1]/div/span"));
            btnSalvar.click();
            Thread.sleep(1000);

            sid = driver.getWindowHandles();
            //Using iterator we can fetch the values from Set.
            it = sid.iterator();
            parentId = it.next();
            System.out.println("Prueba " + parentId);
            Thread.sleep(2000);
            childId = it.next();
            System.out.println("Prueba " + childId);
            //swtiching control to child Window
            driver.switchTo().window(childId);

            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot4, nombreAutomatizacion, folderName);

        }catch (Exception e) {
            e.printStackTrace();
            //log.info(e);
            log.error("Test Case - " + nombreAutomatizacion + " - " + e);
        }

    }
}
