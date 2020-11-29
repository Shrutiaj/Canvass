import { Directive, Input } from '@angular/core';
import { Validator, NG_VALIDATORS, AbstractControl } from '@angular/forms';

@Directive({
  selector: '[appPasswordValidator]',
  providers: [{provide: NG_VALIDATORS, useExisting: PasswordValidatorDirective, multi: true}]
})
export class PasswordValidatorDirective implements Validator {

  passValidator = {
    hasNoSpaces: "",
    hasMin8Chars : "",
    hasUpperCaseLetter: "",
    hasSpecialChar: "",
    hasNumber: "",
    isValid: true
  };

  constructor() { }

  validate(control: AbstractControl): {[key: string]: any} | null {   
    this.passValidator = {
      hasNoSpaces: "",
      hasMin8Chars : "",
      hasUpperCaseLetter: "",
      hasSpecialChar: "",
      hasNumber: "",
      isValid: true
    };
    let controlValue = control.value ? control.value.length : 0;
    if(!(new RegExp('\s').test(control.value))){
      this.passValidator.isValid = false;
      this.passValidator.hasNoSpaces = "Should not contain spaces";
    }
    if(controlValue < 8){
      this.passValidator.isValid = false;
      this.passValidator.hasMin8Chars = "Must contain 8 or more characters";
    }
    if(!new RegExp('([A-Z]+)').test(control.value)){
      this.passValidator.isValid = false;
      this.passValidator.hasUpperCaseLetter = "Must contain at least one upper case letter";
    }
    if(!new RegExp('([^A-z0-9\s]+)').test(control.value)){
      this.passValidator.isValid = false;
      this.passValidator.hasSpecialChar = "Must contain at least one special character";
    }
    if(!new RegExp('([0-9]+)').test(control.value)){
      this.passValidator.isValid = false;
      this.passValidator.hasNumber = "Must contain at least one number";
    }
    if(!this.passValidator.isValid){
      return {
        passValidator:{
          errMsg: this.passValidator
        }
      };
    }
    return null;
  }

}
