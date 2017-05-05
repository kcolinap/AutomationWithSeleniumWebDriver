package AcseleV13_8Asesuisa.main.controller;

import AcseleV13_8Asesuisa.beans.Asesuisa_ModosdePagoBean;
import AcseleV13_8Asesuisa.beans.Asesuisa_RolesBean;
import AcseleV13_8Asesuisa.beans.Asesuisa_TercerosCreacionRepetidaBean;
import AcseleV13_8Asesuisa.main.controller.Asesuisa_Menu.Asesuisa_MenuMantenimiento;
import AcseleV13_8Asesuisa.main.controller.Asesuisa_Terceros.Asesuisa_CrearTerceros;
import AcseleV13_8Asesuisa.main.controller.Asesuisa_TercerosCreacionRepetida;
import metodo.Metodos;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import java.util.List;

import java.lang.Boolean;
import java.util.Random;

import java.awt.*;
import java.sql.SQLException;


/**
 * Created by cortiz on 12/04/2017.
 */
public class Asesuisa_Roles {

    private final static Logger log = Logger.getLogger(Asesuisa_Roles.class);

    public String nombreAutomatizacion = "Asesuisa Roles";
    private WebDriver driver;
    Boolean creado ;


    public void testLink(Asesuisa_RolesBean bean, int i, String folderName, String num) {

        try {

            // Instanciando clases
            Metodos a = new Metodos();
            Asesuisa_MenuMantenimiento menuMantenimiento = new Asesuisa_MenuMantenimiento();
            Asesuisa_TercerosCreacionRepetida asesuisaCrearTerceros = new Asesuisa_TercerosCreacionRepetida();



            driver = a.entrarPagina(a.UrlAsesuisa());
            a.IniciarSesion(driver, nombreAutomatizacion, i, folderName);
            a.ValidandoSesion(driver, nombreAutomatizacion, i, folderName);
            Thread.sleep(5000);
            if (num == "1") {
                //Entrando en Menu
                menuMantenimiento.MantTerc_IngresarTercero(driver, nombreAutomatizacion, 2, i, folderName);

                Thread.sleep(2000);
                a.cambiarVentana(driver);
                Thread.sleep(2000);

                CrearTercero(bean, a, i, folderName, 3, 4, 5, 6, 7, 8);
                Thread.sleep(2000);
                driver.close();
                a.regresarVentana(driver);     //regresar ventana

                //Entrando en Menu
                //Ingreso a la opcion consulta de terceros
                menuMantenimiento.MantTerc_BuscarTercero(driver, nombreAutomatizacion, 2, i, folderName);


                Thread.sleep(2000);
                a.cambiarVentana(driver);
                Thread.sleep(2000);

                BusquedaT(bean, a, i, folderName, 3,4,5,6,7);

                AgregarRol(bean, a, i, folderName, 8, 9, 10, 11, 12);

            } else{

                //Entrando en Menu
                //Ingreso a la opcion busqueda de terceros
                menuMantenimiento.MantTerc_BuscarTercero(driver, nombreAutomatizacion, 2, i, folderName);


                Thread.sleep(2000);
                a.cambiarVentana(driver);
                Thread.sleep(2000);

                BusquedaT(bean, a, i, folderName, 3,4,5,6,7);
                AgregarRol(bean, a, i, folderName, 8, 9, 10, 11, 12);

            }






            Thread.sleep(1000);


           driver.quit();

        } catch (Exception e) {
            e.printStackTrace();
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
            if (driver != null) {
               driver.quit();
            }
        }
    }

    public void CrearTercero(Asesuisa_RolesBean bean, Metodos a, int i, String folderName, int numScreenShoot, int numScreenShoot2, int numScreenShoot3, int numScreenShoot4,
                             int numScreenShoot5, int numScreenShoot6) {
        what:  try {

            Thread.sleep(5000);
            Random rnd = new Random();
            if (bean.getTipoTercero() != null) {
                Select tipoTercero = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_ThirdInformation_thirdPartyTypes']")));
                tipoTercero.selectByValue(bean.getTipoTercero());
                Thread.sleep(1000);
            }

            WebElement otro = driver.findElement(By.xpath("//div[@wicketpath='ThirdInformationContent_ThirdInformation_ThirdInformationLabel']"));

            // Benefeciario Asegurado AP
            if (bean.getAsegurado() != null) {
                Select aseguradoAp = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_ThirdInformation_templateContainer_formThirdBasic_DataTemplate_repeaterPanel1_1_fila_repeaterSelect_1_field']")));
                aseguradoAp.selectByValue(bean.getAsegurado());
                Thread.sleep(1000);
                otro.click();
                Thread.sleep(1000);
            }

            // Primer nombre
            if (bean.getPRIMERNOMBRE() != null) {
                WebElement nombre1 = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_ThirdInformation_templateContainer_formThirdBasic_DataTemplate_repeaterPanel2_1_fila_field']"));
                nombre1.sendKeys(bean.getPRIMERNOMBRE());
                otro.click();
                Thread.sleep(1000);
            }

            // Primer apellido
            if (bean.getPRIMERAPELLIDO() != null) {
                WebElement apellido1 = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_ThirdInformation_templateContainer_formThirdBasic_DataTemplate_repeaterPanel2_2_fila_field']"));
                apellido1.sendKeys(bean.getPRIMERAPELLIDO());
                otro.click();
                Thread.sleep(1000);
            }

            // Fecha de nacimiento
            if (bean.getFNACIMIENTO() != null) {
                WebElement fechaNacimiento = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_ThirdInformation_templateContainer_formThirdBasic_DataTemplate_repeaterPanel2_4_fila_fieldDate']"));
                fechaNacimiento.sendKeys(bean.getFNACIMIENTO());
                otro.click();
                Thread.sleep(1000);
            }
            int i1 = (int) (rnd.nextDouble() * 999999999 + 000000001);


            String numCad = String.valueOf(i1);
            System.out.println(" " + numCad);
            // DUI
            if (bean.getNDUI() != null) {
                WebElement dui = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_BasicInformation_formThirdBasic_DataTemplate_repeaterPanel2_5_fila_field']"));
                dui.sendKeys(numCad);
                otro.click();                  //ThirdInformationContent_ThirdInformation_templateContainer_formThirdBasic_DataTemplate_repeaterPanel2_5_fila_field
                Thread.sleep(1000);
            }

            int i2 = (int) (rnd.nextDouble() * 1000000000 + 0000000002);


            String numCad2 = String.valueOf(i2);
            System.out.println(" " + numCad2);

            if (numCad2.length() < 9) {

                numCad2 = numCad2 + "555555";
                System.out.println("8: " + numCad2); } else {
                numCad2 = numCad2 + "55555";
                System.out.println(" " + numCad2);

            }

            // NIT
            if (bean.getNNIT() != null) {
                WebElement nit = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_ThirdInformation_templateContainer_formThirdBasic_DataTemplate_repeaterPanel1_5_fila_field']"));
                nit.sendKeys(numCad2);
                otro.click();
                Thread.sleep(1000);
            }

            // Tipo documento identificacion
            if (bean.getTDOCUMENTO() != null) {
                Select tipoDocId = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_ThirdInformation_templateContainer_formThirdBasic_DataTemplate_repeaterPanel2_6_fila_repeaterSelect_1_field']")));
                tipoDocId.selectByValue(bean.getTDOCUMENTO());
                Thread.sleep(1000);
                 otro.click();
                Thread.sleep(1000);
            }

            int i3 = (int) (rnd.nextDouble() * 1000000000 + 0000000003);


            String numCad3 = String.valueOf(i1);
            System.out.println(" " + numCad3);

            // Numero documento identificacion
            if (bean.getNDOCUMENTO() != null) {
                WebElement numId = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_ThirdInformation_templateContainer_formThirdBasic_DataTemplate_repeaterPanel1_7_fila_field']"));
                numId.sendKeys(numCad3);
                otro.click();
                Thread.sleep(3000);
            }


            WebElement btnGuardar = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_ThirdInformation_templateContainer_formThirdBasic_saveButton']"));
            Thread.sleep(2000);

            btnGuardar.click();
            a.waitSearchWicket(driver, "Espere, Guardando Tercero");
            System.out.println("Tercero Creado ");
            Thread.sleep(3000);

            Boolean bMensaje = driver.findElements(By.id("_wicket_window_0")).size() > 0;
            if (bMensaje){
                WebElement mensajeErrorTipo = driver.findElement(By.xpath("//div[@wicketpath='ThirdInformationContent_ThirdInformation_templateContainer_errorsPanel_content_errorsForm_table_repeaterErrors_1_error']"));
                WebElement mensajeError = driver.findElement(By.xpath("//div[@wicketpath='ThirdInformationContent_ThirdInformation_templateContainer_errorsPanel_content_errorsForm_table_repeaterErrors_1_errorsMessage1_repeaterMessage_1_message']"));
                System.out.println(mensajeErrorTipo.getText() + "\t" + mensajeError.getText());
                Boolean bMensaje2 = driver.findElements(By.xpath("//div[@wicketpath='ThirdInformationContent_ThirdInformation_templateContainer_errorsPanel_content_errorsForm_table_repeaterErrors_2_errorsMessage1_repeaterMessage_1_message']")).size() > 0;
                Boolean bMensaje3 = driver.findElements(By.xpath("//div[@wicketpath='ThirdInformationContent_ThirdInformation_templateContainer_errorsPanel_content_errorsForm_table_repeaterErrors_3_errorsMessage1_repeaterMessage_1_message']")).size() > 0;
                if (bMensaje2 && bMensaje3){
                    WebElement mensajeErrorTipo2 = driver.findElement(By.xpath("//div[@wicketpath='ThirdInformationContent_ThirdInformation_templateContainer_errorsPanel_content_errorsForm_table_repeaterErrors_2_error']"));
                    WebElement mensajeErrorTipo3 = driver.findElement(By.xpath("//div[@wicketpath='ThirdInformationContent_ThirdInformation_templateContainer_errorsPanel_content_errorsForm_table_repeaterErrors_3_error']"));
                    WebElement mensajeError2 = driver.findElement(By.xpath("//div[@wicketpath='ThirdInformationContent_ThirdInformation_templateContainer_errorsPanel_content_errorsForm_table_repeaterErrors_2_errorsMessage1_repeaterMessage_1_message']"));
                    WebElement mensajeError3 = driver.findElement(By.xpath("//div[@wicketpath='ThirdInformationContent_ThirdInformation_templateContainer_errorsPanel_content_errorsForm_table_repeaterErrors_3_errorsMessage1_repeaterMessage_1_message']"));
                    System.out.println(mensajeErrorTipo2.getText() + "\t" + mensajeError2.getText());
                    System.out.println(mensajeErrorTipo3.getText() + "\t" + mensajeError3.getText());

                }
            }
            else {
                System.out.println("failed");
                break what;
            }


        } catch (Exception e) {
            e.printStackTrace();
            log.error("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }









    public void BusquedaT(Asesuisa_RolesBean bean, Metodos a, int i, String folderName, int numScreenShoot, int numScreenShoot2, int numScreenShoot3, int numScreenShoot4, int numScreenShot5) {

        try {


            JavascriptExecutor jse = (JavascriptExecutor) driver;
            WebElement etiqueta;

            System.out.println("Buscando tercero");

            Thread.sleep(5000);
            //Tipo tercero
            if (bean.getTipoTercero() != null) {
                Thread.sleep(6000);
                Select tipoT = new Select(driver.findElement(By.xpath("//select[@wicketpath='SearchContent_ThirdInformation_thirdPartyTypes']")));
                tipoT.selectByValue(bean.getTipoTercero());
                Thread.sleep(1000);
            }

            //AseguradoAP
            if (bean.getAsegurado() != null) {
                Select aseguradoAp = new Select(driver.findElement(By.xpath("//select[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_1_fila_repeaterSelect_1_field']")));
                aseguradoAp.selectByValue(bean.getAsegurado());
                Thread.sleep(1000);
            }

            //AseguradoAP
            if (bean.getPRIMERNOMBRE() != null) {
               WebElement pNombre = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel2_1_fila_field']"));
                pNombre.sendKeys(bean.getPRIMERNOMBRE());
                Thread.sleep(1000);
            }



            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion, folderName);
            Thread.sleep(1000);


            //Boton buscar
            jse.executeScript("window.scrollBy(0,500)", "");
            WebElement buscar = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_searchButton']"));
            buscar.click();
            Thread.sleep(1000);
            buscar = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_searchButton']"));
            buscar.click();
            a.waitSearchWicket(driver, "Espere, Buscando Tercero");
            jse.executeScript("window.scrollBy(0,300)", "");
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot2, nombreAutomatizacion, folderName);
            Thread.sleep(1000);




            //To locate table.
            WebElement mytable = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[1]/div/div/div[2]/div[1]/div/div/div[4]/div[1]/div[1]/table/tbody"));

            //To locate rows of table.
            List<WebElement> rows_table = mytable.findElements(By.tagName("tr"));
            //To calculate no of rows In table.
            int rows_count = rows_table.size();

            System.out.println("Cantidad de filas con mismo nombre " + rows_count);

            //seleccionar tercero encontrado
            Thread.sleep(2000);
            WebElement selccionTercero = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_showDetailSearchTable_proof_ThirdPartyRadioGroup_resultsTable_" + rows_count + "_thirdPartyRadio']"));
            selccionTercero.click();


            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot3, nombreAutomatizacion, folderName);

            //Boton editar
            WebElement editar = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_showDetailSearchTable_proof_TableForm_associateButton']"));
            editar.click();
            jse.executeScript("window.scrollBy(0,1000)", "");

            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot4, nombreAutomatizacion, folderName);
            Thread.sleep(1000);

        } catch (Exception e) {
            e.printStackTrace();
            log.error("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }

    public void AgregarRol(Asesuisa_RolesBean bean, Metodos a, int i, String folderName, int numScreenShoot, int numScreenShoot2, int numScreenShoot3, int numScreenShoot4, int numScreenShoot5){

        try{
            Thread.sleep(3000);
            JavascriptExecutor jse = (JavascriptExecutor)driver;
            jse.executeScript("window.scrollBy(0,500)", "");
            String tipoRol =  bean.getTIPOROL();


            if (bean.getTIPOROL() != null){
                Thread.sleep(6000);
                Select tipoT = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_thirdInformation_panelRol_rolForm_rolComb']")));
                tipoT.selectByVisibleText(bean.getTIPOROL());
                Thread.sleep(1000);
            }

            WebElement Agregar = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_panelRol_rolForm_AddButton']"));
            Agregar.click();
            Thread.sleep(1000);
            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion, folderName);
            Thread.sleep(1000);
         //   WebElement otro = driver.findElement(By.xpath("//div[@wicketpath='ThirdInformationContent_thirdInformation_rolMessage']"));

            System.out.println("Agregando " + tipoRol);
            switch (tipoRol){

                case "Administracion":

                    if (bean.getTIPOCOMPROBANTE() != null) {
                        Thread.sleep(1000);
                        Select tComprobante = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_thirdInformation_panelRol_templateContainer_rolTempForm_templateBasicThird_tabPanel_repeaterTab_1_SubTabsInformation_repeater_2_fila_repeaterSelect_1_field']")));
                        tComprobante.selectByValue(bean.getTIPOCOMPROBANTE());
                        // otro.click();
                        Thread.sleep(1000);
                    }

                    if (bean.getTIPOPROVEEDOR() != null) {
                        Thread.sleep(1000);
                        Select tProveedor = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_thirdInformation_panelRol_templateContainer_rolTempForm_templateBasicThird_tabPanel_repeaterTab_1_SubTabsInformation_repeater_3_fila_repeaterSelect_1_field']")));
                        tProveedor.selectByValue(bean.getTIPOPROVEEDOR());
                        // otro.click();
                        Thread.sleep(1000);
                    }



                    jse.executeScript("window.scrollBy(0,1000)", "");

                    if (bean.getCLASIFIAREA() != null) {
                        Thread.sleep(1000);
                        Select areaClasifi = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_thirdInformation_panelRol_templateContainer_rolTempForm_templateBasicThird_tabPanel_repeaterTab_1_SubTabsInformation_repeater_5_fila_repeaterSelect_1_field']")));
                        areaClasifi.selectByValue(bean.getCLASIFIAREA());
                        Thread.sleep(1000);
                    }

                    if (bean.getCONTRATO() != null) {
                        Thread.sleep(1000);
                        Select contrato = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_thirdInformation_panelRol_templateContainer_rolTempForm_templateBasicThird_tabPanel_repeaterTab_1_SubTabsInformation_repeater_6_fila_repeaterSelect_1_field']")));
                        contrato.selectByValue(bean.getCONTRATO());
                        // otro.click();
                        Thread.sleep(1000);
                    }

                    if (bean.getCONVENIO() != null) {
                        Thread.sleep(1000);
                        Select convenio = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_thirdInformation_panelRol_templateContainer_rolTempForm_templateBasicThird_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_1_fila_repeaterSelect_1_field']")));
                        convenio.selectByValue(bean.getCONVENIO());
                        // otro.click();
                        Thread.sleep(1000);

                    }

                    jse.executeScript("window.scrollBy(0,500)", "");


                    break;

                case "Ajustador Externo":  // Ajustador externo


                    if (bean.getTIPOCOMPROBANTE() != null) {
                        Thread.sleep(1000);
                        Select tComprobante = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_thirdInformation_panelRol_templateContainer_rolTempForm_templateBasicThird_tabPanel_repeaterTab_1_SubTabsInformation_repeater_2_fila_repeaterSelect_1_field']")));
                        tComprobante.selectByValue(bean.getTIPOCOMPROBANTE());
                        // otro.click();
                        Thread.sleep(1000);
                    }

                    if (bean.getTIPOPROVEEDOR() != null) {
                        Thread.sleep(1000);
                        Select tProveedor = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_thirdInformation_panelRol_templateContainer_rolTempForm_templateBasicThird_tabPanel_repeaterTab_1_SubTabsInformation_repeater_3_fila_repeaterSelect_1_field']")));
                        tProveedor.selectByValue(bean.getTIPOPROVEEDOR());
                        // otro.click();
                        Thread.sleep(1000);
                    }



                    jse.executeScript("window.scrollBy(0,1000)", "");

                    if (bean.getCLASIFIAREA() != null) {
                        Thread.sleep(1000);
                        Select areaClasifi = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_thirdInformation_panelRol_templateContainer_rolTempForm_templateBasicThird_tabPanel_repeaterTab_1_SubTabsInformation_repeater_5_fila_repeaterSelect_1_field']")));
                        areaClasifi.selectByValue(bean.getCLASIFIAREA());
                        Thread.sleep(1000);
                    }

                    if (bean.getCONTRATO() != null) {
                        Thread.sleep(1000);
                        Select contrato = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_thirdInformation_panelRol_templateContainer_rolTempForm_templateBasicThird_tabPanel_repeaterTab_1_SubTabsInformation_repeater_6_fila_repeaterSelect_1_field']")));
                        contrato.selectByValue(bean.getCONTRATO());
                        // otro.click();
                        Thread.sleep(1000);
                    }

                    if (bean.getCONVENIO() != null) {
                        Thread.sleep(1000);
                        Select convenio = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_thirdInformation_panelRol_templateContainer_rolTempForm_templateBasicThird_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_1_fila_repeaterSelect_1_field']")));
                        convenio.selectByValue(bean.getCONVENIO());
                        // otro.click();
                        Thread.sleep(1000);

                    }

                    jse.executeScript("window.scrollBy(0,500)", "");




                    break;

                case "Arquitecto":
                    System.out.println("Arquitecto ");


                    if (bean.getTIPOCOMPROBANTE() != null) {
                        Thread.sleep(1000);
                        Select tComprobante = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_thirdInformation_panelRol_templateContainer_rolTempForm_templateBasicThird_tabPanel_repeaterTab_1_SubTabsInformation_repeater_2_fila_repeaterSelect_1_field']")));
                        tComprobante.selectByValue(bean.getTIPOCOMPROBANTE());
                        // otro.click();
                        Thread.sleep(1000);
                    }

                    if (bean.getTIPOPROVEEDOR() != null) {
                        Thread.sleep(1000);
                        Select tProveedor = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_thirdInformation_panelRol_templateContainer_rolTempForm_templateBasicThird_tabPanel_repeaterTab_1_SubTabsInformation_repeater_3_fila_repeaterSelect_1_field']")));
                        tProveedor.selectByValue(bean.getTIPOPROVEEDOR());
                        // otro.click();
                        Thread.sleep(1000);
                    }



                   // jse.executeScript("window.scrollBy(0,1300)", "");

                    if (bean.getCLASIFIAREA() != null) {
                        Thread.sleep(1000);
                        Select areaClasifi = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_thirdInformation_panelRol_templateContainer_rolTempForm_templateBasicThird_tabPanel_repeaterTab_1_SubTabsInformation_repeater_4_fila_repeaterSelect_1_field']")));
                        areaClasifi.selectByValue(bean.getCLASIFIAREA());
                        Thread.sleep(1000);
                    }

                    if (bean.getCONTRATO() != null) {
                        Thread.sleep(1000);
                        Select contrato = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_thirdInformation_panelRol_templateContainer_rolTempForm_templateBasicThird_tabPanel_repeaterTab_1_SubTabsInformation_repeater_5_fila_repeaterSelect_1_field']")));
                        contrato.selectByValue(bean.getCONTRATO());
                        // otro.click();
                        Thread.sleep(1000);
                    }

                    if (bean.getCONVENIO() != null) {
                        Thread.sleep(1000);
                        Select convenio = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_thirdInformation_panelRol_templateContainer_rolTempForm_templateBasicThird_tabPanel_repeaterTab_1_SubTabsInformation_repeater_6_fila_repeaterSelect_1_field']")));
                        convenio.selectByValue(bean.getCONVENIO());
                        // otro.click();
                        Thread.sleep(1000);

                    }

                    jse.executeScript("window.scrollBy(0,500)", "");


                    break;

                case "AsesorLegal":

                    if (bean.getTIPOCOMPROBANTE() != null) {
                        Thread.sleep(1000);
                        Select tComprobante = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_thirdInformation_panelRol_templateContainer_rolTempForm_templateBasicThird_tabPanel_repeaterTab_1_SubTabsInformation_repeater_2_fila_repeaterSelect_1_field']")));
                        tComprobante.selectByValue(bean.getTIPOCOMPROBANTE());
                        // otro.click();
                        Thread.sleep(1000);
                    }

                    if (bean.getTIPOPROVEEDOR() != null) {
                        Thread.sleep(1000);
                        Select tProveedor = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_thirdInformation_panelRol_templateContainer_rolTempForm_templateBasicThird_tabPanel_repeaterTab_1_SubTabsInformation_repeater_3_fila_repeaterSelect_1_field']")));
                        tProveedor.selectByValue(bean.getTIPOPROVEEDOR());
                        // otro.click();
                        Thread.sleep(1000);
                    }



                  //  jse.executeScript("window.scrollBy(0,1000)", "");

                    if (bean.getCLASIFIAREA() != null) {
                        Thread.sleep(1000);
                        Select areaClasifi = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_thirdInformation_panelRol_templateContainer_rolTempForm_templateBasicThird_tabPanel_repeaterTab_1_SubTabsInformation_repeater_5_fila_repeaterSelect_1_field']")));
                        areaClasifi.selectByValue(bean.getCLASIFIAREA());
                        Thread.sleep(1000);
                    }

                    if (bean.getCONTRATO() != null) {
                        Thread.sleep(1000);
                        Select contrato = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_thirdInformation_panelRol_templateContainer_rolTempForm_templateBasicThird_tabPanel_repeaterTab_1_SubTabsInformation_repeater_6_fila_repeaterSelect_1_field']")));
                        contrato.selectByValue(bean.getCONTRATO());
                        // otro.click();
                        Thread.sleep(1000);
                    }

                    if (bean.getCONVENIO() != null) {
                        Thread.sleep(1000);
                        Select convenio = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_thirdInformation_panelRol_templateContainer_rolTempForm_templateBasicThird_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_1_fila_repeaterSelect_1_field']")));
                        convenio.selectByValue(bean.getCONVENIO());
                        // otro.click();
                        Thread.sleep(1000);

                    }

                    jse.executeScript("window.scrollBy(0,500)", "");


                    break;

                case "Auditor Médico":

                    if (bean.getTIPOCOMPROBANTE() != null) {
                        Thread.sleep(1000);
                        Select tComprobante = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_thirdInformation_panelRol_templateContainer_rolTempForm_templateBasicThird_tabPanel_repeaterTab_1_SubTabsInformation_repeater_4_fila_repeaterSelect_1_field']")));
                        tComprobante.selectByValue(bean.getTIPOCOMPROBANTE());
                        // otro.click();
                        Thread.sleep(1000);
                    }

                    if (bean.getTIPOPROVEEDOR() != null) {
                        Thread.sleep(1000);
                        Select tProveedor = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_thirdInformation_panelRol_templateContainer_rolTempForm_templateBasicThird_tabPanel_repeaterTab_1_SubTabsInformation_repeater_5_fila_repeaterSelect_1_field']")));
                        tProveedor.selectByValue(bean.getTIPOPROVEEDOR());
                        // otro.click();
                        Thread.sleep(1000);
                    }



                    jse.executeScript("window.scrollBy(0,1000)", "");

                    if (bean.getCLASIFIAREA() != null) {
                        Thread.sleep(1000);
                        Select areaClasifi = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_thirdInformation_panelRol_templateContainer_rolTempForm_templateBasicThird_tabPanel_repeaterTab_1_SubTabsInformation_repeater_6_fila_repeaterSelect_1_field']")));
                        areaClasifi.selectByValue(bean.getCLASIFIAREA());
                        Thread.sleep(1000);
                    }

                    if (bean.getCONTRATO() != null) {
                        Thread.sleep(1000);
                        Select contrato = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_thirdInformation_panelRol_templateContainer_rolTempForm_templateBasicThird_tabPanel_repeaterTab_1_SubTabsInformation_repeater_7_fila_repeaterSelect_1_field']")));
                        contrato.selectByValue(bean.getCONTRATO());
                        // otro.click();
                        Thread.sleep(1000);
                    }

                    if (bean.getCONVENIO() != null) {
                        Thread.sleep(1000);
                        Select convenio = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_thirdInformation_panelRol_templateContainer_rolTempForm_templateBasicThird_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_1_fila_repeaterSelect_1_field']")));
                        convenio.selectByValue(bean.getCONVENIO());
                        // otro.click();
                        Thread.sleep(1000);

                    }

                    jse.executeScript("window.scrollBy(0,500)", "");


                    break;

                case "Casa de Repuestos":

                    if (bean.getTIPOCOMPROBANTE() != null) {
                        Thread.sleep(1000);
                        Select tComprobante = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_thirdInformation_panelRol_templateContainer_rolTempForm_templateBasicThird_tabPanel_repeaterTab_1_SubTabsInformation_repeater_2_fila_repeaterSelect_1_field']")));
                        tComprobante.selectByValue(bean.getTIPOCOMPROBANTE());
                        // otro.click();
                        Thread.sleep(1000);
                    }

                    if (bean.getTIPOPROVEEDOR() != null) {
                        Thread.sleep(1000);
                        Select tProveedor = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_thirdInformation_panelRol_templateContainer_rolTempForm_templateBasicThird_tabPanel_repeaterTab_1_SubTabsInformation_repeater_3_fila_repeaterSelect_1_field']")));
                        tProveedor.selectByValue(bean.getTIPOPROVEEDOR());
                        // otro.click();
                        Thread.sleep(1000);
                    }



                    jse.executeScript("window.scrollBy(0,1000)", "");

                    if (bean.getCLASIFIAREA() != null) {
                        Thread.sleep(1000);
                        Select areaClasifi = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_thirdInformation_panelRol_templateContainer_rolTempForm_templateBasicThird_tabPanel_repeaterTab_1_SubTabsInformation_repeater_5_fila_repeaterSelect_1_field']")));
                        areaClasifi.selectByValue(bean.getCLASIFIAREA());
                        Thread.sleep(1000);
                    }

                    if (bean.getCONTRATO() != null) {
                        Thread.sleep(1000);
                        Select contrato = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_thirdInformation_panelRol_templateContainer_rolTempForm_templateBasicThird_tabPanel_repeaterTab_1_SubTabsInformation_repeater_6_fila_repeaterSelect_1_field']")));
                        contrato.selectByValue(bean.getCONTRATO());
                        // otro.click();
                        Thread.sleep(1000);
                    }

                    if (bean.getCONVENIO() != null) {
                        Thread.sleep(1000);
                        Select convenio = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_thirdInformation_panelRol_templateContainer_rolTempForm_templateBasicThird_tabPanel_repeaterTab_1_SubTabsInformation_repeater_7_fila_repeaterSelect_1_field']")));
                        convenio.selectByValue(bean.getCONVENIO());
                        // otro.click();
                        Thread.sleep(1000);

                    }

                    jse.executeScript("window.scrollBy(0,500)", "");


                    break;

                case "Clinica":

                    if (bean.getTIPOCOMPROBANTE() != null) {
                        Thread.sleep(1000);
                        Select tComprobante = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_thirdInformation_panelRol_templateContainer_rolTempForm_templateBasicThird_tabPanel_repeaterTab_1_SubTabsInformation_repeater_2_fila_repeaterSelect_1_field']")));
                        tComprobante.selectByValue(bean.getTIPOCOMPROBANTE());
                        // otro.click();
                        Thread.sleep(1000);
                    }

                    if (bean.getTIPOPROVEEDOR() != null) {
                        Thread.sleep(1000);
                        Select tProveedor = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_thirdInformation_panelRol_templateContainer_rolTempForm_templateBasicThird_tabPanel_repeaterTab_1_SubTabsInformation_repeater_3_fila_repeaterSelect_1_field']")));
                        tProveedor.selectByValue(bean.getTIPOPROVEEDOR());
                        // otro.click();
                        Thread.sleep(1000);
                    }



                    jse.executeScript("window.scrollBy(0,1000)", "");

                    if (bean.getCLASIFIAREA() != null) {
                        Thread.sleep(1000);
                        Select areaClasifi = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_thirdInformation_panelRol_templateContainer_rolTempForm_templateBasicThird_tabPanel_repeaterTab_1_SubTabsInformation_repeater_5_fila_repeaterSelect_1_field']")));
                        areaClasifi.selectByValue(bean.getCLASIFIAREA());
                        Thread.sleep(1000);
                    }

                    if (bean.getCONTRATO() != null) {
                        Thread.sleep(1000);
                        Select contrato = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_thirdInformation_panelRol_templateContainer_rolTempForm_templateBasicThird_tabPanel_repeaterTab_1_SubTabsInformation_repeater_6_fila_repeaterSelect_1_field']")));
                        contrato.selectByValue(bean.getCONTRATO());
                        // otro.click();
                        Thread.sleep(1000);
                    }

                    if (bean.getCONVENIO() != null) {
                        Thread.sleep(1000);
                        Select convenio = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_thirdInformation_panelRol_templateContainer_rolTempForm_templateBasicThird_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_1_fila_repeaterSelect_1_field']")));
                        convenio.selectByValue(bean.getCONVENIO());
                        // otro.click();
                        Thread.sleep(1000);

                    }

                    jse.executeScript("window.scrollBy(0,500)", "");


                    break;

                case "Comprador de Salvamento":

                    if (bean.getTIPOCOMPROBANTE() != null) {
                        Thread.sleep(1000);
                        Select tComprobante = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_thirdInformation_panelRol_templateContainer_rolTempForm_templateBasicThird_tabPanel_repeaterTab_1_SubTabsInformation_repeater_2_fila_repeaterSelect_1_field']")));
                        tComprobante.selectByValue(bean.getTIPOCOMPROBANTE());
                        // otro.click();
                        Thread.sleep(1000);
                    }

                    if (bean.getTIPOPROVEEDOR() != null) {
                        Thread.sleep(1000);
                        Select tProveedor = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_thirdInformation_panelRol_templateContainer_rolTempForm_templateBasicThird_tabPanel_repeaterTab_1_SubTabsInformation_repeater_3_fila_repeaterSelect_1_field']")));
                        tProveedor.selectByValue(bean.getTIPOPROVEEDOR());
                        // otro.click();
                        Thread.sleep(1000);
                    }



                    jse.executeScript("window.scrollBy(0,1000)", "");

                    if (bean.getCLASIFIAREA() != null) {
                        Thread.sleep(1000);
                        Select areaClasifi = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_thirdInformation_panelRol_templateContainer_rolTempForm_templateBasicThird_tabPanel_repeaterTab_1_SubTabsInformation_repeater_4_fila_repeaterSelect_1_field']")));
                        areaClasifi.selectByValue(bean.getCLASIFIAREA());
                        Thread.sleep(1000);
                    }

                    if (bean.getCONTRATO() != null) {
                        Thread.sleep(1000);
                        Select contrato = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_thirdInformation_panelRol_templateContainer_rolTempForm_templateBasicThird_tabPanel_repeaterTab_1_SubTabsInformation_repeater_5_fila_repeaterSelect_1_field']")));
                        contrato.selectByValue(bean.getCONTRATO());
                        // otro.click();
                        Thread.sleep(1000);
                    }

                    if (bean.getCONVENIO() != null) {
                        Thread.sleep(1000);
                        Select convenio = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_thirdInformation_panelRol_templateContainer_rolTempForm_templateBasicThird_tabPanel_repeaterTab_1_SubTabsInformation_repeater_6_fila_repeaterSelect_1_field']")));
                        convenio.selectByValue(bean.getCONVENIO());
                        // otro.click();
                        Thread.sleep(1000);

                    }

                    jse.executeScript("window.scrollBy(0,500)", "");


                    break;

                case "Enfermera":
                    if (bean.getTIPOCOMPROBANTE() != null) {
                        Thread.sleep(1000);
                        Select tComprobante = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_thirdInformation_panelRol_templateContainer_rolTempForm_templateBasicThird_tabPanel_repeaterTab_1_SubTabsInformation_repeater_4_fila_repeaterSelect_1_field']")));
                        tComprobante.selectByValue(bean.getTIPOCOMPROBANTE());
                        // otro.click();
                        Thread.sleep(1000);
                    }

                    if (bean.getTIPOPROVEEDOR() != null) {
                        Thread.sleep(1000);
                        Select tProveedor = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_thirdInformation_panelRol_templateContainer_rolTempForm_templateBasicThird_tabPanel_repeaterTab_1_SubTabsInformation_repeater_5_fila_repeaterSelect_1_field']")));
                        tProveedor.selectByValue(bean.getTIPOPROVEEDOR());
                        // otro.click();
                        Thread.sleep(1000);
                    }



                    jse.executeScript("window.scrollBy(0,1000)", "");

                    if (bean.getCLASIFIAREA() != null) {
                        Thread.sleep(1000);
                        Select areaClasifi = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_thirdInformation_panelRol_templateContainer_rolTempForm_templateBasicThird_tabPanel_repeaterTab_1_SubTabsInformation_repeater_6_fila_repeaterSelect_1_field']")));
                        areaClasifi.selectByValue(bean.getCLASIFIAREA());
                        Thread.sleep(1000);
                    }

                    if (bean.getCONTRATO() != null) {
                        Thread.sleep(1000);
                        Select contrato = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_thirdInformation_panelRol_templateContainer_rolTempForm_templateBasicThird_tabPanel_repeaterTab_1_SubTabsInformation_repeater_7_fila_repeaterSelect_1_field']")));
                        contrato.selectByValue(bean.getCONTRATO());
                        // otro.click();
                        Thread.sleep(1000);
                    }

                    if (bean.getCONVENIO() != null) {
                        Thread.sleep(1000);
                        Select convenio = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_thirdInformation_panelRol_templateContainer_rolTempForm_templateBasicThird_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_1_fila_repeaterSelect_1_field']")));
                        convenio.selectByValue(bean.getCONVENIO());
                        // otro.click();
                        Thread.sleep(1000);

                    }

                    jse.executeScript("window.scrollBy(0,500)", "");


                    break;

                case "Farmacia":
                    if (bean.getTIPOCOMPROBANTE() != null) {
                        Thread.sleep(1000);
                        Select tComprobante = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_thirdInformation_panelRol_templateContainer_rolTempForm_templateBasicThird_tabPanel_repeaterTab_1_SubTabsInformation_repeater_3_fila_repeaterSelect_1_field']")));
                        tComprobante.selectByValue(bean.getTIPOCOMPROBANTE());
                        // otro.click();
                        Thread.sleep(1000);
                    }

                    if (bean.getTIPOPROVEEDOR() != null) {
                        Thread.sleep(1000);
                        Select tProveedor = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_thirdInformation_panelRol_templateContainer_rolTempForm_templateBasicThird_tabPanel_repeaterTab_1_SubTabsInformation_repeater_4_fila_repeaterSelect_1_field']")));
                        tProveedor.selectByValue(bean.getTIPOPROVEEDOR());
                        // otro.click();
                        Thread.sleep(1000);
                    }



                    jse.executeScript("window.scrollBy(0,1000)", "");

                    if (bean.getCLASIFIAREA() != null) {
                        Thread.sleep(1000);
                        Select areaClasifi = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_thirdInformation_panelRol_templateContainer_rolTempForm_templateBasicThird_tabPanel_repeaterTab_1_SubTabsInformation_repeater_5_fila_repeaterSelect_1_field']")));
                        areaClasifi.selectByValue(bean.getCLASIFIAREA());
                        Thread.sleep(1000);
                    }

                    if (bean.getCONTRATO() != null) {
                        Thread.sleep(1000);
                        Select contrato = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_thirdInformation_panelRol_templateContainer_rolTempForm_templateBasicThird_tabPanel_repeaterTab_1_SubTabsInformation_repeater_6_fila_repeaterSelect_1_field']")));
                        contrato.selectByValue(bean.getCONTRATO());
                        // otro.click();
                        Thread.sleep(1000);
                    }

                    if (bean.getCONVENIO() != null) {
                        Thread.sleep(1000);
                        Select convenio = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_thirdInformation_panelRol_templateContainer_rolTempForm_templateBasicThird_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_1_fila_repeaterSelect_1_field']")));
                        convenio.selectByValue(bean.getCONVENIO());
                        // otro.click();
                        Thread.sleep(1000);

                    }

                    jse.executeScript("window.scrollBy(0,500)", "");


                    break;

                case "Fisioterapista":
                    if (bean.getTIPOCOMPROBANTE() != null) {
                        Thread.sleep(1000);
                        Select tComprobante = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_thirdInformation_panelRol_templateContainer_rolTempForm_templateBasicThird_tabPanel_repeaterTab_1_SubTabsInformation_repeater_4_fila_repeaterSelect_1_field']")));
                        tComprobante.selectByValue(bean.getTIPOCOMPROBANTE());
                        // otro.click();
                        Thread.sleep(1000);
                    }

                    if (bean.getTIPOPROVEEDOR() != null) {
                        Thread.sleep(1000);
                        Select tProveedor = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_thirdInformation_panelRol_templateContainer_rolTempForm_templateBasicThird_tabPanel_repeaterTab_1_SubTabsInformation_repeater_5_fila_repeaterSelect_1_field']")));
                        tProveedor.selectByValue(bean.getTIPOPROVEEDOR());
                        // otro.click();
                        Thread.sleep(1000);
                    }



                    jse.executeScript("window.scrollBy(0,1000)", "");

                    if (bean.getCLASIFIAREA() != null) {
                        Thread.sleep(1000);
                        Select areaClasifi = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_thirdInformation_panelRol_templateContainer_rolTempForm_templateBasicThird_tabPanel_repeaterTab_1_SubTabsInformation_repeater_6_fila_repeaterSelect_1_field']")));
                        areaClasifi.selectByValue(bean.getCLASIFIAREA());
                        Thread.sleep(1000);
                    }

                    if (bean.getCONTRATO() != null) {
                        Thread.sleep(1000);
                        Select contrato = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_thirdInformation_panelRol_templateContainer_rolTempForm_templateBasicThird_tabPanel_repeaterTab_1_SubTabsInformation_repeater_7_fila_repeaterSelect_1_field']")));
                        contrato.selectByValue(bean.getCONTRATO());
                        // otro.click();
                        Thread.sleep(1000);
                    }

                    if (bean.getCONVENIO() != null) {
                        Thread.sleep(1000);
                        Select convenio = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_thirdInformation_panelRol_templateContainer_rolTempForm_templateBasicThird_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_1_fila_repeaterSelect_1_field']")));
                        convenio.selectByValue(bean.getCONVENIO());
                        // otro.click();
                        Thread.sleep(1000);

                    }

                    jse.executeScript("window.scrollBy(0,500)", "");


                    break;

                case "Afianzado":

                    System.out.println("Afianzado");

                    break;

                case "Garante":


                    System.out.println("Garante");


                    break;
                case "Hospital":
                    if (bean.getTIPOCOMPROBANTE() != null) {
                        Thread.sleep(1000);
                        Select tComprobante = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_thirdInformation_panelRol_templateContainer_rolTempForm_templateBasicThird_tabPanel_repeaterTab_1_SubTabsInformation_repeater_3_fila_repeaterSelect_1_field']")));
                        tComprobante.selectByValue(bean.getTIPOCOMPROBANTE());
                        // otro.click();
                        Thread.sleep(1000);
                    }

                    if (bean.getTIPOPROVEEDOR() != null) {
                        Thread.sleep(1000);
                        Select tProveedor = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_thirdInformation_panelRol_templateContainer_rolTempForm_templateBasicThird_tabPanel_repeaterTab_1_SubTabsInformation_repeater_4_fila_repeaterSelect_1_field']")));
                        tProveedor.selectByValue(bean.getTIPOPROVEEDOR());
                        // otro.click();
                        Thread.sleep(1000);
                    }



                    jse.executeScript("window.scrollBy(0,1000)", "");

                    if (bean.getCLASIFIAREA() != null) {
                        Thread.sleep(1000);
                        Select areaClasifi = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_thirdInformation_panelRol_templateContainer_rolTempForm_templateBasicThird_tabPanel_repeaterTab_1_SubTabsInformation_repeater_5_fila_repeaterSelect_1_field']")));
                        areaClasifi.selectByValue(bean.getCLASIFIAREA());
                        Thread.sleep(1000);
                    }

                    if (bean.getCONTRATO() != null) {
                        Thread.sleep(1000);
                        Select contrato = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_thirdInformation_panelRol_templateContainer_rolTempForm_templateBasicThird_tabPanel_repeaterTab_1_SubTabsInformation_repeater_6_fila_repeaterSelect_1_field']")));
                        contrato.selectByValue(bean.getCONTRATO());
                        // otro.click();
                        Thread.sleep(1000);
                    }

                    if (bean.getCONVENIO() != null) {
                        Thread.sleep(1000);
                        Select convenio = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_thirdInformation_panelRol_templateContainer_rolTempForm_templateBasicThird_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_1_fila_repeaterSelect_1_field']")));
                        convenio.selectByValue(bean.getCONVENIO());
                        // otro.click();
                        Thread.sleep(1000);

                    }

                    jse.executeScript("window.scrollBy(0,500)", "");


                    break;
                case "Ingeniero":
                    if (bean.getTIPOCOMPROBANTE() != null) {
                        Thread.sleep(1000);
                        Select tComprobante = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_thirdInformation_panelRol_templateContainer_rolTempForm_templateBasicThird_tabPanel_repeaterTab_1_SubTabsInformation_repeater_2_fila_repeaterSelect_1_field']")));
                        tComprobante.selectByValue(bean.getTIPOCOMPROBANTE());
                        // otro.click();
                        Thread.sleep(1000);
                    }

                    if (bean.getTIPOPROVEEDOR() != null) {
                        Thread.sleep(1000);
                        Select tProveedor = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_thirdInformation_panelRol_templateContainer_rolTempForm_templateBasicThird_tabPanel_repeaterTab_1_SubTabsInformation_repeater_3_fila_repeaterSelect_1_field']")));
                        tProveedor.selectByValue(bean.getTIPOPROVEEDOR());
                        // otro.click();
                        Thread.sleep(1000);
                    }



                    jse.executeScript("window.scrollBy(0,1000)", "");

                    if (bean.getCLASIFIAREA() != null) {
                        Thread.sleep(1000);
                        Select areaClasifi = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_thirdInformation_panelRol_templateContainer_rolTempForm_templateBasicThird_tabPanel_repeaterTab_1_SubTabsInformation_repeater_5_fila_repeaterSelect_1_field']")));
                        areaClasifi.selectByValue(bean.getCLASIFIAREA());
                        Thread.sleep(1000);
                    }

                    if (bean.getCONTRATO() != null) {
                        Thread.sleep(1000);
                        Select contrato = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_thirdInformation_panelRol_templateContainer_rolTempForm_templateBasicThird_tabPanel_repeaterTab_1_SubTabsInformation_repeater_6_fila_repeaterSelect_1_field']")));
                        contrato.selectByValue(bean.getCONTRATO());
                        // otro.click();
                        Thread.sleep(1000);
                    }

                    if (bean.getCONVENIO() != null) {
                        Thread.sleep(1000);
                        Select convenio = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_thirdInformation_panelRol_templateContainer_rolTempForm_templateBasicThird_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_1_fila_repeaterSelect_1_field']")));
                        convenio.selectByValue(bean.getCONVENIO());
                        // otro.click();
                        Thread.sleep(1000);

                    }

                    jse.executeScript("window.scrollBy(0,500)", "");





                    break;

                case "Inspector":
                    if (bean.getTIPOCOMPROBANTE() != null) {
                        Thread.sleep(1000);
                        Select tComprobante = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_thirdInformation_panelRol_templateContainer_rolTempForm_templateBasicThird_tabPanel_repeaterTab_1_SubTabsInformation_repeater_2_fila_repeaterSelect_1_field']")));
                        tComprobante.selectByValue(bean.getTIPOCOMPROBANTE());
                        // otro.click();
                        Thread.sleep(1000);
                    }

                    if (bean.getTIPOPROVEEDOR() != null) {
                        Thread.sleep(1000);
                        Select tProveedor = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_thirdInformation_panelRol_templateContainer_rolTempForm_templateBasicThird_tabPanel_repeaterTab_1_SubTabsInformation_repeater_3_fila_repeaterSelect_1_field']")));
                        tProveedor.selectByValue(bean.getTIPOPROVEEDOR());
                        // otro.click();
                        Thread.sleep(1000);
                    }



                    jse.executeScript("window.scrollBy(0,1000)", "");

                    if (bean.getCLASIFIAREA() != null) {
                        Thread.sleep(1000);
                        Select areaClasifi = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_thirdInformation_panelRol_templateContainer_rolTempForm_templateBasicThird_tabPanel_repeaterTab_1_SubTabsInformation_repeater_5_fila_repeaterSelect_1_field']")));
                        areaClasifi.selectByValue(bean.getCLASIFIAREA());
                        Thread.sleep(1000);
                    }

                    if (bean.getCONTRATO() != null) {
                        Thread.sleep(1000);
                        Select contrato = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_thirdInformation_panelRol_templateContainer_rolTempForm_templateBasicThird_tabPanel_repeaterTab_1_SubTabsInformation_repeater_6_fila_repeaterSelect_1_field']")));
                        contrato.selectByValue(bean.getCONTRATO());
                        // otro.click();
                        Thread.sleep(1000);
                    }

                    if (bean.getCONVENIO() != null) {
                        Thread.sleep(1000);
                        Select convenio = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_thirdInformation_panelRol_templateContainer_rolTempForm_templateBasicThird_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_1_fila_repeaterSelect_1_field']")));
                        convenio.selectByValue(bean.getCONVENIO());
                        // otro.click();
                        Thread.sleep(1000);

                    }

                    jse.executeScript("window.scrollBy(0,500)", "");



                    break;

                case "Institución Financiera":
                    if (bean.getTIPOCOMPROBANTE() != null) {
                        Thread.sleep(1000);
                        Select tComprobante = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_thirdInformation_panelRol_templateContainer_rolTempForm_templateBasicThird_tabPanel_repeaterTab_1_SubTabsInformation_repeater_2_fila_repeaterSelect_1_field']")));
                        tComprobante.selectByValue(bean.getTIPOCOMPROBANTE());
                        // otro.click();
                        Thread.sleep(1000);
                    }

                    if (bean.getTIPOPROVEEDOR() != null) {
                        Thread.sleep(1000);
                        Select tProveedor = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_thirdInformation_panelRol_templateContainer_rolTempForm_templateBasicThird_tabPanel_repeaterTab_1_SubTabsInformation_repeater_3_fila_repeaterSelect_1_field']")));
                        tProveedor.selectByValue(bean.getTIPOPROVEEDOR());
                        // otro.click();
                        Thread.sleep(1000);
                    }



                    jse.executeScript("window.scrollBy(0,1000)", "");

                    if (bean.getCLASIFIAREA() != null) {
                        Thread.sleep(1000);
                        Select areaClasifi = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_thirdInformation_panelRol_templateContainer_rolTempForm_templateBasicThird_tabPanel_repeaterTab_1_SubTabsInformation_repeater_5_fila_repeaterSelect_1_field']")));
                        areaClasifi.selectByValue(bean.getCLASIFIAREA());
                        Thread.sleep(1000);
                    }

                    if (bean.getCONTRATO() != null) {
                        Thread.sleep(1000);
                        Select contrato = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_thirdInformation_panelRol_templateContainer_rolTempForm_templateBasicThird_tabPanel_repeaterTab_1_SubTabsInformation_repeater_6_fila_repeaterSelect_1_field']")));
                        contrato.selectByValue(bean.getCONTRATO());
                        // otro.click();
                        Thread.sleep(1000);
                    }

                    if (bean.getCONVENIO() != null) {
                        Thread.sleep(1000);
                        Select convenio = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_thirdInformation_panelRol_templateContainer_rolTempForm_templateBasicThird_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_1_fila_repeaterSelect_1_field']")));
                        convenio.selectByValue(bean.getCONVENIO());
                        // otro.click();
                        Thread.sleep(1000);

                    }

                    jse.executeScript("window.scrollBy(0,500)", "");



                    break;

                case "Investigador Privado":
                    if (bean.getTIPOCOMPROBANTE() != null) {
                        Thread.sleep(1000);
                        Select tComprobante = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_thirdInformation_panelRol_templateContainer_rolTempForm_templateBasicThird_tabPanel_repeaterTab_1_SubTabsInformation_repeater_2_fila_repeaterSelect_1_field']")));
                        tComprobante.selectByValue(bean.getTIPOCOMPROBANTE());
                        // otro.click();
                        Thread.sleep(1000);
                    }

                    if (bean.getTIPOPROVEEDOR() != null) {
                        Thread.sleep(1000);
                        Select tProveedor = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_thirdInformation_panelRol_templateContainer_rolTempForm_templateBasicThird_tabPanel_repeaterTab_1_SubTabsInformation_repeater_3_fila_repeaterSelect_1_field']")));
                        tProveedor.selectByValue(bean.getTIPOPROVEEDOR());
                        // otro.click();
                        Thread.sleep(1000);
                    }



                    jse.executeScript("window.scrollBy(0,1000)", "");

                    if (bean.getCLASIFIAREA() != null) {
                        Thread.sleep(1000);
                        Select areaClasifi = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_thirdInformation_panelRol_templateContainer_rolTempForm_templateBasicThird_tabPanel_repeaterTab_1_SubTabsInformation_repeater_5_fila_repeaterSelect_1_field']")));
                        areaClasifi.selectByValue(bean.getCLASIFIAREA());
                        Thread.sleep(1000);
                    }

                    if (bean.getCONTRATO() != null) {
                        Thread.sleep(1000);
                        Select contrato = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_thirdInformation_panelRol_templateContainer_rolTempForm_templateBasicThird_tabPanel_repeaterTab_1_SubTabsInformation_repeater_6_fila_repeaterSelect_1_field']")));
                        contrato.selectByValue(bean.getCONTRATO());
                        // otro.click();
                        Thread.sleep(1000);
                    }

                    if (bean.getCONVENIO() != null) {
                        Thread.sleep(1000);
                        Select convenio = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_thirdInformation_panelRol_templateContainer_rolTempForm_templateBasicThird_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_1_fila_repeaterSelect_1_field']")));
                        convenio.selectByValue(bean.getCONVENIO());
                        // otro.click();
                        Thread.sleep(1000);

                    }

                    jse.executeScript("window.scrollBy(0,500)", "");



                    break;

                case "Laboratorio":
                    if (bean.getTIPOCOMPROBANTE() != null) {
                        Thread.sleep(1000);
                        Select tComprobante = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_thirdInformation_panelRol_templateContainer_rolTempForm_templateBasicThird_tabPanel_repeaterTab_1_SubTabsInformation_repeater_4_fila_repeaterSelect_1_field']")));
                        tComprobante.selectByValue(bean.getTIPOCOMPROBANTE());
                        // otro.click();
                        Thread.sleep(1000);
                    }

                    if (bean.getTIPOPROVEEDOR() != null) {
                        Thread.sleep(1000);
                        Select tProveedor = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_thirdInformation_panelRol_templateContainer_rolTempForm_templateBasicThird_tabPanel_repeaterTab_1_SubTabsInformation_repeater_5_fila_repeaterSelect_1_field']")));
                        tProveedor.selectByValue(bean.getTIPOPROVEEDOR());
                        // otro.click();
                        Thread.sleep(1000);
                    }



                    jse.executeScript("window.scrollBy(0,1000)", "");

                    if (bean.getCLASIFIAREA() != null) {
                        Thread.sleep(1000);
                        Select areaClasifi = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_thirdInformation_panelRol_templateContainer_rolTempForm_templateBasicThird_tabPanel_repeaterTab_1_SubTabsInformation_repeater_6_fila_repeaterSelect_1_field']")));
                        areaClasifi.selectByValue(bean.getCLASIFIAREA());
                        Thread.sleep(1000);
                    }

                    if (bean.getCONTRATO() != null) {
                        Thread.sleep(1000);
                        Select contrato = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_thirdInformation_panelRol_templateContainer_rolTempForm_templateBasicThird_tabPanel_repeaterTab_1_SubTabsInformation_repeater_7_fila_repeaterSelect_1_field']")));
                        contrato.selectByValue(bean.getCONTRATO());
                        // otro.click();
                        Thread.sleep(1000);
                    }

                    if (bean.getCONVENIO() != null) {
                        Thread.sleep(1000);
                        Select convenio = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_thirdInformation_panelRol_templateContainer_rolTempForm_templateBasicThird_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_1_fila_repeaterSelect_1_field']")));
                        convenio.selectByValue(bean.getCONVENIO());
                        // otro.click();
                        Thread.sleep(1000);

                    }

                    jse.executeScript("window.scrollBy(0,500)", "");



                    break;
                case "Medico":
                    if (bean.getTIPOCOMPROBANTE() != null) {
                        Thread.sleep(1000);
                        Select tComprobante = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_thirdInformation_panelRol_templateContainer_rolTempForm_templateBasicThird_tabPanel_repeaterTab_1_SubTabsInformation_repeater_4_fila_repeaterSelect_1_field']")));
                        tComprobante.selectByValue(bean.getTIPOCOMPROBANTE());
                        // otro.click();
                        Thread.sleep(1000);
                    }

                    if (bean.getTIPOPROVEEDOR() != null) {
                        Thread.sleep(1000);
                        Select tProveedor = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_thirdInformation_panelRol_templateContainer_rolTempForm_templateBasicThird_tabPanel_repeaterTab_1_SubTabsInformation_repeater_5_fila_repeaterSelect_1_field']")));
                        tProveedor.selectByValue(bean.getTIPOPROVEEDOR());
                        // otro.click();
                        Thread.sleep(1000);
                    }



                    jse.executeScript("window.scrollBy(0,1000)", "");

                    if (bean.getCLASIFIAREA() != null) {
                        Thread.sleep(1000);
                        Select areaClasifi = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_thirdInformation_panelRol_templateContainer_rolTempForm_templateBasicThird_tabPanel_repeaterTab_1_SubTabsInformation_repeater_6_fila_repeaterSelect_1_field']")));
                        areaClasifi.selectByValue(bean.getCLASIFIAREA());
                        Thread.sleep(1000);
                    }

                    if (bean.getCONTRATO() != null) {
                        Thread.sleep(1000);
                        Select contrato = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_thirdInformation_panelRol_templateContainer_rolTempForm_templateBasicThird_tabPanel_repeaterTab_1_SubTabsInformation_repeater_7_fila_repeaterSelect_1_field']")));
                        contrato.selectByValue(bean.getCONTRATO());
                        // otro.click();
                        Thread.sleep(1000);
                    }

                    if (bean.getCONVENIO() != null) {
                        Thread.sleep(1000);
                        Select convenio = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_thirdInformation_panelRol_templateContainer_rolTempForm_templateBasicThird_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_1_fila_repeaterSelect_1_field']")));
                        convenio.selectByValue(bean.getCONVENIO());
                        // otro.click();
                        Thread.sleep(1000);

                    }

                    jse.executeScript("window.scrollBy(0,500)", "");



                    break;
                case "Perito":
                    if (bean.getTIPOCOMPROBANTE() != null) {
                        Thread.sleep(1000);
                        Select tComprobante = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_thirdInformation_panelRol_templateContainer_rolTempForm_templateBasicThird_tabPanel_repeaterTab_1_SubTabsInformation_repeater_2_fila_repeaterSelect_1_field']")));
                        tComprobante.selectByValue(bean.getTIPOCOMPROBANTE());
                        // otro.click();
                        Thread.sleep(1000);
                    }

                    if (bean.getTIPOPROVEEDOR() != null) {
                        Thread.sleep(1000);
                        Select tProveedor = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_thirdInformation_panelRol_templateContainer_rolTempForm_templateBasicThird_tabPanel_repeaterTab_1_SubTabsInformation_repeater_3_fila_repeaterSelect_1_field']")));
                        tProveedor.selectByValue(bean.getTIPOPROVEEDOR());
                        // otro.click();
                        Thread.sleep(1000);
                    }



                    jse.executeScript("window.scrollBy(0,1000)", "");

                    if (bean.getCLASIFIAREA() != null) {
                        Thread.sleep(1000);
                        Select areaClasifi = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_thirdInformation_panelRol_templateContainer_rolTempForm_templateBasicThird_tabPanel_repeaterTab_1_SubTabsInformation_repeater_5_fila_repeaterSelect_1_field']")));
                        areaClasifi.selectByValue(bean.getCLASIFIAREA());
                        Thread.sleep(1000);
                    }

                    if (bean.getCONTRATO() != null) {
                        Thread.sleep(1000);
                        Select contrato = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_thirdInformation_panelRol_templateContainer_rolTempForm_templateBasicThird_tabPanel_repeaterTab_1_SubTabsInformation_repeater_6_fila_repeaterSelect_1_field']")));
                        contrato.selectByValue(bean.getCONTRATO());
                        // otro.click();
                        Thread.sleep(1000);
                    }

                    if (bean.getCONVENIO() != null) {
                        Thread.sleep(1000);
                        Select convenio = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_thirdInformation_panelRol_templateContainer_rolTempForm_templateBasicThird_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_1_fila_repeaterSelect_1_field']")));
                        convenio.selectByValue(bean.getCONVENIO());
                        // otro.click();
                        Thread.sleep(1000);

                    }

                    jse.executeScript("window.scrollBy(0,500)", "");



                    break;
                case "Psicologo":
                    if (bean.getTIPOCOMPROBANTE() != null) {
                        Thread.sleep(1000);
                        Select tComprobante = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_thirdInformation_panelRol_templateContainer_rolTempForm_templateBasicThird_tabPanel_repeaterTab_1_SubTabsInformation_repeater_2_fila_repeaterSelect_1_field']")));
                        tComprobante.selectByValue(bean.getTIPOCOMPROBANTE());
                        // otro.click();
                        Thread.sleep(1000);
                    }

                    if (bean.getTIPOPROVEEDOR() != null) {
                        Thread.sleep(1000);
                        Select tProveedor = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_thirdInformation_panelRol_templateContainer_rolTempForm_templateBasicThird_tabPanel_repeaterTab_1_SubTabsInformation_repeater_3_fila_repeaterSelect_1_field']")));
                        tProveedor.selectByValue(bean.getTIPOPROVEEDOR());
                        // otro.click();
                        Thread.sleep(1000);
                    }



                    jse.executeScript("window.scrollBy(0,1000)", "");

                    if (bean.getCLASIFIAREA() != null) {
                        Thread.sleep(1000);
                        Select areaClasifi = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_thirdInformation_panelRol_templateContainer_rolTempForm_templateBasicThird_tabPanel_repeaterTab_1_SubTabsInformation_repeater_4_fila_repeaterSelect_1_field']")));
                        areaClasifi.selectByValue(bean.getCLASIFIAREA());
                        Thread.sleep(1000);
                    }

                    if (bean.getCONTRATO() != null) {
                        Thread.sleep(1000);
                        Select contrato = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_thirdInformation_panelRol_templateContainer_rolTempForm_templateBasicThird_tabPanel_repeaterTab_1_SubTabsInformation_repeater_5_fila_repeaterSelect_1_field']")));
                        contrato.selectByValue(bean.getCONTRATO());
                        // otro.click();
                        Thread.sleep(1000);
                    }

                    if (bean.getCONVENIO() != null) {
                        Thread.sleep(1000);
                        Select convenio = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_thirdInformation_panelRol_templateContainer_rolTempForm_templateBasicThird_tabPanel_repeaterTab_1_SubTabsInformation_repeater_6_fila_repeaterSelect_1_field']")));
                        convenio.selectByValue(bean.getCONVENIO());
                        // otro.click();
                        Thread.sleep(1000);

                    }

                    jse.executeScript("window.scrollBy(0,500)", "");



                    break;
                case "Reasegurador":
                    System.out.println("Reasegurador");


                    break;
                case "Subastador":
                    if (bean.getTIPOCOMPROBANTE() != null) {
                        Thread.sleep(1000);
                        Select tComprobante = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_thirdInformation_panelRol_templateContainer_rolTempForm_templateBasicThird_tabPanel_repeaterTab_1_SubTabsInformation_repeater_2_fila_repeaterSelect_1_field']")));
                        tComprobante.selectByValue(bean.getTIPOCOMPROBANTE());
                        // otro.click();
                        Thread.sleep(1000);
                    }

                    if (bean.getTIPOPROVEEDOR() != null) {
                        Thread.sleep(1000);
                        Select tProveedor = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_thirdInformation_panelRol_templateContainer_rolTempForm_templateBasicThird_tabPanel_repeaterTab_1_SubTabsInformation_repeater_3_fila_repeaterSelect_1_field']")));
                        tProveedor.selectByValue(bean.getTIPOPROVEEDOR());
                        // otro.click();
                        Thread.sleep(1000);
                    }



                    jse.executeScript("window.scrollBy(0,1000)", "");

                    if (bean.getCLASIFIAREA() != null) {
                        Thread.sleep(1000);
                        Select areaClasifi = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_thirdInformation_panelRol_templateContainer_rolTempForm_templateBasicThird_tabPanel_repeaterTab_1_SubTabsInformation_repeater_4_fila_repeaterSelect_1_field']")));
                        areaClasifi.selectByValue(bean.getCLASIFIAREA());
                        Thread.sleep(1000);
                    }

                    if (bean.getCONTRATO() != null) {
                        Thread.sleep(1000);
                        Select contrato = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_thirdInformation_panelRol_templateContainer_rolTempForm_templateBasicThird_tabPanel_repeaterTab_1_SubTabsInformation_repeater_5_fila_repeaterSelect_1_field']")));
                        contrato.selectByValue(bean.getCONTRATO());
                        // otro.click();
                        Thread.sleep(1000);
                    }

                    if (bean.getCONVENIO() != null) {
                        Thread.sleep(1000);
                        Select convenio = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_thirdInformation_panelRol_templateContainer_rolTempForm_templateBasicThird_tabPanel_repeaterTab_1_SubTabsInformation_repeater_6_fila_repeaterSelect_1_field']")));
                        convenio.selectByValue(bean.getCONVENIO());
                        // otro.click();
                        Thread.sleep(1000);

                    }

                    jse.executeScript("window.scrollBy(0,500)", "");



                    break;
                case "Beneficiario":

                     System.out.println("Beneficiario");
                    if (bean.getTIPOPAGO() != null) {
                        Thread.sleep(1000);
                        Select tPago = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_thirdInformation_panelRol_templateContainer_rolTempForm_templateBasicThird_tabPanel_repeaterTab_2_SubTabsInformation_repeater_1_fila_repeaterSelect_1_field']")));
                        tPago.selectByValue(bean.getTIPOPAGO());
                        Thread.sleep(1000);

                    }


                    break;
                case "Terapista":
                    if (bean.getTIPOCOMPROBANTE() != null) {
                        Thread.sleep(1000);
                        Select tComprobante = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_thirdInformation_panelRol_templateContainer_rolTempForm_templateBasicThird_tabPanel_repeaterTab_1_SubTabsInformation_repeater_4_fila_repeaterSelect_1_field']")));
                        tComprobante.selectByValue(bean.getTIPOCOMPROBANTE());
                        // otro.click();
                        Thread.sleep(1000);
                    }

                    if (bean.getTIPOPROVEEDOR() != null) {
                        Thread.sleep(1000);
                        Select tProveedor = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_thirdInformation_panelRol_templateContainer_rolTempForm_templateBasicThird_tabPanel_repeaterTab_1_SubTabsInformation_repeater_5_fila_repeaterSelect_1_field']")));
                        tProveedor.selectByValue(bean.getTIPOPROVEEDOR());
                        // otro.click();
                        Thread.sleep(1000);
                    }



                    jse.executeScript("window.scrollBy(0,1000)", "");

                    if (bean.getCLASIFIAREA() != null) {
                        Thread.sleep(1000);
                        Select areaClasifi = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_thirdInformation_panelRol_templateContainer_rolTempForm_templateBasicThird_tabPanel_repeaterTab_1_SubTabsInformation_repeater_6_fila_repeaterSelect_1_field']")));
                        areaClasifi.selectByValue(bean.getCLASIFIAREA());
                        Thread.sleep(1000);
                    }

                    if (bean.getCONTRATO() != null) {
                        Thread.sleep(1000);
                        Select contrato = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_thirdInformation_panelRol_templateContainer_rolTempForm_templateBasicThird_tabPanel_repeaterTab_1_SubTabsInformation_repeater_7_fila_repeaterSelect_1_field']")));
                        contrato.selectByValue(bean.getCONTRATO());
                        // otro.click();
                        Thread.sleep(1000);
                    }

                    if (bean.getCONVENIO() != null) {
                        Thread.sleep(1000);
                        Select convenio = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_thirdInformation_panelRol_templateContainer_rolTempForm_templateBasicThird_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_1_fila_repeaterSelect_1_field']")));
                        convenio.selectByValue(bean.getCONVENIO());
                        // otro.click();
                        Thread.sleep(1000);

                    }

                    jse.executeScript("window.scrollBy(0,500)", "");



                    break;
                case "Contragarante":

                    System.out.println("Contragarante");


                    break;
                case "Vendedor":
                    if (bean.getTIPOPAGO() != null) {
                        Thread.sleep(1000);
                        Select tPago = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_thirdInformation_panelRol_templateContainer_rolTempForm_templateBasicThird_tabPanel_repeaterTab_2_SubTabsInformation_repeater_1_fila_repeaterSelect_1_field']")));
                        tPago.selectByValue(bean.getTIPOPAGO());
                        Thread.sleep(1000);

                    }


                    break;
                case "Broker":
                    if (bean.getTIPOPAGO() != null) {
                        Thread.sleep(1000);
                        Select tPago = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_thirdInformation_panelRol_templateContainer_rolTempForm_templateBasicThird_tabPanel_repeaterTab_2_SubTabsInformation_repeater_1_fila_repeaterSelect_1_field']")));
                        tPago.selectByValue(bean.getTIPOPAGO());
                        Thread.sleep(1000);

                    }


                    break;
                case "Cesionario":
                    if (bean.getTIPOPAGO() != null) {
                        Thread.sleep(1000);
                        Select tPago = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_thirdInformation_panelRol_templateContainer_rolTempForm_templateBasicThird_tabPanel_repeaterTab_2_SubTabsInformation_repeater_1_fila_repeaterSelect_1_field']")));
                        tPago.selectByValue(bean.getTIPOPAGO());
                        Thread.sleep(1000);

                    }

                    break;

            }


            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot3, nombreAutomatizacion, folderName);
            Thread.sleep(1000);
          //  jse.executeScript("window.scrollBy(0,500)", "");
            driver.findElement(By.xpath("//*[@id=\"campos_obligatoriosPan\"]/h1/div")).click();
            WebElement guardar = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_panelRol_templateContainer_rolTempForm_saveButton']"));
            guardar.click();
            Thread.sleep(4000);



        } catch (Exception e) {
            e.printStackTrace();
            log.error("Test Case - " + nombreAutomatizacion + " - " + e);
        }



    }



}
