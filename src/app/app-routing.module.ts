import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CreateBillComponent } from './create-bill/create-bill.component';
import { ListBillComponent } from './list-bill/list-bill.component';
import { UpdateBillComponent } from './update-bill/update-bill.component';
import { DetailBillComponent } from './detail-bill/detail-bill.component'
const routes: Routes = [
  { path: '', component: ListBillComponent, pathMatch: 'full' },
  { path: 'bills', component: ListBillComponent, pathMatch: 'full' },
  { path: 'create', component: CreateBillComponent, pathMatch: 'full' },
  { path: 'update/:id', component: UpdateBillComponent, pathMatch: 'full' },
  { path: 'detail/:id', component: DetailBillComponent, pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
