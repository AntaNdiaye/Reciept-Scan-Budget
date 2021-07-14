package directory.Controllers;

import com.google.cloud.vision.v1.AnnotateImageResponse;
import com.google.cloud.vision.v1.Feature;
import directory.services.OCRService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gcp.vision.CloudVisionTemplate;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VisionController {

    @Autowired
    private ResourceLoader resourceLoader;

    @Autowired
    private CloudVisionTemplate cloudVisionTemplate;

    /**
     * get classification labels from an image
     * @return
     */
    @RequestMapping("/getLabels")
    public String getLabelDetection() {

        Resource imageResource = this.resourceLoader.getResource("file:/app/sampleFiles/recieptTest1.jpg");
        AnnotateImageResponse response = this.cloudVisionTemplate.analyzeImage(
                imageResource, Feature.Type.LABEL_DETECTION);

        return response.getLabelAnnotationsList().toString();
    }

    /**
     * get text from an image
     * @return
     */
    @RequestMapping("/getText")
    public String getTextDetection() {

        Resource imageResource = this.resourceLoader.getResource("file:/app/sampleFiles/recieptTest1.jpg");
        AnnotateImageResponse response = this.cloudVisionTemplate.analyzeImage(
                imageResource, Feature.Type.DOCUMENT_TEXT_DETECTION);

        return response.getTextAnnotationsList().toString();
    }



}
