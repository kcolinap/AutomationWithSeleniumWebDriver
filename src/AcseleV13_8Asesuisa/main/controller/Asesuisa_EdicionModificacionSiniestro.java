package AcseleV13_8Asesuisa.main.controller;

import AcseleV13_8Asesuisa.beans.Asesuisa_EdicionModificacionSiniestroBean;
import AcseleV13_8Asesuisa.beans.Asesuisa_ValidacionOperacionSiniestroBean;
import AcseleV13_8Asesuisa.main.controller.Asesuisa_Menu.Asesuisa_MenuOperaciones;
import metodo.Metodos;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by cortiz on 09/05/2017.
 */
public class Asesuisa_EdicionModificacionSiniestro {
    private final static Logger log = Logger.getLogger(Asesuisa_EdicionModificacionSiniestro.class);

    public String nombreAutomatizacion = "Edicion Modificacion Siniestro";
    private WebDriver driver;
    private int polizaEncontrada=0;

    public void testLink(Asesuisa_EdicionModificacionSiniestroBean bean, int i, String folderName){
        try {
            Metodos m = new Metodos();
            Asesuisa_MenuOperaciones menu = new Asesuisa_MenuOperaciones();

            driver= m.entrarPagina(m.UrlAsesuisa());
            m.IniciarSesion(driver,nombreAutomatizacion,i,folderName);
            m.ValidandoSesion(driver,nombreAutomatizacion,i,folderName);
            Thread.sleep(2000);

            //Entrando a la opcion crear siniestro
            //Entrando en Menu
            //Ingreso a la opcion Mantenimiento siniestros
            menu.OpeSini_MantenimientoSiniestro(driver, nombreAutomatizacion, 2, i, folderName);
            Thread.sleep(1500);
            m.cambiarVentana(driver);

            BusquedaSiniestro(bean, m, i, folderName, 3, 4, 5, 6, 7, 8, 9, 10, 11);

            Thread.sleep(1000);
            driver.quit();
        }catch (Exception e){
            e.printStackTrace();
            log.error("Test Case - " + nombreAutomatizacion + " - " + e);
            if (driver != null){
                driver.quit();
            }
        }

    }

    public void BusquedaSiniestro(Asesuisa_EdicionModificacionSiniestroBean bean, Metodos a, int i, String folderName, int numScreenShoot, int numScreenShoot2, int numScreenShoot3, int numScreenShoot4, int numScreenShot5,
                                  int numScreenShoot6, int numScreenShoot7, int numScreenShoot8, int numScreenShoot9){


         try {

            Thread.sleep(2000);
            JavascriptExecutor jse = (JavascriptExecutor) driver;

             Thread.sleep(1000);
             a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion, folderName);
             Thread.sleep(1000);

            if (bean.getNSINIESTRO() != null) {
                Thread.sleep(4000);
                WebElement nsiniestro = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/div[5]/div/div/div/div[3]/input"));
                driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/div[5]/div/div/div/div[3]/input")).sendKeys(bean.getNSINIESTRO());
                Thread.sleep(1000);
            }

            //Boton buscar
            WebElement buscar = driver.findElement(By.xpath("/*//*[@id=\"buttonBuscar\"]"));
            buscar.click();

            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot2, nombreAutomatizacion, folderName);
            Thread.sleep(1000);

            //seleccionar siniestro encontrado
            Thread.sleep(3000);
            WebElement sencontrado = driver.findElement(By.xpath("//*[@id=\"layoutResultTable\"]/div[1]/div/div[3]/div[1]/table/tbody/tr[1]/td[2]/div"));
            sencontrado.click();


             Thread.sleep(1000);
             a.ScreenShotPool(driver, i, "screen" + numScreenShoot3, nombreAutomatizacion, folderName);
             Thread.sleep(1000);
            WebElement ok = driver.findElement(By.xpath("/*//*[@id=\"buttonOk\"]/span"));
            ok.click();

            Thread.sleep(4000);
            a.changeLastWindows(driver);
            Thread.sleep(2000);


            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot4, nombreAutomatizacion, folderName);
            Thread.sleep(1000);

             WebElement btneditar = driver.findElement(By.xpath("//*[@id=\"idb_0402006_structure_03\"]"));
             btneditar.click();

             // Cambiar de frame
             driver.switchTo().frame("plantilla");

             if (bean.getFechaNotificacion() != null ) {
                 WebElement fnotificacion = driver.findElement(By.xpath("//*[@id=\"FechaNotificacion\"]"));
                 fnotificacion.sendKeys(bean.getFechaNotificacion());
             }

             if (bean.getHORASINIESTRO() != null) {
                 WebElement horasiniestro = driver.findElement(By.xpath("//*[@id=\"HoraSiniestro\"]"));
                 horasiniestro.sendKeys();
             }

             if (bean.getFASTTRACK() != null)  {
                 WebElement fastTrack = driver.findElement(By.xpath("//*[@id=\"FastTrack\"]"));
                 fastTrack.click();
             }


            if (bean.getTALLER() != null) {
                Select taller = new Select(driver.findElement(By.xpath("/*//*[@id=\"Taller\"]")));
                taller.selectByVisibleText(bean.getTALLER());
            }

            if (bean.getAJUSTADOREXT() != null) {
                WebElement ajustadorExt = driver.findElement(By.xpath("/*//*[@id=\"AjustadorExterno\"]"));
                ajustadorExt.click();
            }


            if (bean.getAJUSTADOR() != null) {
                Select ajustador = new Select(driver.findElement(By.xpath("/*//*[@id=\"Ajustador\"]")));
                ajustador.selectByVisibleText(bean.getAJUSTADOR());
            }

             if (bean.getMONPREINI() != null) {
                 WebElement monpreint = driver.findElement(By.xpath("/*//*[@id=\"MontoPpto\"]"));
                 monpreint.sendKeys();
             }

             if (bean.getMONPRE() != null) {
                 WebElement monpre = driver.findElement(By.xpath("//*[@id=\"MontoPptoAutorizado\"]"));
                 monpre.sendKeys(bean.getMONPRE());
             }

             if (bean.getMONDEC() != null) {
                 WebElement monDec = driver.findElement(By.xpath("/*//*[@id=\"Deducible\"]"));
                 monDec.click();
             }

             if (bean.getRESPONSABILIDAD() != null) {
                 WebElement responsabilidad = driver.findElement(By.xpath("/*//*[@id=\"Responsabilidad\"]"));
                 responsabilidad.click();
             }

             if (bean.getCODESTADO() != null) {
                 Select codEstado = new Select(driver.findElement(By.xpath("/*//*[@id=\"CodigoEstado\"]")));
                 codEstado.selectByVisibleText(bean.getCODESTADO());
             }

             if (bean.getSUBESTADO() != null) {
                 Select subEstado = new Select(driver.findElement(By.xpath("/*//*[@id=\"SubEstado\"]")));
                 subEstado.selectByVisibleText(bean.getSUBESTADO());
             }

             if (bean.getTIPORECLAMO() != null) {
                 Select tipoReclamo = new Select(driver.findElement(By.xpath("/*//*[@id=\"Tiporeclamoexgratia\"]")));
                 tipoReclamo.selectByVisibleText(bean.getTIPORECLAMO());
             }

             if (bean.getVALORPAGO() != null) {
                 WebElement valorPago = driver.findElement(By.xpath("/*//*[@id=\"ValorPago\"]"));
                 valorPago.sendKeys(bean.getVALORPAGO());
             }

             if (bean.getAUTORIZADOPOR() != null) {
                 Select autorizadoPor = new Select(driver.findElement(By.xpath("/*//*[@id=\"Autorizado\"]")));
                 autorizadoPor.selectByVisibleText(bean.getAUTORIZADOPOR());

                 if (bean.getTERCEROSAFECTADOS() != null) {
                     WebElement tercerosAfectados = driver.findElement(By.xpath("/*//*[@id=\"Terceros\"]"));
                     tercerosAfectados.click();
                 }

                 if (bean.getAFECTADOS() != null) {
                     WebElement afectados = driver.findElement(By.xpath("/*//*[@id=\"Afectados\"]"));
                     afectados.click();
                 }

                 if (bean.getTALLERDOS() != null) {
                     Select tallerDos = new Select(driver.findElement(By.xpath("/*//*[@id=\"TallerTerceroI\"]")));
                     tallerDos.selectByVisibleText(bean.getTALLERDOS());
                 }

                 if (bean.getID() != null) {
                     WebElement id = driver.findElement(By.xpath("/*//*[@id=\"IDTerceroIV\"]"));
                     id.sendKeys(bean.getID());
                 }

                 if (bean.getNombresApellidos() != null) {
                     WebElement nomApellido = driver.findElement(By.xpath("//*[@id=\"NombreTerceroIV\"]"));
                 nomApellido.sendKeys(bean.getNombresApellidos());
             }

             if (bean.getNOLICENCIA() != null) {
                 WebElement noLicencia = driver.findElement(By.xpath("/*//*[@id=\"NroLicTerceroIV\"]"));
                 noLicencia.sendKeys();
             }


             if (bean.getVTOLICENCIA() != null) {
                 WebElement vtoLicencia = driver.findElement(By.xpath("/*//*[@id=\"VtoLicTerceroIV\"]"));
                 vtoLicencia.sendKeys(bean.getVTOLICENCIA());
             }

             if  (bean.getEDAD() != null)   {
             WebElement edad= driver.findElement(By.xpath("/*//*[@id=\"EdadTerceroIV\"]"));
             edad.sendKeys();
             }



             WebElement placa= driver.findElement(By.xpath("/*//*[@id=\"PlacaTerceroIV\"]"));
             placa.sendKeys();

             WebElement marca= driver.findElement(By.xpath("/*//*[@id=\"MarcaTerceroIV\"]"));
             marca.sendKeys();

             WebElement modelo= driver.findElement(By.xpath("/*//*[@id=\"ModeloTerceroIV\"]"));
             modelo.sendKeys();

             WebElement ano= driver.findElement(By.xpath("/*//*[@id=\"AnoTerceroIV\"]"));
             ano.sendKeys();

             WebElement ajustadorExt2 = driver.findElement(By.xpath("/*//*[@id=\"AjustTerceroIV\"]"));
             ajustadorExt.click();

             Select ajustador2 =  new Select(driver.findElement(By.xpath("/*//*[@id=\"AjustDosTerceroIV\"]")));
             ajustador.selectByVisibleText();

             WebElement fecasigajustador= driver.findElement(By.xpath("/*//*[@id=\"FecAsigTerceroIV\"]"));
             fecasigajustador.sendKeys();

             WebElement monpreint2 = driver.findElement(By.xpath("/*//*[@id=\"MontoTerceroIV\"]"));
             monpreint.sendKeys();


             WebElement nomApellido2= driver.findElement(By.xpath("/*//*[@id=\"NombreTerceroV\"]"));
             nomApellido.sendKeys();

             WebElement noLicencia2= driver.findElement(By.xpath("/*//*[@id=\"NroLicTerceroV\"]"));
             noLicencia.sendKeys();
*/

















             WebElement btnaceptar = driver.findElement(By.xpath("//*[@id=\"idb_04020099_content_01\"]"));
             btnaceptar.sendKeys();

             // Salir del frame
             driver.switchTo().parentFrame();
             driver.switchTo().defaultContent();




        }catch (Exception e) {
            e.printStackTrace();
            log.error("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }

}
