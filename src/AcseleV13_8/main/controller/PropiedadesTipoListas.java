package AcseleV13_8.main.controller;

import AcseleV13_8.beans.PropiedadesTipoListasBean;
import AcseleV13_8.main.controller.Menu.MenuConfiguracion;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;

/**
 * Created by aazuaje on 22/08/2016.
 */
public class PropiedadesTipoListas {

    private final static Logger log = Logger.getLogger(PropiedadesTipoListas.class);

    public String nombreAutomatizacion = "Propiedades Listas";


    public void testLink(PropiedadesTipoListasBean propiedadesTipoListasBean,int i) throws IOException, InterruptedException {

        //implementando clase de metodos
        Metodos a = new Metodos();
        MenuConfiguracion m = new MenuConfiguracion();
        WebDriver driver = a.entrarPagina();
        a.IniciarSesion(driver, nombreAutomatizacion, i);
        a.ValidandoSesion(driver, nombreAutomatizacion, i);
        Thread.sleep(8000);



        m.NuevoPlantillasModoNoPrivilegiado(driver, nombreAutomatizacion, 3, i);

        Thread.sleep(3000);
        a.cambiarVentana(driver);
        AgregarPropiedades (driver, a, propiedadesTipoListasBean, i);
        ConsultaLista (driver, a, propiedadesTipoListasBean, i);


    }


    public void AgregarPropiedades (WebDriver driver, Metodos a, PropiedadesTipoListasBean propiedadesTipoListasBean, int i) throws IOException, InterruptedException{

        try{
            Thread.sleep(8000);
            a.ScreenShotPool(driver,i,"screen4",nombreAutomatizacion);

            WebElement btnPropiedades = driver.findElement(By.xpath("//*[@id=\"WControllerfront-1437825718\"]/div/div[2]/div/div/div/div[2]/div/div/div[1]/div/div/div/div/div/div/div/span[2]/span[2]"));
            btnPropiedades.click();

            Thread.sleep(1000);
            WebElement btnAgregar = driver.findElement(By.xpath("//*[@id=\"WControllerfront-1437825718-overlays\"]/div[2]/div/div/span[1]/span"));
            btnAgregar.click();
            Thread.sleep(2000);

            WebElement nombrePropiedad = driver.findElement(By.xpath("//*[@id=\"WControllerfront-1437825718-window-overlays\"]/div[3]/div/div/div[5]/div/div/div[3]/input"));
            nombrePropiedad.sendKeys(propiedadesTipoListasBean.getNombrePropiedad());
            Thread.sleep(1000);
            a.ScreenShotPool(driver,i,"screen5",nombreAutomatizacion);

            WebElement btnAceptar = driver.findElement(By.xpath("//*[@id=\"WControllerfront-1437825718-window-overlays\"]/div[3]/div/div/div[5]/div/div/div[5]/div/div[1]/button/span"));
            btnAceptar.click();
            Thread.sleep(3000);

            WebElement buscar = driver.findElement(By.xpath("//*[@id=\"WControllerfront-1437825718\"]/div/div[2]/div/div/div/div[2]/div/div/div[2]/div/div/div[2]/div/div/div[3]/div/div/div[1]/div/div/div[2]/input"));
            buscar.sendKeys(propiedadesTipoListasBean.getBuscar());
            Thread.sleep(1000);

            WebElement btnBuscar = driver.findElement(By.xpath("//*[@id=\"WControllerfront-1437825718\"]/div/div[2]/div/div/div/div[2]/div/div/div[2]/div/div/div[2]/div/div/div[3]/div/div/div[1]/div/div/div[3]/button/img"));
            btnBuscar.click();
            a.ScreenShotPool(driver,i,"screen6",nombreAutomatizacion);
            Thread.sleep(2000);

            for (int j = 1; j <= 3000; j++){

                //System.out.println("dentro del bucle: " + j);
                WebElement propiedad = driver.findElement(By.xpath("//*[@id=\"WControllerfront-1437825718\"]/div/div[2]/div/div/div/div[2]/div/div/div[2]/div/div/div[2]/div/div/div[3]/div/div/div[2]/div/div[2]/div[1]/table/tbody/tr[" + j + "]/td/div")); //arreglo para seleccionar la ultima plantilla creada

                String texto = propiedad.getText();

                //System.out.println("prueba-->>>>>"+opcionNombre+" => "+ opcionNombre.isEnabled());
                //System.out.println("Texto: " + texto);
                //  nuevaPlantilla.click();

                if (texto.equals(propiedadesTipoListasBean.getBuscar())){
                    propiedad.click();
                    Thread.sleep(1000);
                    // a.ScreenShotPool(driver, i, "screen7", nombreAutomatizacion);
                    System.out.println("Prueba: '" + texto + "' seleccionado");
                    break;
                }

            }

            for (int j = 1; j <= 3000; j++){

              //  System.out.println("dentro del bucle: " + j);
                WebElement propiedad = driver.findElement(By.xpath("//*[@id=\"WControllerfront-1437825718\"]/div/div[2]/div/div/div/div[2]/div/div/div[2]/div/div/div[2]/div/div/div[3]/div/div/div[2]/div/div[2]/div[1]/table/tbody/tr[" + j + "]/td/div")); //arreglo para seleccionar la ultima plantilla creada

                String texto = propiedad.getText();

                //System.out.println("prueba-->>>>>"+opcionNombre+" => "+ opcionNombre.isEnabled());
                //System.out.println("Texto: " + texto);
                //  nuevaPlantilla.click();

                if (texto.equals(propiedadesTipoListasBean.getBuscar())){
                    propiedad.click();
                    Thread.sleep(1000);
                    // a.ScreenShotPool(driver, i, "screen7", nombreAutomatizacion);
                    System.out.println("Prueba: '" + texto + "' seleccionado");
                    break;
                }

            }

          /*  WebElement prueba2 = driver.findElement(By.xpath("//*[@id=\"WControllerfront-1437825718\"]/div/div[2]/div/div/div/div[2]/div/div/div[2]/div/div/div[2]/div/div/div[3]/div/div/div[2]/div/div[2]/div[1]/table/tbody/tr[116]/td/div"));
            prueba2.click();
            Thread.sleep(1000);
*/
            WebElement btnAsignarPresentacion = driver.findElement(By.xpath("//*[@id=\"WControllerfront-1437825718\"]/div/div[2]/div/div/div/div[2]/div/div/div[2]/div/div/div[3]/div/div/div/div/div[5]/button/img"));
            btnAsignarPresentacion.click();
            Thread.sleep(1000);

            WebElement btnSeleccionar = driver.findElement(By.xpath("//*[@id=\"WControllerfront-1437825718-window-overlays\"]/div[3]/div/div/div[5]/div/div/div[1]/div/div/div[1]/div/div[3]/div/div"));
            btnSeleccionar.click();
            Thread.sleep(1000);
            WebElement tipoVisualizacion  = driver.findElement(By.xpath("//*[@id=\"VAADIN_COMBOBOX_OPTIONLIST\"]/div/div[2]/table/tbody/tr[3]/td/span"));
            tipoVisualizacion.click();
            Thread.sleep(1000);


            Thread.sleep(1000);
            a.ScreenShotPool(driver,i,"screen7",nombreAutomatizacion);
            Thread.sleep(2000);
            WebElement btnAceptar2 = driver.findElement(By.xpath("//*[@id=\"WControllerfront-1437825718-window-overlays\"]/div[3]/div/div/div[5]/div/div/div[2]/div/div[1]/button/span"));
            btnAceptar2.click();


        }catch (Exception e) {
            e.printStackTrace();
//                log.info(e);
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }


    }

    public void ConsultaLista (WebDriver driver, Metodos a, PropiedadesTipoListasBean propiedadesTipoListasBean, int i) throws IOException, InterruptedException{

        try{

            Thread.sleep(5000);
            
            WebElement btnAsignarPresentacion = driver.findElement(By.xpath("//*[@id=\"WControllerfront-1437825718\"]/div/div[2]/div/div/div/div[2]/div/div/div[2]/div/div/div[3]/div/div/div/div/div[5]/button/img"));
            btnAsignarPresentacion.click();
            Thread.sleep(2000);
            a.ScreenShotPool(driver,i,"screen8",nombreAutomatizacion);
            Thread.sleep(1000);


        }catch (Exception e) {
            e.printStackTrace();
//                log.info(e);
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }
}
