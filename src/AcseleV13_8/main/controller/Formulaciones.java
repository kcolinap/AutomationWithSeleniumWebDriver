package AcseleV13_8.main.controller;

import AcseleV13_8.beans.FormulacionesBean;
import AcseleV13_8.main.controller.Menu.MenuConfiguracion;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;
/**
 * Created by aazuaje on 23/08/2016.
 */
public class Formulaciones {


    private final static Logger log = Logger.getLogger(Formulaciones.class);

    public String nombreAutomatizacion = "Formulaciones";


    public void testLink(FormulacionesBean formulacionesBean,int i) throws IOException, InterruptedException {

        //implementando clase de metodos
        Metodos a = new Metodos();
        MenuConfiguracion m = new MenuConfiguracion();
        WebDriver driver = a.entrarPagina();
        a.IniciarSesion(driver, nombreAutomatizacion);
        a.ValidandoSesion(driver, nombreAutomatizacion);
        Thread.sleep(8000);


        m.NuevoPlantillasModoNoPrivilegiado(a, driver, nombreAutomatizacion);
        Thread.sleep(3000);
        a.cambiarVentana(driver);
        AgregarFormulaciones (driver, a, formulacionesBean);
        ConsultaFormulaciones (driver, a, formulacionesBean);


    }


    public void AgregarFormulaciones (WebDriver driver, Metodos a, FormulacionesBean formulacionesBean) throws IOException, InterruptedException{

        try{
            Thread.sleep(8000);
            a.ScreenShot(driver,"screen4",nombreAutomatizacion);

            WebElement buscar = driver.findElement(By.xpath("//*[@id=\"WControllerfront-1437825718\"]/div/div[2]/div/div/div/div[2]/div/div/div[2]/div/div/div[2]/div/div/div[3]/div/div/div[1]/div/div/div[2]/input"));
            buscar.sendKeys(formulacionesBean.getBuscar());
            Thread.sleep(1000);

            WebElement btnBuscar = driver.findElement(By.xpath("//*[@id=\"WControllerfront-1437825718\"]/div/div[2]/div/div/div/div[2]/div/div/div[2]/div/div/div[2]/div/div/div[3]/div/div/div[1]/div/div/div[3]/button/img"));
            btnBuscar.click();
            a.ScreenShot(driver,"screen6",nombreAutomatizacion);
            Thread.sleep(2000);

            WebElement prueba2 = driver.findElement(By.xpath("//*[@id=\"WControllerfront-1437825718\"]/div/div[2]/div/div/div/div[2]/div/div/div[2]/div/div/div[2]/div/div/div[3]/div/div/div[2]/div/div[2]/div[1]/table/tbody/tr[116]/td/div"));
            prueba2.click();
            Thread.sleep(1000);

            WebElement btnAsignarPresentacion = driver.findElement(By.xpath("//*[@id=\"WControllerfront-1437825718\"]/div/div[2]/div/div/div/div[2]/div/div/div[2]/div/div/div[3]/div/div/div/div/div[5]/button/img"));
            btnAsignarPresentacion.click();
            Thread.sleep(1000);

            WebElement btnRegla= driver.findElement(By.xpath("//*[@id=\"WControllerfront-1437825718-window-overlays\"]/div[3]/div/div/div[5]/div/div/div[1]/div/div/div[1]/div/div[9]/div/div[2]/button/img"));
            btnRegla.click();
            Thread.sleep(2000);

            WebElement descripcionFormula = driver.findElement(By.xpath("//*[@id=\"WControllerfront-1437825718-window-overlays\"]/div[6]/div/div/div[5]/div/div/div[1]/div/div[2]/div/div[1]/textarea"));
            descripcionFormula.sendKeys(formulacionesBean.getDescripcionFormula());
            Thread.sleep(2000);
            a.ScreenShot(driver,"screen7",nombreAutomatizacion);

            WebElement btnSalvar= driver.findElement(By.xpath("//*[@id=\"WControllerfront-1437825718-window-overlays\"]/div[6]/div/div/div[5]/div/div/div[2]/div/div[1]/button/span"));
            btnSalvar.click();
            Thread.sleep(2000);

            a.ScreenShot(driver,"screen8",nombreAutomatizacion);

           /* WebElement btnAceptar= driver.findElement(By.xpath("/*//*[@id=\"WControllerfront-1437825718-window-overlays\"]/div[3]/div/div/div[5]/div/div/div[2]/div/div[1]/button/span"));
            btnAceptar.click();
            Thread.sleep(2000);*/



        }catch (Exception e) {
            e.printStackTrace();
//                log.info(e);
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }
    public void ConsultaFormulaciones (WebDriver driver, Metodos a, FormulacionesBean formulacionesBean) throws IOException, InterruptedException{

        try{
            Thread.sleep(2000);
            WebElement buscar = driver.findElement(By.xpath("//*[@id=\"WControllerfront-1437825718\"]/div/div[2]/div/div/div/div[2]/div/div/div[2]/div/div/div[2]/div/div/div[3]/div/div/div[1]/div/div/div[2]/input"));
            buscar.sendKeys(formulacionesBean.getBuscar());
            Thread.sleep(1000);

            WebElement btnBuscar = driver.findElement(By.xpath("//*[@id=\"WControllerfront-1437825718\"]/div/div[2]/div/div/div/div[2]/div/div/div[2]/div/div/div[2]/div/div/div[3]/div/div/div[1]/div/div/div[3]/button/img"));
            btnBuscar.click();
            Thread.sleep(2000);

            WebElement prueba2 = driver.findElement(By.xpath("//*[@id=\"WControllerfront-1437825718\"]/div/div[2]/div/div/div/div[2]/div/div/div[2]/div/div/div[2]/div/div/div[3]/div/div/div[2]/div/div[2]/div[1]/table/tbody/tr[116]/td/div"));
            prueba2.click();
            Thread.sleep(1000);

            WebElement btnAsignarPresentacion = driver.findElement(By.xpath("//*[@id=\"WControllerfront-1437825718\"]/div/div[2]/div/div/div/div[2]/div/div/div[2]/div/div/div[3]/div/div/div/div/div[5]/button/img"));
            btnAsignarPresentacion.click();
            Thread.sleep(1000);

            a.ScreenShot(driver,"screen9",nombreAutomatizacion);

        }catch (Exception e) {
            e.printStackTrace();
//                log.info(e);
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }
}
