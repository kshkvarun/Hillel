
package Task3.Part2;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Popup {

    @SerializedName("menuitem")
    private List<MenuItems> menuItems = new ArrayList<MenuItems>();

    public Popup() {
    }


    public Popup(List<MenuItems> menuItems) {
        this.menuItems = menuItems;
    }

    public List<MenuItems> getMenuitem() {
        return menuItems;
    }


    @Override
    public String toString() {
        return "Popup{" +
                "menuitem=" + menuItems +
                '}';
    }
}