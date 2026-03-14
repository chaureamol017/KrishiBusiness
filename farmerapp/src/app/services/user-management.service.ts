import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserManagementService {
  private serverUrl = 'http://localhost:8080/';
  private apiEndpoint = 'v1/user';

  constructor(private httpClient: HttpClient) {}

  getAllUsers(): Observable<any[]> {
    const url = `${this.serverUrl}${this.apiEndpoint}/all`;
    return this.httpClient.get<any[]>(url);
  }

  getUserById(userId: number): Observable<any> {
    const url = `${this.serverUrl}${this.apiEndpoint}/byid/${userId}`;
    return this.httpClient.get<any>(url);
  }

  deleteUser(userId: number): Observable<boolean> {
    const url = `${this.serverUrl}${this.apiEndpoint}/delete/${userId}`;
    return this.httpClient.delete<boolean>(url);
  }

  toggleActive(userId: number): Observable<boolean> {
    const url = `${this.serverUrl}${this.apiEndpoint}/toggle-active/${userId}`;
    return this.httpClient.put<boolean>(url, {});
  }
}
