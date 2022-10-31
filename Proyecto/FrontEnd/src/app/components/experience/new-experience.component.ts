import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Experience } from 'src/app/model/experience';
import { SExperienceService } from 'src/app/service/s-experience.service';

@Component({
  selector: 'app-new-experience',
  templateUrl: './new-experience.component.html',
  styleUrls: ['./new-experience.component.css']
})
export class NewExperienceComponent implements OnInit {
  nameE: string = "";
  descriptionE: string = "";
  constructor(private sExperience: SExperienceService, private router: Router) { }

  ngOnInit(): void {
  }

  onCreate(): void{
    const expe = new Experience(this.nameE, this.descriptionE);
    this.sExperience.save(expe).subscribe(data => {
      alert("Experiencia añadida");
      this.router.navigate(['']);
    }, err => {
      alert("Error al añadir la experiencia");
      this.router.navigate(['']);
    }
    )
  }
}
