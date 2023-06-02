const searchWrapper = document.querySelector(".search-field");
const inputBox = searchWrapper.querySelector("input");
const suggBox = searchWrapper.querySelector(".autocom-box");
const icon = searchWrapper.querySelector(".icon");

var tener =RegExp("QUE|CUALES|COMO|DIFERENCIA|QUIEN");
var cadena;
var clave =RegExp("ORDENAMIENTO|METODO");
var p;


inputBox.onkeyup = (e)=>{
    let userData = e.target.value; 
    let emptyArray = [];
    if(userData){


        icon.onclick = ()=>{ 
            nrespuesta(userData);
        }
        emptyArray = suggestions.filter((data)=>{

            return data.toLocaleLowerCase().startsWith(userData.toLocaleLowerCase());
        });
        emptyArray = emptyArray.map((data)=>{
            
            return data = `<li>${data}</li>`;
        });
        searchWrapper.classList.add("active"); 
        showSuggestions(emptyArray);
        let allList = suggBox.querySelectorAll("li");
        for (let i = 0; i < allList.length; i++) {
            
            allList[i].setAttribute("onclick", "select(this)");
        }
    }else{
        searchWrapper.classList.remove("active");
    }
}


function select(element){
    let selectData = element.textContent;
    inputBox.value = selectData;
    icon.onclick = ()=>{
        nrespuesta(selectData);
    }
    searchWrapper.classList.remove("active");
}


function showSuggestions(list){
    let listData;
    if(!list.length){
        userValue = inputBox.value;
        listData = `<li>${userValue}</li>`;
    }else{
      listData = list.join('');
    }
    suggBox.innerHTML = listData;
}

function nrespuesta(cadena){

    cadena = cadena.toUpperCase();
             
        if (cadena = "Que es el Ordenamiento") {
            mensaje = "El ordenamiento es una forma organizada y sistemática de poder alcanzar un determinado objetivo. Puede aplicarse a distintas áreas de estudio como las ciencias naturales , sociales o las matemáticas. El método se entiende entonces como una serie de pasos que se deben seguir para cumplir un objetivo.";
        }
        else if(cadena = "Que es un metodo") {
            mensaje = "El método es una forma organizada y sistemática de poder alcanzar un determinado objetivo. Puede aplicarse a distintas áreas de estudio como las ciencias naturales , sociales o las matemáticas. El método se entiende entonces como una serie de pasos que se deben seguir para cumplir un objetivo.";
        }   
    

    if (document.querySelector('#newtask input').value.length == 0) {
        const Toast = Swal.mixin({
            toast: true,
            position: 'top-end',
            showConfirmButton: false,
            timer: 3000,
            timerProgressBar: true,
            didOpen: (toast) => {
              toast.addEventListener('mouseenter', Swal.stopTimer)
              toast.addEventListener('mouseleave', Swal.resumeTimer)
            }
          })
          
          Toast.fire({
            icon: 'error',
            title: 'Pregunta no Ingresada.'
          })
    }else{
        document.querySelector('#tasks').innerHTML
      += `
      <div class="task">
         <span id="taskname">

            <strong>${cadena+":"}</strong>
            ${mensaje}
         </span>
        <button class="delete">
        <i class='bx bx-trash'></i>
        </button>
      </div>
      `;
      var current_tasks = document.querySelectorAll(".delete");
      for (var i =0; i < current_tasks.length; i++) {
          current_tasks[i].onclick = function(){
              this.parentNode.remove();
          }
          
      }

    }   
}
