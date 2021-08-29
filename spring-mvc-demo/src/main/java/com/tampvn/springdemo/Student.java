package com.tampvn.springdemo;

import java.util.LinkedHashMap;

public class Student {
    private String firstName;
    private String lastName;

    private String country;

    private LinkedHashMap<String, String> countryOptions;

    private String favoriteLanguage;

    private LinkedHashMap<String, String> favoriteLanguageOptions;

    private String[] operatingSystem;

//    private LinkedHashMap<String[], String> operatingSystemOptions;

    public Student(){
        countryOptions = new LinkedHashMap<>();
        //Populate country options: used ISO country code
        countryOptions.put("JH", "Jhin");
        countryOptions.put("EZ", "Ezreal");
        countryOptions.put("AS", "Ashe");
        countryOptions.put("KS", "Kaisa");
        countryOptions.put("YS", "Yasuo");

        favoriteLanguageOptions = new LinkedHashMap<>();

        favoriteLanguageOptions.put("Java", "Java");
        favoriteLanguageOptions.put("C#", "C#");
        favoriteLanguageOptions.put("Python", "Python");
        favoriteLanguageOptions.put("JavaScript", "JavaScript");

//        operatingSystemOptions = new LinkedHashMap<>();
//
//        operatingSystemOptions.put("Windows", "Windows");
//        operatingSystemOptions.put("Linux", "Linux");
//        operatingSystemOptions.put("MacOS", "Macos");
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public LinkedHashMap<String, String> getCountryOptions() {
        return countryOptions;
    }

    public String getFavoriteLanguage() {
        return favoriteLanguage;
    }

    public void setFavoriteLanguage(String favoriteLanguage) {
        this.favoriteLanguage = favoriteLanguage;
    }

    public LinkedHashMap<String, String> getFavoriteLanguageOptions() {
        return favoriteLanguageOptions;
    }

    public String[] getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String[] operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

//    public LinkedHashMap<String[], String> getOperatingSystemOptions() {
//        return operatingSystemOptions;
//    }
}
