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
            m.cambiarVentana(driver);
            Thread.sleep(1000);

            //Validar tipo tercero
            if (asesuisaConsultaEdoCuentaTercerosBean.getTipoTercero()!=null){
                tipoT = new Select(driver.findElement(By.xpath("/html/body/table[3]/tbody/tr[1]/td/form/table/tbody/tr[1]/td[2]/select")));
                tipoT.selectByValue(asesuisaConsultaEdoCuentaTercerosBean.getTipoTercero());
                Thread.sleep(500);

                switch (asesuisaConsultaEdoCuentaTercerosBean.getTipoTercero()){
                    case ("NaturalPerson"):
                        ConsultaNatural(driver, asesuisaConsultaEdoCuentaTercerosBean, i, 3, folderName);
                        break;
                    case ("LegalPerson"):
                        ConsultaJuridica(driver, asesuisaConsultaEdoCuentaTercerosBean, i, 3, folderName);
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

    public void ConsultaNatural(WebDriver driver, Asesuisa_ConsultaEdoCuentaTercerosBean asesuisaConsultaEdoCuentaTercerosBean,
                                int i, int screenShoot1, String folderName){

        WebElement txtNombre, txtApellido, txtcIdentificador, txtEmail, txtDoc, btnBuscar, btnAceptar, rdButton;
        boolean result;
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

            if (asesuisaConsultaEdoCuentaTercerosBean.getCodigoIdentificador()!=null){
                txtcIdentificador = driver.findElement(By.xpath("//*[@id=\"CodeIdentifier\"]"));
                txtcIdentificador.sendKeys(asesuisaConsultaEdoCuentaTercerosBean.getCodigoIdentificador());
                Thread.sleep(500);
            }

            if (asesuisaConsultaEdoCuentaTercerosBean.getEmail()!=null){
                txtEmail = driver.findElement(By.xpath("//*[@id=\"Email\"]"));
                txtEmail.sendKeys(asesuisaConsultaEdoCuentaTercerosBean.getEmail());
                Thread.sleep(500);
            }

            if (asesuisaConsultaEdoCuentaTercerosBean.getDctoIdentificacion()!=null){
                txtDoc = driver.findElement(By.xpath("//*[@id=\"IdentifierI\"]"));
                txtDoc.sendKeys(asesuisaConsultaEdoCuentaTercerosBean.getDctoIdentificacion());
                Thread.sleep(500);
            }

            //Pantallazos

            //Boton buscar
            btnBuscar = driver.findElement(By.xpath("//*[@id=\"idb_0402036_ThirdPartySearchForStatementAccount_01\"]"));
            btnBuscar.click();
            Thread.sleep(1000);

            result= ValidarBusqueda(driver);
            if (result){
                rdButton = driver.findElement(By.xpath("/html/body/table[2]/tbody/tr/td/table/tbody/tr[1]/td[1]/input[1]"));
                rdButton.click();
                Thread.sleep(800);


                btnAceptar= driver.findElement(By.xpath("/html/body/table[2]/tbody/tr/td/table/tbody/tr[16]/td/input"));
                btnAceptar.click();
                Thread.sleep(800);

                DetalleConsulta(driver, i, 5, folderName);
                Thread.sleep(500);
            }else {
                //pantallazo
            }

        }catch (Exception e) {
            e.printStackTrace();
            Log.error("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }

    public void ConsultaJuridica(WebDriver driver, Asesuisa_ConsultaEdoCuentaTercerosBean asesuisaConsultaEdoCuentaTercerosBean,
                                 int i, int screenShoot1, String folderName){

    }

    public boolean ValidarBusqueda(WebDriver driver){

        //WebElement bntAceptar, rdButton;
        boolean aux=false;
        try {
            if (driver.findElement(By.xpath("/html/body/table[2]/tbody/tr/td/table/tbody/tr/td")).isDisplayed()){
                System.out.println("No se encontraron terceros");
                aux=false;
            }else if (driver.findElement(By.xpath("/html/body/table[2]/tbody/tr/td/table/tbody/tr[16]/td/input")).isDisplayed()){
                System.out.println("Se encontraron terceros");
                aux=true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            Log.error("Test Case - " + nombreAutomatizacion + " - " + e);
        }
        return aux;
    }

    public void DetalleConsulta(WebDriver driver, int i, int screenShoot1, String folderName){

        WebElement fInicial, fFinal, btnEnviar;

        try {
            fInicial = driver.findElement(By.xpath("/html/body/center[1]/table/tbody/tr[3]/td/table[1]/tbody/tr[5]/td[2]/input[1]"));
            fInicial.clear();
            Thread.sleep(500);

            fFinal = driver.findElement(By.xpath("/html/body/center[1]/table/tbody/tr[3]/td/table[1]/tbody/tr[6]/td[2]/input[1]"));
            fFinal.clear();
            Thread.sleep(500);

            //pantallazos

            btnEnviar = driver.findElement(By.xpath("//*[@id=\"idb_0402037_SearchConf_01\"]"));
            btnEnviar.click();
            Thread.sleep(3000);

            //pantallazos
        }catch (Exception e) {
            e.printStackTrace();
            Log.error("Test Case - " + nombreAutomatizacion + " - " + e);
        }

    }
}
