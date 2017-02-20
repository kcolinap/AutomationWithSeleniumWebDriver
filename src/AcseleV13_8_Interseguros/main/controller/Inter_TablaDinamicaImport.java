package AcseleV13_8_Interseguros.main.controller;

import AcseleV13_8_Interseguros.beans.Inter_TablaDinamicaImportBean;
import AcseleV13_8_Interseguros.main.controller.Interseguros_Menu.Interseguros_MenuMantenimiento;
import metodo.Metodos;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by agil on 07/02/2017.
 */
public class Inter_TablaDinamicaImport {

    private final static Logger log = Logger.getLogger(Inter_TablaDinamicaImport.class);

    public String nombreAutomatizacion = "Inter Tabla Dinamica Import";
    private WebDriver driver;
    Metodos a = new Metodos();

    public void testLink(Inter_TablaDinamicaImportBean interTablaDinamicaimportBean, int i, String folderName){

        try {

            // Instanciando clases
            Interseguros_MenuMantenimiento menuMantenimiento = new Interseguros_MenuMantenimiento();

            driver = a.entrarPagina(a.UrlInterseguros());
            a.IniciarSesion(driver, nombreAutomatizacion, i, folderName);
            a.ValidandoSesion(driver, nombreAutomatizacion, i, folderName);
            Thread.sleep(5000);


            //Entrando en Menu
            menuMantenimiento.MantGeral_TablasDinamicas(driver, nombreAutomatizacion, 2, i, folderName);

            Thread.sleep(2000);
            a.cambiarVentana(driver);
            Thread.sleep(2000);

            /** Tabla Dinamica */

            Thread.sleep(3000);
            BuscarTablaDinamica(interTablaDinamicaimportBean, i, folderName, 3);
            ImportarTablaDinamica(interTablaDinamicaimportBean, i, folderName, 4, 5);

            //driver.quit();

        } catch (Exception e) {
            e.printStackTrace();
            log.error("Test Case - " + nombreAutomatizacion + " - " + e);
            /*if (driver != null){
                driver.quit();
            }*/
        }
    }

    public void BuscarTablaDinamica(Inter_TablaDinamicaImportBean bean, int i, String folderName, int numScreenShoot){

        try {

            Thread.sleep(2000);
            WebElement nombreTablaDinamica = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/form/table/tbody/tr[3]/td[2]/input"));
            nombreTablaDinamica.sendKeys(bean.getNombreTablaDinamica());

            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion, folderName);

            WebElement btnEnviar = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/form/table/tbody/tr[5]/td/input[2]"));
            btnEnviar.click();

        } catch (Exception e) {
            e.printStackTrace();
            log.error("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }

    public void ImportarTablaDinamica(Inter_TablaDinamicaImportBean bean, int i, String folderName, int numScreenShoot, int numScreenShoot2){

        try {

            JavascriptExecutor jse = (JavascriptExecutor)driver;
            Thread.sleep(2000);
            jse.executeScript("window.scrollBy(0,600)", "");

            a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion, folderName);

            WebElement btnImportarTabla = driver.findElement(By.xpath("//*[@id=\"idb_0402008_TableTemplateViewer_07\"]"));
            btnImportarTabla.click();

            Thread.sleep(1000);

            a.changeLastWindows(driver);

            WebElement rutaArchivo = driver.findElement(By.xpath("/html/body/center/form/table/tbody/tr[2]/td/input[1]"));
            rutaArchivo.sendKeys(bean.getRutaArchivo());

            Thread.sleep(500);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot2, nombreAutomatizacion, folderName);

            WebElement btnAceptar = driver.findElement(By.xpath("//*[@id=\"idb_0402023_selectXMLFile_01\"]"));
            btnAceptar.click();

            Thread.sleep(1000);
            if (ExpectedConditions.alertIsPresent() != null) {
                Thread.sleep(1000);
                Alert alert = driver.switchTo().alert();
                alert.accept();
                Thread.sleep(1000);
                driver.switchTo().defaultContent();
            }

        } catch (Exception e) {
            e.printStackTrace();
            log.error("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }
}
