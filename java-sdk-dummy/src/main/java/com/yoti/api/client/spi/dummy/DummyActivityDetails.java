package com.yoti.api.client.spi.dummy;


import com.yoti.api.client.ActivityDetails;
import com.yoti.api.client.ApplicationProfile;
import com.yoti.api.client.HumanProfile;

import java.util.Date;

public class DummyActivityDetails implements ActivityDetails {
    private HumanProfile humanProfile;
    private ApplicationProfile applicationProfile;
    private String userId;
    private String receiptId;

    @Override
    public HumanProfile getUserProfile() {
        return humanProfile;
    }

    @Override
    public ApplicationProfile getApplicationProfile() {
        return applicationProfile;
    }

    @Override
    public String getUserId() {
        return userId;
    }

    @Override
    public Date getTimestamp() {
        return new java.util.Date();
    }

    @Override
    public String getReceiptId() {
        return receiptId;
    }

    public void setHumanProfile(HumanProfile humanProfile) {
        this.humanProfile = humanProfile;
    }

    public void setApplicationProfile(ApplicationProfile applicationProfile) {
        this.applicationProfile = applicationProfile;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setReceiptId(String receiptId) {
        this.receiptId = receiptId;
    }
}
