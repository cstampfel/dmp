import {Component, OnInit, ViewContainerRef} from '@angular/core';
import {ToastsManager} from "ng2-toastr";
import {DmpModel} from "../model/DmpModel";
import {plainToClass} from "class-transformer";
import {InstanceService} from "../services/instance.service";
import {Router} from "@angular/router";


@Component({
  selector: 'app-instance-input',
  templateUrl: './instance-input.component.html',
  styleUrls: ['./instance-input.component.css'],
})
export class InstanceInputComponent implements OnInit {

  public instanceString :  string;

  constructor(private instanceService: InstanceService, private router: Router, public toastr: ToastsManager, private vcr: ViewContainerRef) {
    this.toastr.setRootViewContainerRef(vcr);
  }

  ngOnInit() {
    this.instanceString = JSON.stringify(this.instanceService.instance, null, 2)
  }

  public visualize(): void {
    let jsonObject = JSON.parse(this.instanceString) as DmpModel;
    this.instanceService.instance = plainToClass(DmpModel, jsonObject);
    this.router.navigate(["/show"]);
  }
}
