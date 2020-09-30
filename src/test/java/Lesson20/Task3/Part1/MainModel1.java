package Lesson20.Task3.Part1;

import com.google.gson.annotations.SerializedName;

public class MainModel1 {

    @SerializedName("widget")
    private Widget widget;

    public MainModel1() {
    }


    public MainModel1(Widget widget) {
        super();
        this.widget = widget;
    }

    public Widget getWidget() {
        return widget;
    }

    public void setWidget(Widget widget) {
        this.widget = widget;
    }

    @Override
    public String toString() {
        return "MainModel1{" +
                "widget=" + widget +
                '}';
    }
}