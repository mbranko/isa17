import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { MaterialModule } from '@angular/material';

import { AppRoutingModule } from './app-routing.module';

import { AppComponent } from './app.component';
import { CategoryListComponent } from './category-list/category-list.component';
import { CategoryComponent } from './category/category.component';
import { ProductComponent } from './product/product.component';
import { ShoppingCartComponent } from './shopping-cart/shopping-cart.component';
import { PaymentComponent } from './payment/payment.component';
import { BreadcrumbComponent } from './breadcrumb/breadcrumb.component';
import { AddProductDialog } from './add-product-dialog/add-product-dialog.component';


@NgModule({
  declarations: [
    AppComponent,
    CategoryListComponent,
    CategoryComponent,
    ProductComponent,
    ShoppingCartComponent,
    PaymentComponent,
    BreadcrumbComponent,
    AddProductDialog,
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    MaterialModule,
    AppRoutingModule,
  ],
  providers: [],
  entryComponents: [AddProductDialog],
  bootstrap: [AppComponent]
})
export class AppModule { }
