package directory.exceptions.receipt;

public class ReceiptNotFoundException extends RuntimeException {
    public ReceiptNotFoundException (Long receiptId) {
        super("Customer" + receiptId + " not found");
    }
}
