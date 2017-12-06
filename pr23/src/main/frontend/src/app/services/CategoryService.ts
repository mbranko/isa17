import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Observable } from 'rxjs';
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/map';

import { Category } from '../models';

@Injectable()
export class CategoryService {

  private rootCategoriesUrl: string = 'http://localhost:4567/api/rootCategories';
  private categoryUrl: string = 'http://localhost:4567/api/category/';

  constructor(private http: Http) { }

  getRootCategories(): Observable<Category[]> {
    return this.http.get(this.rootCategoriesUrl).map(this.extractRoots).catch(this.handleError);
  }

  getCategory(id: number): Observable<Category> {
    return this.http.get(this.categoryUrl + '/' + id).map(this.extractCategory).catch(this.handleError);
  }

  private extractRoots(res: Response) {
    let body = res.json();
    return body || { };
  }

  private extractCategory(res: Response) {
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
