import { Component, OnInit } from '@angular/core';
import { Skill } from 'src/app/model/skill';
import { SkillService } from 'src/app/service/skill.service';
import { TokenService } from 'src/app/service/token.service';

@Component({
  selector: 'app-skills',
  templateUrl: './skills.component.html',
  styleUrls: ['./skills.component.css']
})
export class SkillsComponent implements OnInit {
  skill: Skill[] = [];

  constructor(private skillService: SkillService, private tokenService: TokenService) { }

  isLogged=false;

  ngOnInit(): void {
    this.cargarSkills();
    if(this.tokenService.getToken()){
      this.isLogged=true;
    } else {
      this.isLogged=false;
    }
  }

  cargarSkills():void{
    this.skillService.lista().subscribe(
      data => {
        this.skill = data;
      }, err => {
        console.log(err);
      }
    );
  }

  delete(id: number): void {
    if(id!= undefined){
      this.skillService.delete(id).subscribe(
        data => {
          alert('Skill eliminada correctamente.');
          this.cargarSkills();
        }, err => {
          alert('Error al eliminar la skill.');
        }
      );
    }
  }

}
