package AcseleV13_8.main.controller;

import AcseleV13_8.beans.CreacionListaTemplateBean;
import AcseleV13_8.main.controller.Menu.MenuConfiguracion;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import sun.font.TextRecord;

import java.io.IOException;

/**
 * Created by kzambrano on 01/09/2016.
 */
public class CreacionListaTemplate {

    private final static Logger log = Logger.getLogger(Transformadores.class);

    public String nombreAutomatizacion = "Creacion listas Restrictivas Template";

    public void testLink (CreacionListaTemplateBean creacionListaTemplateBean, int i )  throws IOException, InterruptedException {

        //Metodos a = new Metodos();
        Metodos a = new Metodos();
        MenuConfiguracion m = new MenuConfiguracion();


        WebDriver driver = a.entrarPagina();
        a.IniciarSesion(driver, nombreAutomatizacion);
        a.ValidandoSesion(driver, nombreAutomatizacion);
        Thread.sleep(1500);
        System.out.println("prueba");

        m.NuevoPlantillasModoNoPrivilegiado(a, driver, nombreAutomatizacion);
        Thread.sleep(2000);
        a.cambiarVentana(driver);

        CrearNuevaLista (driver, a, creacionListaTemplateBean);

    }

    public void CrearNuevaLista (WebDriver driver, Metodos a, CreacionListaTemplateBean creacionListaTemplateBean) throws IOException, InterruptedException{

        try{
            Actions action = new Actions(driver);
            Thread.sleep(5000);
            WebElement scroll = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div/div[2]/div/div/div[2]/div/div/div[2]/div/div/div[1]/div/div[2]")); // se usa para mover el scroll
            scroll.sendKeys(Keys.PAGE_DOWN);
            scroll.sendKeys(Keys.PAGE_DOWN);
            scroll.sendKeys(Keys.PAGE_DOWN);
            scroll.sendKeys(Keys.PAGE_DOWN);
            Thread.sleep(3000);

            WebElement plantillaPrincipal = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div/div[2]/div/div/div[2]/div/div/div[2]/div/div/div[1]/div/div[2]/div[1]/table/tbody/tr[41]/td/div")); // selecciona la plantilla principal de listas restrictivas
            plantillaPrincipal.click();
            Thread.sleep(1000);
            a.ScreenShot(driver, "screen4", nombreAutomatizacion);
            Thread.sleep(1000);

            WebElement plantillaListas = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div/div[2]/div/div/div[2]/div/div/div[2]/div/div/div[1]/div/div[2]/div[1]/table/tbody/tr[41]/td/div/span")); //despliega la carpeta con todas las listas restrictivas existentes
            plantillaListas.click();
            Thread.sleep(1000);
            a.ScreenShot(driver, "screen5", nombreAutomatizacion);
            Thread.sleep(1000);

            WebElement btnPlantillas = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div/div[2]/div/div/div[1]/div/div/div/div/div/div/div/span[1]/span[2]")); // selecciona el boton plantillas
            btnPlantillas.click();
            Thread.sleep(1000);

            WebElement opcionAgregar = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div/span[1]/span")); // selecciona la opcion agregar del menu Plantillas
            Thread.sleep(1000);
            action.moveToElement(opcionAgregar).build().perform();
            Thread.sleep(1000);
            a.ScreenShot(driver, "screen6", nombreAutomatizacion);
            Thread.sleep(1000);
            opcionAgregar.click();
            Thread.sleep(1000);
            a.ScreenShot(driver, "screen7", nombreAutomatizacion);

            WebElement nombrePlantillaNueva = driver.findElement(By.xpath("/html/body/div[5]/div[3]/div/div/div[5]/div/div/div[3]/input")); //se agrega el nombre de la nueva plantilla
            nombrePlantillaNueva.sendKeys(creacionListaTemplateBean.getNombrePlantilla());
            Thread.sleep(1000);
            a.ScreenShot(driver,"screen8", nombreAutomatizacion);
            Thread.sleep(1000);

            WebElement btnAceptar = driver.findElement(By.xpath("/html/body/div[5]/div[3]/div/div/div[5]/div/div/div[5]/div/div[1]/button")); //se acacta la creacion de la nueva plantilla
            btnAceptar.click();
            Thread.sleep(2000);



            //System.out.println("prueba ingreso bucle");
            for (int i = 1; i <= 50; i++){

                //System.out.println("dentro del bucle: " + i);
                WebElement nuevaPlantilla = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div/div[2]/div/div/div[2]/div/div/div[2]/div/div/div[1]/div/div[2]/div[1]/table/tbody/tr[" + i + "]/td/div")); //arreglo para seleccionar la ultima plantilla creada
                String texto = nuevaPlantilla.getText();

                //System.out.println("prueba-->>>>>"+nuevaPlantilla+" => "+ nuevaPlantilla.isEnabled());
                //System.out.println("Texto: " + texto);
              //  nuevaPlantilla.click();

                if (texto.equals(creacionListaTemplateBean.getNombrePlantilla())){
                    nuevaPlantilla.click();
                    System.out.println("Prueba: '" + texto + "' seleccionado");
                    break;
                }

            }

            Thread.sleep(2000);

           /* WebElement nuevaLista =driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div/div[2]/div/div/div[2]/div/div/div[2]/div/div/div[1]/div/div[2]/div[1]/table/tbody/tr[48]/td/div"));
            nuevaLista.click();
            Thread.sleep(1000);
            a.ScreenShot(driver, "screen9", nombreAutomatizacion);
            Thread.sleep(1500);
*/
            WebElement carpetaPropiedades = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div/div[2]/div/div/div[2]/div/div/div[2]/div/div/div[3]/div/div/div[2]/div/div[2]/div[1]/table/tbody/tr[6]/td/div")); //selecciona la carpeta con las propiedades de listas restrictivas
            carpetaPropiedades.click();
            Thread.sleep(1000);

            WebElement carpPropiedades = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div/div[2]/div/div/div[2]/div/div/div[2]/div/div/div[3]/div/div/div[2]/div/div[2]/div[1]/table/tbody/tr[6]/td/div/span")); // despliega la carpeta con las propiedades
            carpPropiedades.click();
            Thread.sleep(1500);

            WebElement propiedadLista = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div/div[2]/div/div/div[2]/div/div/div[2]/div/div/div[3]/div/div/div[2]/div/div[2]/div[1]/table/tbody/tr[16]/td/div"));// selecciona la propiedad
            propiedadLista.click();
            Thread.sleep(1000);
            a.ScreenShot(driver, "screen9", nombreAutomatizacion);
            Thread.sleep(1500);

            WebElement asociarPropiedad = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div/div[2]/div/div/div[2]/div/div/div[1]/div/div/div/div/div[1]/button")); //hace click en el incono de asociar propiedad
            asociarPropiedad.click();
            Thread.sleep(2000);


            for (int i = 1; i <= 50; i++){

                System.out.println("dentro del bucle: " + i);
                WebElement listaPropiedad = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div/div[2]/div/div/div[2]/div/div/div[2]/div/div/div[1]/div/div[2]/div[1]/table/tbody/tr[" + i + "]/td/div")); //arreglo para desplegar la carpeta de la ultima plantilla creada

                WebElement listaPropiedadCarpeta = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div/div[2]/div/div/div[2]/div/div/div[2]/div/div/div[1]/div/div[2]/div[1]/table/tbody/tr[" + i + "]/td/div/span")); //arreglo para desplegar la carpeta de la ultima plantilla creada

                String texto = listaPropiedad.getText();

                //System.out.println("prueba-->>>>>"+listaPropiedad+" => "+ listaPropiedad.isEnabled());
                System.out.println("Texto: " + texto);


                if (texto.equals(creacionListaTemplateBean.getNombrePlantilla())){
                    listaPropiedadCarpeta.click();
                    Thread.sleep(1000);
                    a.ScreenShot(driver, "screen10", nombreAutomatizacion);
                    System.out.println("Prueba: '" + texto + "' seleccionado");
                    break;
                 }

            }

            Thread.sleep(2000);


            WebElement btnSalvar = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div/div[2]/div/div/div[2]/div/div/div[1]/div/div/div/div/div[9]/button"));
            btnSalvar.click();
            Thread.sleep(1000);
            a.ScreenShot(driver, "screen11", nombreAutomatizacion);
            Thread.sleep(1000);

            WebElement btnAcept = driver.findElement(By.xpath("/html/body/div[5]/div[3]/div/div/div[5]/div/div/div/div[3]/div/div[1]/button"));
            btnAcept.click();


        }catch (Exception e) {
            e.printStackTrace();
//                log.info(e);
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);

        }
    }

}
