package AcseleV13_8.main.controller;

import AcseleV13_8.beans.UsoTablasDinamicasImportadasBean;
import AcseleV13_8.main.controller.Menu.MenuMantenimiento;
import AcseleV13_8.main.controller.Menu.MenuOperaciones;
import AcseleV13_8.main.controller.PolizaEmision.*;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.io.IOException;
import java.security.Key;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by agil on 17/08/2016.
 */
public class UsoTablasDinamicasImportadas {

    private final static Logger log = Logger.getLogger(UsoTablasDinamicasImportadas.class);

    public static String nombreAutomatizacion = "Uso de Tablas Dinamicas Importadas";

    public void testLink(UsoTablasDinamicasImportadasBean usoTablasDinamicasImportadasBean, int i) throws IOException, InterruptedException {

        try {
            // Instanciando las clases
            Metodos a = new Metodos();
            MenuMantenimiento menuMantenimiento = new MenuMantenimiento();
            MenuOperaciones menuOperaciones = new MenuOperaciones();
            PrePoliza prePoliza = new PrePoliza();
            InformacionGeneralPoliza informacionGeneralPoliza = new InformacionGeneralPoliza();
            TerceroTomador terceroTomador = new TerceroTomador();
            UnidadesRiesgo unidadesRiesgo = new UnidadesRiesgo();
            ObjetoAsegurado objetoAsegurado = new ObjetoAsegurado();

            WebDriver driver = a.entrarPagina();
            a.IniciarSesion(driver, nombreAutomatizacion, i);
            Thread.sleep(2000);
            a.ValidandoSesion(driver, nombreAutomatizacion, i);
            Thread.sleep(5000);

            // Ingreso al menu
            menuMantenimiento.MantGeral_TablasDinamicas(driver, nombreAutomatizacion, 2, i);

            Thread.sleep(2000);
            a.cambiarVentana(driver);
            Thread.sleep(2000);

            BuscarTabla(a, driver, usoTablasDinamicasImportadasBean, i, 3);
            Thread.sleep(1000);
            ImportTablaDinamica(a, driver, usoTablasDinamicasImportadasBean, i, 4, 5, 6, 7);
            Thread.sleep(1000);
            driver.close();

            a.regresarVentana(driver);

            menuOperaciones.OpePol_Crear(driver, nombreAutomatizacion, 8, i);

            Thread.sleep(2000);
            a.cambiarVentana(driver);
            Thread.sleep(2000);

            //CrearPoliza(a, driver, usoTablasDinamicasImportadasBean);
            prePoliza.AdminPropuestaPoliza(a, driver, usoTablasDinamicasImportadasBean, nombreAutomatizacion, i, 9);
            Thread.sleep(1000);
            prePoliza.EvAplicar(a, driver, usoTablasDinamicasImportadasBean, nombreAutomatizacion, i, 10);
            Thread.sleep(1000);

            //InformacionPoliza(a, driver, usoTablasDinamicasImportadasBean);
            informacionGeneralPoliza.InformacionGeneral(a, driver, usoTablasDinamicasImportadasBean, nombreAutomatizacion, i, 11);
            Thread.sleep(1000);

            //AgregarTerceroTomador(a, driver, usoTablasDinamicasImportadasBean);
            terceroTomador.TomadorTercero(a, driver, usoTablasDinamicasImportadasBean, nombreAutomatizacion, i, 12, 13);
            Thread.sleep(1000);

            //AgregarUnidadRiesgo(a, driver, usoTablasDinamicasImportadasBean);
            unidadesRiesgo.UnidadesRiesgo(a, driver, usoTablasDinamicasImportadasBean, nombreAutomatizacion, i, 14, 15);
            Thread.sleep(1000);

            //AgregarObjetoAsegurado(a, driver, usoTablasDinamicasImportadasBean);
            objetoAsegurado.ObjetoAsegurado(a, driver, usoTablasDinamicasImportadasBean, nombreAutomatizacion, i, 16);
            Thread.sleep(1000);

            Comprobar(a, driver, usoTablasDinamicasImportadasBean, i, 17);

        } catch (Exception e) {
            e.printStackTrace();
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }

    }

    public void BuscarTabla(Metodos a, WebDriver driver, UsoTablasDinamicasImportadasBean usoTablasDinamicasImportadasBean, int i, int numScreenShoot){

        try {

            Thread.sleep(2000);

            WebElement nombreTabDina = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/form/table/tbody/tr[3]/td[2]/input"));
            nombreTabDina.sendKeys(usoTablasDinamicasImportadasBean.getNombreTablaDinamica());

            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion); //screenshot2
            Toolkit.getDefaultToolkit().beep();
            Thread.sleep(1000);

            WebElement btnAceptar = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/form/table/tbody/tr[5]/td/input[2]"));
            btnAceptar.click();


        } catch (Exception e) {
            e.printStackTrace();
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }

    }

    public  void ImportTablaDinamica(Metodos a, WebDriver driver, UsoTablasDinamicasImportadasBean usoTablasDinamicasImportadasBean, int i, int numScreenShoot, int numScreenShoot2, int numScreenShoot3, int numScreenShoot4){

        try {

            System.out.println("Inicio de la funcion ImportTablaDinamica");

            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion); //screenshot2
            Toolkit.getDefaultToolkit().beep();

            Thread.sleep(2000);
            WebElement btnImport = driver.findElement(By.xpath("//*[@id=\"idb_0402008_TableTemplateViewer_07\"]"));
            btnImport.click();

            Thread.sleep(4000);

            // Cambiar de ventana
            // getWindowHandles() method returns the ids of all active Windows and its return type will be a Collection Set.
            Set<String> sid = driver.getWindowHandles();
            // Using iterator we can fetch the values from Set.
            Iterator<String> it = sid.iterator();
            String parentId = it.next();
            System.out.println(parentId);
            String childId = it.next();
            System.out.println(childId);
            String childId2 = it.next();
            System.out.println(childId2);
            // swtiching control to child Window
            driver.switchTo().window(childId2);

            WebElement btnSelect = driver.findElement(By.xpath("/html/body/center/form/table/tbody/tr[2]/td/input[1]"));
            /****/
            //btnSelect.sendKeys("C://AcseleTests//Export//Prueba2.xml");
            btnSelect.sendKeys(usoTablasDinamicasImportadasBean.getRutaTablaDinamica());

            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot2, nombreAutomatizacion); //screenshot2
            Toolkit.getDefaultToolkit().beep();

            WebElement btnAcept = driver.findElement(By.xpath("//*[@id=\"idb_0402023_selectXMLFile_01\"]"));
            btnAcept.click();

            Thread.sleep(3000);
            // Mensajes de Alerta
            if (ExpectedConditions.alertIsPresent() != null) {
                Thread.sleep(1000);
                Alert alert = driver.switchTo().alert();
                alert.accept();
                Thread.sleep(1000);
                driver.switchTo().defaultContent();
            }

            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot3, nombreAutomatizacion); //screenshot2
            Toolkit.getDefaultToolkit().beep();

            WebElement btnClose = driver.findElement(By.xpath("//*[@id=\"idb_0402023_DynamicTablesImportExportResultMessage_01\"]"));
            btnClose.click();

            Thread.sleep(2000);
            driver.switchTo().window(childId);

            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot4, nombreAutomatizacion); //screenshot2
            Toolkit.getDefaultToolkit().beep();

        }catch (Exception e) {
            e.printStackTrace();
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }

    }

    public static void Comprobar(Metodos a, WebDriver driver, UsoTablasDinamicasImportadasBean usoTablasDinamicasImportadasBean, int i, int numScreenShoot){

        try {//TipoElemento[@wicketpath='WicketpathElemento']

            Thread.sleep(2000);

            //Select producto = new Select(driver.findElement(By.xpath("//TipoElemento[@wicketpath='WicketpathElemento']")));
            //WebElement fechaDesde = driver.findElement(By.xpath("//TipoElemento[@wicketpath='WicketpathElemento']"));

            WebElement btnCalcular = driver.findElement(By.xpath("//input[@wicketpath='divCalculatePolicy_formCalculate_calculate']"));
            btnCalcular.click();
            Thread.sleep(1000);

            /***Espera***/
            WebElement mensajeEspera10 = driver.findElement(By.id("waitMessage"));
            while (mensajeEspera10.isDisplayed()){
                Thread.sleep(5000);
                System.out.println("Espera 10");
            }

            Thread.sleep(1000);
            WebElement cantidad = driver.findElement(By.xpath("//span[@wicketpath='modalWindowForm_EventSection_content_PolicyResultsSection_TPMovementTable_ThirdPartyMovementTable_1_TPAmount']"));
            cantidad.getText();
            System.out.println(cantidad.getText());
            System.out.println(cantidad.getSize());
            System.out.println(cantidad.getTagName());

            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion); //screenshot2
            Toolkit.getDefaultToolkit().beep();

            Thread.sleep(1000);
            if (cantidad.getText().equals(usoTablasDinamicasImportadasBean.getValorComparacionTD())){
                System.out.println("Test Case - " + nombreAutomatizacion + ": Exitosa");
            }
            else {
                System.out.println("Fallida");
                log.info("Test Case - " + nombreAutomatizacion + ": Fallida");
                //throw e;
            }


        }catch (Exception e) {
            e.printStackTrace();
            log.info("Test Case 25 - " + nombreAutomatizacion + " - " + e);
        }
    }


}
