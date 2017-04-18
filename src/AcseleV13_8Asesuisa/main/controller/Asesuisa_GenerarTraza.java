package AcseleV13_8Asesuisa.main.controller;

import AcseleV13_8Asesuisa.main.controller.Asesuisa_Menu.Asesuisa_MenuOperaciones;
import AcseleV13_8Asesuisa.main.controller.Asesuisa_Menu.Asesuisa_MenuMantenimiento;
import AcseleV13_8Asesuisa.beans.Asesuisa_GenerarTrazaBean;
import metodo.Metodos;
import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by aandrade on 29/03/2017.
 */
public class Asesuisa_GenerarTraza {

    private final static Logger log = Logger.getLogger(Asesuisa_GenerarTraza.class);

    public String nombreAutomatizacion = "Generar Traza";
    private WebDriver driver;

    public void testLink(Asesuisa_GenerarTrazaBean bean, int i, String folderName){

        try {

            // Instanciando clases
            Metodos a = new Metodos();
            Asesuisa_MenuOperaciones menuOperaciones = new Asesuisa_MenuOperaciones();
            Asesuisa_MenuMantenimiento menuMantenimiento = new Asesuisa_MenuMantenimiento();

            driver = a.entrarPagina(a.UrlAsesuisa());
            a.IniciarSesion(driver, nombreAutomatizacion, i, folderName);
            a.ValidandoSesion(driver, nombreAutomatizacion, i, folderName);
            Thread.sleep(5000);

            //Entrando en Menu



            menuOperaciones.UAA_Caja_AperturaCaja(driver, nombreAutomatizacion, 2, i, folderName);

            Thread.sleep(2000);
            a.cambiarVentana(driver);
            Thread.sleep(2000);
            AperturarCaja(bean, a, i, folderName, 3, 4, 5, 6, 7);
            Thread.sleep(2000);
            driver.close();
            a.regresarVentana(driver);     //regresar ventana

            menuOperaciones.UAA_Caja_CierreCaja(driver, nombreAutomatizacion, 8, i, folderName);

            Thread.sleep(2000);
            a.cambiarVentana(driver);
            Thread.sleep(2000);

            CerrarCaja(bean, a, i, folderName, 9, 10, 11, 12, 13);
            Thread.sleep(2000);
            driver.close();
            a.regresarVentana(driver);
            driver.findElement(By.xpath("/html/body/table/tbody/tr[4]/td/table/tbody/tr[2]/td[1]/select[1]")).click();



             Thread.sleep(4000);
            menuMantenimiento.Aud_TrazasAuditoriaVaadin(driver, nombreAutomatizacion, 14, i, folderName);

            Thread.sleep(4000);
            a.cambiarVentana(driver);
            Thread.sleep(2000);

            GenerarTraza(bean, a, i, folderName, 15,16,17);

            driver.quit();




        } catch (Exception e) {
            e.printStackTrace();


            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
            if (driver != null){
                driver.quit();
            }
        }
    }

    public void GenerarTraza(Asesuisa_GenerarTrazaBean bean, Metodos a, int i, String folderName, int screen, int screen2, int screen3){

        try {

            Thread.sleep(2000);
            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + screen, nombreAutomatizacion, folderName);
            Thread.sleep(3000);
            if (bean.getTipoTraza() != null) {
                Thread.sleep(1000);
                WebElement tipotraza = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/div/div/div[2]/div/table/tbody/tr[1]/td[3]/div/div/div[1]/div/div/div[3]/div/div"));
                tipotraza.click();
                WebElement selectTipoTraza = null;

                for (int j = 1; j < 11; j++) {
                    Thread.sleep(1000);
                  //  selectTipoTraza = driver.findElement(By.xpath("//*[@id=\"VAADIN_COMBOBOX_OPTIONLIST\"]/div/div[2]/table/tbody/tr[" + j + "]/td"));
                    selectTipoTraza = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[2]/table/tbody/tr["+ j + "]/td"));

                    System.out.println("Elemento recorrido: " + selectTipoTraza.getText());

                    if (selectTipoTraza.getText().toLowerCase().equals(bean.getTipoTraza().toLowerCase())) {
                      //  if (selectTipoTraza.getText().equals("Caja")){
                        Thread.sleep(1000);
                        selectTipoTraza.click();
                        System.out.println("Seleccionò caja");
                        break;
                    }

                }

            }


            if (bean.getCategoria_Traza() != null) {
                Thread.sleep(1000);
                WebElement categoriatraza = driver.findElement(By.xpath("//*[@id=\"item\"]/div"));
                categoriatraza.click();
                WebElement selectCategoria = null;


                for (int h = 1; h < 11; h++) {
                    Thread.sleep(1000);
                    selectCategoria = driver.findElement(By.xpath("//*[@id=\"VAADIN_COMBOBOX_OPTIONLIST\"]/div/div[2]/table/tbody/tr["+ h +"]/td"));
                    System.out.println("Categoria recorrida: " + selectCategoria.getText());

                    if (selectCategoria.getText().toLowerCase().equals(bean.getCategoria_Traza().toLowerCase())) {
                      //  if (selectCategoria.getText().equals("Apertura de Caja")){
                        Thread.sleep(1000);
                        selectCategoria.click();
                        break;
                    }
                }

            }

            if (bean.getDesde() != null) {
                WebElement desde = driver.findElement(By.xpath("//*[@id=\"startEventDate\"]/input"));
                desde.click();
                desde.sendKeys(bean.getDesde());
                Thread.sleep(500);
            }

            if (bean.getHasta() != null) {
                WebElement hasta = driver.findElement(By.xpath("//*[@id=\"endEventDate\"]/input"));
                hasta.click();
                hasta.sendKeys(bean.getHasta());
                Thread.sleep(500);
            }

            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + screen, nombreAutomatizacion, folderName);
            Thread.sleep(1000);
            WebElement btnBuscar = driver.findElement(By.xpath("//*[@id=\"horizontalButton\"]/div/div/div/span/span"));
            btnBuscar.click();
            Thread.sleep(2000);
            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + screen3, nombreAutomatizacion, folderName);
            Thread.sleep(1000);

           // hacer lo del scroll
        } catch (Exception e) {
            e.printStackTrace();
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }

    }
    public void AperturarCaja(Asesuisa_GenerarTrazaBean bean, Metodos a, int i, String folderName, int numScreenShoot, int numScreenShoot2, int numScreenShoot3, int numScreenShoot4, int numScreenShoot5){

        try {

            String mensaje = driver.findElement(By.xpath("/html/body/center/form/table/tbody/tr[4]/td[2]")).getText();

            // Si no permite aperturar caja
            if (!mensaje.substring(0,2).equals("--")){

                // Captura la pantalla con el mensaje de informacion
                Thread.sleep(1000);
                a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion, folderName);
                Thread.sleep(1000);
                System.out.println(mensaje);
            }
            // Si se seleccionan todos los campos solicitados: numero de caja
            else if(bean.getNrocaja() != null){

                Thread.sleep(1000);
                Select nrocaja = new Select(driver.findElement(By.xpath("//select[@name='cashierRegisterID']")));
                nrocaja.selectByValue(bean.getNrocaja());

                Thread.sleep(1000);
                a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion, folderName);
                Thread.sleep(1000);

                driver.findElement(By.xpath("//input[@value='Aceptar']")).click();

                // Mensajes de Resultado de la operacion
                Thread.sleep(1000);
                a.ScreenShotPool(driver, i, "screen" + numScreenShoot2, nombreAutomatizacion, folderName);
                Thread.sleep(1000);

            }
            // Si no se selecciona el campo: Nro. de caja
            else if (bean.getNrocaja() == null){

                Thread.sleep(1000);
                a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion, folderName);
                Thread.sleep(1000);

                driver.findElement(By.xpath("//input[@value='Aceptar']")).click();

                // Mensajes de Alerta JavaScript
                if (ExpectedConditions.alertIsPresent() != null) {
                    Thread.sleep(1000);
                    Alert alert = driver.switchTo().alert();
                    String alertmess = alert.getText();
                    alert.accept();
                    System.out.println(alertmess);
                    Thread.sleep(1000);
                    driver.switchTo().defaultContent();
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }

    }


    public void CerrarCaja(Asesuisa_GenerarTrazaBean bean, Metodos a, int i, String folderName, int numScreenShoot, int numScreenShoot2, int numScreenShoot3, int numScreenShoot4, int numScreenShoot5){

        try {

            String mensaje = driver.findElement(By.xpath("/html/body/center/form/table/tbody/tr[3]/td[2]")).getText();

            // Si no permite aperturar caja
            if (!mensaje.substring(0,2).equals("--")){

                // Captura la pantalla con el mensaje de informacion
                Thread.sleep(1000);
                a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion, folderName);
                Thread.sleep(1000);
                System.out.println(mensaje);
            }
            // Si se seleccionan todos los campos solicitados: numero de caja
            else if(bean.getNrocaja() != null){

                Thread.sleep(1000);
                Select nrocaja = new Select(driver.findElement(By.xpath("//select[@name='cashierRegisterID']")));
                nrocaja.selectByValue(bean.getNrocaja());

                Thread.sleep(1000);
                a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion, folderName);
                Thread.sleep(1000);

                driver.findElement(By.xpath("//input[@value='Aceptar']")).click();

                // Mensajes de Resultado de la operacion
                Thread.sleep(1000);
                a.ScreenShotPool(driver, i, "screen" + numScreenShoot2, nombreAutomatizacion, folderName);
                Thread.sleep(1000);

            }
            // Si no se selecciona el campo: Nro. de caja
            else if (bean.getNrocaja() == null){

                Thread.sleep(1000);
                a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion, folderName);
                Thread.sleep(1000);

                driver.findElement(By.xpath("//input[@value='Aceptar']")).click();

                // Mensajes de Alerta JavaScript
                if (ExpectedConditions.alertIsPresent() != null) {
                    Thread.sleep(1000);
                    Alert alert = driver.switchTo().alert();
                    String alertmess = alert.getText();
                    alert.accept();
                    System.out.println(alertmess);
                    Thread.sleep(1000);
                    driver.switchTo().defaultContent();
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }

    }


}
