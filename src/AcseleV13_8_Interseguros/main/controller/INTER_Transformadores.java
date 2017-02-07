package AcseleV13_8_Interseguros.main.controller;

import AcseleV13_8_Interseguros.beans.INTER_TransformadoresBean;
import AcseleV13_8_Interseguros.main.controller.Interseguros_Menu.Interseguros_MenuConfiguracion;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;

/**
 * Created by aazuaje on 03/02/2017.
 */
public class INTER_Transformadores {

    private final static Logger log = Logger.getLogger(INTER_Transformadores.class);

    public String nombreAutomatizacion = "Transformadores";
    private WebDriver driver;

    public void testLink (INTER_TransformadoresBean inter_transformadoresBean, int i, String folderName)  throws IOException, InterruptedException {

        try{
            Interseguros_Metodos a = new Interseguros_Metodos();
            Interseguros_MenuConfiguracion m = new Interseguros_MenuConfiguracion();

            driver = a.entrarPagina();
            a.IniciarSesion(driver, nombreAutomatizacion, i, folderName);
            a.ValidandoSesion(driver, nombreAutomatizacion, i, folderName);
            Thread.sleep(1500);
            System.out.println("prueba");

            m.NuevoPlantillasModoNoPrivilegiado(driver,nombreAutomatizacion, 2, i, folderName);
            Thread.sleep(3000);
            a.cambiarVentana(driver);


            TranformadoresGeneral(a, inter_transformadoresBean, i, folderName, 3, 4);
            AgregarTranformadores (a, inter_transformadoresBean, i, folderName, 5,6,7,8);
            EliminarTransformadores (a, inter_transformadoresBean, i, folderName, 9,10,11,12,13);
            Thread.sleep(2000);
            a.cambiarVentana(driver);
            // Thread.sleep(1500);

            //driver.quit();
        }catch (Exception e){
            e.printStackTrace();
            log.error("Test Case - " + nombreAutomatizacion + " - " + e);
            if (driver != null){
                //driver.quit();
            }
        }

    }

    public void TranformadoresGeneral (Interseguros_Metodos a, INTER_TransformadoresBean inter_transformadoresBean, int i, String folderName, int numScreenShoot, int numScreenShoot2) throws IOException, InterruptedException{

        try {
            Thread.sleep(10000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion, folderName);
            Thread.sleep(4000);

            WebElement buscar = driver.findElement(By.xpath("//*[@id=\"WControllerfront-1437825718\"]/div/div[2]/div/div/div/div[2]/div/div/div[2]/div/div/div[2]/div/div/div[3]/div/div/div[1]/div/div/div[2]/input"));
            buscar.sendKeys(inter_transformadoresBean.getBuscar());
            Thread.sleep(1000);

            WebElement btnBuscar = driver.findElement(By.xpath("//*[@id=\"WControllerfront-1437825718\"]/div/div[2]/div/div/div/div[2]/div/div/div[2]/div/div/div[2]/div/div/div[3]/div/div/div[1]/div/div/div[3]/button/img"));
            btnBuscar.click();
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot2, nombreAutomatizacion, folderName);
            Thread.sleep(2000);

            for (int j = 1; j <= 3000; j++){

                //System.out.println("dentro del bucle: " + j);
                WebElement propiedad = driver.findElement(By.xpath("//*[@id=\"WControllerfront-1437825718\"]/div/div[2]/div/div/div/div[2]/div/div/div[2]/div/div/div[2]/div/div/div[3]/div/div/div[2]/div/div[2]/div[1]/table/tbody/tr[" + j + "]/td/div")); //arreglo para seleccionar la ultima plantilla creada

                String texto = propiedad.getText();

                //System.out.println("prueba-->>>>>"+opcionNombre+" => "+ opcionNombre.isEnabled());
                //System.out.println("Texto: " + texto);
                //  nuevaPlantilla.click();

                if (texto.equals(inter_transformadoresBean.getBuscar())){
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

                if (texto.equals(inter_transformadoresBean.getBuscar())){
                    propiedad.click();
                    Thread.sleep(1000);
                    // a.ScreenShotPool(driver, i, "screen7", nombreAutomatizacion);
                    System.out.println("Prueba: '" + texto + "' seleccionado");
                    break;
                }

            }

            WebElement opcionTranformador = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div/div[2]/div/div/div[2]/div/div/div[3]/div/div/div/div/div[1]/button"));
            Thread.sleep(1000);
            opcionTranformador.click();
            Thread.sleep(2000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot2, nombreAutomatizacion, folderName);



        }catch (Exception e) {
            e.printStackTrace();
            //log.info(e);
            log.error("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }

    public void AgregarTranformadores (Interseguros_Metodos a, INTER_TransformadoresBean inter_transformadoresBean, int i, String folderName, int numScreenShoot, int numScreenShoot2, int numScreenShoot3, int numScreenShoot4) throws IOException, InterruptedException{

        try {

            WebElement valorDefecto = driver.findElement(By.xpath("/html/body/div[5]/div[3]/div/div/div[5]/div/div/div[4]/div/div[3]/input"));
            valorDefecto.sendKeys(inter_transformadoresBean.getValorDefecto());
            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion, folderName);
            Thread.sleep(1000);

            WebElement valorPropiedad = driver.findElement(By.xpath("/html/body/div[5]/div[3]/div/div/div[5]/div/div/div[4]/div/div[9]/input"));
            valorPropiedad.sendKeys(inter_transformadoresBean.getValorPropiedad());
            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot2, nombreAutomatizacion, folderName);
            Thread.sleep(2000);

            WebElement btnAgregar = driver.findElement(By.xpath("/html/body/div[5]/div[3]/div/div/div[5]/div/div/div[2]/div/div[1]/button"));
            Thread.sleep(1000);
            btnAgregar.click();
            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot3, nombreAutomatizacion, folderName);
            Thread.sleep(1500);

            WebElement btnAceptar = driver.findElement(By.xpath("/html/body/div[5]/div[3]/div/div/div[5]/div/div/div[5]/div/div[1]/button"));
            //    Thread.sleep(1000);
            btnAceptar.click();
            Thread.sleep(8000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot4, nombreAutomatizacion, folderName);
            Thread.sleep(2000);



        }catch (Exception e) {
            e.printStackTrace();
            //log.info(e);
            log.error("Test Case - " + nombreAutomatizacion + " - " + e);
        }


    }

    public void EliminarTransformadores (Interseguros_Metodos a, INTER_TransformadoresBean inter_transformadoresBean, int i, String folderName, int numScreenShoot, int numScreenShoot2, int numScreenShoot3, int numScreenShoot4, int numScreenShoot5) throws IOException, InterruptedException{

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
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion, folderName);

            WebElement selectTransf = driver.findElement(By.xpath("/html/body/div[5]/div[3]/div/div/div[5]/div/div/div[3]/div/div[2]/div[2]/div[1]/table/tbody/tr/td[1]/div"));
            Thread.sleep(1000);
            selectTransf.click();
            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot2, nombreAutomatizacion, folderName);


            WebElement btnEliminar = driver.findElement(By.xpath("/html/body/div[5]/div[3]/div/div/div[5]/div/div/div[2]/div/div[3]/button"));
            Thread.sleep(1000);
            btnEliminar.click();
            Thread.sleep(2000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot3, nombreAutomatizacion, folderName);
            Thread.sleep(1500);

            WebElement btnAceptar = driver.findElement(By.xpath("/html/body/div[5]/div[3]/div/div/div[5]/div/div/div[5]/div/div[1]/button"));
            Thread.sleep(1000);
            btnAceptar.click();
            Thread.sleep(7000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot4, nombreAutomatizacion, folderName);


            Thread.sleep(2000);
            WebElement opcionTranf = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div/div[2]/div/div/div[2]/div/div/div[3]/div/div/div/div/div[1]/button"));
            Thread.sleep(1000);
            opcionTranf.click();
            Thread.sleep(2000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot5, nombreAutomatizacion, folderName);


        }catch (Exception e) {
            e.printStackTrace();
            //log.info(e);
            log.error("Test Case - " + nombreAutomatizacion + " - " + e);
        }


    }

}
