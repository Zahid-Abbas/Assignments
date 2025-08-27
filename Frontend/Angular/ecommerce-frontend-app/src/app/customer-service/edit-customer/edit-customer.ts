import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { Customer } from '../../types';
import { ActivatedRoute, Router } from '@angular/router';
import { Customerservice } from '../../service/customerservice';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-edit-customer',
  imports: [FormsModule],
  templateUrl: './edit-customer.html',
  styleUrl: './edit-customer.css'
})
export class EditCustomer implements OnInit{
customer:Customer = {
  id:0,
  name:'',
  email:'',
  password:'',
  age:0
};
id!:number;
 constructor(private route:ActivatedRoute, private customerService:Customerservice,private router:Router,private cdr: ChangeDetectorRef){}


  ngOnInit(): void {
    this.id = this.route.snapshot.params['id']; //get id from the url
    this.loadCustomer();
   
  }
  loadCustomer() {
    console.log(this.id);
    this.customerService.getCustomerById(this.id).subscribe({
      next: (data)=>{
        console.log(data);
        this.customer = data;
        this.cdr.detectChanges();
      },
      error:(err)=>console.error(err)
    });
  }
  onSubmit() {
    this.customerService.updateCustomer(this.id, this.customer).subscribe({
      next: () => {
        alert("Customer updated successfully");
         this.router.navigate(['/customer']);
      },
      error: (err)=>{
        console.error(err);
        alert("Failed to update customer !");
      }
    })
}
  
 
}