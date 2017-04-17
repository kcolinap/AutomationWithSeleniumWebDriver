package AcseleV13_8Asesuisa.main.controller;

import AcseleV13_8Asesuisa.beans.Asesuisa_CajaModalidadesBean;
import AcseleV13_8Asesuisa.main.controller.Asesuisa_Menu.Asesuisa_MenuMantenimiento;
import metodo.Metodos;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by aandrade on 12/04/2017.
 */
public class Asesuisa_CajaModalidades {

    private final static Logger log = Logger.getLogger(Asesuisa_CajaModalidades.class);

    public String nombreAutomatizacion = "Asesuisa Caja Modalidades";
    private WebDriver driver;

    public void testLink(Asesuisa_CajaModalidadesBean bean, int i, String folderName){

        try {

            // Instanciando clases
            Metodos a = new Metodos();
            Asesuisa_MenuMantenimiento menuMantenimiento = new Asesuisa_MenuMantenimiento();

            driver = a.entrarPagina(a.UrlAsesuisa());
            a.IniciarSesion(driver, nombreAutomatizacion, i, folderName);
            a.ValidandoSesion(driver, nombreAutomatizacion, i, folderName);
            Thread.sleep(5000);

            //Entrando en Menu
            menuMantenimiento.UAA_Fac_ModalidadFacturas(driver, nombreAutomatizacion, 2, i, folderName);

            Thread.sleep(2000);
            a.cambiarVentana(driver);
            Thread.sleep(2000);

            /** Modalidad Caja*/

            ModalidadesCaja(bean, a, i, folderName, 3, 4, 5, 6, 7);
            Thread.sleep(3000);
            driver.quit();
        }
        catch (Exception e) {
            e.printStackTrace();
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
            if (driver != null){
                driver.quit();
            }
        }
    }

    public void ModalidadesCaja(Asesuisa_CajaModalidadesBean bean, Metodos a, int i, String folderName, int numScreenShoot, int numScreenShoot2, int numScreenShoot3, int numScreenShoot4, int numScreenShoot5){

        int tamanotr;
        WebElement indextr;

        try {

            // Si se selecciona Modalidad
            if (bean.getModalidad() != null) {
                // Modalidad de Factura
                driver.findElement(By.xpath("//*[@id=\"gwt-uid-6\"]")).click();
                Thread.sleep(1000);
                tamanotr = driver.findElements(By.xpath("//*[@id=\"VAADIN_COMBOBOX_OPTIONLIST\"]/div/div[2]/table/tbody/tr")).size();

                for (int j = 0; j < tamanotr; j++) {
                    indextr = driver.findElements(By.xpath("//*[@id=\'VAADIN_COMBOBOX_OPTIONLIST\']/div/div[2]/table/tbody/tr")).get(j);
                    if (bean.getModalidad().equals(indextr.getText())) {
                        indextr.click();
                        break;
                    }
                }
            }

            // Si se selecciona la Plantilla
            if (bean.getPlantilla() != null) {
                // Plantilla
                driver.findElement(By.xpath("//*[@id=\"gwt-uid-8\"]")).click();
                Thread.sleep(1000);
                tamanotr = driver.findElements(By.xpath("//*[@id=\"VAADIN_COMBOBOX_OPTIONLIST\"]/div/div[2]/table/tbody/tr")).size();

                for (int j = 0; j < tamanotr; j++) {
                    indextr = driver.findElements(By.xpath("//*[@id=\'VAADIN_COMBOBOX_OPTIONLIST\']/div/div[2]/table/tbody/tr")).get(j);
                    if (bean.getPlantilla().equals(indextr.getText())) {
                        indextr.click();
                        break;
                    }
                }
            }

            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion, folderName);
            // Clic boton Guardar
            Thread.sleep(1000);
            driver.findElement(By.xpath("//*[@id=\"WControllervaadinservlet-1750660287\"]/div/div[2]/div[2]/div/div[2]/div/div[3]/div/div[1]/div/span")).click();
            // Captura pantalla del resultado
            Thread.sleep(2000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot2, nombreAutomatizacion, folderName);

        } catch (Exception e) {
            e.printStackTrace();
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }
}
