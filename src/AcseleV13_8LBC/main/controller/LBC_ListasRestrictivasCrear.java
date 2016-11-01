package AcseleV13_8LBC.main.controller;

import AcseleV13_8LBC.beans.LBC_ListasRestrictivasCrearBean;
import AcseleV13_8LBC.main.controller.LBC_Menu.LBC_MenuConfiguracion;
import AcseleV13_8LBC.main.controller.LBC_Menu.LBC_MenuMantenimiento;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.awt.*;
import java.io.IOException;

/**
 * Created by agil on 31/10/2016.
 */
public class LBC_ListasRestrictivasCrear {

    private final static Logger log = Logger.getLogger(LBC_ListasRestrictivasCrear.class);

    public String nombreAutomatizacion = "LBC Listas Resctrictiva Crear";
    public String nLista = "ListaPruebaD";
    public String primeraPropiedad = "NombreyApellido";
    public String segundaPropiedad = "DocumentoIdentidad";

    public void testLink(LBC_ListasRestrictivasCrearBean lbcListasRestrictivasCrearBean, int i) throws IOException, InterruptedException {

        try {

            // Instanciando clases
            LBC_Metodos a = new LBC_Metodos();
            LBC_MenuConfiguracion lbcMenuConfiguracion = new LBC_MenuConfiguracion();
            LBC_MenuMantenimiento LBCMenuMantenimiento = new LBC_MenuMantenimiento();

            WebDriver driver = a.entrarPagina();
            a.IniciarSesion(driver, nombreAutomatizacion, i);
            a.ValidandoSesion(driver, nombreAutomatizacion, i);
            Thread.sleep(6000);


            //Entrando en Menu
            lbcMenuConfiguracion.NuevoPlantillasModoNoPrivilegiado(driver, nombreAutomatizacion, 2, i);

            Thread.sleep(2000);
            a.cambiarVentana(driver);
            Thread.sleep(2000);


            Thread.sleep(15000);
            CrearLista(a, driver, lbcListasRestrictivasCrearBean, i, 3, 4, 5, 6, 7, 8);
            Thread.sleep(2000);
            BuscarPrimeraPropiedad(a, driver, lbcListasRestrictivasCrearBean, i, 9, 10, 11);
            BuscarSegundaPropiedad(a, driver, lbcListasRestrictivasCrearBean, i, 12, 13, 14, 15);

            //Entrando en Menu
/*
            LBCMenuMantenimiento.AdminLisRest_CrearListasRestrictivas(driver, nombreAutomatizacion, 2, i);

            Thread.sleep(2000);
            a.cambiarVentana(driver);
            Thread.sleep(2000);
*/

            /** Creando la lista Restrictiva */
/*
            Thread.sleep(3000);
            CrearListaRestrictiva(a, driver, lbcListasRestrictivasCrearBean, i, 3, 4, 5, 6, 7);
*/

        } catch (Exception e) {
            e.printStackTrace();
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }

    }

    public void CrearListaRestrictiva(LBC_Metodos a, WebDriver driver, LBC_ListasRestrictivasCrearBean lbcListasRestrictivasCrearBean, int i,
                                      int numScreenShoot, int numScreenShoot2, int numScreenShoot3, int numScreenShoot4, int numScreenShoot5){

        try {

            Thread.sleep(2000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion);
            Toolkit.getDefaultToolkit().beep();

            WebElement btnAgregar = driver.findElement(By.xpath("//div[2]/div/div/div/div/div/span"));
            btnAgregar.click();

            Thread.sleep(4000);

            if (lbcListasRestrictivasCrearBean.getTipo() != null) {
                WebElement mostrarTipo = driver.findElement(By.xpath("//div/div/div/div/div/div/div[2]/div/div"));
                mostrarTipo.click();
                Thread.sleep(500);
                if (lbcListasRestrictivasCrearBean.getTipo().toLowerCase().equals("negra")) {
                    WebElement listaNegra = driver.findElement(By.xpath("//tr[2]/td/span"));
                    listaNegra.click();
                    Thread.sleep(1000);
                }
                else if (lbcListasRestrictivasCrearBean.getTipo().toLowerCase().equals("blanca")) {
                    WebElement listaBlanca = driver.findElement(By.xpath("//tr[3]/td"));
                    listaBlanca.click();
                    Thread.sleep(1000);
                }
            }

            if (lbcListasRestrictivasCrearBean.getNombre() != null) {
                WebElement mostrarNombre = driver.findElement(By.xpath("//div/div/div/div[2]/div/div/div[2]/div/div"));
                mostrarNombre.click();
                Thread.sleep(500);
                if (lbcListasRestrictivasCrearBean.getNombre().toLowerCase().equals("pruebalistas")) {
                    WebElement pruebaListas = driver.findElement(By.xpath("//tr[2]/td/span"));
                    pruebaListas.click();
                    Thread.sleep(1000);
                }
                if (lbcListasRestrictivasCrearBean.getNombre().toLowerCase().equals("prueba")) {
                    WebElement prueba = driver.findElement(By.xpath("//tr[3]/td/span"));
                    prueba.click();
                    Thread.sleep(1000);
                }
            }

            WebElement btnImportarArchivo = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/div[1]/div/div/div[3]/div/div/div[2]/form/div/input[2]"));
            btnImportarArchivo.click();
            Runtime.getRuntime().exec("C:\\AcseleTests\\AutomationTestAcsele\\AutoIT\\LBC_CrearListasRestrictivas.exe");

            Thread.sleep(2000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot2, nombreAutomatizacion);
            Toolkit.getDefaultToolkit().beep();
            Thread.sleep(2000);

            WebElement btnAceptar = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/div[3]/div/div/div/div/span/span"));
            btnAceptar.click();

            Thread.sleep(4000);

            WebElement seleccionarLista = driver.findElement(By.xpath("//div[3]/div/table/tbody/tr/td/div"));
            seleccionarLista.click();
            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot3, nombreAutomatizacion);
            Toolkit.getDefaultToolkit().beep();
            Thread.sleep(2000);

            WebElement btnConsultar = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/div[7]/div/div[1]/div/span/span"));
            btnConsultar.click();

            Thread.sleep(2000);

            WebElement seleccionarFechaLista = driver.findElement(By.xpath("/html/body/div[3]/div[5]/div/div/div[5]/div/div/div[2]/div/div[1]/div/div[3]/div[1]/table/tbody/tr[1]/td[1]/div/div/span/input"));
            seleccionarFechaLista.click();
            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot4, nombreAutomatizacion);
            Toolkit.getDefaultToolkit().beep();
            Thread.sleep(1000);

            WebElement btnAceptarConsulta = driver.findElement(By.xpath("/html/body/div[3]/div[5]/div/div/div[5]/div/div/div[3]/div/div/div[1]/div/span/span"));
            btnAceptarConsulta.click();

            Thread.sleep(2000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot5, nombreAutomatizacion);
            Toolkit.getDefaultToolkit().beep();
            Thread.sleep(1000);

            log.info("Test Case - " + nombreAutomatizacion + " - " + "Prueba Exitosa");


        }catch (Exception e) {
            e.printStackTrace();
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }

    public void CrearLista(LBC_Metodos a, WebDriver driver, LBC_ListasRestrictivasCrearBean lbcListasRestrictivasCrearBean, int i, int numScreenShoot, int numScreenShoot2, int numScreenShoot3,
                                        int numScreenShoot4, int numScreenShoot5, int numScreenShoot6){

        try {
            Thread.sleep(2000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion);
            Toolkit.getDefaultToolkit().beep();

            BuscarCategoria(a, driver, lbcListasRestrictivasCrearBean, i, numScreenShoot2);

            Thread.sleep(2000);

            WebElement menuPlantillas = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div/div[2]/div/div/div[1]/div/div/div/div/div/div/div/span[1]/span[2]"));
            menuPlantillas.click();
            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot3, nombreAutomatizacion);
            Toolkit.getDefaultToolkit().beep();
            Thread.sleep(1000);
            WebElement menuAgregar = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div/span[1]/span"));
            menuAgregar.click();
            Thread.sleep(1000);

            WebElement nombreLista = driver.findElement(By.xpath("/html/body/div[5]/div[3]/div/div/div[5]/div/div/div[3]/input"));
            nombreLista.sendKeys(nLista); // ListaPruebaD


            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot4, nombreAutomatizacion);
            Toolkit.getDefaultToolkit().beep();

            WebElement btnAceptar = driver.findElement(By.xpath("/html/body/div[5]/div[3]/div/div/div[5]/div/div/div[5]/div/div[1]/button"));
            btnAceptar.click();

            Thread.sleep(15000);

/*            driver.navigate().refresh();
            Thread.sleep(20000);
            BuscarCategoria(a, driver, lbcListasRestrictivasCrearBean, i, numScreenShoot5);
            BuscarLista(a, driver, lbcListasRestrictivasCrearBean, i, numScreenShoot6);
*/
            BuscarCategoria2(a, driver, lbcListasRestrictivasCrearBean, i, numScreenShoot5);


        }catch (Exception e) {
            e.printStackTrace();
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }

    public void BuscarCategoria(LBC_Metodos a, WebDriver driver, LBC_ListasRestrictivasCrearBean lbcListasRestrictivasCrearBean, int i, int numScreenShoot){

        try {
            // Encontrar la catergoria
            for (int j = 1; j <= 500; j++){

                //System.out.println("dentro del bucle: " + i);
                WebElement opcionNombre = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div/div[2]/div/div/div[2]/div/div/div[2]/div/div/div[1]/div/div[2]/div[1]/table/tbody/tr[" + j + "]/td/div")); //arreglo para seleccionar la lista deseada.
                String texto = opcionNombre.getText();

                // System.out.println("prueba-->>>>>"+opcionNombre+" => "+ opcionNombre.isEnabled());
                // System.out.println("Texto: " + texto);
                // System.out.println("num: " + j);
                //  nuevaPlantilla.click();

                //if (texto.equals(listasRestrictivasBean.getListaNombre())){
                if (texto.equals("Lista Restrictiva"/*listasRestrictivasBean.getListaNombre()*/)){
                    opcionNombre.click();
                    Thread.sleep(1000);

                    WebElement abrir = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div/div[2]/div/div/div[2]/div/div/div[2]/div/div/div[1]/div/div[2]/div[1]/table/tbody/tr[" + j + "]/td/div/span"));
                    abrir.click();

                    a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion);
                    Toolkit.getDefaultToolkit().beep();
                    //System.out.println("Prueba: '" + texto + "' seleccionado");
                    break;
                }

            } // Fin del For
        }catch (Exception e) {
            e.printStackTrace();
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }

    public void BuscarCategoria2(LBC_Metodos a, WebDriver driver, LBC_ListasRestrictivasCrearBean lbcListasRestrictivasCrearBean, int i, int numScreenShoot){

        try {
            // Encontrar la catergoria
            for (int j = 1; j <= 500; j++){

                //System.out.println("dentro del bucle: " + i);
                WebElement opcionNombre = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div/div[2]/div/div/div[2]/div/div/div[2]/div/div/div[1]/div/div[2]/div[1]/table/tbody/tr[" + j + "]/td/div")); //arreglo para seleccionar la lista deseada.
                String texto = opcionNombre.getText();

                // System.out.println("prueba-->>>>>"+opcionNombre+" => "+ opcionNombre.isEnabled());
                // System.out.println("Texto: " + texto);
                // System.out.println("num: " + j);
                //  nuevaPlantilla.click();

                //if (texto.equals(listasRestrictivasBean.getListaNombre())){
                if (texto.equals("Lista Restrictiva"/*listasRestrictivasBean.getListaNombre()*/)){
                    opcionNombre.click();
                    Thread.sleep(1000);

                    /*WebElement abrir = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div/div[2]/div/div/div[2]/div/div/div[2]/div/div/div[1]/div/div[2]/div[1]/table/tbody/tr[" + j + "]/td/div/span"));
                    abrir.click();*/

                    a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion);
                    Toolkit.getDefaultToolkit().beep();
                    //System.out.println("Prueba: '" + texto + "' seleccionado");
                    break;
                }

            } // Fin del For
        }catch (Exception e) {
            e.printStackTrace();
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }

    public void BuscarLista(LBC_Metodos a, WebDriver driver, LBC_ListasRestrictivasCrearBean lbcListasRestrictivasCrearBean, int i, int numScreenShoot){

        try {
            // Encontrar la nueva lista
            for (int j = 1; j <= 500; j++){

                //System.out.println("dentro del bucle: " + i);
                WebElement opcionNombre = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div/div[2]/div/div/div[2]/div/div/div[2]/div/div/div[1]/div/div[2]/div[1]/table/tbody/tr[" + j + "]/td/div")); //arreglo para seleccionar la lista deseada.
                String texto = opcionNombre.getText();

                //System.out.println("Buscando la Lista nueva-->>>>>"+opcionNombre+" => "+ opcionNombre.isEnabled());
                //System.out.println("Texto: " + texto);
                //System.out.println("num: " + j);
                //  nuevaPlantilla.click();

                //if (texto.equals(listasRestrictivasBean.getListaNombre())){
                if (texto.equals(nLista/*listasRestrictivasBean.getListaNombre()*/)){ // ListaPruebaD
                    opcionNombre.click();
                    Thread.sleep(1000);
                    opcionNombre.click();
                    Thread.sleep(1000);

                    WebElement abrir = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div/div[2]/div/div/div[2]/div/div/div[2]/div/div/div[1]/div/div[2]/div[1]/table/tbody/tr[" + j + "]/td/div/span"));
                    abrir.click();

                    a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion);
                    Toolkit.getDefaultToolkit().beep();
                    //System.out.println("Prueba: '" + texto + "' seleccionado");
                    break;
                }

            } // Fin del For
        }catch (Exception e) {
            e.printStackTrace();
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }

    public void BuscarPrimeraPropiedad(LBC_Metodos a, WebDriver driver, LBC_ListasRestrictivasCrearBean lbcListasRestrictivasCrearBean, int i, int numScreenShoot, int numScreenShoot2, int numScreenShoot3){

        try {
            Thread.sleep(2000);

            WebElement carpetaTodas = driver.findElement(By.xpath("//*[@id=\"WControllerfront-1437825718\"]/div/div[2]/div/div/div/div[2]/div/div/div[2]/div/div/div[2]/div/div/div[3]/div/div/div[2]/div/div[2]/div[1]/table/tbody/tr[1]/td/div/span"));
            Thread.sleep(1000);
            carpetaTodas.click();

            WebElement inputBuscar = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div/div[2]/div/div/div[2]/div/div/div[2]/div/div/div[3]/div/div/div[1]/div/div/div[2]/input"));
            inputBuscar.sendKeys(primeraPropiedad);
            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion);
            Thread.sleep(1000);

            WebElement btnBuscar = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div/div[2]/div/div/div[2]/div/div/div[2]/div/div/div[3]/div/div/div[1]/div/div/div[3]/button"));
            btnBuscar.click();

            Thread.sleep(15000);
            for (int j = 1; j <= 5000; j++){

                //System.out.println("dentro del bucle: " + i);
                WebElement opcionNombre = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div/div[2]/div/div/div[2]/div/div/div[2]/div/div/div[3]/div/div/div[2]/div/div[2]/div[1]/table/tbody/tr["+j+"]/td/div")); //arreglo para seleccionar la lista deseada.

                String texto = opcionNombre.getText();

                //System.out.println("prueba-->>>>>"+opcionNombre+" => "+ opcionNombre.isEnabled());
                // System.out.println("Texto: " + texto);
                // System.out.println("Num" + j);
                //  nuevaPlantilla.click();

                if (texto.equals(primeraPropiedad)){
                    opcionNombre.click();
                    Thread.sleep(2000);
                    opcionNombre.click();
                    Thread.sleep(1000);
                    a.ScreenShotPool(driver, i, "screen" + numScreenShoot2, nombreAutomatizacion);
                    //System.out.println("Prueba: '" + texto + "' seleccionado");
                    break;
                }
            }

            Thread.sleep(2000);

            WebElement btnAsociarPropiedad = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div/div[2]/div/div/div[2]/div/div/div[1]/div/div/div/div/div[1]/button"));
            btnAsociarPropiedad.click();

            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot3, nombreAutomatizacion);

        }catch (Exception e) {
            e.printStackTrace();
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }

    public void BuscarSegundaPropiedad(LBC_Metodos a, WebDriver driver, LBC_ListasRestrictivasCrearBean lbcListasRestrictivasCrearBean, int i, int numScreenShoot, int numScreenShoot2, int numScreenShoot3, int numScreenShoot4){

        try {
            Thread.sleep(2000);

/*            WebElement carpetaTodas = driver.findElement(By.xpath("//*[@id=\"WControllerfront-1437825718\"]/div/div[2]/div/div/div/div[2]/div/div/div[2]/div/div/div[2]/div/div/div[3]/div/div/div[2]/div/div[2]/div[1]/table/tbody/tr[1]/td/div/span"));
            Thread.sleep(1000);
            carpetaTodas.click();*/

            WebElement inputBuscar = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div/div[2]/div/div/div[2]/div/div/div[2]/div/div/div[3]/div/div/div[1]/div/div/div[2]/input"));
            inputBuscar.clear();
            inputBuscar.clear();
            inputBuscar.sendKeys(segundaPropiedad);
            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion);
            Thread.sleep(1000);

            WebElement btnBuscar = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div/div[2]/div/div/div[2]/div/div/div[2]/div/div/div[3]/div/div/div[1]/div/div/div[3]/button"));
            btnBuscar.click();

            Thread.sleep(1000);
            WebElement seleccionarCarpetaTodas = driver.findElement(By.xpath("//*[@id=\"WControllerfront-1437825718\"]/div/div[2]/div/div/div/div[2]/div/div/div[2]/div/div/div[2]/div/div/div[3]/div/div/div[2]/div/div[2]/div[1]/table/tbody/tr[1]/td/div"));
            seleccionarCarpetaTodas.click();
            Thread.sleep(1000);

            WebElement carpetaTodas = driver.findElement(By.xpath("//*[@id=\"WControllerfront-1437825718\"]/div/div[2]/div/div/div/div[2]/div/div/div[2]/div/div/div[2]/div/div/div[3]/div/div/div[2]/div/div[2]/div[1]/table/tbody/tr[1]/td/div/span"));
            Thread.sleep(1000);
            carpetaTodas.click();

            Thread.sleep(2000);
            btnBuscar = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div/div[2]/div/div/div[2]/div/div/div[2]/div/div/div[3]/div/div/div[1]/div/div/div[3]/button"));
            btnBuscar.click();

            Thread.sleep(15000);
            for (int j = 1; j <= 5000; j++){

                //System.out.println("dentro del bucle: " + i);
                WebElement opcionNombre = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div/div[2]/div/div/div[2]/div/div/div[2]/div/div/div[3]/div/div/div[2]/div/div[2]/div[1]/table/tbody/tr["+j+"]/td/div")); //arreglo para seleccionar la lista deseada.

                String texto = opcionNombre.getText();

                //System.out.println("prueba-->>>>>"+opcionNombre+" => "+ opcionNombre.isEnabled());
                // System.out.println("Texto: " + texto);
                // System.out.println("Num" + j);
                //  nuevaPlantilla.click();

                if (texto.equals(segundaPropiedad)){
                    opcionNombre.click();
                    Thread.sleep(2000);
                    opcionNombre.click();
                    Thread.sleep(1000);
                    a.ScreenShotPool(driver, i, "screen" + numScreenShoot2, nombreAutomatizacion);
                    //System.out.println("Prueba: '" + texto + "' seleccionado");
                    break;
                }
            }

            Thread.sleep(2000);

            BuscarCategoria2(a, driver, lbcListasRestrictivasCrearBean, i, numScreenShoot3);

            WebElement btnAsociarPropiedad = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div/div[2]/div/div/div[2]/div/div/div[1]/div/div/div/div/div[1]/button"));
            btnAsociarPropiedad.click();

            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot4, nombreAutomatizacion);

        }catch (Exception e) {
            e.printStackTrace();
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }
}
