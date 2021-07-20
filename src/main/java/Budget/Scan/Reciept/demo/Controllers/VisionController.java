package Budget.Scan.Reciept.demo.Controllers;


import com.google.cloud.language.v1.*;
import com.google.cloud.vision.v1.AnnotateImageResponse;
import com.google.cloud.vision.v1.EntityAnnotation;
import com.google.cloud.vision.v1.Feature.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gcp.vision.CloudVisionTemplate;
import org.springframework.core.io.ResourceLoader;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class VisionController {

    @Autowired
    private ResourceLoader resourceLoader;

    @Autowired
    private CloudVisionTemplate cloudVisionTemplate;

    /**
     * Send image URL to vision api for general "what is this image" analysis
     * @return a list of labels of type string
     */
    @GetMapping("/properties")
    public ModelAndView properties(String imageUrl, ModelMap map) {
        AnnotateImageResponse response = this.cloudVisionTemplate.analyzeImage(
                this.resourceLoader.getResource(imageUrl), Type.LABEL_DETECTION);

        List<EntityAnnotation> characteristics = response.getLabelAnnotationsList();
        map.addAttribute("characteristics", characteristics);
        map.addAttribute("imageUrl", imageUrl);

        return new ModelAndView("result", map);
    }

    /**
     * Send image URL to vision api for "text extract" analysis
     * @return a list of labels of type string
     */
    @GetMapping("/recieptItems")
    public ModelAndView recieptItems(String imageUrl, ModelMap map) {
        String input = this.cloudVisionTemplate.extractTextFromImage(
                this.resourceLoader.getResource(imageUrl));

        map.addAttribute("input", input);
        map.addAttribute("imageUrl", imageUrl);

        return new ModelAndView("result", map);
    }

    /**
     * Extracts category from text
     * @return a list of labels of type string
     */
    @CrossOrigin
    @GetMapping("/categorize")
    public ModelAndView categorizeText(ModelMap map) throws Exception {

        String textFeed = "Optd by: Bag of Beans Cafe & Restaurant Inc. BAG OF BEANS CAFE & RESTAURANT INC 117 Aguinaldo Highway Crossing Mendez 117 Aguinaldo Highway Crossing Mendez West Tagaytay City Cavite 4120 TIN: 008-117-738-000 VAT O.R. #: 783944 Cashier: Eloisa 11/5/2019 Guest:3 1:24:50 PM 1 170.00 100.00 165.00 Coffee Choco Banana 1 HotGreen Tea 1 D White mocha 1 Blueberry Cheesecake [Slice] 175.00 SubTotal 610.00 PreTax 544.64 Serv Charge.(10%) 12% VAT 54.46 65.36 Amount Due 664.46";
        try (LanguageServiceClient language = LanguageServiceClient.create()) {

            Document doc = Document.newBuilder()
                    .setContent(textFeed)
                    .setType(Document.Type.PLAIN_TEXT)
                    .build();

            ClassifyTextRequest request = ClassifyTextRequest.newBuilder()
                    .setDocument(doc)
                    .build();

            ClassifyTextResponse response = language.classifyText(request);
            for (ClassificationCategory category : response.getCategoriesList()) {

                String getName = category.getName().toString();
//                String getConfidence = String.valueOf(category.getConfidence());

                map.addAttribute("name", getName);
//                map.addAttribute("confidence", getConfidence);
            }
            map.addAttribute("textFeed", textFeed);
            return new ModelAndView("result", map);
        }
    }

}



