package AcseleV13_8.main.controller;

import AcseleV13_8.beans.CumulosAseguradoBean;
import AcseleV13_8.beans.CumulosProductosBean;
import AcseleV13_8.main.controller.Menu.MenuOperaciones;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;

/**
 * Created by aazuaje on 18/08/2016.
 */
public class CumulosAsegurado {

    private final static Logger log = Logger.getLogger(CumulosAsegurado.class);

    public String nombreAutomatizacion = "Cumulos Asegurado";

    public void testLink(CumulosAseguradoBean cumulosAseguradoBean,int i) throws IOException, InterruptedException {

        //implementando clase de metodos
        Metodos a = new Metodos();
        MenuOperaciones m = new MenuOperaciones();
        WebDriver driver = a.entrarPagina();
        a.IniciarSesion(driver, nombreAutomatizacion, i);
        a.ValidandoSesion(driver, nombreAutomatizacion, i);
        Thread.sleep(8000);

        m.Cumulos_CumulosPorAsegurado(driver, a, nombreAutomatizacion);
        Thread.sleep(8000);
        a.cambiarVentana(driver);
        BusquedaAsegurado(driver, a, cumulosAseguradoBean);


    }

    public void BusquedaAsegurado (WebDriver driver, Metodos a, CumulosAseguradoBean cumulosAseguradoBean) throws IOException, InterruptedException{

        try {
            Thread.sleep(3000);
            a.ScreenShot(driver,"screen4",nombreAutomatizacion);
            WebElement btnSeleccionar1 = driver.findElement(By.xpath("//*[@id=\"ThirdParty\"]/div"));
            btnSeleccionar1.click();
            Thread.sleep(1000);
            WebElement tipoTerceros  = driver.findElement(By.xpath("//*[@id=\"VAADIN_COMBOBOX_OPTIONLIST\"]/div/div[2]/table/tbody/tr[1]/td"));
            tipoTerceros.click();


            Thread.sleep(4000);
            WebElement btnSeleccionar2 = driver.findElement(By.xpath("//*[@id=\"TipoDocumento\"]/div"));
            btnSeleccionar2.click();
            Thread.sleep(1000);
            WebElement tipoDocIdentificacion  = driver.findElement(By.xpath("//*[@id=\"VAADIN_COMBOBOX_OPTIONLIST\"]/div/div[2]/table/tbody/tr[2]/td/span"));
            tipoDocIdentificacion.click();

            Thread.sleep(1000);
            if (cumulosAseguradoBean.getPasaporte() != null){
                WebElement pasaporte = driver.findElement(By.xpath("//*[@id=\"Pasaporte\"]"));
                pasaporte.sendKeys(cumulosAseguradoBean.getPasaporte());
            }


            Thread.sleep(1000);
            WebElement numDocIdentificacion = driver.findElement(By.xpath("//*[@id=\"DocumentoIdentidad\"]"));
            numDocIdentificacion.sendKeys(cumulosAseguradoBean.getNumDocIdentificacion());

            Thread.sleep(1000);
            if (cumulosAseguradoBean.getPrimerNombre() != null){
                WebElement primerNombre = driver.findElement(By.xpath("//*[@id=\"Nombre\"]"));
                primerNombre.sendKeys(cumulosAseguradoBean.getPrimerNombre());
            }


            Thread.sleep(1000);
            if (cumulosAseguradoBean.getPrimerApellido() != null){
                WebElement primerApellido = driver.findElement(By.xpath("//*[@id=\"Apellido\"]"));
                primerApellido.sendKeys(cumulosAseguradoBean.getPrimerApellido());
            }

            Thread.sleep(1000);
            if (cumulosAseguradoBean.getEstadoCivil() != null){
                WebElement btnSeleccionar3 = driver.findElement(By.xpath("//*[@id=\"EstadoCivil\"]/div"));
                btnSeleccionar3.click();
                Thread.sleep(1000);
                WebElement estadoCivil  = driver.findElement(By.xpath("//*[@id=\"VAADIN_COMBOBOX_OPTIONLIST\"]/div/div[2]/table/tbody/tr[3]/td"));
                estadoCivil.click();
            }


            Thread.sleep(1000);
            if (cumulosAseguradoBean.getEmail_1() != null){
                WebElement email_1 = driver.findElement(By.xpath("//*[@id=\"Email\"]"));
                email_1.sendKeys(cumulosAseguradoBean.getEmail_1());
            }


            Thread.sleep(1000);
            a.ScreenShot(driver,"screen5",nombreAutomatizacion);

            Thread.sleep(1000);
            WebElement btnBuscar = driver.findElement(By.xpath("//*[@id=\"panelThirdParty\"]/div[2]/div/div[5]/div/div[3]/div/span/span"));
            btnBuscar.click();

            Thread.sleep(2000);
            WebElement btnResultadoBusqueda= driver.findElement(By.xpath("//*[@id=\"gwt-uid-78\"]/div[2]/div[1]/table/tbody/tr/td[1]/div"));
            btnResultadoBusqueda.click();
            Thread.sleep(2000);
            a.ScreenShot(driver,"screen6",nombreAutomatizacion);

            Thread.sleep(5000);
            WebElement btnCumuloAsegurado= driver.findElement(By.xpath("//*[@id=\"panelThirdParty\"]/div[2]/div/div[7]/div/div[2]/div/div[3]/div/div[1]/div/span/span"));
            btnCumuloAsegurado.click();

            Thread.sleep(2000);
            a.ScreenShot(driver,"screen7",nombreAutomatizacion);


        }catch (Exception e) {
            e.printStackTrace();
//                log.info(e);
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);

        }
    }


}
