import { Routes } from '@angular/router';
import { Hello } from './hello/hello';
import { Welcome } from './welcome/welcome';

export const routes: Routes = [
    {path:'hello', component:Hello},
    {path:'welcome', component:Welcome}
];
