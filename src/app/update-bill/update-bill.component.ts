import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { BillService } from '../bill.service';
import { Bill } from '../models/bill';

@Component({
  selector: 'app-update-bill',
  templateUrl: './update-bill.component.html',
  styleUrls: ['./update-bill.component.scss']
})
export class UpdateBillComponent implements OnInit {

  bill: Bill = new Bill()
  constructor(
    private billService: BillService,
    private router: Router, private route: ActivatedRoute
  ) { }

  ngOnInit(): void {
    let id: number = this.route.snapshot.params["id"]
    this.billService.getBillById(id)
      .subscribe(data => {
        //  console.log(data)
        this.bill = data
      })
  }
  submit() {
    console.log(this.bill)

    this.billService.update(this.bill)
      .subscribe(data => {
        console.log("data")
        console.log(data)
        this.router.navigate(["bills"])
      })
  }

}
