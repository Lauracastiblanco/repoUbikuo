/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function inputsProveedor() {
    var selectProveedor = document.getElementById("miSelect");
    var provSeleccionado = selectProveedor.options[selectProveedor.selectedIndex];
    var nombre = provSeleccionado.getAttribute("data-nombre");
    document.getElementById("pronombre").value = nombre;
    var representante = provSeleccionado.getAttribute("data-representante");
    document.getElementById("prorepresentante").value = representante;
    var direccion = provSeleccionado.getAttribute("data-direccion");
    document.getElementById("prodireccion").value = direccion;
    var correo = provSeleccionado.getAttribute("data-correo");
    document.getElementById("procorreo").value = correo;
}
function inputsProductos() {
    var selectProducto = document.getElementById("selectProducto");
    var prodSeleccionado = selectProducto.options[selectProducto.selectedIndex];
    var descripcion = prodSeleccionado.getAttribute("data-descripcion");
    document.getElementById("prod_descripcion").value = descripcion;
    var precio = prodSeleccionado.getAttribute("data-precio");
    document.getElementById("prodprecio").value = precio;
    var stock = prodSeleccionado.getAttribute("data-stock");
    document.getElementById("prodstock_disp").value = stock;
}

//select2
$(document).ready(function() {
  $('.select2').select2();
});
$(document).ready(function() {
  $('.select3').select2();
});
