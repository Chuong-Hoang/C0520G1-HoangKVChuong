import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ChuongComponent } from './chuong/chuong.component';
import { BookComponent } from './book/book.component';
import { UserFormComponent } from './user-form/user-form.component';
import { FormsModule } from '@angular/forms';
import { StructComponent } from './struct/struct.component';
import { WordsComponent } from './words/words.component';
import { PersonComponent } from './person/person.component';
import { ListPersonComponent } from './list-person/list-person.component';
import { ParentComponent } from './output/parent.component';
import {ChildComponent} from './output/child.component';
import { FontSizeEditorComponent } from './font-size-editor/font-size-editor.component';
import { PetComponent } from './pet/pet.component';
import { CalculatorComponent } from './calculator/calculator.component';
import { ColorPickerComponent } from './color-picker/color-picker.component';
import { ArticleComponent } from './article/article.component';
import { LikesComponent } from './likes/likes.component';
import { NavbarComponent } from './navbar/navbar.component';
import { FooterComponent } from './footer/footer.component';
import { NameCardComponent } from './name-card/name-card.component';
import { ProgressBarComponent } from './progress-bar/progress-bar.component';
import { StudentComponent } from './student/student.component';
import { StudentListComponent } from './student-list/student-list.component';

@NgModule({
  declarations: [
    AppComponent,
    ChuongComponent,
    BookComponent,
    UserFormComponent,
    StructComponent,
    WordsComponent,
    PersonComponent,
    ListPersonComponent,
    ParentComponent,
    ChildComponent,
    FontSizeEditorComponent,
    PetComponent,
    CalculatorComponent,
    ColorPickerComponent,
    ArticleComponent,
    LikesComponent,
    NavbarComponent,
    FooterComponent,
    NameCardComponent,
    ProgressBarComponent,
    StudentComponent,
    StudentListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
