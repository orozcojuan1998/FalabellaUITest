package entities;

public class User {

    private String email;
    private String password;
    private String name;
    private String fatherLastName;
    private String motherLastName;
    private String country;
    private String docType;
    private int numDocument;
    private String gender;
    private int day;
    private int month;
    private int year;
    private int cellphone;


    public User(){}

    public User(String email, String password, String name, String fatherLastName, String motherLastName, String country, String docType, int numDocument, String gender, int day, int month, int year, int cellphone) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.fatherLastName = fatherLastName;
        this.motherLastName = motherLastName;
        this.country = country;
        this.docType = docType;
        this.numDocument = numDocument;
        this.gender = gender;
        this.day = day;
        this.month = month;
        this.year = year;
        this.cellphone = cellphone;
    }



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFatherLastName() {
        return fatherLastName;
    }

    public void setFatherLastName(String fatherLastName) {
        this.fatherLastName = fatherLastName;
    }

    public String getMotherLastName() {
        return motherLastName;
    }

    public void setMotherLastName(String motherLastName) {
        this.motherLastName = motherLastName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDocType() {
        return docType;
    }

    public void setDocType(String docType) {
        this.docType = docType;
    }

    public int getNumDocument() {
        return numDocument;
    }

    public void setNumDocument(int numDocument) {
        this.numDocument = numDocument;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String genre) {
        this.gender = genre;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getCellphone() {
        return cellphone;
    }

    public void setCellphone(int cellphone) {
        this.cellphone = cellphone;
    }
}
