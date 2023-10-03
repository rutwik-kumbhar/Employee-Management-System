import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Employee } from '../employee';
import { EmployeeService } from '../employee.service';

@Component({
  selector: 'app-view-employee',
  templateUrl: './view-employee.component.html',
  styleUrls: ['./view-employee.component.css']
})
export class ViewEmployeeComponent implements OnInit {
  id!: number;
  employee: Employee = new Employee();

  constructor(private activatedRoute : ActivatedRoute,private employeeService: EmployeeService ){

  }
  ngOnInit(): void {
    this.id =this.activatedRoute.snapshot.params['id'];
    this.employeeService.getEmployeeById(this.id).subscribe((data)=>{
      this.employee = data;
    },
    error => console.log(error)
    );
  }

}
