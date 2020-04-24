package com.lec.android.a023_camera;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    String [] permissions  = {Manifest.permission.CAMERA,
    Manifest.permission.WRITE_EXTERNAL_STORAGE,
    Manifest.permission.READ_EXTERNAL_STORAGE};

    final int REQUEST_CODE = 101;

    ImageView imageView;
    File file;//촬영한 이미지 파일


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //권한 획득
        if(Build.VERSION.SDK_INT >= 23){
            if(checkSelfPermission(String.valueOf(permissions)) == PackageManager.PERMISSION_DENIED){
                requestPermissions(permissions, REQUEST_CODE); //권한 요청하기
            }
        }

        imageView = findViewById(R.id.imageView);
        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //촬영
                takePicture();
            }
        });

    }//end onCreate()

    //사진촬영
    //캡쳐한 이미지 데이터 -->  data

    public void takePicture(){
        if(file == null){
            file = createFile();
        }
        //위 File 객체로부터 Uri 객체 만들기
        Uri fileUri = FileProvider.getUriForFile(this,
                "org.techtown.capture.intent.fileprovider",
                file);
            //사진 촬영 앱 가동(묵시적 인텐트)
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri);

        //위 액티비티가 가용한지 여부 체크한뒤.
        if(intent.resolveActivity(getPackageManager()) != null){
            startActivityForResult(intent, 101); //사진 앱 촬영 앱!
        }

    }

    private File createFile(){
        String fileName = "capture.jpg";
        File storageDir = Environment.getExternalStorageDirectory();
        File outFile = new File (storageDir, fileName);
        return outFile;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        //사진 촬영 앱의 사진 결과를 받아오게 되면 수행
        if(requestCode == 101 && resultCode == RESULT_OK){
            //저장된 사진 이미지 파일을 --> BitMap 객체 --> ImageView에 띄우기
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inSampleSize = 8; //좀 작은 사이즈로  resample 을 위한 samplesize
            Bitmap bitmap = BitmapFactory.decodeFile(file.getAbsolutePath(), options);
            imageView.setImageBitmap(bitmap); //ImageView 에 세팅

        }


    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch(requestCode){
            case REQUEST_CODE:
                if(grantResults.length <= 0){
                    Toast.makeText(this, "권한 획득 실패",Toast.LENGTH_SHORT).show();

                    //onDestroy() 혹은 finish()
                    return;
                }
                String result = "";
                for(int i = 0; i<grantResults.length; i++){
                    if(grantResults[i] == PackageManager.PERMISSION_GRANTED){
                        result += "권한 획득 성공: " + permissions[i] + "\n";
                    }else {
                        result += "권한 획득 실패" + permissions[i] + "\n";
                    }
                }
                Toast.makeText(this, result, Toast.LENGTH_LONG).show();
                Log.d("myapp",result);
                break;
        }

    }
}
