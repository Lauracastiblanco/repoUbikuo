/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//ARRAY ORDEN TABLA
var productos = [];

function actualizarTablaProductos() { //boton de agregar al pedido
    var tablaBody = document.getElementById("tablaProductosBody"); //donde colo este id
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
        columnaSubtotal.textContent = producto.dpro_cantidad * producto.precio; // Multiplicar precio y cantidad
        fila.appendChild(columnaSubtotal);

        var columnaEliminar = document.createElement("td");
        var botonEliminar = document.createElement("button");
        botonEliminar.classList.add("agregar");
        var iconoEliminar = document.createElement("i"); // creas el elemento <i>

        iconoEliminar.className = "bx bxs-trash"; // agregas la clase del icono
        botonEliminar.appendChild(iconoEliminar); // agregas el icono al botón
        botonEliminar.setAttribute("data-id", i);

        botonEliminar.addEventListener("click", function () {
            var index = parseInt(this.getAttribute("data-id"));
            productos.splice(index, 1);
            actualizarTablaProductos();
        });

        columnaEliminar.appendChild(botonEliminar);
        fila.appendChild(columnaEliminar);
        tablaBody.appendChild(fila);

    }
    // Seleccionar todos los campos de subtotal y sumarlos
    var subtotales = document.getElementsByClassName("subtotal");
    var total = 0;
    for (var i = 0; i < subtotales.length; i++) {
        var subtotal = parseFloat(subtotales[i].innerHTML);
        total += subtotal;
    }

    // Actualizar el valor del campo de texto Total
    var totalField = document.getElementById("total");
    totalField.textContent = total.toFixed(2);
}



// Función para eliminar un producto del array
function eliminarProducto(index) {
    productos.splice(index, 1);
    actualizarTablaProductos();
}

// Event listener para el botón de "Añadir"
function agregarProducto() {
    // Obtener los valores de los campos de entrada
    var proId = document.getElementsByName("proId_fk")[0].value;
    var proNombre = document.getElementsByName("proId_fk")[0].options[document.getElementsByName("proId_fk")[0].selectedIndex].text;
    var detoSabor = document.getElementsByName("detoSabor")[0].value;
    var detoRelleno = document.getElementsByName("detoRelleno")[0].value;
    var detoPorciones = document.getElementsByName("detoPorciones")[0].value;
    var detoCantidad = document.getElementsByName("detoCantidad")[0].value;
    var detoPrecio = document.getElementsByName("detoPrecio")[0].value;

    // Validar que los campos no estén vacíos
    if (proId === "" || detoCantidad === "" || detoPrecio === "") {
        alert("Por favor, complete todos los campos antes de agregar un nuevo producto.");
        return;
    }
    // Agregar un nuevo objeto de producto al array de productos
    productos.push({
        proId: proId,
        proNombre: proNombre,
        sabor: detoSabor,
        relleno: detoRelleno,
        porciones: detoPorciones,
        cantidad: detoCantidad,
        precio: detoPrecio
    });
// Limpiar los campos de entrada
    document.querySelector('select[name="proId_fk"]').value = "";
    document.querySelector('select[name="proId_fk"]').dispatchEvent(new Event('change'));
    document.querySelector('select[name="proId_fk"]').selectedIndex = 0;
    document.querySelector('select[name="detoSabor"]').value = "";
    document.querySelector('select[name="detoSabor"]').dispatchEvent(new Event('change'));
    document.querySelector('select[name="detoRelleno"]').value = "";
    document.querySelector('select[name="detoRelleno"]').dispatchEvent(new Event('change'));
    document.querySelector('input[name="detoPorciones"]').value = "";
    document.querySelector('input[name="detoCantidad"]').value = "";
    document.querySelector('input[name="detoPrecio"]').value = "";
    // Actualizar la tabla de productos
    actualizarTablaProductos();

}
;




