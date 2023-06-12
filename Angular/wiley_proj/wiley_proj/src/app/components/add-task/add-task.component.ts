import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { Subscription } from 'rxjs';
import { UiService } from 'src/app/service/ui.service';
import { Task } from 'src/app/Task';
import { Router } from '@angular/router';

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

  @Output() onAddTask:EventEmitter<Task> = new EventEmitter();

  constructor(private uiService: UiService, private router: Router) { 
      this.subScription = this.uiService
                              .onToggle()
                              .subscribe((value) => {
                                this.showAddTask=value
                              })
   }

  ngOnInit(): void {
  }

  onSubmit(){
    const newTask = {
      text: this.text,
      day: this.day,
      reminder: this.reminder
    }
    this.onAddTask.emit(newTask);
    this.text = '';
    this.day='';
    this.reminder = false;
    this.router.navigate(['/'])
  }
}
