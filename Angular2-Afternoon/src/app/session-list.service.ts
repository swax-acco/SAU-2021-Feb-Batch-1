import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class SessionListService {
  sessions = [];
  constructor() { 
    if(localStorage.getItem('dataSource') != null)
      this.sessions = JSON.parse(localStorage.getItem('dataSource'));
  }

  getSessions() {
    return this.sessions;
  }
  setLocalStorage(){
    localStorage.setItem('dataSource', JSON.stringify(this.sessions));
  }
  addSession(obj: Object) {
    this.sessions.push(obj);
    this.setLocalStorage();
  }
  deleteSession(id: String) {
    this.sessions = this.sessions.filter(session => session.id !== id);
    this.setLocalStorage();
  }
  updateSession(obj: Object) {
    var i = this.sessions.findIndex(session => session.id === obj['id']);
    this.sessions[i] = obj;
    this.setLocalStorage();
  }
  getSessionById(id: String) {
    return this.sessions.find(session => session.id === id);
  }
}
