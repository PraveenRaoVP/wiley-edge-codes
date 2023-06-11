import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-parent',
  templateUrl: './parent.component.html',
  styleUrls: ['./parent.component.css']
})
export class ParentComponent implements OnInit {

  constructor() { }
  message= "Hello"

  ngOnInit(): void {
  }
  receivedMessage: string="";
  receiveMessage(newMessage: any){
    this.receivedMessage = newMessage;
  }

}
