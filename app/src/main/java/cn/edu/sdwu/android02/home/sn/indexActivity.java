package cn.edu.sdwu.android02.home.sn;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class indexActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_index);
    }
    public void homework1(View view) {
        Intent intent = new Intent(this, Homework1Activity.class);
        startActivity(intent);
    }
//    public void homework2(View view) {
//        Intent intent = new Intent(this, Homework2Activity.class);
//        startActivity(intent);
//    }
//    public void homework3(View view) {
//        Intent intent = new Intent(this, Homework3Activity.class);
//        startActivity(intent);
//    }
//    public void homework4(View view) {
//        Intent intent = new Intent(this, Homework4Activity.class);
//        startActivity(intent);
//    }
//    public void homework5(View view) {
//        Intent intent = new Intent(this, Homework5Activity.class);
//        startActivity(intent);
//    }
}
