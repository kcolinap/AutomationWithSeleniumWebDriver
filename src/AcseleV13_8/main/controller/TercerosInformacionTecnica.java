package AcseleV13_8.main.controller;

import AcseleV13_8.beans.TercerosInfTecnicaBean;
import AcseleV13_8.main.controller.Menu.MenuMantenimiento;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.io.IOException;

/**
 * Created by agil on 14/06/2016.
 */
public class TercerosInformacionTecnica {

    String nombreAutomatizacion = "Informacion Tecnica de Terceros";

    public void testLink(TercerosInfTecnicaBean tercerosInfTecnicaBean, int i)throws Exception{

        // Instanciando clases
        Metodos a = new Metodos();
        MenuMantenimiento menuMantenimiento = new MenuMantenimiento();

        WebDriver driver = a.entrarPagina();
        a.IniciarSesion(driver, nombreAutomatizacion, i);
        a.ValidandoSesion(driver, nombreAutomatizacion, i);
        Thread.sleep(5000);

        // Consulta del Tercero Creado
        menuMantenimiento.MantTerc_BuscarTercero(a, driver, nombreAutomatizacion, 2);

        Thread.sleep(2000);
        a.cambiarVentana(driver);
        Thread.sleep(2000);
        BusquedaT(a, driver, tercerosInfTecnicaBean); //Busqueda Tercero

        // Boton Inf Tecnica
        //driver.findElement(By.xpath("//input[4]")).click();
        driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_showDetailSearchTable_proof_TableForm_technicalDataButton']")).click();
        Thread.sleep(5000);
        a.ScreenShot(driver, "screen6", nombreAutomatizacion);

    }

    public void BusquedaT(Metodos a, WebDriver driver, TercerosInfTecnicaBean tercerosInfTecnicaBean) throws InterruptedException, IOException{

        Thread.sleep(4000);
        String title = driver.getTitle();
        System.out.println("Titulo de la pagina: " + title);

        //Tipo de tercero
        if (tercerosInfTecnicaBean.getTipoTercero() != null) {
            Thread.sleep(3000);
            //Select tipoT = new Select(driver.findElement(By.name("SearchContent:ThirdInformation:thirdPartyTypes")));
            Select tipoT = new Select(driver.findElement(By.xpath("//select[@wicketpath='SearchContent_ThirdInformation_thirdPartyTypes']")));
            tipoT.selectByValue(tercerosInfTecnicaBean.getTipoTercero());
        }
        Thread.sleep(2000); // //TipoElemento[@wicketpath='WicketpathElemento']

        if (tercerosInfTecnicaBean.getTipoDocId() != null){
            //Select tipoDoc = new Select(driver.findElement(By.name("templateThird:repeaterPanel1:1:fila:repeaterSelect:1:field")));
            Select tipoDoc = new Select(driver.findElement(By.xpath("//select[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_1_fila_repeaterSelect_1_field']")));
            tipoDoc.selectByValue(tercerosInfTecnicaBean.getTipoDocId());
        }

        if (tercerosInfTecnicaBean.getCedula() != null) {
            //WebElement cedu = getDriver().findElement(By.name("templateThird:repeaterPanel1:2:fila:field"));
            //WebElement cedu = driver.findElement(By.name("templateThird:repeaterPanel1:2:fila:field"));
            WebElement cedu = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_2_fila_field']"));
            cedu.sendKeys(tercerosInfTecnicaBean.getCedula());
        }

        if (tercerosInfTecnicaBean.getNombre() != null) {
            //WebElement nTercero = driver.findElement(By.name("templateThird:repeaterPanel1:3:fila:field"));
            WebElement nTercero = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_3_fila_field']"));
            nTercero.sendKeys(tercerosInfTecnicaBean.getNombre());
        }

//        if (edicionTercerosBean.getApellido() != null) {
//            WebElement aTercero = driver.findElement(By.name("templateThird:repeaterPanel1:5:fila:field"));
            //WebElement aTercero = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_5_fila_field']"));
//            aTercero.sendKeys(edicionTercerosBean.getApellido());
//        }

        //Screenshot
        a.ScreenShot(driver, "screen4", nombreAutomatizacion);
        Toolkit.getDefaultToolkit().beep();

        //WebElement buscar = driver.findElement(By.name("searchButton"));
        WebElement buscar = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_searchButton']"));/***/
        buscar.click();
        Thread.sleep(5000);

        //WebElement selccionTercero = driver.findElement(By.name("SearchContent:ThirdInformation:showDetailSearchTable:proof:ThirdPartyRadioGroup"));
        WebElement selccionTercero = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_showDetailSearchTable_proof_ThirdPartyRadioGroup_resultsTable_1_thirdPartyRadio']"));
        selccionTercero.click();

        //Screenshot
        a.ScreenShot(driver, "screen5", nombreAutomatizacion);
        Toolkit.getDefaultToolkit().beep();
/*****/


//        Thread.sleep(3000);
//        driver.close();
    }
}
