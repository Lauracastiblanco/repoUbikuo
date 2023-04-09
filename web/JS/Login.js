/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 const inputs = document.querySelectorAll('.input');
 
 function focusFunc(){
     Let parent = this.parentNode.parentNode;
     parent.classList.add('focus');
 }
inputs.forEach(input => {
    input.addEvenListener('focus', focusFunc);
});