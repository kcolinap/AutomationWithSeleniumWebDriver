package AcseleV13_8Asesuisa.main.controller;

import AcseleV13_8Asesuisa.beans.Asesuisa_BusquedaAvanzadaPolizaBean;
import AcseleV13_8Asesuisa.main.controller.Asesuisa_Menu.Asesuisa_MenuOperaciones;
import metodo.Metodos;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by agil on 27/03/2017.
 */
public class Asesuisa_BusquedaAvanzadaPoliza {

    private final static Logger log = Logger.getLogger(Asesuisa_BusquedaAvanzadaPoliza.class);

    public String nombreAutomatizacion = "Asesuisa Busqueda Avanzada Poliza";
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

            FormularioBusquedaAvanzada(bean, a, i, folderName, 3, 4, 5, 6, 7);
            Thread.sleep(3000);


            //driver.quit();

        } catch (Exception e) {
            e.printStackTrace();
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
            if (driver != null){
                //driver.quit();
            }
        }
    }

    public void FormularioBusquedaAvanzada(Asesuisa_BusquedaAvanzadaPolizaBean bean, Metodos a, int i, String folderName, int numScreenShoot, int numScreenShoot2, int numScreenShoot3, int numScreenShoot4, int numScreenShoot5){

        what: try {
            //WebElement prueba = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_2_fila_field']"));

            JavascriptExecutor jse = (JavascriptExecutor)driver;

            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion, folderName);
            Thread.sleep(1000);

            WebElement btnBusquedaAvanzada = driver.findElement(By.xpath("//span[@wicketpath='ConsultPolicy_searchForm_detailSearchLink_searchLabel']"));
            btnBusquedaAvanzada.click();

            Thread.sleep(3000);

            // 1. Busqueda vacia
            if (bean.getTipoProducto() == null && bean.getNumeroPoliza() == null && bean.getFechaEmision() == null && bean.getEstadoCicloVida() == null){

                System.out.println("Busqueda con los campos vacios");
                Thread.sleep(1000);
                a.ScreenShotPool(driver, i, "screen" + numScreenShoot2, nombreAutomatizacion, folderName);
                Thread.sleep(1000);

                WebElement btnBuscar = driver.findElement(By.xpath("//input[@wicketpath='ConsultPolicy_searchForm_searchButton']"));
                btnBuscar.click();

                Thread.sleep(1000);
                a.waitSearchWicket(driver, "Buscando Poliza");

                jse.executeScript("window.scrollBy(0,1000)", "");

                Thread.sleep(1000);
                a.ScreenShotPool(driver, i, "screen" + numScreenShoot3, nombreAutomatizacion, folderName);
                Thread.sleep(1000);

                Boolean mensageID = driver.findElements(By.id("_wicket_window_1")).size() > 0;

                if (mensageID){
                    //System.out.println("No se encontró resultados asociados con esta búsqueda");
                    System.out.println(driver.findElement(By.xpath("//span[@wicketpath='ConsultPolicy_errorSimpleSearchModalDialog_content_text']")).getText());
                    System.out.println();
                }

                //System.out.println("Tipo de Producto no valido! failed");
                break what;
            }
            // 2. Busqueda con producto
            else if (bean.getTipoProducto() != null){
                System.out.println("Busqueda con producto");
                if (bean.getTipoProducto().toLowerCase().equals("automotores")){

                    Select tipoProducto = new Select(driver.findElement(By.xpath("//select[@wicketpath='ConsultPolicy_searchForm_productsList']")));
                    tipoProducto.selectByValue(bean.getTipoProducto());

                    Thread.sleep(2000);

                    if (bean.getEstadoCicloVida() != null){
                        Select estadoCicloVida = new Select(driver.findElement(By.xpath("//select[@wicketpath='ConsultPolicy_searchForm_stateProductsList']")));
                        estadoCicloVida.selectByValue(bean.getEstadoCicloVida());
                    }

                    if (bean.getNumeroPoliza() != null) {
                        WebElement numPoliza = driver.findElement(By.xpath("//input[@wicketpath='ConsultPolicy_searchForm_templatePolicy_repeaterPanel2_1_fila_field']"));
                        numPoliza.sendKeys(bean.getNumeroPoliza());
                    }

                    if (bean.getFechaEmision() != null){
                        WebElement asegurado = driver.findElement(By.xpath("//input[@wicketpath='ConsultPolicy_searchForm_templatePolicy_repeaterPanel2_4_fila_fieldDate']"));
                        asegurado.sendKeys(bean.getFechaEmision());
                    }
                }else {
                    System.out.println("Tipo de Producto no valido! failed");
                    break what;
                }
            }
            // 6. Sin producto
            else if (bean.getTipoProducto() == null/* && bean.getNumeroPoliza() == null && bean.getFechaEmision() == null && bean.getEstadoCicloVida() == null*/){

                System.out.println("Busqueda con producto");

                if (bean.getEstadoCicloVida() != null) {
                    Select estadoCicloVida = new Select(driver.findElement(By.xpath("//select[@wicketpath='ConsultPolicy_searchForm_stateProductsList']")));
                    estadoCicloVida.selectByValue(bean.getEstadoCicloVida());
                }

                if (bean.getNumeroPoliza() != null) {
                    WebElement numPoliza = driver.findElement(By.xpath("//input[@wicketpath='ConsultPolicy_searchForm_templatePolicy_repeaterPanel1_2_fila_field']"));
                    numPoliza.sendKeys(bean.getNumeroPoliza());
                }

                if (bean.getFechaEmision() != null) {
                    WebElement asegurado = driver.findElement(By.xpath("//input[@wicketpath='ConsultPolicy_searchForm_templatePolicy_repeaterPanel2_2_fila_fieldDate']"));
                    asegurado.sendKeys(bean.getFechaEmision());
                }

            }
            // 9. Solo Numero de Poliza
            else if (bean.getNumeroPoliza() != null && bean.getTipoProducto() == null && bean.getFechaEmision() == null && bean.getEstadoCicloVida() == null){

            }
            // 10. Solo fecha de emision
            else if (bean.getFechaEmision() != null && bean.getNumeroPoliza() != null && bean.getTipoProducto() == null && bean.getEstadoCicloVida() == null){

            }

            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot2, nombreAutomatizacion, folderName);
            Thread.sleep(1000);

            jse.executeScript("window.scrollBy(0,1000)", "");

            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot3, nombreAutomatizacion, folderName);
            Thread.sleep(1000);

            WebElement btnBuscar = driver.findElement(By.xpath("//input[@wicketpath='ConsultPolicy_searchForm_searchButton']"));
            btnBuscar.click();

            Thread.sleep(1000);
            a.waitSearchWicket(driver, "Buscando Poliza");

            jse.executeScript("window.scrollBy(0,1000)", "");

            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot4, nombreAutomatizacion, folderName);
            Thread.sleep(1000);
/*
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
*/
        } catch (Exception e) {
            e.printStackTrace();
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }
}
