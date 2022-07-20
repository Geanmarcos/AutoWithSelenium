
@primerafuncionalidad
Feature: Funcionalidad del carrito de compra
  @smoke
  Scenario: Compra de un producto
    Given que la web esta operativa
    When se generara el numero de tarjeta
    And selecciona la cantidad "5"
    And realiza la compra del producto
    And Ingresa los datos de la tarjeta
    And Paga el producto
    Then Validar el mensaje de pago "Payment successfull!"

  @regresion
  Scenario Outline: Compra de un producto con varias cantidades
    Given que la web esta operativa
    When se generara el numero de tarjeta
    And selecciona la cantidad "<cantidad>"
    And realiza la compra del producto
    And Ingresa los datos de la tarjeta
    And Paga el producto
    Then Validar el mensaje de pago "<mensaje>"
    Examples: Tabla de cantidades
    |cantidad|mensaje             |
    |4       |Payment successfull!|
    |6       |Payment successfull!|
    |8       |Payment successfull!|


    Scenario: Validacion de tarjeta en blanco
      Given que la web esta operativa
      When selecciona la cantidad "8"
      And realiza la compra del producto
      And selecciona el mes "04"
      And selecciona el año "2021"
      And Paga el producto
      Then validar el mensaje del cuadro de dialogo "Check card number is 16 digits!"