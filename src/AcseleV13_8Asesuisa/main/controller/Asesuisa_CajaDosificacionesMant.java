package AcseleV13_8Asesuisa.main.controller;

import AcseleV13_8Asesuisa.beans.Asesuisa_CajaDosificacionesMantBean;
import AcseleV13_8Asesuisa.main.controller.Asesuisa_Menu.Asesuisa_MenuMantenimiento;
import metodo.Metodos;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;

/**
 * Created by aandrade on 10/04/2017.
 */
public class Asesuisa_CajaDosificacionesMant {

    private final static Logger log = Logger.getLogger(Asesuisa_CajaDosificacionesMant.class);

    public String nombreAutomatizacion = "Asesuisa Caja Dosificaciones Mantenimiento";
    private WebDriver driver;

    public void testLink(Asesuisa_CajaDosificacionesMantBean bean, int i, String folderName){

        try {

            // Instanciando clases
            Metodos a = new Metodos();
            Asesuisa_MenuMantenimiento menuMantenimiento = new Asesuisa_MenuMantenimiento();

            driver = a.entrarPagina(a.UrlAsesuisa());
            a.IniciarSesion(driver, nombreAutomatizacion, i, folderName);
            a.ValidandoSesion(driver, nombreAutomatizacion, i, folderName);
            Thread.sleep(5000);

            //Entrando en Menu
            menuMantenimiento.UAA_Fac_DosificacionFacturasMant(driver, nombreAutomatizacion, 2, i, folderName);

            Thread.sleep(2000);
            a.cambiarVentana(driver);
            Thread.sleep(2000);

            /** Dosificaciones Caja*/

            DosificacionesCajaMant(bean, a, i, folderName, 3, 4, 5, 6, 7);
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

    public void DosificacionesCajaMant(Asesuisa_CajaDosificacionesMantBean bean, Metodos a, int i, String folderName, int numScreenShoot, int numScreenShoot2, int numScreenShoot3, int numScreenShoot4, int numScreenShoot5){

        int tamanotr;
        WebElement indextr;

        try {

            // Busqueda de las Dosificaciones No Genericas
            if(bean.getGenerica() == null) {
                // Seleccion de la modalidad de Factura
                if (bean.getModfactura() != null) {
                    driver.findElement(By.xpath("//*[@id=\"gwt-uid-14\"]")).click();
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
                // Seleccion de la Compañia de Tiraje
                if (bean.getComtiraje() != null) {
                    driver.findElement(By.xpath("//*[@id=\"gwt-uid-20\"]")).click();
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

                Thread.sleep(1000);
                a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion, folderName);
                Thread.sleep(1000);

                // Clic al boton Buscar
                driver.findElement(By.xpath("//*[@id=\"WControllervaadinservlet-1750660287\"]/div/div[2]/div[2]/div/div[2]/div/div[5]/div/div/div/span")).click();
                Thread.sleep(1000);
            }

            // Selecciona la fila que se va a procesar
            driver.findElement(By.xpath("//*[@id=\"WControllervaadinservlet-1750660287\"]/div/div[2]/div[2]/div/div[2]/div/div[7]/div/div/div/div[3]/div[1]/table/tbody/tr/td[3]/div")).click();

            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot2, nombreAutomatizacion, folderName);
            Thread.sleep(1000);


            // Si la operacion es Consultar
            if (bean.getOperacion().equals("CONSULTAR")) {
                // Selecciona el boton Consultar
                driver.findElement(By.xpath("//*[@id=\"WControllervaadinservlet-1750660287\"]/div/div[2]/div[2]/div/div[2]/div/div[9]/div/div[1]/div/span/span")).click();
            }
            // Si la operacion es Editar
            else if (bean.getOperacion().equals("EDITAR")) {
                // Selecciona el boton Consultar
                driver.findElement(By.xpath("//*[@id=\"WControllervaadinservlet-1750660287\"]/div/div[2]/div[2]/div/div[2]/div/div[9]/div/div[3]/div/span")).click();
            }
            // Si la operacion es Asociacion Caja
            else if (bean.getOperacion().equals("ASOCIACION CAJAS")) {
                // Selecciona el boton Consultar
                driver.findElement(By.xpath("//*[@id=\"WControllervaadinservlet-1750660287\"]/div/div[2]/div[2]/div/div[2]/div/div[9]/div/div[5]/div/span")).click();
                Thread.sleep(1000);
                // Selecciona la primera caja disponible de la lista
                driver.findElement(By.xpath("//*[@id=\"WControllervaadinservlet-1750660287-window-overlays\"]/div[5]/div/div/div[5]/div/div/div[2]/div/div[3]/div/select[1]/option[1]")).click();
                Thread.sleep(1000);
                a.ScreenShotPool(driver, i, "screen" + numScreenShoot3, nombreAutomatizacion, folderName);
                Thread.sleep(1000);
                // Selecciona la flecha izquierda
                driver.findElement(By.xpath("//*[@id=\"WControllervaadinservlet-1750660287-window-overlays\"]/div[5]/div/div/div[5]/div/div/div[2]/div/div[3]/div/div[2]/div[1]/span")).click();
                Thread.sleep(1000);
                a.ScreenShotPool(driver, i, "screen" + numScreenShoot4, nombreAutomatizacion, folderName);
                Thread.sleep(1000);
                // Selecciona Aceptar
                driver.findElement(By.xpath("//*[@id=\"WControllervaadinservlet-1750660287-window-overlays\"]/div[5]/div/div/div[5]/div/div/div[2]/div/div[5]/div/div[1]/div/span")).click();
            }
            // Si la operacion es Aprobar
            else if (bean.getOperacion().equals("APROBAR")) {
                // Selecciona el boton Consultar
                driver.findElement(By.xpath("//*[@id=\"WControllervaadinservlet-1750660287\"]/div/div[2]/div[2]/div/div[2]/div/div[9]/div/div[7]/div/span")).click();
            }
            // Si la operacion es Cancelar
            else if (bean.getOperacion().equals("CANCELAR")) {
                // Selecciona el boton Consultar
                driver.findElement(By.xpath("//*[@id=\"WControllervaadinservlet-1750660287\"]/div/div[2]/div[2]/div/div[2]/div/div[9]/div/div[9]/div/span")).click();
            }
            // Si la operacion es Auditoria
            else if (bean.getOperacion().equals("AUDITORIA")) {
                // Selecciona el boton Consultar
                driver.findElement(By.xpath("//*[@id=\"WControllervaadinservlet-1750660287\"]/div/div[2]/div[2]/div/div[2]/div/div[9]/div/div[11]/div/span")).click();
            }
            // Si la operacion es Ver Facturas
            else if (bean.getOperacion().equals("VER FACTURAS")) {
                // Selecciona el boton Consultar
                driver.findElement(By.xpath("//*[@id=\"WControllervaadinservlet-1750660287\"]/div/div[2]/div[2]/div/div[2]/div/div[9]/div/div[13]/div/span")).click();
            }

            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot5, nombreAutomatizacion, folderName);
            Thread.sleep(1000);

        } catch (Exception e) {

            try {
                a.ScreenShotPool(driver, i, "error DosificacionesCajaMant", nombreAutomatizacion, folderName);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            } catch (IOException e1) {
                e1.printStackTrace();
            }

            e.printStackTrace();
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }

    }
}
