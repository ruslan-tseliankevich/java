package com.yoti.api.client.spi.dummy;

import com.yoti.api.client.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class DummyHumanProfile implements HumanProfile {
    private final HashMap<String, String> attributes = new HashMap<String, String>();
    private String familyName;
    private String givenNames;
    private String fullName;
    private Date dateOfBirth;
    private Gender gender;
    private String nationality;
    private String phoneNumber;
    private Image selfie;
    private String emailAddress;
    private DocumentDetails documentDetails;

    @Override
    public String getAttribute(String name) {
        return attributes.get(name);
    }

    @Override
    public boolean is(String name, boolean defaultValue) {
        return defaultValue;
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> T getAttribute(String name, Class<T> clazz) {
        return String.class.equals(clazz) ? (T) getAttribute(name) : null;
    }

    @Override
    public Collection<Attribute> getAttributes() {
        Collection<Attribute> a = new HashSet<Attribute>();
        for (Map.Entry<String, String> e : attributes.entrySet()) {
            a.add(new Attribute(e.getKey(), e.getValue()));
        }
        return a;
    }

    @Override
    public DocumentDetails getDocumentDetails() {
        return documentDetails;
    }

    @Override
    public String getFamilyName() {
        return familyName;
    }

    @Override
    public String getGivenNames() {
        return givenNames;
    }

    @Override
    public String getFullName() {
        return fullName;
    }

    @Override
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    @Override
    public Gender getGender() {
        return gender;
    }

    @Override
    public String getNationality() {
        return nationality;
    }

    @Override
    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public Image getSelfie() {
        return selfie;
    }

    @Override
    public String getEmailAddress() {
        return emailAddress;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public void setGivenNames(String givenNames) {
        this.givenNames = givenNames;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setSelfie(Image selfie) {
        this.selfie = selfie;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setDocumentDetails(DocumentDetails documentDetails) {
        this.documentDetails = documentDetails;
    }
}
