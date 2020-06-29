package com.cashmysalary.utility;

public interface AppConstants {


    interface NewLeadContactsUIType {
        int TYPE_PRIMARY = 1;
        int TYPE_SECONDARY = 2;

    }
    interface BundleKey {

        String PARENTID = "parent_id";
        String BUSINESSTYPE = "business_type";
        String LEAD_ID = "lead_id";
        String COMPANY_NAME = "compnay_name";
        String PRIMARY_NUMBER = "Primary_number";
        String PRIMARY_EMAIL_ID = "Primary_email_id";
        String CONTACT_ID = "contact_id";
        String CONTACT_ID_TYPE = "contact_id_type";
        String TOOLBAR_TITLE = "toolbar_title";
        String SHOW_DELETE = "show_delete";
        String ASSIGN_TO_NAME = "assign_to_name";
        String ASSIGN_TO = "assign_to";
        String ASSIGN_TO_ID = "assign_to_id";
        String STATUS_TYPE = "status_type";
        String SEARCH_LEAD_TYPE = "lead_type";
        String SEARCH_TITLE = "title";
        String ACTIVITY_ID = "activity_id";
        String MEETING_ID = "meeting_id";
        String CHECK_IN_DATE = "check_In_date";
        String CHECK_IN_OUT_TYPE = "check_In_out_type";
        String CHECK_IN_OUT_MESSAGE = "check_In_out_message";

        String CHECK_IN_OUT_ID = "check_In_out_Id";
    }

    interface PostLeadInfoKey {

        String LEAD_ID = "Lead_ID";
        String CONTACT_ID = "Contact_ID";
        String Mobile = "Mobile";
        String Email_ID = "Email";
        String Company_Name = "Company_Name";
        String Address1 = "Address1";
        String Address2 = "Address2";
        String Locality = "Locality";
        String City_Name = "City_Name";

        String StateName = "State";
        String PIN = "PIN";
        String Longitude = "Longitude";
        String Latitude = "Latitude";
        String Lead_Owner = "Lead_Owner";
        String Lead_Created_By = "Lead_Created_By";
        String Assigned_To_Name = "Assigned_To_Name";
        String Assigned_To = "Assigned_To";
        String Assigned_To_ID = "Assigned_To_ID";

        String Address_Name = "Address_Name";
        String Lead_Source_ID = "Lead_Source_ID";
        String Segment_ID = "Segment_ID";
        String Lead_Rating_ID = "Lead_Rating_ID";
        String Entity_ID = "Entity_ID";
        String Business_Unit_ID = "Business_Unit_ID";
        String Account_Type_ID = "Account_Type_ID";

    }

    interface PostSingleLeadContactKey {
        String LEAD_ID = "Lead_ID";
        String CONTACT_ID = "Contact_ID";
        String PREFIX = "Prefix";
        String FIRST_NAME = "First_Name";
        String MIDDLE_NAME = "Middle_Name";
        String LAST_NAME = "Last_Name";
        String DESIGNATION= "Designation";
        String MOBILE = "Mobile";
        String ALT_MOBILE = "Alt_Mobile";
        String Email_ID = "Email";
        String ALT_Email_ID = "Alt_Email";
        String CONTACT_TYPE = "Contact_Type";
    }
    interface PostLeadEntityKey {
        String LEAD_ID = "Lead_ID";
        String CATEGORIES = "Categories";
        String ADD_INFO = "Add_Info";
    }

    interface BottomDialogType {
        int TYPE_STATE = 1;
        int TYPE_ADDRESS_NAME = 2;
        int TYPE_ENTITY = 3;
        int TYPE_BUSINESS_UNTI = 4;
        int TYPE_ACCOUNT_TYPE = 5;
        int TYPE_LEAD_SOURCE = 6;
        int TYPE_SEGMENT = 7;
        int TYPE_LEAD_RATING = 8;
        int TYPE_LEAD_OWNER = 9;
        int TYPE_ASSIGN_TO = 10;
        int TYPE_TITLE = 11;
        int TYPE_DESIGNATION = 12;
        int TYPE_STATUS = 13;
        int TYPE_SUBJECT = 14;
        int TYPE_Customers = 15;

        int TYPE_ACTION = 16;
    }
    interface LeadStatusType {
        String TYPE_OPEN = "open";
        String TYPE_QUALIFIED = "qualified";
        String TYPE_UNQUALIFIED = "unqualified";
        String TYPE_FUTURE = "future";
    }

    interface OPPOStatusType {
        String TYPE_NEW = "new";
        String TYPE_PROPOSAL = "proposal";
        String TYPE_NEGOTIATION = "negotiation";
        String TYPE_CLOSED = "closed";
    }

    interface SearchEmployeeType {
        int TYPE_OWNER = 1;
        int TYPE_OTHER_EMPLOYEE = 2;
    }

    interface LeadMoreType {
        String TYPE_ACTIVITY_LOGS = "Add Activity Log";
        String TYPE_VOICE_NOTE = "Add Voice Note";
        String TYPE_ADD_ATTACHMENT = "Add Attachment";
        String TYPE_SCHEDULE_MEETING = "Schedule Meeting";
    }

    interface BPMoreType {
        String TYPE_CREATE_OPPORTUNITY = "Create an Opportunity";
        String TYPE_GENERATE_QUOTE= "Generate a Quote";
        String TYPE_PLACE_ORDER = "Place an Order";
        String TYPE_CANCEL_RESCHEDULE = "Cancel Meeting/Reschedule";
    }

    interface LeadActionType {
        String TYPE_CONVERT_OPP = "Convert Opportunity";
        String TYPE_INTIT_NEW = "Initiate New Customers Registration";
        String TYPE_UNQALIFIED = "Unqualified";
        String TYPE_FUTURE = "Future";
    }

    interface ActivityType {
        String TYPE_NOTES = "Notes";
        String TYPE_UNQUALIFIED = "Unqualified";
        String TYPE_MEETING = "Meeting";
        String TYPE_FUTURE = "Future";
        String TYPE_ATTACHMENT= "Attachment";
        String TYPE_VOICE_NOTE = "Voice_Note";
    }

    interface ActivityForResult {
        int CODE_ACTION_DATA_CHANGE = 1002;

    }

    interface CalenderFormat {
        String GET_SERVER_FORMAT = "MM-dd-yyyy HH:mm:ss";
        String DATE_TIME_FORMAT = "dd/MM/yyyy hh:mm a";
        String DISPLAY_DATE_FORMAT = "dd/MM/yyyy";
        String DATE_FORMAT_MONTH = "MM-dd-yyyy";
        String DATE_FORMAT_MONTH_SERVER = "MM-dd-yyyy hh:mm:ss";
        String LOCAL_DATE_TIME_FORMAT = "MM-dd-yyyy hh:mm:ss";

        String DATE_FORMAT_MONTH_SERVER_ONLY_DATE = "MM/dd/yyyy";
        String TIME_24_FORMAT = "HH:mm";
        String TIME_24_FORMAT_SEC = "HH:mm:ss";
        String CHECK_IN_OUT_DIALOG_FORMAT ="dd-MM-yyyy, h:mm a";


    }
    interface RequestPermission {
        int PHONE_CALL_PERMISSION = 1;
        int LOCATION_PERMISSION = 2;
        int SMS_PERMISSION = 3;
        int CAMERA_PERMISSION = 4;
        int READ_E_STORAGE_PERMISSION = 5;
        int CALENDAR_PERMISSION = 6;
        int READ_E_STORAGE_PERMISSION_DOWNLOAD = 7;
        int VIDEO_CALL_PERMISSION = 8;
        int MICROPHONE_PERMISSION = 9;
        int CAMERA_VIDEO_PERMISSION = 10;
        int CAMERA_STORAGE_PERMISSION = 11;
        int MEDICAL_DRIVE_PERMISSION = 16;
        int RECORD_AUDIO_PERMISSION = 17;
    }
    interface LeadRecords {
        String ARG_URL = "url";
        String GALLERY = "GALLERY";
        String FILE = "FILE";
        String CAMERA = "CAMERA";
        String REPORT = "report";
        String PRESCRIPTION = "prescription";
        String SAVE_PATIENT_DATA = "SavePatientData";
        String GET_PATIENT_DATA = "GetPatientData";
        String UPLOAD_FILE = "UploadFile";
        String FROM = "from";
        String ATTACHMENT_URL = "attachment_url";
        String FILE_EXTENTION = "fileExtention";
        String URI = "uri";
        String DATA = "data";
        String DOWNLOAD_FILE = "downloadFile";
        String DELETE_MEDICAL_RECORD = "deleteMedicalRecord";
        String IMAGE_MIME_TYPE = "image/*";
        String AUDIO_MIME_TYPE = "audio/*";
        String APPLICATION_MIME_TYPE = "application/*";
        String DELETE = "Delete";

    }

    interface RequestCodes {
        int RECORD_CAMERA_REQUEST = 1888;
        int RECORD_FILE_SELECT_CODE = 1889;
        int RECORD_PIC_SELECT_CODE = 1890;
        int PROFILE_CAMERA_REQUEST = 2999;
        int PROFILE_GALLERY_REQUEST = 3000;
        int RECORD_AUDIO_REQUEST = 3412;
    }


    interface FileExtention {
        String PNG = "png";
        String JPEG = "jpeg";
        String JPG = "jpg";
        String PDF = "pdf";
    }
    public interface partnerConnectKey {
        String ENTITY_CODE = "EntityCode";
        String REQUEST_CODE = "REQUEST_CODE";

        String GROUP_CODE = "GROUP_CODE";
        String Entity_NAME = "EntityName";
    }

    interface CheckInOutNotificationType {
        int TYPE_CHECK_IN = 1;
        int TYPE_CHECK_OUT = 2;
    }

    interface CheckInOutRequestCode {
        int REQUEST_CODE_CHECK_IN = 1;
        int REQUEST_CODE_CHECK_OUT = 2;
    }
    public interface ApiClient {
        String CONTENT_TYPE = "Content-Type";
        String APPLICATION_JSON = "application/json";
        String AUTHORIZATION = "Authorization";
        String GLOBALSETTING = "GlobalSettings";

    }
    public interface priceMasterKey {
        int STOCK_INT = 0;
        int STOCK_STRING =1;

        // 1 not Available
        // 2 few
        // 3 available
        int STOCK_AVAILABLE = 3;
        int STOCK_OUT_OF_STOCK =1;
        int STOCK_FEW_STOCK =2;
    }

}
