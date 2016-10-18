package AcseleV13_8LBC.main.controller;

import AcseleV13_8LBC.main.controller.Menu.Menu.MenuOperaciones;
import AcseleV13_8LBC.beans.CumulosAseguradoLBCBean;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.io.Serializable;

/**
 * Created by aazuaje on 17/10/2016.
 */
public class CumulosAseguradoLBC implements Serializable{
    private final static Logger log = Logger.getLogger(CumulosAseguradoLBC.class);

    public String nombreAutomatizacion = "Cumulos Asegurado";

    public void testLink(CumulosAseguradoLBCBean cumulosAseguradoLBCBean,int i) throws IOException, InterruptedException {

        //implementando clase de metodos
        MetodosLBC a = new MetodosLBC();
        MenuOperaciones m = new MenuOperaciones();
        WebDriver driver = a.entrarPagina();
        a.IniciarSesion(driver, nombreAutomatizacion, i);
        a.ValidandoSesion(driver, nombreAutomatizacion, i);
        Thread.sleep(8000);

        m.Cumulos_CumulosPorAsegurado(driver, a, nombreAutomatizacion,i);
        Thread.sleep(4000);
        a.cambiarVentana(driver);
        BusquedaAsegurado(driver, a, cumulosAseguradoLBCBean, i);


    }

    public void BusquedaAsegurado (WebDriver driver, MetodosLBC a, CumulosAseguradoLBCBean cumulosAseguradoLBCBean, int i) throws IOException, InterruptedException{

        try {
            Thread.sleep(3000);
            a.ScreenShotPool(driver,i,"screen4",nombreAutomatizacion);
            WebElement btnSeleccionar1 = driver.findElement(By.xpath("//*[@id=\"ThirdParty\"]/div"));
            btnSeleccionar1.click();
            Thread.sleep(1000);
            WebElement tipoTerceros  = driver.findElement(By.xpath("//*[@id=\"VAADIN_COMBOBOX_OPTIONLIST\"]/div/div[2]/table/tbody/tr[1]/td"));
            tipoTerceros.click();

            Thread.sleep(2000);

            if (cumulosAseguradoLBCBean.getApellido() != null){
                WebElement apellido = driver.findElement(By.xpath("//*[@id=\"LastName\"]"));
                apellido.sendKeys(cumulosAseguradoLBCBean.getApellido());
            }

            Thread.sleep(1000);
            if (cumulosAseguradoLBCBean.getNombre() != null){
                WebElement nombre = driver.findElement(By.xpath("//*[@id=\"FirstName\"]"));
                nombre.sendKeys(cumulosAseguradoLBCBean.getNombre());
            }

            Thread.sleep(1000);
            WebElement btnSeleccionar2 = driver.findElement(By.xpath("*//*[@id=\"TipoDocIdentificacion\"]/div"));
            btnSeleccionar2.click();
            Thread.sleep(1000);
            WebElement tipoDocIdentificacion  = driver.findElement(By.xpath("//*[@id=\"VAADIN_COMBOBOX_OPTIONLIST\"]/div/div[2]/table/tbody/tr[2]/td/span"));
            tipoDocIdentificacion.click();

            Thread.sleep(1000);


            Thread.sleep(1000);
            WebElement numDocIdentificacion = driver.findElement(By.xpath("//*[@id=\"IdentifierI\"]"));
            numDocIdentificacion.sendKeys(cumulosAseguradoLBCBean.getNumDocIdentificacion());


            Thread.sleep(1000);
            a.ScreenShotPool(driver,i,"screen5",nombreAutomatizacion);

            Thread.sleep(1000);
            WebElement btnBuscar = driver.findElement(By.xpath("//*[@id=\"panelThirdParty\"]/div[2]/div/div[5]/div/div[3]/div/span/span"));
            btnBuscar.click();

            Thread.sleep(2000);
            WebElement btnResultadoBusqueda= driver.findElement(By.xpath("//*[@id=\"gwt-uid-92\"]/div[2]/div[1]/table/tbody/tr/td[1]/div"));
            btnResultadoBusqueda.click();
            Thread.sleep(2000);
            a.ScreenShotPool(driver,i,"screen6",nombreAutomatizacion);

            Thread.sleep(5000);
            WebElement btnCumuloAsegurado= driver.findElement(By.xpath("//*[@id=\"panelThirdParty\"]/div[2]/div/div[7]/div/div[2]/div/div[3]/div/div/div/span/span"));
            btnCumuloAsegurado.click();

            Thread.sleep(2000);
            a.ScreenShotPool(driver,i,"screen7",nombreAutomatizacion);


        }catch (Exception e) {
            e.printStackTrace();
//                log.info(e);
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);

        }
    }


}
