import { Component, OnInit } from '@angular/core';
import { EmployeeService } from '../employee.service';
import { Employee } from '../employee';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-update-employee',
  templateUrl: './update-employee.component.html',
  styleUrls: ['./update-employee.component.css']
})
export class UpdateEmployeeComponent implements OnInit{

  employee: Employee = new Employee();
  id!: number ;
  flag:string = "none";

  constructor(private employeeService: EmployeeService,private activatedRoute: ActivatedRoute,private router: Router){

  }

  ngOnInit(): void {
    this.id = this.activatedRoute.snapshot.params['id'];
    this.employeeService.getEmployeeById(this.id).subscribe(data =>{
      this.employee = data; 
    },
    error => console.log(error)
    )
  }

  onSubmit(){
     this.employeeService.updateEmployee(this.id,this.employee).subscribe(data =>{
       this.toggleAlert();
      setTimeout(()=>{
        this.goToEmployeeList();
      },2000)
      
     },
     error => console.log(error)
     );
  }

  goToEmployeeList(){
    this.router.navigate(['/employees'])
  }

  toggleAlert() {
    this.flag= this.flag === 'none' ? 'block' : 'none';
  }
  
  
}
