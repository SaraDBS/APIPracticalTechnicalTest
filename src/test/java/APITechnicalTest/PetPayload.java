package APITechnicalTest;

/**
 * Created by Sara on 03/02/2020.
 */
class PetPayload {

    static String getPostBody(){

        return "{\"id\":5,\"category\":{\"id\":1,\"name\":\"Dog\"},\"name\":\"Ruby\",\"photoUrls\":[\"pug.jpg\"],\"tags\":[{\"id\":1,\"name\":\"Ruby\"}],\"status\":\"available\"}";
    }

    static String getPutBody(){

        return "{\"id\":5,\"category\":{\"id\":1,\"name\":\"Dog\"},\"name\":\"Lola\",\"photoUrls\":[\"pug.jpg\"],\"tags\":[{\"id\":1,\"name\":\"Ruby\"}],\"status\":\"available\"}";
    }
}
