import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class HttpService {

  url: string = 'http://localhost:8080/'


  constructor(private http:HttpClient) { }
}
