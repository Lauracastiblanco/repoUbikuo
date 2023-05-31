/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function inputsProductoscot() {
    var selectProducto = document.getElementById("selectProducto");
    var prodSeleccionado = selectProducto.options[selectProducto.selectedIndex];
    var descripcion = prodSeleccionado.getAttribute("data-descripcion");
    document.getElementById("prod_descripcion").value = descripcion;
    var precio = prodSeleccionado.getAttribute("data-precio");
    document.getElementById("prodprecio").value = precio;
    var stock = prodSeleccionado.getAttribute("data-stock");
    document.getElementById("prodstock_disp").value = stock;
}

