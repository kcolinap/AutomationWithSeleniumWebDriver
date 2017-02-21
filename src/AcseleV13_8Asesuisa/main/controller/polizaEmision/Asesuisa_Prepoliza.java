package AcseleV13_8Asesuisa.main.controller.Asesuisa_Terceros;

import AcseleV13_8Asesuisa.beans.Asesuisa_PolizasBean;
import metodo.Metodos;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;

/**
 * Created by agil on 21/02/2017.
 */
public class Asesuisa_PrePoliza {

    private final static Logger log = Logger.getLogger(Asesuisa_PrePoliza.class);

    public void AdministracionPropuestaPoliza(Metodos a, WebDriver driver, Asesuisa_PolizasBean bean, String nombreAutomatizacion, int i, String folderName, int numScreenShoot) {

        try {
            Select productoSelect = new Select(driver.findElement(By.xpath("//select[@wicketpath='CreatePolicy_createPolicyForm_productsComboBox']")));
            productoSelect.selectByValue(bean.getProducto());
            Thread.sleep(2000);

            /*if(polizaBean instanceof ImpresionDocumentosNivelPolizaBean){
                System.out.println("Impresora : -->>" + ((ImpresionDocumentosNivelPolizaBean) polizaBean).getImpresora());
            }*/

            Select vigenciaSelect = new Select(driver.findElement(By.xpath("//select[@wicketpath='CreatePolicy_createPolicyForm_validitiesComboBox']")));
            vigenciaSelect.selectByValue(bean.getVigencia());
            Thread.sleep(2000);

            WebElement fechaDes = driver.findElement(By.xpath("//input[@wicketpath='CreatePolicy_createPolicyForm_initialDate']"));
            fechaDes.sendKeys(bean.getFechaDesde());
            Thread.sleep(2000);

            if (bean.getFechaHasta() != null) {
                WebElement fechaHas = driver.findElement(By.xpath("//input[@wicketpath='CreatePolicy_createPolicyForm_finalDate']"));
                fechaHas.sendKeys(bean.getFechaHasta());
            }

            Thread.sleep(2000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion, folderName); //screenshot2
            Toolkit.getDefaultToolkit().beep();
            Thread.sleep(1000);

            WebElement btnCrear = driver.findElement(By.xpath("//input[@wicketpath='CreatePolicy_createPolicyForm_CreateQuoteButton']"));
            btnCrear.click();

            a.waitSearchWicket(driver, "Espere Administracion Porpuesta de Poliza");

        } catch (Exception e) {
            e.printStackTrace();
            log.error("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }

    public void EvAplicar(Metodos a, WebDriver driver, Asesuisa_PolizasBean bean, String nombreAutomatizacion, int i, String folderName, int numScreenShoot){
        try {

            Thread.sleep(3000);
            Boolean eventoAplicarExiste = driver.findElements(By.xpath("//select[@wicketpath='modalWindowForm_EventSection_content_events_repeaterSelect_1_field']")).size() > 0;
            if (eventoAplicarExiste){
                Select eventoAplicarSelect = new Select(driver.findElement(By.xpath("//select[@wicketpath='modalWindowForm_EventSection_content_events_repeaterSelect_1_field']")));
                eventoAplicarSelect.selectByValue(bean.getEventoAplicar()); // Emitir
                Thread.sleep(2000);
            }

            if (bean.getFechaMovimiento() != null){
                WebElement fechaMovimiento = driver.findElement(By.xpath("//input[@wicketpath='modalWindowForm_EventSection_content_Form_templateContainer_repeaterPanel_1_fila_fieldDate']"));
                fechaMovimiento.clear();
                fechaMovimiento.sendKeys(bean.getFechaMovimiento());
                Thread.sleep(1000);
            }
            /*if (interPolizaBean.getFechaEfectivaAplicacionEvento() != null){
                WebElement fechaEfecAplicEvent = driver.findElement(By.xpath("//input[@wicketpath='modalWindowForm_EventSection_content_Form_templateContainer_repeaterPanel_2_fila_fieldDate']"));
                fechaEfecAplicEvent.sendKeys(interPolizaBean.getFechaEfectivaAplicacionEvento());
                Thread.sleep(1000);
            }*/


            a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion, folderName); //screenshot2
            Toolkit.getDefaultToolkit().beep();
            Thread.sleep(1000);

            WebElement btnContinuar = driver.findElement(By.xpath("//input[@wicketpath='modalWindowForm_EventSection_content_Form_continueButton']"));
            btnContinuar.click();

            a.waitSearchWicket(driver, "Espere Evento a Aplicar");

        }catch (Exception e) {
            e.printStackTrace();
            log.error("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }
}
