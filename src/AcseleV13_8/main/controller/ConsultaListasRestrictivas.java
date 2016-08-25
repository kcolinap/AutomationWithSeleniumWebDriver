package AcseleV13_8.main.controller;

import AcseleV13_8.beans.ConsultaListasRestrictivasBean;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;

/**
 * Created by aazuaje on 25/08/2016.
 */
public class ConsultaListasRestrictivas {
    private final static Logger log = Logger.getLogger(ConsultaListasRestrictivas.class);

    public String nombreAutomatizacion = "Listas Restrictivas";

    public void testLink(ConsultaListasRestrictivasBean consultaListasRestrictivasBean,int i) throws IOException, InterruptedException {

        //implementando clase de metodos
        Metodos a = new Metodos();
        WebDriver driver = a.entrarPagina();
        a.IniciarSesion(driver, nombreAutomatizacion);
        a.ValidandoSesion(driver, nombreAutomatizacion);
        Thread.sleep(5000);

        MenuConsultaListasRestrictivas(driver, a);
        Thread.sleep(8000);
        a.cambiarVentana(driver);
        BusquedaLista(driver, a, consultaListasRestrictivasBean);


    }

    public void MenuConsultaListasRestrictivas(WebDriver driver,Metodos a) throws IOException, InterruptedException {
        WebElement menu1 = driver.findElement(By.xpath("/html/body/div[3]/div[2]"));//operacion
        WebElement menu2 = driver.findElement(By.xpath("/html/body/div[5]/div[13]"));//consulta listas restrictivas


        menu1.click();
        a.ScreenShot(driver,"screen3",nombreAutomatizacion);
        Thread.sleep(4000);
        menu2.click();
        Thread.sleep(2000);

    }

    public void BusquedaLista (WebDriver driver, Metodos a, ConsultaListasRestrictivasBean consultaListasRestrictivasBean) throws IOException, InterruptedException{

        try{
            Thread.sleep(3000);
            a.ScreenShot(driver,"screen4",nombreAutomatizacion);
            WebElement btnListas = driver.findElement(By.xpath("//*[@id=\"RestrictiveListCombo\"]/div"));
            btnListas.click();
            Thread.sleep(1000);
            WebElement listaRestrictiva  = driver.findElement(By.xpath("//*[@id=\"VAADIN_COMBOBOX_OPTIONLIST\"]/div/div[2]/table/tbody/tr[5]/td/span"));
            Thread.sleep(3000);
            a.ScreenShot(driver,"screen5",nombreAutomatizacion);
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
            a.ScreenShot(driver,"screen6",nombreAutomatizacion);
            WebElement btnBuscar = driver.findElement(By.xpath("//*[@id=\"SearchPersonInRestrictiveListPanel\"]/div[2]/div/div[3]/div/div[1]/div/span"));
            btnBuscar.click();
            Thread.sleep(2000);
            a.ScreenShot(driver,"screen7",nombreAutomatizacion);

            WebElement btnSeleccionarLista = driver.findElement(By.xpath("//*[@id=\"SearchPersonInRestrictiveListPanel\"]/div[2]/div/div[4]/div/div[1]/div/div[3]/div[1]/table/tbody/tr[1]/td[2]/div"));
            btnSeleccionarLista.click();
            Thread.sleep(1000);

            WebElement btnDetalle = driver.findElement(By.xpath("//*[@id=\"SearchPersonInRestrictiveListPanel\"]/div[2]/div/div[4]/div/div[5]/div/div/div/span/span"));
            Thread.sleep(1000);
            a.ScreenShot(driver,"screen8",nombreAutomatizacion);
            btnDetalle.click();

            Thread.sleep(1000);
            a.ScreenShot(driver,"screen9",nombreAutomatizacion);


        }catch (Exception e) {
            e.printStackTrace();
//                log.info(e);
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);

        }


    }














}
