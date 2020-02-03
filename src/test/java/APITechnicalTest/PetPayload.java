package APITechnicalTest;

/**
 * Created by Sara on 03/02/2020.
 */
public class PetPayload {

    public static String getPostBody(){

        String bodyData = "{\"id\":5,\"category\":{\"id\":1,\"name\":\"Dog\"},\"name\":\"Ruby\",\"photoUrls\":[\"pug.jpg\"],\"tags\":[{\"id\":1,\"name\":\"Ruby\"}],\"status\":\"available\"}";
        return bodyData;
    }

    public static String getPutBody(){

        String bodyData = "{\"id\":5,\"category\":{\"id\":1,\"name\":\"Dog\"},\"name\":\"Lola\",\"photoUrls\":[\"pug.jpg\"],\"tags\":[{\"id\":1,\"name\":\"Ruby\"}],\"status\":\"available\"}";
        return bodyData;
    }
}
