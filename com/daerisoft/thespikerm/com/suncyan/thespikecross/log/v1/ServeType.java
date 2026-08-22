package com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1;

import com.google.protobuf.Descriptors;
import com.google.protobuf.Internal;
import com.google.protobuf.ProtocolMessageEnum;
import com.google.protobuf.RuntimeVersion;

/* JADX INFO: loaded from: classes2.dex */
public enum ServeType implements ProtocolMessageEnum {
    SERVE_TYPE_SPIKE(0),
    SERVE_TYPE_JUMP_FLOATER(1),
    SERVE_TYPE_BASIC(2),
    SERVE_TYPE_SKY(3),
    UNRECOGNIZED(-1);

    public static final int SERVE_TYPE_BASIC_VALUE = 2;
    public static final int SERVE_TYPE_JUMP_FLOATER_VALUE = 1;
    public static final int SERVE_TYPE_SKY_VALUE = 3;
    public static final int SERVE_TYPE_SPIKE_VALUE = 0;
    private static final ServeType[] VALUES;
    private static final Internal.EnumLiteMap<ServeType> internalValueMap;
    private final int value;

    ServeType(int i) {
        this.value = i;
    }

    public static ServeType forNumber(int i) {
        if (i == 0) {
            return SERVE_TYPE_SPIKE;
        }
        if (i == 1) {
            return SERVE_TYPE_JUMP_FLOATER;
        }
        if (i == 2) {
            return SERVE_TYPE_BASIC;
        }
        if (i != 3) {
            return null;
        }
        return SERVE_TYPE_SKY;
    }

    public static final Descriptors.EnumDescriptor getDescriptor() {
        return TheSpikeCrossLog.getDescriptor().getEnumTypes().get(2);
    }

    public static Internal.EnumLiteMap<ServeType> internalGetValueMap() {
        return internalValueMap;
    }

    @Override // com.google.protobuf.ProtocolMessageEnum
    public final Descriptors.EnumDescriptor getDescriptorForType() {
        return getDescriptor();
    }

    @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite, com.google.protobuf.AbstractMessageLite.InternalOneOfEnum
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.value;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }

    @Override // com.google.protobuf.ProtocolMessageEnum
    public final Descriptors.EnumValueDescriptor getValueDescriptor() {
        if (this != UNRECOGNIZED) {
            return getDescriptor().getValues().get(ordinal());
        }
        throw new IllegalStateException("Can't get the descriptor of an unrecognized enum value.");
    }

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 29, 5, "", ServeType.class.getName());
        internalValueMap = new Internal.EnumLiteMap<ServeType>() { // from class: com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.ServeType.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public ServeType findValueByNumber(int i) {
                return ServeType.forNumber(i);
            }
        };
        VALUES = values();
    }

    @Deprecated
    public static ServeType valueOf(int i) {
        return forNumber(i);
    }

    public static ServeType valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
        if (enumValueDescriptor.getType() == getDescriptor()) {
            if (enumValueDescriptor.getIndex() == -1) {
                return UNRECOGNIZED;
            }
            return VALUES[enumValueDescriptor.getIndex()];
        }
        throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
    }
}
