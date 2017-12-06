import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router, Params } from '@angular/router';
import { Observable } from 'rxjs';
import { MdDialog } from '@angular/material';

import { ProductService } from '../services/ProductService';
import { Category, Product, PurchaseOrder, OrderItem } from '../models';
import { AddProductDialog } from '../add-product-dialog/add-product-dialog.component';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css'],
  providers: [ProductService],
})
export class ProductComponent implements OnInit {

  product: Product;

  constructor(
    private productService: ProductService,
    private route: ActivatedRoute,
    private router: Router,
    public dialog: MdDialog) { }

  ngOnInit() {
    this.route.params
      .switchMap((params: Params) => this.productService.getProduct(+params['id']))
      .subscribe((product: Product) => this.product = product);
  }

  buy(product: Product) {
    let config = { data: { product: product } };
    let dialogRef = this.dialog.open(AddProductDialog, config);
    dialogRef.afterClosed().subscribe(result => {
      if (result != undefined) {
        let shoppingCart: PurchaseOrder;
        let sc = sessionStorage.getItem('shoppingCart');
        if (sc == null)
          shoppingCart = new PurchaseOrder();
        else
          shoppingCart = JSON.parse(sc);
        let item = new OrderItem();
        item.product = product;
        item.quantity = +result;
        if (shoppingCart.items == undefined) {
          shoppingCart.items = [ item ];
        } else {
          shoppingCart.items.push(item);
        }
        sessionStorage.setItem('shoppingCart', JSON.stringify(shoppingCart));
      }
    });
  }
}
