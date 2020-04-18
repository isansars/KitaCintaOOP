public class SpaceFullException extends Exception {

    //konstruktor
    public SpaceFullException() {
        //konstruksi dilakukan oleh Java
    }

    public String getMessage() {
        return "Petak telah terisi.";
    }
}