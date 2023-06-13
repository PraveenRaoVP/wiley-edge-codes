import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AboutComponent } from './components/about/about.component';
import { PlacementComponent } from './components/placement/placement.component';
import { ServicesComponent } from './components/services/services.component';
import { TrainingComponent } from './components/training/training.component';
import { ContactComponent } from './components/contact/contact.component';

const routes: Routes = [
  {
    path: "", component: AboutComponent
  },
  {
    path: "about", component: AboutComponent
  },
  {
    path: "contact", component: ContactComponent
  },
  {
    path: "services", component: ServicesComponent,
    children: [
      {
        path: "training", component: TrainingComponent
      },
      {
        path: "placement",component: PlacementComponent
      }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule { }
