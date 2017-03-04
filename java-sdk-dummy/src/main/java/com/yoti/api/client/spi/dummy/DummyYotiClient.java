package com.yoti.api.client.spi.dummy;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import com.yoti.api.client.ActivityDetails;
import com.yoti.api.client.ApplicationProfile;
import com.yoti.api.client.Attribute;
import com.yoti.api.client.Date;
import com.yoti.api.client.DocumentDetails;
import com.yoti.api.client.HumanProfile;
import com.yoti.api.client.Image;
import com.yoti.api.client.InitialisationException;
import com.yoti.api.client.ProfileException;
import com.yoti.api.client.YotiClient;
import com.yoti.api.client.YotiClientConfiguration;
import com.yoti.api.client.YotiClientFactory;

import static com.yoti.api.client.spi.dummy.utils.ProfilesDeserializer.fromFile;

public class DummyYotiClient implements YotiClient, YotiClientFactory {
    private static final String EXCEPTION_TRIGGER_PREFIX = "exception-";
    private static final String DUMMY_PREFIX = "dummy-";
    public static final ActivityDetails DUMMY_RECEIPT;
    private Map<String, ActivityDetails> PROFILES = new HashMap<String, ActivityDetails>();

    static {
        final HashMap<String, String> attributes = new HashMap<String, String>();
        attributes.put("date_of_birth", "1964-11-23");
        attributes.put("given_names", "John");
        attributes.put("family_name", "Doe");

        final HumanProfile userProfile = new HumanProfile() {
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
            public String getFamilyName() {
                return "Doe";
            }

            @Override
            public String getGivenNames() {
                return "John";
            }

            @Override
            public String getFullName() {
                return "John Doe";
            }

            @Override
            public Date getDateOfBirth() {
                return null;
            }

            @Override
            public Gender getGender() {
                return null;
            }

            @Override
            public String getNationality() {
                return null;
            }

            @Override
            public String getPhoneNumber() {
                return null;
            }

            @Override
            public Image getSelfie() {
                return null;
            }

            @Override
            public String getEmailAddress() {
                return null;
            }

            @Override
            public DocumentDetails getDocumentDetails() {
                return null;
            }
        };

        final ApplicationProfile applicationProfile = new ApplicationProfile() {
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
            public String getApplicationName() {
                return null;
            }

            @Override
            public String getApplicationUrl() {
                return null;
            }

            @Override
            public Image getApplicationLogo() {
                return null;
            }

            @Override
            public String getApplicationReceiptBgColor() {
                return null;
            }
        };

        DUMMY_RECEIPT = new ActivityDetails() {

            @Override
            public String getUserId() {
                return "YmFkYWRhZGEtZGFkYWJhZGEK";
            }

            @Override
            public HumanProfile getUserProfile() {
                return userProfile;
            }

            @Override
            public ApplicationProfile getApplicationProfile() {
                return applicationProfile;
            }

            @Override
            public java.util.Date getTimestamp() {
                return new java.util.Date();
            }

            @Override
            public String getReceiptId() {
                return "12345678";
            }

        };
    }

    public DummyYotiClient() {

    }

    public DummyYotiClient (String testProfilesFilePath) throws IOException {
        PROFILES = fromFile(testProfilesFilePath);
    }

    @Override
    public ActivityDetails getActivityDetails(String encryptedConnectToken) throws ProfileException {
        if (encryptedConnectToken != null && encryptedConnectToken.startsWith(EXCEPTION_TRIGGER_PREFIX)) {
            throw new ProfileException(encryptedConnectToken);
        }

        if (PROFILES.isEmpty()) {
            return DUMMY_RECEIPT;
        }

        if (!PROFILES.containsKey(encryptedConnectToken)) {
            throw new ProfileException("Unknown token");
        }

        return PROFILES.get(encryptedConnectToken);
    }

    @Override
    public boolean accepts(String applicationId) {
        return applicationId.startsWith(DUMMY_PREFIX);
    }

    @Override
    public YotiClient getInstance(YotiClientConfiguration yotiClientBuilder) throws InitialisationException {
        return new DummyYotiClient();
    }

}
