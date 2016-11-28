package AcseleV13_8_Interseguros.main.controller;

import AcseleV13_8_Interseguros.beans.Inter_PolizaEmisionVariosOABean;
import AcseleV13_8_Interseguros.main.controller.Interseguros_Menu.Interseguros_MenuOperaciones;
import AcseleV13_8_Interseguros.main.controller.PolizaEmision.*;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * Created by agil on 22/11/2016.
 */
public class Inter_PolizaEmisionVariosOA {

    private final static Logger log = Logger.getLogger(Inter_TercerosCrear.class);

    public String nombreAutomatizacion = "Inter Poliza Emision Varios OA";

    public void testLink(Inter_PolizaEmisionVariosOABean interPolizaEmisionVariosOABean, int i) throws IOException, InterruptedException {

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
            interPrePoliza.AdministracionPropuestaPoliza(a, driver, interPolizaEmisionVariosOABean, nombreAutomatizacion, i, 3);
            Thread.sleep(2000);
            interPrePoliza.EvAplicar(a, driver, interPolizaEmisionVariosOABean, nombreAutomatizacion, i, 4);
            Thread.sleep(2000);
            interInformacionGeneralPoliza.InformacionGeneral(a, driver, interPolizaEmisionVariosOABean, nombreAutomatizacion, i, 5);
            Thread.sleep(2000);
            interContratante.AgregarContratante(a, driver, interPolizaEmisionVariosOABean, nombreAutomatizacion, i, 6, 7);
            Thread.sleep(2000);
            interUnidadesRiesgo.UnidadesRiesgo1(a, driver, interPolizaEmisionVariosOABean, nombreAutomatizacion, i, 8);
            Thread.sleep(2000);
            interObjetosAsegurados.ObjetoAsegurado1_Inteligo(a, driver, interPolizaEmisionVariosOABean, nombreAutomatizacion, i, 9);
            Thread.sleep(2000);
            interAsegurado.AgregarAsegurado1(a, driver, interPolizaEmisionVariosOABean, nombreAutomatizacion, i, 10, 11);
            Thread.sleep(2000);
            interBeneficiario.AgregarBeneficiario1(a, driver, interPolizaEmisionVariosOABean, nombreAutomatizacion, i, 12, 13);
            Thread.sleep(2000);
            interObjetosAsegurados.ObjetoAsegurado2_Inteligo(a, driver, interPolizaEmisionVariosOABean, nombreAutomatizacion, i, 14);
            Thread.sleep(2000);
            interAsegurado.AgregarAsegurado2(a, driver, interPolizaEmisionVariosOABean, nombreAutomatizacion, i, 15, 16);
            Thread.sleep(2000);
            interBeneficiario.AgregarBeneficiario2(a, driver, interPolizaEmisionVariosOABean, nombreAutomatizacion, i, 17, 18);
            Thread.sleep(2000);
            interCalcular.Calcular(a, driver, interPolizaEmisionVariosOABean, nombreAutomatizacion, i, 19, 20);
            Thread.sleep(2000);
            interValidar.ValidarEmisionPoliza(driver, nombreAutomatizacion);

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
