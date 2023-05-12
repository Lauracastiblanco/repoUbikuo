const openPopupBtnsModal1 = document.querySelectorAll('.open-popup[data-popup="popup1"]');
const closePopupBtns = document.querySelectorAll('.cancelarbtn');
const openPopupBtnsModal2 = document.querySelectorAll('.actualizar-rol');
const modal_actualizar_rol = document.querySelector('.actualizar-popup');

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
        const id_Rol = btn.getAttribute('data-rol-id');
        const rolIdInput = modal_actualizar_rol.querySelector('#id_Rol');
        rolIdInput.value = id_Rol ;
        /*
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
        const usuemail = btn.getAttribute('data-usu-email');
        const usuEmailInput = modal_actualizar_usuario.querySelector('#usuemail');
        usuEmailInput.value = usuemail;
        modal_actualizar_usuario.classList.add('active');
        //password
        const usupassword = btn.getAttribute('data-usu-password');
        const usuPasswordInput = modal_actualizar_usuario.querySelector('#usupassword');
        usuPasswordInput.value = usupassword;
        modal_actualizar_usuario.classList.add('active');*/
    });
});


