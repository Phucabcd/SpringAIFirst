package ntp.springaifirst.dto;

import java.util.List;

public class BIllSummary {
    private List<BillItems> billItems;
    private int totalQuantity;
    private int totalPrice;

    public BIllSummary(List<BillItems> billItems) {
        this.billItems = billItems;
        this.totalQuantity = billItems.stream().mapToInt(BillItems::quantity).sum();
        this.totalPrice = billItems.stream().mapToInt(BillItems::price).sum();
    }
}
