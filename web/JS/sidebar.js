/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
// seleccionar todos los elementos "a" en la barra lateral
const links = document.querySelectorAll('aside .sidebar a');

// recorrer todos los elementos "a"
links.forEach(link => {
  // comparar la URL actual con el atributo "href" de cada enlace
  if (link.href === window.location.href) {
    // agregar la clase "active" al enlace correspondiente a la página actual
    link.classList.add('active');
  }
});


