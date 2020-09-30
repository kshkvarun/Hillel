package Lesson20.Task3.Part2;

import com.google.gson.annotations.SerializedName;

public class MenuItems
{

    @SerializedName("value")
    private String value;
    @SerializedName("onclick")
    private String onclick;

    public MenuItems() {
    }


    public MenuItems(String value, String onclick) {
        this.value = value;
        this.onclick = onclick;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getOnclick(String onclick) {
        return onclick;
    }

    public void setOnclick(String onclick) {
        this.onclick = onclick;
    }

    @Override
    public String toString() {
        return "Menuitem{" +
                "value='" + value + '\'' +
                ", onclick='" + onclick + '\'' +
                '}';
    }
}