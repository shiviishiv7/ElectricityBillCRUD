import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { BillService } from '../bill.service';
import { Bill } from '../models/bill';

@Component({
  selector: 'app-list-bill',
  templateUrl: './list-bill.component.html',
  styleUrls: ['./list-bill.component.scss']
})
export class ListBillComponent implements OnInit {
  bills: Bill[]
  constructor(private billService: BillService,
    private router: Router) { }

  ngOnInit(): void {
    this.billService.getAllBill()
      .subscribe(data => {
        this.bills = data;
      })
  }
  createBill() {
    this.router.navigateByUrl("create")
  }
  detailBill(id: number) {
    this.router.navigate(["detail", id])
  }

}
