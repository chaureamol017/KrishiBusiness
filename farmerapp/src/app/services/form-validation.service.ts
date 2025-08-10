import { Injectable } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';

@Injectable({
  providedIn: 'root'
})
export class FormValidationService {

  constructor() { }

  getMyLoginFormGroup(): FormGroup {
    return new FormGroup({
        userName: new FormControl('', [Validators.required]),
        password: new FormControl('', [Validators.required]),
      });
  }

}
