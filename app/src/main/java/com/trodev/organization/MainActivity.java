package com.trodev.organization;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
public class MainActivity extends AppCompatActivity  {

    private static final int POS_CLOSE = 0 ;
    private static final int POS_DASHBOARD = 1 ;
    private static final int POS_MY_PROFILE = 2 ;
    private static final int POS_NEARBY_RES = 3 ;
    private static final int POS_SETTINGS = 4 ;
    private static final int POS_ABOUT_US = 5 ;
    private static final int POS_LOGOUT = 6 ;

    private String [] screenTitles;
    private Drawable[] screenIcons;

    private SlideingRootNav slideingRootNav;

    public MainActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}