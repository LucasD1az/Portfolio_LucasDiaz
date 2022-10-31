export class Person{
    id?: number;
    firstName: string;
    lastName: string;
    description: string;
    img: string;

    constructor(firstName: string, lastName: string, description: string, img: string){
        this.firstName = firstName;
        this.lastName = lastName;
        this.description = description;
        this.img = img;
    }
}