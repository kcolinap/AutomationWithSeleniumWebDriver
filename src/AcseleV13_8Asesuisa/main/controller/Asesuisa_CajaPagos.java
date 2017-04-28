package AcseleV13_8Asesuisa.main.controller;

import AcseleV13_8Asesuisa.beans.Asesuisa_CajaPagosBean;
import AcseleV13_8Asesuisa.main.controller.Asesuisa_Menu.Asesuisa_MenuOperaciones;
import metodo.Metodos;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by aandrade on 26/04/2017.
 */
public class Asesuisa_CajaPagos {

    private final static Logger log = Logger.getLogger(Asesuisa_CajaPagos.class);

    public String nombreAutomatizacion = "Asesuisa Caja Pagos";
    private WebDriver driver;

    public void testLink(Asesuisa_CajaPagosBean bean, int i, String folderName){

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
            menuOperaciones.UAA_Caja_ColeccionDeProcesos(driver, nombreAutomatizacion, 2, i, folderName);

            Thread.sleep(2000);
            a.cambiarVentana(driver);
            Thread.sleep(2000);

            /** Pagos Caja*/

            PagosCaja(bean, a, i, folderName, 3, 4, 5, 6, 7);
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

    public void PagosCaja(Asesuisa_CajaPagosBean bean, Metodos a, int i, String folderName, int numScreenShoot, int numScreenShoot2, int numScreenShoot3, int numScreenShoot4, int numScreenShoot5){

        WebElement indextr;

        try {

            // Ingresa Poliza a gestionar y presiona el boton Aceptar
            WebElement descripcion = driver.findElement(By.xpath("/html/body/table[2]/tbody/tr[3]/td/table/tbody/tr/td/form/table/tbody/tr[4]/td[2]/input"));
            descripcion.sendKeys(bean.getPoliza());
            driver.findElement(By.xpath("//*[@id=\"idb_040203703_thirdPartySelection_01\"]")).click();
            Thread.sleep(1000);

            // ***** Pestaña Seleccion de tercero *****
            // Tipo de transaccion
            Select tipotran = new Select(driver.findElement(By.xpath("//select[@name='transactionType']")));
            tipotran.selectByVisibleText(bean.getTipotran());
            Thread.sleep(1000);
            // Selecciona Radio Boton ID del Tercero
            driver.findElement(By.xpath("/html/body/table[2]/tbody/tr[3]/td/table/tbody/tr/td/form/table[2]/tbody/tr[4]/td[1]/input")).click();
            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion, folderName);
            Thread.sleep(1000);
            // Clic en Boton Seleccione el tercero
            driver.findElement(By.xpath("//*[@id=\"idb_040203703_thirdPartySelection_02\"]")).click();
            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion, folderName);
            Thread.sleep(1000);


            // ***** Pestaña  Estado de cuenta *****
            driver.findElement(By.xpath("/html/body/table[2]/tbody/tr[1]/td[1]/table/tbody/tr/td[7]/a")).click();
            Thread.sleep(1000);
            // Selecciona la cuota
            driver.findElement(By.xpath("//*[@id=\"openItemID22050\"]")).click();
            Thread.sleep(1000);
            // Selecciona el boton Aceptar
            driver.findElement(By.xpath("//*[@id=\"idb_040203703_statementAccount_01\"]")).click();
            Thread.sleep(1000);

            // ***** Pestaña  Ingreso de caja *****
            driver.findElement(By.xpath("//*[@id=\"link_caja\"]/a")).click();
            Thread.sleep(1000);
            // Clic al check Tipo de pago
            driver.findElement(By.xpath("//*[@id=\"cashierRegisterForm\"]/table/tbody/tr[3]/td[1]/input")).click();
            // Selecciona el Tipo de Pago
            Select tipopago = new Select(driver.findElement(By.xpath("//*[@id=\"cashierRegisterForm\"]/table/tbody/tr[3]/td[2]/select")));
            tipopago.selectByVisibleText(bean.getTipopago());
            // Selecciona Cuenta Bancaria
            Select cuentab = new Select(driver.findElement(By.xpath("//*[@id=\"accountsTypePaymentSelect\"]")));
            cuentab.selectByVisibleText(bean.getCuentab());
            // Selecciona el boton Aceptar
            driver.findElement(By.xpath("//*[@id=\"idb_040203703_cashierRegisterReception_01\"]")).click();
            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion, folderName);
            Thread.sleep(1000);
            // Selecciona el boton Aceptar
            driver.findElement(By.xpath("//*[@id=\"idb_040203703_cahsierRegisterReception_10\"]")).click();
            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion, folderName);
            // Asigna el monto de la cuota a una variable
            String monto = driver.findElement(By.xpath("/html/body/table[2]/tbody/tr[3]/td/table/tbody/tr/td/table[1]/tbody/tr[3]/td[2]")).getText();

            Thread.sleep(1000);
            // Selecciona el boton Detalle Pago
            driver.findElement(By.xpath("//*[@id=\"idb_040203703_cahsierRegisterReception_05\"]")).click();

            // Pantalla del Detalle
            Thread.sleep(2000);
            a.changeLastWindows(driver);
            Thread.sleep(2000);
            // Monto del Cheque
            driver.findElement(By.xpath("//*[@id=\"_MontoCheque\"]")).clear();
            driver.findElement(By.xpath("//*[@id=\"_MontoCheque\"]")).sendKeys(monto);
            // Banco Emisor del Cheque
            Select banemisor = new Select(driver.findElement(By.xpath("//*[@id=\"BancoEmisorCheque\"]")));
            banemisor.selectByVisibleText(bean.getBancoe());
            // Fecha del Cheque
            java.util.Date date = new java.util.Date();
            java.text.SimpleDateFormat sdf=new java.text.SimpleDateFormat("dd/MM/yyyy");
            String fecha = sdf.format(date);
            driver.findElement(By.xpath("//*[@id=\"_FechaCheque\"]")).sendKeys(fecha);
            // Numero del Cheque
            //String aanumcheque = "123456789";
            driver.findElement(By.xpath("//*[@id=\"_NumeroChequeCaja\"]")).sendKeys(bean.getNumcheq());
            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion, folderName);
            Thread.sleep(1000);
            // Boton Aceptar
            driver.findElement(By.xpath("//*[@id=\"idb_040203703_registerCheckInfo_01\"]")).click();
            Thread.sleep(1000);
            // Boton Cerrar
            driver.findElement(By.xpath("//*[@id=\"idb_040203703_voidPage_01\"]")).click();
            Thread.sleep(2000);
            a.changeLastWindows(driver);
            Thread.sleep(2000);


            // ***** Pestaña Aplicar Pagos  *****
            Thread.sleep(1000);
            driver.findElement(By.xpath("/html/body/table[2]/tbody/tr[1]/td[1]/table/tbody/tr/td[17]/a")).click();
            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion, folderName);
            Thread.sleep(1000);
            // Boton Finalizar transaccion
            driver.findElement(By.xpath("//*[@id=\"idb_040203703_applyPayment_04\"]")).click();
            Thread.sleep(10000);
            // Seleccionar radio button Numero de factura
            driver.findElement(By.xpath("//*[@id=\"receiptIndex0\"]")).click();
            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion, folderName);
            Thread.sleep(1000);
            //Seleccionar boton imprimir factura
            driver.findElement(By.xpath("//*[@id=\"idb_040203703_applyPayments_09\"]")).click();
            // Factura
            Thread.sleep(2000);
            a.changeLastWindows(driver);
            Thread.sleep(2000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion, folderName);
            Thread.sleep(1000);
            // cierra la ventana de factura
            driver.close();

        } catch (Exception e) {
            e.printStackTrace();
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }

    }
}
