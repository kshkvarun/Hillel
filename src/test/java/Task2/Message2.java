package Task2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name = "Message")
@XmlAccessorType(XmlAccessType.FIELD)
public class Message2 {

        @XmlElement(name = "DateTime")
        private String dateTime;

        @XmlElement(name = "CustomerId")
        private String customerId;

        @XmlElement(name = "CompanyName")
        private String companyName;

        @XmlElement(name = "CustomerNumber")
        private String customerNumber;

        @XmlElement(name = "MessageDetails")
        private MessageDetails messageDetails;

        @XmlElement(name = "Issues")
        private Issues issues;

        public Message2() {
        }

        public Message2(String dateTime, String customerId, String companyName, String customerNumber, MessageDetails messageDetails, Issues issues) {
                this.dateTime = dateTime;
                this.customerId = customerId;
                this.companyName = companyName;
                this.customerNumber = customerNumber;
                this.messageDetails = messageDetails;
                this.issues = issues;
        }

        public String getDateTime() {
                return dateTime;
        }

        public void setDateTime(String dateTime) {
                this.dateTime = dateTime;
        }

        public String getCustomerId() {
                return customerId;
        }

        public void setCustomerId(String customerId) {
                this.customerId = customerId;
        }

        public String getCompanyName() {
                return companyName;
        }

        public void setCompanyName(String companyName) {
                this.companyName = companyName;
        }

        public String getCustomerNumber() {
                return customerNumber;
        }

        public void setCustomerNumber(String customerNumber) {
                this.customerNumber = customerNumber;
        }

        public MessageDetails getMessageDetails() {
                return messageDetails;
        }

        public void setMessageDetails(MessageDetails messageDetails) {
                this.messageDetails = messageDetails;
        }

        public Issues getIssues() {
                return issues;
        }

        public void setIssues(Issues issues) {
                this.issues = issues;
        }

        @Override
        public String toString() {
                return "Message2{" +
                        "dateTime='" + dateTime + '\'' +
                        ", customerId='" + customerId + '\'' +
                        ", companyName='" + companyName + '\'' +
                        ", customerNumber='" + customerNumber + '\'' +
                        ", messageDetails=" + messageDetails +
                        ", issues=" + issues +
                        '}';
        }
}
