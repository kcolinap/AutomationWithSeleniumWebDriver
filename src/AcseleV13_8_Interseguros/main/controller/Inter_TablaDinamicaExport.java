package AcseleV13_8_Interseguros.main.controller;

import AcseleV13_8_Interseguros.beans.Inter_TablaDinamicaExportBean;
import AcseleV13_8_Interseguros.main.controller.Interseguros_Menu.Interseguros_MenuMantenimiento;
import metodo.Metodos;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by agil on 07/02/2017.
 */
public class Inter_TablaDinamicaExport {

    private final static Logger log = Logger.getLogger(Inter_TablaDinamicaExport.class);

    public String nombreAutomatizacion = "Inter Tabla Dinamica Export";
    private WebDriver driver;
    Metodos a = new Metodos();

    public void testLink(Inter_TablaDinamicaExportBean interTablaDinamicaExportBean, int i, String folderName){

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
            BuscarTablaDinamica(interTablaDinamicaExportBean, i, folderName, 3);
            ExportarTablaDinamica(interTablaDinamicaExportBean, i, folderName, 4, 5);

            driver.quit();

        } catch (Exception e) {
            e.printStackTrace();
            log.error("Test Case - " + nombreAutomatizacion + " - " + e);
            if (driver != null){
                driver.quit();
            }
        }
    }

    public void BuscarTablaDinamica(Inter_TablaDinamicaExportBean interTablaDinamicaExportBean, int i, String folderName, int numScreenShoot){

        try {

            Thread.sleep(2000);
            WebElement nombreTablaDinamica = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/form/table/tbody/tr[3]/td[2]/input"));
            nombreTablaDinamica.sendKeys(interTablaDinamicaExportBean.getNombreTablaDinamica());

            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion, folderName);

            WebElement btnEnviar = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/form/table/tbody/tr[5]/td/input[2]"));
            btnEnviar.click();

        } catch (Exception e) {
            e.printStackTrace();
            log.error("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }

    public void ExportarTablaDinamica(Inter_TablaDinamicaExportBean interTablaDinamicaExportBean, int i, String folderName, int numScreenShoot, int numScreenShoot2){

        try {

            JavascriptExecutor jse = (JavascriptExecutor)driver;
            Thread.sleep(2000);
            jse.executeScript("window.scrollBy(0,600)", "");

            a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion, folderName);

            WebElement btnExportarTabla = driver.findElement(By.xpath("//*[@id=\"idb_0402008_TableTemplateViewer_06\"]"));
            btnExportarTabla.click();

            a.changeLastWindows(driver);

            Select selectFormato = new Select(driver.findElement(By.xpath("//*[@id=\"formats\"]")));
            selectFormato.selectByValue(interTablaDinamicaExportBean.getFormato());

            btnExportarTabla = driver.findElement(By.xpath("//*[@id=\"expor01\"]"));
            btnExportarTabla.click();

            Thread.sleep(6000);
            a.changeLastWindows(driver);

            Thread.sleep(3000);
            jse.executeScript("window.scrollBy(0,700)", "");

            Thread.sleep(500);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot2, nombreAutomatizacion, folderName);

            WebElement btnCerrar = driver.findElement(By.xpath("//*[@id=\"idb_0402023_DynamicTablesImportExportResultMessage_01\"]"));
            btnCerrar.click();
            Thread.sleep(1000);

            /*a.changeLastWindows(driver);
            Thread.sleep(1000);
            jse.executeScript("window.scrollBy(0,-700)", "");
            */

        } catch (Exception e) {
            e.printStackTrace();
            log.error("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }
}
