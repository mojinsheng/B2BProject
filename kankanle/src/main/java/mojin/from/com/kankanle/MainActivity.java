package mojin.from.com.kankanle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import mojin.from.com.kankanle.view.BaseView;

public class MainActivity extends AppCompatActivity {


    BaseView baseView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        baseView=(BaseView)findViewById(R.id.id_guaguaka);
//        baseView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            }
//        });
        baseView.setmLister(new BaseView.OnGuaGuaKaCompleteLister() {
            @Override
            public void complete() {
                Toast.makeText(MainActivity.this,"已经完成",Toast.LENGTH_LONG).show();
            }
        });
    }
}
