import { Component, OnInit } from '@angular/core';
import { Book } from '../book';
import { BookService } from '../book.service';

@Component({
  selector: 'app-allsubscribedlist',
  templateUrl: './allsubscribedlist.component.html',
  styleUrls: ['./allsubscribedlist.component.css']
})
export class AllsubscribedlistComponent implements OnInit {
books:any;
  constructor(private service:BookService) { }

  ngOnInit(): void {
    this.service.getAllSubscribeBooks().subscribe(data => this.books=data);
  }
  unsubscribe(id:any){
    this.service.cancelSubscribeBook(id).subscribe();
    this.ngOnInit();
  }

}
