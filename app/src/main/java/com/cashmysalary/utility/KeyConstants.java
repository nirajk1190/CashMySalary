package com.cashmysalary.utility;


import android.graphics.Bitmap;
import android.net.Uri;

import org.json.JSONObject;

import java.util.ArrayList;

//Key Constants
public class KeyConstants {
    public static final String IMEI ="IMEI";
    //Shared preferenceKey
    public static final String FCMTOKEN = "fcmToken";

    public static String BASE64_TYPE = "";
    public static String BASE64_TYPE_SHOW = "BASE64_TYPE_SHOW";
    public static String BASE64_TYPE_SHOW_TYPE = "BASE64_TYPE_SHOW_TYPE";


    public static  ArrayList<String> RETURN_RETURN_DESC = new ArrayList<>();

    public static String REQUEST_ID_WORKFLOW = "";
    public static String CURRENT_STATUS_WORKFLOW = "";
    public static String CURRENT_FILTER_TYPE = "";

    public static  int CURRENT_POSTION_BATCH=0;
    public static  String CURRENT_BATCH_ID="";
    public static  int GROUP_POSITION_EXPEND=0;
    public static  int GROUP_POSITION_EXPEND_BACK=0;
    public static  int APPROVER_SUBMIT_ACTION=0;

    public static  String SUPPORT_SUBMIT_ACTION="0";

    public static  String ZOOM_IN_URL="";
    public static  int ZOOM_IN_URL_POS=0;
    public static  int ZOOM_IN_URL_ATTACH=0;

    public static Bitmap IMAGE_BATCH_Bit1 =null;

    public static  String DELETE_IMAGE_BATCH="";
    public static  String DELETE_IMAGE_BATCH_TYPE="";

    public static  int ALLOWED_IMAGE_BATCH=0;
    public static  String IS_EDITOR="";
    public static  boolean IS_EDITOR_ON=false;
    public static  String REQUEST_TYPE_BATCH="Save";

    public static  boolean IS_VIEW_IMAGE=false;

    public static  String POLICY_BASE ="";
    public static  String HELP_BASE ="";

    public static  String POLICY_BASE1 ="";
    public static  String POLICY_BASE2 ="";
    public static  String POLICY_BASE3 ="";

    public static Bitmap POLICY_Bit1 =null;
    public static Bitmap POLICY_Bit2 =null;
    public static Bitmap POLICY_Bit3 =null;
    public static String ECL_REQUEST_IMG ="";
    public static String isCheckedStrMR="";
    public static String remarksMR="";
    public static  String GetEmployeeHStatusWSString="";


    ///////////////////////////ENHANCE CUSTOMER LIST END//////////////////////////

    ////////////////////////////AOPB START //////////////////////////

    public static String CURRENT_TAB_AOPB = "My Pending";
    public static boolean CURRENT_TAB_AOPB_SELECT_INP = false;
    public static boolean CURRENT_TAB_AOPB_SELECT_MYP = true;
    public static boolean CURRENT_TAB_AOPB_SELECT_COM = false;
    public static boolean CURRENT_TAB_AOPB_SELECT_REJ = false;

    public static  String AOPB_EMPLOYEE_STATUS="";
    public static  String AOPB_IS_EDITOR="";
    public static  String AOPB_IS_REQUESTER="";
    public static  String AOPB_IS_APPROVER="";

    ///////////////////////////AOPB END//////////////////////////


///////////////////////////////Sales Order ///////////////////////
    public static String CURRENT_TAB_SO = "OPEN";
    public static boolean CURRENT_TAB_SO_SELECT_INP = false;
    public static boolean CURRENT_TAB_SO_SELECT_MYP = true;
    public static boolean CURRENT_TAB_SO_SELECT_PO = false;
    public static boolean CURRENT_TAB_SO_SELECT_COM = false;
    public static boolean CURRENT_TAB_SO_SELECT_REJ = false;
    public static  String SO_EMPLOYEE_STATUS="";
    public static  String SO_IS_EDITOR="";
    public static  String SO_IS_REQUESTER="";
    public static  String SO_IS_APPROVER="";
    public static String SO_SPLIT_ALLOW="";
    public static String SO_PRICE_EDIT_ALLOW="";
    public static String SO_COLLECTION_PLAN_STATUS="green";
    public static  String SO_IS_REQUEST_EDITED="0";
    public static  String SO_IS_REQUEST_EDITED_BACK_PRESS="0";
    public static  String SO_CURRENT_PO_NUMBER="";
    public static JSONObject SPLIT_SUBMIT_JSON=new JSONObject();
    public static  String SO_PRICE_EDIT_ITEM_ID="";
    public static  String SO_DEPOT_CODE="";
    public static  String SO_DEPOT_NAME="";
    public static String SO_ETA_DATE="";
    public static boolean REFRESH_PROCESS_SO = false;
    public static boolean SPLIT_REQUEST_SO = false;
    public static String PO_STATUS="";
    public static String CUSTOMER_LIST_BLOCK_TYPE_SO = "N";
    public static String CP_VALIDATION="";
    public static String po_number="";

    /**
     * The constant mOrderInfoArrayList.
     */
    public static String mOrderInfoArrayList = "mOrderInfoArrayList";


    public static String CURRENT_CUSTOMER_EL = "";
    public static String CURRENT_CUSTOMER_DC = "";
    public static String CURRENT_CUSTOMER_DC_CITY = "";
    public static String CURRENT_ORDER_ID = "";
    public static String CURRENT_CUSTOMER_CODE = "";
    public static String CURRENT_CUSTOMER_NAME = "";
    public static boolean CURRENT_CUSTOMER_IS_BLOCKED = false;
    public static String CURRENT_CUSTOMER_OD_FLAG = "";

    public static boolean OFFLINE_VALUE_AVAILABLE = false;

    public static boolean CLOSE_ACTION = false;

    public static String versionName = "";
    public static  String ModuleName="";
//////////////////////////////


    // opportunities
    public static String Existing_Relationship = "Existing Relationship";
    public static String TITLE = "title";
    public static String OPPORTUNITY_ID = "opportunityId";
    public static String TYPE = "type";
    public static String SEARCH_RELATED_TO = "Search Related To";
    public static String SEARCH_TYPE = "relatedTo";
    public static String PONUMBER = "poNumber";


    ////////////////////////// PLOTS STARTS //////////////////////////
    /*
    public static String[] name = {"Insight & Analytics", "Planner", "Settle Expenses", "Settings"};
    public static String[] subName = {"Daily Allowance", "Travel", "business Expenses", "Petty Cash"};*/
    //Shared preferenceKey
/*
    public static final String ACCESS_TOKEN = "AccessToken";
    public static final String REFRESH_TOKEN = "RefreshToken";
    public static final String TOKEN = "Token";
    public static final String OTP = "Otp";
    public static final String EMAIL = "Email";
    public static final String ISLOGGEDIN = "ISLOGGEDIN";
    public static final String FCMTOKEN = "fcmToken";
*/

    public static String TABS_TYPE_VISIBILITY = "";

    public static final String TABS_TYPE_VISIBILITY_ALL_VALUE = "ALL";
    public static final String TABS_TYPE_VISIBILITY_APPROVER_VALUE = "APPROVER";

    public static final String SE_NOTIFICATION_CATEGORY_DAILY = "DAILY";
    public static final String SE_NOTIFICATION_CATEGORY_TRAVEL = "TRAVEL";
    public static final String SE_NOTIFICATION_CATEGORY_BUSINESS = "BUSINESS";
    public static final String SE_NOTIFICATION_CATEGORY_PETTY_CASH = "PETTY CASH";

    public static Boolean PHASE_FLAG_SR = false;
    public static Boolean PHASE_FLAG_AC = false;
    public static Boolean PHASE_FLAG_SRVF = false;
    public static Boolean PHASE_FLAG_ACVF = false;

/*
    public static String PHASE_FLAG = "Phase_One";
    public static String PHASE_ONE_FLAG = "Phase_One";
    public static String PHASE_SEC_FLAG = "Phase_Sec";
*/

    public static int PIN_IT_WINDOW = 0;

    public static Uri ATTACH_AUDIO_MAIN ;
    public static String USER_ROLE = "";
    public static String USER_ROLE_DA = "Daily Allowance";
    public static String USER_ROLE_AC = "Approval Center";
    public static int PAGE_COUNT = 4;

    public static int CURRENT_DAY_PINIT = 0;

    public static String CURRENT_TAB_DA = "My Pending";
    public static boolean CURRENT_TAB_DA_SELECT_INP = false;
    public static boolean CURRENT_TAB_DA_SELECT_MYP = true;
    public static boolean CURRENT_TAB_DA_SELECT_COM = false;
    public static boolean CURRENT_TAB_DA_SELECT_REJ = false;

    public static String REQUEST_CODE = "";
    public static String CURRENT_TAB_FLOW = "";

    public static String CURRENT_TAB_AC = "My Pending";
    public static boolean CURRENT_TAB_AC_SELECT_INP = false;
    public static boolean CURRENT_TAB_AC_SELECT_MYP = true;
    public static boolean CURRENT_TAB_AC_SELECT_COM = false;
    public static boolean CURRENT_TAB_AC_SELECT_REJ = false;

    public static String CATEGORY_NAME_PENDING = "My Pending";
    public static String CATEGORY_NAME_PROGRESS = "In Progress";
    public static String CATEGORY_NAME_COMPLETED = "Completed";
    public static String CATEGORY_NAME_REJECTED = "Rejected";


    public static String VEHICLE_UPDATE_FLAG_NAME = "VEHICLE_UPDATE_FLAG";


    public static String DATE_HEADER = "";

    public static String PRINT_DISTANCE = "";
    public static String PRINT_TA = "";
    public static String PRINT_DATE = "";
    public static String PRINT_CODE = "";


    public static String IS_CLAIM_FLAG = "";
    public static String IS_CLAIM_REASON = "";

    public static String IS_MANUAL_FLAG = "";

    public static  ArrayList<String> TAG_NAME_LIST = new ArrayList<>();
    public static  ArrayList<String> TAG_DEPOT_LIST = new ArrayList<>();
    public static  ArrayList<String> TAG_CUSTOMER_LIST = new ArrayList<>();


    public static  String TAG_TYPE_STRING="";
    public static  String TAG_DEPOT_STRING="Select Option";
    public static String TAG_CUSTOMER_STRING ="Select Option";

    public static String LAT_POINTS="";
    public static String LNG_POINTS="";
    public static String UNIQUE_KEY="";


    public static String VALUE_PER_KM="";
    public static double VALUE_PER_KM_D=0.0;
    public static int IGNORE_CLAIM=0;
    public static int PERSONAL_LOCATION=0;

    public static String TAG_NAME="";
    public static String LABEL_NAME="";

    public static double TAG_LATITUDE=0.0;
    public static double TAG_LONGITUDE=0.0;


    ///////////////////////////Notification values;
    public static String NOTIFICATION_ACTION ="";
    public static  ArrayList<String> TAG_PIN_IT = new ArrayList<>();
    public static String TAG_LT_TAG_NAME ="Select Option";

    public static int PINIT_SERVER_POS=0;
    public static int PINIT_SERVER_FRA_POS=0;
    public static final ArrayList<String> extensions = new ArrayList<String>();
    public static ArrayList<String> getExtension() {
        extensions.add(".pdf");
        extensions.add(".png");
        extensions.add(".jpeg");
        extensions.add(".jpg");
        //extensions.add(".txt");
        extensions.add(".PDF");
        extensions.add(".PNG");
        extensions.add(".JPEG");
        extensions.add(".JPG");
        //extensions.add(".TXT");
        return extensions;
    }

    ///////////////////////// PLOTS END     /////////////////////////

}