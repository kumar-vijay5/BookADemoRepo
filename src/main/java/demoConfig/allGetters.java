package demoConfig;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class allGetters {
    String firstName, lastName, companyName, emailAddress, phoneNumber, jobsTitle, countryName;
    public allGetters() throws IOException {
        String propertyfile = "src/main/java/demoConfig/testData.Properties";
        FileInputStream demoData = new FileInputStream(propertyfile);
        Properties prop = new Properties();
        prop.load(demoData);
        firstName = prop.getProperty("fName");
        lastName = prop.getProperty("lName");
        companyName = prop.getProperty("cName");
        emailAddress = prop.getProperty("email");
        phoneNumber = prop.getProperty("phoneNumb");
        jobsTitle = prop.getProperty("jobTitle");
        countryName = prop.getProperty("country");
    }

    public String getfirstName() {
        return firstName;
    }

    public String getlastName() {
        return lastName;
    }

    public String getccompanyName() { return companyName; }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getJobTitle() {
        return jobsTitle;
    }

    public String getCountryName() {
        return countryName;
    }

}
