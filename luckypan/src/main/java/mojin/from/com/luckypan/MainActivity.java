package mojin.from.com.luckypan;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private LuckyPan mLuckyPan;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mLuckyPan=(LuckyPan)findViewById(R.id.luckypan);
        imageView=(ImageView)findViewById(R.id.startpan);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!mLuckyPan.isStart()){
                    mLuckyPan.lackyStart(5);
                    imageView.setImageResource(R.drawable.node);
                }else{
                    if(!mLuckyPan.isShouldEnd()){
                        mLuckyPan.luckyEnd();
                        imageView.setImageResource(R.drawable.node);
                    }
                }
            }
        });

    }
}
