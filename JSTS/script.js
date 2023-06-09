var person = {
    name: "Praveen",
    address: {
        street: "PKS",
        city: "Chennai"
    },
    skills: ['java','angular']
}

var dEl = document.createElement("div");
var textNode = document.createTextNode("Welcome to Wileyyyyyy");
dEl.appendChild(textNode);
dEl.setAttribute("id","data");
var message="hi all"
dEl.innerHTML = `<p>New data ${message} here </p>`
document.body.appendChild(dEl);
