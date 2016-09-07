package AcseleV13_8.main.controller;

import AcseleV13_8.beans.TercerosDocumentosBean;
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
public class TercerosDocumentos {

    String nombreAutomatizacion = "Terceros Documentos";

    public void testLink(TercerosDocumentosBean tercerosDocumentosBean, int i)throws Exception{

        // Instanciando clases
        Metodos a = new Metodos();
        MenuMantenimiento menuMantenimiento = new MenuMantenimiento();

        WebDriver driver = a.entrarPagina();
        a.IniciarSesion(driver, nombreAutomatizacion, i);
        a.ValidandoSesion(driver, nombreAutomatizacion, i);
        Thread.sleep(5000);

        //Entrando en Menu
        menuMantenimiento.MantTerc_BuscarTercero(a, driver, nombreAutomatizacion, 2);

        // Consulta del Tercero Creado
        Thread.sleep(2000);
        a.cambiarVentana(driver);
        Thread.sleep(2000);
        BusquedaT(a, driver, tercerosDocumentosBean); //Busqueda Tercero

        // Boton Documentos
        //driver.findElement(By.xpath("//input[5]")).click();
        driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_showDetailSearchTable_proof_TableForm_thirdDocumentsButton']")).click();
        Thread.sleep(2000);

        // Boton de carga de documentos
        //driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div[2]/div[2]/div/form/table[1]/tbody/tr[1]/td[2]/input")).sendKeys("C://prueba.txt");
        driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_EditThirdDocuments_thirdDocsForm_fileInput']")).sendKeys("C://prueba.txt");

        //Descripcion
        //driver.findElement(By.name("fileDesc")).sendKeys("Prueba");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//textarea[@wicketpath='ThirdInformationContent_EditThirdDocuments_thirdDocsForm_fileDesc']")).sendKeys("Prueba");

        //Boton Agregar
        //driver.findElement(By.name("fileSubmit")).click();
        driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_EditThirdDocuments_thirdDocsForm_fileSubmit']")).click();
        Thread.sleep(15000);

        a.ScreenShot(driver, "screen6", nombreAutomatizacion);


    }

    public void BusquedaT(Metodos a, WebDriver driver, TercerosDocumentosBean tercerosDocumentosBean) throws InterruptedException, IOException{

        Thread.sleep(4000);
        String title = driver.getTitle();
        System.out.println("Titulo de la pagina: " + title);

        //Tipo de tercero
        if (tercerosDocumentosBean.getTipoTercero() != null) {
            Thread.sleep(3000);
            //Select tipoT = new Select(driver.findElement(By.name("SearchContent:ThirdInformation:thirdPartyTypes")));
            Select tipoT = new Select(driver.findElement(By.xpath("//select[@wicketpath='SearchContent_ThirdInformation_thirdPartyTypes']")));
            tipoT.selectByValue(tercerosDocumentosBean.getTipoTercero());
        }
        Thread.sleep(2000);

        if (tercerosDocumentosBean.getTipoDocId() != null){
            //Select tipoDoc = new Select(driver.findElement(By.name("templateThird:repeaterPanel1:1:fila:repeaterSelect:1:field")));
            Select tipoDoc = new Select(driver.findElement(By.xpath("//select[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_1_fila_repeaterSelect_1_field']")));
            tipoDoc.selectByValue(tercerosDocumentosBean.getTipoDocId());
        }

        if (tercerosDocumentosBean.getCedula() != null) {
            //WebElement cedu = driver.findElement(By.name("templateThird:repeaterPanel1:2:fila:field"));
            WebElement cedu = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_2_fila_field']"));
            cedu.sendKeys(tercerosDocumentosBean.getCedula());
        }

        if (tercerosDocumentosBean.getNombre() != null) {
            //WebElement nTercero = driver.findElement(By.name("templateThird:repeaterPanel1:3:fila:field"));
            WebElement nTercero = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_3_fila_field']"));
            nTercero.sendKeys(tercerosDocumentosBean.getNombre());
        }

//        if (edicionTercerosBean.getApellido() != null) {
//            WebElement aTercero = driver.findElement(By.name("templateThird:repeaterPanel1:5:fila:field"));
            WebElement aTercero = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_5_fila_field']"));
//            aTercero.sendKeys(edicionTercerosBean.getApellido());
//        }

        //Screenshot
        a.ScreenShot(driver, "screen4", nombreAutomatizacion);
        Toolkit.getDefaultToolkit().beep();

        //WebElement buscar = driver.findElement(By.name("searchButton"));
        WebElement buscar = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_searchButton']"));
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

    public void CargaDocumentos(Metodos a, WebDriver driver) {

    }


}
