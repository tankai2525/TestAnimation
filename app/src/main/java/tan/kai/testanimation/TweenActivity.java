package tan.kai.testanimation;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

/**
 * 补间动画
 * 1 alpha 渐变透明
 * 2 scale 缩放
 * 3 translate 位移
 * 4 rotate 旋转
 * Created by tankai on 2017/6/10.
 */

public class TweenActivity extends AppCompatActivity {

    private ImageView imageView;
    private Context mContext;
    private Animation animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tween);
        mContext = this;
        imageView = (ImageView)findViewById(R.id.img);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_alpha:
                animation = AnimationUtils.loadAnimation(mContext, R.anim.tween_alpha_anim);
                break;
            case R.id.btn_scale:
                break;
            case R.id.btn_translate:
                break;
            case R.id.btn_rotate:
                animation = AnimationUtils.loadAnimation(mContext, R.anim.tween_rotate_anim);
                break;
        }
        imageView.startAnimation(animation);
    }

}
