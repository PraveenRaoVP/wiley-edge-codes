class User{
    constructor(name){
        this.name = name
    }

    sayHi = () => {
        console.log("Hello"+this.name)
    }
}

let userOne = new User("Praveen")
userOne.sayHi();