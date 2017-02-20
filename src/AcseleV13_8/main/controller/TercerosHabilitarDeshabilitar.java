package AcseleV13_8.main.controller;

import AcseleV13_8.beans.TercerosHabilitarDeshabilitarBean;
import AcseleV13_8.main.controller.Menu.MenuMantenimiento;
import AcseleV13_8.main.controller.Menu.MenuOperaciones;
import AcseleV13_8.main.controller.PolizaEmision.InformacionGeneralPoliza;
import AcseleV13_8.main.controller.PolizaEmision.PrePoliza;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.io.IOException;

/**
 * Created by agil on 12/07/2016.
 */
public class TercerosHabilitarDeshabilitar {

    private final static Logger log = Logger.getLogger(TercerosHabilitarDeshabilitar.class);

    public String nombreAutomatizacion = "Terceros Habilitar Deshabilitar";

    public void testLink(TercerosHabilitarDeshabilitarBean tercerosHabilitarDeshabilitarBean, int i) throws Exception{

        // Instanciando clases
        Metodos13_8 a = new Metodos13_8();
        MenuMantenimiento menuMantenimiento = new MenuMantenimiento();
        MenuOperaciones menuOperaciones = new MenuOperaciones();
        PrePoliza prePoliza = new PrePoliza();
        InformacionGeneralPoliza informacionGeneralPoliza = new InformacionGeneralPoliza();

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
        BusquedaT(a, driver, tercerosHabilitarDeshabilitarBean); //Busqueda Tercero

        // Boton Habilitar Deshabilitar
        WebElement btnHabDesh = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_showDetailSearchTable_proof_TableForm_EnableDisableThirdButton']"));
        btnHabDesh.click();

        Thread.sleep(3000);
        a.ScreenShot(driver, "screen7", nombreAutomatizacion);
        Toolkit.getDefaultToolkit().beep();
        Thread.sleep(1000);


        // Aceptar la Habilitación/Deshabilitación del tercero
        WebElement btnAceptar = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_showDetailSearchTable_confirmDialog_content_questionForm_confirmButton']"));
        btnAceptar.click();
        Thread.sleep(3000);
        WebElement selccionTercero = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_showDetailSearchTable_proof_ThirdPartyRadioGroup_resultsTable_2_thirdPartyRadio']"));
        selccionTercero.click();
        Thread.sleep(1000);
        a.ScreenShot(driver, "screen8", nombreAutomatizacion);
        Toolkit.getDefaultToolkit().beep();

        // Cerrar la ventana
        driver.close();
        // Regresar a Ventana anterior
        a.regresarVentana(driver);

        // Creación de Póliza
        menuOperaciones.OpePol_Crear(driver, nombreAutomatizacion, 9, i);
        Thread.sleep(2000);
        a.cambiarVentana(driver);
        Thread.sleep(2000);
        //CrearPoliza(a, driver, tercerosHabilitarDeshabilitarBean);

        /** Creando la póliza */

        // PrePoliza
        Thread.sleep(2000);
        prePoliza.AdminPropuestaPoliza(a, driver, tercerosHabilitarDeshabilitarBean, nombreAutomatizacion, i, 3);
        Thread.sleep(2000);
        prePoliza.EvAplicar(a, driver, tercerosHabilitarDeshabilitarBean, nombreAutomatizacion, i, 4);
        Thread.sleep(2000);
        informacionGeneralPoliza.InformacionGeneral(a, driver, tercerosHabilitarDeshabilitarBean, nombreAutomatizacion, i, 5);
        Thread.sleep(2000);
        CrearPoliza(a, driver, tercerosHabilitarDeshabilitarBean);

    }

    public void BusquedaT(Metodos13_8 a, WebDriver driver, TercerosHabilitarDeshabilitarBean tercerosHabilitarDeshabilitarBean) throws InterruptedException, IOException{

        Thread.sleep(4000);
        try {
            String title = driver.getTitle();
            System.out.println("Titulo de la pagina: " + title);

            //Tipo de tercero
            if (tercerosHabilitarDeshabilitarBean.getTipTercer() != null){
                Thread.sleep(3000);
                Select tipoT = new Select(driver.findElement(By.xpath("//select[@wicketpath='SearchContent_ThirdInformation_thirdPartyTypes']")));
                tipoT.selectByValue(tercerosHabilitarDeshabilitarBean.getTipTercer());
            }
            Thread.sleep(2000);

            if (tercerosHabilitarDeshabilitarBean.getTipDcID() != null){
                Select tipoDoc = new Select(driver.findElement(By.xpath("//select[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_1_fila_repeaterSelect_1_field']")));
                tipoDoc.selectByValue(tercerosHabilitarDeshabilitarBean.getTipDcID());
            }

            if (tercerosHabilitarDeshabilitarBean.getCedulaID() != null) {
                WebElement cedu = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_2_fila_field']"));
                cedu.sendKeys(tercerosHabilitarDeshabilitarBean.getCedulaID());
            }

            if (tercerosHabilitarDeshabilitarBean.getNombreT() != null) {
                WebElement nTercero = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_3_fila_field']"));
                nTercero.sendKeys(tercerosHabilitarDeshabilitarBean.getNombreT());
            }

//        if (tercerosHabilitarDeshabilitarBean.getApellidoT() != null) {
//        WebElement aTercero = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_5_fila_field']"));
//            aTercero.sendKeys(tercerosHabilitarDeshabilitarBean.getApellidoT());
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
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }

    public void CrearPoliza(Metodos13_8 a, WebDriver driver, TercerosHabilitarDeshabilitarBean tercerosHabilitarDeshabilitarBean) throws InterruptedException {

        // //TipoElemento[@wicketpath='WicketpathElemento']

        Thread.sleep(4000);
        // Tomador (Tercero) // //TipoElemento[@wicketpath='WicketpathElemento']
        try {
            WebElement btnBusquedaAvanzada = driver.findElement(By.xpath("//a[@wicketpath='policyInformationContent_PolicyInformation_thirdTabs_repeaterSubTab_1_thirdRole_Tomador_thirdForm_detailSearchLink']"));
            btnBusquedaAvanzada.click();

            Thread.sleep(2000);

            Select tipoTeceroSelect = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_thirdTabs_repeaterSubTab_1_thirdRole_Tomador_thirdForm_detailSearch_thirdPartyTypes']")));
            Select tipoDocIdSelect = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_thirdTabs_repeaterSubTab_1_thirdRole_Tomador_thirdForm_detailSearch_templateContainer_searchForm_templateThird_repeaterPanel1_1_fila_repeaterSelect_1_field']")));
            WebElement cedulaInput = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_thirdTabs_repeaterSubTab_1_thirdRole_Tomador_thirdForm_detailSearch_templateContainer_searchForm_templateThird_repeaterPanel1_2_fila_field']"));
            WebElement nombreInput = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_thirdTabs_repeaterSubTab_1_thirdRole_Tomador_thirdForm_detailSearch_templateContainer_searchForm_templateThird_repeaterPanel1_3_fila_field']"));
            WebElement apellidoInput = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_thirdTabs_repeaterSubTab_1_thirdRole_Tomador_thirdForm_detailSearch_templateContainer_searchForm_templateThird_repeaterPanel1_5_fila_field']"));
            WebElement btnBuscarTomador = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_thirdTabs_repeaterSubTab_1_thirdRole_Tomador_thirdForm_detailSearch_templateContainer_searchForm_searchButton']"));

            if (tercerosHabilitarDeshabilitarBean.getTipTercer() != null){
                tipoTeceroSelect.selectByValue(tercerosHabilitarDeshabilitarBean.getTipTercer());
            }
            if (tercerosHabilitarDeshabilitarBean.getTipDcID() != null){
                tipoDocIdSelect.selectByValue(tercerosHabilitarDeshabilitarBean.getTipDcID());
            }
            if (tercerosHabilitarDeshabilitarBean.getCedulaID() != null){
                cedulaInput.sendKeys(tercerosHabilitarDeshabilitarBean.getCedulaID());
            }
            if (tercerosHabilitarDeshabilitarBean.getNombreT() != null){
                nombreInput.sendKeys(tercerosHabilitarDeshabilitarBean.getNombreT());
            }
            if (tercerosHabilitarDeshabilitarBean.getApellidoT() != null){
                apellidoInput.sendKeys(tercerosHabilitarDeshabilitarBean.getApellidoT());
            }

            Thread.sleep(2000);
            a.ScreenShot(driver, "screen13", nombreAutomatizacion); //screenshot2
            Toolkit.getDefaultToolkit().beep();
            Thread.sleep(1000);

            btnBuscarTomador.click();

            Thread.sleep(2000);
            a.ScreenShot(driver, "screen14", nombreAutomatizacion); //screenshot2
            Toolkit.getDefaultToolkit().beep();
            Thread.sleep(1000);

        }catch (Exception e){
            e.printStackTrace();
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }

}
