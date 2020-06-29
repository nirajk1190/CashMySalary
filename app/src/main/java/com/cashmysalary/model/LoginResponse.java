package com.cashmysalary.model;

import com.google.gson.annotations.SerializedName;

public class LoginResponse {
    @SerializedName("sMobileNumber")
    public String sMobileNumber;
    @SerializedName("sAppVersion")
    public String sAppVersion;
    @SerializedName("sDeviceType")
    public String sDeviceType;
    @SerializedName("sDeviceModel")
    public String sDeviceModel;
    @SerializedName("sDeviceVersion")
    public String sDeviceVersion;
    @SerializedName("sDeviceIMEI")
    public String sDeviceIMEI;
    @SerializedName("isLogin")
    public String isLogin;
    @SerializedName("otp")
    public String otp;

    public LoginResponse(String sMobileNumber, String sAppVersion, String sDeviceType, String sDeviceModel, String sDeviceVersion, String sDeviceIMEI) {
        this.sMobileNumber = sMobileNumber;
        this.sAppVersion = sAppVersion;
        this.sDeviceType = sDeviceType;
        this.sDeviceModel = sDeviceModel;
        this.sDeviceVersion = sDeviceVersion;
        this.sDeviceIMEI = sDeviceIMEI;
    }

    public String getsMobileNumber() {
        return sMobileNumber;
    }

    public void setsMobileNumber(String sMobileNumber) {
        this.sMobileNumber = sMobileNumber;
    }

    public String getsAppVersion() {
        return sAppVersion;
    }

    public void setsAppVersion(String sAppVersion) {
        this.sAppVersion = sAppVersion;
    }

    public String getsDeviceType() {
        return sDeviceType;
    }

    public void setsDeviceType(String sDeviceType) {
        this.sDeviceType = sDeviceType;
    }

    public String getsDeviceModel() {
        return sDeviceModel;
    }

    public void setsDeviceModel(String sDeviceModel) {
        this.sDeviceModel = sDeviceModel;
    }

    public String getsDeviceVersion() {
        return sDeviceVersion;
    }

    public void setsDeviceVersion(String sDeviceVersion) {
        this.sDeviceVersion = sDeviceVersion;
    }

    public String getsDeviceIMEI() {
        return sDeviceIMEI;
    }

    public void setsDeviceIMEI(String sDeviceIMEI) {
        this.sDeviceIMEI = sDeviceIMEI;
    }

    public String getIsLogin() {
        return isLogin;
    }

    public void setIsLogin(String isLogin) {
        this.isLogin = isLogin;
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }

}
