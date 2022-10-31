import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Education } from 'src/app/model/education';
import { EducationService } from 'src/app/service/education.service';

@Component({
  selector: 'app-edit-education',
  templateUrl: './edit-education.component.html',
  styleUrls: ['./edit-education.component.css']
})
export class EditEducationComponent implements OnInit {
  education: Education = null;

  constructor(private sEducation: EducationService,
    private activateRouter: ActivatedRoute,
    private router: Router) { }

  ngOnInit(): void {
    const id = this.activateRouter.snapshot.params['id']
    this.sEducation.detail(id).subscribe(
      data => {
        this.education = data;
      }, err => {
        alert('No se pudo editar la educación');
        console.log(err);
        this.router.navigate(['']);
      }
    )
  }

  onUpdate(): void{
    const id = this.activateRouter.snapshot.params["id"];
    this.sEducation.update(id, this.education).subscribe(
      data => {
        alert('Educación actualizada');
        this.router.navigate(['']);
      }, err => {
        alert('No se pudo actualizar la educación');
        console.log(err);
        this.router.navigate(['']);
      }
    )
  }

}
