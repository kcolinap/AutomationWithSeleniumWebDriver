package AcseleV13_8Asesuisa.main.controller;

import AcseleV13_8Asesuisa.beans.Asesuisa_CajaFactAgrupBean;
import AcseleV13_8Asesuisa.main.controller.Asesuisa_Menu.Asesuisa_MenuOperaciones;
import metodo.Metodos;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by aandrade on 03/05/2017.
 */
public class Asesuisa_CajaFactAgrup {

    private final static Logger log = Logger.getLogger(Asesuisa_CajaFactAgrup.class);

    public String nombreAutomatizacion = "Asesuisa Caja Facturas Agrup";
    private WebDriver driver;

    public void testLink(Asesuisa_CajaFactAgrupBean bean, int i, String folderName){

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

            /** Pagos Caja Facturas Agrupadas*/

            FactAgrupCaja(bean, a, i, folderName, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14);
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

    public void FactAgrupCaja(Asesuisa_CajaFactAgrupBean bean, Metodos a, int i, String folderName, int numScreenShoot, int numScreenShoot2, int numScreenShoot3, int numScreenShoot4, int numScreenShoot5, int numScreenShoot6, int numScreenShoot7, int numScreenShoot8, int numScreenShoot9, int numScreenShoot10, int numScreenShoot11, int numScreenShoot12){

        WebElement indextr;
        String monto = null;
        String poliza = null;
        int j = 0;
        JavascriptExecutor jse = (JavascriptExecutor) driver;

        try {

            // Ingresa Tercero a gestionar y presiona el boton Aceptar
            WebElement tercero = driver.findElement(By.xpath("//*[@id=\"thirdPartyName\"]"));
            tercero.sendKeys(bean.getTercero());
            driver.findElement(By.xpath("//*[@name=\"policyNumber\"]")).click(); // /html/body/table[2]/tbody/tr[3]/td/table/tbody/tr/td/form/table/tbody/tr[4]/td[2]/input
            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion, folderName);
            Thread.sleep(1000);
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
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot2, nombreAutomatizacion, folderName);
            Thread.sleep(1000);
            // Clic en Boton Seleccione el tercero
            driver.findElement(By.xpath("//*[@id=\"idb_040203703_thirdPartySelection_02\"]")).click();
            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot3, nombreAutomatizacion, folderName);
            Thread.sleep(1000);

            if(bean.getTipotran().equals("Pago")) {
                // ***** Pestaña  Estado de cuenta *****
                driver.findElement(By.xpath("/html/body/table[2]/tbody/tr[1]/td[1]/table/tbody/tr/td[7]/a")).click();
                Thread.sleep(1000);

                int tamanotr = driver.findElements(By.xpath("//*[@id=\"accountStatusTable\"]/tbody/tr")).size();
                System.out.println("Numero de lineas: " + tamanotr);
                // Busca la poliza de la primera compañia
                for (j = 4; j < (tamanotr+1); j++) {
                    poliza = driver.findElement(By.xpath("//*[@id=\"accountStatusTable\"]/tbody/tr["+j+"]/td[4]")).getText();
                    if(poliza.equals(bean.getPoliza())) {
                        driver.findElement(By.xpath("//*[@id=\"accountStatusTable\"]/tbody/tr["+j+"]/td[1]")).click();
                        break;
                    }
                }

                // Busca la poliza de la segunda compañia
                for (j = 4; j < (tamanotr+1); j++) {
                    poliza = driver.findElement(By.xpath("//*[@id=\"accountStatusTable\"]/tbody/tr["+j+"]/td[4]")).getText();
                    if(poliza.equals(bean.getPoliza2())) {
                        driver.findElement(By.xpath("//*[@id=\"accountStatusTable\"]/tbody/tr["+j+"]/td[1]")).click();
                        break;
                    }
                }


                // Selecciona el boton Aceptar
                driver.findElement(By.xpath("//*[@id=\"idb_040203703_statementAccount_01\"]")).click();
                Thread.sleep(2000);
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



            // AQUI
            // ***** Pestaña Aplicar Pagos  *****
            Thread.sleep(1000);
            driver.findElement(By.xpath("/html/body/table[2]/tbody/tr[1]/td[1]/table/tbody/tr/td[17]/a")).click();
            // Primera parte de la Pantalla
            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot8, nombreAutomatizacion, folderName);
            Thread.sleep(1000);
            // Segunda parte de la Pantalla
            jse.executeScript("window.scrollBy(0,800)", "");
            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot9, nombreAutomatizacion, folderName);
            Thread.sleep(1000);


            // Boton Finalizar transaccion
            if(bean.getTipotran().equals("Pago")) {
                driver.findElement(By.xpath("//*[@id=\"idb_040203703_applyPayment_04\"]")).click();
                Thread.sleep(20000);
                // Seleccionar radio button Numero de factura 1
                driver.findElement(By.xpath("//*[@id=\"receiptIndex0\"]")).click();
                // Seleccionar radio button Numero de factura 2
                driver.findElement(By.xpath("//*[@id=\"receiptIndex1\"]")).click();
                Thread.sleep(1000);
                a.ScreenShotPool(driver, i, "screen" + numScreenShoot10, nombreAutomatizacion, folderName);
                Thread.sleep(1000);
                //Seleccionar boton imprimir factura
                driver.findElement(By.xpath("//*[@id=\"idb_040203703_applyPayments_09\"]")).click();
                // Factura
                Thread.sleep(2000);
                a.changeLastWindows(driver);
                Thread.sleep(2000);
                a.ScreenShotPool(driver, i, "screen" + numScreenShoot11, nombreAutomatizacion, folderName);
                Thread.sleep(1000);
                // LA otra pantalla de factura
                Thread.sleep(2000);
                a.changeLastWindows(driver);
                Thread.sleep(2000);
                a.ScreenShotPool(driver, i, "screen" + numScreenShoot12, nombreAutomatizacion, folderName);
                Thread.sleep(1000);
                // cierra la ventana de factura
                driver.close();
            }
            else if(bean.getTipotran().equals("Prima depósito")) {
                driver.findElement(By.xpath("//*[@id=\"idb_040203703_applyPayments_05\"]")).click();
                Thread.sleep(10000);
                a.ScreenShotPool(driver, i, "screen" + numScreenShoot10, nombreAutomatizacion, folderName);
                Thread.sleep(1000);
            }

        } catch (Exception e) {
            e.printStackTrace();
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }

    }
}
