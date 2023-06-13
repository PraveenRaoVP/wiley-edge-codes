import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { TaskService } from 'src/app/service/task.service';
import { Task } from 'src/app/Task';
import { Location } from '@angular/common';

@Component({
  selector: 'app-task-details',
  templateUrl: './task-details.component.html',
  styleUrls: ['./task-details.component.css'],
})
export class TaskDetailsComponent implements OnInit {

  task?: Task;

  constructor(private route: ActivatedRoute, private taskService: TaskService, private location: Location) { }

  ngOnInit(): void {
    this.getTaskById();
  }

  getTaskById(): void{
    const id = Number(this.route.snapshot.paramMap.get('id'));
    this.taskService.getTaskById(id).subscribe((task) => {this.task = task})
  }

  redirectToMain(): void{
    this.location.back();
  }
}
