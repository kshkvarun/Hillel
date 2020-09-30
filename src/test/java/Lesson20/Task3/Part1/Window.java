package Lesson20.Task3.Part1;

import com.google.gson.annotations.SerializedName;

public class Window {

    @SerializedName("title")
    private String title;
    @SerializedName("name")
    private String name;
    @SerializedName("width")
    private Integer width;
    @SerializedName("height")
    private Integer height;


    public Window() {
    }


    public Window(String title, String name, Integer width, Integer height) {
        this.title = title;
        this.name = name;
        this.width = width;
        this.height = height;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "Window{" +
                "title='" + title + '\'' +
                ", name='" + name + '\'' +
                ", width=" + width +
                ", height=" + height +
                '}';
    }
}