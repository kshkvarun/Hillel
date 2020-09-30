package Lesson20.Task3.Part1;

import com.google.gson.annotations.SerializedName;

public class Text {

    @SerializedName("data")
    private String data;
    @SerializedName("size")
    private Integer size;
    @SerializedName("style")
    private String style;
    @SerializedName("name")
    private String name;
    @SerializedName("hOffset")
    private Integer hOffset;
    @SerializedName("vOffset")
    private Integer vOffset;
    @SerializedName("alignment")
    private String alignment;
    @SerializedName("onMouseUp")
    private String onMouseUp;


    public Text() {
    }


    public Text(String data, Integer size, String style, String name, Integer hOffset,
                Integer vOffset, String alignment, String onMouseUp) {
        super();
        this.data = data;
        this.size = size;
        this.style = style;
        this.name = name;
        this.hOffset = hOffset;
        this.vOffset = vOffset;
        this.alignment = alignment;
        this.onMouseUp = onMouseUp;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getHOffset() {
        return hOffset;
    }

    public void setHOffset(Integer hOffset) {
        this.hOffset = hOffset;
    }

    public Integer getVOffset() {
        return vOffset;
    }

    public void setVOffset(Integer vOffset) {
        this.vOffset = vOffset;
    }

    public String getAlignment() {
        return alignment;
    }

    public void setAlignment(String alignment) {
        this.alignment = alignment;
    }

    public String getOnMouseUp() {
        return onMouseUp;
    }

    public void setOnMouseUp(String onMouseUp) {
        this.onMouseUp = onMouseUp;
    }

    @Override
    public String toString() {
        return "Text{" +
                "data='" + data + '\'' +
                ", size=" + size +
                ", style='" + style + '\'' +
                ", name='" + name + '\'' +
                ", hOffset=" + hOffset +
                ", vOffset=" + vOffset +
                ", alignment='" + alignment + '\'' +
                ", onMouseUp='" + onMouseUp + '\'' +
                '}';
    }
}