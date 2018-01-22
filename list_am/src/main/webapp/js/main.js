$(document).ready(function () {

});

function onClickTextBox() {
    document.getElementById("textBox").type = "password";
}

function onClickUsers() {

    ajax_get("https://reqres.in/api/users/2", renderContent)

}

function renderContent(data) {
    var user = data["data"];
    console.log("user" + user);

    var i, td, text;
    var tr = document.createElement("tr");
    for(var key in user) {
        text = document.createTextNode(user[key]);
        td = document.createElement("td");
        td.appendChild(text);
        td.setAttribute("style", "padding-left: 5px");
        tr.appendChild(td);
    }
    var table = document.createElement("table");
    var content = document.getElementById("content");
    table.appendChild(tr);
    content.appendChild(table);

    // document.getElementById("content").innerHTML = data;
}

function ajax_get(url, callback) {
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4 && xhr.status === 200) {
            console.log("responseText: " + xhr.responseText);
            try {
                var data = JSON.parse(xhr.responseText);
            } catch(err) {
                console.log(err.message + " in " + xhr.responseText);
                return;
            }
            callback(data);
        }
    };
    xhr.open("GET",url, true);
    xhr.send();
}