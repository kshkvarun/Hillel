//package Lesson25;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
//
//import java.util.List;
//
//public class FindProduct {
//
//    public int findProduct (List<WebElement> elementList){
//        int firstPrice;
//        int firstPriceIndex = 0;
//        String priceWithoutSpaces;
//        int counter = 0;
//        for (WebElement element : elementList) {
//            priceWithoutSpaces = element.getText().replaceAll("\\s+", "");
//            firstPrice = Integer.parseInt(priceWithoutSpaces);
//
//            if (firstPrice < 3000) {
//                firstPriceIndex = elementList.indexOf(element);
//                counter++;
//            }
//            if (counter > 0) {
//                break;
//            }
//        }
//        return firstPriceIndex;
//    }
//
//
//
//}
