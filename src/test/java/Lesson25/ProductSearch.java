package Lesson25;

import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductSearch {

    public int productSearch(List<WebElement> priceList, String firstPriceWithoutSpaces, int firstPrice, int firstPriceIndex, int counter  ){
        for (WebElement firstItemPrice : priceList) {
            firstPriceWithoutSpaces = firstItemPrice.getText().replaceAll("\\s+", "");
            firstPrice = Integer.parseInt(firstPriceWithoutSpaces);

            if (firstPrice < 3000) {
                firstPriceIndex = priceList.indexOf(firstItemPrice);
                counter++;
            }
            if (counter > 0) {
                break;
            }
        }
        return firstPriceIndex;
    }
}
