package AcseleV13_8LBC.main.controller;
import AcseleV13_8LBC.beans.LBC_EstadoCuentasBean;
import AcseleV13_8LBC.main.controller.LBC_Menu.LBC_MenuConsultas;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


/**
 * Created by rmontilla on 11/10/2016.
 */
public class LBC_EstadoCuentas {

    private final static Logger log = Logger.getLogger(LBC_EstadoCuentas.class);

    public String nombreAutomatizacion = "Estado de Cuentas LBC";

    public void testLink(LBC_EstadoCuentasBean lbcEstadoCuentasBean, int i)throws Exception{

        try {

            // Instanciando clases
            LBC_Metodos a = new LBC_Metodos();
            LBC_MenuConsultas lbcMenuConsultas = new LBC_MenuConsultas();

            WebDriver driver = a.entrarPagina();
            a.IniciarSesion(driver, nombreAutomatizacion, i);

            a.ValidandoSesion(driver, nombreAutomatizacion, i);
            Thread.sleep(5000);

            //Entrando en Menu
            lbcMenuConsultas.EstadoCuentas(a, driver, nombreAutomatizacion, i, i);

            //
            Thread.sleep(2000);
            a.cambiarVentana(driver);
            Thread.sleep(2000);

            EdoCuentas(driver, lbcEstadoCuentasBean, a, i);
            /*ConsultaPol(driver, consultaMovimientosPolizaBean, a, i);
            SeleccionarPol(driver, a, i);
            SeleccionarMov(driver, a, i);*/

        }catch (Exception e) {
            e.printStackTrace();
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }

    private void EdoCuentas (WebDriver driver, LBC_EstadoCuentasBean lbcEstadoCuentasBean, LBC_Metodos a, int i){
        try {
            Thread.sleep(3000);

            //Screenshot
            a.ScreenShot(driver, "screen3", nombreAutomatizacion);

            // Select del Tipo de Tercero
            if (lbcEstadoCuentasBean.getTipoTercero() != null) {
                Thread.sleep(3000);

                Select orden = new Select(driver.findElement(By.xpath("/html/body/table[3]/tbody/tr[1]/td/form/table/tbody/tr[1]/td[2]/select")));

                if (lbcEstadoCuentasBean.getTipoTercero().equals("NaturalPerson")) {
                    Thread.sleep(2000);
                    orden.selectByValue("NaturalPerson");
                }
            }

                Thread.sleep(2000);

            // Primer Apellido
            if (lbcEstadoCuentasBean.getPrimerApellido() != null) {
                WebElement priApellido = driver.findElement(By.xpath("/html/body/table[3]/tbody/tr[3]/td/form/table[1]/tbody/tr/td[3]/input[1]"));
                priApellido.sendKeys(lbcEstadoCuentasBean.getPrimerApellido());
                //Screenshot
            }

                // Primer Nombre

            if (lbcEstadoCuentasBean.getPrimerNombre() != null) {

                WebElement priNombre = driver.findElement(By.xpath("/html/body/table[3]/tbody/tr[3]/td/form/table[3]/tbody/tr/td[3]/input[1]"));
                priNombre.sendKeys(lbcEstadoCuentasBean.getPrimerNombre());
            }

            // Num Documento Identificacion
            if (lbcEstadoCuentasBean.getNumDocIdentificacion() != null) {
                WebElement numDocIdent = driver.findElement(By.xpath("/html/body/table[3]/tbody/tr[3]/td/form/table[8]/tbody/tr/td[3]/input[1]"));
                numDocIdent.sendKeys(lbcEstadoCuentasBean.getNumDocIdentificacion());
            }

            Thread.sleep(2000);
            a.ScreenShot(driver, "screen4", nombreAutomatizacion);


            // Boton Buscar
            driver.findElement(By.xpath("/html/body/table[3]/tbody/tr[4]/td/button[1]")).click();
            Thread.sleep(7000);


            // Seleccionar el Tercero Buscado

                driver.findElement(By.xpath("/html/body/table[2]/tbody/tr/td/table/tbody/tr[1]/td[1]/input[1]")).click();
                //Screenshot
                a.ScreenShot(driver, "screen5", nombreAutomatizacion);
                Thread.sleep(1000);

                // Boton Aceptar
                driver.findElement(By.xpath("/html/body/table[2]/tbody/tr/td/table/tbody/tr[2]/td/input")).click();
                Thread.sleep(1000);


            //Borrar Fecha inicial y final

                driver.findElement(By.xpath("/html/body/center[1]/table/tbody/tr[3]/td/table[1]/tbody/tr[5]/td[2]/input[1]")).clear();
                driver.findElement(By.xpath("/html/body/center[1]/table/tbody/tr[3]/td/table[1]/tbody/tr[6]/td[2]/input[1]")).clear();

             // Moneda
            if (lbcEstadoCuentasBean.getMoneda() != null) {
                Select moneda = new Select(driver.findElement(By.xpath("/html/body/center[1]/table/tbody/tr[3]/td/table[1]/tbody/tr[7]/td[2]/select")));
                if (lbcEstadoCuentasBean.getMoneda().equals("Bolivianos")) {

                    moneda.selectByValue("2204");
                }

                if (lbcEstadoCuentasBean.getMoneda().equals("Dólares Americanos")) {

                    moneda.selectByValue("2205");
                }
            }

                // Producto
            if (lbcEstadoCuentasBean.getProducto() != null) {

                Select producto = new Select(driver.findElement(By.xpath("/html/body/center[1]/table/tbody/tr[3]/td/table[1]/tbody/tr[8]/td[2]/select")));

                if (lbcEstadoCuentasBean.getProducto().equals("AutomotoresFlota")){
                    Thread.sleep(2000);
                    producto.selectByValue("17838");
                }
            }
                // Num Poliza
            if (lbcEstadoCuentasBean.getNumPoliza() != null) {
                WebElement numeroPolza = driver.findElement(By.xpath("/html/body/center[1]/table/tbody/tr[3]/td/table[1]/tbody/tr[9]/td[2]/input"));
                numeroPolza.sendKeys(lbcEstadoCuentasBean.getNumPoliza());
            }
                //Screenshot
                Thread.sleep(2000);
                a.ScreenShot(driver, "screen6", nombreAutomatizacion);
                Thread.sleep(1000);

                // Boton Enviar
                driver.findElement(By.xpath("/html/body/center[1]/table/tbody/tr[3]/td/table[2]/tbody/tr/td/input")).click();
                Thread.sleep(6000);


                //Screenshot
                a.ScreenShot(driver, "screen7", nombreAutomatizacion);

                System.out.println("Fin del Test");
            } catch (Exception e) {
                e.printStackTrace();
//                log.info(e);
                log.info("Test Case - " + nombreAutomatizacion + " - " + e);
            }
        }
    }