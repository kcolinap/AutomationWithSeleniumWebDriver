package AcseleV13_8Asesuisa.main.controller;

import AcseleV13_8Asesuisa.beans.Asesuisa_TercerosCambioTipoDocumentoBean;
import AcseleV13_8Asesuisa.main.controller.Asesuisa_Menu.Asesuisa_MenuMantenimiento;
import metodo.Metodos;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
/**
 * Created by kcolina on 18/04/2017.
 */
public class Asesuisa_TercerosCambioTipoDocumento {

    private final static Logger log = Logger.getLogger(Asesuisa_TercerosCambioTipoDocumento.class);

    public String nombreAutomatizacion = "Cambio de documento Tercero";
    private WebDriver driver;

    public void testLink(Asesuisa_TercerosCambioTipoDocumentoBean bean, int i, String folderName){

        try {

            Metodos m = new Metodos();
            Asesuisa_MenuMantenimiento asesuisaMenuMantenimiento = new Asesuisa_MenuMantenimiento();

            driver = m.entrarPagina(m.UrlAsesuisa());
            m.IniciarSesion(driver, nombreAutomatizacion,i,folderName);
            m.ValidandoSesion(driver, nombreAutomatizacion, i, folderName);
            Thread.sleep(1000);

            //Ingreso a la opcion consulta de terceros
            asesuisaMenuMantenimiento.MantTerc_BuscarTercero(driver, nombreAutomatizacion,2,i,folderName);

            Thread.sleep(2000);
            m.cambiarVentana(driver);
            Thread.sleep(2000);

            //Buscar tercero
            TipoBusqueda(driver, m, bean, folderName, i, 3, 4, 5);
            Thread.sleep(1000);

            //driver.quit();
        }catch (Exception e){
            e.printStackTrace();
            log.error("Test Case - " + nombreAutomatizacion + " - " + e);
            if (driver != null) {
                driver.quit();
            }
        }
    }

    public void TipoBusqueda(WebDriver driver, Metodos m, Asesuisa_TercerosCambioTipoDocumentoBean bean,
                             String folderName, int i, int screen1, int screen2, int screen3){
        try{

            int scenarioBusqueda;
            if ( (bean.getPrimerApellido()==null) &&
                    (bean.getNumeroDocumento()==null) && (bean.getCodigoIdentificador()==null)){
                scenarioBusqueda=1;
            }else{
                //Evaluo tipo tercero
                if(bean.getTipoTercero()!=null){
                    Thread.sleep(500);
                    Select tipoT = new Select(driver.findElement(By.xpath("//select[@wicketpath='SearchContent_ThirdInformation_thirdPartyTypes']")));
                    tipoT.selectByValue(bean.getTipoTercero());
                    Thread.sleep(1000);
                }

                //Evaluo si hay primer nombre
                if (bean.getPrimerNombre()!=null){
                    Thread.sleep(500);
                    WebElement txtNombre = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel2_1_fila_field']"));
                    txtNombre.sendKeys(bean.getPrimerNombre());
                    Thread.sleep(1000);
                }
                scenarioBusqueda=2;
            }

            switch (scenarioBusqueda){
                case 1:
                    //Busqueda general, sin campo especxifico
                    BusquedaGeneral(driver, m, bean, folderName, i, screen1, screen2, screen3);
                    break;
                case 2:
                    //Busqueda especiofica, se lleno algun campo de busqueda
                    System.out.println("Caso 2");
                    break;
                default:
                    break;
            }


        }catch (Exception e) {
            e.printStackTrace();
            log.error("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }

    public void BusquedaGeneral(WebDriver driver, Metodos m, Asesuisa_TercerosCambioTipoDocumentoBean bean,
                                String folderName, int i, int screen1, int screen2, int screen3){
        try{
            //Boton buscar
            WebElement btnBuscar = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_searchButton']"));
            btnBuscar.click();
            m.waitSearchWicket(driver,". Buscando tercero");
            Thread.sleep(400);


            //Evaluo si se despliega el dialogo
            if (driver.findElements(By.className("w_windowMessage")).size()>0){
                WebElement btnAceptar = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_ConfirmExport_content_questionForm_confirmButton']"));
                btnAceptar.click();
                Thread.sleep(1000);
            }

            //Recorrer los terceros encontrados hasta encontrar uno habilitado(Si aplica)
            int nroFilas = driver.findElements(By.xpath("html/body/div[1]/div[3]/div[1]/div/div/div[2]/div[1]/div/div/div[4]/div[1]/div[1]/table/tbody/tr")).size();
            String lblStatus="", lblCodigo;
            WebElement optTercero;
            int aux=0;

            for (int k=0; k<nroFilas; k++){
               lblStatus=driver.findElement(By.xpath("html/body/div[1]/div[3]/div[1]/div/div/div[2]/div[1]/div/div/div[4]/div[1]/div[1]/table/tbody/tr["+(k+1)+"]/td[4]/div/span")).getText();
                lblCodigo = driver.findElement(By.xpath("html/body/div[1]/div[3]/div[1]/div/div/div[2]/div[1]/div/div/div[4]/div[1]/div[1]/table/tbody/tr["+(k+1)+"]/td[3]/div/span")).getText();
                if ((lblStatus.equals("Habilitado")) && (lblCodigo!=null)){
                    optTercero=driver.findElement(By.xpath("html/body/div[1]/div[3]/div[1]/div/div/div[2]/div[1]/div/div/div[4]/div[1]/div[1]/table/tbody/tr["+(k+1)+"]/td[1]/div/input"));
                    optTercero.click();
                    Thread.sleep(1000);
                    System.out.println("Tercero seleccionado: ");
                    System.out.println("Nombre: " + (driver.findElement(By.xpath("html/body/div[1]/div[3]/div[1]/div/div/div[2]/div[1]/div/div/div[4]/div[1]/div[1]/table/tbody/tr[" + (k + 1) + "]/td[2]/div/span")).getText()));
                    System.out.println("Codigo Identificador: "+(driver.findElement(By.xpath("html/body/div[1]/div[3]/div[1]/div/div/div[2]/div[1]/div/div/div[4]/div[1]/div[1]/table/tbody/tr["+(k+1)+"]/td[3]/div/span")).getText()));
                    aux=k;
                    break;
                }
            }
            aux+=1;

            //pantallazo
            //Boton Consultar
            WebElement btnConsultar = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_showDetailSearchTable_proof_TableForm_consultThirdButton']"));
            btnConsultar.click();
            m.waitSearchWicket(driver,". Consultando");
            Thread.sleep(500);

            //pantallazo


            String nroDocto1 = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_BasicInformation_formThirdBasic_DataTemplate_repeaterPanel1_7_fila_field']")).getAttribute("value");
            System.out.println("nro documento copiado: "+nroDocto1);

            //Vuelvo a consulta
            WebElement btnVolver = driver.findElement(By.xpath("//span[@wicketpath='ThirdInformationContent_panelInformationAndReturnPage_form_editValidity_editValidityLabel']"));
            btnVolver.click();
            m.waitSearchWicket(driver,". Volviendo a busqueda");


            //Seleccionar otro tercero
            for (int k=aux; k<nroFilas; k++){
                lblStatus=driver.findElement(By.xpath("html/body/div[1]/div[3]/div[1]/div/div/div[2]/div[1]/div/div/div[4]/div[1]/div[1]/table/tbody/tr["+(k+1)+"]/td[4]/div/span")).getText();
                lblCodigo = driver.findElement(By.xpath("html/body/div[1]/div[3]/div[1]/div/div/div[2]/div[1]/div/div/div[4]/div[1]/div[1]/table/tbody/tr["+(k+1)+"]/td[3]/div/span")).getText();
                if ((lblStatus.equals("Habilitado")) && (!(lblCodigo.equals("")))){
                    optTercero=driver.findElement(By.xpath("html/body/div[1]/div[3]/div[1]/div/div/div[2]/div[1]/div/div/div[4]/div[1]/div[1]/table/tbody/tr["+(k+1)+"]/td[1]/div/input"));
                    optTercero.click();
                    Thread.sleep(1000);
                    System.out.println("Tercero a editar  seleccionado: ");
                    System.out.println("Nombre: " + (driver.findElement(By.xpath("html/body/div[1]/div[3]/div[1]/div/div/div[2]/div[1]/div/div/div[4]/div[1]/div[1]/table/tbody/tr[" + (k + 1) + "]/td[2]/div/span")).getText()));
                    System.out.println("Codigo Identificador: "+(driver.findElement(By.xpath("html/body/div[1]/div[3]/div[1]/div/div/div[2]/div[1]/div/div/div[4]/div[1]/div[1]/table/tbody/tr["+(k+1)+"]/td[3]/div/span")).getText()));
                    break;
                }
                lblStatus="";lblCodigo="";
            }

            //Boton editar
            WebElement btnEditar = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_showDetailSearchTable_proof_TableForm_associateButton']"));
            btnEditar.click();
            m.waitSearchWicket(driver, ". Entrando a modo edicion");

            if (bean.getTipoDocumento()!=null){
                Thread.sleep(500);
                Select tipoD = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_BasicInformation_formThirdBasic_DataTemplate_repeaterPanel2_6_fila_repeaterSelect_1_field']")));
                tipoD.selectByValue(bean.getTipoDocumento());
                Thread.sleep(1000);
            }


        }catch (Exception e) {
            e.printStackTrace();
            log.error("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }
}
