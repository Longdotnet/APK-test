package com.facebook.login;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public enum LoginTargetApp {
    FACEBOOK("facebook"),
    INSTAGRAM("instagram");

    public final String targetApp;

    LoginTargetApp(String str) {
        this.targetApp = str;
    }

    /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
    public static LoginTargetApp[] valuesCustom() {
        return (LoginTargetApp[]) Arrays.copyOf(values(), 2);
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.targetApp;
    }
}
