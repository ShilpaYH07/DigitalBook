import { Component, OnInit } from '@angular/core';
import { SearchbookComponent } from '../searchbook/searchbook.component';

@Component({
  selector: 'app-searchresult',
  templateUrl: './searchresult.component.html',
  styleUrls: ['./searchresult.component.css']
})
export class SearchresultComponent implements OnInit {
  resultbooks?:any;
  constructor(private search:SearchbookComponent) { }

  ngOnInit(): void {
    console.log('results onInit()'+this.resultbooks);
    this.resultbooks = this.search.getResult();
    console.log('results onInit()'+this.resultbooks);
  }
  showresult(){
    console.log('results showresult() '+this.resultbooks);
    this.resultbooks = this.search.getResult();
  }

}
