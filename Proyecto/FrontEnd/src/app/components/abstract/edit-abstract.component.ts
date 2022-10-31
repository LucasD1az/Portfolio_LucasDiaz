import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Person } from 'src/app/model/person.model';
import { ImageService } from 'src/app/service/image.service';
import { PersonService } from 'src/app/service/person.service';

@Component({
  selector: 'app-edit-abstract',
  templateUrl: './edit-abstract.component.html',
  styleUrls: ['./edit-abstract.component.css']
})
export class EditAbstractComponent implements OnInit {
  person: Person = null;
  constructor(private activatedRouter: ActivatedRoute,
    private personService: PersonService,
    private router: Router,
    public imageService: ImageService) { }

  ngOnInit(): void {
    const id = this.activatedRouter.snapshot.params['id'];
    this.personService.detail(id).subscribe(data => {
      this.person = data;
    }, err => {
      alert('Error al editar la persona.');
      this.router.navigate(['']);
    }
    );
  }

  onUpdate(): void {
    const id = this.activatedRouter.snapshot.params['id'];
    this.person.img = this.imageService.url;
    this.personService.update(id, this.person).subscribe(
      data => {
        alert('Perfil actualizado correctamente.');
        this.router.navigate(['']);
      }, err=> {
        alert('Error al actualizar el perfil.');
        this.router.navigate(['']);
      } 
    );
  }

  uploadImage($event:any): void {
    const id = this.activatedRouter.snapshot.params['id'];
    const name = "perfil_" + id;
    this.imageService.uploadImage($event, name)
  }
}
