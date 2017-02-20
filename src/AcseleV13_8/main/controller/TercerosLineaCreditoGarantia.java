package AcseleV13_8.main.controller;

import AcseleV13_8.beans.TercerosLineaCreditoGarantiaBean;
import AcseleV13_8.main.controller.Menu.MenuMantenimiento;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.io.IOException;

/**
 * Created by agil on 04/07/2016.
 */
public class TercerosLineaCreditoGarantia {

    private final static Logger log = Logger.getLogger(TercerosRoles.class);

    public String nombreAutomatizacion = "LBC_Terceros Linea de Credito Garantia";

    public void testLink(TercerosLineaCreditoGarantiaBean tercerosLineaCreditoGarantiaBean, int i) throws Exception{

        try {

            // Instanciando clases
            Metodos13_8 a = new Metodos13_8();
            MenuMantenimiento menuMantenimiento = new MenuMantenimiento();

            WebDriver driver = a.entrarPagina();
            a.IniciarSesion(driver, nombreAutomatizacion, i);
            a.ValidandoSesion(driver, nombreAutomatizacion, i);
            Thread.sleep(5000);

            //Entrando en Menu
            menuMantenimiento.MantTerc_BuscarTercero(a, driver, nombreAutomatizacion, 2);

            // Consulta del Tercero
            Thread.sleep(2000);
            a.cambiarVentana(driver);
            Thread.sleep(2000);
            BusquedaT(a, driver, tercerosLineaCreditoGarantiaBean, i); //Busqueda Tercero

            // Boton Editar
            driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_showDetailSearchTable_proof_TableForm_associateButton']")).click();
            Thread.sleep(2000);

            LineaCreditoGarantia(a, driver, tercerosLineaCreditoGarantiaBean, i);

            Thread.sleep(3000);
            a.ScreenShotPool(driver, i, "screen7", nombreAutomatizacion);
            Toolkit.getDefaultToolkit().beep();

        }catch (Exception e) {
            e.printStackTrace();
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }

    public void BusquedaT(Metodos13_8 a, WebDriver driver, TercerosLineaCreditoGarantiaBean tercerosLineaCreditoGarantiaBean, int i) throws InterruptedException, IOException{

        Thread.sleep(4000);
        try{
            String title = driver.getTitle();
            System.out.println("Titulo de la pagina: " + title);

            //Tipo de tercero
            if (tercerosLineaCreditoGarantiaBean.getTipoTercero() != null) {
                Thread.sleep(3000);
                Select tipoT = new Select(driver.findElement(By.xpath("//select[@wicketpath='SearchContent_ThirdInformation_thirdPartyTypes']")));
                tipoT.selectByValue(tercerosLineaCreditoGarantiaBean.getTipoTercero());
            }
            Thread.sleep(2000);

            if (tercerosLineaCreditoGarantiaBean.getTipoDocId() != null){
                Select tipoDoc = new Select(driver.findElement(By.xpath("//select[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_1_fila_repeaterSelect_1_field']")));
                tipoDoc.selectByValue(tercerosLineaCreditoGarantiaBean.getTipoDocId());
            }

            if (tercerosLineaCreditoGarantiaBean.getCedula() != null) {
                WebElement cedu = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_2_fila_field']"));
                cedu.sendKeys(tercerosLineaCreditoGarantiaBean.getCedula());
            }

            if (tercerosLineaCreditoGarantiaBean.getNombre() != null) {
                WebElement nTercero = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_3_fila_field']"));
                nTercero.sendKeys(tercerosLineaCreditoGarantiaBean.getNombre());
            }

//        if (edicionTercerosBean.getApellido() != null) {
//        WebElement aTercero = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_5_fila_field']"));
//            aTercero.sendKeys(edicionTercerosBean.getApellido());
//        }

            //Screenshot
            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen4", nombreAutomatizacion);
            Toolkit.getDefaultToolkit().beep();

            WebElement buscar = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_searchButton']"));
            buscar.click();
            Thread.sleep(5000);

            WebElement selccionTercero = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_showDetailSearchTable_proof_ThirdPartyRadioGroup_resultsTable_1_thirdPartyRadio']"));
            selccionTercero.click();

            //Screenshot
            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen5", nombreAutomatizacion);
            Toolkit.getDefaultToolkit().beep();

        }catch (Exception e) {
            e.printStackTrace();
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }


    }

    public void LineaCreditoGarantia(Metodos13_8 a, WebDriver driver, TercerosLineaCreditoGarantiaBean tercerosLineaCreditoGarantiaBean, int i) throws InterruptedException {

        Thread.sleep(4000);
        try{
            String title = driver.getTitle();
            System.out.println("Titulo de la pagina: " + title); // //TipoElemento[@wicketpath='WicketpathElemento']

            WebElement btnAddWarranty = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_panelCreditLine_formThirdCreditLine_AddSecurityButton']"));
            btnAddWarranty.click();

            Thread.sleep(2000);

            WebElement btnAdd = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_panelCreditLine_warrantyPanel_warrantyForm_AddButton']"));
            btnAdd.click();

            Thread.sleep(2000);

            Select tipos = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_thirdInformation_panelCreditLine_warrantyPanel_templateContainer_registerFormThirdDisease_types']")));
            tipos.selectByValue(tercerosLineaCreditoGarantiaBean.getTipos());

            WebElement montos = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_panelCreditLine_warrantyPanel_templateContainer_registerFormThirdDisease_mountField']"));
            montos.sendKeys(tercerosLineaCreditoGarantiaBean.getMontos());

            WebElement descripcion = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_panelCreditLine_warrantyPanel_templateContainer_registerFormThirdDisease_description']"));
            descripcion.sendKeys(tercerosLineaCreditoGarantiaBean.getDescripcion());
            WebElement fechaInicio = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_panelCreditLine_warrantyPanel_templateContainer_registerFormThirdDisease_fieldDate']"));
            fechaInicio.sendKeys(tercerosLineaCreditoGarantiaBean.getFechaDesde());
            WebElement fechaFin = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_panelCreditLine_warrantyPanel_templateContainer_registerFormThirdDisease_fieldDateEnd']"));
            fechaFin.sendKeys(tercerosLineaCreditoGarantiaBean.getFechaHasta());

            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen6", nombreAutomatizacion);
            Toolkit.getDefaultToolkit().beep();

            Thread.sleep(2000);
            WebElement btnGuardar = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_panelCreditLine_warrantyPanel_templateContainer_registerFormThirdDisease_saveButton']"));
            btnGuardar.click();


        }catch (Exception e) {
            e.printStackTrace();
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }

}
