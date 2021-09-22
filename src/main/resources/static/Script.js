function getOnePerson() {
    var dicClass = document.getElementById("OnePerson");
    fetch("getOnePerson", {
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

function getAllFromDB() {
    var dicClass = document.getElementById("Result");
    fetch("getAllFromDB", {
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

function createPeople() {
    var dicClass = document.getElementById("Result");
    fetch("getMaxId", {
           method: 'post',
           headers: { 'Content-Type': 'application/json' }
       }).then(function (response) {
               /*  response.json().then(function (data) {
                 alert(data);
                   // dicClass.innerHTML = "около 153 ебал создано";//JSON.stringify(data);
                    });
                    */
                 //   alert(response);
                 }
       );
}

function onchangeTest() {
    var dicClass = document.getElementById("onchangeTest");
    var message = document.getElementById("message_id").value;
    fetch("onсhangeTest", {
           method: 'post',
                  headers: { 'Content-Type': 'application/json' },
                  body: JSON.stringify({
                     message:message
                  })
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