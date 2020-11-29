import { Component, OnInit, Input, OnDestroy } from '@angular/core';
import { Router } from '@angular/router';
import { AppComponent } from '../app.component';

@Component({
  selector: 'app-sign-out',
  templateUrl: './sign-out.component.html',
  styleUrls: ['./sign-out.component.css']
})
export class SignOutComponent implements OnInit, OnDestroy {

  @Input() loggenInUser;
  constructor(private router: Router, private appComponent: AppComponent) { }

  ngOnInit(): void {
    sessionStorage.removeItem('userName');
    this.router.navigateByUrl('/home');
  }

  ngOnDestroy(){
    this.appComponent.loggedInUser = sessionStorage.getItem('userName');
  }

}
