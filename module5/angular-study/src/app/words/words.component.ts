import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-words',
  templateUrl: './words.component.html',
  styleUrls: ['./words.component.css']
})
export class WordsComponent implements OnInit {
  filterStatus:string = 'XEM_TAT_CA';
  wordEn: string = "";
  wordVn: string = "";
  isShownForm: boolean = false;
  arrWords = [
    {id: 1, en: 'hello', vn: 'xin chào', memorized: false},
    {id: 2, en: 'love', vn: 'tình yêu', memorized: true},
    {id: 3, en: 'taciturn', vn: 'trầm mặc', memorized: true},
    {id: 4, en: 'lamp', vn: 'đèn bàn', memorized: false},
    {id: 5, en: 'table', vn: 'cái bàn', memorized: true},
    {id: 6, en: 'chair', vn: 'cái ghế', memorized: false}
  ];

  constructor() {
  }

  ngOnInit(): void {
  }

  addNewWord() {
    this.arrWords.unshift({
      id: this.arrWords.length + 1,
      en: this.wordEn,
      vn: this.wordVn,
      memorized: false
    });
    this.wordEn = "";
    this.wordVn = "";
    this.isShownForm = false;
  }

  removeWord(id: number) {
    const index = this.arrWords.findIndex(el => el.id === id);
    this.arrWords.splice(index, 1);
  }

  getShowStatus(memorized:boolean){
    const dkXemTatCa = this.filterStatus === 'XEM_TAT_CA';
    const dkXemDaNho = this.filterStatus === 'XEM_DA_NHO' && memorized;
    const dkXemChuaNho = this.filterStatus === 'XEM_CHUA_NHO' && !memorized;
    return dkXemTatCa || dkXemDaNho || dkXemChuaNho;
  }
}
