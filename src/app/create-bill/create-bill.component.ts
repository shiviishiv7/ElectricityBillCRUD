import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { BillService } from '../bill.service';
import { Bill } from '../models/bill';

@Component({
  selector: 'app-create-bill',
  templateUrl: './create-bill.component.html',
  styleUrls: ['./create-bill.component.scss']
})
export class CreateBillComponent implements OnInit {
  bill: Bill = new Bill()
  constructor(
    private billService: BillService,
    private router: Router
  ) { }

  ngOnInit(): void {
  }
  submit() {
    console.log(this.bill)

    this.billService.addBill(this.bill)
      .subscribe(data => {
        this.router.navigate(["bills"])
      })
  }

}
