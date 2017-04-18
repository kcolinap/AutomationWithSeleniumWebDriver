package AcseleV13_8Asesuisa.main.controller;

import AcseleV13_8Asesuisa.beans.Asesuisa_CajaNotasCreditoBean;
import AcseleV13_8Asesuisa.main.controller.Asesuisa_Menu.Asesuisa_MenuOperaciones;
import metodo.Metodos;
import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by aandrade on 17/04/2017.
 */
public class Asesuisa_CajaNotasCredito {

    private final static Logger log = Logger.getLogger(Asesuisa_CajaAperturar.class);

    public String nombreAutomatizacion = "Asesuisa Caja Notas de Credito";
    private WebDriver driver;

    public void testLink(Asesuisa_CajaNotasCreditoBean bean, int i, String folderName){

        try {

            // Instanciando clases
            Metodos a = new Metodos();
            Asesuisa_MenuOperaciones menuOperaciones = new Asesuisa_MenuOperaciones();

            driver = a.entrarPagina(a.UrlAsesuisa());
            a.IniciarSesion(driver, nombreAutomatizacion, i, folderName);
            a.ValidandoSesion(driver, nombreAutomatizacion, i, folderName);
            Thread.sleep(5000);

            //Entrando primero en el Menu de Inicio de Sesion
            menuOperaciones.UAA_Caja_InicioSesion(driver, nombreAutomatizacion, 2, i, folderName);
            Thread.sleep(2000);
            a.cambiarVentana(driver);
            Thread.sleep(2000);
            driver.close();
            a.regresarVentana(driver);
            //Entrando en Menu de Facturas Generadas
            menuOperaciones.UAA_Caja_ConsultaFacturasGeneradas(driver, nombreAutomatizacion, 2, i, folderName);

            Thread.sleep(2000);
            a.cambiarVentana(driver);
            Thread.sleep(2000);

            /** Notas Credito Caja*/

            NotasCreditoCaja(bean, a, i, folderName, 3, 4, 5, 6, 7);
            Thread.sleep(5000);

            //driver.quit();

        } catch (Exception e) {
            e.printStackTrace();
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
            if (driver != null){
                //driver.quit();
            }
        }
    }

    public void NotasCreditoCaja(Asesuisa_CajaNotasCreditoBean bean, Metodos a, int i, String folderName, int numScreenShoot, int numScreenShoot2, int numScreenShoot3, int numScreenShoot4, int numScreenShoot5){

        int tamanotr;
        WebElement indextr;

        try {
            Thread.sleep(1000);


            // Prueba stackoverflow
            boolean breakIt = true;
            while (true) {
                breakIt = true;
                try {
                    driver.findElement(By.xpath("//*[@id=\"WControllervaadinservlet-1750660287\"]/div"));
                } catch (Exception e) {
                    if (e.getMessage().contains("element is not attached")) {
                        breakIt = false;
                    }
                }
                if (breakIt) {
                    break;
                }

            }
            // Fin Stackoverflow





/*
            WebElement mensajeEspera = driver.findElement(By.xpath("//*[@id=\"WControllervaadinservlet-1750660287\"]/div"));
            while (mensajeEspera.isEnabled()) {
                Thread.sleep(5000);
                System.out.println("Espera AAA");
            }
            Thread.sleep(1000);
*/


            // Seleccionar el boton Buscar
            driver.findElement(By.xpath("//*[@id=\"WControllervaadinservlet-1750660287\"]/div/div[2]/div[2]/div/div[2]/div/div[5]/div/div[1]/div/span")).click();
            Thread.sleep(3000);


            tamanotr = driver.findElements(By.xpath("//*[@id=\"WControllervaadinservlet-1750660287\"]/div/div[2]/div[2]/div/div[2]/div/div[7]/div/div[1]/div/div[3]/div[1]/table/tbody/tr")).size();
            for (int j = 1; j < (tamanotr+1); j++) {
                indextr = driver.findElement(By.xpath("//*[@id=\"WControllervaadinservlet-1750660287\"]/div/div[2]/div[2]/div/div[2]/div/div[7]/div/div[1]/div/div[3]/div[1]/table/tbody/tr[" + j + "]/td[8]/div"));
                String texto = indextr.getText();
                if (texto.equals("Valida")) {
                    // Selecciona la linea de la tabla a Anular
                    indextr.click();
                    // Selecciona el boton Anular
                    driver.findElement(By.xpath("//*[@id=\"WControllervaadinservlet-1750660287\"]/div/div[2]/div[2]/div/div[2]/div/div[5]/div/div[1]/div/span")).click();
                    Thread.sleep(5000);

                    // Razon de Anulacion
                    driver.findElement(By.xpath("//*[@id=\"WControllervaadinservlet-1750660287-window-overlays\"]/div[5]/div/div/div[5]/div/div/div[5]/div/div[3]/div/span")).click();
                    //driver.findElement(By.xpath("//*[@id=\"WControllervaadinservlet-1750660287-window-overlays\"]/div[5]/div/div/div[5]/div/div/div[1]/div/div[3]/div/div")).click();
/*
                    Thread.sleep(1000);
                    tamanotr = driver.findElements(By.xpath("//*[@id=\"VAADIN_COMBOBOX_OPTIONLIST\"]/div/div[2]/table/tbody/tr")).size();
                    for (int k = 0; k < tamanotr; k++) {
                        indextr = driver.findElements(By.xpath("//*[@id=\'VAADIN_COMBOBOX_OPTIONLIST\']/div/div[2]/table/tbody/tr")).get(j);
                        if (bean.getRazon() != null) {
                            indextr.click();
                            break;
                        }
                    }
*/
                    break;
                }
            }



/*
            String mensaje = driver.findElement(By.xpath("/html/body/center/form/table/tbody/tr[3]/td[2]")).getText();

            // Si no permite aperturar caja
            if (!mensaje.substring(0,2).equals("--")){

                // Captura la pantalla con el mensaje de informacion
                Thread.sleep(1000);
                a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion, folderName);
                Thread.sleep(1000);
                System.out.println(mensaje);
            }
            // Si se seleccionan todos los campos solicitados: numero de caja
            else if(bean.getNrocaja() != null){

                Thread.sleep(1000);
                Select nrocaja = new Select(driver.findElement(By.xpath("//select[@name='cashierRegisterID']")));
                nrocaja.selectByValue(bean.getNrocaja());

                Thread.sleep(1000);
                a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion, folderName);
                Thread.sleep(1000);

                driver.findElement(By.xpath("//input[@value='Aceptar']")).click();

                // Mensajes de Resultado de la operacion
                Thread.sleep(1000);
                a.ScreenShotPool(driver, i, "screen" + numScreenShoot2, nombreAutomatizacion, folderName);
                Thread.sleep(1000);

            }
            // Si no se selecciona el campo: Nro. de caja
            else if (bean.getNrocaja() == null){

                Thread.sleep(1000);
                a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion, folderName);
                Thread.sleep(1000);

                driver.findElement(By.xpath("//input[@value='Aceptar']")).click();

                // Mensajes de Alerta JavaScript
                if (ExpectedConditions.alertIsPresent() != null) {
                    Thread.sleep(1000);
                    Alert alert = driver.switchTo().alert();
                    String alertmess = alert.getText();
                    alert.accept();
                    System.out.println(alertmess);
                    Thread.sleep(1000);
                    driver.switchTo().defaultContent();
                }

            }
*/
        } catch (Exception e) {
            e.printStackTrace();
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }

    }
}
