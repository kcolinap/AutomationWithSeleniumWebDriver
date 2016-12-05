package AcseleV13_8_Interseguros.main.controller;

import AcseleV13_8_Interseguros.beans.Inter_PolizaEmisionVariasURBean;
import AcseleV13_8_Interseguros.main.controller.Interseguros_Menu.Interseguros_MenuOperaciones;
import AcseleV13_8_Interseguros.main.controller.PolizaEmision.*;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * Created by agil on 04/12/2016.
 */
public class Inter_PolizaEmisionVariasUR {


    private final static Logger log = Logger.getLogger(Inter_TercerosCrear.class);

    public String nombreAutomatizacion = "Inter Poliza Emision Varios OA";

    public void testLink(Inter_PolizaEmisionVariasURBean interPolizaEmisionVariasURBean, int i) throws IOException, InterruptedException {

        try {

            // Instanciando clases
            Interseguros_Metodos a = new Interseguros_Metodos();
            Interseguros_MenuOperaciones intersegurosMenuOperaciones = new Interseguros_MenuOperaciones();
            Inter_PrePoliza interPrePoliza = new Inter_PrePoliza();
            Inter_InformacionGeneralPoliza interInformacionGeneralPoliza = new Inter_InformacionGeneralPoliza();
            Inter_Contratante interContratante = new Inter_Contratante();
            Inter_UnidadesRiesgo interUnidadesRiesgo = new Inter_UnidadesRiesgo();
            Inter_ObjetosAsegurados interObjetosAsegurados = new Inter_ObjetosAsegurados();
            Inter_Asegurado interAsegurado = new Inter_Asegurado();
            Inter_Beneficiario interBeneficiario = new Inter_Beneficiario();
            Inter_Calcular interCalcular = new Inter_Calcular();
            Inter_Validar interValidar = new Inter_Validar();

            WebDriver driver = a.entrarPagina();
            a.IniciarSesion(driver, nombreAutomatizacion, i);
            a.ValidandoSesion(driver, nombreAutomatizacion, i);
            Thread.sleep(5000);


            //Entrando en Menu
            intersegurosMenuOperaciones.OpePol_Crear(driver, nombreAutomatizacion, 2, i);

            Thread.sleep(2000);
            a.cambiarVentana(driver);
            Thread.sleep(2000);

            /** Crear Poliza */

            Thread.sleep(3000);
            interPrePoliza.AdministracionPropuestaPoliza(a, driver, interPolizaEmisionVariasURBean, nombreAutomatizacion, i, 3);
            Thread.sleep(2000);
            interPrePoliza.EvAplicar(a, driver, interPolizaEmisionVariasURBean, nombreAutomatizacion, i, 4);
            Thread.sleep(2000);
            /*if (interPolizaEmisionVariasURBean.getProducto().equals("Inteligo")) {
                interInformacionGeneralPoliza.InformacionGeneralInteligo(a, driver, interPolizaEmisionVariasURBean, nombreAutomatizacion, i, 5);
                Thread.sleep(2000);
                interContratante.AgregarContratante(a, driver, interPolizaEmisionVariasURBean, nombreAutomatizacion, i, 6, 7);
                Thread.sleep(2000);
                interUnidadesRiesgo.UnidadesRiesgo1(a, driver, interPolizaEmisionVariasURBean, nombreAutomatizacion, i, 8);
                Thread.sleep(2000);
                interObjetosAsegurados.ObjetoAsegurado1_Inteligo(a, driver, interPolizaEmisionVariasURBean, nombreAutomatizacion, i, 9);
                Thread.sleep(2000);
                interAsegurado.AgregarAsegurado1(a, driver, interPolizaEmisionVariasURBean, nombreAutomatizacion, i, 10, 11);
                Thread.sleep(2000);
                interBeneficiario.AgregarBeneficiario1(a, driver, interPolizaEmisionVariasURBean, nombreAutomatizacion, i, 12, 13);
                Thread.sleep(2000);
                interObjetosAsegurados.ObjetoAsegurado2_Inteligo(a, driver, interPolizaEmisionVariasURBean, nombreAutomatizacion, i, 14);
                Thread.sleep(2000);
                interAsegurado.AgregarAsegurado2(a, driver, interPolizaEmisionVariasURBean, nombreAutomatizacion, i, 15, 16);
                Thread.sleep(2000);
                interBeneficiario.AgregarBeneficiario2(a, driver, interPolizaEmisionVariasURBean, nombreAutomatizacion, i, 17, 18);
                Thread.sleep(2000);
                interCalcular.Calcular(a, driver, interPolizaEmisionVariasURBean, nombreAutomatizacion, i, 19, 20);
                Thread.sleep(2000);
                interValidar.ValidarEmisionPoliza(driver, nombreAutomatizacion);
            }
            else*/ if (interPolizaEmisionVariasURBean.getProducto().equals("DotalSimple")){
                interInformacionGeneralPoliza.InformacionGeneralDotalSimple(a, driver, interPolizaEmisionVariasURBean, nombreAutomatizacion, i, 5, 6, 7);
                Thread.sleep(2000);
                interContratante.AgregarContratante(a, driver, interPolizaEmisionVariasURBean, nombreAutomatizacion, i, 8, 9);
                Thread.sleep(2000);
                interUnidadesRiesgo.UnidadesRiesgo1DotalSimple(a, driver, interPolizaEmisionVariasURBean, nombreAutomatizacion, i, 10);
                Thread.sleep(2000);
                interObjetosAsegurados.ObjetoAsegurado1_DotalSimple(a, driver, interPolizaEmisionVariasURBean, nombreAutomatizacion, i, 11, 12, 13);
                Thread.sleep(2000);
                interAsegurado.AgregarAsegurado1_DotalSimple(a, driver, interPolizaEmisionVariasURBean, nombreAutomatizacion, i, 14, 15);
                Thread.sleep(2000);
                interUnidadesRiesgo.UnidadesRiesgo2DotalSimple(a, driver, interPolizaEmisionVariasURBean, nombreAutomatizacion, i, 10);
                Thread.sleep(2000);
                interObjetosAsegurados.ObjetoAsegurado2_DotalSimple(a, driver, interPolizaEmisionVariasURBean, nombreAutomatizacion, i, 16, 17, 18, 19);
                Thread.sleep(2000);
                interAsegurado.AgregarAsegurado2_DotalSimple(a, driver, interPolizaEmisionVariasURBean, nombreAutomatizacion, i, 20, 21);
                Thread.sleep(2000);
                interCalcular.Calcular(a, driver, interPolizaEmisionVariasURBean, nombreAutomatizacion, i, 22, 23);
                Thread.sleep(2000);
                interValidar.ValidarEmisionPoliza(driver, nombreAutomatizacion);
            }

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
}

