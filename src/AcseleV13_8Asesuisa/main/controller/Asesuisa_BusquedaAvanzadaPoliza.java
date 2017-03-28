package AcseleV13_8Asesuisa.main.controller;

import AcseleV13_8Asesuisa.beans.Asesuisa_BusquedaAvanzadaPolizaBean;
import AcseleV13_8Asesuisa.main.controller.Asesuisa_Menu.Asesuisa_MenuOperaciones;
import metodo.Metodos;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by agil on 27/03/2017.
 */
public class Asesuisa_BusquedaAvanzadaPoliza {

    private final static Logger log = Logger.getLogger(Asesuisa_BusquedaAvanzadaPoliza.class);

    public String nombreAutomatizacion = "Asesuisa Busqueda Simple Poliza";
    private WebDriver driver;

    public void testLink(Asesuisa_BusquedaAvanzadaPolizaBean bean, int i, String folderName){

        try {

            // Instanciando clases
            Metodos a = new Metodos();
            Asesuisa_MenuOperaciones menuOperaciones = new Asesuisa_MenuOperaciones();

            driver = a.entrarPagina(a.UrlAsesuisa());
            a.IniciarSesion(driver, nombreAutomatizacion, i, folderName);
            a.ValidandoSesion(driver, nombreAutomatizacion, i, folderName);
            Thread.sleep(5000);

            //Entrando en Menu
            menuOperaciones.OpePol_CotizacionSuscripcionEdicion_MantenimientoEdicionFrontEnd(driver, nombreAutomatizacion, 2, i, folderName);

            Thread.sleep(2000);
            a.cambiarVentana(driver);
            Thread.sleep(2000);

            /** Buscar Poliza */

            FormularioBusqueda(bean,a, i, folderName, 3, 4, 5, 6, 7);
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

    public void FormularioBusqueda(Asesuisa_BusquedaAvanzadaPolizaBean bean, Metodos a, int i, String folderName, int numScreenShoot, int numScreenShoot2, int numScreenShoot3, int numScreenShoot4, int numScreenShoot5){

        try {

            //WebElement prueba = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_2_fila_field']"));

            if (bean.getNumeroPoliza() != null) {
                WebElement numPoliza = driver.findElement(By.xpath("//input[@wicketpath='ConsultPolicy_searchForm_policyNumber']"));
                numPoliza.sendKeys(bean.getNumeroPoliza());
            }

            if (bean.getCliente() != null){
                WebElement cliente = driver.findElement(By.xpath("//input[@wicketpath='ConsultPolicy_searchForm_idClient_search']"));
                cliente.sendKeys(bean.getCliente());
            }

            if (bean.getAsegurado() != null){
                WebElement asegurado = driver.findElement(By.xpath("//input[@wicketpath='ConsultPolicy_searchForm_idInsured_search']"));
                asegurado.sendKeys(bean.getAsegurado());
            }


            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion, folderName);
            Thread.sleep(1000);

            WebElement btnBuscar = driver.findElement(By.xpath("//input[@wicketpath='ConsultPolicy_searchForm_searchButton']"));
            btnBuscar.click();

            Thread.sleep(1000);
            a.waitSearchWicket(driver, "Buscando Poliza");

            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot2, nombreAutomatizacion, folderName);
            Thread.sleep(1000);

            Boolean mensageID = driver.findElements(By.id("_wicket_window_2")).size() > 0;

            // No consigue la poliza
            if (mensageID){
                //System.out.println("No se encontró resultados asociados con esta búsqueda");
                System.out.println(driver.findElement(By.xpath("//span[@wicketpath='ConsultPolicy_errorSimpleSearchModalDialog_content_text']")).getText());
                System.out.println();
            }
            else { //Si consigue la poliza
                System.out.println("Encontró la poliza");
                WebElement selPoliza = driver.findElement(By.xpath("//input[@wicketpath='ConsultPolicy_ResultSearchSimplePolicy_groupPolicies_resultSearchPolicyTable_1_policy']"));
                selPoliza.click();

                Thread.sleep(1000);
                a.ScreenShotPool(driver, i, "screen" + numScreenShoot3, nombreAutomatizacion, folderName);

                WebElement btnConsultar = driver.findElement(By.xpath("//input[@wicketpath='ConsultPolicy_ResultSearchSimplePolicy_buttonsForm_container_ConsultPolicyButton']"));
                btnConsultar.click();

                a.waitSearchWicket(driver, "Consultando Poliza");

                Thread.sleep(1000);
                Boolean mensageID2 = driver.findElements(By.id("_wicket_window_1")).size() > 0;
                // Tercero presenta cumulo
                if (mensageID2){
                    System.out.println("Mensaje de Advertencia");
                    System.out.println(driver.findElement(By.id("id3d")).getText());
                    Thread.sleep(1000);
                    a.ScreenShotPool(driver, i, "screen" + numScreenShoot4, nombreAutomatizacion, folderName);

                    WebElement btnContinuar = driver.findElement(By.xpath("//input[@wicketpath='modalWindowForm_EventSection_content_Form_continueButton']"));
                    btnContinuar.click();

                    a.waitSearchWicket(driver, "Consultando Poliza");

                    Thread.sleep(1000);
                    a.ScreenShotPool(driver, i, "screen" + numScreenShoot5, nombreAutomatizacion, folderName);

                }
                else { // Tercero no presenta cumulo
                    System.out.println("Se muestra la póliza");
                    Thread.sleep(1000);
                    a.waitSearchWicket(driver, "Consultando la póliza");
                    Thread.sleep(1000);
                    a.ScreenShotPool(driver, i, "screen" + numScreenShoot4, nombreAutomatizacion, folderName);
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }

    }
}
