package com.google.protobuf.util;

import com.facebook.AccessTokenCache;
import com.google.common.base.Absent;
import com.google.common.base.CaseFormat;
import com.google.common.base.CharMatcher;
import com.google.common.base.Joiner;
import com.google.common.base.Optional;
import com.google.common.base.Present;
import com.google.common.base.Splitter;
import com.google.common.base.Splitter$1$1;
import com.google.common.primitives.Ints$IntArrayAsList;
import com.google.protobuf.Descriptors;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Internal;
import com.google.protobuf.Message;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public final class FieldMaskUtil {
    private static final String FIELD_PATH_SEPARATOR = ",";
    private static final String FIELD_PATH_SEPARATOR_REGEX = ",";
    private static final String FIELD_SEPARATOR_REGEX = "\\.";

    public static final class MergeOptions {
        private boolean replaceMessageFields = false;
        private boolean replaceRepeatedFields = false;
        private boolean replacePrimitiveFields = false;

        public boolean replaceMessageFields() {
            return this.replaceMessageFields;
        }

        public boolean replacePrimitiveFields() {
            return this.replacePrimitiveFields;
        }

        public boolean replaceRepeatedFields() {
            return this.replaceRepeatedFields;
        }

        public MergeOptions setReplaceMessageFields(boolean z) {
            this.replaceMessageFields = z;
            return this;
        }

        public MergeOptions setReplacePrimitiveFields(boolean z) {
            this.replacePrimitiveFields = z;
            return this;
        }

        public MergeOptions setReplaceRepeatedFields(boolean z) {
            this.replaceRepeatedFields = z;
            return this;
        }
    }

    private FieldMaskUtil() {
    }

    public static FieldMask fromFieldNumbers(Class<? extends Message> cls, Iterable<Integer> iterable) {
        Descriptors.Descriptor descriptorForType = ((Message) Internal.getDefaultInstance(cls)).getDescriptorForType();
        FieldMask.Builder builderNewBuilder = FieldMask.newBuilder();
        for (Integer num : iterable) {
            Descriptors.FieldDescriptor fieldDescriptorFindFieldByNumber = descriptorForType.findFieldByNumber(num.intValue());
            String str = num + " is not a valid field number for " + cls + ".";
            if (!(fieldDescriptorFindFieldByNumber != null)) {
                throw new IllegalArgumentException(str);
            }
            builderNewBuilder.addPaths(fieldDescriptorFindFieldByNumber.getName());
        }
        return builderNewBuilder.build();
    }

    public static FieldMask fromJsonString(String str) {
        Splitter splitter = new Splitter(new AccessTokenCache(new CharMatcher.Is(",".charAt(0), 0), 28));
        str.getClass();
        FieldMask.Builder builderNewBuilder = FieldMask.newBuilder();
        Iterator it = ((Splitter.Strategy) splitter.strategy).iterator(splitter, str);
        while (true) {
            Splitter$1$1 splitter$1$1 = (Splitter$1$1) it;
            if (!splitter$1$1.hasNext()) {
                return builderNewBuilder.build();
            }
            String strConvert = (String) splitter$1$1.next();
            if (!strConvert.isEmpty()) {
                CaseFormat.AnonymousClass3 anonymousClass3 = CaseFormat.LOWER_CAMEL;
                CaseFormat.AnonymousClass2 anonymousClass2 = CaseFormat.LOWER_UNDERSCORE;
                anonymousClass3.getClass();
                if (anonymousClass2 != anonymousClass3) {
                    strConvert = anonymousClass3.convert(anonymousClass2, strConvert);
                }
                builderNewBuilder.addPaths(strConvert);
            }
        }
    }

    public static FieldMask fromString(String str) {
        return fromStringList(Arrays.asList(str.split(",")));
    }

    public static FieldMask fromStringList(Class<? extends Message> cls, Iterable<String> iterable) {
        return fromStringList(((Message) Internal.getDefaultInstance(cls)).getDescriptorForType(), iterable);
    }

    public static FieldMask intersection(FieldMask fieldMask, FieldMask fieldMask2) {
        FieldMaskTree fieldMaskTree = new FieldMaskTree(fieldMask);
        FieldMaskTree fieldMaskTree2 = new FieldMaskTree();
        Iterator<String> it = fieldMask2.getPathsList().iterator();
        while (it.hasNext()) {
            fieldMaskTree.intersectFieldPath(it.next(), fieldMaskTree2);
        }
        return fieldMaskTree2.toFieldMask();
    }

    public static boolean isValid(Class<? extends Message> cls, FieldMask fieldMask) {
        return isValid(((Message) Internal.getDefaultInstance(cls)).getDescriptorForType(), fieldMask);
    }

    public static void merge(FieldMask fieldMask, Message message, Message.Builder builder, MergeOptions mergeOptions) {
        new FieldMaskTree(fieldMask).merge(message, builder, mergeOptions);
    }

    public static FieldMask normalize(FieldMask fieldMask) {
        return new FieldMaskTree(fieldMask).toFieldMask();
    }

    public static FieldMask subtract(FieldMask fieldMask, FieldMask fieldMask2, FieldMask... fieldMaskArr) {
        FieldMaskTree fieldMaskTreeRemoveFromFieldMask = new FieldMaskTree(fieldMask).removeFromFieldMask(fieldMask2);
        for (FieldMask fieldMask3 : fieldMaskArr) {
            fieldMaskTreeRemoveFromFieldMask.removeFromFieldMask(fieldMask3);
        }
        return fieldMaskTreeRemoveFromFieldMask.toFieldMask();
    }

    public static String toJsonString(FieldMask fieldMask) {
        ArrayList arrayList = new ArrayList(fieldMask.getPathsCount());
        for (String strConvert : fieldMask.getPathsList()) {
            if (!strConvert.isEmpty()) {
                CaseFormat.AnonymousClass2 anonymousClass2 = CaseFormat.LOWER_UNDERSCORE;
                CaseFormat.AnonymousClass3 anonymousClass3 = CaseFormat.LOWER_CAMEL;
                anonymousClass3.getClass();
                if (anonymousClass3 != anonymousClass2) {
                    strConvert = anonymousClass2.convert(anonymousClass3, strConvert);
                }
                arrayList.add(strConvert);
            }
        }
        Joiner joiner = new Joiner();
        joiner.separator = ",";
        Iterator it = arrayList.iterator();
        StringBuilder sb = new StringBuilder();
        try {
            if (it.hasNext()) {
                Object next = it.next();
                Objects.requireNonNull(next);
                sb.append(next instanceof CharSequence ? (CharSequence) next : next.toString());
                while (it.hasNext()) {
                    sb.append((CharSequence) joiner.separator);
                    Object next2 = it.next();
                    Objects.requireNonNull(next2);
                    sb.append(next2 instanceof CharSequence ? (CharSequence) next2 : next2.toString());
                }
            }
            return sb.toString();
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }

    public static String toString(FieldMask fieldMask) {
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (String str : fieldMask.getPathsList()) {
            if (!str.isEmpty()) {
                if (z) {
                    z = false;
                } else {
                    sb.append(",");
                }
                sb.append(str);
            }
        }
        return sb.toString();
    }

    public static <P extends Message> P trim(FieldMask fieldMask, P p) {
        Message.Builder builderNewBuilderForType = p.newBuilderForType();
        merge(fieldMask, p, builderNewBuilderForType);
        return (P) builderNewBuilderForType.build();
    }

    public static FieldMask union(FieldMask fieldMask, FieldMask fieldMask2, FieldMask... fieldMaskArr) {
        FieldMaskTree fieldMaskTreeMergeFromFieldMask = new FieldMaskTree(fieldMask).mergeFromFieldMask(fieldMask2);
        for (FieldMask fieldMask3 : fieldMaskArr) {
            fieldMaskTreeMergeFromFieldMask.mergeFromFieldMask(fieldMask3);
        }
        return fieldMaskTreeMergeFromFieldMask.toFieldMask();
    }

    public static FieldMask fromString(Class<? extends Message> cls, String str) {
        return fromStringList(cls, Arrays.asList(str.split(",")));
    }

    public static FieldMask fromStringList(Iterable<String> iterable) {
        return fromStringList(Absent.INSTANCE, iterable);
    }

    public static void merge(FieldMask fieldMask, Message message, Message.Builder builder) {
        merge(fieldMask, message, builder, new MergeOptions());
    }

    private static FieldMask fromStringList(Optional optional, Iterable<String> iterable) {
        FieldMask.Builder builderNewBuilder = FieldMask.newBuilder();
        for (String str : iterable) {
            if (!str.isEmpty()) {
                if (optional.isPresent() && !isValid((Descriptors.Descriptor) optional.get(), str)) {
                    throw new IllegalArgumentException(str + " is not a valid path for " + ((Descriptors.Descriptor) optional.get()).getFullName());
                }
                builderNewBuilder.addPaths(str);
            }
        }
        return builderNewBuilder.build();
    }

    public static boolean isValid(Descriptors.Descriptor descriptor, FieldMask fieldMask) {
        Iterator<String> it = fieldMask.getPathsList().iterator();
        while (it.hasNext()) {
            if (!isValid(descriptor, it.next())) {
                return false;
            }
        }
        return true;
    }

    public static boolean isValid(Class<? extends Message> cls, String str) {
        return isValid(((Message) Internal.getDefaultInstance(cls)).getDescriptorForType(), str);
    }

    public static boolean isValid(Descriptors.Descriptor descriptor, String str) {
        Descriptors.FieldDescriptor fieldDescriptorFindFieldByName;
        String[] strArrSplit = str.split(FIELD_SEPARATOR_REGEX);
        if (strArrSplit.length == 0) {
            return false;
        }
        for (String str2 : strArrSplit) {
            if (descriptor == null || (fieldDescriptorFindFieldByName = descriptor.findFieldByName(str2)) == null) {
                return false;
            }
            descriptor = (fieldDescriptorFindFieldByName.isRepeated() || fieldDescriptorFindFieldByName.getJavaType() != Descriptors.FieldDescriptor.JavaType.MESSAGE) ? null : fieldDescriptorFindFieldByName.getMessageType();
        }
        return true;
    }

    public static FieldMask fromStringList(Descriptors.Descriptor descriptor, Iterable<String> iterable) {
        descriptor.getClass();
        return fromStringList(new Present(descriptor), iterable);
    }

    public static FieldMask fromFieldNumbers(Class<? extends Message> cls, int... iArr) {
        List ints$IntArrayAsList;
        if (iArr.length == 0) {
            ints$IntArrayAsList = Collections.emptyList();
        } else {
            ints$IntArrayAsList = new Ints$IntArrayAsList(iArr, 0, iArr.length);
        }
        return fromFieldNumbers(cls, ints$IntArrayAsList);
    }
}
