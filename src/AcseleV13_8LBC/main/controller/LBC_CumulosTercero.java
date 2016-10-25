package AcseleV13_8LBC.main.controller;
import AcseleV13_8LBC.beans.LBC_CumulosTerceroBean;
import AcseleV13_8LBC.main.controller.LBC_Menu.LBC_MenuOperaciones;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;
/**
 * Created by aazuaje on 18/10/2016.
 */
public class LBC_CumulosTercero {

    private final static Logger log = Logger.getLogger(LBC_CumulosTercero.class);

    public String nombreAutomatizacion = "Cumulos Terceros LBC";

    public void testLink(LBC_CumulosTerceroBean lbcCumulosTerceroBean,int i) throws IOException, InterruptedException {

        //implementando clase de metodos
        LBC_Metodos a = new LBC_Metodos();
        LBC_MenuOperaciones m = new LBC_MenuOperaciones();
        WebDriver driver = a.entrarPagina();
        a.IniciarSesion(driver, nombreAutomatizacion, i);
        a.ValidandoSesion(driver, nombreAutomatizacion, i);
        Thread.sleep(8000);

        m.Cumulos_CumulosPorTerceros(driver, a, nombreAutomatizacion, i);
        Thread.sleep(8000);
        a.cambiarVentana(driver);
        BusquedaTerceros (driver, a, lbcCumulosTerceroBean, i);


    }


    public void BusquedaTerceros (WebDriver driver, LBC_Metodos a, LBC_CumulosTerceroBean lbcCumulosTerceroBean, int i) throws IOException, InterruptedException{

        try{

            Thread.sleep(4000);
            a.ScreenShotPool(driver, i, "screen4", nombreAutomatizacion);
            Select tipoTerceros = new Select(driver.findElement(By.xpath("/html/body/table[3]/tbody/tr[1]/td/form/table/tbody/tr[1]/td[2]/select")));
            tipoTerceros.selectByValue(lbcCumulosTerceroBean.getTipoTerceros());

            Thread.sleep(3000);
            if (lbcCumulosTerceroBean.getApellido() != null){
                WebElement primerApellido = driver.findElement(By.xpath("//*[@id=\"57619\"]/td[3]/input[1]"));
                primerApellido.sendKeys(lbcCumulosTerceroBean.getApellido());
            }

            Thread.sleep(1000);
            if (lbcCumulosTerceroBean.getNombre() != null){
                WebElement primerNombre = driver.findElement(By.xpath("//*[@id=\"57617\"]/td[3]/input[1]"));
                primerNombre.sendKeys(lbcCumulosTerceroBean.getNombre());
            }

            Thread.sleep(4000);
            Select tipoDocIdentificacion = new Select(driver.findElement(By.xpath("//*[@id=\"1808422\"]/td[3]/select")));
            tipoDocIdentificacion.selectByValue(lbcCumulosTerceroBean.getTipoDocIdentificacion());

            Thread.sleep(1000);
            WebElement numDocIdentificacion = driver.findElement(By.xpath("//*[@id=\"57556\"]/td[3]/input[1]"));
            numDocIdentificacion.sendKeys(lbcCumulosTerceroBean.getNumDocIdentificacion());

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
            moneda.selectByValue(lbcCumulosTerceroBean.getMoneda());

            Thread.sleep(2000);
            a.ScreenShotPool(driver, i, "screen7", nombreAutomatizacion);


        }catch (Exception e) {
            e.printStackTrace();
//                log.info(e);
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }


    }


}
