import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CreatebookComponent } from './createbook/createbook.component';
import { SearchbookComponent } from './searchbook/searchbook.component';
import { BookslistComponent } from './bookslist/bookslist.component';
import { SignupComponent } from './signup/signup.component';
import { SigninComponent } from './signin/signin.component';
import { NavbarauthorComponent } from './navbarauthor/navbarauthor.component';
import { NavbarbeforsigninComponent } from './navbarbeforsignin/navbarbeforsignin.component';
import { NavbaraftersigninComponent } from './navbaraftersignin/navbaraftersignin.component';
import { AllsubscribedlistComponent } from './allsubscribedlist/allsubscribedlist.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { SearchresultComponent } from './searchresult/searchresult.component';
import { AllbooklistComponent } from './allbooklist/allbooklist.component';

@NgModule({
  declarations: [
    AppComponent,
    CreatebookComponent,
    SearchbookComponent,
    BookslistComponent,
    SignupComponent,
    SigninComponent,
    NavbarauthorComponent,
    NavbarbeforsigninComponent,
    NavbaraftersigninComponent,
    AllsubscribedlistComponent,
    SearchresultComponent,
    AllbooklistComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
