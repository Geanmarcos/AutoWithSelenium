package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import pageobjects.*;

import java.io.IOException;

import static support.util.evidencias;

public class carritoDefinition {
    menuPage menu;
    tarjetaPage tarjeta;
    carritoPage carrito;
    pagoPage pago;

    successPage success;

    public carritoDefinition() {
        menu = new menuPage();
        tarjeta = new tarjetaPage();
        carrito = new carritoPage();
        pago = new pagoPage();
        success = new successPage();

    }

    @Given("que la web esta operativa")
    public void queLaWebEstaOperativa() {
        hooks.driver.get("https://demo.guru99.com/payment-gateway");
    }

    @When("se generara el numero de tarjeta")
    public void seGeneraraElNumeroDeTarjeta() throws IOException {
        menu.clickGenerarTarjeta();
        menu.ventanaActiva();
        tarjeta.obtenerNroTarjeta();
        tarjeta.obtenerCVV();
        tarjeta.obtenerFecha();
        evidencias();
        tarjeta.ventanaInicial();
    }

    @And("selecciona la cantidad {string}")
    public void seleccionaLaCantidad(String cant) throws IOException {
        carrito.seleccionarCantidad(cant);
        evidencias();
    }

    @And("realiza la compra del producto")
    public void realizaLaCompraDelProducto() {
        carrito.clickComprar();
    }

    @And("Ingresa los datos de la tarjeta")
    public void ingresaLosDatosDeLaTarjeta() throws IOException {
        pago.escribirNroTarjeta(tarjetaPage.nro_tarjeta);
        seleccionaElMes(tarjetaPage.mes);
        seleccionaElAño(tarjetaPage.anio);
        pago.escribirCVV(tarjetaPage.cvv);
        evidencias();
    }

    @And("Paga el producto")
    public void pagaElProducto() {
        //pago.scrollVertical();
        pago.clickPagar();
    }

    @Then("Validar el mensaje de pago {string}")
    public void validarElMensajeDePago(String mensaje) throws IOException {
        success.success(mensaje);
        evidencias();
        success.mostrarCodigo();
    }


    @And("selecciona el mes {string}")
    public void seleccionaElMes(String mes) {
        pago.SeleccionarMes(mes);
    }


    @And("selecciona el año {string}")
    public void seleccionaElAño(String anio) {
        pago.SeleccionarAnio(anio);
    }

    @Then("validar el mensaje del cuadro de dialogo {string}")
    public void validarElMensajeDelCuadroDeDialogo(String msj) {
        pago.obtenerTextoDialogo(msj);
        pago.aceptarDialogo();
    }
}