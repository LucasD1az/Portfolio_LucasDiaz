import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Education } from '../model/education';

@Injectable({
  providedIn: 'root'
})
export class EducationService {
  URL = environment.URL + 'educacion/';

  constructor(private HttpClient: HttpClient) { }

  public lista(): Observable<Education[]>{ // <Education[]> is a type assertion
    return this.HttpClient.get<Education[]>(this.URL+'lista');
  }

  public detail(id: number): Observable<Education>{
    return this.HttpClient.get<Education>(this.URL+`detail/${id}`);
  }

  public save(education: Education): Observable<any>{
    return this.HttpClient.post<any>(this.URL+'create', education);
  }

  public update(id: number, education: Education): Observable<any>{
    return this.HttpClient.put<any>(this.URL+`update/${id}`, education);
  }

  public delete(id: number): Observable<any>{
    return this.HttpClient.delete<any>(this.URL+`delete/${id}`);
  }
}
