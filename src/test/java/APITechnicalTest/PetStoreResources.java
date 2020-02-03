package APITechnicalTest;

/**
 * Created by Sara on 03/02/2020.
 */
class PetStoreResources {

    static String postPet(){

        return "/pet";

    }

    static String deletePet(){

        return "/pet/{petId}";
    }

    static String getPet(){
        return "/pet/{petId}";
    }

    static String putUpdatePet(){
        return "/pet";
    }


}
