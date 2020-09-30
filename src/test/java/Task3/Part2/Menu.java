
package Task3.Part2;

import com.google.gson.annotations.SerializedName;

public class Menu
{

    @SerializedName("id")
    private String id;
    @SerializedName("value")
    private String value;
    @SerializedName("popup")
    private Popup popup;

    public Menu() {
    }

    public Menu(String id, String value, Popup popup) {
        super();
        this.id = id;
        this.value = value;
        this.popup = popup;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Popup getPopup() {
        return popup;
    }

    public void setPopup(Popup popup) {
        this.popup = popup;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id='" + id + '\'' +
                ", value='" + value + '\'' +
                ", popup=" + popup +
                '}';
    }
}