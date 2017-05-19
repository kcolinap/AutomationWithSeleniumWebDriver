package AcseleV13_8Asesuisa.main.controller;

import AcseleV13_8Asesuisa.beans.Asesuisa_SiniestroBusquedaSimpleBean;
import AcseleV13_8Asesuisa.main.controller.Asesuisa_Menu.Asesuisa_MenuOperaciones;

import metodo.Metodos;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import sun.awt.windows.ThemeReader;

/**
 * Created by kcolina on 19/05/2017.
 */
public class Asesuisa_SiniestroBusquedaSimple {

    private final static Logger log = Logger.getLogger(Asesuisa_SiniestroBusquedaSimple.class);

    public String nombreAutomatizacion = "Busqueda simple de siniestro";
    private WebDriver driver;

    public void TestLink(Asesuisa_SiniestroBusquedaSimpleBean bean, int i, String folderName){
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
            nroCampo=Integer.parseInt(idCampo);

            //Llamada al metodo BuscarSiniestro
            BuscarSiniestro(driver,bean,m,i,nombreAutomatizacion,folderName,nroCampo);
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

    public void BuscarSiniestro(WebDriver driver, Asesuisa_SiniestroBusquedaSimpleBean bean, Metodos m,
                                int i, String nombreAutomatizacion, String folderName, int idCampo){
        try {

            WebElement txtCampo;

            //Selecciono el metodo de ordenamiento en caso de estar establecido en el xml
            if (bean.getOrdenarPor()!=null){

                //Click a la flecha para desplegar combo ordenarPor
                driver.findElement(By.xpath("html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/div[1]/div/div/div[3]/div/div/div[3]/div/div")).click();
                Thread.sleep(800);

                //Evaluo el nro de elemnto del combo
                int nroOpciones= driver.findElements(By.xpath("html/body/div[2]/div[2]/div/div[2]/table/tbody/tr")).size();
                for (int op=1;op<=nroOpciones;op++){
                    if( (driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div[2]/table/tbody/tr["+op+"]/td")).getText().equals(bean.getOrdenarPor())) ){
                        driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div[2]/table/tbody/tr["+op+"]/td")).click();
                        Thread.sleep(1000);
                        break;
                    }
                }
                driver.findElement(By.xpath("html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/div[1]/div/div/div[3]/div/div/div[1]/div")).click();
                Thread.sleep(800);
            }

            //Evaluo el campo por el cual se realizara la busqueda simple
            switch (idCampo){
                case 1:
                    System.out.println("Búsqueda por: Nro de Siniestro");
                    txtCampo = driver.findElement(By.xpath("html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/div[5]/div/div/div/div[3]/input"));
                    txtCampo.sendKeys(bean.getNroSiniestro());

                    //Click al elemento label del campo nro de siniestro
                    driver.findElement(By.xpath("html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/div[5]/div/div/div/div[2]/div")).click();
                    Thread.sleep(800);

                    //Pantallazo
                    m.ScreenShotPool(driver,i,"screen3",nombreAutomatizacion,folderName);
                    Thread.sleep(800);

                    //Llamada al metodo ValidarBusqueda
                    ValidarBusqueda(driver,m,i,nombreAutomatizacion,folderName);
                    break;
                case 2:
                    System.out.println("Búsqueda por: Fecha de Ocurrencia");
                    txtCampo = driver.findElement(By.xpath("html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/div[5]/div/div/div/div[6]/div/input"));
                    txtCampo.sendKeys(bean.getFechaOcurrencia());

                    //Click al elemento label del campo fecha de ocurrencia
                    driver.findElement(By.xpath("html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/div[5]/div/div/div/div[5]/div")).click();
                    Thread.sleep(800);

                    //Pantallazo
                    m.ScreenShotPool(driver,i,"screen3",nombreAutomatizacion,folderName);
                    Thread.sleep(800);

                    //Llamada al metodo ValidarBusqueda
                    ValidarBusqueda(driver,m,i,nombreAutomatizacion,folderName);
                    break;
                case 3:
                    System.out.println("Búsqueda por: Nro de Póliza");
                    txtCampo = driver.findElement(By.xpath("html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/div[5]/div/div/div/div[8]/input"));
                    txtCampo.sendKeys(bean.getNroPoliza());

                    //Click al elemento label del campo Nro de poliza
                    driver.findElement(By.xpath("html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/div[5]/div/div/div/div[7]/div")).click();
                    Thread.sleep(800);

                    //Pantallazo
                    m.ScreenShotPool(driver,i,"screen3",nombreAutomatizacion,folderName);
                    Thread.sleep(800);

                    //Llamada al metodo ValidarBusqueda
                    ValidarBusqueda(driver,m,i,nombreAutomatizacion,folderName);
                    break;
                case 4:
                    System.out.println("Búsqueda por: Producto");

                    //Click a la flecha para desplegar combo Producto
                    driver.findElement(By.xpath("html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/div[5]/div/div/div/div[11]/div/div")).click();
                    Thread.sleep(800);

                    //Evaluo el nro de elemnto del combo
                    int nroOpciones= driver.findElements(By.xpath("html/body/div[2]/div[2]/div/div[2]/table/tbody/tr")).size();
                    for (int p=1;p<=nroOpciones;p++){
                        if( (driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div[2]/table/tbody/tr["+p+"]/td")).getText().equals(bean.getProducto())) ){
                            driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div[2]/table/tbody/tr["+p+"]/td")).click();
                            Thread.sleep(1000);
                            break;
                        }
                    }

                    //Click al elemento label del campo producto
                    driver.findElement(By.xpath("html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/div[5]/div/div/div/div[10]/div")).click();
                    Thread.sleep(800);

                    //Pantallazo
                    m.ScreenShotPool(driver,i,"screen3",nombreAutomatizacion,folderName);
                    Thread.sleep(800);

                    //Llamada al metodo ValidarBusqueda
                    ValidarBusqueda(driver,m,i,nombreAutomatizacion,folderName);
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
            btnBuscar= driver.findElement(By.xpath("html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/div[7]/div/div/div[3]/div/span"));
            btnBuscar.click();
            Thread.sleep(2000);

            //Evaluo si aparecen mensajes de error
            if (driver.findElements(By.className("v-window-wrap")).size()>0){
                if ( (driver.findElement(By.className("v-window-header")).getText().equals("Mensaje de error"))  &&
                        (driver.findElement(By.xpath("//*[@id=\"WControllervaadinservlet-1750660287-window-overlays\"]/div[5]/div/div/div[5]/div/div/div[1]/div")).getText().equals("Al menos un campo debe estar lleno")) ){
                    System.out.println("Al menos un campo debe estar lleno");

                    //Pantallazo
                    m.ScreenShotPool(driver,i,"screen4",nombreAutomatizacion,folderName);
                    Thread.sleep(800);
                    break salidaValidar;
                }else if ( (driver.findElement(By.className("v-window-header")).getText().equals("Mensaje"))  &&
                        (driver.findElement(By.xpath("//*[@id=\"WControllervaadinservlet-1750660287-window-overlays\"]/div[5]/div/div/div[5]/div/div/div[1]/div")).getText().equals("No se encontró resultados asociados con esta búsqueda")) ){
                    System.out.println("No se encontró resultados asociados con esta búsqueda");

                    //Pantallazo
                    m.ScreenShotPool(driver,i,"screen4",nombreAutomatizacion,folderName);
                    Thread.sleep(1000);
                    break salidaValidar;
                }
            }

            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/div/div/div[5]/div/div/div[1]/div/span")));
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
