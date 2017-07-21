package tan.kai.testanimation;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.Toast;

import static tan.kai.testanimation.R.id.img;

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
        imageView = (ImageView) findViewById(img);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_alpha:
                //animation = AnimationUtils.loadAnimation(mContext, R.anim.tween_alpha_anim);

                //代码实现
                AlphaAnimation alphaAnimation = new AlphaAnimation(0, 1);
                alphaAnimation.setDuration(3000);
                alphaAnimation.setRepeatCount(1);
                alphaAnimation.setRepeatMode(Animation.REVERSE);
                alphaAnimation.setFillAfter(true);
                animation = alphaAnimation;
                break;
            case R.id.btn_scale:
//                animation = AnimationUtils.loadAnimation(mContext, R.anim.tween_scale_anim);

                //代码实现
                //Animation.RELATIVE_TO_SELF 百分比
                ScaleAnimation scaleAnimation = new ScaleAnimation(1f, 2f, 1f, 2f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                scaleAnimation.setFillAfter(true);
                scaleAnimation.setDuration(3000);
                scaleAnimation.setRepeatMode(Animation.REVERSE);
                scaleAnimation.setRepeatCount(1);
                animation = scaleAnimation;
                break;
            case R.id.btn_translate:
//                animation = AnimationUtils.loadAnimation(mContext, R.anim.tween_tanslate_anim);

                //代码实现
                TranslateAnimation translateAnimation = new TranslateAnimation(0f, 100f, 0f, 100f);
                translateAnimation.setDuration(3000);
                animation = translateAnimation;
                break;
            case R.id.btn_rotate:
//                animation = AnimationUtils.loadAnimation(mContext, R.anim.tween_rotate_anim);

                //代码实现
                RotateAnimation rotateAnimation = new RotateAnimation(0f, 359f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                rotateAnimation.setFillAfter(true);
                rotateAnimation.setDuration(50);
                rotateAnimation.setRepeatCount(Animation.INFINITE);
                rotateAnimation.setInterpolator(new LinearInterpolator());//匀速不断旋转
//                rotateAnimation.setInterpolator(new AccelerateInterpolator());//加速 有停顿
                animation = rotateAnimation;
                break;
            case R.id.btn_set:
//                animation = AnimationUtils.loadAnimation(mContext, R.anim.tween_set_anim);

                //代码实现
                RotateAnimation ra = new RotateAnimation(0f, 360f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                ra.setDuration(3000);

                ScaleAnimation sa = new ScaleAnimation(0f, 1f, 0f, 1f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                sa.setDuration(3000);

                TranslateAnimation ts = new TranslateAnimation(0f, 100f, 0f, 0f);
                ts.setDuration(1000);
                ts.setStartOffset(3000);//3秒后执行

                AlphaAnimation ap = new AlphaAnimation(1.0f, 0f);
                ap.setDuration(3000);
                ap.setStartOffset(4000);//4秒后执行

                AnimationSet set = new AnimationSet(false);
                set.setFillAfter(true);
                set.addAnimation(ra);
                set.addAnimation(sa);
                set.addAnimation(ts);
                set.addAnimation(ap);
                animation = set;
                break;
            case R.id.img:
                Toast.makeText(mContext, "click", Toast.LENGTH_SHORT).show();
                break;
        }
        if(animation != null) {
            imageView.startAnimation(animation);
        }
    }

}
