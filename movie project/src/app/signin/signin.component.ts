import { Status } from './../model/Status';
import { User } from './../model/User';
import { Component, OnInit } from '@angular/core';
import { AuthenticateService } from '../authenticate.service';
import { Router, Event, NavigationEnd } from '@angular/router';

@Component({
  selector: 'app-sign-in',
  templateUrl: './signin.component.html',
  styleUrls: ['./signin.component.css']
})
export class SignInComponent implements OnInit {

  user: User
  successFlag: boolean
  errorFlag: boolean

  constructor(public authService: AuthenticateService, public router: Router) {
    this.initUser()
  }

  ngOnInit() {
  }

  signInSubmit(signInForm) {

    this.successFlag = false
    this.errorFlag = false

    this.authService.signIn(this.user)
      .subscribe((res: Status) => {
        if (res.queryStatus) {
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