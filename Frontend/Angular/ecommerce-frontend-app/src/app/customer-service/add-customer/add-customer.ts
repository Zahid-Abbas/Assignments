import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Customerservice } from '../../service/customerservice';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-customer',
  imports: [FormsModule],
  templateUrl: './add-customer.html',
  styleUrl: './add-customer.css'
})
export class AddCustomer {

  customer = {
    name: '',
    password:'',
    email:'',
    age:0
  }
  message='';
  
  constructor(private customerService:Customerservice,private router:Router){}

  async onSubmit() {
    console.log("Submitting customer:", this.customer);

    this.customerService.addCustomer(this.customer).subscribe({
      next: (response) => {
        console.log("Customer saved:", response);
        this.message = "Customer added successfully!";
        this.router.navigate(['/customer']);
      },
      error: (err) => {
        console.error("Error while saving customer:", err);
        this.message = "Error adding customer!";
      }
    });
  }

}