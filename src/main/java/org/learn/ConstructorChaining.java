package org.learn;

public class ConstructorChaining {
    int age;
    int rollNum;
    String firstName;
    String middleName;
    String lastName;
    String collegeName;
    String address;

    ConstructorChaining(int age, int rollNum, String firstName, String middleName, String lastName, String collegeName, String address){
        this.age = age;
        this.rollNum = rollNum;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.collegeName = collegeName;
        this.address = address;
        
    }
    ConstructorChaining(int age, int rollNum, String firstName, String lastName, String collegeName, String address){
        
        this(age,rollNum, firstName,null, lastName, collegeName, address);
        
    }

    @Override
    public String toString() {
        return "ConstructorChaining{" +
                "age=" + age +
                ", rollNum=" + rollNum +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", collegeName='" + collegeName + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public static void main(String[] args) {

        ConstructorChaining c = new ConstructorChaining(8,10,"Praveen", "Baliga", "MIT", "Manipal");
        System.out.println(c);

    }
}
