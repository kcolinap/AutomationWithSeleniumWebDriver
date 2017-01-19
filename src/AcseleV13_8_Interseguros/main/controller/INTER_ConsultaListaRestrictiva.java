package AcseleV13_8_Interseguros.main.controller;


import AcseleV13_8_Interseguros.beans.INTER_ConsultaListaRestrictivaBean;
import AcseleV13_8_Interseguros.main.controller.Interseguros_Menu.Interseguros_MenuOperaciones;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;

/**
 * Created by aazuaje on 18/01/2017.
 */
public class INTER_ConsultaListaRestrictiva {

    private final static Logger log = Logger.getLogger(INTER_ConsultaListaRestrictivaBean.class);

    public String nombreAutomatizacion = "INTER Listas Restrictivas";

    public void testLink(INTER_ConsultaListaRestrictivaBean inter_consultaListaRestrictivaBean,int i) throws IOException, InterruptedException {

        //implementando clase de metodos
        Interseguros_Metodos a = new Interseguros_Metodos();
        Interseguros_MenuOperaciones m = new Interseguros_MenuOperaciones();
        WebDriver driver = a.entrarPagina();
        a.IniciarSesion(driver, nombreAutomatizacion, i);
        a.ValidandoSesion(driver, nombreAutomatizacion, i);
        Thread.sleep(5000);

        m.ConsultarListaRestrictiva (driver, nombreAutomatizacion, i);
        Thread.sleep(8000);
        a.cambiarVentana(driver);
        BusquedaLista(driver, a, inter_consultaListaRestrictivaBean, i);


    }

    public void BusquedaLista (WebDriver driver, Interseguros_Metodos a, INTER_ConsultaListaRestrictivaBean inter_consultaListaRestrictivaBean, int i) throws IOException, InterruptedException{

        try{
            Thread.sleep(3000);
            a.ScreenShotPool(driver,i, "screen4",nombreAutomatizacion);

            WebElement btnListas = driver.findElement(By.xpath("//*[@id=\"RestrictiveListCombo\"]/div"));
            btnListas.click();
            Thread.sleep(1000);

            WebElement listaRestrictiva  = driver.findElement(By.xpath("//*[@id=\"VAADIN_COMBOBOX_OPTIONLIST\"]/div/div[2]/table/tbody/tr[3]/td/span"));
            Thread.sleep(1000);

            a.ScreenShotPool(driver,i,"screen5",nombreAutomatizacion);
            listaRestrictiva.click();

            if (inter_consultaListaRestrictivaBean.getNombre()!= null){
                WebElement nombre = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/div[2]/div/div/div/div[2]/div/table/tbody/tr/td[3]/input"));
                nombre.sendKeys(inter_consultaListaRestrictivaBean.getNombre());
            }

            Thread.sleep(1000);

            if (inter_consultaListaRestrictivaBean.getApellido()!= null){
                WebElement apellido = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/div[2]/div/div/div/div[3]/div/table/tbody/tr/td[3]/input"));
                apellido.sendKeys(inter_consultaListaRestrictivaBean.getApellido());
            }

            Thread.sleep(1000);
            a.ScreenShotPool(driver,i,"screen6",nombreAutomatizacion);

            WebElement btnBuscar = driver.findElement(By.xpath("//*[@id=\"SearchPersonInRestrictiveListPanel\"]/div[2]/div/div[3]/div/div[1]/div/span"));
            btnBuscar.click();
            Thread.sleep(1000);
            a.ScreenShotPool(driver,i,"screen7",nombreAutomatizacion);

            WebElement btnSeleccionarLista = driver.findElement(By.xpath("//*[@id=\"SearchPersonInRestrictiveListPanel\"]/div[2]/div/div[4]/div/div[1]/div/div[3]/div[1]/table/tbody/tr[1]/td[2]/div"));
            btnSeleccionarLista.click();
            Thread.sleep(1000);

            WebElement btnDetalle = driver.findElement(By.xpath("//*[@id=\"SearchPersonInRestrictiveListPanel\"]/div[2]/div/div[4]/div/div[5]/div/div/div/span"));
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
