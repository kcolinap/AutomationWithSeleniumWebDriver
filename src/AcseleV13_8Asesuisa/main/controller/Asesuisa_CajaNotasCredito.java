package AcseleV13_8Asesuisa.main.controller;

import AcseleV13_8Asesuisa.beans.Asesuisa_CajaNotasCreditoBean;
import AcseleV13_8Asesuisa.main.controller.Asesuisa_Menu.Asesuisa_MenuOperaciones;
import metodo.Metodos;
import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by aandrade on 17/04/2017.
 */
public class Asesuisa_CajaNotasCredito {

    private final static Logger log = Logger.getLogger(Asesuisa_CajaAperturar.class);

    public String nombreAutomatizacion = "Asesuisa Caja Notas de Credito";
    private WebDriver driver;

    public void testLink(Asesuisa_CajaNotasCreditoBean bean, int i, String folderName){

        try {

            // Instanciando clases
            Metodos a = new Metodos();
            Asesuisa_MenuOperaciones menuOperaciones = new Asesuisa_MenuOperaciones();

            driver = a.entrarPagina(a.UrlAsesuisa());
            a.IniciarSesion(driver, nombreAutomatizacion, i, folderName);
            a.ValidandoSesion(driver, nombreAutomatizacion, i, folderName);
            Thread.sleep(5000);

            //Entrando primero en el Menu de Inicio de Sesion
            menuOperaciones.UAA_Caja_InicioSesion(driver, nombreAutomatizacion, 2, i, folderName);
            Thread.sleep(2000);
            a.cambiarVentana(driver);
            Thread.sleep(2000);
            driver.close();
            a.regresarVentana(driver);
            //Entrando en Menu de Facturas Generadas
            menuOperaciones.UAA_Caja_ConsultaFacturasGeneradas(driver, nombreAutomatizacion, 2, i, folderName);

            Thread.sleep(2000);
            a.cambiarVentana(driver);
            Thread.sleep(2000);

            /** Notas Credito Caja*/

            NotasCreditoCaja(bean, a, i, folderName, 3, 4, 5, 6, 7);
            Thread.sleep(5000);

            //driver.quit();

        } catch (Exception e) {
            e.printStackTrace();
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
            if (driver != null){
                //driver.quit();
            }
        }
    }

    public void NotasCreditoCaja(Asesuisa_CajaNotasCreditoBean bean, Metodos a, int i, String folderName, int numScreenShoot, int numScreenShoot2, int numScreenShoot3, int numScreenShoot4, int numScreenShoot5){

        int tamanotr;
        WebElement indextr;

        try {
            Thread.sleep(1000);
            // Seleccionar el boton Buscar
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion, folderName);
            Thread.sleep(1000);
            driver.findElement(By.xpath("//*[@id=\"WControllervaadinservlet-1750660287\"]/div/div[2]/div[2]/div/div[2]/div/div[5]/div/div[1]/div/span")).click();
            Thread.sleep(2000);

            // Busca las facturas que esten en estado Valida
            tamanotr = driver.findElements(By.xpath("//*[@id=\"WControllervaadinservlet-1750660287\"]/div/div[2]/div[2]/div/div[2]/div/div[7]/div/div[1]/div/div[3]/div[1]/table/tbody/tr")).size();
            for (int j = 1; j < (tamanotr+1); j++) {
                indextr = driver.findElement(By.xpath("//*[@id=\"WControllervaadinservlet-1750660287\"]/div/div[2]/div[2]/div/div[2]/div/div[7]/div/div[1]/div/div[3]/div[1]/table/tbody/tr[" + j + "]/td[8]/div"));
                String texto = indextr.getText();
                if (texto.equals("Valida")) {
                    // Selecciona la linea de la tabla a Anular
                    indextr.click();
                    a.ScreenShotPool(driver, i, "screen" + numScreenShoot2, nombreAutomatizacion, folderName);
                    Thread.sleep(2000);
                    // Selecciona el boton Anular
                    driver.findElement(By.xpath("//*[@id=\"WControllervaadinservlet-1750660287\"]/div/div[2]/div[2]/div/div[2]/div/div[9]/div/div[5]/div/span")).click();
                    Thread.sleep(2000);

                    // Click a la lista Razon de Anulacion
                    driver.findElement(By.xpath("//*[@id=\"WControllervaadinservlet-1750660287-window-overlays\"]/div[5]/div/div/div[5]/div/div/div[1]/div/div[3]/div/div")).click();

                    // Selecciona la razon de anulacion
                    Thread.sleep(1000);
                    tamanotr = driver.findElements(By.xpath("//*[@id=\"VAADIN_COMBOBOX_OPTIONLIST\"]/div/div[2]/table/tbody/tr")).size();
                    for (int k = 1; k < tamanotr; k++) {
                        indextr = driver.findElement(By.xpath("//*[@id=\"VAADIN_COMBOBOX_OPTIONLIST\"]/div/div[2]/table/tbody/tr["+k+"]/td/span"));
                        texto = indextr.getText();

                        if (bean.getRazon().equals(texto)) {
                            indextr.click();
                            Thread.sleep(2000);
                            break;
                        }
                    }
                    // Selecciona Generar Nota de Credito Si
                    Thread.sleep(1000);
                    if(bean.getGenerar().equals("Si")) {
                        driver.findElement(By.xpath("//*[@id=\"gwt-uid-48\"]")).click();
                    }
                    else if(bean.getGenerar().equals("No")) {
                        driver.findElement(By.xpath("//*[@id=\"gwt-uid-49\"]")).click();
                    }
                    a.ScreenShotPool(driver, i, "screen" + numScreenShoot3, nombreAutomatizacion, folderName);
                    Thread.sleep(1000);
/*
                    // Selecciona Boton Aceptar
                    if (bean.getGenerar() != null) {
                        driver.findElement(By.xpath("//*[@id=\"WControllervaadinservlet-1750660287-window-overlays\"]/div[5]/div/div/div[5]/div/div/div[5]/div/div[1]/div/span")).click();

                        // Selecciona segundo Boton Aceptar
                        Thread.sleep(1000);
                        a.ScreenShotPool(driver, i, "screen" + numScreenShoot4, nombreAutomatizacion, folderName);
                        Thread.sleep(1000);
                        driver.findElement(By.xpath("//*[@id=\"WControllervaadinservlet-1750660287-window-overlays\"]/div[5]/div/div/div[5]/div/div/div/div[3]/div/div[1]/button")).click();
                        // fin


                    }
                    // Selecciona Boton Cancelar
                    else {
                        driver.findElement(By.xpath("//*[@id=\"WControllervaadinservlet-1750660287-window-overlays\"]/div[5]/div/div/div[5]/div/div/div[5]/div/div[3]/div/span")).click();
                    }
*/
                    // Selecciona segundo Boton Aceptar
                    Thread.sleep(1000);
                    a.ScreenShotPool(driver, i, "screen" + numScreenShoot4, nombreAutomatizacion, folderName);
                    Thread.sleep(1000);
                    driver.findElement(By.xpath("//*[@id=\"WControllervaadinservlet-1750660287-window-overlays\"]/div[5]/div/div/div[5]/div/div/div/div[3]/div/div[1]/button")).click();

                    // Muestra el resultado de la operacion
                    Thread.sleep(2000);
                    a.ScreenShotPool(driver, i, "screen" + numScreenShoot5, nombreAutomatizacion, folderName);
                    Thread.sleep(2000);
                    //driver.findElement(By.xpath("//*[@id=\"WControllervaadinservlet-1750660287-window-overlays\"]/div[5]/div/div/div[5]/div/div/div[2]/div/div/div")).click();
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }

    }
}
