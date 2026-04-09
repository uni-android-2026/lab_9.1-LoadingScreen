package org.michael.icon;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {
    private static final long SPLASH_DURATION_MS = 3000L;

    private final Handler handler = new Handler(Looper.getMainLooper());
    private final Runnable openMainScreen = () -> {
        Intent intent = new Intent(SplashActivity.this, MainActivity.class);
        intent.putExtra(MainActivity.EXTRA_SKIP_SPLASH, true);
        startActivity(intent);
        finish();
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashscreen);

        ImageView robotImage = findViewById(R.id.robotImage);
        Animation fadeInAnimation = AnimationUtils.loadAnimation(this, R.anim.fadein);
        robotImage.startAnimation(fadeInAnimation);

        handler.postDelayed(openMainScreen, SPLASH_DURATION_MS);
    }

    @Override
    protected void onDestroy() {
        handler.removeCallbacks(openMainScreen);
        super.onDestroy();
    }
}
