import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import{LoginService} from '../services/login.service'

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
  isValidUser = true;
  user = {
    username: "",
    password: ""
  }

  constructor(private loginService: LoginService, private router: Router) { }

  ngOnInit() {
  }

  onSubmit(){
    this.loginService.isValidUser(this.user).subscribe(
      response => {
        this.isValidUser = Boolean(response);
        if(this.isValidUser){
          this.router.navigateByUrl('/my-account');
        }
      }
    );
    
  }

}
