package Lesson20.Task2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class MessageDetails {

    @XmlElement(name = "MessageId")
    private String messageId;

    @XmlElement(name = "Datatype")
    private String datatype;

    @XmlElement(name = "Type")
    private String type;

    @XmlElement(name = "DatatypeDescription")
    private String datatypeDescription;

    @XmlElement(name = "OriginalFilename")
    private String originalFilename;

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getDatatype() {
        return datatype;
    }

    public void setDatatype(String datatype) {
        this.datatype = datatype;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDatatypeDescription() {
        return datatypeDescription;
    }

    public void setDatatypeDescription(String datatypeDescription) {
        this.datatypeDescription = datatypeDescription;
    }

    public String getOriginalFilename() {
        return originalFilename;
    }

    public void setOriginalFilename(String originalFilename) {
        this.originalFilename = originalFilename;
    }

    public MessageDetails() {
    }

    public MessageDetails(String messageId, String datatype, String type, String datatypeDescription, String originalFilename) {
        this.messageId = messageId;
        this.datatype = datatype;
        this.type = type;
        this.datatypeDescription = datatypeDescription;
        this.originalFilename = originalFilename;
    }

    @Override
    public String toString() {
        return "MessageDetails{" +
                "messageId='" + messageId + '\'' +
                ", datatype='" + datatype + '\'' +
                ", type='" + type + '\'' +
                ", datatypeDescription='" + datatypeDescription + '\'' +
                ", driginalFilename='" + originalFilename + '\'' +
                '}';
    }
}
