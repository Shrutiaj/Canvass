import { Component, OnInit, Input } from '@angular/core';
import { Router } from '@angular/router';
import { AppComponent } from '../app.component';

import{LoginService} from '../services/login.service'

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
  
  isValidUser = true;
  @Input() loggenInUser;
  user = {
    userName: "",
    password: ""
  }

  constructor(private loginService: LoginService, private router: Router, private appComponent: AppComponent) { }

  ngOnInit() {
  }

  onSubmit(){
    this.loginService.isValidUser(this.user).subscribe(
      response => {
        this.isValidUser = Boolean(response);
        if(this.isValidUser){
          sessionStorage.setItem('userName', this.user.userName);
          this.appComponent.loggedInUser = sessionStorage.getItem('userName');
          this.router.navigateByUrl('/my-account');
        }
      }
    );
    
  }

}