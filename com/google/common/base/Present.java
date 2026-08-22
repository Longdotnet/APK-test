package com.google.common.base;

import com.google.protobuf.Descriptors;

/* JADX INFO: loaded from: classes.dex */
public final class Present extends Optional {
    private static final long serialVersionUID = 0;
    public final Descriptors.Descriptor reference;

    public Present(Descriptors.Descriptor descriptor) {
        this.reference = descriptor;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof Present) {
            return this.reference.equals(((Present) obj).reference);
        }
        return false;
    }

    @Override // com.google.common.base.Optional
    public final Object get() {
        return this.reference;
    }

    public final int hashCode() {
        return this.reference.hashCode() + 1502476572;
    }

    @Override // com.google.common.base.Optional
    public final boolean isPresent() {
        return true;
    }

    public final String toString() {
        return "Optional.of(" + this.reference + ")";
    }
}
