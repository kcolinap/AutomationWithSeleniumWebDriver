package AcseleV13_8Asesuisa.main.controller;

import AcseleV13_8Asesuisa.beans.Asesuisa_CajaAnularFacturaBean;
import AcseleV13_8Asesuisa.beans.Asesuisa_SiniestrosPagosBean;
import AcseleV13_8Asesuisa.main.controller.Asesuisa_Menu.Asesuisa_MenuOperaciones;
import metodo.Metodos;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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

            /** Pagos Siniestros Crear*/

            PagosSiniestros(bean, a, i, folderName, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16);
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

    public void PagosSiniestros(Asesuisa_SiniestrosPagosBean bean, Metodos a, int i, String folderName, int numScreenShoot, int numScreenShoot2, int numScreenShoot3, int numScreenShoot4, int numScreenShoot5,
                                int numScreenShoot6, int numScreenShoot7, int numScreenShoot8, int numScreenShoot9, int numScreenShoot10, int numScreenShoot11, int numScreenShoot12, int numScreenShoot13, int numScreenShoot14){

        String pagomax = null;
        String varpagomax;
        JavascriptExecutor jse = (JavascriptExecutor) driver;

        try {
            Thread.sleep(2000);
            // Introduce el numero de siniestro
            WebElement numsiniestro = driver.findElement(By.xpath("//*[@id=\"textFieldClaimNumbre\"]"));
            numsiniestro.sendKeys(bean.getSiniestro());
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

            // *** Cobertura Agregar ***
            // Selecciona Agregar Cobertura
            driver.findElement(By.xpath("//*[@id=\"idb_0402006_structure_04\"]")).click();
            Thread.sleep(5000);
            // Llena el campo Pago Maximo
            if(bean.getPagomax() == null) {
                pagomax = driver.findElement(By.xpath("/html/body/div[14]/div[2]/form/center/table/tbody[2]/tr[1]/td[2]/input[1]")).getAttribute("Value");
                //varpagomax = driver.findElement(By.xpath("/html/body/div[14]/div[2]/form/center/table/tbody[2]/tr[1]/td[2]/input[1]")).getAttribute("Value");
                //aapagomax = varpagomax;
            }
            else {
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
            Thread.sleep(1000);

            Thread.sleep(1000);
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
            jse.executeScript("window.scrollBy(0,800)", "");
            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot9, nombreAutomatizacion, folderName);
            Thread.sleep(1000);

            // Selecciona el boton "Terceros Poliza"
            driver.findElement(By.xpath("//*[@id=\"idb_0402006_generateClaimPayment_04\"]")).click();
            // Selecciona el Tercero
            //driver.findElement(By.xpath("/html/body/div[14]/div[2]/table[2]/tbody/tr[4]/td[1]/input")).click();

            int norden = Integer.parseInt(bean.getTercero());

            for (int j = 4; j < (norden+4); j++) {
                driver.findElement(By.xpath("/html/body/div[14]/div[2]/table[2]/tbody/tr["+j+"]/td[1]/input")).click();
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
            // Fecha del Cheque
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

            if(bean.getMontosini() != null){
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


        } catch (Exception e) {
            e.printStackTrace();
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }

    }
}
