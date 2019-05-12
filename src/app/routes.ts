import { AddStudentComponent } from './add-student/add-student.component';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { Routes } from '@angular/router';

export const appRoutes: Routes = [
    {path: 'home', component: HomeComponent},
    {path: 'login', component: LoginComponent},
    {path: 'add-student', component: AddStudentComponent},
    {path: '**', redirectTo: 'login', pathMatch: 'full'}
];
