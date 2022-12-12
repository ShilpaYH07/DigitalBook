import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Book } from './book';
import { LoginUser } from './loginuser';
import { Reader } from './reader';
import { User } from './user';

@Injectable({
  providedIn: 'root'
})
export class BookService {

  userName?:String;
  password?:String;
  constructor(private http:HttpClient) { }

  // reader signup constroller
  getUser(id:any){
    return this.http.get(`http://localhost:8300/${id}`);
  }
  createuser(user?:LoginUser):Observable<object>{//pending--html link
    return this.http.post<object>("http://localhost:8300/create", user);
  }
  getUserByNameAndPassword(user?:LoginUser):Observable<object>{
    return this.http.post<object>("http://localhost:8300/login", user);
  }
   // reader reader controller
   getData(id:any){//pending --html link
    return this.http.get(`http://localhost:8300/getData/${id}`);
   }
   getAllUser(){
    //const headers = new HttpHeaders({ Authorization: 'Basic ' + btoa(this.userName + ':' + this.password) });
    return this.http.get(`http://localhost:8304/getalluser/`);
   }
   getAllBooks(){//completed
    return this.http.get("http://localhost:8300/ getBooks");
   }
   searchBooks(){//pending
    return this.http.get("http://localhost:8300/searchBook");
   }
   searchBooksBycategory(cat:any){//completed
    console.log('inside book service title search category controll port 9000 '+ cat)
    return this.http.get(`http://localhost:8300/searchCategory/${cat}`);
   }
   searchBooksByAuthor(author:any){//completed
    console.log('inside book service author search reader controll port 9000 '+ author)
    return this.http.get(`http://localhost:8300/searchAuthor/${author}`);
   }
   searchBooksByPrice(price:any){//completed
    return this.http.get(`http://localhost:8300/searchPrice/${price}`);
   }
   searchBooksByTitle(title:any){//completed
    console.log('inside book service title search reader controll port 9000 '+ title)
    return this.http.get(`http://localhost:8300/searchTitle/${title}`);
   }
    searchBooksByPublisher(publisher:any){//completed
      console.log('inside book service publisher search reader controll port 9000 '+ publisher)
      return this.http.get(`http://localhost:8300/searchPublisher/${publisher}`);
    }
    saveSubscribeBook(read:Reader):Observable<object>{
        return this.http.post<object>("http://localhost:8300/subscribe", read);
    }
    getAllSubscribeBooks(){
    return this.http.get("http://localhost:8300/books");

        }
     cancelSubscribeBook(id:any){
    return this.http.get(`http://localhost:8300/cancelSubscribe/${id}`);
        }

        //signup controller

        RegisterUser(user?:User):Observable<object>{
          return this.http.post<object>("http://localhost:8304/signup", user);
        }
        LoginUser(user?:User):Observable<string>{
          let opt = {responseType: 'text' as 'text'}
          let res =  this.http.post("http://localhost:8304/login", user, opt);
          console.log(res);
          return res;
        }
        asignusernamepass(user:String, pass:string){
          this.userName = user;
          this.password = pass;

        }
        login(){
          const headers = new HttpHeaders({ Authorization: 'Basic ' + btoa(this.userName + ':' + this.password) });
          let res =  this.http.post("http://localhost:8304/login", {headers,responseType: 'text' as 'json'});
        }
        // BooksController

        saveDigitalBook(book?:Book):Observable<object>{//correct
          return this.http.post<object>("http://localhost:8303/savebook", book);
        }
        getAllBook(){
          return this.http.get("http://localhost:8303/books");
         }
         getBook(id:any){
          return this.http.get(`http://localhost:8303/book/${id}`);
         }
         getBookByAuthor(authorId:any){
          return this.http.get(`http://localhost:8303/book/author/${authorId}`);
         }
        updateBook(id:any){
          return this.http.get(`http://localhost:8303/update/${id}`);
         }
         deleteBook(id:any){
          return this.http.get(`http://localhost:8303/delete/${id}`);
         }
        searchBook(){ //pending
          return this.http.get("http://localhost:8303/search");
         }
         searchBookByTitle(title:any){
          console.log('inside book service titlesearch '+ title)
          return this.http.get(`http://localhost:8303/title/${title}`);
         }
         searchBooksByCategory(category:any){
          return this.http.get(`http://localhost:8303/category/${category}`);
         }
         searchBookByAuthor(author:any){
          return this.http.get(`http://localhost:8303/author/${author}`);
         }
         searchBookByPrice(price:any){
          return this.http.get(`http://localhost:8303/price/${price}`);
         }
         searchBookByPublisher(publisher:any){
          return this.http.get(`http://localhost:8303/publisher/${publisher}`);
         }
         getSubscribedData(id:any){
          return this.http.get(`http://localhost:8303/getSubscribe/${id}`);
         }
        }
