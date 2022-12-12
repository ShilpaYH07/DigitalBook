import { Component, OnInit } from '@angular/core';
import { BookService } from '../book.service';
import { RegisterUser } from '../registeruser';
import { User } from '../user';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {
  user:RegisterUser=new RegisterUser();
  constructor(private service:BookService) { }

  ngOnInit(): void {
  }

  signup(){
    this.service.RegisterUser(this.user).subscribe();
  }

}
