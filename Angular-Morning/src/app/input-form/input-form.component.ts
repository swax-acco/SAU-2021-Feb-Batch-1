import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-input-form',
  templateUrl: './input-form.component.html',
  styleUrls: ['./input-form.component.css']
})
export class InputFormComponent implements OnInit {
  names = [];
  header = ["First Name", "Last Name"];

  constructor() { }

  ngOnInit(): void {
  }
  getName(first, last){
    this.names.push({"First Name": first, "Last Name": last});
  }
  clear(){
    this.names = [];
  }

}
