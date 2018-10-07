

document.getElementById("allUsersComplete").addEventListener("click", AllClickComplete);
document.getElementById("allUsersContact").addEventListener("click", AllClickContact);
document.getElementById("specificUserComplete").addEventListener("click", SpecificClickComplete);
document.getElementById("specificUserContact").addEventListener("click", SpecificClickContact);

function SpecificClickComplete() {
    var userList = "";
    fetch('http://localhost:8084/CA-2/api/person/complete/' + document.getElementById('userID').value)
            .then(function (response) {
                return response.json();
            })
            .then(function (data) {
                document.getElementById('container').innerHTML = ('<div> Id:' + data.id + '</div>')
                document.getElementById('container').innerHTML += ('<div> mail:' + data.mail + '</div>')
                document.getElementById('container').innerHTML += ('<div> Name: ' + data.fname + ' ' + data.lname + '</div>')
                document.getElementById('container').innerHTML += ('<div> Phone:' + data.phone + '</div>')
                document.getElementById('container').innerHTML += ('<p></p><b>Hobby</b>')
                document.getElementById('container').innerHTML += ('<div> HobbyID: ' + data.hobby.id + '</div>')
                document.getElementById('container').innerHTML += ('<div> Hobby Name: ' + data.hobby.name + '</div>')
                document.getElementById('container').innerHTML += ('<div> Hobby Description: ' + data.hobby.discription + '</div>')
            });
}
function SpecificClickContact() {
    var userList = "";
    fetch('http://localhost:8084/CA-2/api/person/contact/' + document.getElementById('userID').value)
            .then(function (response) {
                return response.json();
            })
            .then(function (data) {
                document.getElementById('container').innerHTML = ('<div> Id:' + data.id + '</div>')
                document.getElementById('container').innerHTML += ('<div> mail:' + data.mail + '</div>')
                document.getElementById('container').innerHTML += ('<div> Name: ' + data.fname + ' ' + data.lname + '</div>')
                document.getElementById('container').innerHTML += ('<div> Phone:' + data.phone + '</div>')
            });
}
function AllClickComplete() {
    var list;
    fetch('http://localhost:8084/CA-2/api/person/complete')
            .then(function (response) {
                return response.json();
            })
            .then(function (data) {
                document.getElementById('container').innerHTML = ('<table id = Table><th>ID</th><th>Mail</th><th>Name</th><th>Phone</th><th>HobbyID</th><th>Hobby Name</th><th>Hobby Description</th>')
                for (var i = 0; i < data.length; i++) {
                    document.getElementById('Table').innerHTML += ('<tr><td> ' + data[i].id + '</td><td> ' + data[i].mail + '</td><td> ' + data[i].fname + ' ' + data.lname + '</td><td> ' + data[i].phone + '</td><td> ' + data[i].hobby.id + '</td><td> ' + data[i].hobby.name + '</td><td> ' + data[i].hobby.discription + '</td></tr>')
                }
            });
}
function AllClickContact() {
    var list;
    fetch('http://localhost:8084/CA-2/api/person/contact')
            .then(function (response) {
                return response.json();
            })
            .then(function (data) {
                document.getElementById('list').innerHTML = ('<table id = Table><th>ID</th><th>Mail</th><th>Name</th><th>Phone</th>')
                for (var i = 0; i < data.length; i++) {
                    document.getElementById('userTable').innerHTML += ('<tr><td> ' + data[i].id + '</td><td> ' + data[i].mail + '</td><td> ' + data[i].fname + ' ' + data.lname + '</td><td> ' + data[i].phone + '</td></tr>')
                }
            });
}

