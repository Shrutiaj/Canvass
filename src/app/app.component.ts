import { AfterViewChecked, AfterViewInit, Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {
  title = 'Canvass';
  loggedInUser = sessionStorage.getItem('userName');

  constructor(){

  }

  ngOnInit(){
    console.log(this.loggedInUser);
  }

  // ngAfterViewInit(){
  //   console.log(this.loggedInUser);
  //   this.loggedInUser = sessionStorage.getItem('userName');
  // }

  // ngAfterViewChecked(){
  //   this.loggedInUser = sessionStorage.getItem('userName');
  //   console.log(this.loggedInUser);
  // }
}
