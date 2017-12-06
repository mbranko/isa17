import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Observable } from 'rxjs';
import 'rxjs/add/operator/toPromise';
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/map';

import { CreditCard, PurchaseOrder, OrderItem, Product } from '../models';

@Injectable()
export class PaymentService {

  private paymentUrl: string = 'http://localhost:4567/api/payment';

  constructor(private http: Http) { }

  makePayment(order: PurchaseOrder, card: CreditCard): Promise<Object> {
    let request = { order: { items: [] }, card: card };
    for(let item of order.items) {
      request.order.items.push({ product: { id: item.product.id }, quantity: item.quantity})
    }
    return this.http.post(this.paymentUrl, JSON.stringify(request)).toPromise().then(res => res.json()).catch(this.handleError);
  }

  private handleError(error: Response | any): Promise<any> {
    console.error('Greska', error);
    return Promise.reject(error.message || error);
  }

}
