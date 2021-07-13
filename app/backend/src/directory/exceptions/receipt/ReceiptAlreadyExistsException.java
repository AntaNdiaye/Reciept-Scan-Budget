package directory.exceptions.receipt;

public class ReceiptAlreadyExistsException extends RuntimeException{
    public ReceiptAlreadyExistsException(Long receiptId) {
        super("Custer " + receiptId + " already present in db");
    }
}
