import { CommonModule } from '@angular/common';
import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { Customerservice } from '../../service/customerservice';
import { Customer } from '../../types';
import { Router } from '@angular/router';

@Component({
  selector: 'app-view-customer',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './view-customer.html',   // ✅ Angular CLI convention
  styleUrls: ['./view-customer.css']     // ✅ Angular CLI convention
})
export class ViewCustomer implements OnInit {

  customers: Customer[] = [];
  errorMessage = '';
  isLoading = true;

  constructor(private customerService: Customerservice,private cdr: ChangeDetectorRef,private router:Router) {}

  ngOnInit(): void {
    this.loadCustomers();
  }

  loadCustomers() {
  console.log("Loading Customers...");

  this.customerService.getCustomers().subscribe({
    next: (data) => {
      console.log("API Response: ", data, Array.isArray(data));
      
      this.customers = [];
      if (Array.isArray(data)) {
        console.log("inside if")
        data.forEach(item => {this.customers.push(item); console.log("pushing ")});
        this.cdr.detectChanges();

      }

      console.log("Assigned customers length:", this.customers.length);
    },
    error: (err) => {
      this.errorMessage = 'Failed to fetch data..';
      console.error(err);
    }
  });
}

deleteCustomer(id: number|undefined) {
  if(confirm('Are you sure to delete this customer?')){
    this.customerService.deleteCustomer(id).subscribe({
      next: () =>{
        alert('Customer deleted successfully');
        this.loadCustomers();
      },
      error:(err) =>{
        console.error(err);
        alert("Failed to delete a customer");
      }
    })
  }
}
editCustomer(id: number|undefined) {
  console.log(" inside edit customer")
  this.router.navigate(['/edit-customer',id]);
}
}