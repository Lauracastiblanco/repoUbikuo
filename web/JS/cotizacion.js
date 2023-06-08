/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function inputsCotizacion() {
    var selectProveedor = document.getElementById("miSelect");
    var provSeleccionado = selectProveedor.options[selectProveedor.selectedIndex];
    var nombre = provSeleccionado.getAttribute("data-nombre");
    document.getElementById("clinombre").value = nombre;
    var apellido = provSeleccionado.getAttribute("data-apellido");
    document.getElementById("cliapellido").value = apellido;
    var direccion = provSeleccionado.getAttribute("data-direccion");
    document.getElementById("clidireccion").value = direccion;
    var correo = provSeleccionado.getAttribute("data-correo");
    document.getElementById("clicorreo").value = correo;
    var telefono =provSeleccionado.getAttribute("data-telefono");
    document.getElementById("clitelefono").value = correo;
     var descripcion =provSeleccionado.getAttribute("data-descripcion");
    document.getElementById("clidescripcion").value = descripcion;
    
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
$(document).ready(function() {
  $('.select4').select2();
});

