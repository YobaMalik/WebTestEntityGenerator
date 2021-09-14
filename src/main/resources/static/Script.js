function test() {
    var dicClass = document.getElementById("TPTC");
    fetch("test123", {
           method: 'post',
           headers: { 'Content-Type': 'application/json' }
       }).then(function (response) {
                 response.json().then(function (data) {
                    dicClass.innerHTML = data["firstName"] + " " +
                    data["middleName"] + " " + data["lastName"] + " " + data["phoneNumber"];
                    });
                 }
       );
}

function tes() {
    var dicClass = document.getElementById("TPTC");
    fetch("test", {
           method: 'post',
           headers: { 'Content-Type': 'application/json' }
       }).then(function (response) {
                 response.json().then(function (data) {
                    var entities = new Array();
                    for (var value of data){
                    entities.push(value["firstName"] + " " +
                                                    value["middleName"] + " " + value["lastName"] + " " + value["phoneNumber"]);
                    }
                    dicClass.innerHTML = "<p>" + entities.join("</p><p>") + "</p>";
                    });
                 }
       );

}


function maxId() {
    var dicClass = document.getElementById("MaxIdValue");
    fetch("getMaxId", {
           method: 'post',
           headers: { 'Content-Type': 'application/json' }
       }).then(function (response) {
                 response.json().then(function (data) {
                    dicClass.innerHTML = data;
                    });
                 }
       );
}