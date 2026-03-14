import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { UserDetails } from '../model/user-details';
import { CommonUtil } from '../util/common.util';

@Injectable({
  providedIn: 'root'
})
export class LocalStorageService {
  constructor(
    private router: Router,
  ) {
  }

  onValidateCall(loggedInUser: UserDetails, token?: string) {
    this.setItemsToLocalStorage(loggedInUser, ['registrationFor']);
    if (token) {
      localStorage.setItem('jwtToken', token);
    }
    window.location.href = "home";
  }

  logOut() {
    const keys: string[] = ['token', 'userId', 'emailId', 'mobile', 'firstName', 'middleName', 'lastName', 'role', 'jwtToken'];
    this.removeItemsFromLocalStorage(keys);

    window.location.href = "";
  }

  isLoggedIn(): boolean {
    const authenticated: boolean = this.getEmailId() && this.getEmailId().length > 0 && this.getRole() && this.getRole().length > 0;
    return authenticated;
  }

  isAdminUser(): boolean {
    return this.isLoggedIn() && this.getRole().toLocaleUpperCase() == 'ADMIN';
  }

  getUserId(): number {
    return CommonUtil.parseToInt(this.getItemFromLocalStorage("userId"));
  }

  getRole(): string {
    return this.getItemFromLocalStorage("role");
  }

  getFirstName(): string {
    return this.getItemFromLocalStorage("firstName");
  }

  getMiddleName(): string {
    return this.getItemFromLocalStorage("middleName");
  }

  getLastName(): string {
    return this.getItemFromLocalStorage("lastName");
  }

  getEmailId(): string {
    return this.getItemFromLocalStorage("emailId");
  }

  getMobile(): string {
    return this.getItemFromLocalStorage("mobile");
  }

  getToken(): string {
    return this.getItemFromLocalStorage("jwtToken");
  }


  private setItemsToLocalStorage(data: any, keysToSkip: undefined | string[]) {
    Object.keys(data)
      .filter(key => !keysToSkip || keysToSkip.length === 0 || !keysToSkip.includes(key))
      .forEach(key => localStorage.setItem(key, data[key] ? data[key] : ""));
  }

  private removeItemsFromLocalStorage(keys: string[]) {
    keys.forEach(key => localStorage.removeItem(key));
  }

  private getItemFromLocalStorage(key: string) {
    const value: string | null = localStorage.getItem(key);
    return value ? value : '';
  }

}
