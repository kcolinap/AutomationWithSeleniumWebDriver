package AcseleV13_8_Interseguros.main.controller;

import AcseleV13_8_Interseguros.beans.INTER_CumuloAseguradoBean;
import AcseleV13_8_Interseguros.main.controller.Interseguros_Menu.Interseguros_MenuOperaciones;
import metodo.Metodos;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import java.io.IOException;

/**
 * Created by aazuaje on 11/01/2017.
 */
public class INTER_CumuloAsegurado {

    private final static Logger log = Logger.getLogger(INTER_CumuloAsegurado.class);

    public String nombreAutomatizacion = "INTER Cumulo Asegurado";
    private WebDriver driver;

    public void testLink(INTER_CumuloAseguradoBean inter_cumuloAseguradoBean, int i, String folderName) throws IOException, InterruptedException {

        try {

            //implementando clase de metodos
            Metodos a = new Metodos();
            Interseguros_MenuOperaciones m = new Interseguros_MenuOperaciones();

            driver = a.entrarPagina(a.UrlInterseguros());
            a.IniciarSesion(driver, nombreAutomatizacion, i, folderName);
            a.ValidandoSesion(driver, nombreAutomatizacion, i, folderName);
            Thread.sleep(8000);

            m.Cumulos_CumulosPorAsegurado(driver, nombreAutomatizacion, 3, i, folderName);
            Thread.sleep(8000);
            a.cambiarVentana(driver);
            BusquedaTerceros(a, inter_cumuloAseguradoBean, i, folderName, 4, 5, 6, 7,8);

            driver.quit();

        }catch (Exception e){
            e.printStackTrace();
            log.error("Test Case - " + nombreAutomatizacion + " - " + e);
            if (driver != null){
                driver.quit();
            }
        }

    }


    public void BusquedaTerceros (Metodos a, INTER_CumuloAseguradoBean inter_cumuloAseguradoBean, int i, String folderName,
                                  int numScreenShoot, int numScreenShoot2, int numScreenShoot3, int numScreenShoot4,int numScreenShoot5){

        try{

            JavascriptExecutor jse = (JavascriptExecutor) driver;

            jse.executeScript("window.scrollBy(0,5000)", "");
            Thread.sleep(1500);
            jse.executeScript("window.scrollBy(0,-5000)", "");

            Thread.sleep(1500);

            WebElement btnSeleccionar1 = driver.findElement(By.xpath("//*[@id=\"ThirdParty\"]/div"));
            btnSeleccionar1.click();
            Thread.sleep(500);
            WebElement tipoTercero  = driver.findElement(By.xpath("//*[@id=\"VAADIN_COMBOBOX_OPTIONLIST\"]/div/div[2]/table/tbody/tr[1]/td/span"));
            tipoTercero.click();

            Thread.sleep(1000);
            if (inter_cumuloAseguradoBean.getDocumentoIdentidad() != null){
                WebElement documentoIdentidad = (driver.findElement(By.xpath("//*[@id=\"DocumentoIdentidad\"]")));
                documentoIdentidad.sendKeys(inter_cumuloAseguradoBean.getDocumentoIdentidad());

            }
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion, folderName);
            Thread.sleep(1000);
            if (inter_cumuloAseguradoBean.getPasaporte() != null){
                WebElement pasaporte = driver.findElement(By.xpath("//*[@id=\"Pasaporte\"]"));
                pasaporte.sendKeys(inter_cumuloAseguradoBean.getPasaporte());
            }

            Thread.sleep(1000);
            if (inter_cumuloAseguradoBean.getApellido() != null){
                WebElement primerApellido = driver.findElement(By.xpath("//*[@id=\"Apellido\"]"));
                primerApellido.sendKeys(inter_cumuloAseguradoBean.getApellido());
            }

            Thread.sleep(1000);
            if (inter_cumuloAseguradoBean.getNombre() != null){
                WebElement primerNombre = driver.findElement(By.xpath("//*[@id=\"Nombre\"]"));
                primerNombre.sendKeys(inter_cumuloAseguradoBean.getNombre());
            }


            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot2, nombreAutomatizacion, folderName);
            Thread.sleep(1500);

            jse.executeScript("window.scrollBy(0,5000);");
            Thread.sleep(1000);
            WebElement btnBuscar = driver.findElement(By.xpath("//*[@id=\"panelThirdParty\"]/div[2]/div/div[5]/div/div[3]/div/span/span"));
            btnBuscar.click();

            Thread.sleep(3000);


            WebElement btnSeleccionar = driver.findElement(By.xpath("//*[@id=\"gwt-uid-128\"]/div[2]/div[1]/table/tbody/tr[1]/td[2]/div"));
            btnSeleccionar.click();
            Thread.sleep(2000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot3, nombreAutomatizacion, folderName);

            Thread.sleep(1000);
            WebElement btnAceptar = driver.findElement(By.xpath("//*[@id=\"panelThirdParty\"]/div[2]/div/div[7]/div/div[2]/div/div[3]/div/div/div/span/span"));
            btnAceptar.click();

            Thread.sleep(7000);

            //jse.executeScript("window.scrollBy(0,-5000)", "");
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot4, nombreAutomatizacion, folderName);

            Thread.sleep(1000);
            jse.executeScript("window.scrollBy(0,2500)", "");
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot5, nombreAutomatizacion, folderName);

        }catch (Exception e) {
            e.printStackTrace();
            log.error("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }
}
