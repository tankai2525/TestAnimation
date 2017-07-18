package tan.kai.testanimation;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

/**
 *  帧动画
 */
public class FrameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame);

        ImageView imageView = (ImageView) findViewById(R.id.img);
        imageView.setBackgroundResource(R.drawable.frame_animation);
        final AnimationDrawable frameAnimation = (AnimationDrawable) imageView.getBackground();
        imageView.post(new Runnable() {
            @Override
            public void run() {
                //兼容低版本
                frameAnimation.start();
            }
        });

    }

}
