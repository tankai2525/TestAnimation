package tan.kai.testanimation;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * 属性动画
 * ValueAnimator : 计算动画过程中变化值
 * ObjectAnimator : 改变对象属性
 *
 */
public class PropertyActivity extends AppCompatActivity {

    private ImageView img;
    private PropertyActivity mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property);
        mContext = this;
        img = (ImageView) findViewById(R.id.img);
    }

    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.btn_value_animator:
                ValueAnimator valueAnimator = ValueAnimator.ofFloat(0, 100);
                valueAnimator.setDuration(1000);
                valueAnimator.start();
                valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        float value = (float) animation.getAnimatedValue();
                        Log.d("TAG", "value:" + value);
                        img.setTranslationX(value);
                    }
                });
                break;
            case R.id.btn_object_animator:
                final ObjectAnimator objectAnimator;
//                objectAnimator = ObjectAnimator.ofFloat(img, "rotation", 0, 360);//以垂直屏幕轴旋转
//                objectAnimator = ObjectAnimator.ofFloat(img, "alpha",0,1);//渐变
                objectAnimator = ObjectAnimator.ofFloat(img, "scaleX", 0, 1);//x方向缩放
                objectAnimator.setRepeatCount(1);
                objectAnimator.setDuration(1000);
                objectAnimator.addListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {
                        Log.d("tag", "onAnimationStart");
                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {
                        Log.d("tag", "onAnimationEnd");
                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {
                        Log.d("tag", "onAnimationCancel");
                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {
                        Log.d("tag", "onAnimationRepeat");
                    }
                });

                objectAnimator.start();

                //500毫秒停止动画，只是为了测试 onAnimationCancel 回调
//                new Handler().postDelayed(new Runnable() {
//                    @Override
//                    public void run() {
//                        objectAnimator.cancel();
//                    }
//                }, 500);

                break;

            case R.id.btn_set_animator:

//                ObjectAnimator objectAnimator1 = ObjectAnimator.ofFloat(img, "scaleX", 0, 1);
//                ObjectAnimator objectAnimator2 = ObjectAnimator.ofFloat(img, "scaleY", 0, 1);
//                ObjectAnimator objectAnimator3 = ObjectAnimator.ofFloat(img, "rotation", 0, 360);
//                ObjectAnimator objectAnimator4 = ObjectAnimator.ofFloat(img, "alpha", 0, 1);
//                ObjectAnimator objectAnimator5 = ObjectAnimator.ofFloat(img, "alpha", 1, 0);
//                AnimatorSet set = new AnimatorSet();
////                set.playTogether(objectAnimator1,objectAnimator2,objectAnimator3,objectAnimator4);//一起播放
//                set.play(objectAnimator1);
//                set.play(objectAnimator2);
//                set.play(objectAnimator3);//1,2,3一起播放
//                set.play(objectAnimator5).after(objectAnimator3);//3结束后播放5
//                set.play(objectAnimator4).after(objectAnimator5);//5结束后播放4
//                set.setDuration(1000);
//                set.start();


                //xml方式
                //1 在res/animator创建动画文件
                //2 载入动画资源文件
                //3 设置目标对象
                //4 启动
                Animator animator = AnimatorInflater.loadAnimator(mContext, R.animator.property_set_anim);
                animator.setTarget(img);
                animator.start();

                break;
            case R.id.img:
                String location = "left:" + img.getLeft() + " right:" + img.getRight() + " top:" + img.getTop() + " bottom:" + img.getBottom();
                Toast.makeText(this, "click:" + location, Toast.LENGTH_LONG).show();
                Log.d("tag", location);
                break;
        }
    }
}
