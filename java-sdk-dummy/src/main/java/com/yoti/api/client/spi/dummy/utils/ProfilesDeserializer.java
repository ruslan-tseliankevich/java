package com.yoti.api.client.spi.dummy.utils;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.yoti.api.client.ActivityDetails;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class ProfilesDeserializer {

    public static Map<String, ActivityDetails> fromFile(String testProfilesFilePath) throws IOException {
        HashMap<String, ActivityDetails> activityDetailsMap;
        Gson gson = new Gson();
        Type mapType = new TypeToken<HashMap<String, ActivityDetails>>() {}.getType();
        URL url = Resources.getResource(testProfilesFilePath);
        String json = Resources.toString(url, Charsets.UTF_8);
        activityDetailsMap = gson.fromJson(json, mapType);
        return activityDetailsMap;
    }
}
