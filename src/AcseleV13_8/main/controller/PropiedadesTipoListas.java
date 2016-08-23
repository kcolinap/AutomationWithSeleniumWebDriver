package AcseleV13_8.main.controller;

import AcseleV13_8.beans.PropiedadesTipoListasBean;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;

/**
 * Created by aazuaje on 22/08/2016.
 */
public class PropiedadesTipoListas {

    private final static Logger log = Logger.getLogger(PropiedadesTipoListas.class);

    public String nombreAutomatizacion = "Propiedades Listas";


    public void testLink(PropiedadesTipoListasBean propiedadesTipoListasBean,int i) throws IOException, InterruptedException {

        //implementando clase de metodos
        Metodos a = new Metodos();
        WebDriver driver = a.entrarPagina();
        a.IniciarSesion(driver, nombreAutomatizacion);
        a.ValidandoSesion(driver, nombreAutomatizacion);
        Thread.sleep(8000);


        MenuNuevoPlantillasModoNoPrivilegiado(driver,a);
        Thread.sleep(3000);
        a.cambiarVentana(driver);
        AgregarPropiedades (driver, a, propiedadesTipoListasBean);
        ConsultaLista (driver, a, propiedadesTipoListasBean);


    }

    public void MenuNuevoPlantillasModoNoPrivilegiado(WebDriver driver, Metodos a) {

        try {
            Actions action = new Actions(driver);
            WebElement menu1 = driver.findElement(By.xpath("/html/body/div[3]/div[3]"));//configuracion
            WebElement menu2 = driver.findElement(By.xpath("/html/body/div[26]/div[18]"));//NuevoPlantillasModoNoPrivilegiado
            Thread.sleep(1000);

            action.moveToElement(menu1).build().perform();

            Thread.sleep(1000);
            a.ScreenShot(driver, "screen3", nombreAutomatizacion);
            Thread.sleep(1000);
            menu2.click();


        }catch (Exception e) {
            e.printStackTrace();
//                log.info(e);
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }

    }


    public void AgregarPropiedades (WebDriver driver, Metodos a, PropiedadesTipoListasBean propiedadesTipoListasBean) throws IOException, InterruptedException{

        try{
            Thread.sleep(8000);
            a.ScreenShot(driver,"screen4",nombreAutomatizacion);

            WebElement btnPropiedades = driver.findElement(By.xpath("//*[@id=\"WControllerfront-1437825718\"]/div/div[2]/div/div/div/div[2]/div/div/div[1]/div/div/div/div/div/div/div/span[2]/span[2]"));
            btnPropiedades.click();

            Thread.sleep(1000);
            WebElement btnAgregar = driver.findElement(By.xpath("//*[@id=\"WControllerfront-1437825718-overlays\"]/div[2]/div/div/span[1]/span"));
            btnAgregar.click();
            Thread.sleep(2000);

            WebElement nombrePropiedad = driver.findElement(By.xpath("//*[@id=\"WControllerfront-1437825718-window-overlays\"]/div[3]/div/div/div[5]/div/div/div[3]/input"));
            nombrePropiedad.sendKeys(propiedadesTipoListasBean.getNombrePropiedad());
            Thread.sleep(1000);
            a.ScreenShot(driver,"screen5",nombreAutomatizacion);

            WebElement btnAceptar = driver.findElement(By.xpath("//*[@id=\"WControllerfront-1437825718-window-overlays\"]/div[3]/div/div/div[5]/div/div/div[5]/div/div[1]/button/span"));
            btnAceptar.click();
            Thread.sleep(3000);

            WebElement buscar = driver.findElement(By.xpath("//*[@id=\"WControllerfront-1437825718\"]/div/div[2]/div/div/div/div[2]/div/div/div[2]/div/div/div[2]/div/div/div[3]/div/div/div[1]/div/div/div[2]/input"));
            buscar.sendKeys(propiedadesTipoListasBean.getBuscar());
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

            WebElement btnSeleccionar = driver.findElement(By.xpath("//*[@id=\"WControllerfront-1437825718-window-overlays\"]/div[3]/div/div/div[5]/div/div/div[1]/div/div/div[1]/div/div[3]/div/div"));
            btnSeleccionar.click();
            Thread.sleep(1000);
            WebElement tipoVisualizacion  = driver.findElement(By.xpath("//*[@id=\"VAADIN_COMBOBOX_OPTIONLIST\"]/div/div[2]/table/tbody/tr[3]/td/span"));
            tipoVisualizacion.click();
            Thread.sleep(1000);


            Thread.sleep(1000);
            a.ScreenShot(driver,"screen7",nombreAutomatizacion);
            Thread.sleep(2000);
            WebElement btnAceptar2 = driver.findElement(By.xpath("//*[@id=\"WControllerfront-1437825718-window-overlays\"]/div[3]/div/div/div[5]/div/div/div[2]/div/div[1]/button/span"));
            btnAceptar2.click();


        }catch (Exception e) {
            e.printStackTrace();
//                log.info(e);
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }


    }

    public void ConsultaLista (WebDriver driver, Metodos a, PropiedadesTipoListasBean propiedadesTipoListasBean) throws IOException, InterruptedException{

        try{

            Thread.sleep(5000);

            WebElement buscar = driver.findElement(By.xpath("//*[@id=\"WControllerfront-1437825718\"]/div/div[2]/div/div/div/div[2]/div/div/div[2]/div/div/div[2]/div/div/div[3]/div/div/div[1]/div/div/div[2]/input"));
            buscar.sendKeys(propiedadesTipoListasBean.getBuscar());
            Thread.sleep(1000);

            WebElement btnBuscar = driver.findElement(By.xpath("//*[@id=\"WControllerfront-1437825718\"]/div/div[2]/div/div/div/div[2]/div/div/div[2]/div/div/div[2]/div/div/div[3]/div/div/div[1]/div/div/div[3]/button/img"));
            btnBuscar.click();
            Thread.sleep(2000);

            WebElement prueba2 = driver.findElement(By.xpath("//*[@id=\"WControllerfront-1437825718\"]/div/div[2]/div/div/div/div[2]/div/div/div[2]/div/div/div[2]/div/div/div[3]/div/div/div[2]/div/div[2]/div[1]/table/tbody/tr[116]/td/div"));
            prueba2.click();
            Thread.sleep(1000);

            WebElement btnAsignarPresentacion = driver.findElement(By.xpath("//*[@id=\"WControllerfront-1437825718\"]/div/div[2]/div/div/div/div[2]/div/div/div[2]/div/div/div[3]/div/div/div/div/div[5]/button/img"));
            btnAsignarPresentacion.click();
            Thread.sleep(2000);
            a.ScreenShot(driver,"screen8",nombreAutomatizacion);
            Thread.sleep(1000);


        }catch (Exception e) {
            e.printStackTrace();
//                log.info(e);
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }
}
