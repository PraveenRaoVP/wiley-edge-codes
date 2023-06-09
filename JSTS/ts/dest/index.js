"use strict";
let id = 123;
let company = "Wiley";
let isPublished = true;
let x;
let studentIds = [1, 2, 3, 4, 5, 6];
studentIds.push(19);
console.log(studentIds);
let person = [1, "Praveen", true];
let employees;
employees = [
    [1, "Praveen"],
    [2, "Anonymous"]
];
let empId;
empId = "venkat";
var Directions;
(function (Directions) {
    Directions[Directions["Up"] = 0] = "Up";
    Directions[Directions["Down"] = 1] = "Down";
    Directions[Directions["Left"] = 2] = "Left";
    Directions[Directions["Right"] = 3] = "Right";
})(Directions || (Directions = {}));
const studentOne = {
    id: 1,
    name: "Praveen"
};
let sid = 1;
let eid = sid;
console.log(eid);
const calcTotal = (x, y) => {
    return x + y;
};
console.log(calcTotal(1, 2));
const sendMessage = (message) => {
    console.log("Hello");
};
sendMessage("Hi");
const student1 = {
    id: 1,
    name: "Praveen"
};
const addFunc = (x, y) => {
    return x + y;
};
const subFunc = (x, y) => {
    return x - y;
};
class Employee {
    constructor(id, name) {
        this.id = id;
        this.name = name;
    }
    register() {
        return `${this.name} registered successfully`;
    }
}
const emp = new Employee(1, "Praveen");
const emp2 = new Employee(2, "Anonymous");
console.log(emp.register());
class Manager extends Employee {
    constructor(id, name, position) {
        super(id, name);
        this.position = position;
    }
}
const manager = new Manager(1, "Praveen", "CEO");
console.log(manager.register());
function getData(items) {
    return new Array().concat(items);
}
let numberData = getData([1, 2, 3, 4]);
let skills = getData(["Java", "JS"]);
numberData.push(1);
