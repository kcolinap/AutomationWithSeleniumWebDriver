package AcseleV13_8Asesuisa.main.controller;

import AcseleV13_8Asesuisa.main.controller.Asesuisa_Menu.Asesuisa_MenuOperaciones;
import metodo.Metodos;
import AcseleV13_8Asesuisa.beans.Asesuisa_SiniestroCrearBean;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import java.util.*;
import java.text.SimpleDateFormat;

/**
 * Created by kcolina on 02/05/2017.
 */
public class Asesuisa_SiniestroCrear {

    private final static Logger log = Logger.getLogger(Asesuisa_SiniestroCrear.class);

    public String nombreAutomatizacion = "Creacion Siniestros";
    private WebDriver driver;
    private int polizaEncontrada=0;

    public void testLink(Asesuisa_SiniestroCrearBean bean, int i, String folderName){
        try {
            Metodos m = new Metodos();
            Asesuisa_MenuOperaciones menu = new Asesuisa_MenuOperaciones();

            driver= m.entrarPagina(m.UrlAsesuisa());
            m.IniciarSesion(driver,nombreAutomatizacion,i,folderName);
            m.ValidandoSesion(driver,nombreAutomatizacion,i,folderName);
            Thread.sleep(2000);

            //Entrando a la opcion crear siniestro
            menu.OpeSini_CreacionSiniestro(driver,nombreAutomatizacion,2,i,folderName);
            Thread.sleep(1500);
            m.cambiarVentana(driver);

            //Buscar la poliza que sera utilizada para generar el siniestro
            BuscarPoliza(driver,bean,i,nombreAutomatizacion,folderName, m);
            Thread.sleep(1000);

            //Evaluo el camino a seguir dependiendo el resultado de la busqueda
            switch (polizaEncontrada){
                case 0:
                    break;
                case 1:
                    //Agregar objeto afectado
                    ObjetoAfectado(driver, bean, i, m, nombreAutomatizacion, folderName);
                    break;
                default:
                    break;
            }

            Thread.sleep(1000);
            driver.quit();
        }catch (Exception e){
            e.printStackTrace();
            log.error("Test Case - " + nombreAutomatizacion + " - " + e);
            if (driver != null){
                driver.quit();
            }
        }

    }

    public void BuscarPoliza(WebDriver driver, Asesuisa_SiniestroCrearBean bean, int i, String nombreAutomatizacion,
                             String folderName, Metodos m){
        salida: try{

            Thread.sleep(2500);
            //Ordenar por
            if (bean.getOrdenarPor()!=null){
                Select ordenarPor = new Select(driver.findElement(By.xpath("html/body/table/tbody/tr[3]/td/table/tbody/tr[1]/td[2]/select")));
                ordenarPor.selectByValue(bean.getOrdenarPor());
                Thread.sleep(1500);
            }

            //Estado ciclo de vida
            if (bean.getEstadosCicloVida()!=null){
                Select cicloVida = new Select(driver.findElement(By.xpath("html/body/table/tbody/tr[3]/td/table/tbody/tr[2]/td/table/tbody/tr[2]/td[2]/select")));
                cicloVida.selectByValue(bean.getOrdenarPor());
                Thread.sleep(1500);
            }

            //Id poliza
            if (bean.getNroPoliza()!=null){
                WebElement nroPoliza = driver.findElement(By.xpath("html/body/table/tbody/tr[3]/td/table/tbody/tr[2]/td/table/tbody/tr[9]/td/form/div/div[1]/div/table[2]/tbody/tr/td[3]/font/input[1]"));
                nroPoliza.sendKeys(bean.getNroPoliza());
                Thread.sleep(1500);
            }


            /**
             * mas campos ( si aplica)
             */
             //Pantallazo
            m.ScreenShotPool(driver,i,"screen4",nombreAutomatizacion, folderName);
            Thread.sleep(800);

            //Boton buscar
            WebElement btnBuscar = driver.findElement(By.xpath("html/body/table/tbody/tr[4]/td/input[1]"));
            btnBuscar.click();
            //m.waitSearchWicket(driver, ". Buscando poliza");
            Thread.sleep(2000);

            //Evaluo si hay mensaje de error
            boolean existe = (driver.findElements(By.xpath("html/body/div[4]/center/table[2]/tbody/tr/td")).size()>0);
            if (existe){

                String txtResultado = driver.findElement(By.xpath("html/body/div[4]/center/table[2]/tbody/tr/td")).getText();
                if (txtResultado.equals("No se encontró ninguna póliza.")){
                    m.ScreenShotPool(driver,i,"screen5",nombreAutomatizacion, folderName);
                    Thread.sleep(800);
                    System.out.println("No se encotrò pòliza con las caracteristicas indicadas");
                    polizaEncontrada=0;
                    break salida;
                }
            }

            polizaEncontrada=1;
            //Fecha de ocurrencia
            if (bean.getFechaOcurrencia()==null){
                Date fecha = new Date();
                String starString= new SimpleDateFormat("dd/MM/yyyy").format(fecha);
                WebElement fechaO=driver.findElement(By.xpath("html/body/div[4]/center/form/table/tbody/tr/td[2]/input[4]"));
                fechaO.sendKeys(starString);
                Thread.sleep(1500);
            }else{
                WebElement fechaO=driver.findElement(By.xpath("html/body/div[4]/center/form/table/tbody/tr/td[2]/input[4]"));
                fechaO.sendKeys(bean.getFechaOcurrencia());//fechaO.sendKeys(bean.getFechaOcurrencia());
                Thread.sleep(1500);
            }

            //Sucursal
            if (bean.getSucursal()!=null){
                Select sucursal = new Select(driver.findElement(By.xpath("html/body/div[4]/center/form/table/tbody/tr/td[4]/select")));
                sucursal.selectByValue(bean.getSucursal());
                Thread.sleep(2000);
            }

            /**
             * Cambiar de frame para poder seleccionar la poliza
              */
            //cambio frame
            driver.switchTo().frame("frameData");
            Thread.sleep(2000);

            //Selecciono la poliza encontrada
            WebElement optPoliza = driver.findElement(By.xpath("//*[@id=\"form1\"]/table/tbody/tr/td[1]/input"));
            optPoliza.click();
            Thread.sleep(800);

            //salida del frame
            driver.switchTo().defaultContent();
            Thread.sleep(1000);
            /**
             * fin del frame
             */

            //Pantallazo
            m.ScreenShotPool(driver,i,"screen5",nombreAutomatizacion,folderName);
            Thread.sleep(800);

            //Boton unidad de riesgo
            WebElement btnUnidadRiesgo = driver.findElement(By.xpath("html/body/div[4]/center/table/tbody/tr[2]/td[2]/input[1]"));
            btnUnidadRiesgo.click();
            Thread.sleep(3500);

            /**
             * Seleccion de unidad de riesgo
             */
            //Check unidad de riesgo
            WebElement chkUnidadRiesgo = driver.findElement(By.xpath("html/body/center/form/table[2]/tbody/tr[5]/td[1]/input"));
            chkUnidadRiesgo.click();
            Thread.sleep(800);

            //Pantallazo
            m.ScreenShotPool(driver,i,"screen6",nombreAutomatizacion,folderName);
            Thread.sleep(800);

            WebElement btnEnviar = driver.findElement(By.xpath("html/body/center/form/table[4]/tbody/tr/td/input"));
            btnEnviar.click();
            Thread.sleep(3000);

            /**
             * fin seleccion de unidad de riesgo
             */

            /**
             * Seleccion de evento
             *
             */
            //Btn seleccionar evento
            WebElement btnSelecEvento = driver.findElement(By.xpath("html/body/div[4]/center/table/tbody/tr[2]/td[2]/input[2]"));
            btnSelecEvento.click();
            Thread.sleep(3500);

            //Recorrro los eventos disponibles hasta encontrar el establecido

            int nroFilasEventos=driver.findElements(By.xpath("html/body/center/form/table[2]")).size();
            for (int k=2; i<nroFilasEventos; k++){
                if (bean.getEventoSiniestro()!=null){
                    if ( (driver.findElement(By.xpath("html/body/center/form/table[2]/tbody/tr[" + (k+1) +"]/td[2]")).getText().equals(bean.getEventoSiniestro())) ){
                        driver.findElement(By.xpath("html/body/center/form/table[2]/tbody/tr[" + (k+1) + "]/td[1]/input")).click();
                        break;
                    }
                }
            }

            //Pantallazo
            m.ScreenShotPool(driver,i,"screen7",nombreAutomatizacion,folderName);
            Thread.sleep(1500);

            //Boton enviar
            btnEnviar = driver.findElement(By.xpath("html/body/center/form/table[3]/tbody/tr/td/input"));
            btnEnviar.click();
            Thread.sleep(3500);
            /**
             * fin seleccion de evento
             */

            //Pantallazo
            m.ScreenShotPool(driver, i, "screen8", nombreAutomatizacion, folderName);
            Thread.sleep(800);

            //Boton aceptar
            WebElement btnAceptar = driver.findElement(By.xpath("html/body/div[4]/center/table/tbody/tr[2]/td[2]/input[3]"));
            btnAceptar.click();
            Thread.sleep(3500);


        }catch (Exception e) {
            e.printStackTrace();
            log.error("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }

    public void ObjetoAfectado(WebDriver driver, Asesuisa_SiniestroCrearBean bean, int i, Metodos m,
                               String nombreAutomatizacion, String folderName){
        try {
            //pantallazo
            m.ScreenShotPool(driver, i, "screen8", nombreAutomatizacion, folderName);
            Thread.sleep(800);

            //Boton Agregar
            WebElement btnAgregar = driver.findElement(By.xpath("html/body/div[13]/form[1]/div[2]/input[1]"));
            btnAgregar.click();
            Thread.sleep(5000);

            // Cambiar de frame
            driver.switchTo().frame("plantilla");
            Thread.sleep(2000);

            /**
             * FORMULARIO AGREGAR OBJETO AFECTADO
             */
            //FECHA NOTIFICACION
            WebElement fechaN;
            if (bean.getFechaNotificacion()==null){
                Date fecha = new Date();
                String starString= new SimpleDateFormat("dd/MM/yyyy").format(fecha);
                fechaN = driver.findElement(By.xpath("html/body/div[1]/form/table[1]/tbody/tr/td[3]/font/input[1]"));
                fechaN.sendKeys(starString);
                Thread.sleep(1500);
            }else{
                fechaN = driver.findElement(By.xpath("html/body/div[1]/form/table[1]/tbody/tr/td[3]/font/input[1]"));
                fechaN.sendKeys(bean.getFechaNotificacion());//fechaO.sendKeys(bean.getFechaOcurrencia());
                Thread.sleep(1500);
            }


            /**
             * /////////////////////////////////////
             */


        }catch (Exception e) {
            e.printStackTrace();
            log.error("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }
}
