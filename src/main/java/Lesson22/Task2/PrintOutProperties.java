package Lesson22.Task2;

public class PrintOutProperties {


    public static void main(String[] args) {

        String baseUrlValue = PropertyReader.getInstance().getValueFromProperty("baseUrl");
        String fName = PropertyReader.getInstance().getValueFromProperty("firstName");
        String sName = PropertyReader.getInstance().getValueFromProperty("secondName");

        System.out.println("baseUrlValue: " + baseUrlValue);
        System.out.println("firstName: " + fName);
        System.out.println("secondName: " + sName);
    }

}

