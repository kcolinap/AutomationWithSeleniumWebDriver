package AcseleV13_8_Interseguros.main.controller;

import AcseleV13_8_Interseguros.beans.INTER_TerceroDeshabilitarBean;
import AcseleV13_8_Interseguros.main.controller.Interseguros_Menu.Interseguros_MenuMantenimiento;
import AcseleV13_8_Interseguros.main.controller.Interseguros_Menu.Interseguros_MenuOperaciones;
import AcseleV13_8_Interseguros.main.controller.PolizaEmision.Inter_InformacionGeneralPoliza;
import AcseleV13_8_Interseguros.main.controller.PolizaEmision.Inter_PrePoliza;
import metodo.Metodos;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.io.IOException;

/**
 * Created by aazuaje on 08/02/2017.
 */
public class INTER_TerceroDeshabilitar {

    private final static Logger log = Logger.getLogger(INTER_TerceroDeshabilitar.class);

    public String nombreAutomatizacion = "Tercero Deshabilitar";
    private WebDriver driver;

    public void testLink(INTER_TerceroDeshabilitarBean inter_terceroDeshabilitarBean, int i, String folderName)  throws IOException, InterruptedException {

        try{
            Metodos a = new Metodos();
            Interseguros_MenuMantenimiento interseguros_menuMantenimiento = new Interseguros_MenuMantenimiento();
            Interseguros_MenuOperaciones interseguros_menuOperaciones = new Interseguros_MenuOperaciones ();
            Inter_PrePoliza inter_prePoliza = new Inter_PrePoliza();
            Inter_InformacionGeneralPoliza inter_informacionGeneralPoliza = new Inter_InformacionGeneralPoliza();


            driver = a.entrarPagina(a.UrlInterseguros());
            a.IniciarSesion(driver, nombreAutomatizacion, i, folderName);
            a.ValidandoSesion(driver, nombreAutomatizacion, i, folderName);
            Thread.sleep(1500);
            System.out.println("prueba");

            //Entrando en Menu
            interseguros_menuMantenimiento.MantTerc_BuscarTercero(driver, nombreAutomatizacion, 2, i, folderName);
            Thread.sleep(3000);
            a.cambiarVentana(driver);

            // Consulta del Tercero
            Thread.sleep(2000);
            a.cambiarVentana(driver);
            Thread.sleep(2000);
            BusquedaT(a, driver, inter_terceroDeshabilitarBean,i, folderName, 4,5 ); //Busqueda Tercero


            Thread.sleep(3000);
            Toolkit.getDefaultToolkit().beep();
            Thread.sleep(1000);

            // Cerrar la ventana
            driver.close();
            // Regresar a Ventana anterior
            a.regresarVentana(driver);

            // Creación de Póliza
            interseguros_menuOperaciones.OpePol_Crear(driver, nombreAutomatizacion, 9, i, folderName);
            Thread.sleep(2000);
            a.cambiarVentana(driver);
            Thread.sleep(2000);
            //CrearPoliza(a, driver, tercerosHabilitarDeshabilitarBean);

            /** Creando la póliza */

            // PrePoliza
            Thread.sleep(2000);
            inter_prePoliza.AdministracionPropuestaPoliza(a, driver, inter_terceroDeshabilitarBean, nombreAutomatizacion, i, folderName, 3);
            Thread.sleep(2000);
            inter_prePoliza.EvAplicar(a, driver, inter_terceroDeshabilitarBean, nombreAutomatizacion, i,folderName, 4);
            Thread.sleep(2000);
            inter_informacionGeneralPoliza.InformacionGeneralDotalSimple(a, driver, inter_terceroDeshabilitarBean, nombreAutomatizacion, i, folderName, 5, 6, 7);
            Thread.sleep(2000);
            CrearPoliza (a, driver, inter_terceroDeshabilitarBean,i, folderName, 10, 11 );


            driver.quit();
        }catch (Exception e){
            e.printStackTrace();
            log.error("Test Case - " + nombreAutomatizacion + " - " + e);
            if (driver != null){
                driver.quit();
            }
        }

    }

    public void BusquedaT(Metodos a, WebDriver driver, INTER_TerceroDeshabilitarBean inter_terceroDeshabilitarBean, int i, String folderName, int numScreenShoot4, int numScreenShoot5) throws InterruptedException, IOException{

        Thread.sleep(4000);
        try {
            String title = driver.getTitle();
            System.out.println("Titulo de la pagina: " + title);

            //Tipo de tercero
            if (inter_terceroDeshabilitarBean.getTipoTercero() != null){
                Thread.sleep(3000);
                Select tipoT = new Select(driver.findElement(By.xpath("//select[@wicketpath='SearchContent_ThirdInformation_thirdPartyTypes']")));
                tipoT.selectByValue(inter_terceroDeshabilitarBean.getTipoTercero());
            }
            Thread.sleep(2000);

            /*if (inter_terceroDeshabilitarBean.getTipoDoc() != null){
                Select tipoDoc = new Select(driver.findElement(By.xpath("//select[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_1_fila_repeaterSelect_1_field']")));
                tipoDoc.selectByValue(inter_terceroDeshabilitarBean.getTipoDoc());
            }

            if (inter_terceroDeshabilitarBean.getDocId() != null) {
                WebElement cedu = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_2_fila_field']"));
                cedu.sendKeys(inter_terceroDeshabilitarBean.getDocId());
            }*/


            if (inter_terceroDeshabilitarBean.getApellido() != null) {
                 WebElement aTercero = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_7_fila_field']"));
                 aTercero.sendKeys(inter_terceroDeshabilitarBean.getApellido());
            }

            Thread.sleep(2000);

            if (inter_terceroDeshabilitarBean.getNombre() != null) {
                WebElement nTercero = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_8_fila_field']"));
                nTercero.clear();
                Thread.sleep(1000);
                WebElement otro = driver.findElement(By.xpath("//div[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_8_fila_etiqueta']"));
                otro.click();
                Thread.sleep(500);
                nTercero = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_8_fila_field']"));
                nTercero.sendKeys(inter_terceroDeshabilitarBean.getNombre());
            }

            //Screenshot
            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot4, nombreAutomatizacion, folderName);
            Toolkit.getDefaultToolkit().beep();

            WebElement buscar = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_searchButton']"));
            buscar.click();
            Thread.sleep(2000);

            WebElement buscar2 = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_searchButton']"));
            buscar2.click();
            Thread.sleep(5000);

            //WebElement selccionTercero = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_showDetailSearchTable_proof_ThirdPartyRadioGroup_resultsTable_1_thirdPartyRadio']"));
            //selccionTercero.click();

            //Screenshot
            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot5, nombreAutomatizacion, folderName);
            Toolkit.getDefaultToolkit().beep();

        }catch (Exception e){
            e.printStackTrace();
//             log.info(e);
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }

    public void CrearPoliza(Metodos a, WebDriver driver, INTER_TerceroDeshabilitarBean inter_terceroDeshabilitarBean, int i, String folderName, int numScreenShoot, int numScreenShoot2) throws InterruptedException {

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

            if (inter_terceroDeshabilitarBean.getTipoTercero() != null){
                tipoTeceroSelect.selectByValue(inter_terceroDeshabilitarBean.getTipoTercero());
            }
            if (inter_terceroDeshabilitarBean.getTipoDoc() != null) {
                tipoDocIdSelect.selectByValue(inter_terceroDeshabilitarBean.getTipoDoc());
            }
            if (inter_terceroDeshabilitarBean.getDocId() != null){
                cedulaInput.sendKeys(inter_terceroDeshabilitarBean.getDocId());
            }
            if (inter_terceroDeshabilitarBean.getNombre() != null){
                nombreInput.sendKeys(inter_terceroDeshabilitarBean.getNombre());
            }
            if (inter_terceroDeshabilitarBean.getApellido() != null){
                apellidoInput.sendKeys(inter_terceroDeshabilitarBean.getApellido());
            }

            Thread.sleep(2000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion, folderName); //screenshot2
            Toolkit.getDefaultToolkit().beep();
            Thread.sleep(1000);

            btnBuscarTomador.click();

            Thread.sleep(2000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot2, nombreAutomatizacion, folderName); //screenshot2
            Toolkit.getDefaultToolkit().beep();
            Thread.sleep(1000);

        }catch (Exception e){
            e.printStackTrace();
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }

}
