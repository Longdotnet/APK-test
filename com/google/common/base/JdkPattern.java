package com.google.common.base;

import java.io.Serializable;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public final class JdkPattern extends CommonPattern implements Serializable {
    private static final long serialVersionUID = 0;
    public final Pattern pattern;

    public JdkPattern(Pattern pattern) {
        pattern.getClass();
        this.pattern = pattern;
    }

    public final String toString() {
        return this.pattern.toString();
    }
}
