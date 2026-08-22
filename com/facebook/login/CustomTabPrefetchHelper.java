package com.facebook.login;

import androidx.browser.customtabs.CustomTabsServiceConnection;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes.dex */
public abstract class CustomTabPrefetchHelper extends CustomTabsServiceConnection {
    public static final ReentrantLock lock = new ReentrantLock();
}
