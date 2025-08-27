import { Routes } from '@angular/router';
import { Menu } from './menu/menu';
import { ViewCustomer } from './customer-service/view-customer/view-customer';
import { AddCustomer } from './customer-service/add-customer/add-customer';
import { EditCustomer } from './customer-service/edit-customer/edit-customer';
import { ProductService } from './product-service/product-service';
// import { Todo } from './todo/todo';

export const routes: Routes = [
    {path:'',component:Menu},
    {path:'customer', component:ViewCustomer},
    {path:'add-customer',component:AddCustomer},
    {path:'edit-customer/:id',component:EditCustomer},
    // {path:'todos', component:Todo}
    {path:"product-servie", component:ProductService}
];