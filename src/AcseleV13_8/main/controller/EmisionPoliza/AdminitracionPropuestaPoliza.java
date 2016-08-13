package AcseleV13_8.main.controller.EmisionPoliza;

import AcseleV13_8.beans.EmisionPolizaBeneficiarioNaturalBean;
import AcseleV13_8.main.controller.Metodos;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;

/**
 * Created by agil on 10/08/2016.
 */
public class AdminitracionPropuestaPoliza {

    private final static Logger log = Logger.getLogger(AdminitracionPropuestaPoliza.class);

    public void AdminPropuestaPoliza(Metodos a, WebDriver driver, EmisionPolizaBeneficiarioNaturalBean emisionPolizaBeneficiarioNaturalBean, String nombreAutomatizacion) {
        try {
            Select productoSelect = new Select(driver.findElement(By.xpath("//select[@wicketpath='CreatePolicy_createPolicyForm_productsComboBox']")));
            productoSelect.selectByValue(emisionPolizaBeneficiarioNaturalBean.getProducto()); //VidaDeudoresAvVillas
            Thread.sleep(2000);

            Select vigenciaSelect = new Select(driver.findElement(By.xpath("//select[@wicketpath='CreatePolicy_createPolicyForm_validitiesComboBox']")));
            vigenciaSelect.selectByValue(emisionPolizaBeneficiarioNaturalBean.getVigencia()); //12= Anual
            Thread.sleep(2000);

            WebElement fechaDes = driver.findElement(By.xpath("//input[@wicketpath='CreatePolicy_createPolicyForm_initialDate']"));
            fechaDes.sendKeys(emisionPolizaBeneficiarioNaturalBean.getFechaDesde()); // 19-07-2016
            Thread.sleep(2000);

            WebElement fechaHas = driver.findElement(By.xpath("//input[@wicketpath='CreatePolicy_createPolicyForm_finalDate']"));
            if (emisionPolizaBeneficiarioNaturalBean.getFechaHasta() != null) {
                fechaHas.sendKeys(emisionPolizaBeneficiarioNaturalBean.getFechaHasta());
            }

            Thread.sleep(2000);
            a.ScreenShot(driver, "screen3", nombreAutomatizacion); //screenshot2
            Toolkit.getDefaultToolkit().beep();
            Thread.sleep(1000);

            WebElement btnCrear = driver.findElement(By.xpath("//input[@wicketpath='CreatePolicy_createPolicyForm_CreateQuoteButton']"));
            btnCrear.click();

        } catch (Exception e) {
            e.printStackTrace();
            //             log.info(e);
            log.info("Test Case 25 - " + nombreAutomatizacion + " - " + e);
        }
    }

    public void EvAplicar(Metodos a, WebDriver driver, EmisionPolizaBeneficiarioNaturalBean emisionPolizaBeneficiarioNaturalBean,
                          String nombreAutomatizacion){
        try {
            Thread.sleep(3000);
            Select eventoAplicarSelect = new Select(driver.findElement(By.xpath("//select[@wicketpath='modalWindowForm_EventSection_content_events_repeaterSelect_1_field']")));

            eventoAplicarSelect.selectByValue(emisionPolizaBeneficiarioNaturalBean.getEventoAplicar()); // Emitir
            Thread.sleep(2000);

            if (emisionPolizaBeneficiarioNaturalBean.getFechaMovimiento() != null){
                WebElement fechaMovimiento = driver.findElement(By.xpath("//input[@wicketpath='modalWindowForm_EventSection_content_Form_templateContainer_repeaterPanel_1_fila_fieldDate']"));
                fechaMovimiento.sendKeys(emisionPolizaBeneficiarioNaturalBean.getFechaMovimiento());
                Thread.sleep(1000);
            }
            if (emisionPolizaBeneficiarioNaturalBean.getFechaEfectivaApliEv() != null){
                WebElement fechaEfecAplicEvent = driver.findElement(By.xpath("//input[@wicketpath='modalWindowForm_EventSection_content_Form_templateContainer_repeaterPanel_2_fila_fieldDate']"));
                fechaEfecAplicEvent.sendKeys(emisionPolizaBeneficiarioNaturalBean.getFechaEfectivaApliEv());
                Thread.sleep(1000);
            }


            a.ScreenShot(driver, "screen4", nombreAutomatizacion); //screenshot2
            Toolkit.getDefaultToolkit().beep();
            Thread.sleep(1000);

            WebElement btnContinuar = driver.findElement(By.xpath("//input[@wicketpath='modalWindowForm_EventSection_content_Form_continueButton']"));
            btnContinuar.click();

        }catch (Exception e){
            e.printStackTrace();
//             log.info(e);
            log.info("Test Case 25 - " + nombreAutomatizacion + " - " + e);
        }
    }
}
