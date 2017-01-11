package AcseleV13_8_Interseguros.main.controller;

import AcseleV13_8_Interseguros.beans.INTER_CumuloAseguradoBean;
import AcseleV13_8_Interseguros.main.controller.Interseguros_Menu.Interseguros_MenuOperaciones;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import java.io.IOException;

/**
 * Created by aazuaje on 11/01/2017.
 */
public class INTER_CumuloAsegurado {

    private final static Logger log = Logger.getLogger(INTER_CumuloAsegurado.class);

    public String nombreAutomatizacion = "INTER Cumulo Asegurado";

    public void testLink(INTER_CumuloAseguradoBean inter_cumuloAseguradoBean,int i) throws IOException, InterruptedException {

        //implementando clase de metodos
        Interseguros_Metodos a = new Interseguros_Metodos();
        Interseguros_MenuOperaciones m = new Interseguros_MenuOperaciones();
        WebDriver driver = a.entrarPagina();
        a.IniciarSesion(driver, nombreAutomatizacion, i);
        a.ValidandoSesion(driver, nombreAutomatizacion, i);
        Thread.sleep(8000);

        m.Cumulos_CumulosPorAsegurado(driver,nombreAutomatizacion, 3,i);
        Thread.sleep(8000);
        a.cambiarVentana(driver);
        BusquedaTerceros (driver, a, inter_cumuloAseguradoBean, i);


    }


    public void BusquedaTerceros (WebDriver driver, Interseguros_Metodos a, INTER_CumuloAseguradoBean inter_cumuloAseguradoBean, int i) throws IOException, InterruptedException{

        try{

            Thread.sleep(3000);
            a.ScreenShotPool(driver, i, "screen4", nombreAutomatizacion);
            WebElement btnSeleccionar1 = driver.findElement(By.xpath("//*[@id=\"ThirdParty\"]/div"));
            btnSeleccionar1.click();
            WebElement tipoTercero  = driver.findElement(By.xpath("//*[@id=\"VAADIN_COMBOBOX_OPTIONLIST\"]/div/div[2]/table/tbody/tr[1]/td/span"));
            tipoTercero.click();

            Thread.sleep(1000);
            if (inter_cumuloAseguradoBean.getDocumentoIdentidad() != null){
                WebElement documentoIdentidad = (driver.findElement(By.xpath("//*[@id=\"DocumentoIdentidad\"]")));
                documentoIdentidad.sendKeys(inter_cumuloAseguradoBean.getDocumentoIdentidad());

            }

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
            a.ScreenShotPool(driver, i, "screen5", nombreAutomatizacion);

            WebElement btnBuscar = driver.findElement(By.xpath("//*[@id=\"panelThirdParty\"]/div[2]/div/div[5]/div/div[3]/div/span/span"));
            btnBuscar.click();

            Thread.sleep(4000);

            WebElement btnSeleccionar = driver.findElement(By.xpath("//*[@id=\"gwt-uid-128\"]/div[2]/div[1]/table/tbody/tr[1]/td[2]/div"));
            btnSeleccionar.click();
            Thread.sleep(2000);
            a.ScreenShotPool(driver, i, "screen6", nombreAutomatizacion);

            Thread.sleep(1000);
            WebElement btnAceptar = driver.findElement(By.xpath("//*[@id=\"panelThirdParty\"]/div[2]/div/div[7]/div/div[2]/div/div[3]/div/div/div/span/span"));
            btnAceptar.click();

            Thread.sleep(8000);
            a.ScreenShotPool(driver, i, "screen7", nombreAutomatizacion);


        }catch (Exception e) {
            e.printStackTrace();
//                log.info(e);
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }


    }
}
