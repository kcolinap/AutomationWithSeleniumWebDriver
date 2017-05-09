package AcseleV13_8Asesuisa.main.controller;

import AcseleV13_8Asesuisa.beans.Asesuisa_ManteSiniestroBean;
import AcseleV13_8Asesuisa.main.controller.Asesuisa_Menu.Asesuisa_MenuOperaciones;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import metodo.Metodos;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import java.awt.*;


/**
 * Created by cortiz on 01/04/2017.
 */
public class Asesuisa_ManteSiniestro {

    private final static Logger log = Logger.getLogger(Asesuisa_ManteSiniestro.class);

    public String nombreAutomatizacion = "Asesuisa Mantenimiento de siniestro";
    private WebDriver driver;


    public void testLink(Asesuisa_ManteSiniestroBean bean, int i, String folderName) {

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

    public void BusquedaT(Asesuisa_ManteSiniestroBean bean, Metodos a, int i, String folderName, int numScreenShoot, int numScreenShoot2, int numScreenShoot3, int numScreenShoot4, int numScreenShot5,
                          int numScreenShoot6, int numScreenShoot7, int numScreenShoot8, int numScreenShoot9) {

        int tamano;
        salida:   try {

            Thread.sleep(2000);
            JavascriptExecutor jse = (JavascriptExecutor) driver;



            if (bean.getNSINIESTRO() != null) {
                Thread.sleep(3000);
                WebElement nsiniestro = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/div[5]/div/div/div/div[3]/input"));
                driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/div[5]/div/div/div/div[3]/input")).sendKeys(bean.getNSINIESTRO());
                Thread.sleep(1000);
            }

            if (bean.getFOCURRENCIA() != null) {
                Thread.sleep(3000);
                WebElement focurrencia = driver.findElement(By.xpath("//*[@id=\"dateFieldOccurrenceDate\"]/input"));
                focurrencia.sendKeys(bean.getFOCURRENCIA());
                Thread.sleep(1000);
            }

            if (bean.getPRODUCTO() != null) {
                Thread.sleep(3000);
                WebElement producto = driver.findElement(By.xpath("//*[@id=\"comboProductoSimpleSearch\"]/div"));
                producto.click();
                Thread.sleep(1000);
                WebElement selectProducto = null;
                tamano = driver.findElements(By.xpath("//*[@id=\"VAADIN_COMBOBOX_OPTIONLIST\"]/div/div[2]/table/tbody/tr")).size();
                System.out.println("Tamaño: " + tamano);
                for (int j = 1; j < 10; j++) {
                    Thread.sleep(1000);
                    selectProducto = driver.findElement(By.xpath("//*[@id=\"VAADIN_COMBOBOX_OPTIONLIST\"]/div/div[2]/table/tbody/tr[" + j + "]/td"));
                    System.out.println("Elemento recorrido: " + selectProducto.getText());


                    if (selectProducto.getText().equals(bean.getPRODUCTO())) {

                        Thread.sleep(1000);
                        selectProducto.click();

                        break ;
                    }
                }

            }


            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion, folderName);
            Thread.sleep(1000);


            //Boton buscar
            WebElement buscar = driver.findElement(By.xpath("//*[@id=\"buttonBuscar\"]"));
            buscar.click();

            if (bean.getCCOMENTARIO().equals("caso9")) {
                //CASO 8
                System.out.println("Busqueda por producto");
                Thread.sleep(1000);
                a.ScreenShotPool(driver, i, "screen" + numScreenShoot9, nombreAutomatizacion, folderName);
                Thread.sleep(1000);
                break salida;
            }



                  //CASO 4
            if  ((bean.getNSINIESTRO() == null) && (bean.getNPOLIZA() == null)) {

                Thread.sleep(1000);
                a.ScreenShotPool(driver, i, "screen" + numScreenShot5, nombreAutomatizacion, folderName);
                Thread.sleep(1000);
                WebElement ErrorAceptar = driver.findElement(By.xpath("/*//*[@id=\"layoutButton\"]/div/div/div/span/span"));
                ErrorAceptar.click();
                break salida;
            }

            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot2, nombreAutomatizacion, folderName);
            Thread.sleep(1000);



            if (bean.getCCOMENTARIO().equals("Caso5")){

                System.out.println("Caso 5");

             } else {
                //seleccionar siniestro encontrado
                Thread.sleep(4000);
                WebElement sencontrado = driver.findElement(By.xpath("//*[@id=\"layoutResultTable\"]/div[1]/div/div[3]/div[1]/table/tbody/tr[1]/td[2]/div"));
                sencontrado.click();

            }



            // case 7
            if (bean.getCCOMENTARIO().equals("Exportar")) {
                Thread.sleep(2000);
                WebElement exportar = driver.findElement(By.xpath("//*[@id=\"buttonExport\"]/span/span"));
                exportar.click();

                Thread.sleep(1000);
                a.ScreenShotPool(driver, i, "screen" + numScreenShoot7, nombreAutomatizacion, folderName);
                Thread.sleep(4000);
                WebElement aceptarExp = driver.findElement(By.xpath("//*[@id=\"layoutButton\"]/div/div/div"));
                aceptarExp.click();
                break salida;
            }
                Thread.sleep(2000);
                WebElement ok = driver.findElement(By.xpath("//*[@id=\"buttonOk\"]/span"));
                ok.click();

            if (bean.getCCOMENTARIO().equals("Caso5")) {
                //caso 5
                System.out.println("No selecciono siniestro luego de busqueda");
                Thread.sleep(1000);
                a.ScreenShotPool(driver, i, "screen" + numScreenShoot6, nombreAutomatizacion, folderName);
                Thread.sleep(1000);
                WebElement aceptarError = driver.findElement(By.xpath("//*[@id=\"layoutButton\"]/div/div/div"));
                aceptarError.click();
                break salida;
            }


            /////
            Thread.sleep(6000);
            a.changeLastWindows(driver);
            Thread.sleep(2000);

            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot3, nombreAutomatizacion, folderName);
            Thread.sleep(1000);

            if (bean.getCCOMENTARIO().equals("Siniestro Revisado")) {
                //Boton cerrar
            Thread.sleep(3000);
            WebElement cerrar = driver.findElement(By.xpath("/html/body/div[13]/div[8]/input[2]"));
            cerrar.click();
            }

            if ((bean.getCCOMENTARIO().equals("Siniestro por analisis")) && (bean.getPRODUCTO()) == null) {
           //Boton reabrir
           Thread.sleep(3000);
            WebElement reabrir = driver.findElement(By.xpath("//*[@id=\"idb_0402006_structure_31\"]"));
            reabrir.click();
            Thread.sleep(2000);
            }

            if (bean.getCCOMENTARIO().equals("Siniestro por analisis"))  {
                //Boton reabrir
                Thread.sleep(3000);
                WebElement reabrir = driver.findElement(By.xpath("//*[@id=\"idb_0402006_structure_30\"]"));
                reabrir.click();
                Thread.sleep(2000);
            }

            if (bean.getCCOMENTARIO().equals("Siniestro Rechazado")) {
            //Boton rechazar
            WebElement rechazar = driver.findElement(By.xpath("//*[@id=\"idb_0402006_structure_29\"]"));
            rechazar.click();
            Thread.sleep(2000);
            }


            // Cambiar de frame
            driver.switchTo().frame("plantilla");



            if (bean.getFOPERACION() != null) {
                Thread.sleep(4000);
                WebElement foperacion = driver.findElement(By.xpath("//*[@id=\"OperationDate\"]"));
                foperacion.sendKeys(bean.getFOPERACION());
                Thread.sleep(1000);
            } else {
                System.out.println("Fecha Vacia");

            }



            if (bean.getCCOMENTARIO().equals("Siniestro Revisado")) {
            if (bean.getMRECHAZOCIERRE() != null) {
            Select motivoCierre = new Select(driver.findElement(By.xpath("/*//*[@id=\"ClosingMotive\"]")));
            motivoCierre.selectByValue(bean.getMRECHAZOCIERRE());
            }
            }

            if (bean.getCCOMENTARIO().equals("Siniestro por analisis")) {
           if (bean.getMRECHAZOCIERRE() != null) {
               Select motivoCierre = new Select(driver.findElement(By.xpath("//*[@id=\"ReopeningMotive\"]")));
                motivoCierre.selectByValue(bean.getMRECHAZOCIERRE()); //*[@id="RejectionMotive"]
            }
            }

            if (bean.getCCOMENTARIO().equals("Siniestro Rechazado")) {
            if (bean.getMRECHAZOCIERRE() != null) {
               Select motivoCierre = new Select(driver.findElement(By.xpath("//*[@id=\"RejectionMotive\"]")));
                motivoCierre.selectByValue(bean.getMRECHAZOCIERRE());
            }
            }


            if (bean.getCCOMENTARIO() != null) {
            WebElement comentario = driver.findElement(By.xpath("//*[@id=\"ClaimComments\"]"));
            comentario.sendKeys(bean.getCCOMENTARIO());
            }
            // Salir del frame
            //driver.switchTo().parentFrame();
            driver.switchTo().defaultContent();

            Thread.sleep(3000);
            WebElement btnAceptar2 = driver.findElement(By.xpath("/html/body/div[14]/div[2]/div[4]/input"));
            btnAceptar2.click();
            Thread.sleep(3000);


            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot4, nombreAutomatizacion, folderName);
            Thread.sleep(1000);

        } catch (Exception e) {
            e.printStackTrace();
            log.error("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }





}
