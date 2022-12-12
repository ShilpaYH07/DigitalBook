import { Component, OnInit } from '@angular/core';
import { RouterLink } from '@angular/router';
import { Book } from '../book';
import { BookService } from '../book.service';

@Component({
  selector: 'app-createbook',
  templateUrl: './createbook.component.html',
  styleUrls: ['./createbook.component.css']
})
export class CreatebookComponent implements OnInit {

  book:Book = new Book();
  constructor(private  service:BookService) { }

  ngOnInit(): void {
  }

  savebook(){
    console.log(this.book)
    console.log('inside createbook ts');
    return this.service.saveDigitalBook(this.book).subscribe();
  }

}
