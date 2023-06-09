import { Component } from "@angular/core";
import { Books } from "./students";
import { Book } from "./mock-students";

@Component({
    selector: "app-welcome",
    templateUrl: "./welcome.component.html",
    styleUrls: ["./welcome.component.css"]
})


export class WelcomeModule{
    message="Hello, Welcome to wiley";

    books = Book
}