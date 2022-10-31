import { Component, OnInit } from '@angular/core';
import { Person } from 'src/app/model/person.model';
import { PersonService } from 'src/app/service/person.service';
import { TokenService } from 'src/app/service/token.service';

@Component({
  selector: 'app-abstract',
  templateUrl: './abstract.component.html',
  styleUrls: ['./abstract.component.css']
})
export class AbstractComponent implements OnInit {
  person: Person = null;

  constructor(public personService: PersonService,
    private tokenService: TokenService) { }
  isLogged=false;

  ngOnInit(): void {
    this.loadPerson();
    if(this.tokenService.getToken()){
      this.isLogged=true;
    } else {
      this.isLogged=false;
    }
  }

  loadPerson(): void {
    this.personService.detail(1).subscribe(data => {
      this.person = data
    });
  }

}
