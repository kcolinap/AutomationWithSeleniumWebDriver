package AcseleV13_8_Interseguros.beans;

import org.apache.log4j.Logger;

/**
 * Created by agil on 22/11/2016.
 */
public class Inter_PolizaBean {

    private final static Logger log = Logger.getLogger(Inter_PolizaBean.class);

    // PrePoliza
    private String producto;
    private String vigencia;
    private String fechaDesde;
    private String fechaHasta;

    private String eventoAplicar;
    private String fechaMovimiento;

    private String planesFinanciamiento;
    private String monedas;
    private String oficina;
    private String numeroPoliza;
    private String fechaEmision;
    private String canalVentaVida;
    private String canalVenta;
    private String frecuenciaPago;
    private String aplicaDescuento;
    private String tipoDocumento;
    private String numeroDocumento;
    private String tipoPago;
    private String fechaEventoAnterior;
    private String fechaProximaGeneracionPrima;
    private String fechaProximaFacturacion;
    private String numeroPlan;
    private String fechaEmisionEnAcsele;
    private String planInteligo;
    private String nivelAgrupamientoReaseguro;
    private String fechaVenta;
    private String claseReaseguro;
    private String numeroCotizacion;
    private String numeroPropuesta;
    private String numeroOperacion;
    private String monedaTransaccion;
    private String montoTransaccion;
    private String monedaDePrima;
    private String montoPrimeraPrima;
    private String fechaCotizacion;
    private String numeroPropuestaAnterior;
    private String CambioNumeroPropuesta;
    private String indicadorDPS;
    private String envioComunicacionesPoliza;
    private String envioComunicacionesEndoso;
    private String prevalizacionViaCobro;
    private String agenteInicialPoliza;
    private String codigoAgenteInicial;
    private String correoAgenteInicial;
    private String codigoAgenciaInicial;
    private String agenteFinalPoliza;
    private String codigoAgenteFinal;
    private String correoAgenteFinal;
    private String codigoAgenciaFinal;
    private String periodoDiasProcedeSuspencionCancelacion;
    private String productosVida;
    private String plan;
    private String fechaProxGenPrimaVi;
    private String polizaCesionada;
    private String loginUsuario;

    private String acuerdos;

    private String contratante1Nombre1;
    private String contratante1Nombre2;
    private String contratante1Apellido1;
    private String contratante1Apellido2;
    private String porcentajeContratante1;

    private String numeroUnidadRiesgo1;
    private String capitalAseguradoCoberturaFallecimiento1;
    private String numeroUnidadRiesgo2;
    private String capitalAseguradoCoberturaFallecimiento2;

    private String numeroObjetoAsegurado1;
    private String nombreCompletoAsegurado1;
    private String nombreCompletoBeneficiario1;
    private String numOACOT;
    private String fechaNacimientoCotizador;
    private String sexoAseguradoCotizador;
    private String cotizadorFumador;
    private String edadActuarialAsegurado;
    private String edadMinimaIngreso;
    private String edadMaximaIngreso;
    private String edadMaximaPermanencia;
    private String informacionBeneficiario1Apellido1;
    private String informacionBeneficiario1Apellido2;
    private String informacionBeneficiario1Nombres;
    private String informacionBeneficiario1FechaNacimiento;
    private String informacionBeneficiario1DocumentoIdentidad;
    private String informacionBeneficiario1Parentesco;
    private String informacionBeneficiario1PorcDistribucion;
    private String informacionBeneficiario2Apellido1;
    private String informacionBeneficiario2Apellido2;
    private String informacionBeneficiario2Nombres;
    private String informacionBeneficiario2FechaNacimiento;
    private String informacionBeneficiario2DocumentoIdentidad;
    private String informacionBeneficiario2Parentesco;
    private String informacionBeneficiario2PorcDistribucion;
    private String informacionBeneficiario3Apellido1;
    private String informacionBeneficiario3Apellido2;
    private String informacionBeneficiario3Nombres;
    private String informacionBeneficiario3FechaNacimiento;
    private String informacionBeneficiario3DocumentoIdentidad;
    private String informacionBeneficiario3Parentesco;
    private String informacionBeneficiario3PorcDistribucion;
    private String informacionBeneficiarioContingente1Apellido1;
    private String informacionBeneficiarioContingente1Apellido2;
    private String informacionBeneficiarioContingente1Nombres;
    private String informacionBeneficiarioContingente1FechaNacimiento;
    private String informacionBeneficiarioContingente1DocumentoIdentidad;
    private String informacionBeneficiarioContingente1Parentesco;
    private String informacionBeneficiarioContingente1PorcDistribucion;
    private String informacionBeneficiarioContingente2Apellido1;
    private String informacionBeneficiarioContingente2Apellido2;
    private String informacionBeneficiarioContingente2Nombres;
    private String informacionBeneficiarioContingente2FechaNacimiento;
    private String informacionBeneficiarioContingente2DocumentoIdentidad;
    private String informacionBeneficiarioContingente2Parentesco;
    private String informacionBeneficiarioContingente2PorcDistribucion;
    private String numeroObjetoAsegurado2;
    private String nombreCompletoAsegurado2;
    private String nombreCompletoBeneficiario2;
    private String numOACOT2;
    private String fechaNacimientoCotizador2;
    private String sexoAseguradoCotizador2;
    private String cotizadorFumador2;
    private String edadActuarialAsegurado2;
    private String edadMinimaIngreso2;
    private String edadMaximaIngreso2;
    private String edadMaximaPermanencia2;
    private String informacion2Beneficiario1Apellido1;
    private String informacion2Beneficiario1Apellido2;
    private String informacion2Beneficiario1Nombres;
    private String informacion2Beneficiario1FechaNacimiento;
    private String informacion2Beneficiario1DocumentoIdentidad;
    private String informacion2Beneficiario1Parentesco;
    private String informacion2Beneficiario1PorcDistribucion;
    private String informacion2Beneficiario2Apellido1;
    private String informacion2Beneficiario2Apellido2;
    private String informacion2Beneficiario2Nombres;
    private String informacion2Beneficiario2FechaNacimiento;
    private String informacion2Beneficiario2DocumentoIdentidad;
    private String informacion2Beneficiario2Parentesco;
    private String informacion2Beneficiario2PorcDistribucion;
    private String informacion2Beneficiario3Apellido1;
    private String informacion2Beneficiario3Apellido2;
    private String informacion2Beneficiario3Nombres;
    private String informacion2Beneficiario3FechaNacimiento;
    private String informacion2Beneficiario3DocumentoIdentidad;
    private String informacion2Beneficiario3Parentesco;
    private String informacion2Beneficiario3PorcDistribucion;
    private String informacion2BeneficiarioContingente1Apellido1;
    private String informacion2BeneficiarioContingente1Apellido2;
    private String informacion2BeneficiarioContingente1Nombres;
    private String informacion2BeneficiarioContingente1FechaNacimiento;
    private String informacion2BeneficiarioContingente1DocumentoIdentidad;
    private String informacion2BeneficiarioContingente1Parentesco;
    private String informacion2BeneficiarioContingente1PorcDistribucion;
    private String informacion2BeneficiarioContingente2Apellido1;
    private String informacion2BeneficiarioContingente2Apellido2;
    private String informacion2BeneficiarioContingente2Nombres;
    private String informacion2BeneficiarioContingente2FechaNacimiento;
    private String informacion2BeneficiarioContingente2DocumentoIdentidad;
    private String informacion2BeneficiarioContingente2Parentesco;
    private String informacion2BeneficiarioContingente2PorcDistribucion;
    private String nuevaCotizacionRecibida;
    private String solicitudAfiliacion;

    private String asegurado1Nombre1;
    private String asegurado1Nombre2;
    private String asegurado1Apellido1;
    private String asegurado1Apellido2;
    private String porcentajeAsegurado1;
    private String asegurado2Nombre1;
    private String asegurado2Nombre2;
    private String asegurado2Apellido1;
    private String asegurado2Apellido2;
    private String porcentajeAsegurado2;
    private String estadoPropuesta;
    private String estadoPropuesta2;

    private String beneficiario1Nombre1;
    private String beneficiario1Nombre2;
    private String beneficiario1Apellido1;
    private String beneficiario1Apellido2;
    private String tipoBeneficiario1;
    private String beneficiarioIrrevocable1;
    private String porcentajeBeneficiario1;
    private String codigoBeneficiario1;
    private String parentescoBeneficiario1;
    private String beneficiario2Nombre1;
    private String beneficiario2Nombre2;
    private String beneficiario2Apellido1;
    private String beneficiario2Apellido2;
    private String tipoBeneficiario2;
    private String beneficiarioIrrevocable2;
    private String porcentajeBeneficiario2;
    private String codigoBeneficiario2;
    private String parentescoBeneficiario2;


    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getVigencia() {
        return vigencia;
    }

    public void setVigencia(String vigencia) {
        this.vigencia = vigencia;
    }

    public String getFechaDesde() {
        return fechaDesde;
    }

    public void setFechaDesde(String fechaDesde) {
        this.fechaDesde = fechaDesde;
    }

    public String getFechaHasta() {
        return fechaHasta;
    }

    public void setFechaHasta(String fechaHasta) {
        this.fechaHasta = fechaHasta;
    }

    public String getEventoAplicar() {
        return eventoAplicar;
    }

    public void setEventoAplicar(String eventoAplicar) {
        this.eventoAplicar = eventoAplicar;
    }

    public String getFechaMovimiento() {
        return fechaMovimiento;
    }

    public void setFechaMovimiento(String fechaMovimiento) {
        this.fechaMovimiento = fechaMovimiento;
    }

    public String getPlanesFinanciamiento() {
        return planesFinanciamiento;
    }

    public void setPlanesFinanciamiento(String planesFinanciamiento) {
        this.planesFinanciamiento = planesFinanciamiento;
    }

    public String getMonedas() {
        return monedas;
    }

    public void setMonedas(String monedas) {
        this.monedas = monedas;
    }

    public String getOficina() {
        return oficina;
    }

    public void setOficina(String oficina) {
        this.oficina = oficina;
    }

    public String getNumeroPoliza() {
        return numeroPoliza;
    }

    public void setNumeroPoliza(String numeroPoliza) {
        this.numeroPoliza = numeroPoliza;
    }

    public String getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(String fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public String getCanalVenta() {
        return canalVenta;
    }

    public void setCanalVenta(String canalVenta) {
        this.canalVenta = canalVenta;
    }

    public String getFrecuenciaPago() {
        return frecuenciaPago;
    }

    public void setFrecuenciaPago(String frecuenciaPago) {
        this.frecuenciaPago = frecuenciaPago;
    }

    public String getFechaEventoAnterior() {
        return fechaEventoAnterior;
    }

    public void setFechaEventoAnterior(String fechaEventoAnterior) {
        this.fechaEventoAnterior = fechaEventoAnterior;
    }

    public String getFechaProximaGeneracionPrima() {
        return fechaProximaGeneracionPrima;
    }

    public void setFechaProximaGeneracionPrima(String fechaProximaGeneracionPrima) {
        this.fechaProximaGeneracionPrima = fechaProximaGeneracionPrima;
    }

    public String getFechaProximaFacturacion() {
        return fechaProximaFacturacion;
    }

    public void setFechaProximaFacturacion(String fechaProximaFacturacion) {
        this.fechaProximaFacturacion = fechaProximaFacturacion;
    }

    public String getNumeroPlan() {
        return numeroPlan;
    }

    public void setNumeroPlan(String numeroPlan) {
        this.numeroPlan = numeroPlan;
    }

    public String getFechaEmisionEnAcsele() {
        return fechaEmisionEnAcsele;
    }

    public void setFechaEmisionEnAcsele(String fechaEmisionEnAcsele) {
        this.fechaEmisionEnAcsele = fechaEmisionEnAcsele;
    }

    public String getPlanInteligo() {
        return planInteligo;
    }

    public void setPlanInteligo(String planInteligo) {
        this.planInteligo = planInteligo;
    }

    public String getNivelAgrupamientoReaseguro() {
        return nivelAgrupamientoReaseguro;
    }

    public void setNivelAgrupamientoReaseguro(String nivelAgrupamientoReaseguro) {
        this.nivelAgrupamientoReaseguro = nivelAgrupamientoReaseguro;
    }

    public String getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(String fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public String getClaseReaseguro() {
        return claseReaseguro;
    }

    public void setClaseReaseguro(String claseReaseguro) {
        this.claseReaseguro = claseReaseguro;
    }

    public String getNumeroCotizacion() {
        return numeroCotizacion;
    }

    public void setNumeroCotizacion(String numeroCotizacion) {
        this.numeroCotizacion = numeroCotizacion;
    }

    public String getNumeroPropuesta() {
        return numeroPropuesta;
    }

    public void setNumeroPropuesta(String numeroPropuesta) {
        this.numeroPropuesta = numeroPropuesta;
    }

    public String getCanalVentaVida() {
        return canalVentaVida;
    }

    public void setCanalVentaVida(String canalVentaVida) {
        this.canalVentaVida = canalVentaVida;
    }

    public String getAplicaDescuento() {
        return aplicaDescuento;
    }

    public void setAplicaDescuento(String aplicaDescuento) {
        this.aplicaDescuento = aplicaDescuento;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(String tipoPago) {
        this.tipoPago = tipoPago;
    }

    public String getNumeroOperacion() {
        return numeroOperacion;
    }

    public void setNumeroOperacion(String numeroOperacion) {
        this.numeroOperacion = numeroOperacion;
    }

    public String getMonedaTransaccion() {
        return monedaTransaccion;
    }

    public void setMonedaTransaccion(String monedaTransaccion) {
        this.monedaTransaccion = monedaTransaccion;
    }

    public String getMontoTransaccion() {
        return montoTransaccion;
    }

    public void setMontoTransaccion(String montoTransaccion) {
        this.montoTransaccion = montoTransaccion;
    }

    public String getMonedaDePrima() {
        return monedaDePrima;
    }

    public void setMonedaDePrima(String monedaDePrima) {
        this.monedaDePrima = monedaDePrima;
    }

    public String getMontoPrimeraPrima() {
        return montoPrimeraPrima;
    }

    public void setMontoPrimeraPrima(String montoPrimeraPrima) {
        this.montoPrimeraPrima = montoPrimeraPrima;
    }

    public String getFechaCotizacion() {
        return fechaCotizacion;
    }

    public void setFechaCotizacion(String fechaCotizacion) {
        this.fechaCotizacion = fechaCotizacion;
    }

    public String getNumeroPropuestaAnterior() {
        return numeroPropuestaAnterior;
    }

    public void setNumeroPropuestaAnterior(String numeroPropuestaAnterior) {
        this.numeroPropuestaAnterior = numeroPropuestaAnterior;
    }

    public String getCambioNumeroPropuesta() {
        return CambioNumeroPropuesta;
    }

    public void setCambioNumeroPropuesta(String cambioNumeroPropuesta) {
        CambioNumeroPropuesta = cambioNumeroPropuesta;
    }

    public String getIndicadorDPS() {
        return indicadorDPS;
    }

    public void setIndicadorDPS(String indicadorDPS) {
        this.indicadorDPS = indicadorDPS;
    }

    public String getEnvioComunicacionesPoliza() {
        return envioComunicacionesPoliza;
    }

    public void setEnvioComunicacionesPoliza(String envioComunicacionesPoliza) {
        this.envioComunicacionesPoliza = envioComunicacionesPoliza;
    }

    public String getEnvioComunicacionesEndoso() {
        return envioComunicacionesEndoso;
    }

    public void setEnvioComunicacionesEndoso(String envioComunicacionesEndoso) {
        this.envioComunicacionesEndoso = envioComunicacionesEndoso;
    }

    public String getPrevalizacionViaCobro() {
        return prevalizacionViaCobro;
    }

    public void setPrevalizacionViaCobro(String prevalizacionViaCobro) {
        this.prevalizacionViaCobro = prevalizacionViaCobro;
    }

    public String getAgenteInicialPoliza() {
        return agenteInicialPoliza;
    }

    public void setAgenteInicialPoliza(String agenteInicialPoliza) {
        this.agenteInicialPoliza = agenteInicialPoliza;
    }

    public String getCodigoAgenteInicial() {
        return codigoAgenteInicial;
    }

    public void setCodigoAgenteInicial(String codigoAgenteInicial) {
        this.codigoAgenteInicial = codigoAgenteInicial;
    }

    public String getCorreoAgenteInicial() {
        return correoAgenteInicial;
    }

    public void setCorreoAgenteInicial(String correoAgenteInicial) {
        this.correoAgenteInicial = correoAgenteInicial;
    }

    public String getCodigoAgenciaInicial() {
        return codigoAgenciaInicial;
    }

    public void setCodigoAgenciaInicial(String codigoAgenciaInicial) {
        this.codigoAgenciaInicial = codigoAgenciaInicial;
    }

    public String getAgenteFinalPoliza() {
        return agenteFinalPoliza;
    }

    public void setAgenteFinalPoliza(String agenteFinalPoliza) {
        this.agenteFinalPoliza = agenteFinalPoliza;
    }

    public String getCodigoAgenteFinal() {
        return codigoAgenteFinal;
    }

    public void setCodigoAgenteFinal(String codigoAgenteFinal) {
        this.codigoAgenteFinal = codigoAgenteFinal;
    }

    public String getCorreoAgenteFinal() {
        return correoAgenteFinal;
    }

    public void setCorreoAgenteFinal(String correoAgenteFinal) {
        this.correoAgenteFinal = correoAgenteFinal;
    }

    public String getCodigoAgenciaFinal() {
        return codigoAgenciaFinal;
    }

    public void setCodigoAgenciaFinal(String codigoAgenciaFinal) {
        this.codigoAgenciaFinal = codigoAgenciaFinal;
    }

    public String getPeriodoDiasProcedeSuspencionCancelacion() {
        return periodoDiasProcedeSuspencionCancelacion;
    }

    public void setPeriodoDiasProcedeSuspencionCancelacion(String periodoDiasProcedeSuspencionCancelacion) {
        this.periodoDiasProcedeSuspencionCancelacion = periodoDiasProcedeSuspencionCancelacion;
    }

    public String getProductosVida() {
        return productosVida;
    }

    public void setProductosVida(String productosVida) {
        this.productosVida = productosVida;
    }

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }

    public String getFechaProxGenPrimaVi() {
        return fechaProxGenPrimaVi;
    }

    public void setFechaProxGenPrimaVi(String fechaProxGenPrimaVi) {
        this.fechaProxGenPrimaVi = fechaProxGenPrimaVi;
    }

    public String getPolizaCesionada() {
        return polizaCesionada;
    }

    public void setPolizaCesionada(String polizaCesionada) {
        this.polizaCesionada = polizaCesionada;
    }

    public String getLoginUsuario() {
        return loginUsuario;
    }

    public void setLoginUsuario(String loginUsuario) {
        this.loginUsuario = loginUsuario;
    }

    public String getAcuerdos() {
        return acuerdos;
    }

    public void setAcuerdos(String acuerdos) {
        this.acuerdos = acuerdos;
    }

    public String getContratante1Nombre1() {
        return contratante1Nombre1;
    }

    public void setContratante1Nombre1(String contratante1Nombre1) {
        this.contratante1Nombre1 = contratante1Nombre1;
    }

    public String getContratante1Nombre2() {
        return contratante1Nombre2;
    }

    public void setContratante1Nombre2(String contratante1Nombre2) {
        this.contratante1Nombre2 = contratante1Nombre2;
    }

    public String getContratante1Apellido1() {
        return contratante1Apellido1;
    }

    public void setContratante1Apellido1(String contratante1Apellido1) {
        this.contratante1Apellido1 = contratante1Apellido1;
    }

    public String getContratante1Apellido2() {
        return contratante1Apellido2;
    }

    public void setContratante1Apellido2(String contratante1Apellido2) {
        this.contratante1Apellido2 = contratante1Apellido2;
    }

    public String getPorcentajeContratante1() {
        return porcentajeContratante1;
    }

    public void setPorcentajeContratante1(String porcentajeContratante1) {
        this.porcentajeContratante1 = porcentajeContratante1;
    }

    public String getNumeroUnidadRiesgo1() {
        return numeroUnidadRiesgo1;
    }

    public String getCapitalAseguradoCoberturaFallecimiento1() {
        return capitalAseguradoCoberturaFallecimiento1;
    }

    public void setCapitalAseguradoCoberturaFallecimiento1(String capitalAseguradoCoberturaFallecimiento1) {
        this.capitalAseguradoCoberturaFallecimiento1 = capitalAseguradoCoberturaFallecimiento1;
    }

    public String getCapitalAseguradoCoberturaFallecimiento2() {
        return capitalAseguradoCoberturaFallecimiento2;
    }

    public void setCapitalAseguradoCoberturaFallecimiento2(String capitalAseguradoCoberturaFallecimiento2) {
        this.capitalAseguradoCoberturaFallecimiento2 = capitalAseguradoCoberturaFallecimiento2;
    }

    public void setNumeroUnidadRiesgo1(String numeroUnidadRiesgo1) {
        this.numeroUnidadRiesgo1 = numeroUnidadRiesgo1;
    }

    public String getNumeroUnidadRiesgo2() {
        return numeroUnidadRiesgo2;
    }

    public void setNumeroUnidadRiesgo2(String numeroUnidadRiesgo2) {
        this.numeroUnidadRiesgo2 = numeroUnidadRiesgo2;
    }

    public String getNumeroObjetoAsegurado1() {
        return numeroObjetoAsegurado1;
    }

    public void setNumeroObjetoAsegurado1(String numeroObjetoAsegurado1) {
        this.numeroObjetoAsegurado1 = numeroObjetoAsegurado1;
    }

    public String getNombreCompletoAsegurado1() {
        return nombreCompletoAsegurado1;
    }

    public void setNombreCompletoAsegurado1(String nombreCompletoAsegurado1) {
        this.nombreCompletoAsegurado1 = nombreCompletoAsegurado1;
    }

    public String getNombreCompletoBeneficiario1() {
        return nombreCompletoBeneficiario1;
    }

    public void setNombreCompletoBeneficiario1(String nombreCompletoBeneficiario1) {
        this.nombreCompletoBeneficiario1 = nombreCompletoBeneficiario1;
    }

    public String getNumeroObjetoAsegurado2() {
        return numeroObjetoAsegurado2;
    }

    public void setNumeroObjetoAsegurado2(String numeroObjetoAsegurado2) {
        this.numeroObjetoAsegurado2 = numeroObjetoAsegurado2;
    }

    public String getNombreCompletoAsegurado2() {
        return nombreCompletoAsegurado2;
    }

    public void setNombreCompletoAsegurado2(String nombreCompletoAsegurado2) {
        this.nombreCompletoAsegurado2 = nombreCompletoAsegurado2;
    }

    public String getNombreCompletoBeneficiario2() {
        return nombreCompletoBeneficiario2;
    }

    public void setNombreCompletoBeneficiario2(String nombreCompletoBeneficiario2) {
        this.nombreCompletoBeneficiario2 = nombreCompletoBeneficiario2;
    }

    public String getAsegurado1Nombre1() {
        return asegurado1Nombre1;
    }

    public void setAsegurado1Nombre1(String asegurado1Nombre1) {
        this.asegurado1Nombre1 = asegurado1Nombre1;
    }

    public String getAsegurado1Nombre2() {
        return asegurado1Nombre2;
    }

    public void setAsegurado1Nombre2(String asegurado1Nombre2) {
        this.asegurado1Nombre2 = asegurado1Nombre2;
    }

    public String getAsegurado1Apellido1() {
        return asegurado1Apellido1;
    }

    public void setAsegurado1Apellido1(String asegurado1Apellido1) {
        this.asegurado1Apellido1 = asegurado1Apellido1;
    }

    public String getAsegurado1Apellido2() {
        return asegurado1Apellido2;
    }

    public void setAsegurado1Apellido2(String asegurado1Apellido2) {
        this.asegurado1Apellido2 = asegurado1Apellido2;
    }

    public String getPorcentajeAsegurado1() {
        return porcentajeAsegurado1;
    }

    public void setPorcentajeAsegurado1(String aorcentajeAsegurado1) {
        this.porcentajeAsegurado1 = aorcentajeAsegurado1;
    }

    public String getAsegurado2Nombre1() {
        return asegurado2Nombre1;
    }

    public void setAsegurado2Nombre1(String asegurado2Nombre1) {
        this.asegurado2Nombre1 = asegurado2Nombre1;
    }

    public String getAsegurado2Nombre2() {
        return asegurado2Nombre2;
    }

    public void setAsegurado2Nombre2(String asegurado2Nombre2) {
        this.asegurado2Nombre2 = asegurado2Nombre2;
    }

    public String getAsegurado2Apellido1() {
        return asegurado2Apellido1;
    }

    public void setAsegurado2Apellido1(String asegurado2Apellido1) {
        this.asegurado2Apellido1 = asegurado2Apellido1;
    }

    public String getAsegurado2Apellido2() {
        return asegurado2Apellido2;
    }

    public void setAsegurado2Apellido2(String asegurado2Apellido2) {
        this.asegurado2Apellido2 = asegurado2Apellido2;
    }

    public String getPorcentajeAsegurado2() {
        return porcentajeAsegurado2;
    }

    public void setPorcentajeAsegurado2(String porcentajeAsegurado2) {
        this.porcentajeAsegurado2 = porcentajeAsegurado2;
    }

    public String getBeneficiario1Nombre1() {
        return beneficiario1Nombre1;
    }

    public void setBeneficiario1Nombre1(String beneficiario1Nombre1) {
        this.beneficiario1Nombre1 = beneficiario1Nombre1;
    }

    public String getBeneficiario1Nombre2() {
        return beneficiario1Nombre2;
    }

    public void setBeneficiario1Nombre2(String beneficiario1Nombre2) {
        this.beneficiario1Nombre2 = beneficiario1Nombre2;
    }

    public String getBeneficiario1Apellido1() {
        return beneficiario1Apellido1;
    }

    public void setBeneficiario1Apellido1(String beneficiario1Apellido1) {
        this.beneficiario1Apellido1 = beneficiario1Apellido1;
    }

    public String getBeneficiario1Apellido2() {
        return beneficiario1Apellido2;
    }

    public void setBeneficiario1Apellido2(String beneficiario1Apellido2) {
        this.beneficiario1Apellido2 = beneficiario1Apellido2;
    }

    public String getTipoBeneficiario1() {
        return tipoBeneficiario1;
    }

    public void setTipoBeneficiario1(String tipoBeneficiario1) {
        this.tipoBeneficiario1 = tipoBeneficiario1;
    }

    public String getBeneficiarioIrrevocable1() {
        return beneficiarioIrrevocable1;
    }

    public void setBeneficiarioIrrevocable1(String beneficiarioIrrevocable1) {
        this.beneficiarioIrrevocable1 = beneficiarioIrrevocable1;
    }

    public String getPorcentajeBeneficiario1() {
        return porcentajeBeneficiario1;
    }

    public void setPorcentajeBeneficiario1(String porcentajeBeneficiario1) {
        this.porcentajeBeneficiario1 = porcentajeBeneficiario1;
    }

    public String getCodigoBeneficiario1() {
        return codigoBeneficiario1;
    }

    public void setCodigoBeneficiario1(String codigoBeneficiario1) {
        this.codigoBeneficiario1 = codigoBeneficiario1;
    }

    public String getParentescoBeneficiario1() {
        return parentescoBeneficiario1;
    }

    public void setParentescoBeneficiario1(String parentescoBeneficiario1) {
        this.parentescoBeneficiario1 = parentescoBeneficiario1;
    }

    public String getBeneficiario2Nombre1() {
        return beneficiario2Nombre1;
    }

    public void setBeneficiario2Nombre1(String beneficiario2Nombre1) {
        this.beneficiario2Nombre1 = beneficiario2Nombre1;
    }

    public String getBeneficiario2Nombre2() {
        return beneficiario2Nombre2;
    }

    public void setBeneficiario2Nombre2(String beneficiario2Nombre2) {
        this.beneficiario2Nombre2 = beneficiario2Nombre2;
    }

    public String getBeneficiario2Apellido1() {
        return beneficiario2Apellido1;
    }

    public void setBeneficiario2Apellido1(String beneficiario2Apellido1) {
        this.beneficiario2Apellido1 = beneficiario2Apellido1;
    }

    public String getBeneficiario2Apellido2() {
        return beneficiario2Apellido2;
    }

    public void setBeneficiario2Apellido2(String beneficiario2Apellido2) {
        this.beneficiario2Apellido2 = beneficiario2Apellido2;
    }

    public String getTipoBeneficiario2() {
        return tipoBeneficiario2;
    }

    public void setTipoBeneficiario2(String tipoBeneficiario2) {
        this.tipoBeneficiario2 = tipoBeneficiario2;
    }

    public String getBeneficiarioIrrevocable2() {
        return beneficiarioIrrevocable2;
    }

    public void setBeneficiarioIrrevocable2(String beneficiarioIrrevocable2) {
        this.beneficiarioIrrevocable2 = beneficiarioIrrevocable2;
    }

    public String getPorcentajeBeneficiario2() {
        return porcentajeBeneficiario2;
    }

    public void setPorcentajeBeneficiario2(String porcentajeBeneficiario2) {
        this.porcentajeBeneficiario2 = porcentajeBeneficiario2;
    }

    public String getCodigoBeneficiario2() {
        return codigoBeneficiario2;
    }

    public void setCodigoBeneficiario2(String codigoBeneficiario2) {
        this.codigoBeneficiario2 = codigoBeneficiario2;
    }

    public String getParentescoBeneficiario2() {
        return parentescoBeneficiario2;
    }

    public void setParentescoBeneficiario2(String parentescoBeneficiario2) {
        this.parentescoBeneficiario2 = parentescoBeneficiario2;
    }

    public String getNumOACOT() {
        return numOACOT;
    }

    public void setNumOACOT(String numOACOT) {
        this.numOACOT = numOACOT;
    }

    public String getFechaNacimientoCotizador() {
        return fechaNacimientoCotizador;
    }

    public void setFechaNacimientoCotizador(String fechaNacimientoCotizador) {
        this.fechaNacimientoCotizador = fechaNacimientoCotizador;
    }

    public String getSexoAseguradoCotizador() {
        return sexoAseguradoCotizador;
    }

    public void setSexoAseguradoCotizador(String sexoAseguradoCotizador) {
        this.sexoAseguradoCotizador = sexoAseguradoCotizador;
    }

    public String getCotizadorFumador() {
        return cotizadorFumador;
    }

    public void setCotizadorFumador(String cotizadorFumador) {
        this.cotizadorFumador = cotizadorFumador;
    }

    public String getEdadActuarialAsegurado() {
        return edadActuarialAsegurado;
    }

    public void setEdadActuarialAsegurado(String edadActuarialAsegurado) {
        this.edadActuarialAsegurado = edadActuarialAsegurado;
    }

    public String getEdadMinimaIngreso() {
        return edadMinimaIngreso;
    }

    public void setEdadMinimaIngreso(String edadMinimaIngreso) {
        this.edadMinimaIngreso = edadMinimaIngreso;
    }

    public String getEdadMaximaIngreso() {
        return edadMaximaIngreso;
    }

    public void setEdadMaximaIngreso(String edadMaximaIngreso) {
        this.edadMaximaIngreso = edadMaximaIngreso;
    }

    public String getEdadMaximaPermanencia() {
        return edadMaximaPermanencia;
    }

    public void setEdadMaximaPermanencia(String edadMaximaPermanencia) {
        this.edadMaximaPermanencia = edadMaximaPermanencia;
    }

    public String getInformacionBeneficiario1Apellido1() {
        return informacionBeneficiario1Apellido1;
    }

    public void setInformacionBeneficiario1Apellido1(String informacionBeneficiario1Apellido1) {
        this.informacionBeneficiario1Apellido1 = informacionBeneficiario1Apellido1;
    }

    public String getInformacionBeneficiario1Apellido2() {
        return informacionBeneficiario1Apellido2;
    }

    public void setInformacionBeneficiario1Apellido2(String informacionBeneficiario1Apellido2) {
        this.informacionBeneficiario1Apellido2 = informacionBeneficiario1Apellido2;
    }

    public String getInformacionBeneficiario1Nombres() {
        return informacionBeneficiario1Nombres;
    }

    public void setInformacionBeneficiario1Nombres(String informacionBeneficiario1Nombres) {
        this.informacionBeneficiario1Nombres = informacionBeneficiario1Nombres;
    }

    public String getInformacionBeneficiario1FechaNacimiento() {
        return informacionBeneficiario1FechaNacimiento;
    }

    public void setInformacionBeneficiario1FechaNacimiento(String informacionBeneficiario1FechaNacimiento) {
        this.informacionBeneficiario1FechaNacimiento = informacionBeneficiario1FechaNacimiento;
    }

    public String getInformacionBeneficiario1DocumentoIdentidad() {
        return informacionBeneficiario1DocumentoIdentidad;
    }

    public void setInformacionBeneficiario1DocumentoIdentidad(String informacionBeneficiario1DocumentoIdentidad) {
        this.informacionBeneficiario1DocumentoIdentidad = informacionBeneficiario1DocumentoIdentidad;
    }

    public String getInformacionBeneficiario1Parentesco() {
        return informacionBeneficiario1Parentesco;
    }

    public void setInformacionBeneficiario1Parentesco(String informacionBeneficiario1Parentesco) {
        this.informacionBeneficiario1Parentesco = informacionBeneficiario1Parentesco;
    }

    public String getInformacionBeneficiario1PorcDistribucion() {
        return informacionBeneficiario1PorcDistribucion;
    }

    public void setInformacionBeneficiario1PorcDistribucion(String informacionBeneficiario1PorcDistribucion) {
        this.informacionBeneficiario1PorcDistribucion = informacionBeneficiario1PorcDistribucion;
    }

    public String getInformacionBeneficiario2Apellido1() {
        return informacionBeneficiario2Apellido1;
    }

    public void setInformacionBeneficiario2Apellido1(String informacionBeneficiario2Apellido1) {
        this.informacionBeneficiario2Apellido1 = informacionBeneficiario2Apellido1;
    }

    public String getInformacionBeneficiario2Apellido2() {
        return informacionBeneficiario2Apellido2;
    }

    public void setInformacionBeneficiario2Apellido2(String informacionBeneficiario2Apellido2) {
        this.informacionBeneficiario2Apellido2 = informacionBeneficiario2Apellido2;
    }

    public String getInformacionBeneficiario2Nombres() {
        return informacionBeneficiario2Nombres;
    }

    public void setInformacionBeneficiario2Nombres(String informacionBeneficiario2Nombres) {
        this.informacionBeneficiario2Nombres = informacionBeneficiario2Nombres;
    }

    public String getInformacionBeneficiario2FechaNacimiento() {
        return informacionBeneficiario2FechaNacimiento;
    }

    public void setInformacionBeneficiario2FechaNacimiento(String informacionBeneficiario2FechaNacimiento) {
        this.informacionBeneficiario2FechaNacimiento = informacionBeneficiario2FechaNacimiento;
    }

    public String getInformacionBeneficiario2DocumentoIdentidad() {
        return informacionBeneficiario2DocumentoIdentidad;
    }

    public void setInformacionBeneficiario2DocumentoIdentidad(String informacionBeneficiario2DocumentoIdentidad) {
        this.informacionBeneficiario2DocumentoIdentidad = informacionBeneficiario2DocumentoIdentidad;
    }

    public String getInformacionBeneficiario2Parentesco() {
        return informacionBeneficiario2Parentesco;
    }

    public void setInformacionBeneficiario2Parentesco(String informacionBeneficiario2Parentesco) {
        this.informacionBeneficiario2Parentesco = informacionBeneficiario2Parentesco;
    }

    public String getInformacionBeneficiario2PorcDistribucion() {
        return informacionBeneficiario2PorcDistribucion;
    }

    public void setInformacionBeneficiario2PorcDistribucion(String informacionBeneficiario2PorcDistribucion) {
        this.informacionBeneficiario2PorcDistribucion = informacionBeneficiario2PorcDistribucion;
    }

    public String getInformacionBeneficiario3Apellido1() {
        return informacionBeneficiario3Apellido1;
    }

    public void setInformacionBeneficiario3Apellido1(String informacionBeneficiario3Apellido1) {
        this.informacionBeneficiario3Apellido1 = informacionBeneficiario3Apellido1;
    }

    public String getInformacionBeneficiario3Apellido2() {
        return informacionBeneficiario3Apellido2;
    }

    public void setInformacionBeneficiario3Apellido2(String informacionBeneficiario3Apellido2) {
        this.informacionBeneficiario3Apellido2 = informacionBeneficiario3Apellido2;
    }

    public String getInformacionBeneficiario3Nombres() {
        return informacionBeneficiario3Nombres;
    }

    public void setInformacionBeneficiario3Nombres(String informacionBeneficiario3Nombres) {
        this.informacionBeneficiario3Nombres = informacionBeneficiario3Nombres;
    }

    public String getInformacionBeneficiario3FechaNacimiento() {
        return informacionBeneficiario3FechaNacimiento;
    }

    public void setInformacionBeneficiario3FechaNacimiento(String informacionBeneficiario3FechaNacimiento) {
        this.informacionBeneficiario3FechaNacimiento = informacionBeneficiario3FechaNacimiento;
    }

    public String getInformacionBeneficiario3DocumentoIdentidad() {
        return informacionBeneficiario3DocumentoIdentidad;
    }

    public void setInformacionBeneficiario3DocumentoIdentidad(String informacionBeneficiario3DocumentoIdentidad) {
        this.informacionBeneficiario3DocumentoIdentidad = informacionBeneficiario3DocumentoIdentidad;
    }

    public String getInformacionBeneficiario3Parentesco() {
        return informacionBeneficiario3Parentesco;
    }

    public void setInformacionBeneficiario3Parentesco(String informacionBeneficiario3Parentesco) {
        this.informacionBeneficiario3Parentesco = informacionBeneficiario3Parentesco;
    }

    public String getInformacionBeneficiario3PorcDistribucion() {
        return informacionBeneficiario3PorcDistribucion;
    }

    public void setInformacionBeneficiario3PorcDistribucion(String informacionBeneficiario3PorcDistribucion) {
        this.informacionBeneficiario3PorcDistribucion = informacionBeneficiario3PorcDistribucion;
    }

    public String getInformacionBeneficiarioContingente1Apellido1() {
        return informacionBeneficiarioContingente1Apellido1;
    }

    public void setInformacionBeneficiarioContingente1Apellido1(String informacionBeneficiarioContingente1Apellido1) {
        this.informacionBeneficiarioContingente1Apellido1 = informacionBeneficiarioContingente1Apellido1;
    }

    public String getInformacionBeneficiarioContingente1Apellido2() {
        return informacionBeneficiarioContingente1Apellido2;
    }

    public void setInformacionBeneficiarioContingente1Apellido2(String informacionBeneficiarioContingente1Apellido2) {
        this.informacionBeneficiarioContingente1Apellido2 = informacionBeneficiarioContingente1Apellido2;
    }

    public String getInformacionBeneficiarioContingente1Nombres() {
        return informacionBeneficiarioContingente1Nombres;
    }

    public void setInformacionBeneficiarioContingente1Nombres(String informacionBeneficiarioContingente1Nombres) {
        this.informacionBeneficiarioContingente1Nombres = informacionBeneficiarioContingente1Nombres;
    }

    public String getInformacionBeneficiarioContingente1FechaNacimiento() {
        return informacionBeneficiarioContingente1FechaNacimiento;
    }

    public void setInformacionBeneficiarioContingente1FechaNacimiento(String informacionBeneficiarioContingente1FechaNacimiento) {
        this.informacionBeneficiarioContingente1FechaNacimiento = informacionBeneficiarioContingente1FechaNacimiento;
    }

    public String getInformacionBeneficiarioContingente1DocumentoIdentidad() {
        return informacionBeneficiarioContingente1DocumentoIdentidad;
    }

    public void setInformacionBeneficiarioContingente1DocumentoIdentidad(String informacionBeneficiarioContingente1DocumentoIdentidad) {
        this.informacionBeneficiarioContingente1DocumentoIdentidad = informacionBeneficiarioContingente1DocumentoIdentidad;
    }

    public String getInformacionBeneficiarioContingente1Parentesco() {
        return informacionBeneficiarioContingente1Parentesco;
    }

    public void setInformacionBeneficiarioContingente1Parentesco(String informacionBeneficiarioContingente1Parentesco) {
        this.informacionBeneficiarioContingente1Parentesco = informacionBeneficiarioContingente1Parentesco;
    }

    public String getInformacionBeneficiarioContingente1PorcDistribucion() {
        return informacionBeneficiarioContingente1PorcDistribucion;
    }

    public void setInformacionBeneficiarioContingente1PorcDistribucion(String informacionBeneficiarioContingente1PorcDistribucion) {
        this.informacionBeneficiarioContingente1PorcDistribucion = informacionBeneficiarioContingente1PorcDistribucion;
    }

    public String getInformacionBeneficiarioContingente2Apellido1() {
        return informacionBeneficiarioContingente2Apellido1;
    }

    public void setInformacionBeneficiarioContingente2Apellido1(String informacionBeneficiarioContingente2Apellido1) {
        this.informacionBeneficiarioContingente2Apellido1 = informacionBeneficiarioContingente2Apellido1;
    }

    public String getInformacionBeneficiarioContingente2Apellido2() {
        return informacionBeneficiarioContingente2Apellido2;
    }

    public void setInformacionBeneficiarioContingente2Apellido2(String informacionBeneficiarioContingente2Apellido2) {
        this.informacionBeneficiarioContingente2Apellido2 = informacionBeneficiarioContingente2Apellido2;
    }

    public String getInformacionBeneficiarioContingente2Nombres() {
        return informacionBeneficiarioContingente2Nombres;
    }

    public void setInformacionBeneficiarioContingente2Nombres(String informacionBeneficiarioContingente2Nombres) {
        this.informacionBeneficiarioContingente2Nombres = informacionBeneficiarioContingente2Nombres;
    }

    public String getInformacionBeneficiarioContingente2FechaNacimiento() {
        return informacionBeneficiarioContingente2FechaNacimiento;
    }

    public void setInformacionBeneficiarioContingente2FechaNacimiento(String informacionBeneficiarioContingente2FechaNacimiento) {
        this.informacionBeneficiarioContingente2FechaNacimiento = informacionBeneficiarioContingente2FechaNacimiento;
    }

    public String getInformacionBeneficiarioContingente2DocumentoIdentidad() {
        return informacionBeneficiarioContingente2DocumentoIdentidad;
    }

    public void setInformacionBeneficiarioContingente2DocumentoIdentidad(String informacionBeneficiarioContingente2DocumentoIdentidad) {
        this.informacionBeneficiarioContingente2DocumentoIdentidad = informacionBeneficiarioContingente2DocumentoIdentidad;
    }

    public String getInformacionBeneficiarioContingente2Parentesco() {
        return informacionBeneficiarioContingente2Parentesco;
    }

    public void setInformacionBeneficiarioContingente2Parentesco(String informacionBeneficiarioContingente2Parentesco) {
        this.informacionBeneficiarioContingente2Parentesco = informacionBeneficiarioContingente2Parentesco;
    }

    public String getInformacionBeneficiarioContingente2PorcDistribucion() {
        return informacionBeneficiarioContingente2PorcDistribucion;
    }

    public void setInformacionBeneficiarioContingente2PorcDistribucion(String informacionBeneficiarioContingente2PorcDistribucion) {
        this.informacionBeneficiarioContingente2PorcDistribucion = informacionBeneficiarioContingente2PorcDistribucion;
    }

    public String getNumOACOT2() {
        return numOACOT2;
    }

    public void setNumOACOT2(String numOACOT2) {
        this.numOACOT2 = numOACOT2;
    }

    public String getFechaNacimientoCotizador2() {
        return fechaNacimientoCotizador2;
    }

    public void setFechaNacimientoCotizador2(String fechaNacimientoCotizador2) {
        this.fechaNacimientoCotizador2 = fechaNacimientoCotizador2;
    }

    public String getSexoAseguradoCotizador2() {
        return sexoAseguradoCotizador2;
    }

    public void setSexoAseguradoCotizador2(String sexoAseguradoCotizador2) {
        this.sexoAseguradoCotizador2 = sexoAseguradoCotizador2;
    }

    public String getCotizadorFumador2() {
        return cotizadorFumador2;
    }

    public void setCotizadorFumador2(String cotizadorFumador2) {
        this.cotizadorFumador2 = cotizadorFumador2;
    }

    public String getEdadActuarialAsegurado2() {
        return edadActuarialAsegurado2;
    }

    public void setEdadActuarialAsegurado2(String edadActuarialAsegurado2) {
        this.edadActuarialAsegurado2 = edadActuarialAsegurado2;
    }

    public String getEdadMinimaIngreso2() {
        return edadMinimaIngreso2;
    }

    public void setEdadMinimaIngreso2(String edadMinimaIngreso2) {
        this.edadMinimaIngreso2 = edadMinimaIngreso2;
    }

    public String getEdadMaximaIngreso2() {
        return edadMaximaIngreso2;
    }

    public void setEdadMaximaIngreso2(String edadMaximaIngreso2) {
        this.edadMaximaIngreso2 = edadMaximaIngreso2;
    }

    public String getEdadMaximaPermanencia2() {
        return edadMaximaPermanencia2;
    }

    public void setEdadMaximaPermanencia2(String edadMaximaPermanencia2) {
        this.edadMaximaPermanencia2 = edadMaximaPermanencia2;
    }

    public String getInformacion2Beneficiario1Apellido1() {
        return informacion2Beneficiario1Apellido1;
    }

    public void setInformacion2Beneficiario1Apellido1(String informacion2Beneficiario1Apellido1) {
        this.informacion2Beneficiario1Apellido1 = informacion2Beneficiario1Apellido1;
    }

    public String getInformacion2Beneficiario1Apellido2() {
        return informacion2Beneficiario1Apellido2;
    }

    public void setInformacion2Beneficiario1Apellido2(String informacion2Beneficiario1Apellido2) {
        this.informacion2Beneficiario1Apellido2 = informacion2Beneficiario1Apellido2;
    }

    public String getInformacion2Beneficiario1Nombres() {
        return informacion2Beneficiario1Nombres;
    }

    public void setInformacion2Beneficiario1Nombres(String informacion2Beneficiario1Nombres) {
        this.informacion2Beneficiario1Nombres = informacion2Beneficiario1Nombres;
    }

    public String getInformacion2Beneficiario1FechaNacimiento() {
        return informacion2Beneficiario1FechaNacimiento;
    }

    public void setInformacion2Beneficiario1FechaNacimiento(String informacion2Beneficiario1FechaNacimiento) {
        this.informacion2Beneficiario1FechaNacimiento = informacion2Beneficiario1FechaNacimiento;
    }

    public String getInformacion2Beneficiario1DocumentoIdentidad() {
        return informacion2Beneficiario1DocumentoIdentidad;
    }

    public void setInformacion2Beneficiario1DocumentoIdentidad(String informacion2Beneficiario1DocumentoIdentidad) {
        this.informacion2Beneficiario1DocumentoIdentidad = informacion2Beneficiario1DocumentoIdentidad;
    }

    public String getInformacion2Beneficiario1Parentesco() {
        return informacion2Beneficiario1Parentesco;
    }

    public void setInformacion2Beneficiario1Parentesco(String informacion2Beneficiario1Parentesco) {
        this.informacion2Beneficiario1Parentesco = informacion2Beneficiario1Parentesco;
    }

    public String getInformacion2Beneficiario1PorcDistribucion() {
        return informacion2Beneficiario1PorcDistribucion;
    }

    public void setInformacion2Beneficiario1PorcDistribucion(String informacion2Beneficiario1PorcDistribucion) {
        this.informacion2Beneficiario1PorcDistribucion = informacion2Beneficiario1PorcDistribucion;
    }

    public String getInformacion2Beneficiario2Apellido1() {
        return informacion2Beneficiario2Apellido1;
    }

    public void setInformacion2Beneficiario2Apellido1(String informacion2Beneficiario2Apellido1) {
        this.informacion2Beneficiario2Apellido1 = informacion2Beneficiario2Apellido1;
    }

    public String getInformacion2Beneficiario2Apellido2() {
        return informacion2Beneficiario2Apellido2;
    }

    public void setInformacion2Beneficiario2Apellido2(String informacion2Beneficiario2Apellido2) {
        this.informacion2Beneficiario2Apellido2 = informacion2Beneficiario2Apellido2;
    }

    public String getInformacion2Beneficiario2Nombres() {
        return informacion2Beneficiario2Nombres;
    }

    public void setInformacion2Beneficiario2Nombres(String informacion2Beneficiario2Nombres) {
        this.informacion2Beneficiario2Nombres = informacion2Beneficiario2Nombres;
    }

    public String getInformacion2Beneficiario2FechaNacimiento() {
        return informacion2Beneficiario2FechaNacimiento;
    }

    public void setInformacion2Beneficiario2FechaNacimiento(String informacion2Beneficiario2FechaNacimiento) {
        this.informacion2Beneficiario2FechaNacimiento = informacion2Beneficiario2FechaNacimiento;
    }

    public String getInformacion2Beneficiario2DocumentoIdentidad() {
        return informacion2Beneficiario2DocumentoIdentidad;
    }

    public void setInformacion2Beneficiario2DocumentoIdentidad(String informacion2Beneficiario2DocumentoIdentidad) {
        this.informacion2Beneficiario2DocumentoIdentidad = informacion2Beneficiario2DocumentoIdentidad;
    }

    public String getInformacion2Beneficiario2Parentesco() {
        return informacion2Beneficiario2Parentesco;
    }

    public void setInformacion2Beneficiario2Parentesco(String informacion2Beneficiario2Parentesco) {
        this.informacion2Beneficiario2Parentesco = informacion2Beneficiario2Parentesco;
    }

    public String getInformacion2Beneficiario2PorcDistribucion() {
        return informacion2Beneficiario2PorcDistribucion;
    }

    public void setInformacion2Beneficiario2PorcDistribucion(String informacion2Beneficiario2PorcDistribucion) {
        this.informacion2Beneficiario2PorcDistribucion = informacion2Beneficiario2PorcDistribucion;
    }

    public String getInformacion2Beneficiario3Apellido1() {
        return informacion2Beneficiario3Apellido1;
    }

    public void setInformacion2Beneficiario3Apellido1(String informacion2Beneficiario3Apellido1) {
        this.informacion2Beneficiario3Apellido1 = informacion2Beneficiario3Apellido1;
    }

    public String getInformacion2Beneficiario3Apellido2() {
        return informacion2Beneficiario3Apellido2;
    }

    public void setInformacion2Beneficiario3Apellido2(String informacion2Beneficiario3Apellido2) {
        this.informacion2Beneficiario3Apellido2 = informacion2Beneficiario3Apellido2;
    }

    public String getInformacion2Beneficiario3Nombres() {
        return informacion2Beneficiario3Nombres;
    }

    public void setInformacion2Beneficiario3Nombres(String informacion2Beneficiario3Nombres) {
        this.informacion2Beneficiario3Nombres = informacion2Beneficiario3Nombres;
    }

    public String getInformacion2Beneficiario3FechaNacimiento() {
        return informacion2Beneficiario3FechaNacimiento;
    }

    public void setInformacion2Beneficiario3FechaNacimiento(String informacion2Beneficiario3FechaNacimiento) {
        this.informacion2Beneficiario3FechaNacimiento = informacion2Beneficiario3FechaNacimiento;
    }

    public String getInformacion2Beneficiario3DocumentoIdentidad() {
        return informacion2Beneficiario3DocumentoIdentidad;
    }

    public void setInformacion2Beneficiario3DocumentoIdentidad(String informacion2Beneficiario3DocumentoIdentidad) {
        this.informacion2Beneficiario3DocumentoIdentidad = informacion2Beneficiario3DocumentoIdentidad;
    }

    public String getInformacion2Beneficiario3Parentesco() {
        return informacion2Beneficiario3Parentesco;
    }

    public void setInformacion2Beneficiario3Parentesco(String informacion2Beneficiario3Parentesco) {
        this.informacion2Beneficiario3Parentesco = informacion2Beneficiario3Parentesco;
    }

    public String getInformacion2Beneficiario3PorcDistribucion() {
        return informacion2Beneficiario3PorcDistribucion;
    }

    public void setInformacion2Beneficiario3PorcDistribucion(String informacion2Beneficiario3PorcDistribucion) {
        this.informacion2Beneficiario3PorcDistribucion = informacion2Beneficiario3PorcDistribucion;
    }

    public String getInformacion2BeneficiarioContingente1Apellido1() {
        return informacion2BeneficiarioContingente1Apellido1;
    }

    public void setInformacion2BeneficiarioContingente1Apellido1(String informacion2BeneficiarioContingente1Apellido1) {
        this.informacion2BeneficiarioContingente1Apellido1 = informacion2BeneficiarioContingente1Apellido1;
    }

    public String getInformacion2BeneficiarioContingente1Apellido2() {
        return informacion2BeneficiarioContingente1Apellido2;
    }

    public void setInformacion2BeneficiarioContingente1Apellido2(String informacion2BeneficiarioContingente1Apellido2) {
        this.informacion2BeneficiarioContingente1Apellido2 = informacion2BeneficiarioContingente1Apellido2;
    }

    public String getInformacion2BeneficiarioContingente1Nombres() {
        return informacion2BeneficiarioContingente1Nombres;
    }

    public void setInformacion2BeneficiarioContingente1Nombres(String informacion2BeneficiarioContingente1Nombres) {
        this.informacion2BeneficiarioContingente1Nombres = informacion2BeneficiarioContingente1Nombres;
    }

    public String getInformacion2BeneficiarioContingente1FechaNacimiento() {
        return informacion2BeneficiarioContingente1FechaNacimiento;
    }

    public void setInformacion2BeneficiarioContingente1FechaNacimiento(String informacion2BeneficiarioContingente1FechaNacimiento) {
        this.informacion2BeneficiarioContingente1FechaNacimiento = informacion2BeneficiarioContingente1FechaNacimiento;
    }

    public String getInformacion2BeneficiarioContingente1DocumentoIdentidad() {
        return informacion2BeneficiarioContingente1DocumentoIdentidad;
    }

    public void setInformacion2BeneficiarioContingente1DocumentoIdentidad(String informacion2BeneficiarioContingente1DocumentoIdentidad) {
        this.informacion2BeneficiarioContingente1DocumentoIdentidad = informacion2BeneficiarioContingente1DocumentoIdentidad;
    }

    public String getInformacion2BeneficiarioContingente1Parentesco() {
        return informacion2BeneficiarioContingente1Parentesco;
    }

    public void setInformacion2BeneficiarioContingente1Parentesco(String informacion2BeneficiarioContingente1Parentesco) {
        this.informacion2BeneficiarioContingente1Parentesco = informacion2BeneficiarioContingente1Parentesco;
    }

    public String getInformacion2BeneficiarioContingente1PorcDistribucion() {
        return informacion2BeneficiarioContingente1PorcDistribucion;
    }

    public void setInformacion2BeneficiarioContingente1PorcDistribucion(String informacion2BeneficiarioContingente1PorcDistribucion) {
        this.informacion2BeneficiarioContingente1PorcDistribucion = informacion2BeneficiarioContingente1PorcDistribucion;
    }

    public String getInformacion2BeneficiarioContingente2Apellido1() {
        return informacion2BeneficiarioContingente2Apellido1;
    }

    public void setInformacion2BeneficiarioContingente2Apellido1(String informacion2BeneficiarioContingente2Apellido1) {
        this.informacion2BeneficiarioContingente2Apellido1 = informacion2BeneficiarioContingente2Apellido1;
    }

    public String getInformacion2BeneficiarioContingente2Apellido2() {
        return informacion2BeneficiarioContingente2Apellido2;
    }

    public void setInformacion2BeneficiarioContingente2Apellido2(String informacion2BeneficiarioContingente2Apellido2) {
        this.informacion2BeneficiarioContingente2Apellido2 = informacion2BeneficiarioContingente2Apellido2;
    }

    public String getInformacion2BeneficiarioContingente2Nombres() {
        return informacion2BeneficiarioContingente2Nombres;
    }

    public void setInformacion2BeneficiarioContingente2Nombres(String informacion2BeneficiarioContingente2Nombres) {
        this.informacion2BeneficiarioContingente2Nombres = informacion2BeneficiarioContingente2Nombres;
    }

    public String getInformacion2BeneficiarioContingente2FechaNacimiento() {
        return informacion2BeneficiarioContingente2FechaNacimiento;
    }

    public void setInformacion2BeneficiarioContingente2FechaNacimiento(String informacion2BeneficiarioContingente2FechaNacimiento) {
        this.informacion2BeneficiarioContingente2FechaNacimiento = informacion2BeneficiarioContingente2FechaNacimiento;
    }

    public String getInformacion2BeneficiarioContingente2DocumentoIdentidad() {
        return informacion2BeneficiarioContingente2DocumentoIdentidad;
    }

    public void setInformacion2BeneficiarioContingente2DocumentoIdentidad(String informacion2BeneficiarioContingente2DocumentoIdentidad) {
        this.informacion2BeneficiarioContingente2DocumentoIdentidad = informacion2BeneficiarioContingente2DocumentoIdentidad;
    }

    public String getInformacion2BeneficiarioContingente2Parentesco() {
        return informacion2BeneficiarioContingente2Parentesco;
    }

    public void setInformacion2BeneficiarioContingente2Parentesco(String informacion2BeneficiarioContingente2Parentesco) {
        this.informacion2BeneficiarioContingente2Parentesco = informacion2BeneficiarioContingente2Parentesco;
    }

    public String getInformacion2BeneficiarioContingente2PorcDistribucion() {
        return informacion2BeneficiarioContingente2PorcDistribucion;
    }

    public void setInformacion2BeneficiarioContingente2PorcDistribucion(String informacion2BeneficiarioContingente2PorcDistribucion) {
        this.informacion2BeneficiarioContingente2PorcDistribucion = informacion2BeneficiarioContingente2PorcDistribucion;
    }

    public String getNuevaCotizacionRecibida() {
        return nuevaCotizacionRecibida;
    }

    public void setNuevaCotizacionRecibida(String nuevaCotizacionRecibida) {
        this.nuevaCotizacionRecibida = nuevaCotizacionRecibida;
    }

    public String getSolicitudAfiliacion() {
        return solicitudAfiliacion;
    }

    public void setSolicitudAfiliacion(String solicitudAfiliacion) {
        this.solicitudAfiliacion = solicitudAfiliacion;
    }

    public String getEstadoPropuesta() {
        return estadoPropuesta;
    }

    public void setEstadoPropuesta(String estadoPropuesta) {
        this.estadoPropuesta = estadoPropuesta;
    }

    public String getEstadoPropuesta2() {
        return estadoPropuesta2;
    }

    public void setEstadoPropuesta2(String estadoPropuesta2) {
        this.estadoPropuesta2 = estadoPropuesta2;
    }
}
