package com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1;

import com.google.protobuf.Descriptors;
import com.google.protobuf.Internal;
import com.google.protobuf.ProtocolMessageEnum;
import com.google.protobuf.RuntimeVersion;

/* JADX INFO: loaded from: classes2.dex */
public enum TossType implements ProtocolMessageEnum {
    TOSS_TYPE_UNSPECIFIED(0),
    TOSS_OPEN(1),
    TOSS_QUICKOPEN(2),
    TOSS_QUICK(3),
    TOSS_TWOATTACK(4),
    TOSS_CQUICK(7),
    TOSS_VERYLOWTOSS(8),
    TOSS_HIGH(12),
    TOSS_SLOWTOSS(18),
    TOSS_MOOYOUNG(19),
    TOSS_VERYHIGH(99),
    TOSS_SODAM(100),
    TOSS_OPEN_MASKED_SOLHWA(TOSS_OPEN_MASKED_SOLHWA_VALUE),
    TOSS_OPEN_BALANCED(TOSS_OPEN_BALANCED_VALUE),
    TOSS_FIXED_LOW_FOR_BEGINNER(TOSS_FIXED_LOW_FOR_BEGINNER_VALUE),
    TOSS_NETUPOPEN(TOSS_NETUPOPEN_VALUE),
    TOSS_NETUPC(TOSS_NETUPC_VALUE),
    TOSS_SPOTLIGHT(TOSS_SPOTLIGHT_VALUE),
    TOSS_FIXED_MED_FOR_BEGINNER(TOSS_FIXED_MED_FOR_BEGINNER_VALUE),
    UNRECOGNIZED(-1);

    public static final int TOSS_CQUICK_VALUE = 7;
    public static final int TOSS_FIXED_LOW_FOR_BEGINNER_VALUE = 104;
    public static final int TOSS_FIXED_MED_FOR_BEGINNER_VALUE = 108;
    public static final int TOSS_HIGH_VALUE = 12;
    public static final int TOSS_MOOYOUNG_VALUE = 19;
    public static final int TOSS_NETUPC_VALUE = 106;
    public static final int TOSS_NETUPOPEN_VALUE = 105;
    public static final int TOSS_OPEN_BALANCED_VALUE = 103;
    public static final int TOSS_OPEN_MASKED_SOLHWA_VALUE = 102;
    public static final int TOSS_OPEN_VALUE = 1;
    public static final int TOSS_QUICKOPEN_VALUE = 2;
    public static final int TOSS_QUICK_VALUE = 3;
    public static final int TOSS_SLOWTOSS_VALUE = 18;
    public static final int TOSS_SODAM_VALUE = 100;
    public static final int TOSS_SPOTLIGHT_VALUE = 107;
    public static final int TOSS_TWOATTACK_VALUE = 4;
    public static final int TOSS_TYPE_UNSPECIFIED_VALUE = 0;
    public static final int TOSS_VERYHIGH_VALUE = 99;
    public static final int TOSS_VERYLOWTOSS_VALUE = 8;
    private static final TossType[] VALUES;
    private static final Internal.EnumLiteMap<TossType> internalValueMap;
    private final int value;

    TossType(int i) {
        this.value = i;
    }

    public static TossType forNumber(int i) {
        if (i == 0) {
            return TOSS_TYPE_UNSPECIFIED;
        }
        if (i == 1) {
            return TOSS_OPEN;
        }
        if (i == 2) {
            return TOSS_QUICKOPEN;
        }
        if (i == 3) {
            return TOSS_QUICK;
        }
        if (i == 4) {
            return TOSS_TWOATTACK;
        }
        if (i == 7) {
            return TOSS_CQUICK;
        }
        if (i == 8) {
            return TOSS_VERYLOWTOSS;
        }
        if (i == 12) {
            return TOSS_HIGH;
        }
        if (i == 18) {
            return TOSS_SLOWTOSS;
        }
        if (i == 19) {
            return TOSS_MOOYOUNG;
        }
        if (i == 99) {
            return TOSS_VERYHIGH;
        }
        if (i == 100) {
            return TOSS_SODAM;
        }
        switch (i) {
            case TOSS_OPEN_MASKED_SOLHWA_VALUE:
                return TOSS_OPEN_MASKED_SOLHWA;
            case TOSS_OPEN_BALANCED_VALUE:
                return TOSS_OPEN_BALANCED;
            case TOSS_FIXED_LOW_FOR_BEGINNER_VALUE:
                return TOSS_FIXED_LOW_FOR_BEGINNER;
            case TOSS_NETUPOPEN_VALUE:
                return TOSS_NETUPOPEN;
            case TOSS_NETUPC_VALUE:
                return TOSS_NETUPC;
            case TOSS_SPOTLIGHT_VALUE:
                return TOSS_SPOTLIGHT;
            case TOSS_FIXED_MED_FOR_BEGINNER_VALUE:
                return TOSS_FIXED_MED_FOR_BEGINNER;
            default:
                return null;
        }
    }

    public static final Descriptors.EnumDescriptor getDescriptor() {
        return TheSpikeCrossLog.getDescriptor().getEnumTypes().get(1);
    }

    public static Internal.EnumLiteMap<TossType> internalGetValueMap() {
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
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 29, 5, "", TossType.class.getName());
        internalValueMap = new Internal.EnumLiteMap<TossType>() { // from class: com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.TossType.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public TossType findValueByNumber(int i) {
                return TossType.forNumber(i);
            }
        };
        VALUES = values();
    }

    @Deprecated
    public static TossType valueOf(int i) {
        return forNumber(i);
    }

    public static TossType valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
        if (enumValueDescriptor.getType() == getDescriptor()) {
            if (enumValueDescriptor.getIndex() == -1) {
                return UNRECOGNIZED;
            }
            return VALUES[enumValueDescriptor.getIndex()];
        }
        throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
    }
}
