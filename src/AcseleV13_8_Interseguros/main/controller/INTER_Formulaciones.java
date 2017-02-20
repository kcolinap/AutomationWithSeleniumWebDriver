package AcseleV13_8_Interseguros.main.controller;

import AcseleV13_8_Interseguros.beans.INTER_FormulacionesBean;
import AcseleV13_8_Interseguros.main.controller.Interseguros_Menu.Interseguros_MenuConfiguracion;
import metodo.Metodos;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;

/**
 * Created by aazuaje on 30/01/2017.
 */
public class INTER_Formulaciones {

    private final static Logger log = Logger.getLogger(INTER_BusquedaSiniestroAvanzada.class);

    public String nombreAutomatizacion = "Formulaciones";
    private WebDriver driver;

    public void testLink (INTER_FormulacionesBean inter_formulacionesBean, int i, String folderName)  throws IOException, InterruptedException {

        try{
            Metodos a = new Metodos();
            Interseguros_MenuConfiguracion m = new Interseguros_MenuConfiguracion();

            driver = a.entrarPagina(a.UrlInterseguros());
            a.IniciarSesion(driver, nombreAutomatizacion, i, folderName);
            a.ValidandoSesion(driver, nombreAutomatizacion, i, folderName);
            Thread.sleep(1500);
            System.out.println("prueba");

            m.NuevoPlantillasModoNoPrivilegiado(driver,nombreAutomatizacion, 2, i, folderName);
            Thread.sleep(3000);
            a.cambiarVentana(driver);


            AgregarFormulaciones(a, inter_formulacionesBean, i, folderName, 3, 4, 5,6);
            ConsultaFormulaciones (a, inter_formulacionesBean, i, folderName, 7);
            Thread.sleep(2000);
            a.cambiarVentana(driver);
            // Thread.sleep(1500);

            driver.quit();
        }catch (Exception e){
            e.printStackTrace();
            log.error("Test Case - " + nombreAutomatizacion + " - " + e);
            if (driver != null){
                //driver.quit();
            }
        }

    }

    public void AgregarFormulaciones ( Metodos a, INTER_FormulacionesBean inter_formulacionesBean, int i, String folderName, int numScreenShoot, int numScreenShoot2, int numScreenShoot3, int numScreenShoot4 ) throws IOException, InterruptedException{

        try{
            Thread.sleep(8000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion, folderName);

            WebElement buscar = driver.findElement(By.xpath("//*[@id=\"WControllerfront-1437825718\"]/div/div[2]/div/div/div/div[2]/div/div/div[2]/div/div/div[2]/div/div/div[3]/div/div/div[1]/div/div/div[2]/input"));
            buscar.sendKeys(inter_formulacionesBean.getBuscar());
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

                if (texto.equals(inter_formulacionesBean.getBuscar())){
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

                if (texto.equals(inter_formulacionesBean.getBuscar())){
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
            descripcionFormula.sendKeys(inter_formulacionesBean.getDescripcionFormula());
            Thread.sleep(2000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot3, nombreAutomatizacion, folderName);

            WebElement btnSalvar= driver.findElement(By.xpath("//*[@id=\"WControllerfront-1437825718-window-overlays\"]/div[6]/div/div/div[5]/div/div/div[2]/div/div[1]/button/span"));
            btnSalvar.click();
            Thread.sleep(2000);

            a.ScreenShotPool(driver, i, "screen" + numScreenShoot4, nombreAutomatizacion, folderName);

            WebElement btnAceptar= driver.findElement(By.xpath("/*//*[@id=\"WControllerfront-1437825718-window-overlays\"]/div[3]/div/div/div[5]/div/div/div[2]/div/div[1]/button/span"));
            btnAceptar.click();
            Thread.sleep(2000);



        }catch (Exception e) {
            e.printStackTrace();
//                log.info(e);
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }
    public void ConsultaFormulaciones ( Metodos a, INTER_FormulacionesBean inter_formulacionesBean, int i, String folderName, int numScreenShoot) throws IOException, InterruptedException{

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

                if (texto.equals(inter_formulacionesBean.getBuscar())){
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

                if (texto.equals(inter_formulacionesBean.getBuscar())){
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

            a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion, folderName);

        }catch (Exception e) {
            e.printStackTrace();
//                log.info(e);
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }



}
