import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { v4 as uuid } from 'uuid';
import { SessionListService } from '../session-list.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-session',
  templateUrl: './add-session.component.html',
  styleUrls: ['./add-session.component.css']
})
export class AddSessionComponent implements OnInit {
  inputReactiveForm:FormGroup;
  constructor(private _sessionList: SessionListService, private router: Router) { }

  ngOnInit(): void {
    this.inputReactiveForm = new FormGroup({
      'session-name': new FormControl(null),
      'instructor': new FormControl(null),
      'description': new FormControl(null)
    })
  }

  getValues() {
    var temp = this.inputReactiveForm.value;
    temp.id = uuid();
    this._sessionList.addSession(temp);
    this.router.navigate(['/sessionList']);
  }
}
