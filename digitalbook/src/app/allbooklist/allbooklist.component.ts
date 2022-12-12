import { Component, OnInit } from '@angular/core';
import { BookService } from '../book.service';
import { Reader } from '../reader';

@Component({
  selector: 'app-allbooklist',
  templateUrl: './allbooklist.component.html',
  styleUrls: ['./allbooklist.component.css']
})
export class AllbooklistComponent implements OnInit {
  books:any;
  reader:Reader = new Reader();
  constructor(private service:BookService) { }

  ngOnInit(): void {
    this.service.getAllBooks().subscribe(data => this.books=data);
  }
  
  subscribe(id:any){
    this.reader.bookId=id;
    this.reader.email = 'basaveshks@gmail.com';
    this.reader.userId = 1;
    this.service.saveSubscribeBook(this.reader).subscribe();
  }

}
