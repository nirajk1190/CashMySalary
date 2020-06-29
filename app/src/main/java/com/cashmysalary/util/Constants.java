package com.cashmysalary.util;

import java.text.SimpleDateFormat;

/**
 * Created by aditi.bhuranda on 03/06/2019.
 */

public class Constants {
    /**
     * The Constant MB.
     */
    public static final int MB = 1 * 1024 * 1024;

    /**
     * The Constant MAX_BITMAP_CACHE_SIZE.
     */
    public static final int MAX_MEMORY_CACHE_SIZE = 4 * MB;

    /**
     * The Constant MAX_DISK_CACHE_SIZE.
     */
    public static final int MAX_DISK_CACHE_SIZE = 50 * MB;
    public static final int SUCCESS = 200;
    public static final String DATE_FORMAT = "dd-MMM-yyyy";
    public static final SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
    public static final SimpleDateFormat format11 = new SimpleDateFormat("dd-MM-yyyy");
    public static final SimpleDateFormat format2 = new SimpleDateFormat(DATE_FORMAT);
    public static final String format8 = "MMM dd, yyyy hh:mm:ss";
    //    2018-12-05T00:00:00.000Z
    public static final SimpleDateFormat format3 = new SimpleDateFormat("yyyy-MM-dd'T'00:00:00.000'Z'");
    public static final SimpleDateFormat format4 = new SimpleDateFormat("yyyy-MM-dd");
    public static final String utc_format = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
    public static final String utc_format1 = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
    public static final String format6 = "yyyy-MM-dd";
    public static final String format5 = "MMM dd, yyyy hh:mm:ss a";
    public static final SimpleDateFormat format10 = new SimpleDateFormat(Constants.format5);
    public static final String format = "dd/MMM/yyyy";

    // mandatory or not mandatory
    public static final String ASTERIK_SIGN = "<font color='#03A9F4'> *</font>";

    public static final int API_METHOD_GET = 0;
    public static final String ISLOGGEDIN = "ISLOGGEDIN";

    public static final String ACCESS_TOKEN = "Auth";
    public static final String USER_EMAIL = "user_email";
    public static final String USER_MOBILE = "user_mobile";
    public static final String USER_NAME = "user_name";
    public static final String ID = "id";
    public static final String ROLE_NAME = "role_name";
    public static final String ROLE_ID= "role_id";
    public static final String SURVEY_ID= "survey_id";
    public static final String STATUS= "status";
    public static final String MSG= "msg";
    public static final String TOKEN= "token";

    public static int BAD_REQUEST = 400;
    public static int INTERNAL_SERVER_ERROR = 500;
    /**
     * The constant URL_NOT_FOUND.
     */
    public static int URL_NOT_FOUND = 404;
    /**
     * The constant UNAUTHORIZE_ACCESS.
     */
    public static int UNAUTHORIZE_ACCESS = 401;
    /**
     * The constant CONNECTION_OUT.
     */
    public static int CONNECTION_OUT = 408;

    public static final String TYPE_TEXT = "text";
    public static final String TYPE_LOCATION = "location_text";
    public static final String TYPE_TOAST = "toast";
    public static final String TYPE_BUTTON = "button";
    public static final String TYPE_NUMBER = "number";
    public static final String TYPE_FLOAT= "float";
    public static final String TYPE_TEXT_AREA= "textarea";
    public static final String VIEW_TYPE_CHECK_BOX= "checkbox";
    public static final String VIEW_TYPE_CHECK_SELECT= "select";
    public static final String VIEW_TYPE_RADIO= "radio";
    public static final String PROPERTY_VISIBLE= "visible";
    public static final String PROPERTY_INVISIBLE= "invisible";

    public static final String SLUG_AGE= "age";
    public static final String SLUG_MOBILE_NUMBER= "mobile_number";
    public static final String SLUG_ALT_MOBILE_NUMBER= "alt_mobile_number";
    public static final String SLUG_NOTE= "note";
    public static final String SLUG_STATE= "state";
    public static final String SLUG_REGION= "region";
    public static final String SLUG_DISTRICT= "district";
    public static final String TYPE_REGION= "regions";
    public static final String SLUG_ACRES= "total_acre";
    public static final String SLUG_FNAME= "f_name";
    public static final String SLUG_EMAIL= "farmer_email";
    public static final String SLUG_QUERY= "f_mobile";
    public static final String SLUG_ADDRESS= "address";
    public static final String SLUG_FARMER_NAME= "farmer_name";
    public static final String SLUG_PINCODE= "pincode";
    public static final String SLUG_IRRIGATED_AREA= "irrigated_area";
    public static final String SLUG_CROP_CULTIVATED= "crops_cultivated";
    public static final String LAT= "latitude";
    public static final String LONG= "longitude";
    public static final String EVENT_TYPE= "event_type";
    public static final String _STATUS= "status";
    public static final String SAVED= "Saved";
    public static final String COMPLETED= "Completed";
    public static final String farmer_mobile= "farmer_mobile";
    public static final String VERIFY_CURRENT_LAT= "verifyLat";
    public static final String VERIFY_CURRENT_LONG= "verifyLong";
    public static final String UNAUTHORISED_ACCESS= "unauthorised access";
    public static final String SUCCESS_CODE= "200";
    public static final String STATUS_CODE_401= "401";
    public static final String CALLER= "caller";
    public static final String DASHBOARD= "dashboard";
    public static final String QUESTIONS= "questions";
    public static final String VERIFIED= "verifiedList";
    public static final String TAB_NAME= "tab_name";
    public static final String DATA= "data";
    public static final String Q_list= "Q_list";
    public static final String NONE_SELECTED= "None selected";
    public static final String SURVEY_LIST= "surveyList";
    public static final String USER_MASTER_LIST= "user_master";
    public static final String pending_since= "pending_since";
    public static final String f_value= "f_value";
}

