package AcseleV13_8LBC.main.controller;


import AcseleV13_8.main.controller.Menu.MenuOperaciones;
import AcseleV13_8LBC.beans.LBC_ConsultaListasRestricBean;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;

/**
 * Created by aazuaje on 28/10/2016.
 */
public class LBC_ConsultaListasRestric {

    private final static Logger log = Logger.getLogger(LBC_ConsultaListasRestric.class);

    public String nombreAutomatizacion = "LBC Listas Restrictivas";

    public void testLink(LBC_ConsultaListasRestricBean lbc_consultaListasRestricBean,int i) throws IOException, InterruptedException {

        //implementando clase de metodos
        LBC_Metodos a = new LBC_Metodos();
        MenuOperaciones m = new MenuOperaciones();
        WebDriver driver = a.entrarPagina();
        a.IniciarSesion(driver, nombreAutomatizacion, i);
        a.ValidandoSesion(driver, nombreAutomatizacion, i);
        Thread.sleep(5000);

        m.ConsultarListaRestrictiva (driver, a, nombreAutomatizacion, i);
        Thread.sleep(8000);
        a.cambiarVentana(driver);
        BusquedaLista(driver, a, lbc_consultaListasRestricBean, i);


    }

    public void BusquedaLista (WebDriver driver, LBC_Metodos a, LBC_ConsultaListasRestricBean lbc_consultaListasRestricBean, int i) throws IOException, InterruptedException{

        try{
            Thread.sleep(3000);
            a.ScreenShotPool(driver,i, "screen4",nombreAutomatizacion);
            WebElement btnListas = driver.findElement(By.xpath("//*[@id=\"RestrictiveListCombo\"]/div"));
            btnListas.click();
            Thread.sleep(1000);
            WebElement listaLbc  = driver.findElement(By.xpath("//*[@id=\"VAADIN_COMBOBOX_OPTIONLIST\"]/div/div[2]/table/tbody/tr[3]/td"));
            Thread.sleep(3000);
            a.ScreenShotPool(driver,i,"screen5",nombreAutomatizacion);
            listaLbc.click();


            Thread.sleep(2000);
            WebElement nomApellLista = driver.findElement(By.xpath("//*[@id=\"NombreyApellido\"]"));
            nomApellLista.sendKeys(lbc_consultaListasRestricBean.getNomApellLista());
            Thread.sleep(1000);

            if (lbc_consultaListasRestricBean.getDocIdenLista()!= null){
                WebElement docIdenLista = driver.findElement(By.xpath("//*[@id=\"DocumentoIdentidad\"]"));
            docIdenLista.sendKeys(lbc_consultaListasRestricBean.getDocIdenLista());
            }

            
            Thread.sleep(1000);
            a.ScreenShotPool(driver,i,"screen6",nombreAutomatizacion);
            WebElement btnBuscar = driver.findElement(By.xpath("//*[@id=\"SearchPersonInRestrictiveListPanel\"]/div[2]/div/div[3]/div/div[1]/div/span/span"));
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