package com.example.tongxiwen.collection;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.example.tongxiwen.collection.base.FoxActivity;
import com.example.tongxiwen.collection.views.ImagePickerBottomSheetDialog;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends FoxActivity {

    private ImagePickerBottomSheetDialog dialog;

    @Override
    protected int onInflateLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void create(Bundle savedInstanceState) {
        dialog = ImagePickerBottomSheetDialog.get(MainActivity.this);
        findViewById(R.id.button_field).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.show();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        File file = dialog.onResult(requestCode, resultCode, data);
        ImageView view = findViewById(R.id.image_field);
        if (file != null)
            view.setImageURI(Uri.fromFile(file));
    }
}