import { StudentDto } from './../dtos/student-dto';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  baseUrl = 'http://localhost:8080/';

  constructor(private http: HttpClient) { }

  getStudents() {
    return this.http.get(this.baseUrl + 'students');
  }

  addStudent(student: StudentDto) {
    return this.http.post(this.baseUrl + 'insertstudent', student);
  }
}
