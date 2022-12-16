package com.trodev.organization;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private Button go_notification_activity;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle toggle;
    private NavigationView navigationView;
    private CardView member, video_call, notice,  calls, motives, location,sms,gallery,profile ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        member = findViewById(R.id.members);
        video_call = findViewById(R.id.video_call);
        notice = findViewById(R.id.notice);
        calls = findViewById(R.id.calls);
        motives = findViewById(R.id.motives);
        location = findViewById(R.id.location);
        sms = findViewById(R.id.sms);
        gallery = findViewById(R.id.gallery);
        profile = findViewById(R.id.profile);
        drawerLayout = findViewById(R.id.drawerlayout);
        navigationView = findViewById(R.id.navigation_view);

        // #######################
        // Drawer Layout implement
        toggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.start, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        // #################################################################
        // eikhane eituku hocche amader navigation layout er kaj korar jonno.
        navigationView.setNavigationItemSelectedListener(this::onOptionsItemSelected);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);


        // #####################################
        // Clicking activity
        // #####################################
        member.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog_jakat();
            }
        });

        video_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog_jakat();
            }
        });

        notice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog_jakat();
            }
        });

        calls.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog_jakat();
            }
        });

        motives.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog_jakat();
            }
        });

        location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog_jakat();
            }
        });


        sms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog_jakat();
            }
        });

        gallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog_jakat();
            }
        });

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog_jakat();
            }
        });

    }


    // ##################################
    // Bottomsheet label working process
    private void showDialog_jakat() {
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.update_bottomsheet_layout);


        dialog.show();
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        dialog.getWindow().setGravity(Gravity.BOTTOM);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (toggle.onOptionsItemSelected(item)) {
            return true;
        }

        switch (item.getItemId()) {
/*           case R.id.nav_donation:
               Toast.makeText(this, "শীগ্রহি আসবে!", Toast.LENGTH_SHORT).show();
              break;*/
            case R.id.nav_notification_notice:
                Toast.makeText(this, "নোটিফিকেশান!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_dev:
                final Dialog dialog = new Dialog(this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.developer_bottomsheet_layout);

                dialog.show();
                dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
                dialog.getWindow().setGravity(Gravity.BOTTOM);
                Toast.makeText(this, "ডেভেলপার পরিচয়!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_policy:
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.app-privacy-policy.com/live.php?token=qB3iS10fUJmr6yEFtaVo9yve0uuPP3Ok")));
                Toast.makeText(this, "প্রাইভেসি পলিসি!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_share:
                try {
                    Intent shareIntent = new Intent(Intent.ACTION_SEND);
                    shareIntent.setType("text/plain");
                    shareIntent.putExtra(Intent.EXTRA_SUBJECT, "The Holy Quran -Islamic App");
                    String shareMessage = "\nThe Holy Quran -Islamic App অ্যাপটি ডাউনলোড করুন\n\n";
                    shareMessage = shareMessage + "https://play.google.com/store/apps/details?id=" + BuildConfig.APPLICATION_ID + "\n\n";
                    shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage);
                    startActivity(Intent.createChooser(shareIntent, "choose one"));
                    Toast.makeText(this, "শেয়ার করুন!", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    //e.toString();
                }

                break;
            case R.id.nav_rate:
                try {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + getPackageName())));
                    Toast.makeText(this, "রেটিং দিন!", Toast.LENGTH_SHORT).show();
                } catch (ActivityNotFoundException e) {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + getPackageName())));
                }
                break;

        }
        return super.onOptionsItemSelected(item);
    }
}
