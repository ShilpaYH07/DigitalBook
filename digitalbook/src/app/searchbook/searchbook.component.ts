import { Component, OnInit } from '@angular/core';
import { BookService } from '../book.service';
import { SearchresultComponent } from '../searchresult/searchresult.component';

@Component({
  selector: 'app-searchbook',
  templateUrl: './searchbook.component.html',
  styleUrls: ['./searchbook.component.css']
})
export class SearchbookComponent implements OnInit {
  category?:String;
  author?:String;
  title?:String;
  publisher?:String;

  null?:String;
  result:any;
  resultbooks:any;

  constructor(private service:BookService) { }

  ngOnInit(): void {
  }
  search(){
    console.log( this.category+' '+this.author+' '+this.title+" "+this.publisher);
    console.log('inside search()');
    if(this.category!=null && this.category!=undefined && this.category!=''){
     this.service.searchBooksBycategory(this.category).subscribe(data => this.result = data);
      console.log('inside searchbycategory');
    }
    else if(this.title!=null && this.title!=undefined && this.title!=''){
     this.service.searchBooksByTitle(this.title).subscribe(data => this.result = data);
      console.log('inside searchbytitle '+this.title);
    }
    else if(this.author!=null && this.author!=undefined && this.author!=''){
      this.service.searchBooksByAuthor(this.author).subscribe(data => this.result = data);
      console.log('inside searchbyauthor');
    }
    else if(this.publisher!=null && this.publisher!=undefined && this.publisher!=''){
      this.service.searchBooksByPublisher(this.publisher).subscribe(data => this.result = data);
      console.log('inside searchbypublisher');
    }
    else{
      this.null='Enter any one field';
      alert('enter any field');
    }
    console.log(this.result);

  }

  getResult(){
    console.log(this.result);
    return this.result;
  }

}
