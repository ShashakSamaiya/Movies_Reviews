import { Router } from '@angular/router';
import { AuthenticateService } from './../authenticate.service';
import { User } from './../model/User';
import { Status } from './../model/Status';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-sign-up',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignUpComponent implements OnInit {

  user: User
  successFlag: boolean
  errorFlag: boolean

  constructor(public authService: AuthenticateService, public router: Router) {
    this.initUser()
  }

  ngOnInit() {
  }

  signUpSubmit(signUpForm) {

    this.successFlag = false
    this.errorFlag = false

    this.authService.signUp(this.user)
      .subscribe((res: User) => {
        if (res !== null) {
          this.successFlag = true
          this.authService.loginStatus = true
          this.router.navigateByUrl('')
        }
        else {
          this.errorFlag = true
          this.authService.loginStatus = false
        }
      }, err => {
        console.log(err)
        this.errorFlag = true
        this.authService.loginStatus = false
      })
  }

  initUser() {
    this.user = {
      uId: 0,
      email: '',
      password: ''
    }
  }

}