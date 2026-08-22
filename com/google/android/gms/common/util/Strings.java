package com.google.android.gms.common.util;

import android.text.TextUtils;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public abstract class Strings {
    public static final /* synthetic */ int $r8$clinit = 0;

    static {
        Pattern.compile("\\$\\{(.*?)\\}");
    }

    public static String emptyToNull(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return str;
    }
}
