package com.google.protobuf.util;

import com.google.protobuf.DescriptorProtos;

/* JADX INFO: loaded from: classes3.dex */
public final class ProtoFileUtil {
    private ProtoFileUtil() {
    }

    public static String getEditionString(DescriptorProtos.Edition edition) {
        return edition.toString().substring(8);
    }
}
