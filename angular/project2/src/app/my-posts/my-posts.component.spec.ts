import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MyPostsComponent } from './my-posts.component';

describe('MyPostComponent', () => {
  let component: MyPostsComponent;
  let fixture: ComponentFixture<MyPostsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MyPostsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    component = fixture.componentInstance;
  it('should create', () => {
    expect(component).toBeTruthy();
  });
})});
