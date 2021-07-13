package directory.FireBase;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.FileInputStream;


@Service
public class FireBaseInitialize {
    @PostConstruct
    public void initialize() {
        try {
            // finds the fireBase key at "./serviceAccountKey.json"
            FileInputStream serviceAccount =
                    new FileInputStream("./serviceAccountKey.json");
            // sets up the connection with the data base
            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .setDatabaseUrl("https://reciepttracker-c693d.firebase.com/").build();
            // starts up the dataBase
            FirebaseApp.initializeApp(options);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
