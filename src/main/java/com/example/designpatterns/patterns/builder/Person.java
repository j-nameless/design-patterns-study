package com.example.designpatterns.patterns.builder;

/**
 * className Person
 * date 2021/2/18
 *
 * @author JC
 */
public class Person {
    private String sex;
    private int age;
    private int phone;
    private String name;
    private String cardId;

    public static class Builder {
        private final String sex;
        private final int age;
        private int phone;
        private final String name;
        private String cardId;

        public Builder(String sex, int age, String name) {
            this.sex = sex;
            this.age = age;
            this.name = name;
        }

        public Builder setPhone(int phone) {
            this.phone = phone;
            return this;
        }
        public Builder setCardId(String cardId) {
            this.cardId = cardId;
            return this;
        }

        public Person buildPerson() {
            return new Person(this);
        }
    }
    private Person(Builder builder) {
        this.sex= builder.sex;
        this.age = builder.age;
        this.name = builder.name;
        this.phone = builder.phone;
        this.cardId = builder.cardId;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    @Override
    public String toString() {
        return "Person{" +
                "sex='" + sex + '\'' +
                ", age=" + age +
                ", phone=" + phone +
                ", name='" + name + '\'' +
                ", cardId='" + cardId + '\'' +
                '}';
    }


}
