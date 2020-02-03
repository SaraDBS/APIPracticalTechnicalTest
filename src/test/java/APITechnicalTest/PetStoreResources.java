package APITechnicalTest;

/**
 * Created by Sara on 03/02/2020.
 */
public class PetStoreResources {

    public static String postPet(){

        String resource = "/pet";
        return resource;

    }

    public static String deletePet(){

        String resource = "/pet/{petId}";
        return resource;
    }

    public static String getPet(){
        String resource = "/pet/{petId}";
        return resource;
    }

    public static String putUpdatePet(){
        String resource = "/pet";
        return resource;
    }


}
