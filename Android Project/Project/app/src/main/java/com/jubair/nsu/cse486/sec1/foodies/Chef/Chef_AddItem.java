package com.jubair.nsu.cse486.sec1.foodies.Chef;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.session.MediaSession;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.PermissionRequest;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.auth.Token;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.jubair.nsu.cse486.sec1.foodies.R;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.single.PermissionListener;


import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Chef_AddItem extends AppCompatActivity {

    RadioGroup radioGroup;
    RadioButton radioButton;
    EditText name,description, price ;
    FirebaseAuth mFirebaseAuth;
    FirebaseFirestore db;
    ProgressDialog pd;
    Uri filepath;
    Bitmap bitmap;
    ImageView img;
    String chefID;
    String foodID;
    String imageID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chef_add_item);

        //actionbar and its title
//        ActionBar actionBar = getSupportActionBar();
//        actionBar.setTitle("Add Data");

        mFirebaseAuth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();
        pd = new ProgressDialog(this);

        name = findViewById(R.id.editTextTextPersonName3);
        description = findViewById(R.id.editTextTextMultiLine);
        price = findViewById(R.id.editTextTextPersonName9);
        radioGroup = findViewById(R.id.radioGroup2);
        img=(ImageView)findViewById(R.id.imageView5);


    }

    public void addConfirm(View v) {

        int radioId = radioGroup.getCheckedRadioButtonId();
        radioButton = findViewById(radioId);

        String category = radioButton.getText().toString();
        String foodName = name.getText().toString();
        String foodDescription = description.getText().toString();
        String foodPrice = price.getText().toString();
    //    String image = filepath.toString();

/*
        if(!(radioGroup.getCheckedRadioButtonId())){
            name.setError("Please enter food name");
            name.requestFocus();
        }
*/

        if(foodName.isEmpty()){
            name.setError("Please enter food name");
            name.requestFocus();
        }
        else if(foodDescription.isEmpty()){
            description.setError("Please write description about the food");
            description.requestFocus();
        }
        else if(foodPrice.isEmpty()){
            price.setError("Please enter the price");
            price.requestFocus();
        }

        else if(!(foodName.isEmpty() && foodDescription.isEmpty() && foodPrice.isEmpty())){

            //Set title of progress bar
            pd.setTitle("Adding your food item...");
            //Show progress bar when user click confirm button
            pd.show();

            chefID = mFirebaseAuth.getCurrentUser().getEmail() ;
            foodID = UUID.randomUUID().toString();
            imageID= UUID.randomUUID().toString();

            FirebaseStorage storage=FirebaseStorage.getInstance();
            StorageReference uploader=storage.getReference().child(imageID+".jpg");
            uploader.putFile(filepath).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    pd.dismiss();
                }
            });

            DocumentReference documentReference = db.collection("Chef_Item").document("1").collection(chefID).document()  ;

            Map<String,Object> item = new HashMap<>();
            item.put("Name", foodName );
            item.put("Description", foodDescription );
            item.put("Price", foodPrice );
            item.put("Category", category );
            item.put("ImageUri", filepath.toString());

            //add data
            documentReference.set(item).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    // this will be called when data is added successfully
                    pd.dismiss();
                    Toast.makeText(Chef_AddItem.this,"Posted Successfully",Toast.LENGTH_SHORT).show();

                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    // this will be called if there is error while uploading
                    Toast.makeText(Chef_AddItem.this, e.getMessage() ,Toast.LENGTH_SHORT).show();
                }
            });
        }
        else{
            Toast.makeText(Chef_AddItem.this,"Error Occurred!",Toast.LENGTH_SHORT).show();
        }
    }


    public void browseImage(View v){

        Dexter.withActivity(Chef_AddItem.this)
                .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                .withListener(new PermissionListener() {
                    @Override
                    public void onPermissionGranted(PermissionGrantedResponse response) {
                        Intent intent=new Intent(Intent.ACTION_PICK);
                        intent.setType("image/*");
                        startActivityForResult(Intent.createChooser(intent,"Please select Image"),1);
                    }

                    @Override
                    public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {

                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(com.karumi.dexter.listener.PermissionRequest permission, PermissionToken token) {
                        token.continuePermissionRequest();
                    }
                }).check();
    }




    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data)
    {
        if(requestCode==1 && resultCode==RESULT_OK)
        {
            filepath=data.getData();
            try
            {
                InputStream inputStream=getContentResolver().openInputStream(filepath);
                bitmap= BitmapFactory.decodeStream(inputStream);
                img.setImageBitmap(bitmap);
            }catch (Exception ex)
            {

            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }



    public void GoBack(View v) {
        startActivity(new Intent(this, Chef_Kitchen.class));
    }


}