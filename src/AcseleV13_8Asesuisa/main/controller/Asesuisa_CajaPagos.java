package AcseleV13_8Asesuisa.main.controller;

import AcseleV13_8Asesuisa.beans.Asesuisa_CajaPagosBean;
import AcseleV13_8Asesuisa.main.controller.Asesuisa_Menu.Asesuisa_MenuOperaciones;
import com.sun.istack.internal.NotNull;
import metodo.Metodos;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by aandrade on 26/04/2017.
 */
public class Asesuisa_CajaPagos {

    private final static Logger log = Logger.getLogger(Asesuisa_CajaPagos.class);

    public String nombreAutomatizacion = "Asesuisa Caja Pagos";
    private WebDriver driver;
    Metodos a = new Metodos();

    public void testLink(Asesuisa_CajaPagosBean bean, int i, String folderName){

        try {

            // Instanciando clases
            //Metodos a = new Metodos();
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

            PagosCaja(bean, i, folderName, 3, 4, 5, 6, 7,8,9,10,11,12);
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

    public void PagosCaja(Asesuisa_CajaPagosBean bean, int i, String folderName, int numScreenShoot, int numScreenShoot2, int numScreenShoot3, int numScreenShoot4, int numScreenShoot5, int numScreenShoot6, int numScreenShoot7, int numScreenShoot8, int numScreenShoot9, int numScreenShoot10){

        WebElement indextr;
        String monto=null;

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
            driver.findElement(By.xpath("/html/body/table[2]/tbody/tr[3]/td/table/tbody/tr/td/form/table/tbody/tr[4]/td[1]/input")).click();
            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion, folderName);
            Thread.sleep(1000);
            // Clic en Boton Seleccione el tercero
            driver.findElement(By.xpath("//*[@id=\"idb_040203703_thirdPartySelection_02\"]")).click();
            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot2, nombreAutomatizacion, folderName);
            Thread.sleep(1000);

            if(bean.getTipotran().equals("Pago")) {
                // ***** Pestaña  Estado de cuenta *****
                driver.findElement(By.xpath("/html/body/table[2]/tbody/tr[1]/td[1]/table/tbody/tr/td[7]/a")).click();
                Thread.sleep(1000);
                // Selecciona la cuota
                driver.findElement(By.xpath("//*[@id=\"openItemID22050\"]")).click();
                Thread.sleep(1000);
                a.ScreenShotPool(driver, i, "screen" + numScreenShoot3, nombreAutomatizacion, folderName);
                Thread.sleep(1000);
                // Selecciona el boton Aceptar
                driver.findElement(By.xpath("//*[@id=\"idb_040203703_statementAccount_01\"]")).click();
                Thread.sleep(1000);

                // Mensajes de Alerta JavaScript 2
                a.alertJavaScriptAceptar(driver);

                a.ScreenShotPool(driver, i, "screen" + numScreenShoot4, nombreAutomatizacion, folderName);
                Thread.sleep(1000);
            }


            // ***** Pestaña  Ingreso de caja *****
            driver.findElement(By.xpath("//*[@id=\"link_caja\"]/a")).click();
            Thread.sleep(1000);

            // Tipo de Transaccion PAGO
            if(bean.getTipotran().equals("Pago")) {
                // Clic al check Tipo de pago
                driver.findElement(By.xpath("//*[@id=\"cashierRegisterForm\"]/table/tbody/tr[3]/td[1]/input")).click();
                // Selecciona el Tipo de Pago
                Select tipopago = new Select(driver.findElement(By.xpath("//*[@id=\"cashierRegisterForm\"]/table/tbody/tr[3]/td[2]/select")));
                tipopago.selectByVisibleText(bean.getTipopago());
                if (bean.getTipopago().equals("Cheque")) {
                    // Selecciona Cuenta Bancaria
                    Select cuentab = new Select(driver.findElement(By.xpath("//*[@id=\"accountsTypePaymentSelect\"]")));
                    cuentab.selectByVisibleText(bean.getCuentab());
                }
                // Selecciona el boton Aceptar
                driver.findElement(By.xpath("//*[@id=\"idb_040203703_cashierRegisterReception_01\"]")).click();
                //Thread.sleep(1000);
                //a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion, folderName);
                //Thread.sleep(1000);
                // Selecciona el boton Aceptar
                Thread.sleep(1000);
                a.ScreenShotPool(driver, i, "screen" + numScreenShoot5, nombreAutomatizacion, folderName);
                driver.findElement(By.xpath("//*[@id=\"idb_040203703_cahsierRegisterReception_10\"]")).click();
                // Asigna el monto de la cuota a una variable
                monto = driver.findElement(By.xpath("/html/body/table[2]/tbody/tr[3]/td/table/tbody/tr/td/table[1]/tbody/tr[3]/td[2]")).getText();

            }
            // Tipo de Transaccion PRIMA DEPOSITO
            if(bean.getTipotran().equals("Prima depósito")) {
                // Selecciona el Tipo de Pago
                Select tipopago = new Select(driver.findElement(By.xpath("//*[@id=\"registerIncomingAmountForm\"]/table/tbody/tr[3]/td[1]/select[1]")));
                tipopago.selectByVisibleText(bean.getTipopago());
                // Selecciona Cuenta Bancaria
                Select cuentab = new Select(driver.findElement(By.xpath("//*[@id=\"accountsTypePaymentSelect\"]")));
                cuentab.selectByVisibleText(bean.getCuentab());
                Thread.sleep(1000);
                // Selecciona Moneda
                Select moneda = new Select(driver.findElement(By.xpath("//*[@id=\"registerIncomingAmountForm\"]/table/tbody/tr[3]/td[1]/select[3]")));
                moneda.selectByVisibleText(bean.getMoneda());
                // Selecciona Monto
                driver.findElement(By.xpath("//*[@id=\"amount\"]")).sendKeys(bean.getMonto());
                // Selecciona Ramo
                Select aaramo = new Select(driver.findElement(By.xpath("//*[@id=\"registerIncomingAmountForm\"]/table/tbody/tr[3]/td[1]/select[4]")));
                aaramo.selectByVisibleText(bean.getRamo());

                Thread.sleep(1000);
                a.ScreenShotPool(driver, i, "screen" + numScreenShoot3, nombreAutomatizacion, folderName);
                Thread.sleep(1000);

                // Clic al boton agregar
                driver.findElement(By.xpath("//*[@id=\"idb_040203703_cahsierRegisterReception_03\"]")).click();
                Thread.sleep(1000);
                // Selecciona el boton Aceptar
                driver.findElement(By.xpath("//*[@id=\"idb_040203703_cahsierRegisterReception_10\"]")).click();
                Thread.sleep(1000);
                a.ScreenShotPool(driver, i, "screen" + numScreenShoot4, nombreAutomatizacion, folderName);
                // Asigna el monto de la cuota a una variable
                monto = bean.getMonto();

            }

            Thread.sleep(1000);
            // Selecciona el boton Detalle Pago
            driver.findElement(By.xpath("//*[@id=\"idb_040203703_cahsierRegisterReception_05\"]")).click();

            // Pantalla del Detalle
            Thread.sleep(2000);
            a.changeLastWindows(driver);
            Thread.sleep(3000);

            if (bean.getTipopago().equals("Cheque")) {

                // Monto del Cheque
                driver.findElement(By.xpath("//*[@id=\"_MontoCheque\"]")).clear();
                driver.findElement(By.xpath("//*[@id=\"_MontoCheque\"]")).sendKeys(monto);
                // Banco Emisor del Cheque
                Select banemisor = new Select(driver.findElement(By.xpath("//*[@id=\"BancoEmisorCheque\"]")));
                banemisor.selectByVisibleText(bean.getBancoe());
                // Fecha del Cheque
                java.util.Date date = new java.util.Date();
                java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yyyy");
                String fecha = sdf.format(date);
                driver.findElement(By.xpath("//*[@id=\"_FechaCheque\"]")).sendKeys(fecha);
                // Numero del Cheque
                driver.findElement(By.xpath("//*[@id=\"_NumeroChequeCaja\"]")).sendKeys(bean.getNumcheq());
                //Thread.sleep(1000);
                //a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion, folderName);
                //Thread.sleep(1000);
            }
            else if (bean.getTipopago().equals("Efectivo")) {
                // Nombre del Pagador
                driver.findElement(By.xpath("//*[@id=\"_NombrePagadorCaja\"]")).sendKeys(bean.getPagador());
                Thread.sleep(1000);
                // DIU del Pagador
                driver.findElement(By.xpath("//*[@id=\"_NumeroDUI\"]")).sendKeys(bean.getDiu());
                Thread.sleep(1000);
            }
            else if (bean.getTipopago().equals("Tarjeta de D?bito o Cr?dito")) {
                // Tipo de Tarjeta
                Select tipot = new Select(driver.findElement(By.xpath("//*[@id=\"TipoTarjeta\"]")));
                tipot.selectByVisibleText(bean.getTipotarj());
                // Numero de Tarjeta
                driver.findElement(By.xpath("//*[@id=\"_NumeroTarjetaCaja\"]")).sendKeys(bean.getNumerot());
                // Numero Autorizacion POS
                driver.findElement(By.xpath("//*[@id=\"_NumeroAutorizPOS\"]")).sendKeys(bean.getNumpos());
                // Numero Voucher
                driver.findElement(By.xpath("//*[@id=\"_NumeroVoucherPOS\"]")).sendKeys(bean.getVoucher());
                // Nombre del Pagador
                driver.findElement(By.xpath("//*[@id=\"_NombrePagadorCaja\"]")).sendKeys(bean.getPagador());
                // DIU del Pagador
                driver.findElement(By.xpath("//*[@id=\"_NumeroDUI\"]")).sendKeys(bean.getDiu());
            }

            else if (bean.getTipopago().equals("Call Center")) {
                // Fecha del Voucher
                java.util.Date date = new java.util.Date();
                java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yyyy");
                String fecha = sdf.format(date);
                driver.findElement(By.xpath("//*[@id=\"_FechaVoucher\"]")).sendKeys(fecha);
                // Número de Autorización
                driver.findElement(By.xpath("//*[@id=\"_NumeroAutorizacion\"]")).sendKeys(bean.getNumpos());
                // Número de Factura
                driver.findElement(By.xpath("//*[@id=\"_NumeroFactura\"]")).sendKeys(bean.getVoucher());
                // Referencia
                driver.findElement(By.xpath("//*[@id=\"_NumeroReferencia\"]")).sendKeys(bean.getDiu());
                // Monto del Voucher
                driver.findElement(By.xpath("//*[@id=\"_MontoVoucher\"]")).clear();
                driver.findElement(By.xpath("//*[@id=\"_MontoVoucher\"]")).sendKeys(monto);
            }

            else if (bean.getTipopago().equals("Nota de Abono")) {

                // Monto de la Nota de Abono
                driver.findElement(By.xpath("//*[@id=\"_MontoNotaAbono\"]")).clear();
                driver.findElement(By.xpath("//*[@id=\"_MontoNotaAbono\"]")).sendKeys(monto);
                // Fecha de la Nota de Abono
                java.util.Date date = new java.util.Date();
                java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yyyy");
                String fecha = sdf.format(date);
                driver.findElement(By.xpath("//*[@id=\"_FechaNotaAbono\"]")).sendKeys(fecha);
                // Referencia
                driver.findElement(By.xpath("//*[@id=\"_NumeroReferencia\"]")).sendKeys(bean.getNumcheq());
                // Banco Receptor
                Select banemisor = new Select(driver.findElement(By.xpath("//*[@id=\"BancoReceptorNotaAbono\"]")));
                banemisor.selectByVisibleText(bean.getBancoe());
                Thread.sleep(2000);
                // Cuenta Bancaria
                Select cuentaBanco = new Select(driver.findElement(By.xpath("//*[@id=\"CtaBancariaBancRecep\"]")));
                cuentaBanco.selectByVisibleText(bean.getCuentab());
            }


            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot6, nombreAutomatizacion, folderName);
            Thread.sleep(1000);

            // Boton Aceptar
            driver.findElement(By.xpath("//*[@id=\"idb_040203703_registerCheckInfo_01\"]")).click();
            Thread.sleep(1000);
            // Boton Cerrar
            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot7, nombreAutomatizacion, folderName);
            Thread.sleep(1000);
            driver.findElement(By.xpath("//*[@id=\"idb_040203703_voidPage_01\"]")).click();
            Thread.sleep(1000);
            a.changeLastWindows(driver);
            Thread.sleep(1000);


            // ***** Pestaña Aplicar Pagos  *****
            Thread.sleep(1000);
            driver.findElement(By.xpath("/html/body/table[2]/tbody/tr[1]/td[1]/table/tbody/tr/td[17]/a")).click();
            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot8, nombreAutomatizacion, folderName);
            Thread.sleep(1000);
            // Boton Finalizar transaccion
            if(bean.getTipotran().equals("Pago")) {
                driver.findElement(By.xpath("//*[@id=\"idb_040203703_applyPayment_04\"]")).click();
                Thread.sleep(10000);
                // Evalua si la operacion fue satisfactoria
                if (driver.findElements(By.xpath("/html/body/table[2]/tbody/tr[3]/td/table[1]/tbody/tr[1]/td/form/table[3]/tbody/tr/td[2]/b")).size()>0) {
                    String numerror = driver.findElement(By.xpath("/html/body/table[2]/tbody/tr[3]/td/table[1]/tbody/tr[1]/td/form/table[3]/tbody/tr/td[2]/b")).getText();
                    Thread.sleep(1000);
                    a.ScreenShotPool(driver, i, "screen" + numScreenShoot9, nombreAutomatizacion, folderName);
                    Thread.sleep(1000);
                    String mensaje = driver.findElement(By.xpath("/html/body/table[2]/tbody/tr[3]/td/table[2]/tbody/tr[2]/td[2]")).getText();
                    System.out.println("El resultado de la Transaccion no fue exitosa. Error: " + numerror + "  Mensaje:  " + mensaje);
                }

                // Seleccionar radio button Numero de factura
                driver.findElement(By.xpath("//*[@id=\"receiptIndex0\"]")).click();
                Thread.sleep(1000);
                a.ScreenShotPool(driver, i, "screen" + numScreenShoot9, nombreAutomatizacion, folderName);
                Thread.sleep(1000);
                //Seleccionar boton imprimir factura
                driver.findElement(By.xpath("//*[@id=\"idb_040203703_applyPayments_09\"]")).click();
                // Factura
                Thread.sleep(2000);
                a.changeLastWindows(driver);
                Thread.sleep(2000);
                a.ScreenShotPool(driver, i, "screen" + numScreenShoot10, nombreAutomatizacion, folderName);
                Thread.sleep(1000);
                // cierra la ventana de factura
                driver.close();
            }
            else if(bean.getTipotran().equals("Prima depósito")) {
                driver.findElement(By.xpath("//*[@id=\"idb_040203703_applyPayments_05\"]")).click();
                Thread.sleep(10000);
                a.ScreenShotPool(driver, i, "screen" + numScreenShoot9, nombreAutomatizacion, folderName);
                Thread.sleep(1000);
            }

        } catch (Exception e) {

            try {
                a.ScreenShotPool(driver, i, "error PagosCaja", nombreAutomatizacion, folderName);
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
