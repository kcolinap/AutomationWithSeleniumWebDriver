package AcseleV13_8Asesuisa.main.controller;

import AcseleV13_8Asesuisa.beans.Asesuisa_ExportarTrazaAuditoriaBean;
import AcseleV13_8Asesuisa.main.controller.Asesuisa_Menu.Asesuisa_MenuMantenimiento;
import metodo.Metodos;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

/**
 * Created by cortiz on 29/03/2017.
 */
public class Asesuisa_ExportarTrazaAuditoria {

    private final static Logger log = Logger.getLogger(Asesuisa_ExportarTrazaAuditoria.class);

    public String nombreAutomatizacion = "Exportar Traza de Auditoria";

    private WebDriver driver;

    public void testLink (Asesuisa_ExportarTrazaAuditoriaBean exportarTrazaAuditoriaBean, int i, String folderName)  throws IOException, InterruptedException {

        try {

            // Instanciando clases
            Metodos a = new Metodos();
            Asesuisa_MenuMantenimiento menuMantenimiento = new Asesuisa_MenuMantenimiento();

            driver = a.entrarPagina(a.UrlAsesuisa());
            a.IniciarSesion(driver, nombreAutomatizacion, i, folderName);
            a.ValidandoSesion(driver, nombreAutomatizacion, i, folderName);
            Thread.sleep(3000);

            //Entrando en Menu
            menuMantenimiento.Aud_TrazasAuditoriaVaadin(driver, nombreAutomatizacion, 2, i, folderName);

            Thread.sleep(2000);
            a.cambiarVentana(driver);
            Thread.sleep(2000);

            /** Consultar Traza */
            ExportarTrazaAuditoria(exportarTrazaAuditoriaBean, a, i, folderName, 3,4,5,6,7,8,9,10);

            Thread.sleep(3000);


            driver.quit();


        } catch (Exception e) {
            e.printStackTrace();
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
            if (driver != null){
                driver.quit();
            }
        }
    }

    public void  ExportarTrazaAuditoria(Asesuisa_ExportarTrazaAuditoriaBean  bean, Metodos a, int i, String folderName, int screen, int screen2, int screen3, int screen4, int screen5, int screen6, int screen7, int screen8) {

        try {

            Thread.sleep(3000);


            if (bean.getFechaDesde() != null) {
                WebElement desde = driver.findElement(By.xpath("//*[@id=\"startEventDate\"]/input"));
                desde.click();
                desde.getText();
                desde.sendKeys(bean.getFechaDesde());
                Thread.sleep(500);
            }

            if (bean.getFechaHasta() != null) {
                WebElement hasta = driver.findElement(By.xpath("//*[@id=\"endEventDate\"]/input"));
                hasta.click();
                hasta.sendKeys(bean.getFechaHasta());
                Thread.sleep(500);
            }


            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + screen, nombreAutomatizacion, folderName);
            Thread.sleep(1000);
            WebElement btnBuscar = driver.findElement(By.xpath("//*[@id=\"horizontalButton\"]/div/div/div/span/span"));
            btnBuscar.click();
            Thread.sleep(2000);
            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + screen2, nombreAutomatizacion, folderName);
            Thread.sleep(1000);



            WebElement exportar = driver.findElement(By.xpath("//*[@id=\"horizontalButtonExport\"]/div/div/div"));
            exportar.click();


                Thread.sleep(1000);
                a.ScreenShotPool(driver, i, "screen" + screen3, nombreAutomatizacion, folderName);
                Thread.sleep(3000);


          WebElement tipodoc = driver.findElement(By.xpath("/html/body/div[5]/div[5]/div/div/div[5]/div/div/table/tbody/tr/td[3]/div/div[1]/div/div[3]/div/div"));
           tipodoc.click();
             WebElement seleccionarTipo = null;
            for  (int k= 1; k<3; k++) {
                Thread.sleep(1000);
              seleccionarTipo = driver.findElement(By.xpath("//*[@id=\"VAADIN_COMBOBOX_OPTIONLIST\"]/div/div[2]/table/tbody/tr["+ k +"]/td"));
                System.out.println("Elemento recorrido: " + seleccionarTipo.getText());
                if (seleccionarTipo.getText().toLowerCase().equals(bean.getTipoDoc().toLowerCase())) {
                    Thread.sleep(1000);
                    seleccionarTipo.click();
                    Thread.sleep(2000);
                    a.ScreenShotPool(driver, i, "screen" + screen4, nombreAutomatizacion, folderName);
                    Thread.sleep(3000);
                    break;
                }
            }



            WebElement btnExportar = driver.findElement(By.xpath("/*//*[@id=\"formExportAuditTrail\"]/table/tbody/tr/td[3]/div/div[3]/div/span"));

            btnExportar.click();

            Thread.sleep(5000);
            a.ScreenShotPool(driver, i, "screen" + screen5, nombreAutomatizacion, folderName);
            Thread.sleep(1000);
            Thread.sleep(85000);

           /* WebDriverWait wait = new WebDriverWait(driver, 100);
                    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("WControllervaadinservlet-1750660287-window-overlays")));*/
            if ((bean.getFechaDesde().equals("07-03-2017"))) {

                Thread.sleep(1000);
                WebElement descargar = driver.findElement(By.xpath("//*[@id=\"WControllervaadinservlet-1750660287-window-overlays\"]/div[4]/div/div/div[5]/div/div/div[2]/div/div/div"));
                descargar.click();

                Thread.sleep(5000);
                a.ScreenShotPool(driver, i, "screen" + screen7, nombreAutomatizacion, folderName);
                Thread.sleep(4000);
                //ventana final de descarga
               /* WebElement btncerrar = driver.findElement(By.xpath("*//*//**//*[@id=\"243_window_close\"]"));
                btncerrar.click();*/

                Thread.sleep(1000);
                a.ScreenShotPool(driver, i, "screen" + screen8, nombreAutomatizacion, folderName);
                Thread.sleep(1000);
            }
           if ((bean.getFechaDesde().equals("09-03-2017"))){

               Boolean mensageID = driver.findElements(By.xpath("//*[@id=\"WControllervaadinservlet-1750660287-window-overlays\"]/div[4]")).size() > 0;

               if (mensageID){
                   System.out.println("ruta correcta");
               }else{

    WebElement msgerror = driver.findElement(By.xpath("//*[@id=\"WControllervaadinservlet-1750660287-window-overlays\"]/div[5]/div/div/div[5]/div/div/div/div"));


    if (msgerror.getText().equals("An error has occurred in Export")) {


        Thread.sleep(3000);
        a.ScreenShotPool(driver, i, "screen" + screen6, nombreAutomatizacion, folderName);
        Thread.sleep(10000);
        /*WebElement btnclose = driver.findElement(By.xpath("/*//*[@id=\"111_window_close\"]"));
        btnclose.click();*/


    }
    }


}














        } catch (Exception e) {
            e.printStackTrace();
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }





    }
}
