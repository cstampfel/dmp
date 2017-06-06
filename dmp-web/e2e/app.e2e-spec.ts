import { DmpWebPage } from './app.po';

describe('dmp-web App', () => {
  let page: DmpWebPage;

  beforeEach(() => {
    page = new DmpWebPage();
  });

  it('should display welcome message', done => {
    page.navigateTo();
    page.getParagraphText()
      .then(msg => expect(msg).toEqual('Welcome to app!!'))
      .then(done, done.fail);
  });
});
