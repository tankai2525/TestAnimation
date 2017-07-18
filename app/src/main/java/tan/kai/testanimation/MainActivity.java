package tan.kai.testanimation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * 动画
 * 3.0之前：1 补间动画 Tween Animation、2 逐帧动画 Frame Animation（也称Drawable Animation ）
 * 3.0之后：3 属性动画 Property Animation
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_tween:
                to(TweenActivity.class);
                break;
            case R.id.btn_frame:
                to(FrameActivity.class);
                break;
            case R.id.btn_property:
                break;
        }
    }

    public void to(Class c) {
        Intent intent = new Intent(this, c);
        startActivity(intent);
    }
}
