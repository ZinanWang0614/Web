import {Component, OnInit, OnDestroy } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {Subscription} from 'rxjs/Subscription';
import {DomSanitizer} from '@angular/platform-browser';
import {Course} from '../course.model';
import {CourseService} from '../course.service';




@Component({
  selector: 'app-course-list',
  templateUrl: './course-list.component.html',
  styleUrls: ['./course-list.component.css']
})
export class CourseListComponent implements OnInit {

  private courses: Course[];
  private items_:Course[];
  private items:string[];
  subscription: Subscription;
  sort_string:string;

    search: string;
    finalCourses = [];
    isNull : boolean = false;

    private value:any = {};
    private _disabledV:string = '0';
    private disabled:boolean = false;


  constructor(private courseService: CourseService,
              private router: Router,
              private route: ActivatedRoute) {
  }


  private get disabledV():string {
    return this._disabledV;
  }
 
  private set disabledV(value:string) {
    this._disabledV = value;
    this.disabled = this._disabledV === '1';
  }
 
  public selected(value:any):void {
      this.sort_string = value.text;
    console.log('Selected value is: ', value);
  }
 
  public removed(value:any):void {
    console.log('Removed value is: ', value);
  }
 
  public typed(value:any):void {
    console.log('New search input: ', value);
  }
 
  public refreshValue(value:any):void {
    this.value = value;
  }

sort(){

        var sort_result: any[] =[];

        if(this.sort_string == null){
            alert("Select any item");
        }

        for(var i=0;i<this.courses.length;i++){

            if(this.courses[i].instructorName==this.sort_string){
                sort_result.push(this.courses[i]);
            }

        }

        this.courses = sort_result;


      }

init(){
    this.courses = this.items_;
}


  ngOnInit() {
      this.search = this.route.snapshot.queryParams['search'];

      if(this.search) {
          console.log('inside search!');
          this.courseService.getCourses()
              .subscribe(
                  (courses: Course[]) => {
                      for(let i=0; i<courses.length; i++) {
                          if(courses[i].courseName.toUpperCase().indexOf(this.search.toUpperCase()) > -1) {
                              this.finalCourses.push(courses[i]);
                          }
                      }
                      if (this.finalCourses.length == 0 ) {
                         this.isNull = true;
                         console.log(this.isNull);
                      }
                      this.courses = this.finalCourses;
                      this.items_ = this.courses;
                      this.items = [];
                      for(var i=0;i<this.items_.length;i++){
     
                              if(!this.items.includes(this.items_[i].instructorName)){
                                this.items.push(this.items_[i].instructorName);
                              }
                          
                      }
                      console.log(this.items);
                      console.log(this.items_);
                  }
              );
      } else {
          this.courseService.getCourses()
              .subscribe(
                  (courses: Course[]) => {
                      this.courses = courses;
                      this.items_ = this.courses;
                      this.items = [];
                      for(var i=0;i<this.items_.length;i++){
     
                              if(!this.items.includes(this.items_[i].instructorName)){
                                this.items.push(this.items_[i].instructorName);
                              }
                          
                      }
                      console.log(this.isNull);
                  }
              );
      }

  }

}
