package com.google.android.gms.dynamite;

import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Random;
import okhttp3.internal.Util;

/* JADX INFO: loaded from: classes.dex */
public final class zzd extends ThreadLocal {
    public final /* synthetic */ int $r8$classId;

    @Override // java.lang.ThreadLocal
    public final Object initialValue() {
        switch (this.$r8$classId) {
            case 0:
                return 0L;
            case 1:
                return new Random();
            default:
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.US);
                simpleDateFormat.setLenient(false);
                simpleDateFormat.setTimeZone(Util.UTC);
                return simpleDateFormat;
        }
    }
}
