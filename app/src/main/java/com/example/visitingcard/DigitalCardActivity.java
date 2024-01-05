package com.example.visitingcard;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.PickVisualMediaRequest;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.net.URI;

import de.hdodenhof.circleimageview.CircleImageView;

public class DigitalCardActivity extends AppCompatActivity {

    ActivityResultLauncher<PickVisualMediaRequest> pickMedia;
    CircleImageView imageView;
    ImageButton imageButton;
    TextInputLayout fNameLayout;
    TextInputEditText fNameEditText;
    TextInputLayout designationLayout;
    TextInputEditText designationEditText;
    TextInputLayout companyLayout;
    TextInputEditText companyEditText;
    TextInputLayout aboutLayout;
    TextInputEditText aboutEditText;
    TextInputLayout contactLayout;
    TextInputEditText contactEditText;
    TextInputLayout emailLayout;
    TextInputEditText emailEditText;
    TextInputLayout addressLayout;
    TextInputEditText addressEditText;
    TextInputLayout serviceLayout;
    TextInputEditText serviceEditText;

    Button btnNext;
    Uri imageUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_digital_card);
        initBinding();
        pickMedia = registerForActivityResult(new ActivityResultContracts.PickVisualMedia(), uri -> {
            if (uri != null) {
                imageView.setImageURI(uri);
                imageUri=uri;
                Log.d("PhotoPicker", "Selected URI: " + uri);
            } else {
                Log.d("PhotoPicker", "No media selected");
            }
        });

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pickMedia.launch(new PickVisualMediaRequest.Builder().setMediaType(ActivityResultContracts.PickVisualMedia.ImageOnly.INSTANCE).build());
            }
        });


        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String fName = fNameEditText.getText().toString();
                String designation = designationEditText.getText().toString();
                String company = companyEditText.getText().toString();
                String aboutMe = aboutEditText.getText().toString();
                String contact = contactEditText.getText().toString();
                String email = emailEditText.getText().toString();
                String address = addressEditText.getText().toString();
                String service = serviceEditText.getText().toString();

                if (TextUtils.isEmpty(fName)) {
                    fNameEditText.setError("Enter Full Name");
                } else if (TextUtils.isEmpty(designation)) {
                    designationEditText.setError("Enter Designation");
                } else if (TextUtils.isEmpty(company)) {
                    designationEditText.setError("Enter Company");
                } else if (TextUtils.isEmpty(aboutMe)) {
                    designationEditText.setError("Enter something about you");
                } else if (TextUtils.isEmpty(contact)) {
                    designationEditText.setError("Enter contact no.");
                } else if (TextUtils.isEmpty(email)) {
                    designationEditText.setError("Enter email");
                } else if (TextUtils.isEmpty(address)) {
                    designationEditText.setError("Enter address");
                } else if (TextUtils.isEmpty(service)) {
                    designationEditText.setError("Enter service");
                } else {
                    Intent intent = new Intent(DigitalCardActivity.this, VisitingCardActivity.class);
                    intent.putExtra("fName", fName);
                    intent.putExtra("designation", designation);
                    intent.putExtra("company", company);
                    intent.putExtra("about", aboutMe);
                    intent.putExtra("contact", contact);
                    intent.putExtra("email", email);
                    intent.putExtra("address", address);
                    intent.putExtra("service", service);
                    intent.putExtra("imageView",imageUri.toString());

                    startActivity(intent);
                }

//                Intent intent = new Intent(DigitalCardActivity.this, VisitingCardActivity.class);
//                startActivity(intent);

            }
        });
    }


    void initBinding() {
        imageView = findViewById(R.id.imageview);
        imageButton = findViewById(R.id.pickImageBtn);
        fNameEditText = findViewById(R.id.editTextPersonalInfo);
        designationEditText = findViewById(R.id.editTextDesignation);
        companyEditText = findViewById(R.id.editTextCompany);
        aboutEditText = findViewById(R.id.editTextAboutMe);
        contactEditText = findViewById(R.id.editTextContactNo);
        emailEditText = findViewById(R.id.editTextEmail);
        addressEditText = findViewById(R.id.editTextAddress);
        serviceEditText = findViewById(R.id.editTextServices);
        btnNext = findViewById(R.id.btnNext);

    }

    public void next(View view) {

    }
}