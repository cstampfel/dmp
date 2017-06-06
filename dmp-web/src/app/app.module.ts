import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AppComponent } from './app.component';
import { InstanceInputComponent } from './instance-input/instance-input.component';
import { InstanceDisplayComponent } from './instance-display/instance-display.component';
import {Routes, RouterModule} from "@angular/router";
import {ToastModule} from "ng2-toastr";
import { FormsModule } from '@angular/forms';
import { HelpComponent } from './help/help.component';
import {InstanceService} from "./services/instance.service";

const routes: Routes = [
  { path: '', component: InstanceInputComponent},
  { path: 'show', component:InstanceDisplayComponent},
  { path: 'help', component:HelpComponent},
];

@NgModule({
  declarations: [
    AppComponent,
    InstanceInputComponent,
    InstanceDisplayComponent,
    HelpComponent
  ],
  imports: [
    BrowserModule,
    CommonModule,
    FormsModule,
    RouterModule.forRoot(routes),
    ToastModule.forRoot()
  ],
  providers: [InstanceService],
  bootstrap: [AppComponent]
})
export class AppModule { }
