import { AmiBuilderUiPage } from './app.po';

describe('ami-builder-ui App', function() {
  let page: AmiBuilderUiPage;

  beforeEach(() => {
    page = new AmiBuilderUiPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
