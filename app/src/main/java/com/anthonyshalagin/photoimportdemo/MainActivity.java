package com.anthonyshalagin.photoimportdemo;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import java.io.IOException;

import static android.R.attr.data;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Intent i = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
		startActivityForResult(i, 1);

	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {

		super.onActivityResult(requestCode, resultCode, data); //Called whenever we go to an external activity and then come back to our app

		if (requestCode == 1 && resultCode == RESULT_OK && data != null) {

			Uri selectedImage = data.getData();

			try {

				Bitmap bitmapImage = MediaStore.Images.Media.getBitmap(this.getContentResolver(), selectedImage);

				ImageView imageView = (ImageView) findViewById(R.id.imageView);
				imageView.setImageBitmap(bitmapImage);


			} catch (IOException e) {
				e.printStackTrace();
			}


		}

	}
}
