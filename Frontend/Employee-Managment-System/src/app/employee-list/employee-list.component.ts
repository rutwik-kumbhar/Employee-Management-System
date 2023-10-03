import { Component, OnInit } from '@angular/core';
import { Employee } from '../employee';
import { EmployeeService } from '../employee.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.css'],
})
export class EmployeeListComponent  implements OnInit {
  employees!: Employee[];


  constructor(private employeeService: EmployeeService , private router: Router,) {
    // this.employees = [
    //   {
    //     id: 1,
    //     firstName: 'Vicky',
    //     lastName: 'Kumbhar',
    //     emailId: 'rutwik@gmail.com',
    //     designation: 'Manager',
    //     salary: 25500,
    //   },
    //   {
    //     id: 1,
    //     firstName: 'Vicky',
    //     lastName: 'Kumbhar',
    //     emailId: 'rutwik@gmail.com',
    //     designation: 'Manager',
    //     salary: 25500,
    //   },
    // ];
  }
  ngOnInit(): void {
    this.getEmployees();
  }

   private getEmployees(){
    this.employeeService.getEmployeesList().subscribe(data => {
      console.log(data)
      this.employees = data;
    });
   }

    updateEmployee(id: number){
      this.router.navigate(['update-employee',id])
   }

   deleteEmployee(id: number){
     let isDeleted:boolean  =  confirm("You Want to Delete Record?")
     if(isDeleted){
      this.employeeService.deleteEmployee(id).subscribe(data =>{
        this.getEmployees();
     },
     error => console.log(error));
     }
   }

   employeeDetails(id: number){
      this.router.navigate(['employee-details',id])
   }

   confirmDelete(){

   }
}
