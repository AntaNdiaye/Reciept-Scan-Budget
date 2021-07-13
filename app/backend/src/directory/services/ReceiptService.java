package directory.services;

import directory.exceptions.receipt.ReceiptAlreadyExistsException;
import directory.exceptions.receipt.ReceiptNotFoundException;
import directory.models.Receipt;
import directory.repositories.ReceiptRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReceiptService {

	@Autowired
	private ReceiptRepo receiptRepo;

	public Receipt createReceipt(Receipt newReceipt) throws ReceiptAlreadyExistsException {
		if (receiptRepo.existsById(newReceipt.getReceiptId())) {
			throw new ReceiptAlreadyExistsException(newReceipt.getReceiptId());
		}
		return receiptRepo.save(newReceipt);
	}

	public Receipt getReceiptById(Long id) throws ReceiptNotFoundException {
		if (receiptRepo.existsById(id)) {
			return receiptRepo.findById(id).orElseThrow(() -> new ReceiptNotFoundException(id));
		}
		throw new ReceiptNotFoundException(id);
	}

	public List<Receipt> getAllReceipts() {
		return receiptRepo.findAll();
	}


}