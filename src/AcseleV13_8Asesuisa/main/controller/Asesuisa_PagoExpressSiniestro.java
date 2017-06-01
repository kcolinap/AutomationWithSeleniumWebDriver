package AcseleV13_8Asesuisa.main.controller;

import AcseleV13_8Asesuisa.beans.Asesuisa_PagoExpressSiniestroBean;
import AcseleV13_8Asesuisa.main.controller.Asesuisa_Menu.Asesuisa_MenuConfiguracion;
import AcseleV13_8Asesuisa.main.controller.Asesuisa_Menu.Asesuisa_MenuOperaciones;
import metodo.Metodos;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.io.IOException;

/**
 * Created by cortiz on 26/05/2017.
 */
public class Asesuisa_PagoExpressSiniestro {
    private final static Logger log = Logger.getLogger(Asesuisa_PagoExpressSiniestro.class);

    public String nombreAutomatizacion = "PagoExpressSiniestro";
    private WebDriver driver;
    private int pagexitoso;
    Metodos m = new Metodos();

    public void testLink(Asesuisa_PagoExpressSiniestroBean bean, int i, String folderName){
        try {

            Asesuisa_MenuConfiguracion menuConfiguacion = new Asesuisa_MenuConfiguracion();
            Asesuisa_MenuOperaciones menuOperacion = new Asesuisa_MenuOperaciones();

            driver= m.entrarPagina(m.UrlAsesuisa());
            m.IniciarSesion(driver,nombreAutomatizacion,i,folderName);
            m.ValidandoSesion(driver,nombreAutomatizacion,i,folderName);
            Thread.sleep(3000);

            //Entrando en Menu
            //Ingreso a la opcion Configuracion
            menuConfiguacion.MantenimientoProducto(driver, nombreAutomatizacion, 2);

            Thread.sleep(2000);
            m.cambiarVentana(driver);
            Thread.sleep(2000);

            ConfigurarPagoSiniestro(bean, m, i, folderName, 3,4,5,6,7,8);
            Thread.sleep(2000);
            driver.close();
            m.regresarVentana(driver);     //regresar ventana

            //Entrando en Menu
            //Ingreso a la opcion Mantenimiento siniestros
            menuOperacion.OpeSini_MantenimientoSiniestro(driver, nombreAutomatizacion, 4, i, folderName);
            Thread.sleep(1500);
            m.cambiarVentana(driver);

            BusquedaSiniestro(bean, m, i, folderName, 9, 10, 11, 12, 13, 14, 15, 16, 17);
            PagoExpressSiniestro(bean, m, i, folderName, 18,19,20,21,22,23,24);

            Thread.sleep(1000);
            driver.quit();
        }catch (Exception e){
            e.printStackTrace();
            log.error("Test Case - " + nombreAutomatizacion + " - " + e);
            try {
                m.ScreenShotPool(driver, i, "error Test Link", nombreAutomatizacion, folderName);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            if (driver != null){
                driver.quit();
            }
        }
    }


   public void ConfigurarPagoSiniestro(Asesuisa_PagoExpressSiniestroBean bean, Metodos a, int i, String folderName, int numScreenShoot, int numScreenShoot2
           , int numScreenShoot3, int numScreenShoot4, int numScreenShoot5, int numScreenShoot6){

       try {
           JavascriptExecutor jse = (JavascriptExecutor) driver;
           Thread.sleep(4000);
           WebElement jerarquia = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div/div/div[2]/div/div/div/div/div/div/div/div/div/div/ul/li/ul/li[3]/div/a/span"));
           jerarquia.click();
           Thread.sleep(2000);
           Thread.sleep(1000);
           a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion, folderName);
           Thread.sleep(1000);
           WebElement producto = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div/div/div[1]/div[1]/ul/li[2]/a[2]/em/span/span"));
           producto.click();
           Thread.sleep(2000);
           WebElement despliegueProducto = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div/div/div[2]/div/div[2]/div/div/div[1]/div/div/div/div/div/ul/li/div/img[1]"));
           despliegueProducto.click();
           Thread.sleep(1000);
           WebElement subProducto = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div/div/div[2]/div/div[2]/div/div/div[1]/div/div/div/div/div/ul/li/ul/li/div/img[1]"));
           subProducto.click();
           Thread.sleep(1000);
           WebElement planes = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div/div/div[2]/div/div[2]/div/div/div[1]/div/div/div/div/div/ul/li/ul/li/ul/li[3]/div/img[1]"));
           planes.click();
           Thread.sleep(1000);
           WebElement subPlanes = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div/div/div[2]/div/div[2]/div/div/div[1]/div/div/div/div/div/ul/li/ul/li/ul/li[3]/ul/li/div/img[1]"));
           subPlanes.click();
           Thread.sleep(1000);
           WebElement objetosAsegurados = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div/div/div[2]/div/div[2]/div/div/div[1]/div/div/div/div/div/ul/li/ul/li/ul/li[3]/ul/li/ul/li/div/img[1]"));
           objetosAsegurados.click();

           Thread.sleep(1000);
           WebElement suObAsegurados = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div/div/div[2]/div/div[2]/div/div/div[1]/div/div/div/div/div/ul/li/ul/li/ul/li[3]/ul/li/ul/li/ul/li/div/img[1]"));
           suObAsegurados.click();

           Thread.sleep(1000);
           WebElement coberturas = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div/div/div[2]/div/div[2]/div/div/div[1]/div/div/div/div/div/ul/li/ul/li/ul/li[3]/ul/li/ul/li/ul/li/ul/li/div/img[1]"));
           coberturas.click();

           Thread.sleep(1000);
           WebElement basicoVida = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div/div/div[2]/div/div[2]/div/div/div[1]/div/div/div/div/div/ul/li/ul/li/ul/li[3]/ul/li/ul/li/ul/li/ul/li/ul/li[1]/div/a/span"));
           basicoVida.click();
           Thread.sleep(1000);
           a.ScreenShotPool(driver, i, "screen" + numScreenShoot2, nombreAutomatizacion, folderName);
           Thread.sleep(1000);

           Thread.sleep(1000);
           WebElement confCobertura = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div/table[2]/tbody/tr[2]/td/div/div/div/div/div/div/table/tbody/tr[10]/td/div/div/div/img"));
           confCobertura.click();

           Thread.sleep(1000);
           a.ScreenShotPool(driver, i, "screen" + numScreenShoot3, nombreAutomatizacion, folderName);
           Thread.sleep(1000);

           WebElement cuadroDialogo = driver.findElement(By.xpath("//*[@id=\"isc_C\"]\n"));
           cuadroDialogo.click();

           Thread.sleep(1000);

           driver.switchTo().frame("isc_2");

           WebElement montoBeneficio = driver.findElement(By.xpath("/html/body/center/form/table[3]/tbody/tr[3]/td[3]/input"));
           montoBeneficio.click();
           Thread.sleep(1000);
           a.ScreenShotPool(driver, i, "screen" + numScreenShoot4, nombreAutomatizacion, folderName);
           Thread.sleep(1000);

           WebElement pagoExp = driver.findElement(By.xpath("/html/body/center/form/table[3]/tbody/tr[55]/td[1]/input"));

           if (pagoExp.isSelected()) {

               System.out.println("El pago express ya esta seleccionado");

           } else {
               pagoExp.click();
               Thread.sleep(1000);
               a.ScreenShotPool(driver, i, "screen" + numScreenShoot5, nombreAutomatizacion, folderName);
               Thread.sleep(1000);
           }

           Thread.sleep(2000);
           WebElement btnsalvar = driver.findElement(By.xpath("//*[@id=\"idb_0402006_ClaimsCoverageConfiguration_06\"]"));
           btnsalvar.click();
           Thread.sleep(1000);
           a.ScreenShotPool(driver, i, "screen" + numScreenShoot6, nombreAutomatizacion, folderName);
           Thread.sleep(1000);

           driver.switchTo().defaultContent();

       }catch (Exception e) {
           e.printStackTrace();
           log.error("Test Case - " + nombreAutomatizacion + " - " + e);
           try {
               m.ScreenShotPool(driver, i, "error Configurando Pago Express", nombreAutomatizacion, folderName);
           } catch (InterruptedException e1) {
               e1.printStackTrace();
           } catch (IOException e1) {
               e1.printStackTrace();
           }
       }

    }

    public void BusquedaSiniestro(Asesuisa_PagoExpressSiniestroBean bean, Metodos a, int i, String folderName, int numScreenShoot, int numScreenShoot2, int numScreenShoot3, int numScreenShoot4, int numScreenShot5,
                                  int numScreenShoot6, int numScreenShoot7, int numScreenShoot8, int numScreenShoot9){


     salida:    try {

            Thread.sleep(2000);
            JavascriptExecutor jse = (JavascriptExecutor) driver;

             Thread.sleep(1000);
             a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion, folderName);
             Thread.sleep(1000);

             if (bean.getNSINIESTRO() != null) {
                 Thread.sleep(6000);
                 WebElement nsiniestro = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/div[5]/div/div/div/div[3]/input"));
                 driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/div[5]/div/div/div/div[3]/input")).sendKeys(bean.getNSINIESTRO());
                 Thread.sleep(1000);
             }

            if (bean.getPRODUCTO() != null) {
                Thread.sleep(1000);
                WebElement tipoProducto = driver.findElement(By.xpath("//*[@id=\"comboProductoSimpleSearch\"]/div"));
                tipoProducto.click();
                    WebElement selectTipoProducto = null;

                    for (int j = 1; j < 11; j++) {
                        Thread.sleep(1000);
                        selectTipoProducto = driver.findElement(By.xpath("//*[@id=\"VAADIN_COMBOBOX_OPTIONLIST\"]/div/div[2]/table/tbody/tr[" + j + "]/td"));


                        System.out.println("Elemento recorrido: " + selectTipoProducto.getText());

                        if (selectTipoProducto.getText().toLowerCase().equals(bean.getPRODUCTO().toLowerCase())) {

                            Thread.sleep(1000);
                            selectTipoProducto.click();
                            break;
                        }

                    }


            }

            //Boton buscar
            WebElement buscar = driver.findElement(By.xpath("/*//*[@id=\"buttonBuscar\"]"));
            buscar.click();

            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot2, nombreAutomatizacion, folderName);
            Thread.sleep(1000);

            //seleccionar siniestro encontrado

             if (bean.getPRODUCTO() != null) {
                 Thread.sleep(2000);
             //To locate table.
             WebElement mytable = driver.findElement(By.xpath("//*[@id=\"layoutResultTable\"]/div[1]/div/div[3]/div[1]/table/tbody"));

             //To locate rows of table.
             List<WebElement> rows_table = mytable.findElements(By.tagName("tr"));
             //To calculate no of rows In table.
             int rows_count = rows_table.size();

             System.out.println("Cantidad de filas " + rows_count);

             for (int j = 1; j < rows_count; j++) {

                 Thread.sleep(1000);
                 WebElement sencontrado = driver.findElement(By.xpath("//*[@id=\"layoutResultTable\"]/div[1]/div/div[3]/div[1]/table/tbody/tr[" + j +"]/td[3]/div"));
                 WebElement estadoSin =   driver.findElement(By.xpath("//*[@id=\"layoutResultTable\"]/div[1]/div/div[3]/div[1]/table/tbody/tr[" + j +"]/td[3]/div"));// estado del siniestro
                 if ((estadoSin.getText().equals("Abierto")  || (estadoSin.getText().equals("Reabierto")))) {
                 sencontrado.click();
                  Thread.sleep(1000);
             a.ScreenShotPool(driver, i, "screen" + numScreenShoot3, nombreAutomatizacion, folderName);
             Thread.sleep(1000);
            WebElement ok = driver.findElement(By.xpath("//*[@id=\"buttonOk\"]"));
            ok.click();

            Thread.sleep(3000);
            a.changeLastWindows(driver);
            Thread.sleep(2000);
             this.PagoExpressSiniestro(bean, m, i, folderName, 18, 19, 20, 21, 22, 23,24);
                     Thread.sleep(2000);
                     driver.close();
                     m.regresarVentana(driver);
              if (pagexitoso == 1){
                 break;
              }
              }

             }

             }

             //seleccionar siniestro encontrado
             Thread.sleep(4000);

             WebElement sencontrado = driver.findElement(By.xpath("/*//*[@id=\"layoutResultTable\"]/div[1]/div/div[3]/div[1]/table/tbody/tr[1]/td[2]/div"));
             sencontrado.click();

         Thread.sleep(1000);
             a.ScreenShotPool(driver, i, "screen" + numScreenShoot3, nombreAutomatizacion, folderName);
             Thread.sleep(1000);
            WebElement ok = driver.findElement(By.xpath("//*[@id=\"buttonOk\"]"));
            ok.click();

            Thread.sleep(3000);
            a.changeLastWindows(driver);
            Thread.sleep(2000);






            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot4, nombreAutomatizacion, folderName);
            Thread.sleep(1000);





        }catch (Exception e) {
            e.printStackTrace();
            log.error("Test Case - " + nombreAutomatizacion + " - " + e);
         try {
             m.ScreenShotPool(driver, i, "error Buscando Siniestro", nombreAutomatizacion, folderName);
         } catch (InterruptedException e1) {
             e1.printStackTrace();
         } catch (IOException e1) {
             e1.printStackTrace();
         }
        }
    }

    public void PagoExpressSiniestro(Asesuisa_PagoExpressSiniestroBean bean, Metodos a, int i, String folderName, int numScreenShoot
            , int numScreenShoot2, int numScreenShoot3, int numScreenShoot4, int numScreenShoot5, int numScreenShoot6, int numScreenShoot7)
    {
        salida:  try {

            double dmontoReserva,montoxml;
            JavascriptExecutor jse = (JavascriptExecutor)driver;

            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            //Evaluo si hay Objeto Afectado agregado

            WebElement montoReserva = driver.findElement(By.xpath("//*[@id=\"remainingReserveAmount\"]"));

            if (montoReserva.getText().equals("0.00")){
                System.out.println("\"Se completo el pago de la reserva. No se pueden generar mas ordenes\"");
                break salida;
            } else  {

            if ((driver.findElements(By.xpath("//*[@id=\"ioID\"]")).size()==0)){
                System.out.println("No se ha agregado Objeto afectado. No se puede continuar con la operacion");
                break salida;
            }

            //Evaluo si hay Cobertura agregada

           /* if ((driver.findElements(By.xpath("/*//*[@id=\"coverageId\"]")).size()==0)){
                System.out.println("No se ha agregado Cobertura. No se puede continuar con la operacion");
                break salida;
            }*/

            WebElement cobertura = driver.findElement(By.xpath("//*[@id=\"coverageSelect\"]/option"));
            Thread.sleep(1000);
            cobertura.click();

            Thread.sleep(2000);

            WebElement btnPagos = driver.findElement(By.xpath("//*[@id=\"idb_0402006_structure_09\"]"));
            Thread.sleep(1000);
            btnPagos.click();

            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion, folderName);
            Thread.sleep(1000);

          jse.executeScript("window.scrollBy(0,200)", "");


            Thread.sleep(5000);
            jse.executeScript("window.scrollBy(0,200)", "");

                WebElement btnTerPoliza = driver.findElement(By.xpath("//*[@id=\"idb_0402006_generateClaimPayment_04\"]"));
                btnTerPoliza.click();


            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot2, nombreAutomatizacion, folderName);
            Thread.sleep(1000);



            Thread.sleep(2000);

            WebElement tercero = driver.findElement(By.xpath("/html/body/div[14]/div[2]/table[2]/tbody/tr[4]/td[1]/input"));
            tercero.click();

            jse.executeScript("window.scrollBy(0,200)", "");


            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot3, nombreAutomatizacion, folderName);
            Thread.sleep(1000);

            WebElement btnenviar = driver.findElement(By.xpath("//*[@id=\"idb_0402006_resultClaimThirdParty_01\"]"));
            btnenviar.click();

            jse.executeScript("window.scrollBy(0,200)", "");

            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot4, nombreAutomatizacion, folderName);
            Thread.sleep(1000);

            Thread.sleep(2000);

            //To locate table.
            WebElement mytable = driver.findElement(By.xpath("//*[@id=\"paymentTable\"]/tbody"));

            //To locate rows of table.
            List<WebElement> rows_table = mytable.findElements(By.tagName("tr"));
            //To calculate no of rows In table.
            int rows_count = rows_table.size();

            System.out.println("Cantidad de filas" + rows_count);


            WebElement btneditar = driver.findElement(By.xpath("//*[@id=\"paymentTable\"]/tbody/tr[" + rows_count + "]/td[1]/input[2]"));
            btneditar.click();

            Thread.sleep(4000);

                WebElement fecInicial = driver.findElement(By.xpath("/html/body/div[14]/div[2]/form/table/tbody/tr[4]/td[5]/input[2]"));

            jse.executeScript("window.scrollBy(0,200)", "");

            WebElement fecCompromiso = driver.findElement(By.xpath("/html/body/div[14]/div[2]/form/table/tbody/tr[4]/td[4]/input[2]"));
            fecCompromiso.sendKeys(Keys.chord(Keys.CONTROL, "a"));
            fecCompromiso.sendKeys(fecInicial.getText());

            WebElement pagoExpress = driver.findElement(By.xpath("//*[@id=\"idTablePayments\"]/tbody/tr[1]/td[1]/input[2]"));
            pagoExpress.click();

            if (bean.getRAZON()  != null) {
                Thread.sleep(1000);
            WebElement razon = driver.findElement(By.xpath("//*[@id=\"idTablePayments\"]/tbody/tr[4]/td[11]/textarea"));
                razon.clear();
                razon.sendKeys(bean.getRAZON());
            }

            if (bean.getMONTO()  != null) {
                Thread.sleep(1000);
                WebElement monto = driver.findElement(By.xpath("//*[@id=\"amount1\"]"));
                monto.sendKeys(Keys.chord(Keys.CONTROL, "a"));
                monto.sendKeys(bean.getMONTO());
                Thread.sleep(1000);
            }

            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot5, nombreAutomatizacion, folderName);
            Thread.sleep(1000);

            Thread.sleep(2000);
            WebElement btnEnviar = driver.findElement(By.xpath("//*[@id=\"idb_0402006_claimPaymentDetail_01\"]"));
                Thread.sleep(1000);
            btnEnviar.click();

                a.alertJavaScriptAceptar(driver);
                if (bean.getACCION().equals("5")) {
                    break salida;
                }

 /*               dmontoReserva =   Double.parseDouble(montoReserva.getText());
                montoxml = Double.parseDouble(bean.getMONTO());*/

          //  if   (montoxml> dmontoReserva) {
                if   (bean.getMONTO().equals("1000000")) {
                WebElement valmonto = driver.findElement(By.xpath("//*[@id=\"idTablePayments\"]/tbody/tr[14]/td/font/ul/li"));

                if (valmonto.getText().equals("El monto total a ser pagado no puede ser mayor a la reserva")) {
                    jse.executeScript("window.scrollBy(0,400)", "");
                    System.out.println("El monto total a ser pagado no puede ser mayor a la reserva");
                    Thread.sleep(1000);
                    a.ScreenShotPool(driver, i, "screen" + numScreenShoot7, nombreAutomatizacion, folderName);
                    Thread.sleep(1000);
                    Assert.assertEquals("El monto total a ser pagado no puede ser mayor a la reserva", valmonto.getText());
                    break salida;
                } else {

                    System.out.println("NO valida monto total a ser pagado no puede ser mayor a la reserva! failed");
                    break salida;
                }
            }


            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot6, nombreAutomatizacion, folderName);
            Thread.sleep(1000);

            jse.executeScript("window.scrollBy(0,500)", "");

            Thread.sleep(5000);

            WebElement estadoPago = driver.findElement(By.xpath("//*[@id=\"statusMessage\"]"));
                estadoPago.click();

            if (estadoPago.getText().equals("Pagado")) {

                System.out.println("El pago fue exitoso");
                pagexitoso = 1;
            } else {
                Thread.sleep(1000);
                System.out.println("Pago Fallido! failed");
                break salida ;
            }
            }

        }catch (Exception e) {
            e.printStackTrace();
            log.error("Test Case - " + nombreAutomatizacion + " - " + e);
            try {
                m.ScreenShotPool(driver, i, "error Pagando Siniestro", nombreAutomatizacion, folderName);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

}
