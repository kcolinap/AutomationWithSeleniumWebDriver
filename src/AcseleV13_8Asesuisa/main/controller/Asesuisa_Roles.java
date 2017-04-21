package AcseleV13_8Asesuisa.main.controller;

import AcseleV13_8Asesuisa.beans.Asesuisa_ModosdePagoBean;
import AcseleV13_8Asesuisa.beans.Asesuisa_RolesBean;
import AcseleV13_8Asesuisa.beans.Asesuisa_TercerosCreacionRepetidaBean;
import AcseleV13_8Asesuisa.main.controller.Asesuisa_Menu.Asesuisa_MenuMantenimiento;
import AcseleV13_8Asesuisa.main.controller.Asesuisa_Terceros.Asesuisa_CrearTerceros;
import AcseleV13_8Asesuisa.main.controller.Asesuisa_TercerosCreacionRepetida;
import metodo.Metodos;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;


/**
 * Created by aandrade on 29/03/2017.
 */
public class Asesuisa_Roles {

    private final static Logger log = Logger.getLogger(Asesuisa_Roles.class);

    public String nombreAutomatizacion = "Asesuisa Roles";
    private WebDriver driver;

    public void testLink(Asesuisa_RolesBean bean, int i, String folderName) {

        try {

            // Instanciando clases
            Metodos a = new Metodos();
            Asesuisa_MenuMantenimiento menuMantenimiento = new Asesuisa_MenuMantenimiento();
            Asesuisa_TercerosCreacionRepetida asesuisaCrearTerceros = new Asesuisa_TercerosCreacionRepetida();



            driver = a.entrarPagina(a.UrlAsesuisa());
            a.IniciarSesion(driver, nombreAutomatizacion, i, folderName);
            a.ValidandoSesion(driver, nombreAutomatizacion, i, folderName);
            Thread.sleep(5000);

            //Entrando en Menu
            menuMantenimiento.MantTerc_IngresarTercero(driver, nombreAutomatizacion, 2, i, folderName);

            Thread.sleep(2000);
            a.cambiarVentana(driver);
            Thread.sleep(2000);

            CrearTercero(bean, a, i, folderName, 3, 4, 5, 6, 7, 8);
            Thread.sleep(3000);

            //Entrando en Menu
            //Ingreso a la opcion consulta de terceros
            menuMantenimiento.MantTerc_BuscarTercero(driver, nombreAutomatizacion, 2, i, folderName);


            Thread.sleep(2000);
            a.cambiarVentana(driver);
            Thread.sleep(2000);

            BusquedaT(bean, a, i, folderName, 3,4,5,6,7);
            AgregarRol(bean, a, i, folderName, 8, 9, 10, 11, 12);


            Thread.sleep(1000);


           driver.quit();

        } catch (Exception e) {
            e.printStackTrace();
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
            if (driver != null) {
               driver.quit();
            }
        }
    }

    public void CrearTercero(Asesuisa_RolesBean bean, Metodos a, int i, String folderName, int numScreenShoot, int numScreenShoot2, int numScreenShoot3, int numScreenShoot4,
                             int numScreenShoot5, int numScreenShoot6){

        if (bean.getTipoTercero() != null){
            Select tipoTercero = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_ThirdInformation_thirdPartyTypes']")));
            tipoTercero.selectByValue(bean.getTipoTercero());
            Thread.sleep(1000);
        }

        WebElement otro = driver.findElement(By.xpath("//div[@wicketpath='ThirdInformationContent_ThirdInformation_ThirdInformationLabel']"));

        // Benefeciario Asegurado AP
        if (bean.getAsegurado() != null){
            Select aseguradoAp = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_ThirdInformation_templateContainer_formThirdBasic_DataTemplate_repeaterPanel1_1_fila_repeaterSelect_1_field']")));
            aseguradoAp.selectByValue(bean.getAsegurado());
            Thread.sleep(1000);
            otro.click();
            Thread.sleep(1000);
        }

        // Primer nombre
        if (bean.getPRIMERNOMBRE() != null){
            WebElement nombre1 = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_ThirdInformation_templateContainer_formThirdBasic_DataTemplate_repeaterPanel2_1_fila_field']"));
            nombre1.sendKeys(bean.getPRIMERNOMBRE());
            otro.click();
            Thread.sleep(1000);
        }

        // Primer apellido
        if (bean.getPrimerApellido() != null){
            WebElement apellido1 = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_ThirdInformation_templateContainer_formThirdBasic_DataTemplate_repeaterPanel2_2_fila_field']"));
            apellido1.sendKeys(bean.getPrimerApellido());
            otro.click();
            Thread.sleep(1000);
        }

        // Fecha de nacimiento
        if (bean.getFechaNacimiento() != null){
            WebElement fechaNacimiento = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_ThirdInformation_templateContainer_formThirdBasic_DataTemplate_repeaterPanel2_4_fila_fieldDate']"));
            fechaNacimiento.sendKeys(bean.getFechaNacimiento());
            otro.click();
            Thread.sleep(1000);
        }

        // DUI
        if (bean.getNumeroDUI() != null){
            WebElement dui = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_ThirdInformation_templateContainer_formThirdBasic_DataTemplate_repeaterPanel2_5_fila_field']"));
            dui.sendKeys(bean.getNumeroDUI());
            otro.click();
            Thread.sleep(1000);
        }

        // NIT
        if (bean.getNumeroNIT() != null){
            WebElement nit = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_ThirdInformation_templateContainer_formThirdBasic_DataTemplate_repeaterPanel1_5_fila_field']"));
            nit.sendKeys(bean.getNumeroNIT());
            otro.click();
            Thread.sleep(1000);
        }

        // Tipo documento identificacion
        if (bean.getTipoDocumentoIdentificacion() != null){
            Select tipoDocId = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_ThirdInformation_templateContainer_formThirdBasic_DataTemplate_repeaterPanel2_6_fila_repeaterSelect_1_field']")));
            tipoDocId.selectByValue(bean.getTipoDocumentoIdentificacion());
            Thread.sleep(1000);
            otro.click();
            Thread.sleep(1000);
        }

        // Numero documento identificacion
        if (bean.getNumeroDocumentoIdentificacion() != null){
            WebElement numId = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_ThirdInformation_templateContainer_formThirdBasic_DataTemplate_repeaterPanel1_7_fila_field']"));
            numId.sendKeys(bean.getNumeroDocumentoIdentificacion());
            otro.click();
            Thread.sleep(1000);
        }



        WebElement btnGuardar = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_ThirdInformation_templateContainer_formThirdBasic_saveButton']"));
        btnGuardar.click();
        a.waitSearchWicket(driver, "Espere, Guardando Tercero");

        Thread.sleep(3000);


    }


    public void BusquedaT(Asesuisa_RolesBean bean, Metodos a, int i, String folderName, int numScreenShoot, int numScreenShoot2, int numScreenShoot3, int numScreenShoot4, int numScreenShot5) {

        try {

            Thread.sleep(2000);
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            WebElement etiqueta;

            //Tipo tercero
            if (bean.getTipoTercero() != null) {
                Thread.sleep(1000);
                Select tipoT = new Select(driver.findElement(By.xpath("//select[@wicketpath='SearchContent_ThirdInformation_thirdPartyTypes']")));
                tipoT.selectByValue(bean.getTipoTercero());
                Thread.sleep(1000);
            }

            //AseguradoAP
            if (bean.getAsegurado() != null) {
                Select aseguradoAp = new Select(driver.findElement(By.xpath("//select[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_1_fila_repeaterSelect_1_field']")));
                aseguradoAp.selectByValue(bean.getAsegurado());
                Thread.sleep(1000);
            }

            //AseguradoAP
            if (bean.getPRIMERNOMBRE() != null) {
               WebElement pNombre = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel2_1_fila_field']"));
                pNombre.sendKeys(bean.getPRIMERNOMBRE());
                Thread.sleep(1000);
            }



            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion, folderName);
            Thread.sleep(1000);


            //Boton buscar
            jse.executeScript("window.scrollBy(0,500)", "");
            WebElement buscar = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_searchButton']"));
            buscar.click();
            Thread.sleep(1000);
            buscar = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_searchButton']"));
            buscar.click();
            jse.executeScript("window.scrollBy(0,300)", "");
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot2, nombreAutomatizacion, folderName);
            Thread.sleep(1000);







            //seleccionar tercero encontrado

            Thread.sleep(2000);
            WebElement selccionTercero = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_showDetailSearchTable_proof_ThirdPartyRadioGroup_resultsTable_2_thirdPartyRadio']"));
            selccionTercero.click();


            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot3, nombreAutomatizacion, folderName);

            //Boton editar
            WebElement editar = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_showDetailSearchTable_proof_TableForm_associateButton']"));
            editar.click();
            jse.executeScript("window.scrollBy(0,1000)", "");

            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot4, nombreAutomatizacion, folderName);
            Thread.sleep(1000);

        } catch (Exception e) {
            e.printStackTrace();
            log.error("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }

    public void AgregarRol(Asesuisa_RolesBean bean, Metodos a, int i, String folderName, int numScreenShoot, int numScreenShoot2, int numScreenShoot3, int numScreenShoot4, int numScreenShoot5){

        try{
            Thread.sleep(2000);
            JavascriptExecutor jse = (JavascriptExecutor)driver;

            if (bean.getTIPOROL() != null){
                Thread.sleep(2000);
                Select tipoT = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_thirdInformation_panelRol_rolForm_rolComb']")));
                tipoT.selectByValue(bean.getTIPOROL());
                Thread.sleep(1000);
            }

            WebElement Agregar = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_panelRol_rolForm_AddButton']"));
            Agregar.click();
            Thread.sleep(1000);
            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion, folderName);
            Thread.sleep(1000);
         //   WebElement otro = driver.findElement(By.xpath("//div[@wicketpath='ThirdInformationContent_thirdInformation_rolMessage']"));

            if (bean.getTIPOCOMPROBANTE() != null) {
                Thread.sleep(1000);
                Select tComprobante = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_thirdInformation_panelRol_templateContainer_rolTempForm_templateBasicThird_tabPanel_repeaterTab_1_SubTabsInformation_repeater_2_fila_repeaterSelect_1_field']")));
                tComprobante.selectByValue(bean.getTIPOCOMPROBANTE());
                // otro.click();
                Thread.sleep(1000);
            }

            if (bean.getTIPOPROVEEDOR() != null) {
                Thread.sleep(1000);
                Select tProveedor = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_thirdInformation_panelRol_templateContainer_rolTempForm_templateBasicThird_tabPanel_repeaterTab_1_SubTabsInformation_repeater_3_fila_repeaterSelect_1_field']")));
                tProveedor.selectByValue(bean.getTIPOPROVEEDOR());
                // otro.click();
                Thread.sleep(1000);
            }

            if (bean.getESPECIALIDAD1() != null) {
                Thread.sleep(1000);
                WebElement especialidad1 = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_panelRol_templateContainer_rolTempForm_templateBasicThird_tabPanel_repeaterTab_1_SubTabsInformation_repeater_4_fila_Group_FirstRepeater_1_checked']"));
                especialidad1.click();
                Thread.sleep(1000);
            }

            jse.executeScript("window.scrollBy(0,1000)", "");

            if (bean.getCLASIFIAREA() != null) {
                Thread.sleep(1000);
                Select areaClasifi = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_thirdInformation_panelRol_templateContainer_rolTempForm_templateBasicThird_tabPanel_repeaterTab_1_SubTabsInformation_repeater_5_fila_repeaterSelect_1_field']")));
                areaClasifi.selectByValue(bean.getCLASIFIAREA());
                Thread.sleep(1000);
            }

            if (bean.getCONTRATO() != null) {
                Thread.sleep(1000);
                Select contrato = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_thirdInformation_panelRol_templateContainer_rolTempForm_templateBasicThird_tabPanel_repeaterTab_1_SubTabsInformation_repeater_6_fila_repeaterSelect_1_field']")));
                contrato.selectByValue(bean.getCONTRATO());
                // otro.click();
                Thread.sleep(1000);
            }

            if (bean.getCONVENIO() != null) {
                Thread.sleep(1000);
                Select convenio = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_thirdInformation_panelRol_templateContainer_rolTempForm_templateBasicThird_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_1_fila_repeaterSelect_1_field']")));
                convenio.selectByValue(bean.getCONVENIO());
                // otro.click();
                Thread.sleep(1000);

            }

            jse.executeScript("window.scrollBy(0,500)", "");

    /*        if (bean.getTIPOPAGO() != null) {
                Thread.sleep(1000);
                Select tPago = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_thirdInformation_panelRol_templateContainer_rolTempForm_templateBasicThird_tabPanel_repeaterTab_2_SubTabsInformation_repeater_1_fila_repeaterSelect_1_field']")));
                tPago.selectByValue(bean.getTIPOPAGO());
                Thread.sleep(1000);

            }
            */

            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot3, nombreAutomatizacion, folderName);
            Thread.sleep(1000);
          //  jse.executeScript("window.scrollBy(0,500)", "");
            driver.findElement(By.xpath("//*[@id=\"campos_obligatoriosPan\"]/h1/div")).click();
            WebElement guardar = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_panelRol_templateContainer_rolTempForm_saveButton']"));
            guardar.click();
            Thread.sleep(4000);

        } catch (Exception e) {
            e.printStackTrace();
            log.error("Test Case - " + nombreAutomatizacion + " - " + e);
        }



    }



}
