package AcseleV13_8LBC.main.controller;

import AcseleV13_8.main.controller.Menu.MenuMantenimiento;
import AcseleV13_8LBC.beans.LBC_TercerosUpdateRolBean;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.io.IOException;

/**
 * Created by aazuaje on 24/10/2016.
 */
public class LBC_TercerosUpdateRol {

    private final static Logger log = Logger.getLogger(LBC_TercerosUpdateRolBean.class);

    public String nombreAutomatizacion = "Terceros Update Rol LBC";

    public void testLink(LBC_TercerosUpdateRolBean lbc_tercerosUpdateRol, int i) throws IOException, InterruptedException {

        // Instanciando clases
        LBC_Metodos a = new LBC_Metodos();
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
        BusquedaT(a, driver, lbc_tercerosUpdateRol); //Busqueda Tercero

        // Boton Editar
        // driver.findElement(By.xpath("//form/input")).click();
        driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_showDetailSearchTable_proof_TableForm_associateButton']")).click();
        Thread.sleep(3000);

        UpdateRol(a, driver, lbc_tercerosUpdateRol);

        a.regresarVentana(driver);

        IngresarMenuTrazaAuditoriaVaadin(driver, a);
        Thread.sleep(2000);
        a.cambiarVentana(driver);

        TrazaAuditoriaVaadin(driver, a, lbc_tercerosUpdateRol);


    }

    public void BusquedaT(LBC_Metodos a, WebDriver driver, LBC_TercerosUpdateRolBean lbc_tercerosUpdateRol) throws InterruptedException, IOException{

        try{
            Thread.sleep(4000);
            String title = driver.getTitle();
            System.out.println("Titulo de la pagina: " + title);

            //Tipo de tercero
            if (lbc_tercerosUpdateRol.getTipoTerceros() != null) {
                Thread.sleep(3000);
                Select tipoT = new Select(driver.findElement(By.xpath("//select[@wicketpath='SearchContent_ThirdInformation_thirdPartyTypes']")));
                tipoT.selectByValue(lbc_tercerosUpdateRol.getTipoTerceros());
            }
            Thread.sleep(2000); // //TipoElemento[@wicketpath='WicketpathElemento']

            if (lbc_tercerosUpdateRol.getApellido() != null) {
                // WebElement aTercero = driver.findElement(By.name("templateThird:repeaterPanel1:5:fila:field"));
                WebElement aTercero = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_5_fila_field']"));
                aTercero.sendKeys(lbc_tercerosUpdateRol.getApellido());
            }

            if (lbc_tercerosUpdateRol.getNombre() != null) {
                // WebElement nTercero = driver.findElement(By.name("templateThird:repeaterPanel1:3:fila:field"));
                WebElement nTercero = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_3_fila_field']"));
                nTercero.sendKeys(lbc_tercerosUpdateRol.getNombre());
            }

            if (lbc_tercerosUpdateRol.getTipoDocIdentificacion() != null){
                // Select tipoDoc = new Select(driver.findElement(By.name("templateThird:repeaterPanel1:1:fila:repeaterSelect:1:field")));
                Select tipoDoc = new Select(driver.findElement(By.xpath("//select[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_1_fila_repeaterSelect_1_field']")));
                tipoDoc.selectByValue(lbc_tercerosUpdateRol.getTipoDocIdentificacion());
            }

            if (lbc_tercerosUpdateRol.getNumDocIdentificacion() != null) {
                // WebElement cedu = driver.findElement(By.name("templateThird:repeaterPanel1:2:fila:field"));
                WebElement cedu = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_2_fila_field']"));
                cedu.sendKeys(lbc_tercerosUpdateRol.getNumDocIdentificacion());
            }

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
            log.info("Test Case 24 - LBC_Terceros Update Roles - " + e);
        }

    }

    public void UpdateRol(LBC_Metodos a, WebDriver driver, LBC_TercerosUpdateRolBean lbc_tercerosUpdateRol) throws InterruptedException {

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
            log.info("Test Case 24 - LBC_Terceros Update Roles - " + e);
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
            gene.selectByValue(lbc_tercerosUpdateRol.getGenero());
            Thread.sleep(2000);
            // fecNac = driver.findElement(By.xpath("//div[2]/div/div/div[4]/input")); // Fecha nacimiento
            fecNac = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_panelRol_templateContainer_rolTempForm_templateBasicThird_tabPanel_repeaterTab_1_SubTabsInformation_repeater_2_fila_fieldDate']")); // Fecha nacimiento
            fecNac.clear();
            fecNac.sendKeys(lbc_tercerosUpdateRol.getFechaNac());
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
            log.info("Test Case 24 - LBC_Terceros Update Roles - " + e);
        }
    }

    public void IngresarMenuTrazaAuditoriaVaadin(WebDriver driver, LBC_Metodos a) throws IOException, InterruptedException {

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
            log.info("Test Case 24 - LBC_Terceros Update Roles - " + e);
        }
    }

    public void TrazaAuditoriaVaadin(WebDriver driver, LBC_Metodos a, LBC_TercerosUpdateRolBean lbc_tercerosUpdateRol) throws InterruptedException, IOException {

        Thread.sleep(3000);
        // Fecha desde
        WebElement feDesde = driver.findElement(By.xpath("//div[3]/div/div/div[3]/div/input"));
        // Fecha Hasta
        WebElement feHasta = driver.findElement(By.xpath("//tr[5]/td[3]/div/div/div[3]/div/div/div[3]/div/input"));
        // Boton Buscar
        WebElement btnBusca = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/div[1]/div/div[2]/div/table/tbody/tr[7]/td[3]/div/div/div/div/span/span"));

        feDesde.sendKeys(lbc_tercerosUpdateRol.getAudFechaDesde());
        Thread.sleep(1000);
        feHasta.sendKeys(lbc_tercerosUpdateRol.getAudFechaHasta());
        Thread.sleep(1000);

        a.ScreenShot(driver, "screen10", nombreAutomatizacion);
        Toolkit.getDefaultToolkit().beep();

        btnBusca.click();
        Thread.sleep(3000);

        a.ScreenShot(driver, "screen11", nombreAutomatizacion);
        Toolkit.getDefaultToolkit().beep();

    }
}
