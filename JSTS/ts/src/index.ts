let id: number = 123;
let company: String = "Wiley"
let isPublished: boolean = true
let x: any;

let studentIds: number[] = [1,2,3,4,5,6]
studentIds.push(19)
console.log(studentIds)

let person: [number, String, boolean] = [1, "Praveen", true]

let employees: [number, String][]
employees = [
    [1,"Praveen"],
    [2,"Anonymous"]
] 
let empId: string | number
empId="venkat"

enum Directions{
    Up, Down, Left, Right
}

type Student = {
    id: number,
    name: String,
    age?:number
}

const studentOne: Student ={
    id: 1,
    name: "Praveen"
}

let sid: any = 1;
let eid = sid;
console.log(eid);

const calcTotal = (x:number,y:number): number => {
    return x+y;
}
console.log(calcTotal(1,2))


const sendMessage = (message: string | number): void => {
    console.log("Hello")
}

sendMessage("Hi")

interface StudentInterface{
    readonly id: number,
    name: string,
    age?: number
}

const student1: StudentInterface = {
    id: 1,
    name: "Praveen"
}


interface calcFunc{
    (x: number, y: number): number
}

const addFunc: calcFunc = (x: number,y:number): number => {
    return x+y;
}
const subFunc: calcFunc = (x: number,y:number): number => {
    return x-y;
}

interface EmployeeInterface{
    id: number,
    name: String,
    register(): String
}

class Employee implements EmployeeInterface{
    id: number;
    name: String;
    constructor(id: number, name: String){
        this.id = id;
        this.name = name;
    }
    register(): String{
        return `${this.name} registered successfully`;
    }
}

const emp = new Employee(1,"Praveen");
const emp2 = new Employee(2, "Anonymous");
console.log(emp.register());

class Manager extends Employee{
    position: String;
    constructor(id: number, name: String, position: String){
        super(id,name);
        this.position = position;
    }
}

const manager = new Manager(1,"Praveen", "CEO");
console.log(manager.register());


function getData<T>(items: T[]): T[]{
    return new Array().concat(items);
}

let numberData = getData<number>([1,2,3,4]);
let skills = getData<String>(["Java", "JS"]);

numberData.push(1);
