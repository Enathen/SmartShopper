package creativeendlessgrowingceg.smartshopper.Account;

import android.widget.TextView;

import creativeendlessgrowingceg.smartshopper.Connections.ServiceLogin;
import creativeendlessgrowingceg.smartshopper.R;

/**
 * Created by Enathen on 2017-07-16.
 */

public class Account {
    private int age;
    private String email;
    private String gender;
    private String classification;
    private String password;
    private String username;
    private String firstName;
    private String lastName;

    public Account() {

    }


    public boolean checkAge(TextView age) {
        Age ageClass = new Age(this.age);
        return ageClass.checkAge(age);
    }

    public boolean checkEmail(TextView email) {
        Email emailClass = new Email(this.email);
        return emailClass.emailCorrectFormat(email);

    }

    public boolean checkPassword(TextView password) {
        Password passwordClass = new Password(this.password);
        return passwordClass.checkPassword(password);
    }

    public boolean checkUsername(TextView username) {
        Username usernameClass = new Username(this.username);
        return usernameClass.checkUsername(username);
    }

    public boolean checkFirstName(TextView firstName) {
        firstName.setText(R.string.firstNameCreate);
        if (this.firstName.length() > 50) {
            firstName.setText(R.string.errorFirstNameLong);
            return false;
        }
        if (this.firstName.length() < 1) {
            firstName.setText(R.string.errorFirstNameShort);
            return false;
        }
        return true;
    }

    public boolean checkLastName(TextView lastName) {
        lastName.setText(R.string.lastNameCreate);
        if (this.lastName.length() > 50) {
            lastName.setText(R.string.errorLastNameLong);
            return false;
        }
        if (this.lastName.length() < 1) {
            lastName.setText(R.string.errorLastNameShort);
            return false;
        }
        return true;
    }


    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean loginAccount(String... params) {
        return false;
    }

    /**
     * firstName,lastName,email,salt,hash,username,age,gender,class
     * try to create account.
     * @return
     */
    public boolean createAccount() {
        Password password = new Password(this.password);

        new ServiceLogin().execute(firstName, lastName, email, password.createSalt(),
                password.createHash(), username, Integer.toString(age), gender, classification);

        return true;

    }

}
