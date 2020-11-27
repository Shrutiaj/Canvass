import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';

import { PasswordValidatorDirective } from '../directives/password-validator.directive'

@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.scss']
})
export class SignUpComponent implements OnInit {
  signupForm;
  user = {
    username: "",
    password: "",
    confirmpassword: "",
    fullname: "",
    phonenumber: "",
    profilesummary: ""
  }
  constructor() { }

  ngOnInit() {
    
  }

  onSubmit(){
    console.log(this.signupForm.value);

  }

}
