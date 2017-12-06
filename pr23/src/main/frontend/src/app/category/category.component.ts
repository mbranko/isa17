import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router, Params } from '@angular/router';
import { Observable } from 'rxjs';

import { Category, Product } from '../models';
import { CategoryService } from '../services/CategoryService';

@Component({
  selector: 'app-category',
  templateUrl: './category.component.html',
  styleUrls: ['./category.component.css'],
  providers: [CategoryService],
})
export class CategoryComponent implements OnInit {

  category: Category;

  constructor(
    private categoryService: CategoryService,
    private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit() {
    this.route.params
      .switchMap((params: Params) => this.categoryService.getCategory(+params['id']))
      .subscribe((category: Category) => this.category = category);
  }

  onSelectCategory(category: Category) {
    this.router.navigate(['/category', category.id]);
  }

  onSelectProduct(product: Product) {
    this.router.navigate(['/product', product.id]);
  }


}
