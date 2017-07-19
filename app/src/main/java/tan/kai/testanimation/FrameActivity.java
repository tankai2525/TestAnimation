package tan.kai.testanimation;

import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

/**
 * 帧动画
 */
public class FrameActivity extends AppCompatActivity {

    private AnimationDrawable frameAnimation;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame);

        imageView = (ImageView) findViewById(R.id.img);

        initXml();//xml方式
//        initCode();//代码方式

        //启动,第一种方式
        imageView.post(new Runnable() {//兼容低版本2.3.3
            @Override
            public void run() {
                frameAnimation.start();
            }
        });
    }

    private void initXml() {
        //设置imageView的背景为帧动画资源文件
        imageView.setBackgroundResource(R.drawable.frame_animation);
        //拿到帧动画背景强转成AnimationDrawable
        frameAnimation = (AnimationDrawable) imageView.getBackground();
    }

    private void initCode() {
        frameAnimation = new AnimationDrawable();
        for (int i = 1; i < 6; i++) {
            //拿到资源图片id
            int id = getResources().getIdentifier("loading_newpic" + i, "mipmap", getPackageName());
            //根据id拿到Drawable
            Drawable drawable = ContextCompat.getDrawable(this, id);
            //添加一帧到帧动画
            frameAnimation.addFrame(drawable, 200);
        }
        //设置循环播放
        frameAnimation.setOneShot(false);
        if (Build.VERSION.SDK_INT >= 16) {
            imageView.setBackground(frameAnimation);
        } else {
            imageView.setBackgroundDrawable(frameAnimation);
        }
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        //启动,第二种方式
        //开启动画，默认循环播放
//        frameAnimation.start();
    }
}
