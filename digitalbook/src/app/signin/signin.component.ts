import { NgFor } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { BookService } from '../book.service';
import { LoginReponce } from '../LoginResponce';
import { LoginUser } from '../loginuser';
import { User } from '../user';

@Component({
  selector: 'app-signin',
  templateUrl: './signin.component.html',
  styleUrls: ['./signin.component.css']
})
export class SigninComponent implements OnInit {
  // user:User=new User();
  // res?:any;
  username?:any;
  password?:any;
  role?:number;
  user?:any;
  constructor(private bookservice:BookService, private router:Router) { }

  ngOnInit(): void {

  }
  login(){
    // console.log(this.user);
    // this.bookservice.LoginUser(this.user).subscribe(data => this.res = data);
    // console.log(this.res);

    // this.bookservice.asignusernamepass(this.username, this.password);
    // this.login();
    
  
    
  }

}
