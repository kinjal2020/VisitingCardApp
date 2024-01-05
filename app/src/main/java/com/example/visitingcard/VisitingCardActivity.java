package com.example.visitingcard;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class VisitingCardActivity extends AppCompatActivity {

    TextView fNameTextView;
    TextView designationTextView;
    TextView companyTextView;
    TextView aboutTextView;
    TextView serviceTextView;
    TextView addressTextView;
    TextView emailTextView;
    TextView contactTextView;
    FloatingActionButton btnDownload;
    FloatingActionButton btnEdit;
    RelativeLayout cardLayout;
    RelativeLayout contentLayout;

    CardView btnCall;
    CardView btnEmail;
    CardView btnLocation;
    CircleImageView imageView;


//    List<Integer> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visiting_card);
        initBinding();
       Uri uri= Uri.parse(getIntent().getStringExtra("imageView"));
        Log.d("ImageTAG", "onCreate: "+uri);
        imageView.setImageURI(uri);

        String fName = getIntent().getStringExtra("fName");
        String company = getIntent().getStringExtra("company");
        String designation = getIntent().getStringExtra("designation");
        String about = getIntent().getStringExtra("about");
        String address = getIntent().getStringExtra("address");
        String service = getIntent().getStringExtra("service");
        String email = getIntent().getStringExtra("email");
        String contact = getIntent().getStringExtra("contact");
        fNameTextView.setText(fName);
        companyTextView.setText(company);
        designationTextView.setText(designation);
        aboutTextView.setText(about);
        addressTextView.setText(address);
        companyTextView.setText(company);
        contactTextView.setText(contact);
        serviceTextView.setText(service);
        emailTextView.setText(email);

        btnDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                cardLayout.setDrawingCacheEnabled(true);
                Bitmap bitmap = cardLayout.getDrawingCache();
                File file, f = null;

//                if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
                    file = new File(Environment.getExternalStorageDirectory(), "TTImages_cache");
                    if (!file.exists()) {
                        file.mkdirs();

                    }
                    f = new File(file.getAbsolutePath() + "filename" + ".png");
//                }
                Log.d("TAG", "onClick: "+f.getAbsolutePath());
                FileOutputStream ostream = null;
                try {
                    ostream = new FileOutputStream(f);
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
                bitmap.compress(Bitmap.CompressFormat.PNG, 10, ostream);
                try {
                    ostream.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }


            }
        });

        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:8849624886"));
                startActivity(intent);
            }
        });

        btnEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_EMAIL, "test@yopmail.com");
                startActivity(Intent.createChooser(intent, "Choose Email Account"));
            }
        });


        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                cardLayout.setBackgroundResource(R.color.skyBlue);

                AlertDialog.Builder builder = new AlertDialog.Builder(VisitingCardActivity.this);
                final View customLayout = getLayoutInflater().inflate(R.layout.alert_dialog, null);
                builder.setView(customLayout);
                AlertDialog dialog = builder.create();
                dialog.show();

                CardView cvGreen = customLayout.findViewById(R.id.cardGreen);
                CardView cvOrange = customLayout.findViewById(R.id.cardOrange);
                CardView cvRed = customLayout.findViewById(R.id.cardRed);
                CardView cvBlue = customLayout.findViewById(R.id.cardBlue);
                CardView cvPink = customLayout.findViewById(R.id.cardPink);
                CardView cvBg1 = customLayout.findViewById(R.id.cardBg1);
                CardView cvBg2 = customLayout.findViewById(R.id.cardBg2);
                CardView cvBg3 = customLayout.findViewById(R.id.cardBg3);
                CardView cvBg4 = customLayout.findViewById(R.id.cardBg4);
                CardView cvBg5 = customLayout.findViewById(R.id.cardBg5);
                TextView font1 = customLayout.findViewById(R.id.font1);
                TextView font2 = customLayout.findViewById(R.id.font2);
                TextView font3 = customLayout.findViewById(R.id.font3);
                TextView font4 = customLayout.findViewById(R.id.font4);
                TextView font5 = customLayout.findViewById(R.id.font5);


                cvGreen.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        cardLayout.setBackgroundResource(R.color.darkGreen);
                    }
                });
                cvOrange.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        cardLayout.setBackgroundResource(R.color.orange);
                    }
                });
                cvRed.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        cardLayout.setBackgroundResource(R.color.red);
                    }
                });
                cvBlue.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        cardLayout.setBackgroundResource(R.color.darkBlue);
                    }
                });
                cvPink.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        cardLayout.setBackgroundResource(R.color.pink);
                    }
                });

                cvBg1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        contentLayout.setBackgroundResource(R.drawable.bg1);
                    }
                });

                cvBg2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        contentLayout.setBackgroundResource(R.drawable.bg2);
                    }
                });
                cvBg3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        contentLayout.setBackgroundResource(R.drawable.bg3);
                    }
                });
                cvBg4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        contentLayout.setBackgroundResource(R.drawable.bg4);
                    }
                });
                cvBg5.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        contentLayout.setBackgroundResource(R.drawable.bg5);
                    }
                });

                font1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Typeface face = null;
                        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                            face = getResources().getFont(R.font.montserrat);
                        }
                        companyTextView.setTypeface(face);
                        fNameTextView.setTypeface(face);
                        designationTextView.setTypeface(face);
                    }
                });
                font2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Typeface face = null;
                        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                            face = getResources().getFont(R.font.kaushanscript);
                        }

                        companyTextView.setTypeface(face);
                        fNameTextView.setTypeface(face);
                        designationTextView.setTypeface(face);
                    }
                });

                font3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Typeface face = null;
                        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                            face = getResources().getFont(R.font.playpensans);
                        }

                        companyTextView.setTypeface(face);
                        fNameTextView.setTypeface(face);
                        designationTextView.setTypeface(face);
                    }
                });

                font4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Typeface face = null;
                        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                            face = getResources().getFont(R.font.robotoslab);
                        }

                        companyTextView.setTypeface(face);
                        fNameTextView.setTypeface(face);
                        designationTextView.setTypeface(face);
                    }
                });

                font5.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Typeface face = null;
                        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                            face = getResources().getFont(R.font.satisfy);
                        }
                        companyTextView.setTypeface(face);
                        fNameTextView.setTypeface(face);
                        designationTextView.setTypeface(face);
                    }
                });


            }
        });
    }

    private void initBinding() {
        fNameTextView = findViewById(R.id.textviewFullName);
        companyTextView = findViewById(R.id.textviewCompanyName);
        designationTextView = findViewById(R.id.textviewDesignationName);
        aboutTextView = findViewById(R.id.textviewAbout);
        companyTextView = findViewById(R.id.textviewCompanyName);
        contactTextView = findViewById(R.id.textviewContactNo);
        serviceTextView = findViewById(R.id.textViewService);
        addressTextView = findViewById(R.id.textviewAddress);
        emailTextView = findViewById(R.id.textviewEmailId);
        btnDownload = findViewById(R.id.fabDownload);
        btnEdit = findViewById(R.id.fab_Edit);
        cardLayout = findViewById(R.id.profileContainer);
        contentLayout = findViewById(R.id.contentLayout);
        btnCall = findViewById(R.id.cardViewCall);
        btnEmail = findViewById(R.id.cardViewEmail);
        btnLocation = findViewById(R.id.cardViewLocation);
        imageView = findViewById(R.id.imageview);
    }
}