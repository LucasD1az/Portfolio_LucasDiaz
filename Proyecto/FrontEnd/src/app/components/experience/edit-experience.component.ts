import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Experience } from 'src/app/model/experience';
import { SExperienceService } from 'src/app/service/s-experience.service';

@Component({
  selector: 'app-edit-experience',
  templateUrl: './edit-experience.component.html',
  styleUrls: ['./edit-experience.component.css']
})
export class EditExperienceComponent implements OnInit {
  experience: Experience = null;
  constructor(private sExperience: SExperienceService, private activatedRouter: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
    const id = this.activatedRouter.snapshot.params['id'];
    this.sExperience.detail(id).subscribe(
      data => {
        this.experience = data;
      }, err => {
        alert("Error al editar la experiencia");
        this.router.navigate(['']);
      }
      )
  }

  onUpdate(): void{
    const id = this.activatedRouter.snapshot.params['id'];
    this.sExperience.update(id, this.experience).subscribe(data => {
      this.router.navigate(['']);
    }, err => {
      alert("Error al editar la experiencia");
      this.router.navigate(['']);
    }
    )
  }

}
