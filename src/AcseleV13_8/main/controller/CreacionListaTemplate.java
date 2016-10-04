package AcseleV13_8.main.controller;

import AcseleV13_8.beans.CreacionListaTemplateBean;
import AcseleV13_8.main.controller.Menu.MenuConfiguracion;
import AcseleV13_8.main.controller.Menu.MenuMantenimiento;
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
        MenuMantenimiento menuMantenimiento = new MenuMantenimiento();



        WebDriver driver = a.entrarPagina();
        a.IniciarSesion(driver, nombreAutomatizacion, i);
        a.ValidandoSesion(driver, nombreAutomatizacion, i);
        Thread.sleep(1500);
        System.out.println("prueba");


        m.NuevoPlantillasModoNoPrivilegiado(driver, nombreAutomatizacion, 3, i);

        Thread.sleep(2000);
        a.cambiarVentana(driver);

        CrearNuevaLista (driver, a, creacionListaTemplateBean, i);
        driver.close();
        Thread.sleep(1000);


        a.regresarVentana(driver);
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/table/tbody/tr[4]/td/table/tbody/tr/td[1]/div")).click();
        Thread.sleep(1000);
        menuMantenimiento.AdminLisRest_CrearListasRestrictivas(driver, nombreAutomatizacion, 3, i);
        Thread.sleep(3000);
        a.cambiarVentana(driver);

        ListasRestrictivasCreacion (driver, a, creacionListaTemplateBean, i);
        Thread.sleep(1000);

    }

   public void CrearNuevaLista (WebDriver driver, Metodos a, CreacionListaTemplateBean creacionListaTemplateBean, int i) throws IOException, InterruptedException{

        try{
            Actions action = new Actions(driver);
            Thread.sleep(8000);
            WebElement scroll = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div/div[2]/div/div/div[2]/div/div/div[2]/div/div/div[1]/div/div[2]")); // se usa para mover el scroll
            scroll.sendKeys(Keys.PAGE_DOWN);
            scroll.sendKeys(Keys.PAGE_DOWN);
            scroll.sendKeys(Keys.PAGE_DOWN);
            scroll.sendKeys(Keys.PAGE_DOWN);
            Thread.sleep(3000);

            WebElement plantillaPrincipal = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div/div[2]/div/div/div[2]/div/div/div[2]/div/div/div[1]/div/div[2]/div[1]/table/tbody/tr[41]/td/div")); // selecciona la plantilla principal de listas restrictivas
            plantillaPrincipal.click();
            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen4", nombreAutomatizacion);
            Thread.sleep(1000);

            WebElement plantillaListas = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div/div[2]/div/div/div[2]/div/div/div[2]/div/div/div[1]/div/div[2]/div[1]/table/tbody/tr[41]/td/div/span")); //despliega la carpeta con todas las listas restrictivas existentes
            plantillaListas.click();
            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen5", nombreAutomatizacion);
            Thread.sleep(1000);

            WebElement btnPlantillas = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div/div[2]/div/div/div[1]/div/div/div/div/div/div/div/span[1]/span[2]")); // selecciona el boton plantillas
            btnPlantillas.click();
            Thread.sleep(1000);

            WebElement opcionAgregar = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div/span[1]/span")); // selecciona la opcion agregar del menu Plantillas
            Thread.sleep(1000);
            action.moveToElement(opcionAgregar).build().perform();
            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen6", nombreAutomatizacion);
            Thread.sleep(1000);
            opcionAgregar.click();
            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen7", nombreAutomatizacion);

            WebElement nombrePlantillaNueva = driver.findElement(By.xpath("/html/body/div[5]/div[3]/div/div/div[5]/div/div/div[3]/input")); //se agrega el nombre de la nueva plantilla
            nombrePlantillaNueva.sendKeys(creacionListaTemplateBean.getNombrePlantilla());
            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen8", nombreAutomatizacion);
            Thread.sleep(1000);

            WebElement btnAceptar = driver.findElement(By.xpath("/html/body/div[5]/div[3]/div/div/div[5]/div/div/div[5]/div/div[1]/button")); //se acacta la creacion de la nueva plantilla
            btnAceptar.click();
            Thread.sleep(2000);



            //System.out.println("prueba ingreso bucle");
            for (int j = 1; j <= 200; j++){

                //System.out.println("dentro del bucle: " + i);
                WebElement nuevaPlantilla = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div/div[2]/div/div/div[2]/div/div/div[2]/div/div/div[1]/div/div[2]/div[1]/table/tbody/tr[" + j + "]/td/div")); //arreglo para seleccionar la ultima plantilla creada
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


            WebElement carpetaPropiedades = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div/div[2]/div/div/div[2]/div/div/div[2]/div/div/div[3]/div/div/div[2]/div/div[2]/div[1]/table/tbody/tr[6]/td/div")); //selecciona la carpeta con las propiedades de listas restrictivas
            carpetaPropiedades.click();
            Thread.sleep(1000);

            WebElement carpPropiedades = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div/div[2]/div/div/div[2]/div/div/div[2]/div/div/div[3]/div/div/div[2]/div/div[2]/div[1]/table/tbody/tr[6]/td/div/span")); // despliega la carpeta con las propiedades
            carpPropiedades.click();
            Thread.sleep(1500);

            WebElement propiedadLista = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div/div[2]/div/div/div[2]/div/div/div[2]/div/div/div[3]/div/div/div[2]/div/div[2]/div[1]/table/tbody/tr[16]/td/div"));// selecciona la propiedad
            propiedadLista.click();
            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen9", nombreAutomatizacion);
            Thread.sleep(1500);

            WebElement asociarPropiedad = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div/div[2]/div/div/div[2]/div/div/div[1]/div/div/div/div/div[1]/button")); //hace click en el incono de asociar propiedad
            asociarPropiedad.click();
            Thread.sleep(2000);


            for (int j = 1; j <= 50; j++){

                System.out.println("dentro del bucle: " + i);
                WebElement listaPropiedad = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div/div[2]/div/div/div[2]/div/div/div[2]/div/div/div[1]/div/div[2]/div[1]/table/tbody/tr[" + j + "]/td/div")); //arreglo para desplegar la carpeta de la ultima plantilla creada

                WebElement listaPropiedadCarpeta = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div/div[2]/div/div/div[2]/div/div/div[2]/div/div/div[1]/div/div[2]/div[1]/table/tbody/tr[" + j + "]/td/div/span")); //arreglo para desplegar la carpeta de la ultima plantilla creada

                String texto = listaPropiedad.getText();

                //System.out.println("prueba-->>>>>"+listaPropiedad+" => "+ listaPropiedad.isEnabled());
                System.out.println("Texto: " + texto);


                if (texto.equals(creacionListaTemplateBean.getNombrePlantilla())){
                    listaPropiedadCarpeta.click();
                    Thread.sleep(1000);
                    a.ScreenShotPool(driver, i, "screen10", nombreAutomatizacion);
                    System.out.println("Prueba: '" + texto + "' seleccionado");
                    break;
                 }

            }

            Thread.sleep(2000);


            WebElement btnSalvar = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div/div[2]/div/div/div[2]/div/div/div[1]/div/div/div/div/div[9]/button"));
            btnSalvar.click();
            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen11", nombreAutomatizacion);
            Thread.sleep(1000);

            WebElement btnAcept = driver.findElement(By.xpath("/html/body/div[5]/div[3]/div/div/div[5]/div/div/div/div[3]/div/div[1]/button"));
            btnAcept.click();
            Thread.sleep(2000);


        }catch (Exception e) {
            e.printStackTrace();
//                log.info(e);
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);

        }
    }

    public void ListasRestrictivasCreacion (WebDriver driver, Metodos a, CreacionListaTemplateBean creacionListaTemplateBean, int i) throws IOException, InterruptedException{

        try {

            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen12", nombreAutomatizacion);
            Thread.sleep(1000);

            WebElement btnAgregar = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/div[1]/div/div/div/span/span")); //hace click al boton agregar en listas restrictivas
            btnAgregar.click();
            Thread.sleep(2000);
            a.ScreenShotPool(driver, i, "screen13", nombreAutomatizacion);
            Thread.sleep(1000);

            WebElement tipo = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/div[1]/div/div/div[1]/div/div/div[2]/div/div")); //despliega los tipos de lista disponibles
            tipo.click();
            Thread.sleep(1000);

            WebElement opcion = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[2]/table/tbody/tr[2]/td")); // selecciona el tipo de lista
            opcion.click();
            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen14", nombreAutomatizacion);
            Thread.sleep(1000);

            WebElement nombre = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/div[1]/div/div/div[2]/div/div/div[2]/div/div")); //despliega las listas que existen en el tempolate tool
            nombre.click();
            Thread.sleep(1500);

            for (int j = 1; j<= 50; j++){

                //System.out.println("dentro del bucle: " + i);
                WebElement opcionNombre = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[2]/table/tbody/tr[" + j + "]/td/span")); //arreglo para seleccionar la ultima plantilla creada

                String texto = opcionNombre.getText();

                //System.out.println("prueba-->>>>>"+opcionNombre+" => "+ opcionNombre.isEnabled());
                //System.out.println("Texto: " + texto);
                //  nuevaPlantilla.click();

                if (texto.equals(creacionListaTemplateBean.getNombrePlantilla())){
                    opcionNombre.click();
                    Thread.sleep(1000);
                    a.ScreenShotPool(driver, i, "screen15", nombreAutomatizacion);
                    System.out.println("Prueba: '" + texto + "' seleccionado");
                    break;
                }

            }

            Thread.sleep(2000);
            WebElement campoArchivo = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/div[1]/div/div/div[3]/div/div/div[2]/form/div/input[2]")); //se ubica el boton archivo
            Thread.sleep(1000);
            campoArchivo.click();

            Runtime.getRuntime().exec("C:\\AcseleTests\\AutomationTestAcsele\\AutoIT\\ListasTemplate.exe");  //se importa el archivo cn la data de la nueva lista
            Thread.sleep(1500);
            a.ScreenShotPool(driver, i, "screen16", nombreAutomatizacion);
            Thread.sleep(1000);


            WebElement btnAceptar = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/div[3]/div/div/div/div/span/span"));
            Thread.sleep(1000);
            btnAceptar.click();
            Thread.sleep(3000);

            for (int j = 1; j <= 50; j++){

                //System.out.println("dentro del bucle: " + i);
                WebElement nuevaLista = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/div[3]/div/div[3]/div[1]/table/tbody/tr[" + j + "]/td[1]/div")); //arreglo para seleccionar la ultima plantilla creada
                String texto = nuevaLista.getText();

                //System.out.println("prueba-->>>>>"+opcionNombre+" => "+ opcionNombre.isEnabled());
                //System.out.println("Texto: " + texto);
                //  nuevaPlantilla.click();

                if (texto.equals(creacionListaTemplateBean.getNombrePlantilla())){
                    nuevaLista.click();
                    Thread.sleep(1000);
                    a.ScreenShotPool(driver, i,  "screen17", nombreAutomatizacion);
                    System.out.println("Prueba: '" + texto + "' seleccionado");
                    break;
                }

            }
            Thread.sleep(1000);
            WebElement btnConsultar = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/div[7]/div/div[1]/div/span/span")); // selecciona el boton consultar para ver la informacion del ultimo import
            //Thread.sleep(1000);
            btnConsultar.click();
            Thread.sleep(1500);

            WebElement ultimoRegistro = driver.findElement(By.xpath("/html/body/div[3]/div[5]/div/div/div[5]/div/div/div[2]/div/div[1]/div/div[3]/div[1]/table/tbody/tr[1]/td[1]/div/div/span/input")); // selecciona la fecha mas reciente
            ultimoRegistro.click();
            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen18", nombreAutomatizacion);
            Thread.sleep(1000);

            WebElement btnAcept = driver.findElement(By.xpath("/html/body/div[3]/div[5]/div/div/div[5]/div/div/div[3]/div/div/div[1]/div/span")); //gace click al boton aceptar y muestra el detalle del import
            btnAcept.click();
            Thread.sleep(2000);
            a.ScreenShotPool(driver, i, "screen19", nombreAutomatizacion);


        }catch (Exception e) {
            e.printStackTrace();
//                log.info(e);
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
    }



    }

}
