package AcseleV13_8Asesuisa.main.controller;

import AcseleV13_8Asesuisa.beans.Asesuisa_AjusteReservaSiniestroBean;
import AcseleV13_8Asesuisa.beans.Asesuisa_ManteSiniestroBean;
import AcseleV13_8Asesuisa.main.controller.Asesuisa_Menu.Asesuisa_MenuOperaciones;
import metodo.Metodos;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.geom.Arc2D;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * Created by cortiz on 12/05/2017.
 */
public class ASesuisa_AjusteReservaSiniestro {

    private final static Logger log = Logger.getLogger(Asesuisa_ManteSiniestro.class);

    public String nombreAutomatizacion = "Asesuisa Ajuste Reserva de siniestro";
    private WebDriver driver;



    public void testLink(Asesuisa_AjusteReservaSiniestroBean bean, int i, String folderName){

        try {

            // Instanciando clases
            Metodos a = new Metodos();
            Asesuisa_MenuOperaciones menuOperaciones = new Asesuisa_MenuOperaciones();


            driver = a.entrarPagina(a.UrlAsesuisa());
            a.IniciarSesion(driver, nombreAutomatizacion, i, folderName);
            a.ValidandoSesion(driver, nombreAutomatizacion, i, folderName);
            Thread.sleep(5000);

            //Entrando en Menu
            //Ingreso a la opcion Mantenimiento siniestros
            menuOperaciones.OpeSini_MantenimientoSiniestro(driver, nombreAutomatizacion, 2, i, folderName);

            Thread.sleep(2000);
            a.cambiarVentana(driver);
            Thread.sleep(2000);

            BusquedaT(bean, a, i, folderName, 3,4,5,6,7,8,9,10,11);
            AjusteReserva(bean, a, i, folderName, 12,13,14,15);

            Thread.sleep(3000);


            driver.quit();

        } catch (Exception e) {
                e.printStackTrace();
                log.info("Test Case - " + nombreAutomatizacion + " - " + e);
                if (driver != null) {
                    driver.quit();
                }

    }
}

    public void BusquedaT(Asesuisa_AjusteReservaSiniestroBean bean, Metodos a, int i, String folderName, int numScreenShoot, int numScreenShoot2, int numScreenShoot3, int numScreenShoot4, int numScreenShot5,
                          int numScreenShoot6, int numScreenShoot7, int numScreenShoot8, int numScreenShoot9) {



        salida:   try {


            JavascriptExecutor jse = (JavascriptExecutor) driver;


            if (bean.getNSINIESTRO() != null) {
                Thread.sleep(3000);
                WebElement nsiniestro = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/div[5]/div/div/div/div[3]/input"));
                driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/div[5]/div/div/div/div[3]/input")).sendKeys(bean.getNSINIESTRO());
                Thread.sleep(1000);
            }

            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion, folderName);
            Thread.sleep(1000);


            //Boton buscar
            WebElement buscar = driver.findElement(By.xpath("//*[@id=\"buttonBuscar\"]"));
            buscar.click();


            //seleccionar siniestro encontrado
            Thread.sleep(4000);
            WebElement sencontrado = driver.findElement(By.xpath("//*[@id=\"layoutResultTable\"]/div[1]/div/div[3]/div[1]/table/tbody/tr[1]/td[2]/div"));
            sencontrado.click();


            Thread.sleep(2000);
            WebElement ok = driver.findElement(By.xpath("//*[@id=\"buttonOk\"]/span"));
            ok.click();

            /////
            Thread.sleep(4000);
            a.changeLastWindows(driver);
            Thread.sleep(2000);

           /* WebDriverWait wait = new WebDriverWait(driver, 5);
            wait.until(ExpectedConditions.alertIsPresent());*/

            a.alertJavaScriptAceptar(driver);


            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot3, nombreAutomatizacion, folderName);
            Thread.sleep(1000);


        } catch (Exception e) {
            e.printStackTrace();
            log.error("Test Case - " + nombreAutomatizacion + " - " + e);
        }
}

    public void AjusteReserva(Asesuisa_AjusteReservaSiniestroBean bean, Metodos a, int i, String folderName, int numScreenShoot,
                              int numScreenShoot2, int numScreenShoot3, int numScreenShoot4){

        try {
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            double numero,nreserva,dmontoAjuste,resta;

            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS) ;

            Thread.sleep(2000);
            WebElement cobertura = driver.findElement(By.xpath("//*[@id=\"coverageSelect\"]/option"));
            cobertura.click();
            Thread.sleep(1000);
            cobertura = driver.findElement(By.xpath("//*[@id=\"coverageSelect\"]/option"));
            cobertura.click();

            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion, folderName);
            Thread.sleep(1000);

            Thread.sleep(2000);
            WebElement btnreserva = driver.findElement(By.xpath("//*[@id=\"idb_0402006_structure_08\"]"));
            btnreserva.click();
            Thread.sleep(1000);
            btnreserva = driver.findElement(By.xpath("//*[@id=\"idb_0402006_structure_08\"]"));
            btnreserva.click();
            Thread.sleep(2000);
            jse.executeScript("window.scrollBy(0,500)", "");

            /*WebElement montopago = driver.findElement(By.xpath("/*//*[@id=\"paidAmmount\"]"));
            String     montopagostr = montopago.getText();
            numero = Double.parseDouble(montopagostr);*/
            Thread.sleep(4000);

           /* WebElement etiqueta = driver.findElement(By.xpath("/html/body/div[14]/div[2]/form/table/tbody[3]/tr[4]/td[1]/b/font"));
            etiqueta.click();*/
            WebElement aajuste = driver.findElement(By.xpath("//*[@id=\"idb_0402006_editReverse_02\"]"));
            aajuste.click();
            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot2, nombreAutomatizacion, folderName);
            Thread.sleep(1000);

            //To locate table.
            WebElement mytable = driver.findElement(By.xpath("/html/body/div[14]/div[2]/form/table/tbody[3]"));

            //To locate rows of table.
            java.util.List<WebElement> rows_table = mytable.findElements(By.tagName("tr"));
            //To calculate no of rows In table.
            int rows_count = rows_table.size() - 4 ;

            System.out.println("Cantidad de filas con mismo nombre " + rows_count);

            jse.executeScript("window.scrollBy(0,500)", "");
            Select tajuste = new Select(driver.findElement(By.xpath("/html/body/div[14]/div[2]/form/table/tbody[3]/tr[" + rows_count + "]/td[1]/select")));
            tajuste.selectByValue(bean.getTipoajuste());
            jse.executeScript("window.scrollBy(0,500)", "");

            Thread.sleep(1000);
            WebElement razonAjuste = driver.findElement(By.xpath("/html/body/div[14]/div[2]/form/table/tbody[3]/tr[" + rows_count + "]/td[5]/textarea"));
            razonAjuste.sendKeys(bean.getRAZONAJUSTE());

            Thread.sleep(2000);
            WebElement montoAjuste = driver.findElement(By.xpath("/html/body/div[14]/div[2]/form/table/tbody[3]/tr[" + rows_count + "]/td[6]/input[1]"));
            montoAjuste.sendKeys(Keys.chord(Keys.CONTROL, "a"));
            montoAjuste = driver.findElement(By.xpath("/html/body/div[14]/div[2]/form/table/tbody[3]/tr[" + rows_count + "]/td[6]/input[1]"));
            montoAjuste.sendKeys(bean.getMontosini());
           // dmontoAjuste = Double.parseDouble(bean.getMontosini());

            /*WebElement mreserva = driver.findElement(By.xpath("/html/body/div[14]/div[2]/form/table/tbody[3]/tr[3]/td[2]/input[1]"));
            Thread.sleep(2000);*/
           // nreserva = Double.parseDouble(mreserva.getAttribute("value"));
            //nreserva = Double.parseDouble(mreservastr);

           // resta  = nreserva - dmontoAjuste;

          // System.out.println("Monto de reserva" +  resta );

            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot3, nombreAutomatizacion, folderName);
            Thread.sleep(1000);

            Thread.sleep(1000);
            WebElement btnenviar = driver.findElement(By.xpath("//*[@id=\"idb_0402006_editReverse_03\"]"));
            btnenviar.click();

            /*if (resta < numero){

                if(a.isAlertPresent(driver)){
                    Alert alert = driver.switchTo().alert();
                    String alertmess = alert.getText();
                    alert.accept();
                    System.out.println(alertmess);
                    Assert.assertEquals("La reserva no puede ser menor al monto pagado", alertmess);
                    Thread.sleep(1000);
                    driver.switchTo().defaultContent();
                }
            }*/



            if ((bean.getRAZONAJUSTE().equals("Prueba")) || (bean.getRAZONAJUSTE().equals("Prueba 2"))) {

                WebElement texto = driver.findElement(By.xpath("/html/body/div[14]/div[2]/table[1]/tbody/tr[2]/td"));
                String str = texto.getText();

                if (texto.getText().equals("La reserva fue ajustada exitosamente")){

                    Assert.assertEquals("La reserva fue ajustada exitosamente",str);
                    System.out.println("Ajuste de " + str);
                }

            }
            /*WebDriverWait wait = new WebDriverWait(driver, 5);
            wait.until(ExpectedConditions.alertIsPresent());*/

            if(a.isAlertPresent(driver)){
                Alert alert = driver.switchTo().alert();
                String alertmess = alert.getText();
                alert.accept();
                if (bean.getRAZONAJUSTE().equals("Numero incorrecto")){
                    System.out.println(alertmess);
                    Assert.assertEquals(" Numero incorrecto", alertmess);

                }

                if (bean.getRAZONAJUSTE().equals("El monto cero")){
                    System.out.println(alertmess);
                    Assert.assertEquals("El monto para el ajuste de la reserva debe ser mayor a cero", alertmess);

                }

                if (bean.getRAZONAJUSTE().equals("La reserva no puede ser menor al monto pagado")){
                    System.out.println(alertmess);
                    Assert.assertEquals("La reserva no puede ser menor al monto pagado", alertmess);
                }
                Thread.sleep(1000);
                driver.switchTo().defaultContent();
            }






        } catch (Exception e) {
            e.printStackTrace();
            log.error("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }


}
