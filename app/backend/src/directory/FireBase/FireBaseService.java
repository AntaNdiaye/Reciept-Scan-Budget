package directory.FireBase;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;

import java.util.concurrent.ExecutionException;

public class FireBaseService {
    public String saveReceipt(String url) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionApiFuture = dbFirestore.collection("reciepts").document(url).set(url);
        return collectionApiFuture.get().getUpdateTime().toString();
    }
}