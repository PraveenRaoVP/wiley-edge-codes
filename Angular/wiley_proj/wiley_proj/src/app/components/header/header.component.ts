import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UiService } from 'src/app/service/ui.service';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  title="Task Management";
  showAddTask: boolean = false;
  subScription?: Subscription
  
  constructor(private router: Router, private uiService: UiService) {
    this.subScription = this.uiService
                            .onToggle()
                            .subscribe(
                              (value) => {
                                this.showAddTask = value;
                              }
                            )
  }

  ngOnInit(): void {
  }

  toggleTask(){
    console.log("Toggle from header")
    this.uiService.toggleAddTask();
  }

  hasRoute(route: String){
    return this.router.url===route
  }

}
