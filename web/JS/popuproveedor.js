/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

const openPopupBtnsModal1 = document.querySelectorAll('.open-popup[data-popup="popup1"]');
const closePopupBtns = document.querySelectorAll('.cancelarbtn');
const openPopupBtnsModal2 = document.querySelectorAll('.actualizar-usuario');
const modal_actualizar_usuario = document.querySelector('.actualizar-popup');

openPopupBtnsModal1.forEach(btn => {
    btn.addEventListener('click', () => {
        const popupId = btn.dataset.popup;
        const popup = document.querySelector(`#${popupId}`);
        popup.classList.add('active');
    });
});

closePopupBtns.forEach(btn => {
    btn.addEventListener('click', () => {
        const popup = btn.closest('.popup');
        popup.classList.remove('active');
    });
});

openPopupBtnsModal2.forEach(btn => {
    btn.addEventListener('click', (event) => {
        event.preventDefault();
        //id
        const usuid = btn.getAttribute('data-prov-id');
        const usuIdInput = modal_actualizar_usuario.querySelector('#id_prov');
        usuIdInput.value = usuid;
        modal_actualizar_usuario.classList.add('active');
        //nombre
        const usunombre = btn.getAttribute('data-prov-nombre');
        const usuNombreInput = modal_actualizar_usuario.querySelector('#pronombre');
        usuNombreInput.value = usunombre;
        //direccion
        const usudireccion = btn.getAttribute('data-prov-direccion');
        const usuDireccionInput = modal_actualizar_usuario.querySelector('#prodireccion');
        usuDireccionInput.value = usudireccion;
        modal_actualizar_usuario.classList.add('active');
        //telefono
        const usutelefono = btn.getAttribute('data-prov-telefono');
        const usuTelefonoInput = modal_actualizar_usuario.querySelector('#protelefono');
        usuTelefonoInput.value = usutelefono;
        modal_actualizar_usuario.classList.add('active');
        //email
        const usuemail = btn.getAttribute('data-prov-email');
        const usuEmailInput = modal_actualizar_usuario.querySelector('#procorreo');
        usuEmailInput.value = usuemail;
        modal_actualizar_usuario.classList.add('active');
        //estado
        const usuestado = btn.getAttribute('data-prov-estado');
        const usuEstadoInput = modal_actualizar_usuario.querySelector('#proestado');
        usuEstadoInput.value = usuestado;
        modal_actualizar_usuario.classList.add('active');
        //descripcion
        const usuestado = btn.getAttribute('data-prov-descripcion');
        const usuEstadoInput = modal_actualizar_usuario.querySelector('#prodescripcion');
        usuEstadoInput.value = usuestado;
        modal_actualizar_usuario.classList.add('active');
        //estado
        const usuestado = btn.getAttribute('data-prov-estado');
        const usuEstadoInput = modal_actualizar_usuario.querySelector('#proestado');
        usuEstadoInput.value = usuestado;
        modal_actualizar_usuario.classList.add('active');
    });
});

