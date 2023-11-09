(function(){
    'use strict'
     var changeMenu = document.getElementById('changeMenu'); 
     var menuContainer = document.getElementById('menuContainer');
     
     //Função para aparecer e sumir menu: 
     changeMenu.addEventListener('click', function(){
       menuContainer.classList.toggle('toggleMenu'); 
        //trocar icones:
       changeMenu.classList.toggle('icon-hamburger_menu_navigation_navbar_icon');
       changeMenu.classList.toggle('icon-circle_x_icon');
     })


     var itemMenu = document.getElementsByClassName('menu-items-link');

     var x = 0;

  while(itemMenu[x]){
   itemMenu[x].addEventListener('click', function(){
     menuContainer.classList.remove('toggleMenu');
     //trocar icones:
     changeMenu.classList.toggle('icon-circle_x_icon');
     changeMenu.classList.toggle('icon-hamburger_menu_navigation_navbar_icon');
   })
   x++
 }
})()
