
window.onload=()=>{


}

function borrar(idtask){
    var baseUrl = window.location.protocol + "//" + window.location.host + "/taskWeb_war_exploded/api?idtask="+idtask;

    fetch(baseUrl, {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json',
            //'Content-Type':'text',
        },
    })
        .then(response => response.json())
        .then(data => {
            let tbody= "";
            for (const task of data) {
                tbody+= `<tr><td>${task.idtask}</td><td>${task.title}</td><td>${task.description}</td><td></td><td></td><td>><i class="fa-solid fa-pen-to-square"></i>
                                <i onclick="borrar(${task.idtask})" class="fa-solid fa-trash"></i></td>`;

            }
            document.getElementById("tableTask").innerHTML=tbody;
            console.log(data);
        })
        .catch(error => {
            console.error('Error:', error);
        });



}
