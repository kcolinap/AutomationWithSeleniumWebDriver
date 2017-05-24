package AcseleV13_8Asesuisa.main.controller;

import AcseleV13_8Asesuisa.beans.Asesuisa_ConsultaEdoCuentaTercerosBean;
import AcseleV13_8Asesuisa.main.controller.Asesuisa_Menu.Asesuisa_MenuConsultas;

import metodo.Metodos;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;

/**
 * Created by kcolina on 24/03/2017.
 */
public class Asesuisa_ConsultaEdoCuentaTerceros {
    private final static Logger Log = Logger.getLogger(Asesuisa_ConsultaEdoCuentaTerceros.class);
    public String nombreAutomatizacion = "Consulta estado de cuenta";
    private WebDriver driver;

    public void testLink(Asesuisa_ConsultaEdoCuentaTercerosBean asesuisaConsultaEdoCuentaTercerosBean, int i,
                         String folderName){
        try{
            Metodos m = new Metodos();
            Asesuisa_MenuConsultas menuConsultas  = new Asesuisa_MenuConsultas();
            Select tipoT;


            driver= m.entrarPagina(m.UrlAsesuisa());
            m.IniciarSesion(driver, nombreAutomatizacion, i, folderName);
            m.ValidandoSesion(driver,nombreAutomatizacion, i, folderName);
            Thread.sleep(1000);

            //Ingreso a la opcion estado de cuenta
            menuConsultas.EstadoCuentas(driver, nombreAutomatizacion, 2,i,folderName);
            Thread.sleep(1200);
           if (alertPresente(driver)){
                driver.switchTo().alert();
                driver.switchTo().alert().accept();
                driver.switchTo().defaultContent();
                Thread.sleep(800);
            }
           // driver.switchTo().alert().accept();
            m.cambiarVentana(driver);
            Thread.sleep(1000);

            //Alert alert= driver.switchTo().alert();
            //Mensaje de alerta




            //Validar tipo tercero
            if (asesuisaConsultaEdoCuentaTercerosBean.getTipoTercero()!=null){
                tipoT = new Select(driver.findElement(By.xpath("/html/body/table[3]/tbody/tr[1]/td/form/table/tbody/tr[1]/td[2]/select")));
                tipoT.selectByValue(asesuisaConsultaEdoCuentaTercerosBean.getTipoTercero());
                Thread.sleep(2000);

                switch (asesuisaConsultaEdoCuentaTercerosBean.getTipoTercero()){
                    case ("NaturalPerson"):
                        ConsultaNatural(m, driver, asesuisaConsultaEdoCuentaTercerosBean, i, 3,4,5,6, folderName);
                        break;
                    case ("LegalPerson"):
                        ConsultaJuridica(m,driver, asesuisaConsultaEdoCuentaTercerosBean, i, 3,4,5,6, folderName);
                        break;
                    default:
                        break;
                }
            }

            Thread.sleep(1000);
            driver.quit();

        }catch (Exception e){
            e.printStackTrace();
            Log.error("Test Case - " + nombreAutomatizacion + " - " + e);
            if (driver != null) {
                driver.quit();
            }
        }
    }

    public void ConsultaNatural(Metodos m, WebDriver driver, Asesuisa_ConsultaEdoCuentaTercerosBean asesuisaConsultaEdoCuentaTercerosBean,
                                int i, int screenShoot1, int screenShoot2, int screenShoot3, int screenShoot4,
                                String folderName){

        WebElement txtNombre, txtApellido, txtcIdentificador, txtEmail, txtDoc, btnBuscar, btnAceptar, rdButton;
        boolean result;

        JavascriptExecutor jse = (JavascriptExecutor) driver;

        try {
            if (asesuisaConsultaEdoCuentaTercerosBean.getPrimerNombre()!=null){
                txtNombre = driver.findElement(By.xpath("//*[@id=\"FirstName\"]"));
                txtNombre.sendKeys(asesuisaConsultaEdoCuentaTercerosBean.getPrimerNombre());
                Thread.sleep(500);
            }

            if (asesuisaConsultaEdoCuentaTercerosBean.getPrimerApellido()!=null){
                txtApellido = driver.findElement(By.xpath("//*[@id=\"LastName\"]"));
                txtApellido.sendKeys(asesuisaConsultaEdoCuentaTercerosBean.getPrimerApellido());
                Thread.sleep(500);
            }

            if (asesuisaConsultaEdoCuentaTercerosBean.getCodigoNit()!=null){
                txtcIdentificador = driver.findElement(By.xpath("//*[@id=\"Nit\"]"));
                txtcIdentificador.sendKeys(asesuisaConsultaEdoCuentaTercerosBean.getCodigoNit());
                Thread.sleep(500);
            }

            if (asesuisaConsultaEdoCuentaTercerosBean.getEmail()!=null){
                txtEmail = driver.findElement(By.xpath("//*[@id=\"Email\"]"));
                txtEmail.sendKeys(asesuisaConsultaEdoCuentaTercerosBean.getEmail());
                Thread.sleep(500);
            }

            if (asesuisaConsultaEdoCuentaTercerosBean.getDctoIdentificacion()!=null){
                txtDoc = driver.findElement(By.xpath("html/body/table[3]/tbody/tr[3]/td/form/table[13]/tbody/tr/td[3]/font/input[1]"));
                txtDoc.sendKeys(asesuisaConsultaEdoCuentaTercerosBean.getDctoIdentificacion());
                Thread.sleep(500);
            }

            //Pantallazos
            jse.executeScript("window.scrollBy(0,-3000)", "");
            Thread.sleep(800);
            m.ScreenShotPool(driver,i,"screen"+screenShoot1, nombreAutomatizacion, folderName);

            jse.executeScript("window.scrollBy(0,600)", "");
            Thread.sleep(800);
            m.ScreenShotPool(driver,i,"screen"+screenShoot2, nombreAutomatizacion, folderName);

            jse.executeScript("window.scrollBy(0,600)", "");
            Thread.sleep(800);
            m.ScreenShotPool(driver,i,"screen"+screenShoot3, nombreAutomatizacion, folderName);


            //Boton buscar
            btnBuscar = driver.findElement(By.xpath("//*[@id=\"idb_0402036_ThirdPartySearchForStatementAccount_01\"]"));
            btnBuscar.click();
            Thread.sleep(1000);

            result= ValidarBusqueda(driver);
            if (result){
                rdButton = driver.findElement(By.xpath("/html/body/table[2]/tbody/tr/td/table/tbody/tr[1]/td[1]/input[1]"));
                rdButton.click();
                Thread.sleep(800);

                //Pantallazo
                Thread.sleep(500);
                m.ScreenShotPool(driver,i,"screen"+screenShoot4, nombreAutomatizacion, folderName);

                //btnAceptar= driver.findElement(By.xpath("/html/body/table[2]/tbody/tr/td/table/tbody/tr["+j+"]/td/input"));
                btnAceptar = driver.findElement(By.className("altbuttonFormat"));
                btnAceptar.click();
                Thread.sleep(800);

                DetalleConsulta(m, driver, i, 7,8,9, folderName);
                Thread.sleep(500);
            }else {
                Thread.sleep(500);
                m.ScreenShotPool(driver,i,"screen"+screenShoot4, nombreAutomatizacion, folderName);
            }

        }catch (Exception e) {
            e.printStackTrace();
            Log.error("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }

    public void ConsultaJuridica(Metodos m, WebDriver driver, Asesuisa_ConsultaEdoCuentaTercerosBean asesuisaConsultaEdoCuentaTercerosBean,
                                 int i, int screenShoot1, int screenShoot2, int screenShoot3, int screenShoot4,
                                 String folderName){

        WebElement txtRazonSocial, txtCodigoIJuridico, txtTlfnEmpresa, txtEmailContacto, btnBuscar, btnAceptar, rdButton;
        Select paisOrigen;
        boolean result;
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        //Alert alert= driver.switchTo().alert();



        try {

            Thread.sleep(1500);

            //Mensaje de alerta
        /*if (alertPresente(driver))
            alert.accept();*/
            m.alertJavaScriptAceptar(driver);

            if (asesuisaConsultaEdoCuentaTercerosBean.getRazonSocial()!=null){
                txtRazonSocial = driver.findElement(By.xpath("html/body/table[3]/tbody/tr[3]/td/form/table[2]/tbody/tr/td[3]/font/input[1]"));
                txtRazonSocial.sendKeys(asesuisaConsultaEdoCuentaTercerosBean.getRazonSocial());
                Thread.sleep(800);
                WebElement auxRazon = driver.findElement(By.xpath("html/body/table[3]/tbody/tr[3]/td/form/table[2]/tbody/tr/td[2]/font"));
                auxRazon.click();
                Thread.sleep(2500);
                /*if (alertPresente(driver))
                    alert.accept();*/
            }

            if (asesuisaConsultaEdoCuentaTercerosBean.getCodigoIJuridico()!=null){
                txtCodigoIJuridico = driver.findElement(By.xpath("html/body/table[3]/tbody/tr[3]/td/form/table[8]/tbody/tr/td[3]/font/input[1]"));
                txtCodigoIJuridico.sendKeys(asesuisaConsultaEdoCuentaTercerosBean.getCodigoIJuridico());
                Thread.sleep(800);

                WebElement auxLogin = driver.findElement(By.xpath("html/body/table[3]/tbody/tr[3]/td/form/table[9]/tbody/tr/td[3]/font/input[1]"));
               /* if (alertPresente(driver))
                    alert.accept();*/
                auxLogin.click();
                Thread.sleep(2500);
               /* if (alertPresente(driver))
                    alert.accept();*/
            }

            if (asesuisaConsultaEdoCuentaTercerosBean.getPaisOrigen()!=null){
                paisOrigen = new Select(driver.findElement(By.xpath("html/body/table[3]/tbody/tr[3]/td/form/table[3]/tbody/tr/td[3]/font/select")));
                paisOrigen.selectByValue(asesuisaConsultaEdoCuentaTercerosBean.getPaisOrigen());
                Thread.sleep(2500);
                /*if (alertPresente(driver))
                    alert.accept();*/
                /*WebElement auxPais = driver.findElement(By.xpath("html/body/table[3]/tbody/tr[3]/td/form/table[3]/tbody/tr/td[1]/font"));
                auxPais.click();
                Thread.sleep(2500);
                alert.accept();*/
            }

            if (asesuisaConsultaEdoCuentaTercerosBean.getTlfEmpresa()!=null){
                txtTlfnEmpresa = driver.findElement(By.xpath("html/body/table[3]/tbody/tr[3]/td/form/table[5]/tbody/tr/td[3]/font/input[1]"));
                txtTlfnEmpresa.sendKeys(asesuisaConsultaEdoCuentaTercerosBean.getTlfEmpresa());
                Thread.sleep(800);
                WebElement auxtlfn = driver.findElement(By.xpath("html/body/table[3]/tbody/tr[3]/td/form/table[5]/tbody/tr/td[2]/font"));
                auxtlfn.click();
                Thread.sleep(2500);
                /*if (alertPresente(driver))
                    alert.accept();*/
            }

            if (asesuisaConsultaEdoCuentaTercerosBean.getEmailContacto()!=null){
                txtEmailContacto = driver.findElement(By.xpath("html/body/table[3]/tbody/tr[3]/td/form/table[11]/tbody/tr/td[3]/font/input[1]"));
                txtEmailContacto.sendKeys(asesuisaConsultaEdoCuentaTercerosBean.getEmailContacto());
                Thread.sleep(800);
                WebElement auxEmail = driver.findElement(By.xpath("html/body/table[3]/tbody/tr[3]/td/form/table[11]/tbody/tr/td[2]/font"));
                auxEmail.click();
                Thread.sleep(2500);
                /*if (alertPresente(driver))
                    alert.accept();*/
            }

           /* if (alertPresente(driver))
                alert.accept();*/

            //Pantallazos
            Thread.sleep(1500);
            jse.executeScript("window.scrollBy(0,-3000)", "");
            Thread.sleep(800);
            m.ScreenShotPool(driver,i,"screen"+screenShoot1, nombreAutomatizacion, folderName);

            jse.executeScript("window.scrollBy(0,600)", "");
            Thread.sleep(800);
            m.ScreenShotPool(driver,i,"screen"+screenShoot2, nombreAutomatizacion, folderName);

            jse.executeScript("window.scrollBy(0,600)", "");
            Thread.sleep(800);
            m.ScreenShotPool(driver,i,"screen"+screenShoot3, nombreAutomatizacion, folderName);


            //Boton buscar
            btnBuscar = driver.findElement(By.xpath("html/body/table[3]/tbody/tr[4]/td/button[1]"));
            btnBuscar.click();
            Thread.sleep(2000);

            result= ValidarBusqueda(driver);
            if (result){
                rdButton = driver.findElement(By.xpath("/html/body/table[2]/tbody/tr/td/table/tbody/tr[1]/td[1]/input[1]"));
                rdButton.click();
                Thread.sleep(800);

                //Pantallazo
                Thread.sleep(500);
                m.ScreenShotPool(driver,i,"screen"+screenShoot4, nombreAutomatizacion, folderName);

                //btnAceptar= driver.findElement(By.xpath("/html/body/table[2]/tbody/tr/td/table/tbody/tr["+j+"]/td/input"));
                btnAceptar = driver.findElement(By.className("altbuttonFormat"));
                btnAceptar.click();
                Thread.sleep(800);

                DetalleConsulta(m, driver, i, 7,8,9, folderName);
                Thread.sleep(500);
            }else {
                Thread.sleep(500);
                m.ScreenShotPool(driver,i,"screen"+screenShoot4, nombreAutomatizacion, folderName);
            }

        }catch (Exception e) {
            e.printStackTrace();
            Log.error("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }

    public boolean ValidarBusqueda(WebDriver driver){

        //WebElement bntAceptar, rdButton;
        String lblCaption;
        boolean aux=false;
        try {
            lblCaption = (driver.findElement(By.xpath("/html/body/table[2]/tbody/tr/td/table/tbody/tr/td")).getText());
            if (driver.findElement(By.xpath("/html/body/table[2]/tbody/tr/td/table/tbody/tr/td")).isDisplayed() &&
                    lblCaption.equals("No se encontraron terceros")){
                System.out.println("No se encontraron terceros");
                aux=false;
            }else if (driver.findElement(By.xpath("/html/body/table[2]/tbody/tr/td/table/tbody/tr[1]/td[1]")).isDisplayed()){
                System.out.println("Se encontraron terceros");
                aux=true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            Log.error("Test Case - " + nombreAutomatizacion + " - " + e);
        }
        return aux;
    }

    public void DetalleConsulta(Metodos m, WebDriver driver, int i, int screenShoot1, int screenShoot2, int screenShoot3,
                                String folderName){

        WebElement fInicial, fFinal, btnEnviar;
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        salida: try {

            if ( (driver.findElement(By.xpath("html/body/center[1]/table/tbody/tr[3]/td/table[1]/tbody/tr[4]/td[2]/b/font")).getText().equals("[Debe asociar al menos un rol al tercero]")) ){
                //pantallazos
                Thread.sleep(800);
                m.ScreenShotPool(driver,i,"screen"+screenShoot1, nombreAutomatizacion, folderName);
                break salida;
            }

            fInicial = driver.findElement(By.xpath("/html/body/center[1]/table/tbody/tr[3]/td/table[1]/tbody/tr[5]/td[2]/input[1]"));
            fInicial.clear();
            Thread.sleep(800);

            fFinal = driver.findElement(By.xpath("/html/body/center[1]/table/tbody/tr[3]/td/table[1]/tbody/tr[6]/td[2]/input[1]"));
            fFinal.clear();
            Thread.sleep(800);

            //pantallazos
            Thread.sleep(800);
            m.ScreenShotPool(driver,i,"screen"+screenShoot1, nombreAutomatizacion, folderName);

            btnEnviar = driver.findElement(By.xpath("//*[@id=\"idb_0402037_SearchConf_01\"]"));
            btnEnviar.click();
            Thread.sleep(3000);

            //pantallazos
            Thread.sleep(800);
            m.ScreenShotPool(driver,i,"screen"+screenShoot2, nombreAutomatizacion, folderName);

            Thread.sleep(800);
            jse.executeScript("window.scrollBy(0,600)", "");
            m.ScreenShotPool(driver,i,"screen"+screenShoot3, nombreAutomatizacion, folderName);
        }catch (Exception e) {
            e.printStackTrace();
            Log.error("Test Case - " + nombreAutomatizacion + " - " + e);
        }

    }

    public boolean alertPresente(WebDriver driver){
        try {
            driver.switchTo().alert();
            return true;
        }catch (Exception e){
            return false;
        }
    }

}
