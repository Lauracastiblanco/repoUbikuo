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
        //nombre
        const usunombre = btn.getAttribute('data-usu-nombre');
        const usuNombreInput = modal_actualizar_usuario.querySelector('#usunombre');
        usuNombreInput.value = usunombre;
        //apellido
        const usuapellido = btn.getAttribute('data-usu-apellido');
        const usuApellidoInput = modal_actualizar_usuario.querySelector('#usuapellido');
        usuApellidoInput.value = usuapellido;
        modal_actualizar_usuario.classList.add('active');
        //id
        const usuid = btn.getAttribute('data-usu-id');
        const usuIdInput = modal_actualizar_usuario.querySelector('#id_usuario');
        usuIdInput.value = usuid;
        modal_actualizar_usuario.classList.add('active');
        //direccion
        const usudireccion = btn.getAttribute('data-usu-direccion');
        const usuDireccionInput = modal_actualizar_usuario.querySelector('#usudireccion');
        usuDireccionInput.value = usudireccion;
        modal_actualizar_usuario.classList.add('active');
        //telefono
        const usutelefono = btn.getAttribute('data-usu-telefono');
        const usuTelefonoInput = modal_actualizar_usuario.querySelector('#usutelefono');
        usuTelefonoInput.value = usutelefono;
        modal_actualizar_usuario.classList.add('active');
        //email
        const usuemail = btn.getAttribute('data-prov-email');
        const usuEmailInput = modal_actualizar_usuario.querySelector('#');
        usuEmailInput.value = usuemail;
        modal_actualizar_usuario.classList.add('active');
        //password
        const usupassword = btn.getAttribute('data-usu-password');
        const usuPasswordInput = modal_actualizar_usuario.querySelector('#usupassword');
        usuPasswordInput.value = usupassword;
        modal_actualizar_usuario.classList.add('active');
        //rol
        const usu_id_rol = btn.getAttribute('data-usu-rol');
        const usuRolInput = modal_actualizar_usuario.querySelector('#usu_id_rol');
        usuRolInput.value = usu_id_rol;
        modal_actualizar_usuario.classList.add('active');
        //estado
        const usuestado = btn.getAttribute('data-usu-estado');
        const usuEstadoInput = modal_actualizar_usuario.querySelector('#usuestado');
        usuEstadoInput.value = usuestado;
        modal_actualizar_usuario.classList.add('active');
    });
});
