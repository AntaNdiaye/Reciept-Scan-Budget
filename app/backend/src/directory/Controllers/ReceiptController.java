package directory.Controllers;

import directory.exceptions.receipt.ReceiptNotFoundException;
import directory.models.Receipt;
import directory.services.ReceiptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/receipts")
public class ReceiptController {

	private final ReceiptService receiptService;

	@Autowired
	public ReceiptController(ReceiptService receiptService) {
		this.receiptService = receiptService;
	}

	@PutMapping("/user/{receiptId}/receipt")
	@CrossOrigin
	public Receipt newReceipt(Receipt receipt) {
		return this.receiptService.createReceipt(receipt);
	}

	@GetMapping(value = "/byId/{receiptId}")
	@CrossOrigin
	public Receipt getReceiptById(@PathVariable Long receiptId) throws ReceiptNotFoundException {
		return this.receiptService.getReceiptById(receiptId);
	}

	@GetMapping("/")
	@CrossOrigin
	public List<Receipt> getAllReceipts() {
		return receiptService.getAllReceipts();
	}
}