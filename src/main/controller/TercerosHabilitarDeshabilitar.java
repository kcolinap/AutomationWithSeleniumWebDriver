package main.controller;

import beans.TercerosHabilitarDeshabilitarBean;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import sun.awt.windows.ThemeReader;

import java.awt.*;
import java.io.IOException;

/**
 * Created by agil on 05/07/2016.
 */
public class TercerosHabilitarDeshabilitar {

    private final static Logger log = Logger.getLogger(TercerosHabilitarDeshabilitar.class);

    public String nombreAutomatizacion = "Terceros Habilitar Deshabilitar";

    public void testLink(TercerosHabilitarDeshabilitarBean tercerosHabilitarDeshabilitarBean, int i) throws Exception{

        //implementando clase de metodos
        Metodos a = new Metodos();
        WebDriver driver = a.entrarPagina();
        a.IniciarSesion(driver, nombreAutomatizacion);
        a.ValidandoSesion(driver, nombreAutomatizacion);
        Thread.sleep(5000);

        // Consulta del Tercero
        IngresarMenuBuscarTercero(driver, a); //Menu
        Thread.sleep(2000);
        a.cambiarVentana(driver);
        Thread.sleep(2000);
        BusquedaT(a, driver, tercerosHabilitarDeshabilitarBean); //Busqueda Tercero

        // Boton Habilitar Deshabilitar
        WebElement btnHabDesh = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_showDetailSearchTable_proof_TableForm_EnableDisableThirdButton']"));
        btnHabDesh.click();

        Thread.sleep(3000);
        a.ScreenShot(driver, "screen7", nombreAutomatizacion);
        Toolkit.getDefaultToolkit().beep();


        //TipoElemento[@wicketpath='WicketpathElemento']
    }

    public void IngresarMenuBuscarTercero(WebDriver driver, Metodos a) throws IOException, InterruptedException{
        WebElement menu1 = driver.findElement(By.xpath("/html/body/div[3]/div[4]")); // Mantenimiento
        WebElement menu2 = driver.findElement(By.xpath("/html/body/div[35]/div[2]")); // Mantenimiento de Terceros
        WebElement menu3 = driver.findElement(By.xpath("/html/body/div[36]/div[2]")); // Busqueda de Terceros
        menu1.click();
        menu2.click();
        a.ScreenShot(driver, "screen3", nombreAutomatizacion); //screenshot2
        menu3.click();
    }

    public void BusquedaT(Metodos a, WebDriver driver, TercerosHabilitarDeshabilitarBean tercerosHabilitarDeshabilitarBean) throws InterruptedException, IOException{

        Thread.sleep(4000);
        try {
            String title = driver.getTitle();
            System.out.println("Titulo de la pagina: " + title);

            //Tipo de tercero
            if (tercerosHabilitarDeshabilitarBean.getTipoTercero() != null){
                Thread.sleep(3000);
                Select tipoT = new Select(driver.findElement(By.xpath("")));
                tipoT.selectByValue(tercerosHabilitarDeshabilitarBean.getTipoTercero());
            }
            Thread.sleep(2000);

            if (tercerosHabilitarDeshabilitarBean.getTipoDocId() != null){
                Select tipoDoc = new Select(driver.findElement(By.xpath("//select[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_1_fila_repeaterSelect_1_field']")));
                tipoDoc.selectByValue(tercerosHabilitarDeshabilitarBean.getTipoDocId());
            }

            if (tercerosHabilitarDeshabilitarBean.getCedula() != null) {
                WebElement cedu = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_2_fila_field']"));
                cedu.sendKeys(tercerosHabilitarDeshabilitarBean.getCedula());
            }

            if (tercerosHabilitarDeshabilitarBean.getNombre() != null) {
                WebElement nTercero = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_3_fila_field']"));
                nTercero.sendKeys(tercerosHabilitarDeshabilitarBean.getNombre());
            }

//        if (tercerosHabilitarDeshabilitarBean.getApellido() != null) {
//        WebElement aTercero = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_5_fila_field']"));
//            aTercero.sendKeys(tercerosHabilitarDeshabilitarBean.getApellido());
//        }

            //Screenshot
            Thread.sleep(1000);
            a.ScreenShot(driver, "screen4", nombreAutomatizacion);
            Toolkit.getDefaultToolkit().beep();

            WebElement buscar = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_searchButton']"));
            buscar.click();
            Thread.sleep(5000);

            WebElement selccionTercero = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_showDetailSearchTable_proof_ThirdPartyRadioGroup_resultsTable_1_thirdPartyRadio']"));
            selccionTercero.click();

            //Screenshot
            Thread.sleep(1000);
            a.ScreenShot(driver, "screen5", nombreAutomatizacion);
            Toolkit.getDefaultToolkit().beep();

        }catch (Exception e){
            e.printStackTrace();
//             log.info(e);
            log.info("Test Case 21 - " + nombreAutomatizacion + " - " + e);
        }
    }
}
