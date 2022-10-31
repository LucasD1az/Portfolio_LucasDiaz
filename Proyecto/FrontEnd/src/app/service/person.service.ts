import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Person } from '../model/person.model';

@Injectable({
  providedIn: 'root'
})
export class PersonService {
  URL = environment.URL + 'personas/';
  constructor(private httpClient: HttpClient) { }

  public getPerson(): Observable<Person>{
    return this.httpClient.get<Person>(this.URL+'traer/perfil');
  }

  public lista(): Observable<Person[]>{ // <Education[]> is a type assertion
    return this.httpClient.get<Person[]>(this.URL+'lista');
  }

  public detail(id: number): Observable<Person>{
    return this.httpClient.get<Person>(this.URL+`detail/${id}`);
  }
/*
  public save(education: Education): Observable<any>{
    return this.HttpClient.post<any>(this.URL+'create', education);
  }
*/
  public update(id: number, person: Person): Observable<any>{
    return this.httpClient.put<any>(this.URL+`update/${id}`, person);
  }
/*
  public delete(id: number): Observable<any>{
    return this.HttpClient.delete<any>(this.URL+`delete/${id}`);
  }
*/
}
