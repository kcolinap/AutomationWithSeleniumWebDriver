package AcseleV13_8.main.controller;

import AcseleV13_8.beans.ImportExportTablasDinamicasBean;
import AcseleV13_8.main.controller.Menu.MenuMantenimiento;
import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by agil on 13/08/2016.
 */
public class ImportExportTablasDinamicas {

    private final static Logger log = Logger.getLogger(ImportExportTablasDinamicas.class);

    public String nombreAutomatizacion = "Import Export Tablas Dinamicas";

    public void testLink(ImportExportTablasDinamicasBean importExportTablasDinamicasBean, int i) throws IOException, InterruptedException {

        try {
            //implementando clases
            Metodos13_8 a = new Metodos13_8();
            MenuMantenimiento m = new MenuMantenimiento();

            WebDriver driver = a.entrarPagina();
            a.IniciarSesion(driver, nombreAutomatizacion, i);
            Thread.sleep(2000);
            a.ValidandoSesion(driver, nombreAutomatizacion, i);
            Thread.sleep(5000);

            // Creación de Póliza
            m.MantGeral_TablasDinamicas(driver, nombreAutomatizacion, 2, i);

            Thread.sleep(2000);
            a.cambiarVentana(driver);
            Thread.sleep(2000);

            TablaDinamica(a, driver, importExportTablasDinamicasBean);

        } catch (Exception e) {
            e.printStackTrace();
            //             log.info(e);
            log.info("Test Case 25 - " + nombreAutomatizacion + " - " + e);
        }
    }

    public void TablaDinamica(Metodos13_8 a, WebDriver driver, ImportExportTablasDinamicasBean importExportTablasDinamicasBean){

        try {

            Thread.sleep(2000);

            BuscarTabla(a, driver, importExportTablasDinamicasBean);

            Thread.sleep(3000);

            ExportarTablaDinamica(a, driver, importExportTablasDinamicasBean);

            ImportTablaDinamica(a, driver, importExportTablasDinamicasBean);


        } catch (Exception e) {
            e.printStackTrace();
            //             log.info(e);
            log.info("Test Case 25 - " + nombreAutomatizacion + " - " + e);
        }
    }

    public void BuscarTabla(Metodos13_8 a, WebDriver driver, ImportExportTablasDinamicasBean importExportTablasDinamicasBean){

        try {

            Thread.sleep(2000);

            WebElement nombreTabDina = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/form/table/tbody/tr[3]/td[2]/input"));
            nombreTabDina.sendKeys(importExportTablasDinamicasBean.getNombreTablaDinamica());

            Thread.sleep(1000);
            a.ScreenShot(driver, "screen4", nombreAutomatizacion); //screenshot2
            Toolkit.getDefaultToolkit().beep();
            Thread.sleep(1000);

            WebElement btnAceptar = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/form/table/tbody/tr[5]/td/input[2]"));
            btnAceptar.click();


        } catch (Exception e) {
            e.printStackTrace();
            //             log.info(e);
            log.info("Test Case 25 - " + nombreAutomatizacion + " - " + e);
        }

    }


    public void ExportarTablaDinamica(Metodos13_8 a, WebDriver driver, ImportExportTablasDinamicasBean importExportTablasDinamicasBean){

        try {

            Thread.sleep(1000);
            a.ScreenShot(driver, "screen5,1", nombreAutomatizacion); //screenshot2
            Toolkit.getDefaultToolkit().beep();
            Thread.sleep(1000);

            Thread.sleep(2000);

            WebElement btnExportar = driver.findElement(By.xpath("//*[@id=\"idb_0402008_TableTemplateViewer_06\"]"));
            btnExportar.click();

//            a.ScreenShot(driver, "screen5", nombreAutomatizacion); //screenshot2
//            Toolkit.getDefaultToolkit().beep();

            Thread.sleep(1000);
            a.ScreenShot(driver, "screen6", nombreAutomatizacion); //screenshot2
            Toolkit.getDefaultToolkit().beep();
            Thread.sleep(1000);

            // Cambiar ventana

            // Cambiar de ventana
            // getWindowHandles() method returns the ids of all active Windows and its return type will be a Collection Set.
            Set<String> sid = driver.getWindowHandles();
            // Using iterator we can fetch the values from Set.
            Iterator<String> it = sid.iterator();
            String parentId = it.next();
            System.out.println(parentId);
            String childId = it.next();
            System.out.println(childId);
            String childId2 = it.next();
            System.out.println(childId2);
            // swtiching control to child Window
            driver.switchTo().window(childId2);

            Select selectFormato = new Select(driver.findElement(By.xpath("//*[@id=\"formats\"]")));
            selectFormato.selectByValue(importExportTablasDinamicasBean.getFormato());

            Thread.sleep(1000);
            a.ScreenShot(driver, "screen6", nombreAutomatizacion); //screenshot2
            Toolkit.getDefaultToolkit().beep();

            Thread.sleep(2000);
            WebElement btnExportTabla = driver.findElement(By.xpath("//*[@id=\"expor01\"]"));
            btnExportTabla.click();

            driver.switchTo().window(childId);

            // Cambiar de ventana
            // getWindowHandles() method returns the ids of all active Windows and its return type will be a Collection Set.
            sid = driver.getWindowHandles();
            // Using iterator we can fetch the values from Set.
            it = sid.iterator();
            parentId = it.next();
            System.out.println(parentId);
            childId = it.next();
            System.out.println(childId);
            childId2 = it.next();
            System.out.println(childId2);
            // swtiching control to child Window
            driver.switchTo().window(childId2);

            Thread.sleep(1000);
            a.ScreenShot(driver, "screen7", nombreAutomatizacion); //screenshot2
            Toolkit.getDefaultToolkit().beep();

            WebElement btnCerrar = driver.findElement(By.xpath("//*[@id=\"idb_0402023_DynamicTablesImportExportResultMessage_01\"]"));
            btnCerrar.click();

            driver.switchTo().window(childId);


            System.out.println("Fin de funcion ExportarTablaDinamica");

        } catch (Exception e) {
            e.printStackTrace();
            //             log.info(e);
            log.info("Test Case 25 - " + nombreAutomatizacion + " - " + e);
        }

    }

    public  void ImportTablaDinamica(Metodos13_8 a, WebDriver driver, ImportExportTablasDinamicasBean importExportTablasDinamicasBean){

        try {

            System.out.println("Inicio de la funcion ImportTablaDinamica");
            Thread.sleep(2000);
            WebElement btnImport = driver.findElement(By.xpath("//*[@id=\"idb_0402008_TableTemplateViewer_07\"]"));
            btnImport.click();

            Thread.sleep(4000);

            // Cambiar de ventana
            // getWindowHandles() method returns the ids of all active Windows and its return type will be a Collection Set.
            Set<String> sid = driver.getWindowHandles();
            // Using iterator we can fetch the values from Set.
            Iterator<String> it = sid.iterator();
            String parentId = it.next();
            System.out.println(parentId);
            String childId = it.next();
            System.out.println(childId);
            String childId2 = it.next();
            System.out.println(childId2);
            // swtiching control to child Window
            driver.switchTo().window(childId2);

            WebElement btnSelect = driver.findElement(By.xpath("/html/body/center/form/table/tbody/tr[2]/td/input[1]"));
            //btnSelect.sendKeys(importExportTablasDinamicasBean.getRutaTablaDinamica());
            btnSelect.sendKeys("C://AcseleTests//Export//Prueba2.xml");

            Thread.sleep(1000);
            a.ScreenShot(driver, "screen8", nombreAutomatizacion); //screenshot2
            Toolkit.getDefaultToolkit().beep();

            WebElement btnAcept = driver.findElement(By.xpath("//*[@id=\"idb_0402023_selectXMLFile_01\"]"));
            btnAcept.click();

            Thread.sleep(3000);
            // Mensajes de Alerta
            if (ExpectedConditions.alertIsPresent() != null) {
                Thread.sleep(1000);
                Alert alert = driver.switchTo().alert();
                alert.accept();
                Thread.sleep(1000);
                driver.switchTo().defaultContent();
            }


            Thread.sleep(1000);
            a.ScreenShot(driver, "screen9", nombreAutomatizacion); //screenshot2
            Toolkit.getDefaultToolkit().beep();

            WebElement btnClose = driver.findElement(By.xpath("//*[@id=\"idb_0402023_DynamicTablesImportExportResultMessage_01\"]"));
            btnClose.click();

            Thread.sleep(2000);
            driver.switchTo().window(childId);

            Thread.sleep(1000);
            a.ScreenShot(driver, "screen10", nombreAutomatizacion); //screenshot2
            Toolkit.getDefaultToolkit().beep();




        }catch (Exception e) {
            e.printStackTrace();
            //             log.info(e);
            log.info("Test Case 25 - " + nombreAutomatizacion + " - " + e);
        }

    }
}
