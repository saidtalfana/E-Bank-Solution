import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  { path: 'customer', component: ShowFormComponent },
  { path: 'login', component: loginComponent },
  { path: '',   redirectTo: '/glycemie', pathMatch: 'full' },
  { path: '**', redirectTo: '/glycemie', pathMatch: 'full'}  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
