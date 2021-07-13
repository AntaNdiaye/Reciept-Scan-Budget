package Service;

import Models.Receipt;
import Repository.RecieptRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecieptService {

	@Autowired
	private RecieptRepo recieptRepo;

	public List<Receipt> getAllReceipts() {
		return recieptRepo.findAll();
	}

}