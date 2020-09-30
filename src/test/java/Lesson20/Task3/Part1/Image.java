package Lesson20.Task3.Part1;

import com.google.gson.annotations.SerializedName;

public class Image {

    @SerializedName("src")
    private String src;
    @SerializedName("name")
    private String name;
    @SerializedName("hOffset")
    private Integer hOffset;
    @SerializedName("vOffset")
    private Integer vOffset;
    @SerializedName("alignment")
    private String alignment;


    public Image() {
    }

    public Image(String src, String name, Integer hOffset, Integer vOffset,
                 String alignment) {
        super();
        this.src = src;
        this.name = name;
        this.hOffset = hOffset;
        this.vOffset = vOffset;
        this.alignment = alignment;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
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

    @Override
    public String toString() {
        return "Image{" +
                "src='" + src + '\'' +
                ", name='" + name + '\'' +
                ", hOffset=" + hOffset +
                ", vOffset=" + vOffset +
                ", alignment='" + alignment + '\'' +
                '}';
    }
}