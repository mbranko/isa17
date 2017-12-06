import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Observable } from 'rxjs';
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/map';

import { Product, Category } from '../models';

@Injectable()
export class ProductService {

  private productUrl: string = 'http://localhost:4567/api/product';

  constructor(private http: Http) { }

  getProduct(id: number): Observable<Product> {
    return this.http.get(this.productUrl + '/' + id).map(this.extractProduct).catch(this.handleError);
  }

  private extractProduct(res: Response) {
    let body = res.json();
    return body || { };
  }

  private handleError(error: Response | any) {
    let errMsg: string;
    if (error instanceof Response) {
      const body = error.json() || '';
      const err = body.error || JSON.stringify(body);
      errMsg = `${error.status} - ${error.statusText || ''} ${err}`;
    } else {
      errMsg = error.message ? error.message : error.toString();
    }
    console.error(errMsg);
    return Observable.throw(errMsg);
  }

}
