import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class SignupService {

  constructor(private httpClient: HttpClient) { }

  createUser(user){
    const body = JSON.stringify(user);
    const httpOptions = {
      headers: new HttpHeaders({
        "Access-Control-Allow-Origin": "*",
        "Content-Type": "appliction/json"
      })
    }
    return this.httpClient.post("http://localhost:8080/User/createUser", body, httpOptions).
    pipe(
      map(repsonse =>
        {
          console.log("CreateUser:: " + repsonse);
        },
        error => console.log(error)
      )
    );
  }
}
