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
            EditarSiniestro(bean, m, i, folderName,12,13,14,15,16,17,18);

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
                Thread.sleep(1000);
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
         }catch (Exception e) {
             e.printStackTrace();
             log.error("Test Case - " + nombreAutomatizacion + " - " + e);
         }

    }


    public void EditarSiniestro(Asesuisa_EdicionModificacionSiniestroBean bean, Metodos a, int i, String folderName, int numScreenShoot, int numScreenShoot2
            , int numScreenShoot3, int numScreenShoot4, int numScreenShoot5, int numScreenShoot6, int numScreenShoot7)
        {

            try {

                JavascriptExecutor jse = (JavascriptExecutor)driver;


             WebElement btneditar = driver.findElement(By.xpath("//*[@id=\"idb_0402006_structure_03\"]"));
             btneditar.click();

             // Cambiar de frame
             driver.switchTo().frame("plantilla");

             if (bean.getFechaNotificacion() != null ) {
                 Thread.sleep(1000);
                 WebElement fnotificacion = driver.findElement(By.xpath("//*[@id=\"FechaNotificacion\"]"));
                 fnotificacion.sendKeys(bean.getFechaNotificacion());
             }

             if (bean.getHORASINIESTRO() != null) {
                 Thread.sleep(1000);
                 WebElement horasiniestro = driver.findElement(By.xpath("//*[@id=\"HoraSiniestro\"]"));
                 horasiniestro.sendKeys();
             }

             if (bean.getFASTTRACK() != null)  {
                 Thread.sleep(1000);
                 WebElement fastTrack = driver.findElement(By.xpath("//*[@id=\"FastTrack\"]"));
                 fastTrack.click();
             }


            if (bean.getTALLER() != null) {
                Thread.sleep(1000);
                Select taller = new Select(driver.findElement(By.xpath("/*//*[@id=\"Taller\"]")));
                taller.selectByVisibleText(bean.getTALLER());
            }

            if (bean.getAJUSTADOREXT() != null) {
                Thread.sleep(1000);
                WebElement ajustadorExt = driver.findElement(By.xpath("/*//*[@id=\"AjustadorExterno\"]"));
                ajustadorExt.click();
            }


            if (bean.getAJUSTADOR() != null) {
                Thread.sleep(1000);
                Select ajustador = new Select(driver.findElement(By.xpath("/*//*[@id=\"Ajustador\"]")));
                ajustador.selectByVisibleText(bean.getAJUSTADOR());
            }

             if (bean.getMONPREINI() != null) {
                 Thread.sleep(1000);
                 WebElement monpreint = driver.findElement(By.xpath("/*//*[@id=\"MontoPpto\"]"));
                 monpreint.clear();
                 monpreint.sendKeys();
             }

                Thread.sleep(1000);
                a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion, folderName);
                Thread.sleep(1000);

                jse.executeScript("window.scrollBy(0,300)", "");



                if (bean.getMONPRE() != null) {
                 Thread.sleep(1000);
                 WebElement monpre = driver.findElement(By.xpath("//*[@id=\"MontoPptoAutorizado\"]"));
                 monpre.clear();
                 monpre.sendKeys(bean.getMONPRE());
             }

             if (bean.getMONDEC() != null) {
                 Thread.sleep(1000);
                 WebElement monDec = driver.findElement(By.xpath("/*//*[@id=\"Deducible\"]"));
                 monDec.click();
             }

             if (bean.getRESPONSABILIDAD() != null) {
                 Thread.sleep(1000);
                 WebElement responsabilidad = driver.findElement(By.xpath("/*//*[@id=\"Responsabilidad\"]"));
                 responsabilidad.click();
             }

             if (bean.getCODESTADO() != null) {
                 Thread.sleep(1000);
                 Select codEstado = new Select(driver.findElement(By.xpath("/*//*[@id=\"CodigoEstado\"]")));
                 codEstado.selectByVisibleText(bean.getCODESTADO());
             }

                Thread.sleep(1000);
                a.ScreenShotPool(driver, i, "screen" + numScreenShoot2, nombreAutomatizacion, folderName);
                Thread.sleep(1000);


                jse.executeScript("window.scrollBy(0,300)", "");


                if (bean.getTIPORECLAMO() != null) {
                 Thread.sleep(1000);
                 Select tipoReclamo = new Select(driver.findElement(By.xpath("/*//*[@id=\"Tiporeclamoexgratia\"]")));
                 tipoReclamo.selectByVisibleText(bean.getTIPORECLAMO());
             }

             if (bean.getVALORPAGO() != null) {
                 Thread.sleep(1000);
                 WebElement valorPago = driver.findElement(By.xpath("/*//*[@id=\"ValorPago\"]"));
                 valorPago.clear();
                 valorPago.sendKeys(bean.getVALORPAGO());
             }

             if (bean.getAUTORIZADOPOR() != null) {
                 Thread.sleep(1000);
                 Select autorizadoPor = new Select(driver.findElement(By.xpath("/*//*[@id=\"Autorizado\"]")));
                 autorizadoPor.selectByVisibleText(bean.getAUTORIZADOPOR());
             }

                Thread.sleep(1000);
                a.ScreenShotPool(driver, i, "screen" + numScreenShoot3, nombreAutomatizacion, folderName);
                Thread.sleep(1000);

                 if (bean.getTERCEROSAFECTADOS() != null) {
                     Thread.sleep(1000);
                     WebElement tercerosAfectados = driver.findElement(By.xpath("/*//*[@id=\"Terceros\"]"));
                     tercerosAfectados.click();
                 }

                 if (bean.getAFECTADOS() != null) {
                     Thread.sleep(1000);
                     WebElement afectados = driver.findElement(By.xpath("/*//*[@id=\"Afectados\"]"));
                     afectados.click();
                 }

                jse.executeScript("window.scrollBy(0,300)", "");


                if (bean.getTALLERDOS() != null) {
                     Thread.sleep(1000);
                     Select tallerDos = new Select(driver.findElement(By.xpath("/*//*[@id=\"TallerTerceroI\"]")));
                     tallerDos.selectByVisibleText(bean.getTALLERDOS());
                 }

                 if (bean.getID() != null) {
                     Thread.sleep(1000);
                     WebElement id = driver.findElement(By.xpath("/*//*[@id=\"IDTerceroIV\"]"));
                     id.clear();
                     id.sendKeys(bean.getID());
                 }

                 if (bean.getNOMAPEELIDO() != null) {
                     Thread.sleep(1000);
                     WebElement nomApellido = driver.findElement(By.xpath("//*[@id=\"NombreTerceroIV\"]"));
                     nomApellido.clear();
                 nomApellido.sendKeys(bean.getNOMAPEELIDO());
             }

                Thread.sleep(1000);
                a.ScreenShotPool(driver, i, "screen" + numScreenShoot4, nombreAutomatizacion, folderName);
                Thread.sleep(1000);

             if (bean.getNOLICENCIA() != null) {
                 Thread.sleep(1000);
                 WebElement noLicencia = driver.findElement(By.xpath("/*//*[@id=\"NroLicTerceroIV\"]"));
                 noLicencia.clear();
                 noLicencia.sendKeys(bean.getNOLICENCIA());
             }


             if (bean.getVTOLICENCIA() != null) {
                 Thread.sleep(1000);
                 WebElement vtoLicencia = driver.findElement(By.xpath("/*//*[@id=\"VtoLicTerceroIV\"]"));
                 vtoLicencia.clear();
                 vtoLicencia.sendKeys(bean.getVTOLICENCIA());
             }

             if  (bean.getEDAD() != null)   {
                 Thread.sleep(1000);
                 WebElement edad= driver.findElement(By.xpath("/*//*[@id=\"EdadTerceroIV\"]"));
                 edad.clear();
             edad.sendKeys(bean.getEDAD());
             }

              if (bean.getPLACA() != null) {
                  Thread.sleep(1000);
                  WebElement placa= driver.findElement(By.xpath("/*//*[@id=\"PlacaTerceroIV\"]"));
                  placa.clear();
             placa.sendKeys(bean.getPLACA());
              }

                Thread.sleep(1000);
                a.ScreenShotPool(driver, i, "screen" + numScreenShoot5, nombreAutomatizacion, folderName);
                Thread.sleep(1000);

             if (bean.getMARCA() != null)    {
                 Thread.sleep(1000);
                 WebElement marca= driver.findElement(By.xpath("/*//*[@id=\"MarcaTerceroIV\"]"));
                 marca.clear();
             marca.sendKeys(bean.getMARCA());
             }

             if  (bean.getMODELO() != null)    {
                 Thread.sleep(1000);
                 WebElement modelo= driver.findElement(By.xpath("/*//*[@id=\"ModeloTerceroIV\"]"));
                 modelo.clear();
             modelo.sendKeys(bean.getMODELO());
             }

             if  (bean.getAno() != null)    {
                 Thread.sleep(1000);
                 WebElement ano= driver.findElement(By.xpath("/*//*[@id=\"AnoTerceroIV\"]"));
                 ano.clear();
             ano.sendKeys(bean.getAno());
             }


                 if  (bean.getAJUSTEXT2() != null)    {
                     Thread.sleep(1000);
                     WebElement ajustadorExt2 = driver.findElement(By.xpath("/*//*[@id=\"AjustTerceroIV\"]"));
             ajustadorExt2.click();
                 }

             if  (bean.getAJUSTADOR2() != null)    {
                 Thread.sleep(1000);
                 Select ajustador2 =  new Select(driver.findElement(By.xpath("/*//*[@id=\"AjustDosTerceroIV\"]")));
             ajustador2.selectByVisibleText(bean.getAJUSTADOR2());
             }

                Thread.sleep(1000);
                a.ScreenShotPool(driver, i, "screen" + numScreenShoot6, nombreAutomatizacion, folderName);
                Thread.sleep(1000);

             if  (bean.getFECHAASIGAJUST() != null)    {
                 Thread.sleep(1000);
                 WebElement fecasigajustador= driver.findElement(By.xpath("/*//*[@id=\"FecAsigTerceroIV\"]"));
                 fecasigajustador.clear();
             fecasigajustador.sendKeys(bean.getFECHAASIGAJUST());
             }

                 if  (bean.getMONPREINI2() != null)    {
                     Thread.sleep(1000);
                     WebElement monpreini2 = driver.findElement(By.xpath("/*//*[@id=\"MontoTerceroIV\"]"));
                     monpreini2.clear();
                     monpreini2.sendKeys(bean.getMONPREINI2());
                 }

             if (bean.getNOMAPEELID2() != null)   {
                 Thread.sleep(1000);
                 WebElement nomApellido2= driver.findElement(By.xpath("/*//*[@id=\"NombreTerceroV\"]"));
                 nomApellido2.clear();
                 nomApellido2.sendKeys(bean.getNOMAPEELID2());
             }

             if   (bean.getNOLICENCIA2() != null)   {
                 Thread.sleep(1000);
                 WebElement noLicencia2= driver.findElement(By.xpath("/*//*[@id=\"NroLicTerceroV\"]"));
                 noLicencia2.clear();
                 noLicencia2.sendKeys(bean.getNOLICENCIA2());
             }

             // Salir del frame
             driver.switchTo().parentFrame();
             driver.switchTo().defaultContent();

                WebElement btnaceptar = driver.findElement(By.xpath("//*[@id=\"idb_04020099_content_01\"]"));
                btnaceptar.click();

                jse.executeScript("window.scrollBy(0,500)", "");

                Thread.sleep(1000);
                a.ScreenShotPool(driver, i, "screen" + numScreenShoot7, nombreAutomatizacion, folderName);
                Thread.sleep(1000);

                System.out.println("La modificación del siniestro se ha realizado satisfactoriamente");

            }catch (Exception e) {
            e.printStackTrace();
            log.error("Test Case - " + nombreAutomatizacion + " - " + e);
        }

    }

        }


