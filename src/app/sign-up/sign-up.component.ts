import { Component, DoCheck, OnChanges, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { SignupService } from '../services/signup.service';

@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.scss']
})
export class SignUpComponent implements OnInit {
  
  user = {
    userName: "",
    password: "",
    custID: 1,
    roleID: 1,
    userDetail:{
      fullName: "",
      phoneNumber: "",
      userSummary: ""
    }
  }
  confirmPassword = "";
  confirmPasswordError : boolean = false;
  constructor(private signUpService: SignupService) { }

  ngOnInit() {
    
  }

  onBlur(){
    if(this.user.password !== this.confirmPassword){
      this.confirmPasswordError = true;
    }
    else{
      this.confirmPasswordError = false;
    }
  }

  onSubmit(){
    this.signUpService.createUser(this.user).subscribe(
      response => console.log(response),
      error => console.log(error)
    );
    console.log(this.user);

  }

}
