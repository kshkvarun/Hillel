package Task2;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileOutputStream;

public class Run {
    public static void main(String[] args) {
        Message2 message1 = null;

        try{
            File file = new File("/home/kostya/Task2.3.Maven/src/test/java/Task2/xml1.xml");
            JAXBContext jContext = JAXBContext.newInstance(Message2.class);
            Unmarshaller unmarshallerObj = jContext.createUnmarshaller();
            message1= (Message2) unmarshallerObj.unmarshal(file);
            System.out.println(message1);
        }catch(Exception e){
            e.printStackTrace();
        }

        message1.setCustomerId("34");
        message1.setCompanyName("Hillel2");
        message1.setCustomerNumber("666");
        message1.setDateTime("2012");

        try {
            JAXBContext jContext = JAXBContext.newInstance(Message2.class);
            Marshaller marshallObj = jContext.createMarshaller();
            marshallObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshallObj.marshal(message1, new FileOutputStream("/home/kostya/Task2.3.Maven/src/test/java/Task2/final2.xml"));
        } catch (Exception e) {
            e.printStackTrace();
        }


        Message2 message2 = null;
        try {
            File file = new File("/home/kostya/Task2.3.Maven/src/test/java/Task2/xml2.xml");
            JAXBContext jContext = JAXBContext.newInstance(Message2.class);
            Unmarshaller unmarshallerObj = jContext.createUnmarshaller();
            message2 = (Message2) unmarshallerObj.unmarshal(file);
            System.out.println(message2);
        } catch (Exception e) {
            e.printStackTrace();
        }

        message2.setCompanyName("Hillel");
        message2.getMessageDetails().setDatatype("Second level xml changing");

        for(int i = 0; i< message2.getIssues().getIssues1().size(); i++){
            message2.getIssues().getIssues1().get(i).setType(i);
            message2.getIssues().getIssues1().get(i).setIssue2("New value" + i);
        }


        try {
            JAXBContext jContext = JAXBContext.newInstance(Message2.class);
            Marshaller marshallObj = jContext.createMarshaller();
            marshallObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshallObj.marshal(message2, new FileOutputStream("/home/kostya/Task2.3.Maven/src/test/java/Task2/final.xml"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
