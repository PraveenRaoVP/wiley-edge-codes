import { Component } from "@angular/core";
import { Book } from "./students";
import { Books } from "./mock-students";

@Component({
    selector: "app-welcome",
    templateUrl: "./welcome.component.html",
    styleUrls: ["./welcome.component.css"]
})


export class WelcomeModule{
    message="Hello, Welcome to wiley";

    books = Books

    selectedBook?: Book;

    onSelect(book: Book): void {
        this.selectedBook=book;
    }
}