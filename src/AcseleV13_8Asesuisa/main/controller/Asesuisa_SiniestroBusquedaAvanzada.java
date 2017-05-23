package AcseleV13_8Asesuisa.main.controller;

import AcseleV13_8Asesuisa.beans.Asesuisa_SiniestroBusquedaAvanzadaBean;
import AcseleV13_8Asesuisa.main.controller.Asesuisa_Menu.Asesuisa_MenuOperaciones;

import metodo.Metodos;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by kcolina on 18/05/2017.
 */
public class Asesuisa_SiniestroBusquedaAvanzada {

    private final static Logger log = Logger.getLogger(Asesuisa_SiniestroBusquedaAvanzada.class);

    public String nombreAutomatizacion = "Busqueda avanzada de siniestro";
    private WebDriver driver;

    public void TestLink(Asesuisa_SiniestroBusquedaAvanzadaBean bean, int i, String folderName){

        try {

            String idCampo="";
            int nroCampo;
            Metodos m = new Metodos();
            Asesuisa_MenuOperaciones menuOperaciones = new Asesuisa_MenuOperaciones();

            driver = m.entrarPagina(m.UrlAsesuisa());
            m.IniciarSesion(driver, nombreAutomatizacion,i,folderName);
            m.ValidandoSesion(driver, nombreAutomatizacion,i,folderName);
            Thread.sleep(1000);

            //Ingreso a la opcion Mantenimiento de Siniestro
            menuOperaciones.OpeSini_MantenimientoSiniestro(driver, nombreAutomatizacion, 2, i, folderName);
            Thread.sleep(1000);
            m.cambiarVentana(driver);
            Thread.sleep(1000);

            //Evaluo por cual campo se hara la busqueda
            idCampo=bean.getIdCampo();
            Thread.sleep(1000);
            nroCampo = Integer.parseInt(idCampo);

            //Seleccion de opcion busqueda avanzada
            WebElement btnAvanzada;
            btnAvanzada=driver.findElement(By.xpath("html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/div[1]/div/div/div[5]/div/div/div[3]/div/span/span"));
            btnAvanzada.click();
            Thread.sleep(2000);

            //Llamada al metodo BuscarSiniestro
            BuscarSiniestro(driver, bean, m, i, nombreAutomatizacion, folderName, nroCampo);
            Thread.sleep(1500);

            //Salida de la funcionalidad
            driver.quit();

        }catch (Exception e){
            e.printStackTrace();e.printStackTrace();
            log.error("Test Case - " + nombreAutomatizacion + " - " + e);
            if (driver != null) {
                driver.quit();
            }
        }
    }

    public void BuscarSiniestro(WebDriver driver, Asesuisa_SiniestroBusquedaAvanzadaBean bean,
                                Metodos m, int i, String nombreAutomatizacion, String folderName,
                                int idCampo){
        try {

            JavascriptExecutor jse = (JavascriptExecutor)driver;
            WebElement txtCampo;
            switch (idCampo){
                case 1:
                    System.out.println("Busqueda de siniestro por: SUCURSAL");
                    txtCampo=driver.findElement(By.xpath("html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/div[9]/div/div[3]/div/div/div/div/div/div/div[3]/div/input"));
                    txtCampo.sendKeys(bean.getSucursal());
                    Thread.sleep(1000);

                    driver.findElement(By.xpath("html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/div[9]/div/div[3]/div/div/div/div/div/div/div[2]/div")).click();//Hago click en el label del campo para que se quitela sugerencia
                    Thread.sleep(800);

                    //Pantallazo
                    m.ScreenShotPool(driver,i,"Screen3",nombreAutomatizacion,folderName);
                    Thread.sleep(800);

                    //Llamada al metodo ValidarBusqueda
                    ValidarBusqueda(driver, m, i, nombreAutomatizacion, folderName);
                    break;
                case 2:
                    System.out.println("Busqueda de siniestro por: Nro. de Póliza");
                    txtCampo=driver.findElement(By.xpath("html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/div[9]/div/div[3]/div/div/div/div/div/div/div[5]/input"));
                    txtCampo.sendKeys(bean.getNroPoliza());
                    Thread.sleep(1000);

                    driver.findElement(By.xpath("html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/div[9]/div/div[3]/div/div/div/div/div/div/div[4]/div")).click();//Hago click en el label del campo para que se quitela sugerencia
                    Thread.sleep(800);

                    //Pantallazo
                    m.ScreenShotPool(driver,i,"Screen3",nombreAutomatizacion,folderName);
                    Thread.sleep(1000);

                    //Llamada al metodo ValidarBusqueda
                    ValidarBusqueda(driver, m, i, nombreAutomatizacion, folderName);
                    break;
                case 3:
                    System.out.println("Busqueda de siniestro por: Tipo de Póliza");
                    txtCampo=driver.findElement(By.xpath("html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/div[9]/div/div[3]/div/div/div/div/div/div/div[11]/div/input"));
                    txtCampo.sendKeys(bean.getTipoPoliza());
                    Thread.sleep(1000);

                    driver.findElement(By.xpath("html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/div[9]/div/div[3]/div/div/div/div/div/div/div[10]/div")).click();//Hago click en el label del campo para que se quitela sugerencia
                    Thread.sleep(800);

                    //Pantallazo
                    m.ScreenShotPool(driver,i,"Screen3",nombreAutomatizacion,folderName);
                    Thread.sleep(1000);

                    //Llamada al metodo ValidarBusqueda
                    ValidarBusqueda(driver, m, i, nombreAutomatizacion, folderName);
                    break;
                case 4:
                    Thread.sleep(1000);

                    System.out.println("Busqueda de siniestro por: Tercero Natural");
                    driver.findElement(By.xpath("html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/div[13]/div/div[3]/div/div/div/div/div/div/div[3]/div/div")).click();
                    Thread.sleep(1000);

                    driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div[2]/table/tbody/tr[3]/td/span")).click();
                    Thread.sleep(1000);
                    /*txtCampo=driver.findElement(By.xpath("html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/div[13]/div/div[3]/div/div/div/div/div/div/div[3]/div/input"));
                    txtCampo.clear();
                    Thread.sleep(400);*/
                    txtCampo=driver.findElement(By.xpath("html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/div[13]/div/div[3]/div/div/div/div/div/div/div[3]/div/input"));
                    //txtCampo.sendKeys(bean.getTipoTercero());
                    //Thread.sleep(1000);
                    txtCampo.sendKeys(Keys.chord(Keys.TAB));
                    Thread.sleep(900);

                    /*txtCampo=driver.findElement(By.xpath("html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/div[13]/div/div[3]/div/div/div/div/div/div/div[9]/input"));
                    txtCampo.sendKeys(Keys.ARROW_DOWN);
                    txtCampo=driver.findElement(By.xpath("html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/div[13]/div/div[3]/div/div/div/div/div/div/div[37]/input"));
                    txtCampo.sendKeys(Keys.ARROW_DOWN);

                    driver.findElement(By.xpath("html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/div[13]/div/div[3]/div/div/div/div/div/div/div[2]/div")).click();//Hago click en el label del campo para que se quitela sugerencia
                    Thread.sleep(800);*/

                    driver.findElement(By.xpath("html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/div[13]/div/div[3]/div/div/div/div/div/div/div[79]/input")).click();
                    Thread.sleep(800);

                    txtCampo=driver.findElement(By.xpath("html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/div[13]/div/div[3]/div/div/div/div/div/div/div[79]/input"));
                    txtCampo.sendKeys(bean.getCodigoIdentificador());
                    Thread.sleep(1000);

                    driver.findElement(By.xpath("html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/div[13]/div/div[3]/div/div/div/div/div/div/div[78]/div")).click();//Hago click en el label del campo para que se quitela sugerencia
                    Thread.sleep(800);

                    //Pantallazo
                    m.ScreenShotPool(driver,i,"Screen3",nombreAutomatizacion,folderName);
                    Thread.sleep(1000);

                    //Llamada al metodo ValidarBusqueda
                    ValidarBusqueda(driver, m, i, nombreAutomatizacion, folderName);
                    break;
                case 5:
                    Thread.sleep(1000);

                    System.out.println("Busqueda de siniestro por: Tercero Juridico");
                    driver.findElement(By.xpath("html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/div[13]/div/div[3]/div/div/div/div/div/div/div[3]/div/div")).click();
                    Thread.sleep(1000);

                    driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div[2]/table/tbody/tr[2]/td/span")).click();
                    Thread.sleep(1000);
                    /*txtCampo=driver.findElement(By.xpath("html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/div[13]/div/div[3]/div/div/div/div/div/div/div[3]/div/input"));
                    txtCampo.clear();
                    Thread.sleep(400);*/
                    txtCampo=driver.findElement(By.xpath("html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/div[13]/div/div[3]/div/div/div/div/div/div/div[13]/input"));
                    //txtCampo.sendKeys(bean.getTipoTercero());
                    //Thread.sleep(1000);
                    txtCampo.sendKeys(Keys.chord(Keys.TAB));
                    Thread.sleep(900);

                    /*txtCampo=driver.findElement(By.xpath("html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/div[13]/div/div[3]/div/div/div/div/div/div/div[9]/input"));
                    txtCampo.sendKeys(Keys.ARROW_DOWN);
                    txtCampo=driver.findElement(By.xpath("html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/div[13]/div/div[3]/div/div/div/div/div/div/div[37]/input"));
                    txtCampo.sendKeys(Keys.ARROW_DOWN);

                    driver.findElement(By.xpath("html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/div[13]/div/div[3]/div/div/div/div/div/div/div[2]/div")).click();//Hago click en el label del campo para que se quitela sugerencia
                    Thread.sleep(800);*/

                    driver.findElement(By.xpath("html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/div[13]/div/div[3]/div/div/div/div/div/div/div[49]/input")).click();
                    Thread.sleep(800);

                    txtCampo=driver.findElement(By.xpath("html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/div[13]/div/div[3]/div/div/div/div/div/div/div[49]/input"));
                    txtCampo.sendKeys(bean.getCodigoIdentificador());
                    Thread.sleep(1000);

                    driver.findElement(By.xpath("html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/div[13]/div/div[3]/div/div/div/div/div/div/div[48]/div")).click();//Hago click en el label del campo para que se quitela sugerencia
                    Thread.sleep(800);

                    //Pantallazo
                    m.ScreenShotPool(driver,i,"Screen3",nombreAutomatizacion,folderName);
                    Thread.sleep(1000);

                    //Llamada al metodo ValidarBusqueda
                    ValidarBusqueda(driver, m, i, nombreAutomatizacion, folderName);
                    break;
                default:
                    //Pantallazo
                    m.ScreenShotPool(driver,i,"Screen3",nombreAutomatizacion,folderName);
                    Thread.sleep(800);

                    //Llamada al metodo ValidarBusqueda
                    ValidarBusqueda(driver, m, i, nombreAutomatizacion, folderName);
                    break;
            }
        }catch (Exception e){
            e.printStackTrace();e.printStackTrace();
            log.error("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }

    public void ValidarBusqueda(WebDriver driver, Metodos m, int i, String nombreAutomatizacion,
                                String folderName){

        salidaValidar:try {

            WebDriverWait wait = new WebDriverWait(driver, 15);

            //Boton Buscar
            WebElement btnBuscar;
            btnBuscar= driver.findElement(By.xpath("html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/div[23]/div/div/div[3]/div/span"));
            btnBuscar.click();
            Thread.sleep(2000);

            //Evaluo si aparecen mensajes de error
            if (driver.findElements(By.className("v-window-wrap")).size()>0){
                if ( (driver.findElement(By.className("v-window-header")).getText().equals("Mensaje de error"))  &&
                        (driver.findElement(By.xpath("html/body/div[3]/div[5]/div/div/div[5]/div/div/div[1]/div")).getText().equals("Al menos un campo debe estar lleno")) ){
                    System.out.println("Al menos un campo debe estar lleno");

                    //Pantallazo
                    m.ScreenShotPool(driver,i,"screen4",nombreAutomatizacion,folderName);
                    Thread.sleep(800);
                    break salidaValidar;
                }else if ( (driver.findElement(By.className("v-window-header")).getText().equals("Mensaje"))  &&
                        (driver.findElement(By.xpath("html/body/div[3]/div[5]/div/div/div[5]/div/div/div[1]/div")).getText().equals("No se encontró resultados asociados con esta búsqueda")) ){
                    System.out.println("No se encontró resultados asociados con esta búsqueda");

                    //Pantallazo
                    m.ScreenShotPool(driver,i,"screen4",nombreAutomatizacion,folderName);
                    Thread.sleep(1000);
                    break salidaValidar;
                }
            }

            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/div/div/div[3]/div/div[1]")));
            Thread.sleep(1000);

            //Pantallazo
            m.ScreenShotPool(driver,i,"screen4",nombreAutomatizacion,folderName);
            Thread.sleep(800);

            //Evaluo si hay mas de un elemento
            int nroFilas = driver.findElements(By.xpath("html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/div/div/div[3]/div/div[1]/div/div[3]/div[1]/table/tbody/tr")).size();
            WebElement divSiniestro;
            if (nroFilas>1){
                divSiniestro=driver.findElement(By.xpath("html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/div/div/div[3]/div/div[1]/div/div[3]/div[1]/table/tbody/tr[1]/td[1]/div"));
                divSiniestro.click();
                Thread.sleep(800);
            }else{
                divSiniestro=driver.findElement(By.xpath("html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/div/div/div[3]/div/div[1]/div/div[3]/div[1]/table/tbody/tr/td[1]/div"));
                divSiniestro.click();
                Thread.sleep(800);
            }

            //Pantallazo
            m.ScreenShotPool(driver,i,"screen5",nombreAutomatizacion,folderName);
            Thread.sleep(800);

            //Boton OK
            WebElement btnOk;
            btnOk=driver.findElement(By.xpath("html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/div/div/div[5]/div/div/div[1]/div/span"));
            btnOk.click();
            Thread.sleep(2000);

            //Cambio de ventana para que obtenga el foco la ultima
            Thread.sleep(800);
            m.changeLastWindows(driver);
            Thread.sleep(2000);

           // driver.findElement(By.xpath("html/body/div[14]/div[2]/div[1]/center/table/tbody/tr[1]/td[1]/span"));

            //Espero a que se cargue algun elemento de la pantalla siniestro
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("html/body/div[14]/div[2]/div/center/table/tbody/tr[12]/td[3]/a/span")));
            Thread.sleep(1000);

            //Pantallazo
            m.ScreenShotPool(driver,i,"screen6",nombreAutomatizacion,folderName);
            Thread.sleep(800);

        }catch (Exception e){
            e.printStackTrace();e.printStackTrace();
            log.error("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }
}
