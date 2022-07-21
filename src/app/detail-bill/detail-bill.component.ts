import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { BillService } from '../bill.service';
import { Bill } from '../models/bill';

@Component({
  selector: 'app-detail-bill',
  templateUrl: './detail-bill.component.html',
  styleUrls: ['./detail-bill.component.scss']
})
export class DetailBillComponent implements OnInit {
  paid_date: Date = new Date()
  bill_date: Date = new Date()
  amount: number = 0
  unit: number = 0
  id: number
  constructor(
    private billService: BillService,
    private router: Router, private route: ActivatedRoute
  ) { }

  ngOnInit(): void {
    let id: number = this.route.snapshot.params["id"]
    this.id = id
    this.billService.getBillById(id)
      .subscribe(data => {
        this.amount = data.amount
        this.unit = data.unit
        this.bill_date = new Date(data.bill_date)
        this.paid_date = new Date(data.paid_date)
      })
  }

  deleteBill() {
    this.billService.delete(this.id)
      .subscribe(data => {
        alert(data)
        this.router.navigateByUrl("bills")
      })
  }
  updateBill() {
    this.router.navigate(["update", this.id])
  }

}
