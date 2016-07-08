package main.controller;

import beans.TercerosUpdateRolesBean;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.io.IOException;

/**
 * Created by agil on 23/06/2016.
 */
public class TercerosUpdateRoles {

    private final static Logger log = Logger.getLogger(TercerosUpdateRoles.class);

    String nombreAutomatizacion = "Terceros Update Roles";

    public void testLink(TercerosUpdateRolesBean tercerosUpdateRolesBean, int i) throws IOException, InterruptedException {

        //implementando clase de metodos
        Metodos a = new Metodos();
        WebDriver driver = a.entrarPagina();
        a.IniciarSesion(driver, nombreAutomatizacion);
        a.ValidandoSesion(driver, nombreAutomatizacion);
        Thread.sleep(5000);

        // Consulta del Tercero Creado
        IngresarMenuBuscarTercero(driver, a); //Menu
        Thread.sleep(2000);
        a.cambiarVentana(driver);
        Thread.sleep(2000);
        BusquedaT(a, driver, tercerosUpdateRolesBean); //Busqueda Tercero

        // Boton Editar
        // driver.findElement(By.xpath("//form/input")).click();
        driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_showDetailSearchTable_proof_TableForm_associateButton']")).click();
        Thread.sleep(3000);

        UpdateRol(a, driver, tercerosUpdateRolesBean);

        a.regresarVentana(driver);

        IngresarMenuTrazaAuditoriaVaadin(driver, a);
        Thread.sleep(2000);
        a.cambiarVentana(driver);

        TrazaAuditoriaVaadin(driver, a, tercerosUpdateRolesBean);


    }

    public void IngresarMenuBuscarTercero(WebDriver driver, Metodos a) throws IOException, InterruptedException {

        try {
            WebElement menu1 = driver.findElement(By.xpath("/html/body/div[3]/div[4]"));// Mantenimiento
            WebElement menu2 = driver.findElement(By.xpath("/html/body/div[35]/div[2]"));//Mantenimiento de terceros
            WebElement menu3 = driver.findElement(By.xpath("/html/body/div[36]/div[2]"));//buscar tercero
            menu1.click();
            menu2.click();
            a.ScreenShot(driver, "screen3", nombreAutomatizacion); //screenshot2
            menu3.click();

        } catch (Exception e){
            e.printStackTrace();
//             log.info(e);
            log.info("Test Case 24 - Terceros Update Roles - " + e);
        }
    }

    public void BusquedaT(Metodos a, WebDriver driver, TercerosUpdateRolesBean tercerosUpdateRolesBean) throws InterruptedException, IOException{

        try{
            Thread.sleep(4000);
            String title = driver.getTitle();
            System.out.println("Titulo de la pagina: " + title);

            //Tipo de tercero
            if (tercerosUpdateRolesBean.getTipoTercero() != null) {
                Thread.sleep(3000);
                // Select tipoT = new Select(driver.findElement(By.name("SearchContent:ThirdInformation:thirdPartyTypes")));
                Select tipoT = new Select(driver.findElement(By.xpath("//select[@wicketpath='SearchContent_ThirdInformation_thirdPartyTypes']")));
                tipoT.selectByValue(tercerosUpdateRolesBean.getTipoTercero());
            }
            Thread.sleep(2000); // //TipoElemento[@wicketpath='WicketpathElemento']

            if (tercerosUpdateRolesBean.getTipoDocId() != null){
                // Select tipoDoc = new Select(driver.findElement(By.name("templateThird:repeaterPanel1:1:fila:repeaterSelect:1:field")));
                Select tipoDoc = new Select(driver.findElement(By.xpath("//select[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_1_fila_repeaterSelect_1_field']")));
                tipoDoc.selectByValue(tercerosUpdateRolesBean.getTipoDocId());
            }

            if (tercerosUpdateRolesBean.getCedula() != null) {
                // WebElement cedu = driver.findElement(By.name("templateThird:repeaterPanel1:2:fila:field"));
                WebElement cedu = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_2_fila_field']"));
                cedu.sendKeys(tercerosUpdateRolesBean.getCedula());
            }

            if (tercerosUpdateRolesBean.getNombre() != null) {
                // WebElement nTercero = driver.findElement(By.name("templateThird:repeaterPanel1:3:fila:field"));
                WebElement nTercero = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_3_fila_field']"));
                nTercero.sendKeys(tercerosUpdateRolesBean.getNombre());
            }

//        if (tercerosUpdateRolesBean.getApellido() != null) {
//            // WebElement aTercero = driver.findElement(By.name("templateThird:repeaterPanel1:5:fila:field"));
//            WebElement aTercero = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_5_fila_field']"));
//            aTercero.sendKeys(tercerosUpdateRolesBean.getApellido());
//        }

            //Screenshot
            a.ScreenShot(driver, "screen4", nombreAutomatizacion);
            Toolkit.getDefaultToolkit().beep();

            // WebElement buscar = driver.findElement(By.name("searchButton"));
            WebElement buscar = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_searchButton']"));
            buscar.click();
            Thread.sleep(5000);

            // WebElement selccionTercero = driver.findElement(By.name("SearchContent:ThirdInformation:showDetailSearchTable:proof:ThirdPartyRadioGroup"));
            WebElement selccionTercero = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_showDetailSearchTable_proof_ThirdPartyRadioGroup_resultsTable_1_thirdPartyRadio']"));
            selccionTercero.click();

            Thread.sleep(1000);
            //Screenshot
            a.ScreenShot(driver, "screen5", nombreAutomatizacion);
            Toolkit.getDefaultToolkit().beep();

        } catch (Exception e){
            e.printStackTrace();
//             log.info(e);
            log.info("Test Case 24 - Terceros Update Roles - " + e);
        }

    }

    public void UpdateRol(Metodos a, WebDriver driver, TercerosUpdateRolesBean tercerosUpdateRolesBean) throws InterruptedException {

        Thread.sleep(3000);
        try {
            // WebElement selRol = driver.findElement(By.xpath("//tr[3]/td/div/input")); // Seleccionar el Rol
            WebElement selRol = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_panelRol_container_ThirdRol_3_insurance']")); // Seleccionar el Rol
            // WebElement btnEditar = driver.findElement(By.xpath("//form/div[3]/input")); // Boton Editar
            WebElement btnEditar = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_panelRol_rolForm_EditButton']")); // Boton Editar

            selRol.click();
            Thread.sleep(1000);

            a.ScreenShot(driver, "screen6", nombreAutomatizacion);
            Toolkit.getDefaultToolkit().beep();

            btnEditar.click();
            Thread.sleep(6000);
        } catch (Exception e){
            e.printStackTrace();
//             log.info(e);
            log.info("Test Case 24 - Terceros Update Roles - " + e);
        }

        try{
            // //TipoElemento[@wicketpath='WicketpathElemento']
            // Select gene = new Select(driver.findElement(By.xpath("//div[2]/table/tbody/tr/td/div/div/div/div/select"))); // Genero
            Select gene = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_thirdInformation_panelRol_templateContainer_rolTempForm_templateBasicThird_tabPanel_repeaterTab_1_SubTabsInformation_repeater_1_fila_repeaterSelect_1_field']"))); // Genero
            // WebElement fecNac = driver.findElement(By.xpath("//div[2]/div/div/div[4]/input")); // Fecha nacimiento
            WebElement fecNac = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_panelRol_templateContainer_rolTempForm_templateBasicThird_tabPanel_repeaterTab_1_SubTabsInformation_repeater_2_fila_fieldDate']")); // Fecha nacimiento
            // WebElement btnGuardar = driver.findElement(By.xpath("//div[2]/div/div[2]/input")); // Boton Guardar
            WebElement btnGuardar = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_panelRol_templateContainer_rolTempForm_saveButton']")); // Boton Guardar

            /****/
            a.ScreenShot(driver, "screen7", nombreAutomatizacion);
            Toolkit.getDefaultToolkit().beep();

            Thread.sleep(1000);
            gene.selectByValue(tercerosUpdateRolesBean.getGenero());
            Thread.sleep(2000);
            // fecNac = driver.findElement(By.xpath("//div[2]/div/div/div[4]/input")); // Fecha nacimiento
            fecNac = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_panelRol_templateContainer_rolTempForm_templateBasicThird_tabPanel_repeaterTab_1_SubTabsInformation_repeater_2_fila_fieldDate']")); // Fecha nacimiento
            fecNac.clear();
            fecNac.sendKeys(tercerosUpdateRolesBean.getFechaNac());
            Thread.sleep(1000);

            a.ScreenShot(driver, "screen8", nombreAutomatizacion);
            Toolkit.getDefaultToolkit().beep();

            Thread.sleep(1000);
            btnGuardar.click();
            Thread.sleep(6000);

            driver.close();

        } catch (Exception e){
            e.printStackTrace();
//             log.info(e);
            log.info("Test Case 24 - Terceros Update Roles - " + e);
        }
    }

    public void IngresarMenuTrazaAuditoriaVaadin(WebDriver driver, Metodos a) throws IOException, InterruptedException {

        try {
            WebElement menu1 = driver.findElement(By.xpath("/html/body/div[3]/div[4]"));// Mantenimiento
            WebElement menu2 = driver.findElement(By.xpath("/html/body/div[35]/div[10]"));//Auditoria
            WebElement menu3 = driver.findElement(By.xpath("/html/body/div[42]/div[4]"));//Trazas de Auditoría (Vaadin)
            menu1.click();
            menu2.click();
            a.ScreenShot(driver, "screen9", nombreAutomatizacion); //screenshot2
            Toolkit.getDefaultToolkit().beep();
            menu3.click();

        } catch (Exception e){
            e.printStackTrace();
//             log.info(e);
            log.info("Test Case 24 - Terceros Update Roles - " + e);
        }
    }

    public void TrazaAuditoriaVaadin(WebDriver driver, Metodos a, TercerosUpdateRolesBean tercerosUpdateRolesBean) throws InterruptedException, IOException {

        Thread.sleep(3000);
        // Fecha desde
        WebElement feDesde = driver.findElement(By.xpath("//div[3]/div/div/div[3]/div/input"));
        // Fecha Hasta
        WebElement feHasta = driver.findElement(By.xpath("//tr[5]/td[3]/div/div/div[3]/div/div/div[3]/div/input"));
        // Boton Buscar
        WebElement btnBusca = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/div[1]/div/div[2]/div/table/tbody/tr[7]/td[3]/div/div/div/div/span/span"));

        feDesde.sendKeys(tercerosUpdateRolesBean.getAudFechaDesde());
        Thread.sleep(1000);
        feHasta.sendKeys(tercerosUpdateRolesBean.getAudFechaHasta());
        Thread.sleep(1000);

        a.ScreenShot(driver, "screen10", nombreAutomatizacion);
        Toolkit.getDefaultToolkit().beep();

        btnBusca.click();
        Thread.sleep(3000);

        a.ScreenShot(driver, "screen11", nombreAutomatizacion);
        Toolkit.getDefaultToolkit().beep();

    }
}
