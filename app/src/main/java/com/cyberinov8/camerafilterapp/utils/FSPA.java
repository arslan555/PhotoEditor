package com.cyberinov8.camerafilterapp.utils;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.cyberinov8.camerafilterapp.SignInFragment;
import com.cyberinov8.camerafilterapp.SignUpFragment;


/**
 * Created by M.Arslan on 27/11/2018.
 */

public class FSPA extends FragmentStatePagerAdapter {
    private int count;

    public FSPA(FragmentManager fragmentManager, int count) {
        super(fragmentManager);
        this.count = count;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0: {
                SignInFragment fragment1 = new SignInFragment();
                return fragment1;
            }
            case 1: {
                SignUpFragment fragment2 = new SignUpFragment();
                return fragment2;
            }
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return count;
    }
}