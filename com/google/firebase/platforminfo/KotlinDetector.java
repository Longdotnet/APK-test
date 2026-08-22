package com.google.firebase.platforminfo;

import kotlin.KotlinVersion;

/* JADX INFO: loaded from: classes.dex */
public final class KotlinDetector {
    private KotlinDetector() {
    }

    public static String detectVersion() {
        try {
            KotlinVersion.CURRENT.getClass();
            return "1.8.22";
        } catch (NoClassDefFoundError unused) {
            return null;
        }
    }
}
