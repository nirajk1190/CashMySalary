package com.cashmysalary.utility;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.view.Window;
import android.widget.TextView;

import com.cashmysalary.R;


/**
 * The type Custom progress dialog.
 */
public class CustomProgressDialog extends Dialog {
    private TextView _tvLoadingText;

    /**
     * Instantiates a new Custom progress dialog.
     *
     * @param activity        the context
     * @param progressMessage the progress message
     */
//String _progressMessage;
    public CustomProgressDialog(Activity activity, String progressMessage) {
        super(activity);

        // dismiss();
        // ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(activity, R.style.DialogThemeNoTitle);
        //  LayoutInflater inflater = LayoutInflater.from(activity);
        //   View dialogView = inflater.inflate(R.layout.custom_progress_dialog, null);


        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        setContentView(R.layout.custom_progress_dialog);
        setCanceledOnTouchOutside(false);


        _tvLoadingText = findViewById(R.id.tvLoadingText);
        _tvLoadingText.setText(progressMessage);
        // AlertDialog.Builder alertDialog = new AlertDialog.Builder(contextThemeWrapper);
//		   getWindow().setType(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT );

      /*  try {
            int LAYOUT_FLAG;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//				LAYOUT_FLAG = WindowManager.LayoutParams.TYPE_ACCESSIBILITY_OVERLAY;
                getWindow().setType(WindowManager.LayoutParams.TYPE_ACCESSIBILITY_OVERLAY);
            } else {
//				LAYOUT_FLAG = WindowManager.LayoutParams.TYPE_TOAST;
                getWindow().setType(WindowManager.LayoutParams.TYPE_TOAST);
//
            }
//		WindowManager windowManager = (WindowManager)context,getSystemService(WINDOW_SERVICE);
            //here is all the science of params\
//			final WindowManager.LayoutParams
//					params = new WindowManager.LayoutParams(
//					WindowManager.LayoutParams.WRAP_CONTENT,
//					WindowManager.LayoutParams.WRAP_CONTENT,
//					LAYOUT_FLAG,
//					WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE | WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN | WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
//					PixelFormat.TRANSLUCENT);
//		   getWindow().setType(WindowManager.LayoutParams.TYPE_APPLICATION_PANEL );
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        //  alertDialog.setView(dialogView);

        //  alertDialog.create();

        // alertDialog.show();
        try {
            if (isShowing()) {
                dismiss();
            } else {
                show();
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        //_progressMessage = progressMessage;

    }
	/*@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		LayoutInflater inflater = (LayoutInflater) getLayoutInflater();
		View view = inflater.inflate(R.layout.custom_progress_dialog, null);
		_tvLoadingText = (TextView)view.findViewById(R.id.tvLoadingText);
		_tvLoadingText.setText(_progressMessage);
		setCanceledOnTouchOutside(true);
//		requestWindowFeature(Window.FEATURE_NO_TITLE);
	}*/


    /**
     * Sets message.
     *
     * @param message the message
     */
    public void setMessage(CharSequence message) {
        _tvLoadingText.setText(message);
    }
}