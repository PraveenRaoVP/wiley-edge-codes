import { Component, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { UiService } from 'src/app/service/ui.service';

@Component({
  selector: 'app-add-task',
  templateUrl: './add-task.component.html',
  styleUrls: ['./add-task.component.css']
})
export class AddTaskComponent implements OnInit {

  text: string = '';
  day: string = '';
  reminder: boolean = false;

  showAddTask ?: boolean;

  subScription?: Subscription;

  constructor(private uiService: UiService) { 
      this.subScription = this.uiService
                              .onToggle()
                              .subscribe((value) => {
                                this.showAddTask=value
                              })
   }

  ngOnInit(): void {
  }

  onSubmit(){
    const newTask = {}
    
  }
}
