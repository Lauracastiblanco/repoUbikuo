// Función para mostrar un mensaje de error en un campo específico
function mostrarError(campo, mensaje) {
  const inputBox = campo.parentElement; // Obtener el div 'input-box'
  const errorMensaje = inputBox.querySelector('.error-mensaje'); // Obtener el div 'error-mensaje'
  
  // Mostrar el mensaje de error
  errorMensaje.textContent = mensaje;
  inputBox.classList.add('error'); // Agregar la clase 'error' al div 'input-box'
}

// Función para ocultar los mensajes de error en todos los campos
function ocultarErrores() {
  const errorMensajes = document.querySelectorAll('.error-mensaje');
  const inputBoxes = document.querySelectorAll('.input-box');

  errorMensajes.forEach((errorMensaje) => {
    errorMensaje.textContent = '';
  });

  inputBoxes.forEach((inputBox) => {
    inputBox.classList.remove('error');
  });
}

// Evento de envío del formulario
const form = document.querySelector('form');
form.addEventListener('submit', (event) => {
  event.preventDefault(); // Evitar el envío del formulario para validar los campos
  
  ocultarErrores(); // Ocultar todos los mensajes de error antes de validar
  
  // Validar los campos
  const nombre = document.querySelector('input[name="usunombre"]');
  const apellido = document.querySelector('input[name="usuapellido"]');
  const documento = document.querySelector('input[name="id_usuario"]');
  const direccion = document.querySelector('input[name="usudireccion"]');
  const telefono = document.querySelector('input[name="usutelefono"]');
  const correo = document.querySelector('input[name="usuemail"]');
  const contrasena = document.querySelector('input[name="usupassword"]');
  
  // Validación del nombre
  if (nombre.value.length < 3 || nombre.value.length > 12) {
    mostrarError(nombre, 'Asegúrate de que el nombre tenga entre 3 y 12 caracteres.');
  }

  // Validación del apellido
  if (apellido.value.length < 3 || apellido.value.length > 12) {
    mostrarError(apellido, 'Asegúrate de que el apellido tenga entre 3 y 12 caracteres.');
  }

  // Validación del documento
  if (documento.value.length < 10 || documento.value.length > 12) {
    mostrarError(documento, 'Asegúrate de que el documento tenga entre 10 y 12 caracteres.');
  }

  // Validación de la dirección
  if (direccion.value.length < 10 || direccion.value.length > 50) {
    mostrarError(direccion, 'El número mínimo de caracteres a ingresar es 10 y el máximo es 50 caracteres.');
  }

  // Validación del teléfono
  const telefonoRegex = /^[0-9]{10}$/;
  if (!telefonoRegex.test(telefono.value)) {
    mostrarError(telefono, 'Solo se permiten números de teléfono celular.');
  }

  // Validación del correo electrónico
  const correoRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
  if (correo.value.length > 110 || !correoRegex.test(correo.value)) {
    mostrarError(correo, 'Asegúrate de no usar caracteres especiales y de cumplir con el formato del correo, además de no sobrepasar los 110 caracteres.');
  }

  // Validación de la contraseña
  if (contrasena.value.length < 6) {
    mostrarError(contrasena, 'El mínimo de caracteres que se puede usar es de 6.');
  }
});
