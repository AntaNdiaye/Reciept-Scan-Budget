package Budget.Scan.Reciept.demo.Services;

import com.google.cloud.language.v1.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    Logger log = LoggerFactory.getLogger(CategoryService.class);

    public static void main(String... args) throws Exception {
        try (LanguageServiceClient language = LanguageServiceClient.create()) {

            //text from sample reciept image (url in text file in resources folder)
            String text = "Optd by: Bag of Beans Cafe & Restaurant Inc. BAG OF BEANS CAFE & RESTAURANT INC 117 Aguinaldo Highway Crossing Mendez 117 Aguinaldo Highway Crossing Mendez West Tagaytay City Cavite 4120 TIN: 008-117-738-000 VAT O.R. #: 783944 Cashier: Eloisa 11/5/2019 Guest:3 1:24:50 PM 1 170.00 100.00 165.00 Coffee Choco Banana 1 HotGreen Tea 1 D White mocha 1 Blueberry Cheesecake [Slice] 175.00 SubTotal 610.00 PreTax 544.64 Serv Charge.(10%) 12% VAT 54.46 65.36 Amount Due 664.46";

            Document doc = Document.newBuilder().setContent(text).setType(Document.Type.PLAIN_TEXT).build();
            ClassifyTextRequest request = ClassifyTextRequest.newBuilder().setDocument(doc).build();
            ClassifyTextResponse response = language.classifyText(request);

            //iterating out the category and percent confidence score
            for (ClassificationCategory category : response.getCategoriesList()) {
                System.out.printf("\nCategory of text: " + category.getName() + ". Confidence score: " + category.getConfidence());
            }
        }
    }

}







