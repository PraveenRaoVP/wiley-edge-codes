import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { AppRoutingModule } from './app-routing.module';
import { RouterModule, Routes } from '@angular/router';
import { AppComponent } from './app.component';

import { HeaderComponent } from './components/header/header.component';
import { FooterComponent } from './components/footer/footer.component';

import { AboutComponent } from './components/about/about.component';
import { TasksComponent } from './components/tasks/tasks.component';
import { TaskItemComponent } from './components/task-item/task-item.component';
import { AddTaskComponent } from './components/add-task/add-task.component';
import { ButtonComponent } from './components/button/button.component';

// const appRoutes: Routes = [
//   {path:'', component: TasksComponent},
//   {path:'about', component: AboutComponent},
// ]

// const appRoutes: Routes = [
//   {path:'', component: WelcomeComponent},
//   {path: 'welcome', redirectTo:'welcome', pathMatch:'full'},
//   //{path: 'products', component: ProductsComponent}
// //  {path: '**', component: PageNotFoundComponent},
// ]

@NgModule({
  declarations: [
    AppComponent,
    AboutComponent,
    AddTaskComponent,
    HeaderComponent,
    FooterComponent,
    AboutComponent,
    TasksComponent,
    TaskItemComponent,
    AddTaskComponent,
    ButtonComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    AppRoutingModule,
    FontAwesomeModule,
    // RouterModule.forRoot(appRoutes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }