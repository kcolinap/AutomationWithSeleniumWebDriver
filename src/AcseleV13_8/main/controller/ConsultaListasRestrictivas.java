package AcseleV13_8.main.controller;

import AcseleV13_8.beans.ConsultaListasRestrictivasBean;
import AcseleV13_8.main.controller.Menu.MenuOperaciones;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;

/**
 * Created by aazuaje on 25/08/2016.
 */
public class ConsultaListasRestrictivas {
    private final static Logger log = Logger.getLogger(ConsultaListasRestrictivas.class);

    public String nombreAutomatizacion = "Listas Restrictivas";

    public void testLink(ConsultaListasRestrictivasBean consultaListasRestrictivasBean,int i) throws IOException, InterruptedException {

        //implementando clase de metodos
        Metodos13_8 a = new Metodos13_8();
        MenuOperaciones m = new MenuOperaciones();
        WebDriver driver = a.entrarPagina();
        a.IniciarSesion(driver, nombreAutomatizacion, i);
        a.ValidandoSesion(driver, nombreAutomatizacion, i);
        Thread.sleep(5000);

        m.ConsultarListaRestrictiva (driver, a, nombreAutomatizacion, i);
        Thread.sleep(8000);
        a.cambiarVentana(driver);
        BusquedaLista(driver, a, consultaListasRestrictivasBean, i);


    }

    public void BusquedaLista (WebDriver driver, Metodos13_8 a, ConsultaListasRestrictivasBean consultaListasRestrictivasBean, int i) throws IOException, InterruptedException{

        try{
            Thread.sleep(3000);
            a.ScreenShotPool(driver,i, "screen4",nombreAutomatizacion);
            WebElement btnListas = driver.findElement(By.xpath("//*[@id=\"RestrictiveListCombo\"]/div"));
            btnListas.click();
            Thread.sleep(1000);
            WebElement listaRestrictiva  = driver.findElement(By.xpath("//*[@id=\"VAADIN_COMBOBOX_OPTIONLIST\"]/div/div[2]/table/tbody/tr[5]/td/span"));
            Thread.sleep(3000);
            a.ScreenShotPool(driver,i,"screen5",nombreAutomatizacion);
            listaRestrictiva.click();

            if (consultaListasRestrictivasBean.getIdentListaRestrictiva()!= null){
                WebElement identListaRestrictiva = driver.findElement(By.xpath("//*[@id=\"IdentificacionListaRes\"]"));
                identListaRestrictiva.sendKeys(consultaListasRestrictivasBean.getIdentListaRestrictiva());
            }

            Thread.sleep(2000);
            WebElement nombreListaRestrictiva = driver.findElement(By.xpath("//*[@id=\"NombresListaRes\"]"));
            nombreListaRestrictiva.sendKeys(consultaListasRestrictivasBean.getNombreListaRestrictiva());
            Thread.sleep(1000);

            WebElement apellidoListaRestrictiva = driver.findElement(By.xpath("//*[@id=\"ApellidosListaRes\"]"));
            apellidoListaRestrictiva.sendKeys(consultaListasRestrictivasBean.getApellidoListaRestrictiva());

            if (consultaListasRestrictivasBean.getCodigoListaRestrictiva()!= null){
                WebElement codigoListaRestrictiva = driver.findElement(By.xpath("//*[@id=\"CodigoListaRestrictiva\"]"));
                codigoListaRestrictiva.sendKeys(consultaListasRestrictivasBean.getCodigoListaRestrictiva());
            }

            if (consultaListasRestrictivasBean.getObservacionListaRestrictiva()!= null){
                WebElement observacionListaRestrictiva = driver.findElement(By.xpath("//*[@id=\"ObservacionListaRes\"]"));
                observacionListaRestrictiva.sendKeys(consultaListasRestrictivasBean.getObservacionListaRestrictiva());
            }

            if (consultaListasRestrictivasBean.getListaRelativaSanciones()!= null){
                WebElement listaRelativaSanciones = driver.findElement(By.xpath("//*[@id=\"ListaRelativaSanciones\"]"));
                listaRelativaSanciones.sendKeys(consultaListasRestrictivasBean.getListaRelativaSanciones());
            }

            Thread.sleep(1000);
            a.ScreenShotPool(driver,i,"screen6",nombreAutomatizacion);
            WebElement btnBuscar = driver.findElement(By.xpath("//*[@id=\"SearchPersonInRestrictiveListPanel\"]/div[2]/div/div[3]/div/div[1]/div/span"));
            btnBuscar.click();
            Thread.sleep(2000);
            a.ScreenShotPool(driver,i,"screen7",nombreAutomatizacion);

            WebElement btnSeleccionarLista = driver.findElement(By.xpath("//*[@id=\"SearchPersonInRestrictiveListPanel\"]/div[2]/div/div[4]/div/div[1]/div/div[3]/div[1]/table/tbody/tr[1]/td[2]/div"));
            btnSeleccionarLista.click();
            Thread.sleep(1000);

            WebElement btnDetalle = driver.findElement(By.xpath("//*[@id=\"SearchPersonInRestrictiveListPanel\"]/div[2]/div/div[4]/div/div[5]/div/div/div/span/span"));
            Thread.sleep(1000);
            a.ScreenShotPool(driver,i,"screen8",nombreAutomatizacion);
            btnDetalle.click();

            Thread.sleep(1000);
            a.ScreenShotPool(driver,i,"screen9",nombreAutomatizacion);


        }catch (Exception e) {
            e.printStackTrace();
//                log.info(e);
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);

        }


    }














}
