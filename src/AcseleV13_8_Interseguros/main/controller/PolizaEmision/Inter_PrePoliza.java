package AcseleV13_8_Interseguros.main.controller.PolizaEmision;

import AcseleV13_8_Interseguros.beans.Inter_PolizaBean;
import AcseleV13_8_Interseguros.main.controller.Interseguros_Metodos;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * Created by agil on 23/11/2016.
 */
public class Inter_PrePoliza {

    private final static Logger log = Logger.getLogger(Inter_PrePoliza.class);

    public void AdministracionPropuestaPoliza(Interseguros_Metodos a, WebDriver driver, Inter_PolizaBean interPolizaBean, String nombreAutomatizacion, int i, int numScreenShoot) {

        try {
            Select productoSelect = new Select(driver.findElement(By.xpath("//select[@wicketpath='CreatePolicy_createPolicyForm_productsComboBox']")));
            productoSelect.selectByValue(interPolizaBean.getProducto());
            Thread.sleep(2000);

            /*if(polizaBean instanceof ImpresionDocumentosNivelPolizaBean){
                System.out.println("Impresora : -->>" + ((ImpresionDocumentosNivelPolizaBean) polizaBean).getImpresora());
            }*/

            Select vigenciaSelect = new Select(driver.findElement(By.xpath("//select[@wicketpath='CreatePolicy_createPolicyForm_validitiesComboBox']")));
            vigenciaSelect.selectByValue(interPolizaBean.getVigencia());
            Thread.sleep(2000);

            WebElement fechaDes = driver.findElement(By.xpath("//input[@wicketpath='CreatePolicy_createPolicyForm_initialDate']"));
            fechaDes.sendKeys(interPolizaBean.getFechaDesde());
            Thread.sleep(2000);

            WebElement fechaHas = driver.findElement(By.xpath("//input[@wicketpath='CreatePolicy_createPolicyForm_finalDate']"));
            if (interPolizaBean.getFechaHasta() != null) {
                fechaHas.sendKeys(interPolizaBean.getFechaHasta());
            }

            Thread.sleep(2000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion); //screenshot2
            Toolkit.getDefaultToolkit().beep();
            Thread.sleep(1000);

            WebElement btnCrear = driver.findElement(By.xpath("//input[@wicketpath='CreatePolicy_createPolicyForm_CreateQuoteButton']"));
            btnCrear.click();

            a.waitSearchWicket(driver, "Espere Administracion Porpuesta de Poliza");

        } catch (Exception e) {
            e.printStackTrace();
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);
            sw.toString(); // stack trace as a string
            //log.info("Test Case - " + nombreAutomatizacion + " - " + e);
            log.info("Test Case - " + nombreAutomatizacion + " - " + sw.toString());
        }
    }

    public void EvAplicar(Interseguros_Metodos a, WebDriver driver, Inter_PolizaBean interPolizaBean, String nombreAutomatizacion, int i, int numScreenShoot){
        try {

            Thread.sleep(3000);
            Boolean eventoAplicarExiste = driver.findElements(By.xpath("//select[@wicketpath='modalWindowForm_EventSection_content_events_repeaterSelect_1_field']")).size() > 0;
            if (eventoAplicarExiste){
                Select eventoAplicarSelect = new Select(driver.findElement(By.xpath("//select[@wicketpath='modalWindowForm_EventSection_content_events_repeaterSelect_1_field']")));
                eventoAplicarSelect.selectByValue(interPolizaBean.getEventoAplicar()); // Emitir
                Thread.sleep(2000);
            }

            if (interPolizaBean.getFechaMovimiento() != null){
                WebElement fechaMovimiento = driver.findElement(By.xpath("//input[@wicketpath='modalWindowForm_EventSection_content_Form_templateContainer_repeaterPanel_1_fila_fieldDate']"));
                fechaMovimiento.sendKeys(interPolizaBean.getFechaMovimiento());
                Thread.sleep(1000);
            }
            /*if (interPolizaBean.getFechaEfectivaAplicacionEvento() != null){
                WebElement fechaEfecAplicEvent = driver.findElement(By.xpath("//input[@wicketpath='modalWindowForm_EventSection_content_Form_templateContainer_repeaterPanel_2_fila_fieldDate']"));
                fechaEfecAplicEvent.sendKeys(interPolizaBean.getFechaEfectivaAplicacionEvento());
                Thread.sleep(1000);
            }*/


            a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion); //screenshot2
            Toolkit.getDefaultToolkit().beep();
            Thread.sleep(1000);

            WebElement btnContinuar = driver.findElement(By.xpath("//input[@wicketpath='modalWindowForm_EventSection_content_Form_continueButton']"));
            btnContinuar.click();

            a.waitSearchWicket(driver, "Espere Evento a Aplicar");

        }catch (Exception e) {
            //log.info("Test Case - " + nombreAutomatizacion + " - " + e);
            e.printStackTrace();
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);
            sw.toString(); // stack trace as a string
            log.info("Test Case - " + nombreAutomatizacion + " - " + sw.toString());
        }
    }
}
