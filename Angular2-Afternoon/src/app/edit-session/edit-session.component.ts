import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { SessionListService } from '../session-list.service';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-edit-session',
  templateUrl: './edit-session.component.html',
  styleUrls: ['./edit-session.component.css']
})
export class EditSessionComponent implements OnInit {
  inputReactiveForm:FormGroup;
  constructor(private _sessionList: SessionListService, private router: Router, private route: ActivatedRoute) { }
  
  tempObj;
  ngOnInit(): void {
    this.tempObj = this._sessionList.getSessionById(this.route.snapshot.paramMap.get('id'));
    this.inputReactiveForm = new FormGroup({
      'session-name': new FormControl(this.tempObj['session-name']),
      'instructor': new FormControl(this.tempObj.instructor),
      'description': new FormControl(this.tempObj.description)
    })
  }

  updateValues() {
    var temp = this.inputReactiveForm.value;
    temp.id = this.tempObj.id;
    this._sessionList.updateSession(temp);
    this.router.navigate(['/sessionList']);
  }

}
