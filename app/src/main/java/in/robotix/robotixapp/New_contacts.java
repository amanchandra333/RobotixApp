package in.robotix.robotixapp;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class New_contacts extends Activity{

    final Context context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_contacts_complete);

        ImageView fb = (ImageView) findViewById(R.id.fb);
        ImageView home = (ImageView) findViewById(R.id.home);
        ImageView yt = (ImageView) findViewById(R.id.yt);
        ImageView wp = (ImageView) findViewById(R.id.wp);
        ImageView tw = (ImageView) findViewById(R.id.tw);
        ImageView web= (ImageView) findViewById(R.id.web);

        web.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                // Launching News Feed Screen
                Intent website= new Intent();
                website.setAction(Intent.ACTION_VIEW);
                website.addCategory(Intent.CATEGORY_BROWSABLE);
                website.setData(Uri.parse("http://robotix.in/"));
                startActivity(website);
            }
        });

        home.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent kraig = new Intent("in.robotix.robotixapp.DBD");
                startActivity(kraig);
            }
        });

        fb.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                // Launching News Feed Screen
                Intent updates = new Intent();
                updates.setAction(Intent.ACTION_VIEW);
                updates.addCategory(Intent.CATEGORY_BROWSABLE);
                updates.setData(Uri.parse("https://www.facebook.com/robotixiitkgp"));
                startActivity(updates);
            }
        });

        yt.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                // Launching News Feed Screen
                Intent updates = new Intent();
                updates.setAction(Intent.ACTION_VIEW);
                updates.addCategory(Intent.CATEGORY_BROWSABLE);
                updates.setData(Uri.parse("http://www.youtube.com/robotixiitkgp"));
                startActivity(updates);
            }
        });

        wp.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                // Launching News Feed Screen
                Intent updates = new Intent();
                updates.setAction(Intent.ACTION_VIEW);
                updates.addCategory(Intent.CATEGORY_BROWSABLE);
                updates.setData(Uri.parse("http://blog.robotix.in/"));
                startActivity(updates);
            }
        });

        tw.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                // Launching News Feed Screen
                Intent updates = new Intent();
                updates.setAction(Intent.ACTION_VIEW);
                updates.addCategory(Intent.CATEGORY_BROWSABLE);
                updates.setData(Uri.parse("https://twitter.com/robotixiitkgp"));
                startActivity(updates);
            }
        });
        TextView head1tv = (TextView)findViewById(R.id.head1tv);
        ImageView head1 = (ImageView)findViewById(R.id.head1);

        TextView head2tv = (TextView)findViewById(R.id.head2tv);
        ImageView head2 = (ImageView)findViewById(R.id.head2);

        TextView head3tv = (TextView)findViewById(R.id.head3tv);
        ImageView head3 = (ImageView)findViewById(R.id.head3);

        TextView head4tv = (TextView)findViewById(R.id.head4tv);
        ImageView head4 = (ImageView)findViewById(R.id.head4);

        TextView head5tv = (TextView)findViewById(R.id.head5tv);
        ImageView head5 = (ImageView)findViewById(R.id.head5);

        TextView head6tv = (TextView)findViewById(R.id.head6tv);
        ImageView head6 = (ImageView)findViewById(R.id.head6);

        TextView head7tv = (TextView)findViewById(R.id.head7tv);
        ImageView head7 = (ImageView)findViewById(R.id.head7);

        TextView head8tv = (TextView)findViewById(R.id.head8tv);
        ImageView head8 = (ImageView)findViewById(R.id.head8);

        TextView head9tv = (TextView)findViewById(R.id.head9tv);
        ImageView head9 = (ImageView)findViewById(R.id.head9);

        TextView head10tv = (TextView)findViewById(R.id.head10tv);
        ImageView head10 = (ImageView)findViewById(R.id.head10);

        TextView head11tv = (TextView)findViewById(R.id.head11tv);
        ImageView head11 = (ImageView)findViewById(R.id.head11);

        // For each heads  ///////////////////////////////////////////////////////// Anchit


        head1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                // Launching News Feed Screen
                Intent updates = new Intent();
                updates.setAction(Intent.ACTION_VIEW);
                updates.addCategory(Intent.CATEGORY_BROWSABLE);
                updates.setData(Uri.parse("https://www.facebook.com/anchitn"));
                startActivity(updates);
            }
        });

        head1tv.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                // Launching News Feed Screen
                final Dialog dialog = new Dialog(context,R.style.ContactDialog);
                dialog.setContentView(R.layout.contacts_dialog);
                //dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
                dialog.setTitle("Contact Details");

                // set the custom dialog components - text, image and button
                Button dialogButton1 = (Button) dialog.findViewById(R.id.contact_no_btn);
                Button dialogButton2 = (Button) dialog.findViewById(R.id.contact_email_btn);
                TextView contact_no = (TextView) dialog.findViewById(R.id.contact_no);
                TextView contact_email = (TextView)dialog.findViewById(R.id.contact_email);
                TextView contact_name = (TextView)dialog.findViewById(R.id.contact_name);

                contact_name.setText("Anchit Navelkar");

                contact_no.setText("+91-8348664782");
                contact_email.setText("anchitn@robotix.in");

                // if button is clicked, close the custom dialog
                dialogButton1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                        Intent callIntent = new Intent(Intent.ACTION_CALL);
                        callIntent.setData(Uri.parse("tel:08348664782"));
                        startActivity(callIntent);
                    }
                });

                dialogButton2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        // Launching News Feed Screen
                        Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
                        emailIntent.setType("message/rfc822");
                        emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"anchitn@robotix.in"});
                        startActivity(Intent.createChooser(emailIntent, "Send Email"));
                    }
                });


                dialog.show();
            }
        });

        // /////////////////////////////////////////////////////////////


        // For each heads ///////////////////////////////////////////////////////// Sudeshna


        head2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                // Launching News Feed Screen
                Intent updates = new Intent();
                updates.setAction(Intent.ACTION_VIEW);
                updates.addCategory(Intent.CATEGORY_BROWSABLE);
                updates.setData(Uri.parse("https://www.facebook.com/sudutri"));
                startActivity(updates);
            }
        });

        head2tv.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                // Launching News Feed Screen
                final Dialog dialog = new Dialog(context,R.style.ContactDialog);
                dialog.setContentView(R.layout.contacts_dialog);
                //dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
                dialog.setTitle("Contact Details");

                // set the custom dialog components - text, image and button
                Button dialogButton1 = (Button) dialog.findViewById(R.id.contact_no_btn);
                Button dialogButton2 = (Button) dialog.findViewById(R.id.contact_email_btn);
                TextView contact_no = (TextView) dialog.findViewById(R.id.contact_no);
                TextView contact_email = (TextView)dialog.findViewById(R.id.contact_email);
                TextView contact_name = (TextView)dialog.findViewById(R.id.contact_name);

                contact_name.setText("Sudeshna Trilok");

                contact_no.setText("+91-9800134697");
                contact_email.setText("sudeshna@robotix.in");

                // if button is clicked, close the custom dialog
                dialogButton1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                        Intent callIntent = new Intent(Intent.ACTION_CALL);
                        callIntent.setData(Uri.parse("tel:09800134697"));
                        startActivity(callIntent);
                    }
                });

                dialogButton2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        // Launching News Feed Screen
                        Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
                        emailIntent.setType("message/rfc822");
                        emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"sudeshna@robotix.in"});
                        startActivity(Intent.createChooser(emailIntent, "Send Email"));
                    }
                });


                dialog.show();
            }
        });

        // /////////////////////////////////////////////////////////////

        // For each heads ///////////////////////////////////////////////////////// Vipasha

        head3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                // Launching News Feed Screen
                Intent updates = new Intent();
                updates.setAction(Intent.ACTION_VIEW);
                updates.addCategory(Intent.CATEGORY_BROWSABLE);
                updates.setData(Uri.parse("https://www.facebook.com/vipasha.jain.73"));
                startActivity(updates);
            }
        });

        head3tv.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                // Launching News Feed Screen
                final Dialog dialog = new Dialog(context,R.style.ContactDialog);
                dialog.setContentView(R.layout.contacts_dialog);
                //dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
                dialog.setTitle("Contact Details");

                // set the custom dialog components - text, image and button
                Button dialogButton1 = (Button) dialog.findViewById(R.id.contact_no_btn);
                Button dialogButton2 = (Button) dialog.findViewById(R.id.contact_email_btn);
                TextView contact_no = (TextView) dialog.findViewById(R.id.contact_no);
                TextView contact_email = (TextView)dialog.findViewById(R.id.contact_email);
                TextView contact_name = (TextView)dialog.findViewById(R.id.contact_name);

                contact_name.setText("Vipasha Jain");

                contact_no.setText("+91-8101443646");
                contact_email.setText("vipasha@robotix.in");

                // if button is clicked, close the custom dialog
                dialogButton1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                        Intent callIntent = new Intent(Intent.ACTION_CALL);
                        callIntent.setData(Uri.parse("tel:08101443646"));
                        startActivity(callIntent);
                    }
                });

                dialogButton2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        // Launching News Feed Screen
                        Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
                        emailIntent.setType("message/rfc822");
                        emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"vipasha@robotix.in"});
                        startActivity(Intent.createChooser(emailIntent, "Send Email"));
                    }
                });


                dialog.show();
            }
        });

        // /////////////////////////////////////////////////////////////

        // For each heads ///////////////////////////////////////////////////////// Ruchita

        head4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                // Launching News Feed Screen
                Intent updates = new Intent();
                updates.setAction(Intent.ACTION_VIEW);
                updates.addCategory(Intent.CATEGORY_BROWSABLE);
                updates.setData(Uri.parse("https://www.facebook.com/ruchita.kachhap"));
                startActivity(updates);
            }
        });

        head4tv.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                // Launching News Feed Screen
                final Dialog dialog = new Dialog(context,R.style.ContactDialog);
                dialog.setContentView(R.layout.contacts_dialog);
                //dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
                dialog.setTitle("Contact Details");

                // set the custom dialog components - text, image and button
                Button dialogButton1 = (Button) dialog.findViewById(R.id.contact_no_btn);
                Button dialogButton2 = (Button) dialog.findViewById(R.id.contact_email_btn);
                TextView contact_no = (TextView) dialog.findViewById(R.id.contact_no);
                TextView contact_email = (TextView)dialog.findViewById(R.id.contact_email);
                TextView contact_name = (TextView)dialog.findViewById(R.id.contact_name);

                contact_name.setText("Ruchita Kachhap");

                contact_no.setText("+91-9126149118");
                contact_email.setText("ruchita@robotix.in");

                // if button is clicked, close the custom dialog
                dialogButton1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                        Intent callIntent = new Intent(Intent.ACTION_CALL);
                        callIntent.setData(Uri.parse("tel:09126149118"));
                        startActivity(callIntent);
                    }
                });

                dialogButton2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        // Launching News Feed Screen
                        Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
                        emailIntent.setType("message/rfc822");
                        emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"ruchita@robotix.in"});
                        startActivity(Intent.createChooser(emailIntent, "Send Email"));
                    }
                });


                dialog.show();
            }
        });

        // /////////////////////////////////////////////////////////////

        // For each heads ///////////////////////////////////////////////////////// Harsheel

        head5.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                // Launching News Feed Screen
                Intent updates = new Intent();
                updates.setAction(Intent.ACTION_VIEW);
                updates.addCategory(Intent.CATEGORY_BROWSABLE);
                updates.setData(Uri.parse("https://www.facebook.com/harsheel.soin"));
                startActivity(updates);
            }
        });

        head5tv.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                // Launching News Feed Screen
                final Dialog dialog = new Dialog(context,R.style.ContactDialog);
                dialog.setContentView(R.layout.contacts_dialog);
                //dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
                dialog.setTitle("Contact Details");

                // set the custom dialog components - text, image and button
                Button dialogButton1 = (Button) dialog.findViewById(R.id.contact_no_btn);
                Button dialogButton2 = (Button) dialog.findViewById(R.id.contact_email_btn);
                TextView contact_no = (TextView) dialog.findViewById(R.id.contact_no);
                TextView contact_email = (TextView)dialog.findViewById(R.id.contact_email);
                TextView contact_name = (TextView)dialog.findViewById(R.id.contact_name);

                contact_name.setText("Harsheel Singh Soin");

                contact_no.setText("+91-8967762824");
                contact_email.setText("harsheel@robotix.in");

                // if button is clicked, close the custom dialog
                dialogButton1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                        Intent callIntent = new Intent(Intent.ACTION_CALL);
                        callIntent.setData(Uri.parse("tel:08967762824"));
                        startActivity(callIntent);
                    }
                });

                dialogButton2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        // Launching News Feed Screen
                        Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
                        emailIntent.setType("message/rfc822");
                        emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"harsheel@robotix.in"});
                        startActivity(Intent.createChooser(emailIntent, "Send Email"));
                    }
                });


                dialog.show();
            }
        });

        // /////////////////////////////////////////////////////////////

        // For each heads ///////////////////////////////////////////////////////// Ashutosh

        head6.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                // Launching News Feed Screen
                Intent updates = new Intent();
                updates.setAction(Intent.ACTION_VIEW);
                updates.addCategory(Intent.CATEGORY_BROWSABLE);
                updates.setData(Uri.parse("https://www.facebook.com/ashutosh.baheti95"));
                startActivity(updates);
            }
        });

        head6tv.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                // Launching News Feed Screen
                final Dialog dialog = new Dialog(context,R.style.ContactDialog);
                dialog.setContentView(R.layout.contacts_dialog);
                //dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
                dialog.setTitle("Contact Details");

                // set the custom dialog components - text, image and button
                Button dialogButton1 = (Button) dialog.findViewById(R.id.contact_no_btn);
                Button dialogButton2 = (Button) dialog.findViewById(R.id.contact_email_btn);
                TextView contact_no = (TextView) dialog.findViewById(R.id.contact_no);
                TextView contact_email = (TextView)dialog.findViewById(R.id.contact_email);
                TextView contact_name = (TextView)dialog.findViewById(R.id.contact_name);

                contact_name.setText("Ashutosh Baheti");

                contact_no.setText("+91-8159875992");
                contact_email.setText("ashutosh@robotix.in");

                // if button is clicked, close the custom dialog
                dialogButton1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                        Intent callIntent = new Intent(Intent.ACTION_CALL);
                        callIntent.setData(Uri.parse("tel:08159875992"));
                        startActivity(callIntent);
                    }
                });

                dialogButton2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        // Launching News Feed Screen
                        Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
                        emailIntent.setType("message/rfc822");
                        emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"ashutosh@robotix.in"});
                        startActivity(Intent.createChooser(emailIntent, "Send Email"));
                    }
                });


                dialog.show();
            }
        });

        // /////////////////////////////////////////////////////////////


        // For each heads ///////////////////////////////////////////////////////// Ayush

        head7.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                // Launching News Feed Screen
                Intent updates = new Intent();
                updates.setAction(Intent.ACTION_VIEW);
                updates.addCategory(Intent.CATEGORY_BROWSABLE);
                updates.setData(Uri.parse("https://www.facebook.com/gargayush792"));
                startActivity(updates);
            }
        });

        head7tv.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                // Launching News Feed Screen
                final Dialog dialog = new Dialog(context,R.style.ContactDialog);
                dialog.setContentView(R.layout.contacts_dialog);
                //dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
                dialog.setTitle("Contact Details");

                // set the custom dialog components - text, image and button
                Button dialogButton1 = (Button) dialog.findViewById(R.id.contact_no_btn);
                Button dialogButton2 = (Button) dialog.findViewById(R.id.contact_email_btn);
                TextView contact_no = (TextView) dialog.findViewById(R.id.contact_no);
                TextView contact_email = (TextView)dialog.findViewById(R.id.contact_email);
                TextView contact_name = (TextView)dialog.findViewById(R.id.contact_name);

                contact_name.setText("Ayush Garg");

                contact_no.setText("+91-9002297176");
                contact_email.setText("ayush.garg@robotix.in");

                // if button is clicked, close the custom dialog
                dialogButton1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                        Intent callIntent = new Intent(Intent.ACTION_CALL);
                        callIntent.setData(Uri.parse("tel:09002297176"));
                        startActivity(callIntent);
                    }
                });

                dialogButton2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        // Launching News Feed Screen
                        Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
                        emailIntent.setType("message/rfc822");
                        emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"ayush.garg@robotix.in"});
                        startActivity(Intent.createChooser(emailIntent, "Send Email"));
                    }
                });


                dialog.show();
            }
        });

        // /////////////////////////////////////////////////////////////

        // For each heads ///////////////////////////////////////////////////////// Choudhury

        head8.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                // Launching News Feed Screen
                final Dialog dialog = new Dialog(context,R.style.ContactDialog);
                dialog.setContentView(R.layout.contacts_dialog);
                //dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
                dialog.setTitle("Contact Details");

                // set the custom dialog components - text, image and button
                Button dialogButton1 = (Button) dialog.findViewById(R.id.contact_no_btn);
                Button dialogButton2 = (Button) dialog.findViewById(R.id.contact_email_btn);
                TextView contact_no = (TextView) dialog.findViewById(R.id.contact_no);
                TextView contact_email = (TextView)dialog.findViewById(R.id.contact_email);
                TextView contact_name = (TextView)dialog.findViewById(R.id.contact_name);

                contact_name.setText("Choudhary Electronics");

                contact_no.setText("+91-9434415812");
                contact_email.setVisibility(View.GONE);
                dialogButton2.setVisibility(View.GONE);

                // if button is clicked, close the custom dialog
                dialogButton1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                        Intent callIntent = new Intent(Intent.ACTION_CALL);
                        callIntent.setData(Uri.parse("tel:09434415812"));
                        startActivity(callIntent);
                    }
                });

//                dialogButton2.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        // Launching News Feed Screen
//                        Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
//                        emailIntent.setType("message/rfc822");
//                        emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{""});
//                        startActivity(Intent.createChooser(emailIntent, "Send Email"));
//                    }
//                });


                dialog.show();
            }
        });

        head8tv.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                // Launching News Feed Screen
                final Dialog dialog = new Dialog(context,R.style.ContactDialog);
                dialog.setContentView(R.layout.contacts_dialog);
                //dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
                dialog.setTitle("Contact Details");

                // set the custom dialog components - text, image and button
                Button dialogButton1 = (Button) dialog.findViewById(R.id.contact_no_btn);
                Button dialogButton2 = (Button) dialog.findViewById(R.id.contact_email_btn);
                TextView contact_no = (TextView) dialog.findViewById(R.id.contact_no);
                TextView contact_email = (TextView)dialog.findViewById(R.id.contact_email);
                TextView contact_name = (TextView)dialog.findViewById(R.id.contact_name);

                contact_name.setText("Choudhary Electronics");

                contact_no.setText("+91-9434415812");
                contact_email.setVisibility(View.GONE);
                dialogButton2.setVisibility(View.GONE);

                // if button is clicked, close the custom dialog
                dialogButton1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                        Intent callIntent = new Intent(Intent.ACTION_CALL);
                        callIntent.setData(Uri.parse("tel:09434415812"));
                        startActivity(callIntent);
                    }
                });

//                dialogButton2.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        // Launching News Feed Screen
//                        Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
//                        emailIntent.setType("message/rfc822");
//                        emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{""});
//                        startActivity(Intent.createChooser(emailIntent, "Send Email"));
//                    }
//                });


                dialog.show();
            }
        });

        // /////////////////////////////////////////////////////////////

        // For each heads ///////////////////////////////////////////////////////// Carpenter

        head9.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                // Launching News Feed Screen
                final Dialog dialog = new Dialog(context,R.style.ContactDialog);
                dialog.setContentView(R.layout.contacts_dialog);
                //dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
                dialog.setTitle("Contact Details");

                // set the custom dialog components - text, image and button
                Button dialogButton1 = (Button) dialog.findViewById(R.id.contact_no_btn);
                Button dialogButton2 = (Button) dialog.findViewById(R.id.contact_email_btn);
                TextView contact_no = (TextView) dialog.findViewById(R.id.contact_no);
                TextView contact_email = (TextView)dialog.findViewById(R.id.contact_email);
                TextView contact_name = (TextView)dialog.findViewById(R.id.contact_name);

                contact_name.setText("Umesh carpenter");

                contact_no.setText("+91-9333413982");
                contact_email.setVisibility(View.GONE);
                dialogButton2.setVisibility(View.GONE);

                // if button is clicked, close the custom dialog
                dialogButton1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                        Intent callIntent = new Intent(Intent.ACTION_CALL);
                        callIntent.setData(Uri.parse("tel:09333413982"));
                        startActivity(callIntent);
                    }
                });

//                dialogButton2.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        // Launching News Feed Screen
//                        Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
//                        emailIntent.setType("message/rfc822");
//                        emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{""});
//                        startActivity(Intent.createChooser(emailIntent, "Send Email"));
//                    }
//                });


                dialog.show();
            }
        });

        head9tv.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                // Launching News Feed Screen
                final Dialog dialog = new Dialog(context,R.style.ContactDialog);
                dialog.setContentView(R.layout.contacts_dialog);
                //dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
                dialog.setTitle("Contact Details");

                // set the custom dialog components - text, image and button
                Button dialogButton1 = (Button) dialog.findViewById(R.id.contact_no_btn);
                Button dialogButton2 = (Button) dialog.findViewById(R.id.contact_email_btn);
                TextView contact_no = (TextView) dialog.findViewById(R.id.contact_no);
                TextView contact_email = (TextView)dialog.findViewById(R.id.contact_email);
                TextView contact_name = (TextView)dialog.findViewById(R.id.contact_name);

                contact_name.setText("Carpenter");

                contact_no.setText("+91-9434415812");
                contact_email.setVisibility(View.GONE);
                dialogButton2.setVisibility(View.GONE);

                // if button is clicked, close the custom dialog
                dialogButton1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                        Intent callIntent = new Intent(Intent.ACTION_CALL);
                        callIntent.setData(Uri.parse("tel:09434415812"));
                        startActivity(callIntent);
                    }
                });

//                dialogButton2.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        // Launching News Feed Screen
//                        Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
//                        emailIntent.setType("message/rfc822");
//                        emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{""});
//                        startActivity(Intent.createChooser(emailIntent, "Send Email"));
//                    }
//                });


                dialog.show();
            }
        });

        // /////////////////////////////////////////////////////////////

        // For each heads ///////////////////////////////////////////////////////// Accomodation

        head10.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View view) {
            // Launching News Feed Screen
            final Dialog dialog = new Dialog(context,R.style.ContactDialog);
            dialog.setContentView(R.layout.contacts_dialog);
            //dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
            dialog.setTitle("Contact Details");

            // set the custom dialog components - text, image and button
            Button dialogButton1 = (Button) dialog.findViewById(R.id.contact_no_btn);
            Button dialogButton2 = (Button) dialog.findViewById(R.id.contact_email_btn);
            TextView contact_no = (TextView) dialog.findViewById(R.id.contact_no);
            TextView contact_email = (TextView)dialog.findViewById(R.id.contact_email);
            TextView contact_name = (TextView)dialog.findViewById(R.id.contact_name);

            contact_name.setText("Ankit Choudhary");

            contact_no.setText("+91-8170057552");
            contact_email.setVisibility(View.GONE);
            dialogButton2.setVisibility(View.GONE);

            // if button is clicked, close the custom dialog
            dialogButton1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                    Intent callIntent = new Intent(Intent.ACTION_CALL);
                    callIntent.setData(Uri.parse("tel:08170057552"));
                    startActivity(callIntent);
                }
            });

//                dialogButton2.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        // Launching News Feed Screen
//                        Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
//                        emailIntent.setType("message/rfc822");
//                        emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{""});
//                        startActivity(Intent.createChooser(emailIntent, "Send Email"));
//                    }
//                });


            dialog.show();
        }
    });

        head10tv.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                // Launching News Feed Screen
                final Dialog dialog = new Dialog(context,R.style.ContactDialog);
                dialog.setContentView(R.layout.contacts_dialog);
                //dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
                dialog.setTitle("Contact Details");

                // set the custom dialog components - text, image and button
                Button dialogButton1 = (Button) dialog.findViewById(R.id.contact_no_btn);
                Button dialogButton2 = (Button) dialog.findViewById(R.id.contact_email_btn);
                TextView contact_no = (TextView) dialog.findViewById(R.id.contact_no);
                TextView contact_email = (TextView)dialog.findViewById(R.id.contact_email);
                TextView contact_name = (TextView)dialog.findViewById(R.id.contact_name);

                contact_name.setText("Ankit Choudhary");

                contact_no.setText("+91-8170057552");
                contact_email.setVisibility(View.GONE);
                dialogButton2.setVisibility(View.GONE);

                // if button is clicked, close the custom dialog
                dialogButton1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                        Intent callIntent = new Intent(Intent.ACTION_CALL);
                        callIntent.setData(Uri.parse("tel:08170057552"));
                        startActivity(callIntent);
                    }
                });

//                dialogButton2.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        // Launching News Feed Screen
//                        Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
//                        emailIntent.setType("message/rfc822");
//                        emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{""});
//                        startActivity(Intent.createChooser(emailIntent, "Send Email"));
//                    }
//                });


                dialog.show();
            }
        });

        // /////////////////////////////////////////////////////////////


        // For each heads ///////////////////////////////////////////////////////// Vipasha

        head11.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                // Launching News Feed Screen
                Intent updates = new Intent();
                updates.setAction(Intent.ACTION_VIEW);
                updates.addCategory(Intent.CATEGORY_BROWSABLE);
                updates.setData(Uri.parse("https://www.facebook.com/vipasha.jain.73"));
                startActivity(updates);
            }
        });

        head11tv.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                // Launching News Feed Screen
                final Dialog dialog = new Dialog(context,R.style.ContactDialog);
                dialog.setContentView(R.layout.contacts_dialog);
                //dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
                dialog.setTitle("Contact Details");

                // set the custom dialog components - text, image and button
                Button dialogButton1 = (Button) dialog.findViewById(R.id.contact_no_btn);
                Button dialogButton2 = (Button) dialog.findViewById(R.id.contact_email_btn);
                TextView contact_no = (TextView) dialog.findViewById(R.id.contact_no);
                TextView contact_email = (TextView)dialog.findViewById(R.id.contact_email);
                TextView contact_name = (TextView)dialog.findViewById(R.id.contact_name);

                contact_name.setText("Vipasha Jain");

                contact_no.setText("+91-8101443646");
                contact_email.setText("vipasha@robotix.in");

                // if button is clicked, close the custom dialog
                dialogButton1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                        Intent callIntent = new Intent(Intent.ACTION_CALL);
                        callIntent.setData(Uri.parse("tel:08101443646"));
                        startActivity(callIntent);
                    }
                });

                dialogButton2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        // Launching News Feed Screen
                        Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
                        emailIntent.setType("message/rfc822");
                        emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"vipasha@robotix.in"});
                        startActivity(Intent.createChooser(emailIntent, "Send Email"));
                    }
                });


                dialog.show();
            }
        });

        // /////////////////////////////////////////////////////////////






    }

    }