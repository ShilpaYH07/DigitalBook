import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AllbooklistComponent } from './allbooklist/allbooklist.component';
import { AllsubscribedlistComponent } from './allsubscribedlist/allsubscribedlist.component';
import { BookslistComponent } from './bookslist/bookslist.component';
import { CreatebookComponent } from './createbook/createbook.component';
import { SearchbookComponent } from './searchbook/searchbook.component';
import { SigninComponent } from './signin/signin.component';
import { SignupComponent } from './signup/signup.component';

const routes: Routes = [
  {path:'createbook', component:CreatebookComponent},
  {path:'searchbook', component:SearchbookComponent},
  {path:'bookslist', component:BookslistComponent},
  {path:'signin', component:SigninComponent},
  {path:'signup', component:SignupComponent},
  {path:'', component:SigninComponent},
  {path:'allsubscribedlist', component:AllsubscribedlistComponent},
  {path:'allbooklist', component:AllbooklistComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
