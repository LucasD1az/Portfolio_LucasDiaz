export class person{
    id?: number;
    firstName: String;
    lastName: String;
    img: String;

    constructor(firstName: String, lastName: String, img: String){
        this.firstName = firstName;
        this.lastName = lastName;
        this.img = img;
    }
}