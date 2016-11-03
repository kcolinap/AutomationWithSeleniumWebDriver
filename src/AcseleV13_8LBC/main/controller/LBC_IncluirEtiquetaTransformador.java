package AcseleV13_8LBC.main.controller;

import AcseleV13_8LBC.beans.LBC_IncluirEtiquetaTransformadorBean;
import AcseleV13_8LBC.main.controller.LBC_Menu.LBC_MenuConfiguracion;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;

/**
 * Created by rmontilla on 01/11/2016.
 */
public class LBC_IncluirEtiquetaTransformador {

    private final static Logger log = Logger.getLogger(LBC_IncluirTransformadoresM.class);

    public String nombreAutomatizacion = "LBC Incluir Etiqueta Transformadores";

    public void testLink (LBC_IncluirEtiquetaTransformadorBean lbc_IncluirEtiquetaTransformadorBean, int i )  throws IOException, InterruptedException {

        //Metodos a = new Metodos();
        LBC_Metodos a = new LBC_Metodos();
        LBC_MenuConfiguracion m = new LBC_MenuConfiguracion();

        WebDriver driver = a.entrarPagina();
        a.IniciarSesion(driver, nombreAutomatizacion, i);
        a.ValidandoSesion(driver, nombreAutomatizacion, i);
        Thread.sleep(1500);
        System.out.println("prueba");


        m.NuevoPlantillasModoNoPrivilegiado(driver, nombreAutomatizacion, 2, i);

        a.cambiarVentana(driver);

        TranformadoresGeneral(driver, a, lbc_IncluirEtiquetaTransformadorBean, i);
        AgregarEtiquetaTranformadores( driver, a, lbc_IncluirEtiquetaTransformadorBean, i);

    }

    public void TranformadoresGeneral (WebDriver driver, LBC_Metodos a, LBC_IncluirEtiquetaTransformadorBean lbc_IncluirEtiquetaTransformadorBean, int i) throws IOException, InterruptedException{

        try {
            Thread.sleep(15000);
            WebElement carpetaTodas = driver.findElement(By.xpath("//*[@id=\"WControllerfront-1437825718\"]/div/div[2]/div/div/div/div[2]/div/div/div[2]/div/div/div[2]/div/div/div[3]/div/div/div[2]/div/div[2]/div[1]/table/tbody/tr[1]/td/div/span"));
            Thread.sleep(1000);
            carpetaTodas.click();
            Thread.sleep(3000);/*
            driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div/div[2]/div/div/div[2]/div/div/div[2]/div/div/div[3]/div/div/div[2]/div/div[2]/div[1]/table/tbody/tr[1]/td/div")).click();
            Thread.sleep(1000);*/


            WebElement prop = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div/div[2]/div/div/div[2]/div/div/div[2]/div/div/div[3]/div/div/div[1]/div/div/div[2]/input"));
            prop.sendKeys(lbc_IncluirEtiquetaTransformadorBean.getPropiedad());
            Thread.sleep(1000);
            driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div/div[2]/div/div/div[2]/div/div/div[2]/div/div/div[3]/div/div/div[1]/div/div/div[3]/button")).click();

            Thread.sleep(10000);
            for (int j = 1; j <= 5000; j++){

                //System.out.println("dentro del bucle: " + i);
                WebElement opcionNombre = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div/div[2]/div/div/div[2]/div/div/div[2]/div/div/div[3]/div/div/div[2]/div/div[2]/div[1]/table/tbody/tr["+j+"]/td/div")); //arreglo para seleccionar la lista deseada.

                String texto = opcionNombre.getText();

                //System.out.println("prueba-->>>>>"+opcionNombre+" => "+ opcionNombre.isEnabled());
                // System.out.println("Texto: " + texto);
                // System.out.println("Num" + j);
                //  nuevaPlantilla.click();

                if (texto.equals(lbc_IncluirEtiquetaTransformadorBean.getPropiedad())){
                    opcionNombre.click();
                    Thread.sleep(2000);
                    opcionNombre.click();
                    Thread.sleep(2000);
                    a.ScreenShotPool(driver, i, "screen3", nombreAutomatizacion);
                    System.out.println("Prueba: '" + texto + "' seleccionado");
                    break;
                }

            }
            Thread.sleep(2000);
            WebElement opcionTranformador = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div/div[2]/div/div/div[2]/div/div/div[3]/div/div/div/div/div[1]/button"));
            Thread.sleep(1000);
            opcionTranformador.click();
            Thread.sleep(3000);
            a.ScreenShotPool(driver, i, "screen4", nombreAutomatizacion);
            Thread.sleep(2000);


        }catch (Exception e) {
            e.printStackTrace();
//                log.info(e);
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);

        }
    }

    public void AgregarEtiquetaTranformadores (WebDriver driver, LBC_Metodos a, LBC_IncluirEtiquetaTransformadorBean lbc_IncluirEtiquetaTransformadorBean, int i) throws IOException, InterruptedException{

        try {
            Boolean transformador = driver.findElements(By.xpath("/html/body/div[5]/div[3]/div/div/div[5]/div/div/div[3]/div/div[2]/div[2]/div[1]/table/tbody/tr[2]/td[1]/div")).size() > 0;

            if (!transformador){

                WebElement clicTran =  driver.findElement(By.xpath("/html/body/div[5]/div[3]/div/div/div[5]/div/div/div[3]/div/div[2]/div[2]/div[1]/table/tbody/tr/td[1]/div"));
                clicTran.click();
                Thread.sleep(2000);
                a.ScreenShotPool(driver, i, "screen5", nombreAutomatizacion);
                Thread.sleep(1000);
            }

            else{

                for (int j = 1; j <= 50; j++){

                    //System.out.println("dentro del bucle: " + i);
                    WebElement opcionNombre = driver.findElement(By.xpath("/html/body/div[5]/div[3]/div/div/div[5]/div/div/div[3]/div/div[2]/div[2]/div[1]/table/tbody/tr["+j+"]/td[1]/div")); //arreglo para seleccionar la lista deseada.

                    String texto = opcionNombre.getText();

                    //System.out.println("prueba-->>>>>"+opcionNombre+" => "+ opcionNombre.isEnabled());
                    // System.out.println("Texto: " + texto);
                    // System.out.println("Num" + j);
                    //  nuevaPlantilla.click();

                    if (texto.equals(lbc_IncluirEtiquetaTransformadorBean.getValor())){
                        opcionNombre.click();
                        Thread.sleep(2000);
                        //opcionNombre.click();
                        //Thread.sleep(1000);
                        a.ScreenShotPool(driver, i, "screen5", nombreAutomatizacion);
                        System.out.println("Prueba: '" + texto + "' seleccionado");
                        break;
                    }

                }

            }

            Thread.sleep(2000);
            WebElement btnEtiqueta = driver.findElement(By.xpath("/html/body/div[5]/div[3]/div/div/div[5]/div/div/div[4]/div/div[5]/button"));
            btnEtiqueta.click();

            Thread.sleep(2000);
            WebElement btnAgregar = driver.findElement(By.xpath("/html/body/div[5]/div[6]/div/div/div[5]/div/div/div[3]/div/div[1]/button"));
            btnAgregar.click();

            Thread.sleep(2000);
            WebElement label = driver.findElement(By.xpath("/html/body/div[5]/div[6]/div/div/div[5]/div/div/div[1]/div/div[2]/div[1]/table/tbody/tr/td[1]/div/input"));
            label.sendKeys(lbc_IncluirEtiquetaTransformadorBean.getLabel());

            Thread.sleep(2000);
            if (lbc_IncluirEtiquetaTransformadorBean.getLocale().equals("es_BO")){
                Thread.sleep(1000);
                WebElement locale = driver.findElement(By.xpath("/html/body/div[5]/div[6]/div/div/div[5]/div/div/div[1]/div/div[2]/div[1]/table/tbody/tr/td[2]/div/div/div"));
                locale.click();
                Thread.sleep(1000);
                WebElement select  = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[2]/table/tbody/tr/td/span"));
                select.click();
            }

            WebElement producto = driver.findElement(By.xpath("/html/body/div[5]/div[6]/div/div/div[5]/div/div/div[1]/div/div[2]/div[1]/table/tbody/tr/td[3]/div/div/div"));
            producto.click();

            for (int x = 1; x <= 50; x++){

                //System.out.println("dentro del bucle: " + i);
                if (x == 11) {
                    Thread.sleep(1000);
                    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[3]/span")).click();
                    Thread.sleep(2000);
                    x=1;
                }
                Thread.sleep(3000);
                WebElement opcionProducto = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[2]/table/tbody/tr["+x+"]/td")); //arreglo para seleccionar la lista deseada.
                String texto = opcionProducto.getText();

                //System.out.println("prueba-->>>>>"+opcionNombre+" => "+ opcionNombre.isEnabled());
                // System.out.println("Texto: " + texto);
                // System.out.println("Num" + j);
                //  nuevaPlantilla.click();


                if (texto.equals(lbc_IncluirEtiquetaTransformadorBean.getProducto())){
                    opcionProducto.click();
                     Thread.sleep(2000);
                    a.ScreenShotPool(driver, i, "screen6", nombreAutomatizacion);
                    System.out.println("Prueba: '" + texto + "' seleccionado");
                    break;
                }

            }

            WebElement btnAceptar = driver.findElement(By.xpath("/html/body/div[5]/div[6]/div/div/div[5]/div/div/div[3]/div/div[5]/button"));
            btnAceptar.click();

            Thread.sleep(2000);
            a.ScreenShotPool(driver, i, "screen7", nombreAutomatizacion);
            Thread.sleep(2000);




        }catch (Exception e) {
            e.printStackTrace();
//                log.info(e);
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }

    }

}
