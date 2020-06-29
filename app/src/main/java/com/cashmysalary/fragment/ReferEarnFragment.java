package com.cashmysalary.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.cashmysalary.R;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;

public class ReferEarnFragment extends Fragment implements View.OnClickListener {
    private String TAG = ReferEarnFragment.class.getSimpleName();
    private View main;
    private RelativeLayout rlShare;
    private ImageView btnEmail,btnMessage,btnWhatsApp,btnMessenger;

    public ReferEarnFragment() {
        // Required empty public constructor
    }

    public static ReferEarnFragment newInstance(String param1, String param2) {
        ReferEarnFragment fragment = new ReferEarnFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        main = inflater.inflate(R.layout.frag_refer, container, false);

        init();
        applyInit();
        return main;
    }

    private void applyInit() {

    }

    private void init() {
        btnEmail = main.findViewById(R.id.btnEmail);
        btnMessage = main.findViewById(R.id.btnMessage);
        btnWhatsApp = main.findViewById(R.id.btnWhatsApp);
        btnMessenger = main.findViewById(R.id.btnMessenger);
        rlShare = main.findViewById(R.id.rlShare);

        rlShare.setOnClickListener(this);

        btnEmail.setOnClickListener(this);
        btnMessage.setOnClickListener(this);
        btnWhatsApp.setOnClickListener(this);
        btnMessenger.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.rlShare:
                shareVia();
                break;
            case R.id.btnEmail:
                shareViaEmail();
                break;
            case R.id.btnMessage:
                shareViaSMS();
                break;
            case R.id.btnWhatsApp:
                shareViaWhatsApp();
                break;
            case R.id.btnMessenger:
                shareViaMessenger();
            default:
                break;
        }
    }

    private void shareViaMessenger() {
        String shareMessage = "Hi\n\n"+"I use CashMySalary to borrow cash and it's really quick. CashMySalary gives you an instant loan upto Rs 2 Lakh starting at just 0.8% a day. Sign up with my code"+" "+"'"+getActivity().getResources().getString(R.string.referral_code)+"'"+" and we both can get some discount on processing fee.\n\n" +
                "Get the CashMySalary app from the link below. \n" +
                "https://play.google.com/store/apps/details?id=com.refreshideas.cashmysalary1&hl=en";

        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, shareMessage);
        sendIntent.setType("text/plain");
        sendIntent.setPackage("com.facebook.orca");
        try {
            startActivity(sendIntent);
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(getActivity(),"Messanger have not been installed.",Toast.LENGTH_LONG);
        }
    }

    public void shareViaWhatsApp(){
        String shareMessage = "Hi\n\n"+"I use CashMySalary to borrow cash and it's really quick. CashMySalary gives you an instant loan upto Rs 2 Lakh starting at just 0.8% a day. Sign up with my code"+" "+"'"+getActivity().getResources().getString(R.string.referral_code)+"'"+" and we both can get some discount on processing fee.\n\n" +
                "Get the CashMySalary app from the link below. \n" +
                "https://play.google.com/store/apps/details?id=com.refreshideas.cashmysalary1&hl=en";

        Intent whatsappIntent = new Intent(Intent.ACTION_SEND);
        whatsappIntent.setType("text/plain");
        whatsappIntent.setPackage("com.whatsapp");
        whatsappIntent.putExtra(Intent.EXTRA_TEXT, shareMessage);
        try {
            startActivity(whatsappIntent);
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(getActivity(),"Whatsapp have not been installed.",Toast.LENGTH_LONG);
        }
    }
    public void shareViaEmail(){
        //Java
        String shareSubject = "";
        String shareMessage = "Hi\n\n"+"I use CashMySalary to borrow cash and it's really quick. CashMySalary gives you an instant loan upto Rs 2 Lakh starting at just 0.8% a day. Sign up with my code"+" "+"'"+getActivity().getResources().getString(R.string.referral_code)+"'"+" and we both can get some discount on processing fee.\n\n" +
                "Get the CashMySalary app from the link below. \n" +
                "https://play.google.com/store/apps/details?id=com.refreshideas.cashmysalary1&hl=en";

        Intent sendIntent = new Intent(Intent.ACTION_SENDTO,Uri.parse("mailto:"));
        sendIntent.putExtra(Intent.EXTRA_TEXT, shareMessage);
        sendIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, shareSubject);
        startActivity(sendIntent);
    }

    public void shareViaSMS(){
        Uri smsToUri = Uri.parse( "smsto:" );
        //Java
        String shareMessage = "Hi\n\n"+"I use CashMySalary to borrow cash and it's really quick. CashMySalary gives you an instant loan upto Rs 2 Lakh starting at just 0.8% a day. Sign up with my code"+" "+"'"+getActivity().getResources().getString(R.string.referral_code)+"'"+" and we both can get some discount on processing fee.\n\n" +
                "Get the CashMySalary app from the link below. \n" +
                "https://play.google.com/store/apps/details?id=com.refreshideas.cashmysalary1&hl=en";

        Intent sendIntent = new Intent(Intent.ACTION_VIEW,smsToUri);
        sendIntent.putExtra("sms_body", shareMessage);
        sendIntent.setType("vnd.android-dir/mms-sms");
        startActivity(sendIntent);
    }
    public void shareVia(){
        //Java
        String shareSubject = "";
        String shareMessage = "Hi\n\n"+"I use CashMySalary to borrow cash and it's really quick. CashMySalary gives you an instant loan upto Rs 2 Lakh starting at just 0.8% a day. Sign up with my code"+" "+"'"+getActivity().getResources().getString(R.string.referral_code)+"'"+" and we both can get some discount on processing fee.\n\n" +
                "Get the CashMySalary app from the link below. \n" +
                "https://play.google.com/store/apps/details?id=com.refreshideas.cashmysalary1&hl=en";

        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, shareSubject);
        sendIntent.putExtra(Intent.EXTRA_TEXT, shareMessage);
        sendIntent.setType("text/plain");
        startActivity(Intent.createChooser(sendIntent, "Share Via"));
    }
}
