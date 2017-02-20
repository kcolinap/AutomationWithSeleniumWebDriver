package AcseleV13_8_Interseguros.main.controller;

import AcseleV13_8_Interseguros.beans.INTER_BusquedaSiniestroSimpleBean;
import AcseleV13_8_Interseguros.main.controller.Interseguros_Menu.Interseguros_MenuOperaciones;
import metodo.Metodos;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;

/**
 * Created by aazuaje on 23/01/2017.
 */
public class INTER_BusquedaSiniestroSimple {

    private final static Logger log = Logger.getLogger(INTER_BusquedaSiniestroSimple.class);

    public String nombreAutomatizacion = "Busqueda Siniestros Simple";
    private WebDriver driver;

    public void testLink (INTER_BusquedaSiniestroSimpleBean inter_busquedaSiniestroSimpleBean, int i, String folderName)  throws IOException, InterruptedException {

        try{
            Metodos a = new Metodos();
            Interseguros_MenuOperaciones m = new Interseguros_MenuOperaciones();

            driver = a.entrarPagina(a.UrlInterseguros());
            a.IniciarSesion(driver, nombreAutomatizacion, i, folderName);
            a.ValidandoSesion(driver, nombreAutomatizacion, i, folderName);
            Thread.sleep(1500);
            System.out.println("prueba");

            m.OpeSini_MantenimientoSiniestro(driver,a , nombreAutomatizacion,2, i, folderName);
            Thread.sleep(3000);
            a.cambiarVentana(driver);


            BuscarSiniestro(a, inter_busquedaSiniestroSimpleBean, i, folderName, 3, 4, 5);
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

    public void BuscarSiniestro(Metodos a, INTER_BusquedaSiniestroSimpleBean inter_busquedaSiniestroSimpleBean, int i, String folderName, int numScreenShoot, int numScreenShoot2, int numScreenShoot3){

        try {

            //
            /*if (inter_busquedaSiniestroSimpleBean.getOrdenarPor() != null){
                Select ordenarPor = new Select(driver.findElement(By.xpath("/*//*[@id=\"orderBy\"]/input")));
                ordenarPor.selectByValue(inter_busquedaSiniestroSimpleBean.getOrdenarPor());
            }*/

            if (inter_busquedaSiniestroSimpleBean.getNumeroSiniestro() != null){
                Thread.sleep(2000);
                WebElement numeroSiniestro = driver.findElement(By.xpath("//*[@id=\"textFieldClaimNumbre\"]"));
                numeroSiniestro.sendKeys(inter_busquedaSiniestroSimpleBean.getNumeroSiniestro());
            }

            //
            if (inter_busquedaSiniestroSimpleBean.getNumeroPoliza() != null){
                Thread.sleep(2000);
                WebElement numeroPoliza = driver.findElement(By.xpath("//*[@id=\"textFieldPolicyNumber\"]"));
                numeroPoliza.sendKeys(inter_busquedaSiniestroSimpleBean.getNumeroPoliza());
            }

            if (inter_busquedaSiniestroSimpleBean.getFechaOcurrenciaSin() != null){
                Thread.sleep(2000);
                WebElement fechaSiniestro = driver.findElement(By.xpath("//*[@id=\"dateFieldOccurrenceDate\"]/input"));
                fechaSiniestro.sendKeys(inter_busquedaSiniestroSimpleBean.getFechaOcurrenciaSin());
            }

            String productos = "DotalSimple";

            if (inter_busquedaSiniestroSimpleBean.getProducto() != null){
                Thread.sleep(1000);
                WebElement btnSeleccionar = driver.findElement(By.xpath("//*[@id=\"comboProductoSimpleSearch\"]/div"));
                btnSeleccionar.click();
                Thread.sleep(1000);
                WebElement producto  = driver.findElement(By.xpath("//*[@id=\"VAADIN_COMBOBOX_OPTIONLIST\"]/div/div[2]/table/tbody/tr[7]/td/span"));
                producto.click();
                //}
            }


            Thread.sleep(2000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion, folderName);
            WebElement buscar = driver.findElement(By.xpath("//*[@id=\"buttonBuscar\"]/span/span"));//buscar siniestro
            buscar.click();

            Thread.sleep(2000);

            WebElement seleccionar = driver.findElement(By.xpath("//*[@id=\"layoutResultTable\"]/div[1]/div/div[3]/div[1]/table/tbody/tr[3]/td[3]/div"));
            seleccionar.click();
            Thread.sleep(2000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot2, nombreAutomatizacion, folderName);
            Thread.sleep(1000);
            WebElement consultar = driver.findElement(By.xpath("//*[@id=\"buttonOk\"]/span/span"));
            consultar.click();

            Thread.sleep(3000);

            a.changeLastWindows(driver);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot3, nombreAutomatizacion, folderName);



        }catch (Exception e) {
            e.printStackTrace();
            //log.info(e);
            log.error("Test Case - " + nombreAutomatizacion + " - " + e);
        }

    }

}
