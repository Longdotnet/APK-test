package com.google.common.base;

/* JADX INFO: loaded from: classes.dex */
public final class Absent extends Optional {
    public static final Absent INSTANCE = new Absent();
    private static final long serialVersionUID = 0;

    private Object readResolve() {
        return INSTANCE;
    }

    public final boolean equals(Object obj) {
        return obj == this;
    }

    @Override // com.google.common.base.Optional
    public final Object get() {
        throw new IllegalStateException("Optional.get() cannot be called on an absent value");
    }

    public final int hashCode() {
        return 2040732332;
    }

    @Override // com.google.common.base.Optional
    public final boolean isPresent() {
        return false;
    }

    public final String toString() {
        return "Optional.absent()";
    }
}
