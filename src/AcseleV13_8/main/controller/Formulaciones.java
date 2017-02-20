package AcseleV13_8.main.controller;

import AcseleV13_8.beans.FormulacionesBean;
import AcseleV13_8.main.controller.Menu.MenuConfiguracion;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
/**
 * Created by aazuaje on 23/08/2016.
 */
public class Formulaciones {


    private final static Logger log = Logger.getLogger(Formulaciones.class);

    public String nombreAutomatizacion = "Formulaciones";


    public void testLink(FormulacionesBean formulacionesBean,int i) throws IOException, InterruptedException {

        //implementando clase de metodos
        Metodos13_8 a = new Metodos13_8();
        MenuConfiguracion m = new MenuConfiguracion();
        WebDriver driver = a.entrarPagina();
        a.IniciarSesion(driver, nombreAutomatizacion, i);
        a.ValidandoSesion(driver, nombreAutomatizacion, i);
        Thread.sleep(8000);


        m.NuevoPlantillasModoNoPrivilegiado(driver, nombreAutomatizacion, 3, i);

        Thread.sleep(3000);
        a.cambiarVentana(driver);
        AgregarFormulaciones (driver, a, formulacionesBean, i);
        ConsultaFormulaciones (driver, a, formulacionesBean, i);


    }


    public void AgregarFormulaciones (WebDriver driver, Metodos13_8 a, FormulacionesBean formulacionesBean, int i) throws IOException, InterruptedException{

        try{
            Thread.sleep(8000);
            a.ScreenShotPool(driver,i,"screen4",nombreAutomatizacion);

            WebElement buscar = driver.findElement(By.xpath("//*[@id=\"WControllerfront-1437825718\"]/div/div[2]/div/div/div/div[2]/div/div/div[2]/div/div/div[2]/div/div/div[3]/div/div/div[1]/div/div/div[2]/input"));
            buscar.sendKeys(formulacionesBean.getBuscar());
            Thread.sleep(1000);

            WebElement btnBuscar = driver.findElement(By.xpath("//*[@id=\"WControllerfront-1437825718\"]/div/div[2]/div/div/div/div[2]/div/div/div[2]/div/div/div[2]/div/div/div[3]/div/div/div[1]/div/div/div[3]/button/img"));
            btnBuscar.click();
            a.ScreenShotPool(driver,i,"screen5",nombreAutomatizacion);
            Thread.sleep(2000);

            for (int j = 1; j <= 3000; j++){

                //System.out.println("dentro del bucle: " + j);
                WebElement propiedad = driver.findElement(By.xpath("//*[@id=\"WControllerfront-1437825718\"]/div/div[2]/div/div/div/div[2]/div/div/div[2]/div/div/div[2]/div/div/div[3]/div/div/div[2]/div/div[2]/div[1]/table/tbody/tr[" + j + "]/td/div")); //arreglo para seleccionar la ultima plantilla creada

                String texto = propiedad.getText();

                //System.out.println("prueba-->>>>>"+opcionNombre+" => "+ opcionNombre.isEnabled());
                //System.out.println("Texto: " + texto);
                //  nuevaPlantilla.click();

                if (texto.equals(formulacionesBean.getBuscar())){
                    propiedad.click();
                    Thread.sleep(1000);
                    // a.ScreenShotPool(driver, i, "screen7", nombreAutomatizacion);
                    System.out.println("Prueba: '" + texto + "' seleccionado");
                    break;
                }

            }

            for (int j = 1; j <= 3000; j++){

                //System.out.println("dentro del bucle: " + j);
                WebElement propiedad = driver.findElement(By.xpath("//*[@id=\"WControllerfront-1437825718\"]/div/div[2]/div/div/div/div[2]/div/div/div[2]/div/div/div[2]/div/div/div[3]/div/div/div[2]/div/div[2]/div[1]/table/tbody/tr[" + j + "]/td/div")); //arreglo para seleccionar la ultima plantilla creada

                String texto = propiedad.getText();

                //System.out.println("prueba-->>>>>"+opcionNombre+" => "+ opcionNombre.isEnabled());
                //System.out.println("Texto: " + texto);
                //  nuevaPlantilla.click();

                if (texto.equals(formulacionesBean.getBuscar())){
                    propiedad.click();
                    Thread.sleep(1000);
                    // a.ScreenShotPool(driver, i, "screen7", nombreAutomatizacion);
                    System.out.println("Prueba: '" + texto + "' seleccionado");
                    break;
                }

            }


            WebElement btnAsignarPresentacion = driver.findElement(By.xpath("//*[@id=\"WControllerfront-1437825718\"]/div/div[2]/div/div/div/div[2]/div/div/div[2]/div/div/div[3]/div/div/div/div/div[5]/button/img"));
            btnAsignarPresentacion.click();
            Thread.sleep(1000);

            WebElement btnRegla= driver.findElement(By.xpath("//*[@id=\"WControllerfront-1437825718-window-overlays\"]/div[3]/div/div/div[5]/div/div/div[1]/div/div/div[1]/div/div[9]/div/div[2]/button/img"));
            btnRegla.click();
            Thread.sleep(2000);

            WebElement descripcionFormula = driver.findElement(By.xpath("//*[@id=\"WControllerfront-1437825718-window-overlays\"]/div[6]/div/div/div[5]/div/div/div[1]/div/div[2]/div/div[1]/textarea"));
            descripcionFormula.sendKeys(formulacionesBean.getDescripcionFormula());
            Thread.sleep(2000);
            a.ScreenShotPool(driver,i,"screen6",nombreAutomatizacion);

            WebElement btnSalvar= driver.findElement(By.xpath("//*[@id=\"WControllerfront-1437825718-window-overlays\"]/div[6]/div/div/div[5]/div/div/div[2]/div/div[1]/button/span"));
            btnSalvar.click();
            Thread.sleep(2000);

            a.ScreenShotPool(driver,i,"screen7",nombreAutomatizacion);

           WebElement btnAceptar= driver.findElement(By.xpath("/*//*[@id=\"WControllerfront-1437825718-window-overlays\"]/div[3]/div/div/div[5]/div/div/div[2]/div/div[1]/button/span"));
            btnAceptar.click();
            Thread.sleep(2000);



        }catch (Exception e) {
            e.printStackTrace();
//                log.info(e);
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }
    public void ConsultaFormulaciones (WebDriver driver, Metodos13_8 a, FormulacionesBean formulacionesBean, int i) throws IOException, InterruptedException{

        try{
            Thread.sleep(2000);
           /* WebElement buscar = driver.findElement(By.xpath("/*//*[@id=\"WControllerfront-1437825718\"]/div/div[2]/div/div/div/div[2]/div/div/div[2]/div/div/div[2]/div/div/div[3]/div/div/div[1]/div/div/div[2]/input"));
            buscar.sendKeys(formulacionesBean.getBuscar());
            Thread.sleep(1000);*/

            /*WebElement btnBuscar = driver.findElement(By.xpath("/*//*[@id=\"WControllerfront-1437825718\"]/div/div[2]/div/div/div/div[2]/div/div/div[2]/div/div/div[2]/div/div/div[3]/div/div/div[1]/div/div/div[3]/button/img"));
            btnBuscar.click();
            Thread.sleep(2000);*/

            for (int j = 1; j <= 3000; j++){

                //System.out.println("dentro del bucle: " + j);
                WebElement propiedad = driver.findElement(By.xpath("//*[@id=\"WControllerfront-1437825718\"]/div/div[2]/div/div/div/div[2]/div/div/div[2]/div/div/div[2]/div/div/div[3]/div/div/div[2]/div/div[2]/div[1]/table/tbody/tr[" + j + "]/td/div")); //arreglo para seleccionar la ultima plantilla creada

                String texto = propiedad.getText();

                //System.out.println("prueba-->>>>>"+opcionNombre+" => "+ opcionNombre.isEnabled());
                //System.out.println("Texto: " + texto);
                //  nuevaPlantilla.click();

                if (texto.equals(formulacionesBean.getBuscar())){
                    propiedad.click();
                    Thread.sleep(1000);
                    // a.ScreenShotPool(driver, i, "screen7", nombreAutomatizacion);
                    System.out.println("Prueba: '" + texto + "' seleccionado");
                    break;
                }

            }

            for (int j = 1; j <= 3000; j++){

                //System.out.println("dentro del bucle: " + j);
                WebElement propiedad = driver.findElement(By.xpath("//*[@id=\"WControllerfront-1437825718\"]/div/div[2]/div/div/div/div[2]/div/div/div[2]/div/div/div[2]/div/div/div[3]/div/div/div[2]/div/div[2]/div[1]/table/tbody/tr[" + j + "]/td/div")); //arreglo para seleccionar la ultima plantilla creada

                String texto = propiedad.getText();

                //System.out.println("prueba-->>>>>"+opcionNombre+" => "+ opcionNombre.isEnabled());
                //System.out.println("Texto: " + texto);
                //  nuevaPlantilla.click();

                if (texto.equals(formulacionesBean.getBuscar())){
                    propiedad.click();
                    Thread.sleep(1000);
                    // a.ScreenShotPool(driver, i, "screen7", nombreAutomatizacion);
                    System.out.println("Prueba: '" + texto + "' seleccionado");
                    break;
                }

            }

            WebElement btnAsignarPresentacion = driver.findElement(By.xpath("//*[@id=\"WControllerfront-1437825718\"]/div/div[2]/div/div/div/div[2]/div/div/div[2]/div/div/div[3]/div/div/div/div/div[5]/button/img"));
            btnAsignarPresentacion.click();
            Thread.sleep(1000);

            a.ScreenShotPool(driver,i,"screen8",nombreAutomatizacion);

        }catch (Exception e) {
            e.printStackTrace();
//                log.info(e);
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }
}
