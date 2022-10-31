import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EditEducationComponent } from './components/education/edit-education.component';
import { NeweducationComponent } from './components/education/neweducation.component';
import { EditExperienceComponent } from './components/experience/edit-experience.component';
import { NewExperienceComponent } from './components/experience/new-experience.component';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';

const routes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'login', component: LoginComponent},
  {path: 'newexp', component: NewExperienceComponent},
  {path: 'editexp/:id', component: EditExperienceComponent},
  {path: 'newedu', component: NeweducationComponent},
  {path: 'editedu/:id', component: EditEducationComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
