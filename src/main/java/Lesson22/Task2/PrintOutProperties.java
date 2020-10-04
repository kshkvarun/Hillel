package Lesson22.Task2;

public class PrintOutProperties {


    public static void main(String[] args) {
        //String timeoutValue = PropertyReader.getInstance().getValueFromProperty("defaultTimeout");
        String baseUrlValue = PropertyReader.getInstance().getValueFromProperty("baseUrl");

        //System.out.println("timeoutValue" + timeoutValue);
        System.out.println("baseUrlValue" + baseUrlValue);
    }

}

