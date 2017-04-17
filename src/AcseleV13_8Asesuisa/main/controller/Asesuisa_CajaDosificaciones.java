package AcseleV13_8Asesuisa.main.controller;

import AcseleV13_8Asesuisa.beans.Asesuisa_CajaDosificacionesBean;
import AcseleV13_8Asesuisa.main.controller.Asesuisa_Menu.Asesuisa_MenuMantenimiento;
import metodo.Metodos;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by aandrade on 06/04/2017.
 */
public class Asesuisa_CajaDosificaciones {
    private final static Logger log = Logger.getLogger(Asesuisa_CajaDosificaciones.class);

    public String nombreAutomatizacion = "Asesuisa Caja Dosificaciones";
    private WebDriver driver;

    public void testLink(Asesuisa_CajaDosificacionesBean bean, int i, String folderName){

        try {

            // Instanciando clases
            Metodos a = new Metodos();
            Asesuisa_MenuMantenimiento menuMantenimiento = new Asesuisa_MenuMantenimiento();

            driver = a.entrarPagina(a.UrlAsesuisa());
            a.IniciarSesion(driver, nombreAutomatizacion, i, folderName);
            a.ValidandoSesion(driver, nombreAutomatizacion, i, folderName);
            Thread.sleep(5000);

            //Entrando en Menu
            menuMantenimiento.UAA_Fac_DosificacionFacturas(driver, nombreAutomatizacion, 2, i, folderName);

            Thread.sleep(2000);
            a.cambiarVentana(driver);
            Thread.sleep(2000);

            /** Dosificaciones Caja*/

            DosificacionesCaja(bean, a, i, folderName, 3, 4, 5, 6, 7);
            Thread.sleep(3000);

           // driver.quit();

        } catch (Exception e) {
            e.printStackTrace();
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
            if (driver != null){
                //driver.quit();
            }
        }
    }

    public void DosificacionesCaja(Asesuisa_CajaDosificacionesBean bean, Metodos a, int i, String folderName, int numScreenShoot, int numScreenShoot2, int numScreenShoot3, int numScreenShoot4, int numScreenShoot5){

        int tamanotr;
        WebElement indextr;

        try {

            // Si no se selecciona Creacion Generica
           if(bean.getGenerica() == null) {
               // Modalidad de Factura
               if (bean.getModfactura() != null) {
                   driver.findElement(By.xpath("//*[@id='gwt-uid-8']")).click();
                   Thread.sleep(1000);
                   tamanotr = driver.findElements(By.xpath("//*[@id=\'VAADIN_COMBOBOX_OPTIONLIST\']/div/div[2]/table/tbody/tr")).size();
                   for (int j = 0; j < tamanotr; j++) {
                       indextr = driver.findElements(By.xpath("//*[@id=\'VAADIN_COMBOBOX_OPTIONLIST\']/div/div[2]/table/tbody/tr")).get(j);
                       if (bean.getModfactura().equals(indextr.getText())) {
                           indextr.click();
                           break;
                       }
                   }
               }
               // Compañia de Tiraje
               if (bean.getComtiraje() != null) {
                   driver.findElement(By.xpath("//*[@id=\'gwt-uid-10\']")).click();
                   Thread.sleep(1000);
                   tamanotr = driver.findElements(By.xpath("//*[@id=\'VAADIN_COMBOBOX_OPTIONLIST\']/div/div[2]/table/tbody/tr")).size();
                   for (int j = 0; j < tamanotr; j++) {
                       indextr = driver.findElements(By.xpath("//*[@id=\'VAADIN_COMBOBOX_OPTIONLIST\']/div/div[2]/table/tbody/tr")).get(j);
                       if (bean.getComtiraje().equals(indextr.getText())) {
                           indextr.click();
                           break;
                       }
                   }
               }
               // Año del Tiraje
               if (bean.getAnotiraje() != null) {
                   WebElement anotiraje = driver.findElement(By.xpath("//*[@id='gwt-uid-12']"));
                   anotiraje.sendKeys(bean.getAnotiraje());
               }
               // Certificado de Hacienda
               if (bean.getCertiraje() != null) {
                   WebElement certiraje = driver.findElement(By.xpath("//*[@id=\'CertificadoHacienda\']"));
                   certiraje.sendKeys(bean.getCertiraje());
               }

               Thread.sleep(1000);
               a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion, folderName);
               Thread.sleep(1000);

               driver.findElement(By.xpath("//*[@id=\"WControllervaadinservlet-1750660287\"]/div/div[2]/div[2]/div/div[2]/div/div[5]/div/div/div/span")).click();

               Thread.sleep(1000);
               a.ScreenShotPool(driver, i, "screen" + numScreenShoot2, nombreAutomatizacion, folderName);
               Thread.sleep(1000);

           }
            // Si se selecciona Creacion Generica
            else  {
               driver.findElement(By.xpath("//*[@id=\"gwt-uid-2\"]")).click();
               Thread.sleep(2000);
               // Si se ingresa rango de factura desde
               if (bean.getRangodesd() != null) {
                   WebElement rangodesd = driver.findElement(By.xpath("//*[@id=\'gwt-uid-16\']"));
                   rangodesd.sendKeys(bean.getRangodesd());
               }
               else {
                   WebElement rangodesd = driver.findElement(By.xpath("//*[@id=\'gwt-uid-16\']"));
                   rangodesd.clear();
               }
               // Si se ingresa rango de factura hasta
               if (bean.getRangohast() != null) {
                   WebElement rangohast = driver.findElement(By.xpath("//*[@id=\'gwt-uid-18\']"));
                   rangohast.sendKeys(bean.getRangohast());
               }
               else {
                   WebElement rangohast = driver.findElement(By.xpath("//*[@id=\'gwt-uid-18\']"));
                   rangohast.clear();
               }
               // Compañia de Tiraje
               if (bean.getComtiraje() != null) {
                   driver.findElement(By.xpath("//*[@id=\'gwt-uid-10\']")).click();
                   Thread.sleep(1000);
                   tamanotr = driver.findElements(By.xpath("//*[@id=\'VAADIN_COMBOBOX_OPTIONLIST\']/div/div[2]/table/tbody/tr")).size();
                   for (int j = 0; j < tamanotr; j++) {
                       indextr = driver.findElements(By.xpath("//*[@id=\'VAADIN_COMBOBOX_OPTIONLIST\']/div/div[2]/table/tbody/tr")).get(j);
                       if (bean.getComtiraje().equals(indextr.getText())) {
                           indextr.click();
                           break;
                       }
                   }
               }
               // Año del Tiraje
               if (bean.getAnotiraje() != null) {
                   WebElement anotiraje = driver.findElement(By.xpath("//*[@id='gwt-uid-12']"));
                   anotiraje.sendKeys(bean.getAnotiraje());
               }
               // Certificado de Hacienda
               if (bean.getCertiraje() != null) {
                   WebElement certiraje = driver.findElement(By.xpath("//*[@id=\'CertificadoHacienda\']"));
                   certiraje.sendKeys(bean.getCertiraje());
               }

               Thread.sleep(1000);
               a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion, folderName);
               Thread.sleep(1000);

               driver.findElement(By.xpath("//*[@id=\"WControllervaadinservlet-1750660287\"]/div/div[2]/div[2]/div/div[2]/div/div[5]/div/div/div/span")).click();

               Thread.sleep(1000);
               a.ScreenShotPool(driver, i, "screen" + numScreenShoot2, nombreAutomatizacion, folderName);
               Thread.sleep(1000);

           }

        } catch (Exception e) {
            e.printStackTrace();
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }

    }
}
