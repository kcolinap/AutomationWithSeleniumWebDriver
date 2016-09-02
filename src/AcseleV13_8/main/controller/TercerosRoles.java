package AcseleV13_8.main.controller;

import AcseleV13_8.beans.TercerosRolesBean;
import AcseleV13_8.main.controller.Menu.MenuMantenimiento;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.io.IOException;

/**
 * Created by agil on 16/06/2016.
 */
public class TercerosRoles {

    private final static Logger log = Logger.getLogger(TercerosRoles.class);

    String nombreAutomatizacion = "Terceros Roles";

    public void testLink(TercerosRolesBean tercerosRolesBean, int i)throws Exception{

        // Instanciando clases
        Metodos a = new Metodos();
        MenuMantenimiento menuMantenimiento = new MenuMantenimiento();

        WebDriver driver = a.entrarPagina();
        a.IniciarSesion(driver, nombreAutomatizacion);
        a.ValidandoSesion(driver, nombreAutomatizacion);
        Thread.sleep(5000);

        //Entrando en Menu
        menuMantenimiento.MantTerc_BuscarTercero(a, driver, nombreAutomatizacion, 2);

        Thread.sleep(2000);
        a.cambiarVentana(driver);
        Thread.sleep(2000);
        BusquedaT(a, driver, tercerosRolesBean); //Busqueda Tercero

        // Boton Editar
        //driver.findElement(By.xpath("//form/input")).click();
        driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_showDetailSearchTable_proof_TableForm_associateButton']")).click();
        Thread.sleep(2000);

        RolesTerceros(a, driver, tercerosRolesBean);

        Thread.sleep(3000);
        a.ScreenShot(driver, "screen7", nombreAutomatizacion);


    }

    public void BusquedaT(Metodos a, WebDriver driver, TercerosRolesBean tercerosRolesBean) throws InterruptedException, IOException{

        Thread.sleep(4000);
        String title = driver.getTitle();
        System.out.println("Titulo de la pagina: " + title);

        //Tipo de tercero
        if (tercerosRolesBean.getTipoTercero() != null) {
            Thread.sleep(3000);
            //Select tipoT = new Select(driver.findElement(By.name("SearchContent:ThirdInformation:thirdPartyTypes")));
            Select tipoT = new Select(driver.findElement(By.xpath("//select[@wicketpath='SearchContent_ThirdInformation_thirdPartyTypes']")));
            tipoT.selectByValue(tercerosRolesBean.getTipoTercero());
        }
        Thread.sleep(2000);

        if (tercerosRolesBean.getTipoDocId() != null){
            //Select tipoDoc = new Select(driver.findElement(By.name("templateThird:repeaterPanel1:1:fila:repeaterSelect:1:field")));
            Select tipoDoc = new Select(driver.findElement(By.xpath("//select[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_1_fila_repeaterSelect_1_field']")));
            tipoDoc.selectByValue(tercerosRolesBean.getTipoDocId());
        }

        if (tercerosRolesBean.getCedula() != null) {
            //WebElement cedu = driver.findElement(By.name("templateThird:repeaterPanel1:2:fila:field"));
            WebElement cedu = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_2_fila_field']"));
            cedu.sendKeys(tercerosRolesBean.getCedula());
        }

        if (tercerosRolesBean.getNombre() != null) {
            //WebElement nTercero = driver.findElement(By.name("templateThird:repeaterPanel1:3:fila:field"));
            WebElement nTercero = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_3_fila_field']"));
            nTercero.sendKeys(tercerosRolesBean.getNombre());
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

    }

    public void RolesTerceros(Metodos a, WebDriver driver, TercerosRolesBean tercerosRolesBean) throws InterruptedException, IOException {

        // Tipo de rol
        //Select tRol = new Select(driver.findElement(By.xpath("//div[2]/div/div/select")));
        Select tRol = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_thirdInformation_panelRol_rolForm_rolComb']")));
        tRol.selectByVisibleText(tercerosRolesBean.getRol());
        Thread.sleep(3000); //TipoElemento[@wicketpath='WicketpathElemento']

        // Boton Agregar
        //driver.findElement(By.xpath("//div[2]/div[2]/input")).click();
        driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_panelRol_rolForm_AddButton']")).click();
        Thread.sleep(2000);

        // Nombre Entidad Bancaria
        //Select nomEntBan = new Select(driver.findElement(By.xpath("//div[2]/div[2]/div/div[2]/table/tbody/tr/td/div/div/div/div/select")));
        Select nomEntBan = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_thirdInformation_panelRol_templateContainer_rolTempForm_templateBasicThird_tabPanel_repeaterTab_2_SubTabsInformation_repeater_1_fila_repeaterSelect_1_field']")));
        nomEntBan.selectByValue(tercerosRolesBean.getEntBancaria());

        // Tipo de Cuenta Bancaria
        //Select tCtaBan = new Select(driver.findElement(By.name("templateBasicThird:tabPanel:repeaterTab:2:SubTabsInformation:repeater:2:fila:repeaterSelect:1:field")));
        Select tCtaBan = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_thirdInformation_panelRol_templateContainer_rolTempForm_templateBasicThird_tabPanel_repeaterTab_2_SubTabsInformation_repeater_2_fila_repeaterSelect_1_field']")));
        tCtaBan.selectByValue(tercerosRolesBean.getTipoCtaBanc());

        // No.de Cuenta Bancaria
        //WebElement nCtaBan = driver.findElement(By.xpath("//div[2]/div[2]/div/div[2]/table/tbody/tr/td[2]/div/div/div/input[2]"));
        WebElement nCtaBan = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_panelRol_templateContainer_rolTempForm_templateBasicThird_tabPanel_repeaterTab_2_SubTabsInformation_repeater2_1_fila_field']"));
        nCtaBan.sendKeys(tercerosRolesBean.getNumCtaBanc());
//        Thread.sleep(2000);

        // Boton Guardar
        //driver.findElement(By.xpath("//div[2]/div/div[2]/input")).click();
        driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_panelRol_templateContainer_rolTempForm_saveButton']")).click();
        Thread.sleep(4000);

        // Mensaje de error
        //driver.findElement(By.name("AcceptButton")).click();
        driver.findElement(By.name("//input[@wicketpath='ThirdInformationContent_thirdInformation_panelRol_templateContainer_errorsPanel_content_errorsForm_AcceptButton']")).click();
        Thread.sleep(2000);

        // Tipo de Cuenta Bancaria
//        Select tCtaBan = new Select(driver.findElement(By.xpath("//div[2]/div/div/div/select")));
        //tCtaBan = new Select(driver.findElement(By.name("templateBasicThird:tabPanel:repeaterTab:2:SubTabsInformation:repeater:2:fila:repeaterSelect:1:field")));
        tCtaBan = new Select(driver.findElement(By.name("//select[@wicketpath='ThirdInformationContent_thirdInformation_panelRol_templateContainer_rolTempForm_templateBasicThird_tabPanel_repeaterTab_2_SubTabsInformation_repeater_1_fila_repeaterSelect_1_field']")));
        tCtaBan.selectByValue(tercerosRolesBean.getTipoCtaBanc());
        Thread.sleep(2000);

        // No.de Cuenta Bancaria
//        WebElement nCtaBan = driver.findElement(By.xpath("//div[2]/div[2]/div/div[2]/table/tbody/tr/td[2]/div/div/div/input[2]"));
//        nCtaBan = driver.findElement(By.name("templateBasicThird:tabPanel:repeaterTab:2:SubTabsInformation:repeater2:1:fila:field"));
        //WebElement nCtaBan2 = driver.findElement(By.xpath("//div[2]/div[2]/div/div[2]/table/tbody/tr/td[2]/div/div/div/input[2]"));
        WebElement nCtaBan2 = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_panelRol_templateContainer_rolTempForm_templateBasicThird_tabPanel_repeaterTab_2_SubTabsInformation_repeater2_1_fila_field']"));
        nCtaBan2.click();
        nCtaBan2.sendKeys(tercerosRolesBean.getNumCtaBanc());
        Thread.sleep(2000);

        a.ScreenShot(driver, "screen6", nombreAutomatizacion);
        Thread.sleep(1000);

        // Boton Guardar
        //driver.findElement(By.xpath("//div[2]/div/div[2]/input")).click();
        driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_panelRol_templateContainer_rolTempForm_saveButton']")).click();
        Thread.sleep(2000);

        System.out.println("Fin Prueba");


    }

}
