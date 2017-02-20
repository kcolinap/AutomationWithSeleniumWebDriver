package AcseleV13_8_Interseguros.main.controller;

import AcseleV13_8_Interseguros.beans.Inter_TercerosDocumentosBean;
import AcseleV13_8_Interseguros.main.controller.Inter_Terceros.Inter_BuscarTerceros;
import AcseleV13_8_Interseguros.main.controller.Interseguros_Menu.Interseguros_MenuMantenimiento;
import metodo.Metodos;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by agil on 26/01/2017.
 */
public class Inter_TercerosDocumentos {

    private final static Logger log = Logger.getLogger(INTER_TercerosDirecciones.class);

    public String nombreAutomatizacion = "Terceros Documentos";
    private WebDriver driver;

    public void testLink(Inter_TercerosDocumentosBean interTercerosDocumentosBean, int i, String folderName){

        try {

            // Instanciando clases
            Metodos a = new Metodos();
            Interseguros_MenuMantenimiento interMenuMantenimiento = new Interseguros_MenuMantenimiento();
            Inter_BuscarTerceros interBuscarTerceros = new Inter_BuscarTerceros();

            driver = a.entrarPagina(a.UrlInterseguros());
            a.IniciarSesion(driver, nombreAutomatizacion, i, folderName);
            a.ValidandoSesion(driver, nombreAutomatizacion, i, folderName);
            Thread.sleep(5000);

            //Entrando en Menu
            interMenuMantenimiento.MantTerc_BuscarTercero(driver, nombreAutomatizacion, 2, i, folderName);

            // Consulta del Tercero Creado
            Thread.sleep(2000);
            a.cambiarVentana(driver);
            Thread.sleep(2000);
            interBuscarTerceros.BusquedaT(driver, a, interTercerosDocumentosBean, nombreAutomatizacion, i, folderName, 3, 4, 5, 6);
            CargaDocumentos(a, interTercerosDocumentosBean, i, folderName, 7, 8);
            RegresarBusqueda(a, interTercerosDocumentosBean, i, folderName, 9, 10);

            driver.quit();

        }catch (Exception e) {
            e.printStackTrace();
            log.error("Test Case - " + nombreAutomatizacion + " - " + e);
            if (driver != null){
                driver.quit();
            }
        }
    }

    public void CargaDocumentos (Metodos a, Inter_TercerosDocumentosBean interTercerosDocumentosBean, int i, String folderName, int numScreenShoot, int numScreenShoot2) {

        try {

            // Boton Documentos
            WebElement btnDocumentos = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_showDetailSearchTable_proof_TableForm_thirdDocumentsButton']"));
            btnDocumentos.click();
            Thread.sleep(2000);

            // Boton de carga de documentos
            WebElement carga = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_EditThirdDocuments_thirdDocsForm_fileInput']"));//.sendKeys("C://prueba.txt");
            carga.click();

            Runtime.getRuntime().exec("C:\\AcseleTests\\AutomationTestAcsele\\AutoIT\\interTercerosDocumentos.exe");
            Thread.sleep(1500);

            if (interTercerosDocumentosBean.getDescripcion() != null) {
                WebElement cedu = driver.findElement(By.xpath("//textarea[@wicketpath='ThirdInformationContent_EditThirdDocuments_thirdDocsForm_fileDesc']"));
                cedu.clear();
                Thread.sleep(500);
                cedu = driver.findElement(By.xpath("//textarea[@wicketpath='ThirdInformationContent_EditThirdDocuments_thirdDocsForm_fileDesc']"));
                cedu.sendKeys(interTercerosDocumentosBean.getDescripcion());
                Thread.sleep(500);
            }

            if (interTercerosDocumentosBean.getTipoArchivoAdjuntar() != null) {
                Thread.sleep(3000);
                Select tipoT = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_EditThirdDocuments_thirdDocsForm_ThirdPartyDocumentsTemplate_repeaterPanel1_1_fila_repeaterSelect_1_field']")));
                tipoT.selectByValue(interTercerosDocumentosBean.getTipoArchivoAdjuntar());
                Thread.sleep(500);
            }

            if (interTercerosDocumentosBean.getComentarioArchivoAdjuntado() != null) {
                WebElement cedu = driver.findElement(By.xpath("//textarea[@wicketpath='ThirdInformationContent_EditThirdDocuments_thirdDocsForm_ThirdPartyDocumentsTemplate_repeaterPanel2_1_fila_field']"));
                cedu.clear();
                Thread.sleep(500);
                cedu = driver.findElement(By.xpath("//textarea[@wicketpath='ThirdInformationContent_EditThirdDocuments_thirdDocsForm_ThirdPartyDocumentsTemplate_repeaterPanel2_1_fila_field']"));
                cedu.sendKeys(interTercerosDocumentosBean.getComentarioArchivoAdjuntado());
                Thread.sleep(500);
            }

            a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion, folderName);

            //Boton Agregar
            WebElement btnAgregar = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_EditThirdDocuments_thirdDocsForm_fileSubmit']"));
            btnAgregar.click();
            a.waitSearchWicket(driver, "Espere: Carga de Archivos");

            a.ScreenShotPool(driver, i, "screen" + numScreenShoot2, nombreAutomatizacion, folderName);

        }catch (Exception e) {
            e.printStackTrace();
            log.error("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }

    public void RegresarBusqueda (Metodos a, Inter_TercerosDocumentosBean interTercerosDocumentosBean, int i, String folderName, int numScreenShoot, int numScreenShoot2) {

        try {

            JavascriptExecutor jse = (JavascriptExecutor)driver;

            WebElement btnRegresar = driver.findElement(By.xpath("//span[@wicketpath='ThirdInformationContent_backToSearch_backSearchLabel']"));
            btnRegresar.click();
            Thread.sleep(2000);

            WebElement selTercero = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_showDetailSearchTable_proof_ThirdPartyRadioGroup_resultsTable_2_thirdPartyRadio']"));
            selTercero.click();

            WebElement btnDocumentos = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_showDetailSearchTable_proof_TableForm_thirdDocumentsButton']"));
            btnDocumentos.click();

            Thread.sleep(2000);

            jse.executeScript("window.scrollBy(0,500)", "");
            Thread.sleep(2000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion, folderName);

        }catch (Exception e) {
            e.printStackTrace();
            log.error("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }
}
