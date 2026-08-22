package com.facebook.appevents.aam;

import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: classes.dex */
public final class MetadataRule {
    public static final CopyOnWriteArraySet rules = new CopyOnWriteArraySet();
    public final List keyRules;
    public final String name;
    public final String valRule;

    public MetadataRule(String str, String str2, List list) {
        this.name = str;
        this.valRule = str2;
        this.keyRules = list;
    }

    public static final /* synthetic */ CopyOnWriteArraySet access$getRules$cp() {
        if (CrashShieldHandler.isObjectCrashing(MetadataRule.class)) {
            return null;
        }
        try {
            return rules;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(MetadataRule.class, th);
            return null;
        }
    }

    public final String getName() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            return this.name;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(this, th);
            return null;
        }
    }
}
