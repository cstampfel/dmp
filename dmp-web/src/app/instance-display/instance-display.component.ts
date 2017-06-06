import { Component, OnInit } from '@angular/core';
import {InstanceService} from "../services/instance.service";
import {DmpModel, DataObject} from "../model/DmpModel";

@Component({
  selector: 'app-instance-display',
  templateUrl: './instance-display.component.html',
  styleUrls: ['./instance-display.component.css'],
})
export class InstanceDisplayComponent implements OnInit {

  public instance: DmpModel;
  public selectedDataObject: DataObject;

  constructor(private instanceService: InstanceService) {
    this.instance = instanceService.instance;
    this.selectedDataObject = this.instance.dataObjects[0];
    console.log(this.instance)

  }

  ngOnInit() {
  }

  public setDataObjectSelection(object: any): void {
    this.selectedDataObject = object;
  }



}
