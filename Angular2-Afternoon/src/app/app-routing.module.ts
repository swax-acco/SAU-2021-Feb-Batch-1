import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
// import { Session } from 'inspector';
import { AddSessionComponent } from './add-session/add-session.component';
import { SessionListComponent } from './session-list/session-list.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { EditSessionComponent } from './edit-session/edit-session.component';

const routes: Routes = [
  {path: '', redirectTo: '/sessionList', pathMatch: 'full'},
  {path: 'sessionList', component: SessionListComponent},
  {path: 'addSession', component: AddSessionComponent},
  {path: 'editSession/:id', component: EditSessionComponent},
  {path: '**', component: PageNotFoundComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
