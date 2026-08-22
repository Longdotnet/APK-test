package com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1;

import com.google.protobuf.Descriptors;
import com.google.protobuf.Internal;
import com.google.protobuf.ProtocolMessageEnum;
import com.google.protobuf.RuntimeVersion;

/* JADX INFO: loaded from: classes.dex */
public enum PointType implements ProtocolMessageEnum {
    POINT_TYPE_NONE(0),
    POINT_TYPE_SPIKE(1),
    POINT_TYPE_BLOCKING(2),
    POINT_TYPE_SERVE_ACE(3),
    POINT_TYPE_DOUBLE_CONTACT(4),
    POINT_TYPE_FOUR_HIT(5),
    POINT_TYPE_OUT_OF_BOUND(6),
    POINT_TYPE_SERVE_FAULT(7),
    POINT_TYPE_SERVE_TOUCH_FAULT(8),
    UNRECOGNIZED(-1);

    public static final int POINT_TYPE_BLOCKING_VALUE = 2;
    public static final int POINT_TYPE_DOUBLE_CONTACT_VALUE = 4;
    public static final int POINT_TYPE_FOUR_HIT_VALUE = 5;
    public static final int POINT_TYPE_NONE_VALUE = 0;
    public static final int POINT_TYPE_OUT_OF_BOUND_VALUE = 6;
    public static final int POINT_TYPE_SERVE_ACE_VALUE = 3;
    public static final int POINT_TYPE_SERVE_FAULT_VALUE = 7;
    public static final int POINT_TYPE_SERVE_TOUCH_FAULT_VALUE = 8;
    public static final int POINT_TYPE_SPIKE_VALUE = 1;
    private static final PointType[] VALUES;
    private static final Internal.EnumLiteMap<PointType> internalValueMap;
    private final int value;

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 29, 5, "", PointType.class.getName());
        internalValueMap = new Internal.EnumLiteMap<PointType>() { // from class: com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.PointType.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public PointType findValueByNumber(int i) {
                return PointType.forNumber(i);
            }
        };
        VALUES = values();
    }

    PointType(int i) {
        this.value = i;
    }

    public static PointType forNumber(int i) {
        switch (i) {
            case 0:
                return POINT_TYPE_NONE;
            case 1:
                return POINT_TYPE_SPIKE;
            case 2:
                return POINT_TYPE_BLOCKING;
            case 3:
                return POINT_TYPE_SERVE_ACE;
            case 4:
                return POINT_TYPE_DOUBLE_CONTACT;
            case 5:
                return POINT_TYPE_FOUR_HIT;
            case 6:
                return POINT_TYPE_OUT_OF_BOUND;
            case 7:
                return POINT_TYPE_SERVE_FAULT;
            case 8:
                return POINT_TYPE_SERVE_TOUCH_FAULT;
            default:
                return null;
        }
    }

    public static final Descriptors.EnumDescriptor getDescriptor() {
        return TheSpikeCrossLog.getDescriptor().getEnumTypes().get(0);
    }

    public static Internal.EnumLiteMap<PointType> internalGetValueMap() {
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

    @Deprecated
    public static PointType valueOf(int i) {
        return forNumber(i);
    }

    public static PointType valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
        if (enumValueDescriptor.getType() == getDescriptor()) {
            if (enumValueDescriptor.getIndex() == -1) {
                return UNRECOGNIZED;
            }
            return VALUES[enumValueDescriptor.getIndex()];
        }
        throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
    }
}
