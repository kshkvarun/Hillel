
package Task3.Part2;

import com.google.gson.annotations.SerializedName;

public class MainModel
{

    @SerializedName("menu")
    private Menu menu;

    public MainModel() {
    }

    public MainModel(Menu menu) {
        super();
        this.menu = menu;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    @Override
    public String toString() {
        return "Docs{" +
                "menu=" + menu +
                '}';
    }
}