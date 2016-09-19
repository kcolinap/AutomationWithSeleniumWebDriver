package AcseleV13_8.main.controller;

import AcseleV13_8.beans.TransformadoresBean;
import AcseleV13_8.main.controller.Menu.MenuConfiguracion;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;

/**
 * Created by kzambrano on 20/08/2016.
 */
public class Transformadores {

    private final static Logger log = Logger.getLogger(Transformadores.class);

    public String nombreAutomatizacion = "Transformadores";

    public void testLink (TransformadoresBean transformadoresBean, int i )  throws IOException, InterruptedException {

        //Metodos a = new Metodos();
        Metodos a = new Metodos();
        MenuConfiguracion m = new MenuConfiguracion();

        WebDriver driver = a.entrarPagina();
        a.IniciarSesion(driver, nombreAutomatizacion, i);
        a.ValidandoSesion(driver, nombreAutomatizacion, i);
        Thread.sleep(1500);
        System.out.println("prueba");


        m.NuevoPlantillasModoNoPrivilegiado(driver, nombreAutomatizacion, 3, i);

        Thread.sleep(2000);
        a.cambiarVentana(driver);

        TranformadoresGeneral(driver, a, transformadoresBean, i);
        Thread.sleep(3000);

        AgregarTranformadores( driver, a, transformadoresBean, i);
        Thread.sleep(3000);

        EliminarTransformadores (driver, a, transformadoresBean, i);


    }

    public void TranformadoresGeneral (WebDriver driver, Metodos a, TransformadoresBean transformadoresBean, int i) throws IOException, InterruptedException{

        try {

            Thread.sleep(7000);
            a.ScreenShotPool(driver, i, "screen4", nombreAutomatizacion);
            Thread.sleep(1500);

            WebElement buscar = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div/div[2]/div/div/div[2]/div/div/div[2]/div/div/div[3]/div/div/div[1]/div/div/div[2]/input"));
            buscar.sendKeys(transformadoresBean.getBuscar());
            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen5", nombreAutomatizacion);
            Thread.sleep(500);

            WebElement btnBuscar = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div/div[2]/div/div/div[2]/div/div/div[2]/div/div/div[3]/div/div/div[1]/div/div/div[3]/button"));
           // Thread.sleep(1000);
            btnBuscar.click();
            Thread.sleep(3000);
            a.ScreenShotPool(driver, i, "screen6", nombreAutomatizacion);



  /*          WebElement carpetaTodas = driver.findElement(By.xpath("//*[@id=\"WControllerfront-1437825718\"]/div/div[2]/div/div/div/div[2]/div/div/div[2]/div/div/div[2]/div/div/div[3]/div/div/div[2]/div/div[2]/div[1]/table/tbody/tr[1]/td/div/span"));
            Thread.sleep(1000);
            carpetaTodas.click();
            Thread.sleep(2500);
*/

            Thread.sleep(4000);
            WebElement propiedad = driver.findElement(By.xpath("//*[@id=\"33882194\"]"));
            Thread.sleep(1500);
            propiedad.click();
            Thread.sleep(1000);
            propiedad.click();


         /*   for (int j = 1; j <= 3000; j++){

                System.out.println("dentro del bucle: " + j);
                WebElement propiedad = driver.findElement(By.xpath("//*[@id=\"WControllerfront-1437825718\"]/div/div[2]/div/div/div/div[2]/div/div/div[2]/div/div/div[2]/div/div/div[3]/div/div/div[2]/div/div[2]/div[1]/table/tbody/tr[" + j + "]/td/div")); //arreglo para seleccionar la ultima plantilla creada

                String texto = propiedad.getText();

                //System.out.println("prueba-->>>>>"+opcionNombre+" => "+ opcionNombre.isEnabled());
                //System.out.println("Texto: " + texto);
                //  nuevaPlantilla.click();

                if (texto.equals(transformadoresBean.getBuscar())){
                    propiedad.click();
                    Thread.sleep(1000);
                  //  a.ScreenShotPool(driver, i, "screen7", nombreAutomatizacion);
                    System.out.println("Prueba: '" + texto + "' seleccionado");
                    break;
                }

            }
*/
            //Thread.sleep(1000);

         /*   for (int j = 1; j <= 3000; j++){

                System.out.println("dentro del bucle: " + j);
                WebElement propiedad = driver.findElement(By.xpath("//*[@id=\"WControllerfront-1437825718\"]/div/div[2]/div/div/div/div[2]/div/div/div[2]/div/div/div[2]/div/div/div[3]/div/div/div[2]/div/div[2]/div[1]/table/tbody/tr[" + j + "]/td/div")); //arreglo para seleccionar la ultima plantilla creada

                String texto = propiedad.getText();

                //System.out.println("prueba-->>>>>"+opcionNombre+" => "+ opcionNombre.isEnabled());
                //System.out.println("Texto: " + texto);
                //  nuevaPlantilla.click();

                if (texto.equals(transformadoresBean.getBuscar())){
                    propiedad.click();
                    Thread.sleep(1000);
                    a.ScreenShotPool(driver, i, "screen7", nombreAutomatizacion);
                    System.out.println("Prueba: '" + texto + "' seleccionado");
                    break;
                }

            }
*/
/*
            Thread.sleep(3000);
            WebElement propiedad = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div/div[2]/div/div/div[2]/div/div/div[2]/div/div/div[3]/div/div/div[2]/div/div[2]/div[1]/table/tbody/tr[59]/td/div"));
            propiedad.click();
            Thread.sleep(3000);
            a.ScreenShotPool(driver, i, "screen7", nombreAutomatizacion);
            Thread.sleep(2000);

   */         WebElement opcionTranformador = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div/div[2]/div/div/div[2]/div/div/div[3]/div/div/div/div/div[1]/button"));
            Thread.sleep(1000);
            opcionTranformador.click();
            Thread.sleep(2000);
            a.ScreenShotPool(driver, i, "screen8", nombreAutomatizacion);



        }catch (Exception e) {
            e.printStackTrace();
//                log.info(e);
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);

        }
    }

    public void AgregarTranformadores (WebDriver driver, Metodos a, TransformadoresBean transformadoresBean, int i) throws IOException, InterruptedException{

        try {

            WebElement valorDefecto = driver.findElement(By.xpath("/html/body/div[5]/div[3]/div/div/div[5]/div/div/div[4]/div/div[3]/input"));
            valorDefecto.sendKeys(transformadoresBean.getValorDefecto());
            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen9", nombreAutomatizacion);
            Thread.sleep(1000);

            WebElement valorPropiedad = driver.findElement(By.xpath("/html/body/div[5]/div[3]/div/div/div[5]/div/div/div[4]/div/div[9]/input"));
            valorPropiedad.sendKeys(transformadoresBean.getValorPropiedad());
            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen10", nombreAutomatizacion);
            Thread.sleep(2000);

            WebElement btnAgregar = driver.findElement(By.xpath("/html/body/div[5]/div[3]/div/div/div[5]/div/div/div[2]/div/div[1]/button"));
            Thread.sleep(1000);
            btnAgregar.click();
            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen11", nombreAutomatizacion);
            Thread.sleep(1500);

            WebElement btnAceptar = driver.findElement(By.xpath("/html/body/div[5]/div[3]/div/div/div[5]/div/div/div[5]/div/div[1]/button"));
        //    Thread.sleep(1000);
            btnAceptar.click();
            Thread.sleep(8000);
            a.ScreenShotPool(driver, i, "screen12", nombreAutomatizacion);
            Thread.sleep(2000);



        }catch (Exception e) {
            e.printStackTrace();
//                log.info(e);
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }


    }

    public void EliminarTransformadores (WebDriver driver, Metodos a, TransformadoresBean transformadoresBean, int i) throws IOException, InterruptedException{

        try {

         /*   WebElement carpetaTodas = driver.findElement(By.xpath("//*[@id=\"WControllerfront-1437825718\"]/div/div[2]/div/div/div/div[2]/div/div/div[2]/div/div/div[2]/div/div/div[3]/div/div/div[2]/div/div[2]/div[1]/table/tbody/tr[1]/td/div/span"));
            Thread.sleep(1000);
            carpetaTodas.click();
            Thread.sleep(2500);
         */


            Thread.sleep(3000);
            WebElement opcionTranformador = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div/div[2]/div/div/div[2]/div/div/div[3]/div/div/div/div/div[1]/button"));
            Thread.sleep(1000);
            opcionTranformador.click();
            Thread.sleep(2000);
            a.ScreenShotPool(driver, i, "screen13", nombreAutomatizacion);

            WebElement selectTransf = driver.findElement(By.xpath("/html/body/div[5]/div[3]/div/div/div[5]/div/div/div[3]/div/div[2]/div[2]/div[1]/table/tbody/tr/td[1]/div"));
            Thread.sleep(1000);
            selectTransf.click();
            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen14", nombreAutomatizacion);


            WebElement btnEliminar = driver.findElement(By.xpath("/html/body/div[5]/div[3]/div/div/div[5]/div/div/div[2]/div/div[3]/button"));
            Thread.sleep(1000);
            btnEliminar.click();
            Thread.sleep(2000);
            a.ScreenShotPool(driver, i, "screen15", nombreAutomatizacion);
            Thread.sleep(1500);

            WebElement btnAceptar = driver.findElement(By.xpath("/html/body/div[5]/div[3]/div/div/div[5]/div/div/div[5]/div/div[1]/button"));
            Thread.sleep(1000);
            btnAceptar.click();
            Thread.sleep(7000);
            a.ScreenShotPool(driver, i, "screen16", nombreAutomatizacion);


            Thread.sleep(2000);
            WebElement opcionTranf = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div/div[2]/div/div/div[2]/div/div/div[3]/div/div/div/div/div[1]/button"));
            Thread.sleep(1000);
            opcionTranf.click();
            Thread.sleep(2000);
            a.ScreenShotPool(driver, i, "screen17", nombreAutomatizacion);


        }catch (Exception e) {
            e.printStackTrace();
//                log.info(e);
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }


    }

}











