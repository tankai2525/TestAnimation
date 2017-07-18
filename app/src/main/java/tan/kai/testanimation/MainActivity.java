package tan.kai.testanimation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * 动画
 * 分类 1 view动画，2 帧动画，3 属性动画
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button:
                to(TweenActivity.class);
                break;
            case R.id.button1:
                break;
            case R.id.button2:
                break;
        }
    }

    public void to(Class c) {
        Intent intent = new Intent(this, c);
        startActivity(intent);
    }
}
