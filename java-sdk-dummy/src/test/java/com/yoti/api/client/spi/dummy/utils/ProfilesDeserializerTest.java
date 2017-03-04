package com.yoti.api.client.spi.dummy.utils;

//import com.google.gson.Gson;
//import com.google.gson.GsonBuilder;
//import com.yoti.api.client.ActivityDetails;
//import com.yoti.api.client.HumanProfile;
//import com.yoti.api.client.spi.dummy.DummyActivityDetails;
//import com.yoti.api.client.spi.dummy.DummyHumanProfile;
//import com.yoti.api.client.spi.dummy.DummyYotiClient;
//import org.junit.Test;
//
//import java.util.HashMap;
//import java.util.Map;


import com.yoti.api.client.ActivityDetails;
import com.yoti.api.client.spi.dummy.DummyActivityDetails;
import org.junit.Test;

import java.util.Map;

public class ProfilesDeserializerTest {

//    @Test
//    public void name() throws Exception {
//        Map<String, ActivityDetails> profiles = new HashMap<String, ActivityDetails>();
//        profiles.put("1234567890987654321", getDummyActivityDetails());
//        Gson gson = new GsonBuilder().setPrettyPrinting().create();
//        String json = gson.toJson(profiles);
//        System.out.println(json);
//    }
//
//    private DummyActivityDetails getDummyActivityDetails() {
//        DummyActivityDetails details = new DummyActivityDetails();
//        details.setReceiptId("1234567890987654321");
//        details.setUserId("user-id-12345654321");
//
//        DummyHumanProfile profile = new DummyHumanProfile();
//        profile.setFullName("My-full-name");
//        profile.setFamilyName("My-Family-Name");
//        profile.setGender(HumanProfile.Gender.FEMALE);
//
//        details.setDummyHumanProfile(profile);
//        return details;
//    }

    @Test
    public void testFromFile() throws Exception {
        Map<String, ? extends ActivityDetails> profiles = ProfilesDeserializer.fromFile("test-profiles.json");

    }
}