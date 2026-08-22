package com.daerisoft.thespikerm;

import android.app.Dialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;

/* JADX INFO: loaded from: classes.dex */
public abstract class RunnerSocial {
    public void Event(String str) {
    }

    public void GetInfo(String str) {
    }

    public void Init() {
        Log.i(GooglePlayBillingService.TAG, "Base extension class init called");
    }

    public void LoadFriends() {
    }

    public void LoadLeaderboard(String str, int i, int i2, int i3) {
    }

    public void LoadPic(String str) {
    }

    public void Login() {
    }

    public void Logout() {
    }

    public void PostScore(String str, int i) {
    }

    public void Show(int i, String str, int i2) {
    }

    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        return false;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return false;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
    }

    public void onConfigurationChanged(Configuration configuration) {
    }

    public Dialog onCreateDialog(int i) {
        return null;
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        return false;
    }

    public void onDestroy() {
    }

    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        return false;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return false;
    }

    public boolean onKeyLongPress(int i, KeyEvent keyEvent) {
        return false;
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        return false;
    }

    public void onNewIntent(Intent intent) {
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        return false;
    }

    public void onPause() {
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
    }

    public void onRestart() {
    }

    public void onResume() {
    }

    public void onStart() {
    }

    public void onStop() {
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    public void onWindowFocusChanged(boolean z) {
    }

    public boolean performClick() {
        return false;
    }
}
