import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Observable } from 'rxjs';
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/map';

import { Category, Product } from '../models';

@Injectable()
export class BreadcrumbService {

  private productBreadcrumbUrl: string = 'http://localhost:4567/api/breadcrumb/product';
  private categoryBreadcrumbUrl: string = 'http://localhost:4567/api/breadcrumb/category';

  constructor(private http: Http) { }

  getProductBreadcrumbs(id: number): Observable<Category[]> {
    return this.http.get(this.productBreadcrumbUrl + '/' + id).map(this.extractBreadcrumbs).catch(this.handleError);
  }

  getCategoryBreadcrumbs(id: number): Observable<Category[]> {
    return this.http.get(this.categoryBreadcrumbUrl + '/' + id).map(this.extractBreadcrumbs).catch(this.handleError);
  }

  private extractBreadcrumbs(res: Response) {
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
