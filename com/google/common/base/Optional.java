package com.google.common.base;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public abstract class Optional implements Serializable {
    private static final long serialVersionUID = 0;

    public abstract Object get();

    public abstract boolean isPresent();
}
