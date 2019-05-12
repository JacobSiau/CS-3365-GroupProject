import { AuthService } from './../services/auth.service';
import { Component, OnInit } from '@angular/core';
import { Student } from '../Models/student';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  // tslint:disable-next-line:max-line-length
  students: Student[] = [{RNumber: '11453995', firstName: 'Eddie', lastName: 'Gonzalez', gradDate: 'December 2020', department: 'Engineering', major: 'Computer Science', minor: 'Mathematics', username: 'eddie97g', email: 'eddie.gonzalez@ttu.edu' },
  // tslint:disable-next-line:max-line-length
  {RNumber: '11453996', firstName: 'Jacob', lastName: 'Siau', gradDate: 'December 2019', department: 'Engineering', major: 'Computer Engineering', minor: 'Physics', username: 'jacob97g', email: 'jacob.siau@ttu.edu' }];
  // tslint:disable-next-line:max-line-length
  displayedColumns: string[] = ['RNumber', 'firstName', 'lastName', 'gradDate', 'department', 'major', 'minor', 'username', 'email'];

  studentsFromService: any; // DO I HAVE TO INITIALIZE IT?????
  constructor(private authService: AuthService) { }

  ngOnInit() {
    this.getStudents();
  }

  getStudents() {
    this.authService.getStudents().subscribe(response => {
      this.studentsFromService = response;
    }, error => {
      console.log('There was an error trying to retrieve the students\' records');
    });
  }

}
