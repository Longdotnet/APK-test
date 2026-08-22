package com.facebook.login;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public enum LoginBehavior {
    /* JADX INFO: Fake field, exist only in values array */
    NATIVE_WITH_FALLBACK(true, true, true, false, true, true),
    /* JADX INFO: Fake field, exist only in values array */
    NATIVE_ONLY(true, true, false, false, false, true),
    /* JADX INFO: Fake field, exist only in values array */
    KATANA_ONLY(false, true, false, false, false, false),
    /* JADX INFO: Fake field, exist only in values array */
    WEB_ONLY(false, false, true, false, true, false),
    /* JADX INFO: Fake field, exist only in values array */
    DIALOG_ONLY(false, true, true, false, true, true),
    /* JADX INFO: Fake field, exist only in values array */
    DEVICE_AUTH(false, false, false, true, false, false);

    public final boolean allowsCustomTabAuth;
    public final boolean allowsDeviceAuth;
    public final boolean allowsGetTokenAuth;
    public final boolean allowsInstagramAppAuth;
    public final boolean allowsKatanaAuth;
    public final boolean allowsWebViewAuth;

    LoginBehavior(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
        this.allowsGetTokenAuth = z;
        this.allowsKatanaAuth = z2;
        this.allowsWebViewAuth = z3;
        this.allowsDeviceAuth = z4;
        this.allowsCustomTabAuth = z5;
        this.allowsInstagramAppAuth = z6;
    }

    /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
    public static LoginBehavior[] valuesCustom() {
        return (LoginBehavior[]) Arrays.copyOf(values(), 6);
    }
}
