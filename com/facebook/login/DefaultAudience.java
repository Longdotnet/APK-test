package com.facebook.login;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public enum DefaultAudience {
    NONE(null),
    /* JADX INFO: Fake field, exist only in values array */
    ONLY_ME("only_me"),
    /* JADX INFO: Fake field, exist only in values array */
    FRIENDS("friends"),
    /* JADX INFO: Fake field, exist only in values array */
    EVERYONE("everyone");

    public final String nativeProtocolAudience;

    DefaultAudience(String str) {
        this.nativeProtocolAudience = str;
    }

    /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
    public static DefaultAudience[] valuesCustom() {
        return (DefaultAudience[]) Arrays.copyOf(values(), 4);
    }
}
