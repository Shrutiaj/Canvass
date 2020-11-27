import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private http: HttpClient) { }

  isValidUser(credentials){
    const body = JSON.stringify(credentials);
    const httpOptions ={
      headers: new HttpHeaders({
        "Content-Type" : "appliction/json"
      })
    };
    return this.http.post("http://localhost:8080/Survey/user/isValid", body,httpOptions).pipe(
      map(response => {
        console.log(response);
        return response;
      },
      error => console.log(error)
    ))
  }

}
