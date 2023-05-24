/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var productos = [];

function actualizarTablaProductos() {
  var tablaBody = document.getElementById("tablaProductosBody");
  tablaBody.innerHTML = "";

  // Recorrer el array de productos y agregar filas a la tabla
  for (var i = 0; i < productos.length; i++) {
    var producto = productos[i];

    var fila = document.createElement("tr");

    var idProducto = document.createElement("td");
    idProducto.textContent = producto.id_prod;
    fila.appendChild(idProducto);

    var nombreProducto = document.createElement("td");
    nombreProducto.textContent = producto.prodnombre;
    fila.appendChild(nombreProducto);

    var cantidadProducto = document.createElement("td");
    cantidadProducto.textContent = producto.dpro_cantidad;
    fila.appendChild(cantidadProducto);

    var precioProducto = document.createElement("td");
    precioProducto.textContent = producto.prodprecio;
    fila.appendChild(precioProducto);

    var columnaSubtotal = document.createElement("td");
    var columnaSubtotalSpan = document.createElement("span");
    columnaSubtotal.classList.add("subtotal");
    columnaSubtotal.textContent = producto.dpro_cantidad * producto.prodprecio; // Multiplicar precio y cantidad
    fila.appendChild(columnaSubtotal);

    var columnaEliminar = document.createElement("td");
    var botonEliminar = document.createElement("button");
    botonEliminar.classList.add("agregar");
    var iconoEliminar = document.createElement("i");

    iconoEliminar.className = "bx bxs-trash";
    botonEliminar.appendChild(iconoEliminar);
    botonEliminar.setAttribute("data-id", i);

    botonEliminar.addEventListener("click", function () {
      var index = parseInt(this.getAttribute("data-id"));
      productos.splice(index, 1);
      actualizarTablaProductos();
      guardarProductosEnAlmacenamientoLocal(); // Guardar los productos actualizados en el almacenamiento local
    });

    columnaEliminar.appendChild(botonEliminar);
    fila.appendChild(columnaEliminar);
    tablaBody.appendChild(fila);
  }
}

// Cargar los productos almacenados en el almacenamiento local al cargar la página
function cargarProductosDesdeAlmacenamientoLocal() {
  var productosGuardados = localStorage.getItem("productos");
  if (productosGuardados) {
    productos = productosGuardados.split(","); // Convertir la cadena de texto en un array
  }
}

// Guardar los productos en el almacenamiento local
function guardarProductosEnAlmacenamientoLocal() {
  var productosString = productos.join(","); // Convertir el array en una cadena de texto separada por comas
  localStorage.setItem("productos", productosString);
}

// Evento que se ejecuta al cargar la página
window.addEventListener("load", function () {
  cargarProductosDesdeAlmacenamientoLocal(); // Cargar los productos desde el almacenamiento local
  actualizarTablaProductos();
});

// Resto del código para agregar productos, eliminar productos, etc.


// Cargar los productos almacenados en el almacenamiento local al cargar la página
function cargarProductosDesdeAlmacenamientoLocal() {
  var productosGuardados = localStorage.getItem("productos");
  if (productosGuardados) {
    productos = JSON.parse(productosGuardados);
  }
}

// Guardar los productos en el almacenamiento local
function guardarProductosEnAlmacenamientoLocal() {
  localStorage.setItem("productos", JSON.stringify(productos));
}

// Evento que se ejecuta al cargar la página
window.addEventListener("load", function () {
  cargarProductosDesdeAlmacenamientoLocal(); // Cargar los productos desde el almacenamiento local
  actualizarTablaProductos();
});

// Resto del código para agregar productos, eliminar productos, etc.


// Función para eliminar un producto del array
function eliminarProducto(index) {
    productos.splice(index, 1);
    actualizarTablaProductos();
}

// Event listener para el botón de "Añadir"
function agregarProducto() {
    // Obtener los valores de los campos de entrada
    //var id_prod = document.getElementsByName("id_prod")[0].options[document.getElementsByName("id_prod")[0].selectedIndex].text;
    var id_prod = document.getElementsByName("id_prod")[0].value;
    var prodprecio = document.getElementsByName("prodprecio")[0].value;
    var prodnombre = document.getElementsByName("id_prod")[0].options[document.getElementsByName("id_prod")[0].selectedIndex].text.split(' - ')[0];
    var dpro_cantidad = document.getElementsByName("dpro_cantidad")[0].value;


    // Validar que los campos no estén vacíos
    if (id_prod === "" || prodprecio === "" || dpro_cantidad === "") {
        alert("Por favor, complete todos los campos antes de agregar un nuevo producto.");
        return;
    }
    // Agregar un nuevo objeto de producto al array de productos
    productos.push({
        id_prod: id_prod,
        prodprecio: prodprecio,
        prodnombre: prodnombre,
        dpro_cantidad: dpro_cantidad,
       

    });
// Limpiar los campos de entrada
    document.querySelector('select[name="id_prod"]').value = "";
    document.querySelector('select[name="id_prod"]').dispatchEvent(new Event('change'));
    document.querySelector('input[name="dpro_cantidad"]').value = "";
    // Actualizar la tabla de productos
    actualizarTablaProductos();

}
;