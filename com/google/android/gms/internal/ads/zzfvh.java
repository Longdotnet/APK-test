package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Iterator;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class zzfvh {
    public static final CharSequence zza(Object obj) {
        Objects.requireNonNull(obj);
        return obj instanceof CharSequence ? (CharSequence) obj : obj.toString();
    }

    public static final StringBuilder zzb(StringBuilder sb, Iterable iterable, String str) {
        zzc(sb, iterable.iterator(), str);
        return sb;
    }

    public static final StringBuilder zzc(StringBuilder sb, Iterator it, String str) {
        try {
            if (it.hasNext()) {
                sb.append(zza(it.next()));
                while (it.hasNext()) {
                    sb.append((CharSequence) str);
                    sb.append(zza(it.next()));
                }
            }
            return sb;
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }
}
