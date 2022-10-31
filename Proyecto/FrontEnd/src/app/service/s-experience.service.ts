import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Experience } from '../model/experience';

@Injectable({
  providedIn: 'root'
})
export class SExperienceService {
  expURL = environment.URL + 'exp/';
  constructor(private HttpClient: HttpClient) { }

  public lista(): Observable<Experience[]>{
    return this.HttpClient.get<Experience[]>(this.expURL+'lista');
  }

  public detail(id: number): Observable<Experience>{
    return this.HttpClient.get<Experience>(this.expURL+`detail/${id}`);
  }

  public save(experience: Experience): Observable<any>{
    return this.HttpClient.post<any>(this.expURL+'create', experience);
  }

  public update(id: number, experience: Experience): Observable<any>{
    return this.HttpClient.put<any>(this.expURL+`update/${id}`, experience);
  }

  public delete(id: number): Observable<any>{
    return this.HttpClient.delete<any>(this.expURL+`delete/${id}`);
  }
}
