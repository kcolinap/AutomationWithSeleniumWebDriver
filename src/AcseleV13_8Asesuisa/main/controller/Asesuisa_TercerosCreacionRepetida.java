package AcseleV13_8Asesuisa.main.controller;

import AcseleV13_8Asesuisa.beans.Asesuisa_TercerosCreacionRepetidaBean;
import AcseleV13_8Asesuisa.main.controller.Asesuisa_Menu.Asesuisa_MenuMantenimiento;
import metodo.Metodos;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by agil on 14/04/2017.
 */
public class Asesuisa_TercerosCreacionRepetida {

    private final static Logger log = Logger.getLogger(Asesuisa_TercerosCreacionRepetida.class);

    public String nombreAutomatizacion = "Asesuisa Terceros Creacion Repetida";
    private WebDriver driver;

    public void testLink(Asesuisa_TercerosCreacionRepetidaBean bean, int i, String folderName){

        try {

            // Instanciando clases
            Metodos a = new Metodos();
            Asesuisa_MenuMantenimiento menuMantenimiento = new Asesuisa_MenuMantenimiento();

            driver = a.entrarPagina(a.UrlAsesuisa());
            a.IniciarSesion(driver, nombreAutomatizacion, i, folderName);
            a.ValidandoSesion(driver, nombreAutomatizacion, i, folderName);
            Thread.sleep(5000);

            //Entrando en Menu
            menuMantenimiento.MantTerc_IngresarTercero(driver, nombreAutomatizacion, 2, i, folderName);

            Thread.sleep(2000);
            a.cambiarVentana(driver);
            Thread.sleep(2000);

            /** Buscar Poliza */

            CrearTercero(bean, a, i, folderName, 3, 4, 5, 6, 7, 8);
            Thread.sleep(3000);


            //driver.quit();

        } catch (Exception e) {
            e.printStackTrace();
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
            if (driver != null){
              //  driver.quit();
            }
        }
    }

    public void CrearTercero(Asesuisa_TercerosCreacionRepetidaBean bean, Metodos a, int i, String folderName, int numScreenShoot, int numScreenShoot2, int numScreenShoot3, int numScreenShoot4,
                             int numScreenShoot5, int numScreenShoot6){

        what: try {
            //WebElement prueba = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_2_fila_field']"));

            JavascriptExecutor jse = (JavascriptExecutor)driver;

            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion, folderName);
            Thread.sleep(1000);

            if (bean.getTipoTercero() != null){
                Select tipoTercero = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_ThirdInformation_thirdPartyTypes']")));
                tipoTercero.selectByValue(bean.getTipoTercero());
                Thread.sleep(1000);
            }

            WebElement otro = driver.findElement(By.xpath("//div[@wicketpath='ThirdInformationContent_ThirdInformation_ThirdInformationLabel']"));

            // Benefeciario Asegurado AP
            if (bean.getAseguradoAp() != null){
                Select aseguradoAp = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_ThirdInformation_templateContainer_formThirdBasic_DataTemplate_repeaterPanel1_1_fila_repeaterSelect_1_field']")));
                aseguradoAp.selectByValue(bean.getAseguradoAp());
                Thread.sleep(1000);
                otro.click();
                Thread.sleep(1000);
            }

            // Primer nombre
            if (bean.getPrimerNombre() != null){
                WebElement nombre1 = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_ThirdInformation_templateContainer_formThirdBasic_DataTemplate_repeaterPanel2_1_fila_field']"));
                nombre1.sendKeys(bean.getPrimerNombre());
                otro.click();
                Thread.sleep(1000);
            }

            // Segundo nombre
            if (bean.getSegundoNombre() != null){
                WebElement nombre2 = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_ThirdInformation_templateContainer_formThirdBasic_DataTemplate_repeaterPanel1_2_fila_field']"));
                nombre2.sendKeys(bean.getSegundoNombre());
                otro.click();
                Thread.sleep(1000);
            }

            // Primer apellido
            if (bean.getPrimerApellido() != null){
                WebElement apellido1 = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_ThirdInformation_templateContainer_formThirdBasic_DataTemplate_repeaterPanel2_2_fila_field']"));
                apellido1.sendKeys(bean.getPrimerApellido());
                otro.click();
                Thread.sleep(1000);
            }

            // Segundo apellido
            if (bean.getSegundoApellido() != null){
                WebElement apellido2 = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_ThirdInformation_templateContainer_formThirdBasic_DataTemplate_repeaterPanel1_3_fila_field']"));
                apellido2.sendKeys(bean.getSegundoApellido());
                otro.click();
                Thread.sleep(1000);
            }

            // Pais origen
            if (bean.getPaisOrigen() != null){
                Select paisOrigen = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_ThirdInformation_templateContainer_formThirdBasic_DataTemplate_repeaterPanel2_3_fila_repeaterSelect_1_field']")));
                paisOrigen.selectByValue(bean.getPaisOrigen());
                otro.click();
                Thread.sleep(1000);
            }

            // Nacionalidad
            if (bean.getNacionalidad() != null){
                Select nacionalidad = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_ThirdInformation_templateContainer_formThirdBasic_DataTemplate_repeaterPanel1_4_fila_repeaterSelect_1_field']")));
                nacionalidad.selectByValue(bean.getNacionalidad());
                otro.click();
                Thread.sleep(1000);
            }

            // Fecha de nacimiento
            if (bean.getFechaNacimiento() != null){
                WebElement fechaNacimiento = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_ThirdInformation_templateContainer_formThirdBasic_DataTemplate_repeaterPanel2_4_fila_fieldDate']"));
                fechaNacimiento.sendKeys(bean.getFechaNacimiento());
                otro.click();
                Thread.sleep(1000);
            }

            // DUI
            if (bean.getNumeroDUI() != null){
                WebElement dui = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_ThirdInformation_templateContainer_formThirdBasic_DataTemplate_repeaterPanel2_5_fila_field']"));
                dui.sendKeys(bean.getNumeroDUI());
                otro.click();
                Thread.sleep(1000);
            }

            // NIT
            if (bean.getNumeroNIT() != null){
                WebElement nit = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_ThirdInformation_templateContainer_formThirdBasic_DataTemplate_repeaterPanel1_5_fila_field']"));
                nit.sendKeys(bean.getNumeroNIT());
                otro.click();
                Thread.sleep(1000);
            }

            // Tipo documento identificacion
            if (bean.getTipoDocumentoIdentificacion() != null){
                Select tipoDocId = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_ThirdInformation_templateContainer_formThirdBasic_DataTemplate_repeaterPanel2_6_fila_repeaterSelect_1_field']")));
                tipoDocId.selectByValue(bean.getTipoDocumentoIdentificacion());
                Thread.sleep(1000);
                otro.click();
                Thread.sleep(1000);
            }

            // Numero documento identificacion
            if (bean.getNumeroDocumentoIdentificacion() != null){
                WebElement numId = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_ThirdInformation_templateContainer_formThirdBasic_DataTemplate_repeaterPanel1_7_fila_field']"));
                numId.sendKeys(bean.getNumeroDocumentoIdentificacion());
                otro.click();
                Thread.sleep(1000);
            }

            // Correo electronico principal
            if (bean.getCorreoElectronicoPrincipal() != null){
                WebElement emailPrincipal = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_ThirdInformation_templateContainer_formThirdBasic_DataTemplate_repeaterPanel2_8_fila_field']"));
                emailPrincipal.sendKeys(bean.getCorreoElectronicoPrincipal());
                otro.click();
                Thread.sleep(1000);
            }

            // Correo electronico opcional
            if (bean.getCorreoElectronicoOpcional() != null){
                WebElement emailOpcional = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_ThirdInformation_templateContainer_formThirdBasic_DataTemplate_repeaterPanel1_9_fila_field']"));
                emailOpcional.sendKeys(bean.getCorreoElectronicoOpcional());
                otro.click();
                Thread.sleep(1000);
            }

            // ID Facebook
            if (bean.getIdFacebook() != null){
                WebElement idFacebook = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_ThirdInformation_templateContainer_formThirdBasic_DataTemplate_repeaterPanel1_10_fila_field']"));
                idFacebook.sendKeys(bean.getIdFacebook());
                otro.click();
                Thread.sleep(1000);
            }

            // ID Twitter
            if (bean.getIdTwitter() != null){
                WebElement nombre1 = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_ThirdInformation_templateContainer_formThirdBasic_DataTemplate_repeaterPanel2_10_fila_field']"));
                nombre1.sendKeys(bean.getIdTwitter());
                otro.click();
                Thread.sleep(1000);
            }

            // ID Linkedin
            if (bean.getIdLinkedin() != null){
                WebElement nombre1 = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_ThirdInformation_templateContainer_formThirdBasic_DataTemplate_repeaterPanel1_11_fila_field']"));
                nombre1.sendKeys(bean.getIdLinkedin());
                otro.click();
                Thread.sleep(1000);
            }

            // Genero
            if (bean.getGenero() != null){
                Select genero = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_ThirdInformation_templateContainer_formThirdBasic_DataTemplate_repeaterPanel2_11_fila_repeaterSelect_1_field']")));
                genero.selectByValue(bean.getGenero());
                otro.click();
                Thread.sleep(1000);
            }

            // Estado civil
            if (bean.getEstadoCivil() != null){
                Select edoCivil = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_ThirdInformation_templateContainer_formThirdBasic_DataTemplate_repeaterPanel1_12_fila_repeaterSelect_1_field']")));
                edoCivil.selectByValue(bean.getEstadoCivil());
                otro.click();
                Thread.sleep(1000);
            }

            // Numero de hijos
            if (bean.getNumeroHijos() != null){
                Select numHijo = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_ThirdInformation_templateContainer_formThirdBasic_DataTemplate_repeaterPanel2_12_fila_repeaterSelect_1_field']")));
                numHijo.selectByValue(bean.getNumeroHijos());
                otro.click();
                Thread.sleep(1000);
            }

            // Nivel de estudios
            if (bean.getNivelEstudio() != null){
                Select nivelEstudios = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_ThirdInformation_templateContainer_formThirdBasic_DataTemplate_repeaterPanel1_13_fila_repeaterSelect_1_field']")));
                nivelEstudios.selectByValue(bean.getNivelEstudio());
                otro.click();
                Thread.sleep(1000);
            }

            // Ocupacion
            if (bean.getOcupacion() != null){
                Select ocupacion = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_ThirdInformation_templateContainer_formThirdBasic_DataTemplate_repeaterPanel2_13_fila_repeaterSelect_1_field']")));
                ocupacion.selectByValue(bean.getOcupacion());
                otro.click();
                Thread.sleep(1000);
            }

            // Telefono de domicilio
            if (bean.getTlfDomicilio() != null){
                WebElement nombre1 = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_ThirdInformation_templateContainer_formThirdBasic_DataTemplate_repeaterPanel1_14_fila_field']"));
                nombre1.sendKeys(bean.getTlfDomicilio());
                otro.click();
                Thread.sleep(1000);
            }

            // Numero celular
            if (bean.getNumeroCelular() != null){
                WebElement nombre1 = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_ThirdInformation_templateContainer_formThirdBasic_DataTemplate_repeaterPanel2_14_fila_field']"));
                nombre1.sendKeys(bean.getNumeroCelular());
                otro.click();
                Thread.sleep(1000);
            }

            // NRC
            if (bean.getNumeroRegistroContribuyente() != null){
                WebElement nombre1 = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_ThirdInformation_templateContainer_formThirdBasic_DataTemplate_repeaterPanel1_15_fila_field']"));
                nombre1.sendKeys(bean.getNumeroRegistroContribuyente());
                otro.click();
                Thread.sleep(1000);
            }

            // Categoria contribuyente
            if (bean.getCategoriaContribuyente() != null){
                Select categContribuyente = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_ThirdInformation_templateContainer_formThirdBasic_DataTemplate_repeaterPanel2_15_fila_repeaterSelect_1_field']")));
                categContribuyente.selectByValue(bean.getCategoriaContribuyente());
                otro.click();
                Thread.sleep(1000);
            }

            // Actividad economica
            if (bean.getActividadEconomica() != null){
                Select actividadEconomica = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_ThirdInformation_templateContainer_formThirdBasic_DataTemplate_repeaterPanel1_16_fila_repeaterSelect_1_field']")));
                actividadEconomica.selectByValue(bean.getActividadEconomica());
                otro.click();
                Thread.sleep(1000);
            }

            // Nivel salarial
            if (bean.getNivelSalarial() != null){
                Select nivelSalarial = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_ThirdInformation_templateContainer_formThirdBasic_DataTemplate_repeaterPanel2_16_fila_repeaterSelect_1_field']")));
                nivelSalarial.selectByValue(bean.getNivelSalarial());
                otro.click();
                Thread.sleep(1000);
            }

            // Tipo empresa
            if (bean.getTipoEmpresa() != null){
                Select tipoEmpresa = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_ThirdInformation_templateContainer_formThirdBasic_DataTemplate_repeaterPanel1_17_fila_repeaterSelect_1_field']")));
                tipoEmpresa.selectByValue(bean.getTipoEmpresa());
                otro.click();
                Thread.sleep(1000);
            }

            // Categoria Empresa
            if (bean.getCategoriaEmpresa() != null){
                Select categoriaEmpresa = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_ThirdInformation_templateContainer_formThirdBasic_DataTemplate_repeaterPanel2_17_fila_repeaterSelect_1_field']")));
                categoriaEmpresa.selectByValue(bean.getCategoriaEmpresa());
                otro.click();
                Thread.sleep(1000);
            }

            // Exento IVA
            if (bean.getExentoIVA() != null){
                Select iva = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_ThirdInformation_templateContainer_formThirdBasic_DataTemplate_repeaterPanel1_18_fila_repeaterSelect_1_field']")));
                iva.selectByValue(bean.getExentoIVA());
                otro.click();
                Thread.sleep(1000);
            }

            // Login
            if (bean.getLogin() != null){
                WebElement nombre1 = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_ThirdInformation_templateContainer_formThirdBasic_DataTemplate_repeaterPanel2_18_fila_field']"));
                nombre1.sendKeys(bean.getLogin());
                otro.click();
                Thread.sleep(1000);
            }

            // Numero Documento Identificacion 2
            if (bean.getNumeroDocumentoIdentificacion2() != null){
                WebElement nombre1 = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_ThirdInformation_templateContainer_formThirdBasic_DataTemplate_repeaterPanel2_19_fila_field']"));
                nombre1.sendKeys(bean.getNumeroDocumentoIdentificacion2());
                otro.click();
                Thread.sleep(1000);
            }

            jse.executeScript("window.scrollBy(0,-5000)", "");

            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot2, nombreAutomatizacion, folderName);
            Thread.sleep(1000);

            jse.executeScript("window.scrollBy(0,600)", "");
            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot3, nombreAutomatizacion, folderName);
            Thread.sleep(1000);



            WebElement btnGuardar = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_ThirdInformation_templateContainer_formThirdBasic_saveButton']"));
            btnGuardar.click();
            a.waitSearchWicket(driver, "Espere, Guardando Tercero");

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

            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot4, nombreAutomatizacion, folderName);
            Thread.sleep(1000);



        } catch (Exception e) {
            e.printStackTrace();
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }
}
