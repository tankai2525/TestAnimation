package tan.kai.testanimation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * 补间动画
 * Created by tankai on 2017/6/10.
 */

public class TweenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tween);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_tween:
                break;
            case R.id.btn_frame:
                break;
            case R.id.btn_property:
                break;
        }
    }

}
