package AcseleV13_8Asesuisa.main.controller;

import AcseleV13_8Asesuisa.beans.Asesuisa_TercerosDocumentosBean;
import AcseleV13_8Asesuisa.main.controller.Asesuisa_Menu.Asesuisa_MenuMantenimiento;
import metodo.Metodos;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by agil on 20/04/2017.
 */
public class Asesuisa_TercerosDocumentos {

    private final static Logger log = Logger.getLogger(Asesuisa_TercerosDocumentos.class);

    public String nombreAutomatizacion = "Asesuisa Terceros Documentos";
    private WebDriver driver;

    public void testLink(Asesuisa_TercerosDocumentosBean bean, int i, String folderName){

        try {

            // Instanciando clases
            Metodos a = new Metodos();
            Asesuisa_MenuMantenimiento menuMantenimiento = new Asesuisa_MenuMantenimiento();

            driver = a.entrarPagina(a.UrlAsesuisa());
            a.IniciarSesion(driver, nombreAutomatizacion, i, folderName);
            a.ValidandoSesion(driver, nombreAutomatizacion, i, folderName);
            Thread.sleep(5000);

            //Entrando en Menu
            menuMantenimiento.MantTerc_BuscarTercero(driver, nombreAutomatizacion, 2, i, folderName);

            Thread.sleep(2000);
            a.cambiarVentana(driver);
            Thread.sleep(2000);

            /** Buscar Poliza */

            BuscarTercero(bean, a, i, folderName, 3, 4, 5, 6);
            Thread.sleep(3000);
            TerceroDocumento(bean, a, i, folderName, 7, 8, 9);


            driver.quit();

        } catch (Exception e) {
            e.printStackTrace();
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
            if (driver != null){
                  driver.quit();
            }
        }
    }

    public void BuscarTercero(Asesuisa_TercerosDocumentosBean bean, Metodos a, int i, String folderName, int numScreenShoot, int numScreenShoot2, int numScreenShoot3, int numScreenShoot4){

        what: try {

            //WebElement prueba = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_2_fila_field']"));
            JavascriptExecutor jse = (JavascriptExecutor)driver;

            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion, folderName);
            Thread.sleep(1000);

            Thread.sleep(3000);

            WebElement otro = driver.findElement(By.xpath("//div[@wicketpath='SearchContent_ThirdInformationLabel']"));

            if (bean.getNumeroNIT() != null) {
                WebElement nit = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_5_fila_field']"));
                nit.sendKeys(bean.getNumeroNIT());
                Thread.sleep(1000);
                otro.click();
            }

            jse.executeScript("window.scrollBy(0,-5000)", "");
            Thread.sleep(500);

            //jse.executeScript("window.scrollBy(0,600)", "");
            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot2, nombreAutomatizacion, folderName);
            Thread.sleep(1000);

            jse.executeScript("window.scrollBy(0,600)", "");
            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot3, nombreAutomatizacion, folderName);
            Thread.sleep(1000);

            WebElement btnBuscar = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_searchButton']"));
            btnBuscar.click();
            Thread.sleep(1000);

            a.waitSearchWicket(driver, "Espere: Buscando Tercero");
            Thread.sleep(1000);

            jse.executeScript("window.scrollBy(0,600)", "");
            Thread.sleep(1000);

            WebElement seleccionTercero = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_showDetailSearchTable_proof_ThirdPartyRadioGroup_resultsTable_1_thirdPartyRadio']"));
            seleccionTercero.click();

            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot4, nombreAutomatizacion, folderName);
            Thread.sleep(1000);

            WebElement btnDocumentos = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_showDetailSearchTable_proof_TableForm_thirdDocumentsButton']"));
            btnDocumentos.click();
            Thread.sleep(1000);

            a.waitSearchWicket(driver, "Espere: Ingresando a la edicion del Tercero");

        } catch (Exception e) {
            e.printStackTrace();
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }

    }

    public void TerceroDocumento(Asesuisa_TercerosDocumentosBean bean, Metodos a, int i, String folderName, int numScreenShoot, int numScreenShoot2, int numScreenShoot3){

        doc: try {

            //WebElement prueba = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_2_fila_field']"));
            JavascriptExecutor jse = (JavascriptExecutor)driver;

            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion, folderName);
            Thread.sleep(1000);

            WebElement btnCargaArchivo = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_EditThirdDocuments_thirdDocsForm_fileInput']"));
            btnCargaArchivo.click();

            if (bean.getTipoDocumento().toLowerCase().equals("docx")) {
                Runtime.getRuntime().exec("C:\\AcseleTests\\AutomationTestAcsele\\AutoIT\\asesuisaTercerosDocumentosDocx.exe");
                Thread.sleep(1500);
            }
            else if (bean.getTipoDocumento().toLowerCase().equals("xlsx")) {
                Runtime.getRuntime().exec("C:\\AcseleTests\\AutomationTestAcsele\\AutoIT\\asesuisaTercerosDocumentosXlsx.exe");
                Thread.sleep(1500);
            }
            else if (bean.getTipoDocumento().toLowerCase().equals("pdf")) {
                Runtime.getRuntime().exec("C:\\AcseleTests\\AutomationTestAcsele\\AutoIT\\asesuisaTercerosDocumentosPdf.exe");
                Thread.sleep(1500);
            }
            else if (bean.getTipoDocumento().toLowerCase().equals("txt")) {
                Runtime.getRuntime().exec("C:\\AcseleTests\\AutomationTestAcsele\\AutoIT\\asesuisaTercerosDocumentosTxt.exe");
                Thread.sleep(1500);
            }

            if (bean.getDescripcion() != null) {
                WebElement descripcion = driver.findElement(By.xpath("//textarea[@wicketpath='ThirdInformationContent_EditThirdDocuments_thirdDocsForm_fileDesc']"));
                descripcion.clear();
                Thread.sleep(500);
                descripcion = driver.findElement(By.xpath("//textarea[@wicketpath='ThirdInformationContent_EditThirdDocuments_thirdDocsForm_fileDesc']"));
                descripcion.sendKeys(bean.getDescripcion());
                Thread.sleep(500);
            }

            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot2, nombreAutomatizacion, folderName);
            Thread.sleep(1000);

            WebElement btnAgregar = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_EditThirdDocuments_thirdDocsForm_fileSubmit']"));
            btnAgregar.click();
            Thread.sleep(1000);

            a.waitSearchWicket(driver, "Espere: Agregando Documento");

            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot3, nombreAutomatizacion, folderName);
            Thread.sleep(1000);

        } catch (Exception e) {
            e.printStackTrace();
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }

    }

}
