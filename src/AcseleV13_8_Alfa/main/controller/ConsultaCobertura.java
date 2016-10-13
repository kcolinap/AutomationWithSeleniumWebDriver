package AcseleV13_8_Alfa.main.controller;

import AcseleV13_8_Alfa.beans.ConsultaCoberturaBean;
import AcseleV13_8_Alfa.main.controller.Menu.MenuConsultas;
import com.steadystate.css.parser.Locatable;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;

/**
 * Created by yalvarez on 30/09/2016.
 */
public class ConsultaCobertura {

    private final static Logger log = Logger.getLogger(ConsultaCobertura.class);

    public String nombreAutomatizacion = "Consulta Cobertura"; //nombre la carpeta de capture en c, ya esto esta em metodos definido

    public void testLink(ConsultaCoberturaBean consultaCoberturaBean,int i) throws IOException, InterruptedException {

        //implementando clase de Metodos_Alfa
        Metodos a = new Metodos();
        WebDriver driver = a.entrarPagina();
        MenuConsultas menuConsultas = new MenuConsultas();


        a.IniciarSesion(driver, nombreAutomatizacion);// desde aqui se  toma la primera captura
        a.ValidandoSesion(driver, nombreAutomatizacion); // segunda caotura de la imagen
        Thread.sleep(5000);

        //Ingresar al menu
        menuConsultas.MovimientoPolizas(driver, nombreAutomatizacion, 3); //aqui toma la primera vez la foto del menu
        Thread.sleep(2000);
        a.cambiarVentana(driver); //este cambiar ventana es porque ascel-e desplega otra ventana donde se consulta la poliza

        MovimientoPolizas(driver, consultaCoberturaBean, a, i);
        Thread.sleep(8000);
        //ConsultaCobertura(driver, consultaCoberturaBean, a, i);

    }

    private void MovimientoPolizas(WebDriver driver, ConsultaCoberturaBean consultaCoberturaBean, Metodos a, int i) {

        try{
            Thread.sleep(5000);

            //Producto

            if (consultaCoberturaBean.getProducto() != null){

                Select orden = new Select(driver.findElement(By.xpath("//*[@id=\"_productId\"]")));

                if (consultaCoberturaBean.getProducto().equals("VidaDeudoresAvVillas")){
                    Thread.sleep(2000);
                    orden.selectByValue("46897"); //id en acsel-e para  la busqueda por producto.
                }

            }

            //ID Poliza

            if (consultaCoberturaBean.getNumPoliza() != null){
                Thread.sleep(2000);
                WebElement numPoliza = driver.findElement(By.xpath("//*[@id=\"1829814\"]/td[3]/font/input[1]"));
                numPoliza.sendKeys(consultaCoberturaBean.getNumPoliza());//se le envia el id de la poliza que esta en el xml de beans
            }

            Thread.sleep(2000);
            a.ScreenShotPool(driver, i,  "screen4", nombreAutomatizacion);
            Thread.sleep(1000);


            WebElement btnBuscsar = driver.findElement(By.xpath("//*[@id=\"idb_040201401_searchformpolicy_01\"]"));
            btnBuscsar.click();

            Thread.sleep(1000);

            // Ingreso al Frame
            driver.switchTo().frame("frameData");
            Thread.sleep(2000);

            a.ScreenShotPool(driver, i,  "screen5", nombreAutomatizacion);
            Thread.sleep(1000);


            WebElement btnPoliza = driver.findElement(By.xpath("//*[@id=\"form1\"]/table/tbody/tr/td[3]/a"));
            btnPoliza.click();


            // Salida del Frame
            //driver.switchTo().defaultContent();

            Thread.sleep(5000);

            a.changeLastWindows(driver);
            Thread.sleep(2000);
            a.ScreenShotPool(driver, i,  "screen6", nombreAutomatizacion);
            Thread.sleep(1000);

            WebElement consultColoratura = driver.findElement(By.xpath("//*[@id=\"divTree\"]/table[12]/tbody/tr/td[2]/a/b"));
            consultColoratura.click();
            Thread.sleep(1000);
            a.ScreenShotPool(driver, i,  "screen7", nombreAutomatizacion);
            Thread.sleep(3000);

            WebElement scroll = driver.findElement(By.xpath("/html/body/center/table[2]/tbody/tr/td[2]/div")); // se usa para mover el scroll
            scroll.sendKeys(Keys.PAGE_DOWN);
            scroll.sendKeys(Keys.PAGE_DOWN);
            scroll.sendKeys(Keys.PAGE_DOWN);
            scroll.sendKeys(Keys.PAGE_DOWN);
            Thread.sleep(2000);



        }
        catch (Exception e) {
            e.printStackTrace();
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }

    }
}