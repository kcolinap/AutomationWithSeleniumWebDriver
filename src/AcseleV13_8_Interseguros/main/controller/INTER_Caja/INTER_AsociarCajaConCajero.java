package AcseleV13_8_Interseguros.main.controller.INTER_Caja;


import AcseleV13_8_Interseguros.beans.INTER_CajaBean;
import metodo.Metodos;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;

/**
 * Created by mchurion on 07/12/2016.
 */
public class INTER_AsociarCajaConCajero {
    private final static Logger log = Logger.getLogger(INTER_AsociarCajaConCajero.class);

    public void AsociarCajaConCajero(Metodos a, WebDriver driver, INTER_CajaBean interCajaBean, String nombreAutomatizacion, int i, String folderName, int numScreenShoot, int numScreenShoot2, int numScreenShoot3, int numScreenShoot4){

        try {
            Thread.sleep(2000);

            // Pantalla inicial
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion, folderName);
            Toolkit.getDefaultToolkit().beep();

            Thread.sleep(1000);

            // Llenado del formulario
            String textoCajero = null;
            if (interCajaBean.getCajero() != null){
                Select cajero = new Select(driver.findElement(By.xpath("/html/body/center/form/table[1]/tbody/tr[1]/td[2]/select")));
                cajero.selectByValue(interCajaBean.getCajero());
                textoCajero = cajero.getFirstSelectedOption().getText();
                Thread.sleep(2000);
            }
            System.out.println("Texto del select cajero: " + textoCajero);

            String textoNumCaja = null;
            if (interCajaBean.getNumeroCaja() != null){
                Select numeroCaja = new Select(driver.findElement(By.xpath("/html/body/center/form/table[1]/tbody/tr[2]/td[2]/select")));
                //numeroCaja.selectByValue(lbcCajaBean.getNumeroCaja());
                numeroCaja.selectByVisibleText(interCajaBean.getNumeroCaja());
                textoNumCaja = numeroCaja.getFirstSelectedOption().getText();
                Thread.sleep(2000);
            }
            System.out.println("Texto del select numero de caja: " + textoNumCaja);


            Thread.sleep(2000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot2, nombreAutomatizacion, folderName);
            Toolkit.getDefaultToolkit().beep();

            Thread.sleep(2000);
            //WebElement btnAceptar = driver.findElement(By.xpath("/html/body/center/form/table[2]/tbody/tr/td/input"));
            WebElement btnAceptar = driver.findElement(By.xpath("//*[@id=\"idb_040203703_associateCashierRegisterWithCashier_01\"]"));
            btnAceptar.click();


            // Misma pantalla, se busca el cajero asociado
            Thread.sleep(4000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot3, nombreAutomatizacion, folderName);
            Toolkit.getDefaultToolkit().beep();

            // Busqueda

            for (int j = 3; j <= 500; j +=2){

                System.out.println("dentro del bucle i: " + j);
                //    WebElement lista = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/div[3]/div/div[3]/div[1]/table/tbody/tr[" + j + "]/td[1]/div/span")); //arreglo para seleccionar la ultima plantilla creada
                // WebElement lista = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/div[3]/div/div[3]/div[1]/table/tbody/tr[" + j + "]/td[1]/div")); //arreglo para seleccionar la ultima plantilla creada
                WebElement listaNombreCajero = driver.findElement(By.xpath("/html/body/center/form/div/table/tbody/tr[" + j + "]/td[2]")); //arreglo para seleccionar la ultima plantilla creada


                String texto = listaNombreCajero.getText();
                //String nombreCajero = lbcCaja.getNombreCajero() + " " + lbcCaja.getApellidoCajero();
                //System.out.println("Nombre Cajero del XML: " + nombreCajero);


                //System.out.println("prueba-->>>>>"+opcionNombre+" => "+ opcionNombre.isEnabled());
                //System.out.println("Texto: " + texto);
                //  nuevaPlantilla.click();

                if (texto.equals(textoCajero)){

                    for (int k = j; k <= 500; k +=2){
                        System.out.println("dentro del bucle k: " + k);
                        WebElement listaNumeroCajero = driver.findElement(By.xpath("/html/body/center/form/div/table/tbody/tr[" + k + "]/td[3]")); //arreglo para seleccionar la ultima plantilla creada

                        String textoNumeroCaja = listaNumeroCajero.getText();
                        String numeroCajaXML = interCajaBean.getNumeroCaja();
                        System.out.println("Numero Caja del XML: " + numeroCajaXML);

                        if (textoNumeroCaja.equals(textoNumCaja)){
                            WebElement seleccionarCajero = driver.findElement(By.xpath("/html/body/center/form/div/table/tbody/tr[" + k + "]/td[1]/input"));
                            seleccionarCajero.click();
                            Thread.sleep(1000);
                            a.ScreenShotPool(driver, i, "screen" + numScreenShoot4, nombreAutomatizacion, folderName);
                            Toolkit.getDefaultToolkit().beep();
                            break;
                        }

                    }
                    /*
                    listaNombreCajero.click();
                    Thread.sleep(1000);
                    a.ScreenShotPool(driver, i, "screen9", nombreAutomatizacion);
                    System.out.println("Prueba: '" + texto + "' seleccionado");
                    break;
                    */
                    break;
                }

            }

        }catch (Exception e) {
            e.printStackTrace();
            log.error("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }
}
