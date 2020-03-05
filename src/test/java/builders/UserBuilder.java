package builders;

import entities.User;

public class UserBuilder {

    private User user;


    public UserBuilder() {

        user = new User();

    }


    public UserBuilder(User user) {
        this.user = user;
    }


    public UserBuilder withEmail(String email) {

        user.setEmail(email);

        return this;

    }


    public UserBuilder withPassword(String password) {

        user.setPassword(password);

        return this;

    }


    public UserBuilder withGender(String gender) {

        user.setGender(gender);

        return this;

    }


    public UserBuilder withName(String name) {

        user.setName(name);

        return this;

    }


    public UserBuilder withFatherLastname(String lastName) {

        user.setFatherLastName(lastName);

        return this;

    }


    public UserBuilder withMotherLastName(String lastName) {

        user.setMotherLastName(lastName);

        return this;

    }


    public UserBuilder withCountry(String country) {

        user.setCountry(country);

        return this;

    }

    public UserBuilder withDocumentType(String documentType) {

        user.setDocType(documentType);

        return this;

    }


    public UserBuilder withNumDocument(int numDocument) {

        user.setNumDocument(numDocument);

        return this;

    }

    public UserBuilder withDay(int day) {

        user.setDay(day);

        return this;

    }

    public UserBuilder withMonth(int month) {

        user.setMonth(month);

        return this;

    }


    public UserBuilder withYear(int year) {

        user.setYear(year);

        return this;

    }

    public UserBuilder withCellphone(int cellphone) {

        user.setCellphone(cellphone);

        return this;

    }


    public User create() {

        return this.user;

    }
}
