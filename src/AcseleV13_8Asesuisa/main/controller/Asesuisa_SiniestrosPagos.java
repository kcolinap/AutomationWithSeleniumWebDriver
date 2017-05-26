package AcseleV13_8Asesuisa.main.controller;

import AcseleV13_8Asesuisa.beans.Asesuisa_CajaAnularFacturaBean;
import AcseleV13_8Asesuisa.beans.Asesuisa_SiniestrosPagosBean;
import AcseleV13_8Asesuisa.main.controller.Asesuisa_Menu.Asesuisa_MenuOperaciones;
import AcseleV13_8Asesuisa.principal.EjecutarJar_Asesuisa;
import metodo.Metodos;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import util.DBUnitConnectionManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by aandrade on 13/05/2017.
 */
public class Asesuisa_SiniestrosPagos {

    private final static Logger log = Logger.getLogger(Asesuisa_SiniestrosPagos.class);

    public String nombreAutomatizacion = "Asesuisa Siniestros Crear Pagos";
    private WebDriver driver;

    public void testLink(Asesuisa_SiniestrosPagosBean bean, int i, String folderName){


        try {

            //System.out.println("Siniestro: " + bean.getNumSiniestro());
            // Instanciando clases
            Metodos a = new Metodos();
            Asesuisa_MenuOperaciones menuOperaciones = new Asesuisa_MenuOperaciones();

            driver = a.entrarPagina(a.UrlAsesuisa());
            a.IniciarSesion(driver, nombreAutomatizacion, i, folderName);
            a.ValidandoSesion(driver, nombreAutomatizacion, i, folderName);
            Thread.sleep(5000);

            //Entrando en Menu de Mantenimiento de Siniestro
            menuOperaciones.OpeSini_MantenimientoSiniestro(driver, nombreAutomatizacion, 2, i, folderName);

            Thread.sleep(2000);
            a.cambiarVentana(driver);
            Thread.sleep(2000);

            //     ** Pagos Siniestros Crear*

            PagosSiniestros(bean, a, i, folderName, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20);
            Thread.sleep(5000);

            driver.quit();

        } catch (Exception e) {
            e.printStackTrace();
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
            if (driver != null){
                driver.quit();
            }
        }
    }

    public void PagosSiniestros(Asesuisa_SiniestrosPagosBean bean, Metodos a, int i, String folderName, int numScreenShoot, int numScreenShoot2, int numScreenShoot3, int numScreenShoot4, int numScreenShoot5,
                                int numScreenShoot6, int numScreenShoot7, int numScreenShoot8, int numScreenShoot9, int numScreenShoot10, int numScreenShoot11, int numScreenShoot12, int numScreenShoot13, int numScreenShoot14,
                                int numScreenShoot15, int numScreenShoot16, int numScreenShoot17, int numScreenShoot18){

        String pagomax = null;
        String varpagomax;
        JavascriptExecutor jse = (JavascriptExecutor) driver;

        try {
            Thread.sleep(2000);
            // Introduce el numero de siniestro
            System.out.println("Valor de getNumSiniestro2:  " + bean.getNumSiniestro());
            System.out.println("Valor de Accion:  " + bean.getAccion());
            WebElement numsiniestro = driver.findElement(By.xpath("//*[@id=\"textFieldClaimNumbre\"]"));
            numsiniestro.sendKeys(bean.getNumSiniestro());
            //numsiniestro.sendKeys(bean.getSiniestro());
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion, folderName);
            Thread.sleep(1000);
            // Selecciona el boton buscar
            driver.findElement(By.xpath("//*[@id=\"buttonBuscar\"]/span/span")).click();
            Thread.sleep(2000);
            // Selecciona el siniestro y luego el boton Buscar
            driver.findElement(By.xpath("//*[@id=\"layoutResultTable\"]/div[1]/div/div[3]/div[1]/table/tbody/tr/td[2]/div")).click();
            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot2, nombreAutomatizacion, folderName);
            Thread.sleep(1000);
            driver.findElement(By.xpath("//*[@id=\"buttonOk\"]")).click();
            Thread.sleep(3000);


                // Pantalla de Mantenimiento del Siniestro
                // Primera parte de la Pantalla
                a.changeLastWindows(driver);
                Thread.sleep(3000);
                a.ScreenShotPool(driver, i, "screen" + numScreenShoot3, nombreAutomatizacion, folderName);
                Thread.sleep(1000);
                // Segunda parte de la Pantalla
                jse.executeScript("window.scrollBy(0,800)", "");
                Thread.sleep(1000);
                a.ScreenShotPool(driver, i, "screen" + numScreenShoot4, nombreAutomatizacion, folderName);
                Thread.sleep(1000);


                /****  Enviar Pago *****/
                if(bean.getAccion().equals("Enviar")) {

                    // *** Cobertura Agregar ***
                    // Selecciona Agregar Cobertura
                    driver.findElement(By.xpath("//*[@id=\"idb_0402006_structure_04\"]")).click();
                    Thread.sleep(5000);
                    // Llena el campo Pago Maximo
                    if (bean.getPagomax() == null) {
                        pagomax = driver.findElement(By.xpath("/html/body/div[14]/div[2]/form/center/table/tbody[2]/tr[1]/td[2]/input[1]")).getAttribute("Value");
                    } else {
                        System.out.println("Pago maximo de la tabla");
                        pagomax = bean.getPagomax();
                    }
                    WebElement pagomaximo = driver.findElement(By.xpath("//*[@id=\"maxBenefitAmount1\"]"));
                    pagomaximo.clear();
                    pagomaximo.sendKeys(pagomax);
                    Thread.sleep(1000);

                    a.ScreenShotPool(driver, i, "screen" + numScreenShoot5, nombreAutomatizacion, folderName);
                    Thread.sleep(1000);

                    // Selecciona el boton Enviar
                    driver.findElement(By.xpath("//*[@id=\"idb_0402006_addCoverages_03\"]")).click();
                    Thread.sleep(1000);
                    // Mensajes de Alerta JavaScript 2
                    a.alertJavaScriptAceptar(driver);

                    // *** Cobertura Requisitos ***
                    // Selecciona la Cobertura
                    driver.findElement(By.xpath("//*[@id=\"coverageSelect\"]/option")).click();
                    Thread.sleep(1500);

                    a.ScreenShotPool(driver, i, "screen" + numScreenShoot6, nombreAutomatizacion, folderName);
                    Thread.sleep(1000);


                    // Selecciona "Requisitos"
                    driver.findElement(By.xpath("//*[@id=\"idb_0402006_structure_14\"]")).click();
                    Thread.sleep(2000);
                    // Selecciona el radio buton "RECIBIDOS"
                    driver.findElement(By.xpath("/html/body/div[14]/div[2]/form[2]/center/table/thead/tr/th[3]/input")).click();
                    Thread.sleep(2000);

                    a.ScreenShotPool(driver, i, "screen" + numScreenShoot7, nombreAutomatizacion, folderName);
                    Thread.sleep(1000);

                    // Selecciona el buton "Enviar"
                    driver.findElement(By.xpath("//*[@id=\"idb_0402006_requisites_02\"]")).click();
                    Thread.sleep(2000);


                    // *** Cobertura Pagos ***
                    // Selecciona la Cobertura
                    driver.findElement(By.xpath("//*[@id=\"coverageSelect\"]/option")).click();
                    Thread.sleep(1000);
                    // Selecciona Pagos
                    driver.findElement(By.xpath("//*[@id=\"idb_0402006_structure_09\"]")).click();
                    Thread.sleep(1000);

                    a.ScreenShotPool(driver, i, "screen" + numScreenShoot8, nombreAutomatizacion, folderName);
                    Thread.sleep(1000);
                    jse.executeScript("window.scrollBy(0,600)", "");
                    Thread.sleep(1000);
                    a.ScreenShotPool(driver, i, "screen" + numScreenShoot9, nombreAutomatizacion, folderName);
                    Thread.sleep(1000);

                    // Selecciona el boton "Terceros Poliza"
                    driver.findElement(By.xpath("//*[@id=\"idb_0402006_generateClaimPayment_04\"]")).click();
                    // Selecciona el Tercero
                    //driver.findElement(By.xpath("/html/body/div[14]/div[2]/table[2]/tbody/tr[4]/td[1]/input")).click();

                    int norden = Integer.parseInt(bean.getTercero());

                    for (int j = 4; j < (norden + 4); j++) {
                        driver.findElement(By.xpath("/html/body/div[14]/div[2]/table[2]/tbody/tr[" + j + "]/td[1]/input")).click();
                    }

                    Thread.sleep(1000);

                    a.ScreenShotPool(driver, i, "screen" + numScreenShoot10, nombreAutomatizacion, folderName);
                    Thread.sleep(1000);

                    // Selecciona el buton "Enviar"
                    driver.findElement(By.xpath("//*[@id=\"idb_0402006_resultClaimThirdParty_01\"]")).click();
                    Thread.sleep(2000);

                    a.ScreenShotPool(driver, i, "screen" + numScreenShoot11, nombreAutomatizacion, folderName);
                    Thread.sleep(1000);

                    // Selecciona el icono del Lapiz
                    driver.findElement(By.xpath("//*[@id=\"paymentTable\"]/tbody/tr/td[1]/input[2]")).click();
                    Thread.sleep(2000);
                    // Cambia la fecha de compromiso
                    java.util.Date date = new java.util.Date();
                    java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yyyy");
                    String fecha = sdf.format(date);
                    driver.findElement(By.xpath("//*[@id=\"idTablePayments\"]/tbody/tr[4]/td[4]/input[2]")).clear();
                    driver.findElement(By.xpath("//*[@id=\"idTablePayments\"]/tbody/tr[4]/td[4]/input[2]")).sendKeys(fecha);
                    Thread.sleep(2000);
                    // Introduce Monto Siniestro
                    driver.findElement(By.xpath("//*[@id=\"amount1\"]")).clear();
                    Thread.sleep(2000);
                    a.alertJavaScriptAceptar(driver);

                    if (bean.getMontosini() != null) {
                        pagomax = bean.getMontosini();
                    }
                    driver.findElement(By.xpath("//*[@id=\"amount1\"]")).sendKeys(pagomax);
                    Thread.sleep(2000);
                    driver.findElement(By.xpath("//*[@id=\"idTablePayments\"]/tbody/tr[4]/td[4]/input[2]")).click();
                    Thread.sleep(2000);

                    a.ScreenShotPool(driver, i, "screen" + numScreenShoot12, nombreAutomatizacion, folderName);
                    Thread.sleep(1000);


                    // Selecciona el buton "Enviar"
                    driver.findElement(By.xpath("//*[@id=\"idb_0402006_claimPaymentDetail_01\"]")).click();
                    Thread.sleep(2000);

                    a.ScreenShotPool(driver, i, "screen" + numScreenShoot13, nombreAutomatizacion, folderName);
                    Thread.sleep(1000);
                    jse.executeScript("window.scrollBy(0,500)", "");
                    Thread.sleep(1000);
                    a.ScreenShotPool(driver, i, "screen" + numScreenShoot14, nombreAutomatizacion, folderName);
                    Thread.sleep(1000);

                    // Selecciona el buton "Atras"
                    driver.findElement(By.xpath("//*[@id=\"idTablePayments\"]/tbody/tr[16]/td[1]/input[5]")).click();
                    Thread.sleep(2000);
                    a.ScreenShotPool(driver, i, "screen" + numScreenShoot15, nombreAutomatizacion, folderName);
                    Thread.sleep(1000);
                    jse.executeScript("window.scrollBy(0,800)", "");
                    Thread.sleep(1000);
                    a.ScreenShotPool(driver, i, "screen" + numScreenShoot16, nombreAutomatizacion, folderName);
                    Thread.sleep(1000);

                    // Selecciona el buton "Enviar"
                    driver.findElement(By.xpath("//*[@id=\"idb_0402006_generateClaimPayment_14\"]")).click();
                    Thread.sleep(3000);
                    a.ScreenShotPool(driver, i, "screen" + numScreenShoot17, nombreAutomatizacion, folderName);
                    Thread.sleep(1000);
                    jse.executeScript("window.scrollBy(0,500)", "");
                    Thread.sleep(1000);
                    a.ScreenShotPool(driver, i, "screen" + numScreenShoot18, nombreAutomatizacion, folderName);
                    Thread.sleep(1000);

                }

            /****  Aprobar, Anular y Cancelar Pago *****/
           // else if(bean.getCobertura().equals("Aprobar")) {
           else {

                // *** Cobertura Pagos ***
                // Selecciona la Cobertura
                driver.findElement(By.xpath("//*[@id=\"coverageSelect\"]/option[1]")).click();
                Thread.sleep(1000);
                // Selecciona Pagos
                driver.findElement(By.xpath("//*[@id=\"idb_0402006_structure_09\"]")).click();
                Thread.sleep(1000);

                a.ScreenShotPool(driver, i, "screen" + numScreenShoot5, nombreAutomatizacion, folderName);
                Thread.sleep(1000);
                jse.executeScript("window.scrollBy(0,800)", "");
                Thread.sleep(1000);
                a.ScreenShotPool(driver, i, "screen" + numScreenShoot6, nombreAutomatizacion, folderName);
                Thread.sleep(1000);

                jse.executeScript("window.scrollBy(0,-800)", "");

                // Selecciona la Orden de Pago
                //driver.findElement(By.xpath("//*[@id=\"paymentCheck\"]")).click();
                //Thread.sleep(1000);

                Thread.sleep(1000);
                a.ScreenShotPool(driver, i, "screen" + numScreenShoot7, nombreAutomatizacion, folderName);
                Thread.sleep(1000);

                    /****  Aprobar Pago *****/

                    if(bean.getAccion().equals("Aprobar")) {


                        // Cambia la fecha de compromiso
                        java.util.Date date = new java.util.Date();
                        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yyyy");
                        String fecha = sdf.format(date);
                        driver.findElement(By.xpath("//*[@id=\"paymentTable\"]/tbody/tr/td[4]/input[1]")).clear();
                        driver.findElement(By.xpath("//*[@id=\"paymentTable\"]/tbody/tr/td[4]/input[1]")).sendKeys(fecha);
                        Thread.sleep(2000);
                        // Boton Cambiar
                        driver.findElement(By.xpath("//*[@id=\"idb_0402006_generateClaimPayment_03\"]")).click();
                        Thread.sleep(1000);
                        driver.findElement(By.xpath("//*[@id=\"panel-3\"]/div[3]/span/button[1]")).click();
                        Thread.sleep(2000);
//
                        // Selecciona la Orden de Pago
                        driver.findElement(By.xpath("//*[@id=\"paymentCheck\"]")).click();
                        Thread.sleep(1000);

                        // Seleccionar Accion Aprobar
                        Select accion = new Select(driver.findElement(By.xpath("//*[@id=\"actions\"]")));
                        accion.selectByVisibleText(bean.getAccion());
                        Thread.sleep(2000);

                        // Selecionar Ignorar validaciones
                        driver.findElement(By.xpath("//*[@id=\"checkIgnoreValidateClaims\"]")).click();
                        Thread.sleep(1000);

                        Thread.sleep(1000);
                        a.ScreenShotPool(driver, i, "screen" + numScreenShoot8, nombreAutomatizacion, folderName);
                        Thread.sleep(1000);

                        // Selecionar boton Aceptar
                        driver.findElement(By.xpath("//*[@id=\"validateClaims_01\"]")).click();
                        Thread.sleep(1000);

                        // Selecciona el boton Aceptar
                        //driver.findElement(By.xpath("//*[@id=\"validateClaims_01\"]")).click();
                        // Acepta el popup JavaScript
                        a.alertJavaScriptAceptar(driver);
                        Thread.sleep(3000);

                        Thread.sleep(1000);
                        a.ScreenShotPool(driver, i, "screen" + numScreenShoot9, nombreAutomatizacion, folderName);
                        Thread.sleep(1000);

                        // Selecciona una Sucursal
                        //Select sucursal = new Select(driver.findElement(By.xpath("//*[@id=\"divBranchOffice\"]/form/table/tbody/tr[3]/td[1]/table/tbody/tr/td[2]/select")));
                        //accion.selectByVisibleText("San Salvador");

                        // Boton Enviar
                        Thread.sleep(2000);
                        driver.findElement(By.xpath("//*[@id=\"divBranchOffice\"]/form/table/tbody/tr[5]/td/button")).click();
                        Thread.sleep(5000);


                        a.ScreenShotPool(driver, i, "screen" + numScreenShoot11, nombreAutomatizacion, folderName);
                        Thread.sleep(1000);
                        jse.executeScript("window.scrollBy(0,400)", "");
                        Thread.sleep(1000);
                        a.ScreenShotPool(driver, i, "screen" + numScreenShoot12, nombreAutomatizacion, folderName);
                        Thread.sleep(1000);
                    }

                    /****  Cancelar Pago *****/
                    else if(bean.getAccion().equals("Cancelar")) {
                        // Selecciona la Orden de Pago
                        driver.findElement(By.xpath("//*[@id=\"paymentCheck\"]")).click();
                        Thread.sleep(1000);
                        a.ScreenShotPool(driver, i, "screen" + numScreenShoot8, nombreAutomatizacion, folderName);
                        Thread.sleep(1000);

                        // Seleccionar Accion Cancelar
                        Select accion = new Select(driver.findElement(By.xpath("//*[@id=\"actions\"]")));
                        accion.selectByVisibleText(bean.getAccion());
                        Thread.sleep(2000);

                        // Acepta el popup JavaScript
                        a.alertJavaScriptAceptar(driver);
                        Thread.sleep(5000);

                        jse.executeScript("window.scrollBy(0,-800)", "");
                        a.ScreenShotPool(driver, i, "screen" + numScreenShoot9, nombreAutomatizacion, folderName);
                        Thread.sleep(1000);
                        jse.executeScript("window.scrollBy(0,600)", "");
                        Thread.sleep(1000);
                        a.ScreenShotPool(driver, i, "screen" + numScreenShoot10, nombreAutomatizacion, folderName);
                        Thread.sleep(1000);
                    }

                    /****  Rechazar Pago *****/
                    else if(bean.getAccion().equals("Rechazar")) {
                        // Selecciona la Orden de Pago
                        driver.findElement(By.xpath("//*[@id=\"paymentCheck\"]")).click();
                        Thread.sleep(1000);
                        a.ScreenShotPool(driver, i, "screen" + numScreenShoot8, nombreAutomatizacion, folderName);
                        Thread.sleep(1000);

                        // Seleccionar Accion Rechazar
                        Select accion = new Select(driver.findElement(By.xpath("//*[@id=\"actions\"]")));
                        accion.selectByVisibleText(bean.getAccion());
                        Thread.sleep(2000);

                        // Acepta el popup JavaScript
                        a.alertJavaScriptAceptar(driver);
                        Thread.sleep(5000);

                        jse.executeScript("window.scrollBy(0,-800)", "");
                        a.ScreenShotPool(driver, i, "screen" + numScreenShoot9, nombreAutomatizacion, folderName);
                        Thread.sleep(1000);
                        jse.executeScript("window.scrollBy(0,600)", "");
                        Thread.sleep(1000);
                        a.ScreenShotPool(driver, i, "screen" + numScreenShoot10, nombreAutomatizacion, folderName);
                        Thread.sleep(1000);

                    }

            }


        } catch (Exception e) {
            e.printStackTrace();
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }

    }

}
