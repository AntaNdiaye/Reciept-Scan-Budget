package directory.FireBase;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import java.util.concurrent.ExecutionException;

public class FireBaseService {
    //adding to the database
    public String saveReceipt(String url) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();//connects to the Firestore
        ApiFuture<WriteResult> collectionApiFuture = dbFirestore.collection("reciepts").document(url).set(url);//save new info to Firestore
        return collectionApiFuture.get().getUpdateTime().toString();// return a time stamp, something to show that it worked
    }
    //retrieval from the database
    public String getReceipt(String url) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();//connects to the Firestore
        DocumentReference documentReference = dbFirestore.collection("reciepts").document(url);//get info from Firestore
        ApiFuture<DocumentSnapshot> future = documentReference.get();

        return future.get().toString();//should return the url from the database
    }

}