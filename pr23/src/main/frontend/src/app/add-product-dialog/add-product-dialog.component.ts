import { Component, OnInit, Inject } from '@angular/core';
import { MdDialogRef, MD_DIALOG_DATA } from '@angular/material';

@Component({
  selector: 'app-add-product-dialog',
  templateUrl: './add-product-dialog.component.html',
  styleUrls: ['./add-product-dialog.component.css']
})
export class AddProductDialog {

  constructor(
    public dialogRef: MdDialogRef<AddProductDialog>,
    @Inject(MD_DIALOG_DATA) public data: any) {}

}
