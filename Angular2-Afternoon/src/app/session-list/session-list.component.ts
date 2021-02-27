import { Component, OnInit } from '@angular/core';
import { SessionListService } from '../session-list.service';
import { Router } from '@angular/router';
import { Variable } from '@angular/compiler/src/render3/r3_ast';

@Component({
  selector: 'app-session-list',
  templateUrl: './session-list.component.html',
  styleUrls: ['./session-list.component.css']
})
export class SessionListComponent implements OnInit {
  constructor(private _sessionList: SessionListService, private router: Router) { }
  sessionList = [];
  ngOnInit(): void {
    this.sessionList = this._sessionList.getSessions();
  }

  deleteSession(id: String) {
    console.log(id);
    this._sessionList.deleteSession(id);
    this.sessionList = this._sessionList.getSessions();
  }

  updateSession(id: String) {
    this.router.navigate(['/editSession', id]);
  }

}
