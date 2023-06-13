import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AboutComponent } from './components/about/about.component';
import { AddTaskComponent } from './components/add-task/add-task.component';
import { TaskDetailsComponent } from './components/tasks/task-details/task-details.component';
import { TasksComponent } from './components/tasks/tasks.component';

const appRoutes: Routes = [
  {path:'', component: TasksComponent},
  {path:'about', component: AboutComponent},
 // {path: 'add-task', component: AddTaskComponent}
  {path: 'task/:id', component: TaskDetailsComponent},
]

@NgModule({
  imports: [RouterModule.forRoot(appRoutes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
