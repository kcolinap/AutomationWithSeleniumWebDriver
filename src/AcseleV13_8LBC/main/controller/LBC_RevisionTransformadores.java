package AcseleV13_8LBC.main.controller;

import AcseleV13_8LBC.beans.LBC_RevisionTransformadoresBean;
import AcseleV13_8LBC.main.controller.LBC_Menu.LBC_MenuConfiguracion;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;

/**
 * Created by rmontilla on 03/11/2016.
 */
public class LBC_RevisionTransformadores {

    private final static Logger log = Logger.getLogger(LBC_RevisionTransformadores.class);

    public String nombreAutomatizacion = "LBC Revision Transformadores";

    public void testLink (LBC_RevisionTransformadoresBean lbc_RevisionTransformadoresBean, int i )  throws IOException, InterruptedException {

        //Metodos a = new Metodos();
        LBC_Metodos a = new LBC_Metodos();
        LBC_MenuConfiguracion m = new LBC_MenuConfiguracion();

        WebDriver driver = a.entrarPagina();
        a.IniciarSesion(driver, nombreAutomatizacion, i);
        a.ValidandoSesion(driver, nombreAutomatizacion, i);
        Thread.sleep(1500);
        System.out.println("prueba");


        m.NuevoPlantillasModoNoPrivilegiado(driver, nombreAutomatizacion, 2, i);

        Thread.sleep(2000);
        a.cambiarVentana(driver);

        TranformadoresGeneral(driver, a, lbc_RevisionTransformadoresBean, i);

    }

    public void TranformadoresGeneral (WebDriver driver, LBC_Metodos a, LBC_RevisionTransformadoresBean lbcRevisionTransformadoresBean, int i) throws IOException, InterruptedException{

        try {
            Thread.sleep(15000);
            WebElement carpetaTodas = driver.findElement(By.xpath("//*[@id=\"WControllerfront-1437825718\"]/div/div[2]/div/div/div/div[2]/div/div/div[2]/div/div/div[2]/div/div/div[3]/div/div/div[2]/div/div[2]/div[1]/table/tbody/tr[1]/td/div/span"));
            Thread.sleep(1000);
            carpetaTodas.click();
            Thread.sleep(3000);/*
            driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div/div[2]/div/div/div[2]/div/div/div[2]/div/div/div[3]/div/div/div[2]/div/div[2]/div[1]/table/tbody/tr[1]/td/div")).click();
            Thread.sleep(1000);*/


            WebElement propiedad = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div/div[2]/div/div/div[2]/div/div/div[2]/div/div/div[3]/div/div/div[1]/div/div/div[2]/input"));
            propiedad.sendKeys(lbcRevisionTransformadoresBean.getBuscar());
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

                if (texto.equals(lbcRevisionTransformadoresBean.getBuscar())){
                    opcionNombre.click();
                    Thread.sleep(2000);
                    opcionNombre.click();
                    Thread.sleep(1000);
                    a.ScreenShotPool(driver, i, "screen3", nombreAutomatizacion);
                    System.out.println("Prueba: '" + texto + "' seleccionado");
                    break;
                }

            }

            WebElement opcionTranformador = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div/div[2]/div/div/div[2]/div/div/div[3]/div/div/div/div/div[1]/button"));
            Thread.sleep(1000);
            opcionTranformador.click();
            Thread.sleep(3000);
            a.ScreenShotPool(driver, i, "screen4", nombreAutomatizacion);



        }catch (Exception e) {
            e.printStackTrace();
//                log.info(e);
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);

        }
    }

}
