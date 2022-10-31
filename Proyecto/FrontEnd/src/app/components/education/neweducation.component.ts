import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Education } from 'src/app/model/education';
import { EducationService } from 'src/app/service/education.service';

@Component({
  selector: 'app-neweducation',
  templateUrl: './neweducation.component.html',
  styleUrls: ['./neweducation.component.css']
})
export class NeweducationComponent implements OnInit {
  nameE: string;
  descriptionE: string;

  constructor(private sEducation: EducationService, private router: Router) { }

  ngOnInit(): void {
  }

  onCreate(): void{
    const education = new Education(this.nameE, this.descriptionE);
    this.sEducation.save(education).subscribe(
      data => {
        alert('Educación creada');
        this.router.navigate(['']);
      } , err => {
        alert('No se pudo crear la educación');
        console.log(err);
        this.router.navigate(['']);
      }
    )
  }

}
