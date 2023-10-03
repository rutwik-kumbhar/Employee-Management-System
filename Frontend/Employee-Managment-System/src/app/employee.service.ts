import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Employee } from './employee';


@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  private baseUrl = "http://localhost:8080/api/";
  constructor(private httpClient: HttpClient) { }

  getEmployeesList(): Observable<Employee[]>{
    return this.httpClient.get<Employee[]>(`${this.baseUrl}`+"employees"); 
  }

  createEmployee(employee:Employee): Observable<Object>{
    return this.httpClient.post(`${this.baseUrl}`+"employee",employee);
  } 

  getEmployeeById(id:number): Observable<Employee> {
    return this.httpClient.get<Employee>(`${this.baseUrl}` + "employee/" + `${id}`);
  }


  updateEmployee(id: number ,employee: Employee): Observable<Employee>{
    return this.httpClient.put<Employee>(`${this.baseUrl}` + "employee/update/" + `${id}`, employee );
  }

  deleteEmployee(id: number): Observable<object>{
    return this.httpClient.delete<object>(`${this.baseUrl}` + "employee/delete/" + `${id}`)
  }
}
