package com.google.protobuf.util;

import androidx.fragment.app.Fragment;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import com.google.common.base.JdkPattern;
import com.google.common.base.Platform;
import com.google.common.base.Splitter;
import com.google.common.base.Splitter$1$1;
import com.google.protobuf.Descriptors;
import com.google.protobuf.FieldMask;
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.Message;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.text.StringsKt__IndentKt;

/* JADX INFO: loaded from: classes3.dex */
final class FieldMaskTree {
    private static final String FIELD_PATH_SEPARATOR_REGEX = "\\.";
    private static final Logger logger = Logger.getLogger(FieldMaskTree.class.getName());
    private final Node root = new Node();

    public static final class Node {
        final SortedMap<String, Node> children;

        private Node() {
            this.children = new TreeMap();
        }
    }

    public FieldMaskTree() {
    }

    private static void getFieldPaths(Node node, String str, List<String> list) {
        if (node.children.isEmpty()) {
            list.add(str);
            return;
        }
        for (Map.Entry<String, Node> entry : node.children.entrySet()) {
            getFieldPaths(entry.getValue(), str.isEmpty() ? entry.getKey() : str + "." + entry.getKey(), list);
        }
    }

    public FieldMaskTree addFieldPath(String str) {
        String[] strArrSplit = str.split(FIELD_PATH_SEPARATOR_REGEX);
        if (strArrSplit.length == 0) {
            return this;
        }
        Node node = this.root;
        boolean z = false;
        for (String str2 : strArrSplit) {
            if (!z && node != this.root && node.children.isEmpty()) {
                return this;
            }
            if (node.children.containsKey(str2)) {
                node = node.children.get(str2);
            } else {
                Node node2 = new Node();
                node.children.put(str2, node2);
                z = true;
                node = node2;
            }
        }
        node.children.clear();
        return this;
    }

    public void intersectFieldPath(String str, FieldMaskTree fieldMaskTree) {
        if (this.root.children.isEmpty()) {
            return;
        }
        String[] strArrSplit = str.split(FIELD_PATH_SEPARATOR_REGEX);
        if (strArrSplit.length == 0) {
            return;
        }
        Node node = this.root;
        for (String str2 : strArrSplit) {
            if (node != this.root && node.children.isEmpty()) {
                fieldMaskTree.addFieldPath(str);
                return;
            } else {
                if (!node.children.containsKey(str2)) {
                    return;
                }
                node = node.children.get(str2);
            }
        }
        ArrayList arrayList = new ArrayList();
        getFieldPaths(node, str, arrayList);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            fieldMaskTree.addFieldPath((String) it.next());
        }
    }

    public void merge(Message message, Message.Builder builder, FieldMaskUtil.MergeOptions mergeOptions) {
        if (message.getDescriptorForType() != builder.getDescriptorForType()) {
            throw new IllegalArgumentException("Cannot merge messages of different types.");
        }
        if (this.root.children.isEmpty()) {
            return;
        }
        merge(this.root, message, builder, mergeOptions);
    }

    public FieldMaskTree mergeFromFieldMask(FieldMask fieldMask) {
        Iterator<String> it = fieldMask.getPathsList().iterator();
        while (it.hasNext()) {
            addFieldPath(it.next());
        }
        return this;
    }

    public FieldMaskTree removeFieldPath(String str) {
        Platform.patternCompiler.getClass();
        JdkPattern jdkPattern = new JdkPattern(Pattern.compile(FIELD_PATH_SEPARATOR_REGEX));
        Matcher matcher = jdkPattern.pattern.matcher("");
        matcher.getClass();
        StringsKt__IndentKt.checkArgument(!matcher.matches(), "The pattern may not match the empty string: %s", jdkPattern);
        Splitter splitter = new Splitter(new Fragment.AnonymousClass7(jdkPattern, 27));
        str.getClass();
        Iterator it = ((Splitter.Strategy) splitter.strategy).iterator(splitter, str);
        ArrayList arrayList = new ArrayList();
        while (true) {
            Splitter$1$1 splitter$1$1 = (Splitter$1$1) it;
            if (!splitter$1$1.hasNext()) {
                break;
            }
            arrayList.add((String) splitter$1$1.next());
        }
        List listUnmodifiableList = Collections.unmodifiableList(arrayList);
        if (listUnmodifiableList.isEmpty()) {
            return this;
        }
        removeFieldPath(this.root, listUnmodifiableList, 0);
        return this;
    }

    public FieldMaskTree removeFromFieldMask(FieldMask fieldMask) {
        Iterator<String> it = fieldMask.getPathsList().iterator();
        while (it.hasNext()) {
            removeFieldPath(it.next());
        }
        return this;
    }

    public FieldMask toFieldMask() {
        if (this.root.children.isEmpty()) {
            return FieldMask.getDefaultInstance();
        }
        ArrayList arrayList = new ArrayList();
        getFieldPaths(this.root, "", arrayList);
        return FieldMask.newBuilder().addAllPaths(arrayList).build();
    }

    public String toString() {
        return FieldMaskUtil.toString(toFieldMask());
    }

    public FieldMaskTree(FieldMask fieldMask) {
        mergeFromFieldMask(fieldMask);
    }

    private static void merge(Node node, Message message, Message.Builder builder, FieldMaskUtil.MergeOptions mergeOptions) {
        Message.Builder builder2;
        if (message.getDescriptorForType() == builder.getDescriptorForType()) {
            Descriptors.Descriptor descriptorForType = message.getDescriptorForType();
            for (Map.Entry<String, Node> entry : node.children.entrySet()) {
                Descriptors.FieldDescriptor fieldDescriptorFindFieldByName = descriptorForType.findFieldByName(entry.getKey());
                if (fieldDescriptorFindFieldByName == null) {
                    logger.warning("Cannot find field \"" + entry.getKey() + "\" in message type " + descriptorForType.getFullName());
                } else if (!entry.getValue().children.isEmpty()) {
                    if (!fieldDescriptorFindFieldByName.isRepeated() && fieldDescriptorFindFieldByName.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                        if (message.hasField(fieldDescriptorFindFieldByName) || builder.hasField(fieldDescriptorFindFieldByName)) {
                            if (builder instanceof GeneratedMessage.Builder) {
                                builder2 = builder.getFieldBuilder(fieldDescriptorFindFieldByName);
                            } else {
                                builder2 = ((Message) builder.getField(fieldDescriptorFindFieldByName)).toBuilder();
                            }
                            merge(entry.getValue(), (Message) message.getField(fieldDescriptorFindFieldByName), builder2, mergeOptions);
                            builder.setField(fieldDescriptorFindFieldByName, builder2.buildPartial());
                        }
                    } else {
                        logger.warning("Field \"" + fieldDescriptorFindFieldByName.getFullName() + "\" is not a singular message field and cannot have sub-fields.");
                    }
                } else if (fieldDescriptorFindFieldByName.isRepeated()) {
                    if (mergeOptions.replaceRepeatedFields()) {
                        builder.setField(fieldDescriptorFindFieldByName, message.getField(fieldDescriptorFindFieldByName));
                    } else {
                        Iterator it = ((List) message.getField(fieldDescriptorFindFieldByName)).iterator();
                        while (it.hasNext()) {
                            builder.addRepeatedField(fieldDescriptorFindFieldByName, it.next());
                        }
                    }
                } else if (fieldDescriptorFindFieldByName.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                    if (mergeOptions.replaceMessageFields()) {
                        if (!message.hasField(fieldDescriptorFindFieldByName)) {
                            builder.clearField(fieldDescriptorFindFieldByName);
                        } else {
                            builder.setField(fieldDescriptorFindFieldByName, message.getField(fieldDescriptorFindFieldByName));
                        }
                    } else if (message.hasField(fieldDescriptorFindFieldByName)) {
                        builder.setField(fieldDescriptorFindFieldByName, ((Message) builder.getField(fieldDescriptorFindFieldByName)).toBuilder().mergeFrom((Message) message.getField(fieldDescriptorFindFieldByName)).build());
                    }
                } else if (!message.hasField(fieldDescriptorFindFieldByName) && mergeOptions.replacePrimitiveFields()) {
                    builder.clearField(fieldDescriptorFindFieldByName);
                } else {
                    builder.setField(fieldDescriptorFindFieldByName, message.getField(fieldDescriptorFindFieldByName));
                }
            }
            return;
        }
        throw new IllegalArgumentException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m("source (", message.getDescriptorForType().getFullName(), ") and destination (", builder.getDescriptorForType().getFullName(), ") descriptor must be equal"));
    }

    private static boolean removeFieldPath(Node node, List<String> list, int i) {
        String str = list.get(i);
        if (!node.children.containsKey(str)) {
            return false;
        }
        if (i == list.size() - 1) {
            node.children.remove(str);
            return node.children.isEmpty();
        }
        if (removeFieldPath(node.children.get(str), list, i + 1)) {
            node.children.remove(str);
        }
        return node.children.isEmpty();
    }
}
