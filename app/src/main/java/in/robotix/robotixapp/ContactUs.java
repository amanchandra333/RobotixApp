package in.robotix.robotixapp;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.json.JSONObject;

/**
 * Created by lenovo on 24-Jan-17.
 */

public class ContactUs extends NavigationDrawer{

    Config mConfig;
    final Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View contentView = inflater.inflate(R.layout.contact_us, null, false);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);
        mContentMain.addView(contentView, params);
        mConfig = new Config(this);
        TextView[] head_tv = new TextView[mConfig.contactUsNames.size()];
        ImageView[] head_iv = new ImageView[mConfig.contactUsNames.size()];
        for(int i = 0; i < mConfig.contactUsNames.size(); i++) {
            String head_name = mConfig.contactUsNames.get(i);
            String head_number = "";
            String head_full_name = "";
            String head_email = "";
            String head_facebook = "";
            try{
                JSONObject jObject = new JSONObject(mConfig.contactDetails.get(head_name));
                head_full_name = jObject.getString("name");
                head_number = jObject.getString("phone");
                head_email = jObject.getString("email");
                head_facebook = jObject.getString("facebook");
                //Log.w("myApp", head_facebook);

            }catch (Exception e) {
                e.printStackTrace();
            }

            final String head_number_f = head_number;
            final String head_full_name_f = head_full_name;
            final String head_email_f = head_email;
            final String head_facebook_f = head_facebook;

            head_tv[i] = (TextView)findViewById(getResources().getIdentifier(head_name+"_tv", "id", getPackageName()));
            head_iv[i] = (ImageView)findViewById(getResources().getIdentifier(head_name+"_iv", "id", getPackageName()));

            head_tv[i].setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    Intent callIntent = new Intent(Intent.ACTION_DIAL);
                    callIntent.setData(Uri.parse("tel:"+head_number_f));
                    startActivity(callIntent);
                }
            });

            head_iv[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    final Dialog dialog = new Dialog(context,R.style.ContactDialog);
                    dialog.setContentView(R.layout.contacts_dialog);
                    dialog.setTitle("Contact Details");
                    Button dialogButton1 = (Button) dialog.findViewById(R.id.contact_no_btn);
                    Button dialogButton2 = (Button) dialog.findViewById(R.id.contact_email_btn);
                    Button dialogButton3 = (Button) dialog.findViewById(R.id.contact_facebook_btn);
                    TextView contact_no = (TextView) dialog.findViewById(R.id.contact_no);
                    TextView contact_email = (TextView)dialog.findViewById(R.id.contact_email);
                    TextView contact_name = (TextView)dialog.findViewById(R.id.contact_name);

                    contact_name.setText(head_full_name_f);
                    contact_no.setText(head_number_f);

                    if(!head_email_f.equals(""))contact_email.setText(head_email_f);
                    else{
                        contact_email.setVisibility(View.GONE);
                        dialogButton2.setVisibility(View.GONE);
                    }
                    if(head_facebook_f.equals(""))dialogButton3.setVisibility(View.GONE);

                    dialogButton1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.dismiss();
                            Intent callIntent = new Intent(Intent.ACTION_DIAL);
                            callIntent.setData(Uri.parse("tel:"+head_number_f));
                            startActivity(callIntent);
                        }
                    });

                    if(!head_email_f.equals("")){
                        dialogButton2.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
                                emailIntent.setType("message/rfc822");
                                emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{head_email_f});
                                startActivity(Intent.createChooser(emailIntent, "Send Email"));
                            }
                        });
                    }

                    if(!head_facebook_f.equals("")) {
                        dialogButton3.setOnClickListener(new View.OnClickListener() {

                            @Override
                            public void onClick(View view) {
                                Intent updates = new Intent();
                                updates.setAction(Intent.ACTION_VIEW);
                                updates.addCategory(Intent.CATEGORY_BROWSABLE);
                                updates.setData(Uri.parse(head_facebook_f));
                                startActivity(updates);
                            }
                        });
                    }
                    dialog.show();
                }
            });
        }
    }
}
