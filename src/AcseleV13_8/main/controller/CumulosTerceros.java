package AcseleV13_8.main.controller;


import AcseleV13_8.beans.CumulosTercerosBean;
import AcseleV13_8.main.controller.Menu.MenuOperaciones;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;

/**
 * Created by aazuaje on 17/08/2016.
 */
public class CumulosTerceros {

    private final static Logger log = Logger.getLogger(CumulosTerceros.class);

    public String nombreAutomatizacion = "Cumulos LBC_Terceros";

    public void testLink(CumulosTercerosBean cumulosTercerosBean,int i) throws IOException, InterruptedException {

        //implementando clase de metodos
        Metodos a = new Metodos();
        MenuOperaciones m = new MenuOperaciones();
        WebDriver driver = a.entrarPagina();
        a.IniciarSesion(driver, nombreAutomatizacion, i);
        a.ValidandoSesion(driver, nombreAutomatizacion, i);
        Thread.sleep(8000);

        m.Cumulos_CumulosPorTerceros(driver, a, nombreAutomatizacion, i);
        Thread.sleep(8000);
        a.cambiarVentana(driver);
        BusquedaTerceros (driver, a, cumulosTercerosBean, i);


    }


    public void BusquedaTerceros (WebDriver driver, Metodos a, CumulosTercerosBean cumulosTercerosBean, int i) throws IOException, InterruptedException{

        try{

            Thread.sleep(8000);
            a.ScreenShotPool(driver, i, "screen4", nombreAutomatizacion);
            Select tipoTerceros = new Select(driver.findElement(By.xpath("/html/body/table[3]/tbody/tr[1]/td/form/table/tbody/tr[1]/td[2]/select")));
            tipoTerceros.selectByValue(cumulosTercerosBean.getTipoTerceros());

            Thread.sleep(4000);
            Select tipoDocIdentificacion = new Select(driver.findElement(By.xpath("//*[@id=\"3093254\"]/td[3]/font/select")));
            tipoDocIdentificacion.selectByValue(cumulosTercerosBean.getTipoDocIdentificacion());

            Thread.sleep(1000);
            if (cumulosTercerosBean.getPasaporte() != null){
                WebElement pasaporte = driver.findElement(By.xpath("//*[@id=\"3540374\"]/td[3]/font/input[1]"));
                pasaporte.sendKeys(cumulosTercerosBean.getPasaporte());
            }

            Thread.sleep(1000);
            WebElement numDocIdentificacion = driver.findElement(By.xpath("//*[@id=\"1932174\"]/td[3]/font/input[1]"));
            numDocIdentificacion.sendKeys(cumulosTercerosBean.getNumDocIdentificacion());

            Thread.sleep(1000);
            if (cumulosTercerosBean.getPrimerNombre() != null){
                WebElement primerNombre = driver.findElement(By.xpath("//*[@id=\"3541054\"]/td[3]/font/input[1]"));
                primerNombre.sendKeys(cumulosTercerosBean.getPrimerNombre());
            }

            Thread.sleep(1000);
            if (cumulosTercerosBean.getTelefonoOficina() != null){
                WebElement telefonoOficina = driver.findElement(By.xpath("//*[@id=\"1960174\"]/td[3]/font/input[1]"));
                telefonoOficina.sendKeys(cumulosTercerosBean.getTelefonoOficina());
            }


            Thread.sleep(1000);
            if (cumulosTercerosBean.getPrimerApellido() != null){
                WebElement primerApellido = driver.findElement(By.xpath("//*[@id=\"1931454\"]/td[3]/font/input[1]"));
                primerApellido.sendKeys(cumulosTercerosBean.getPrimerApellido());
            }

            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen5", nombreAutomatizacion);

            WebElement btnBuscar = driver.findElement(By.xpath("//*[@id=\"idb_0402036_ThirdPartySearchForCumulus_01\"]"));
            btnBuscar.click();

            Thread.sleep(4000);

            WebElement btnSeleccionar = driver.findElement(By.xpath("/html/body/table[2]/tbody/tr/td/table/tbody/tr[1]/td[1]/input[1]"));
            btnSeleccionar.click();
            Thread.sleep(2000);
            a.ScreenShotPool(driver, i, "screen6", nombreAutomatizacion);

            Thread.sleep(1000);
            WebElement btnAceptar = driver.findElement(By.xpath("//*[@id=\"td_button_submit_01\"]/input"));
            btnAceptar.click();

            Thread.sleep(10000);
            WebElement btnmoneda = driver.findElement(By.xpath("//*[@id=\"money\"]"));
            btnmoneda.click();

            Select moneda = new Select(driver.findElement(By.xpath("//*[@id=\"money\"]")));
            moneda.selectByValue(cumulosTercerosBean.getMoneda());

            Thread.sleep(2000);
            Select moneda2 = new Select(driver.findElement(By.xpath("//*[@id=\"money\"]")));
            moneda2.selectByValue(cumulosTercerosBean.getMoneda2());

            Thread.sleep(2000);
            a.ScreenShotPool(driver, i, "screen7", nombreAutomatizacion);


        }catch (Exception e) {
            e.printStackTrace();
//                log.info(e);
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }


    }

}
