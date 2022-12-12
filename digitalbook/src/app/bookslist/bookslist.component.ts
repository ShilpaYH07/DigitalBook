import { Component, OnInit } from '@angular/core';
import { BookService } from '../book.service';

@Component({
  selector: 'app-bookslist',
  templateUrl: './bookslist.component.html',
  styleUrls: ['./bookslist.component.css']
})
export class BookslistComponent implements OnInit {
  books:any;
  constructor(private service:BookService) { }

  ngOnInit(): void {
    this.service.getAllBooks().subscribe(data => this.books=data);
  }

}
