import { Component, OnInit, Input, EventEmitter, Output } from '@angular/core';

@Component({
  selector: 'app-child',
  templateUrl: './child.component.html',
  styleUrls: ['./child.component.css']
})
export class ChildComponent implements OnInit {
  childMessage="Hello Parent"

  @Input() message="";

  constructor() { }

  @Output() sendEvent = new EventEmitter<String>()

  sendMessage(){
    this.sendEvent.emit(this.childMessage);
  }

  ngOnInit(): void {

  }

}
