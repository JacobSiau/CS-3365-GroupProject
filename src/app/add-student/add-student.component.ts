import { AuthService } from './../services/auth.service';
import { Component, OnInit } from '@angular/core';
import { StudentDto } from '../dtos/student-dto';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-student',
  templateUrl: './add-student.component.html',
  styleUrls: ['./add-student.component.css']
})
export class AddStudentComponent implements OnInit {

  RNumber: string;
  firstName: string;
  lastName: string;
  gradDate: string;
  department: string;
  major: string;
  minor: string;
  username: string;
  email: string;
  password: string;

  constructor(private authService: AuthService, private router: Router) { }

  ngOnInit() {
  }

  private makeStudent(): StudentDto {
    const newStudent = new StudentDto;
    newStudent.rnumber = this.RNumber;
    newStudent.firstname = this.firstName;
    newStudent.lastname = this.lastName;
    newStudent.graddate = this.gradDate;
    newStudent.department = this.department;
    newStudent.major = this.major;
    newStudent.minor = this.minor;
    newStudent.username = this.username;
    newStudent.email = this.email;
    newStudent.password = this.password;
    // console.log(newStudent);
    return newStudent;
  }

  addStudent() {
    // this.makeStudent();
    let newStudent: StudentDto = this.makeStudent();
    console.log(newStudent);
    this.authService.addStudent(newStudent).subscribe(response => {
      console.log('Successfully added student');
    }, error => {
      console.log('There was an error trying to add the student');
      console.log(error);
    }, () => {
        this.router.navigate(['/home']);
      // redirect to home page

    });
  }

}
