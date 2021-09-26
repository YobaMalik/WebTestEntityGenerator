function getOnePerson() {
    var dicClass = document.getElementById("OnePerson");
    fetch("GetOnePerson", {
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
    fetch("GetAllFromDB", {
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
    fetch("GetMaxId", {
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

function findByContaining() {
    var dicClass = document.getElementById("onchangeTest");
    var message = document.getElementById("message_id").value;
    fetch("FindByContaining", {
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

function UpdateEntity() {
    var message = document.getElementById("phone_id").value;
    fetch("UpdateEntity", {
           method: 'post',
                  headers: { 'Content-Type': 'application/json' },
                  body: JSON.stringify({
                     message:message
                  })
              }).then(function (response) {

                                  }
                        );

                 }

function zulul() {
    var password = document.getElementById("password").value;
    var userName = document.getElementById("userName").value;
    fetch("zulul", {
        method: 'post',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({
            password:password,
            userName:userName
        })
        }).then(function (response) {
document.getElementById("request_reg").innerHTML="удача блин";
}
);
}