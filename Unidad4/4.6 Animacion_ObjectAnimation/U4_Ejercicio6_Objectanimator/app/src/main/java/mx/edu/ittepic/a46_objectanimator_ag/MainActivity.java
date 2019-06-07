package mx.edu.ittepic.a46_objectanimator_ag;

import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.BounceInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private RelativeLayout canvas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.faceIcon);
        canvas = findViewById(R.id.animationCanvas);
    }
    public void onButtonClick(View v) {

        int screenHeight = canvas.getHeight();
        int targetY = screenHeight - imageView.getHeight();

        ObjectAnimator animator = ObjectAnimator.ofFloat(
                imageView, "y", (canvas.getHeight()-150), 1)
                .setDuration(4000);

        animator.setInterpolator(new AccelerateDecelerateInterpolator());
        animator.start();

        //animator.setInterpolator(new BounceInterpolator());
        //animator.setInterpolator(new CycleInterpolator(3));
        //animator.start();

        //animator.start();
    }
    public void onButton1Click(View v){
        ObjectAnimator animator = ObjectAnimator.ofFloat(
                imageView, "y", (canvas.getHeight()-150), 1)
                .setDuration(4000);
        animator.setInterpolator(new BounceInterpolator());
        animator.start();
    }
    public void onButton2Click(View v){
        ObjectAnimator animator = ObjectAnimator.ofFloat(
                imageView, "y", (canvas.getHeight()-150), 1)
                .setDuration(4000);
        animator.setInterpolator(new AnticipateOvershootInterpolator(2));
        animator.start();
    }
}
