import { Directive, Input } from '@angular/core';
import { Validator, NG_VALIDATORS, AbstractControl, ValidatorFn } from '@angular/forms';

export function passwordValidator(validatorRegEx: RegExp): ValidatorFn {
  return (control: AbstractControl): {[key: string]: any} | null => {
    const validator = validatorRegEx.test(control.value);
    console.log("In passwordValidator function" + validator);
    return validator ? {validator: {value: control.value}} : null;
  };
}

@Directive({
  selector: '[appPasswordValidator]',
  providers: [{provide: NG_VALIDATORS, useExisting: PasswordValidatorDirective, multi: true}]
})
export class PasswordValidatorDirective implements Validator {

  constructor() { }

  @Input('appPasswordValidator') passValidator: string;

  validate(control: AbstractControl): {[key: string]: any} | null {
    console.log("passValidator "+this.passValidator);
    console.log(passwordValidator(new RegExp('^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)” + “(?=.*[-+_!@#$%^&*., ?]).+$'))(control));
    return this.passValidator ? passwordValidator(new RegExp('^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)” + “(?=.*[-+_!@#$%^&*., ?]).+$'))(control) : null;
  }

}
