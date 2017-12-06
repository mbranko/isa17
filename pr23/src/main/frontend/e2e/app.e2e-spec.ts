import { AngularWebshopPage } from './app.po';

describe('angular-webshop App', () => {
  let page: AngularWebshopPage;

  beforeEach(() => {
    page = new AngularWebshopPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
