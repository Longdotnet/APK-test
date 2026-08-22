package com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1;

import com.google.protobuf.Descriptors;
import com.google.protobuf.Internal;
import com.google.protobuf.ProtocolMessageEnum;
import com.google.protobuf.RuntimeVersion;

/* JADX INFO: loaded from: classes2.dex */
public enum BallState implements ProtocolMessageEnum {
    STAT_NORMAL(0),
    STAT_BLOCK(1),
    STAT_STRONGBLOCK(2),
    STAT_WEAKSPIKE(3),
    STAT_FAINT(4),
    STAT_TOSS(5),
    STAT_RECEIVE(6),
    STAT_STRONGSPIKE(7),
    STAT_PASSFAINT(8),
    STAT_DIRECT(9),
    STAT_CHEMICAL2(11),
    STAT_CHEMICAL3(12),
    STAT_SERVE(13),
    STAT_SUPERBALL(14),
    STAT_CHEMICAL4(16),
    STAT_ACTIVE_HONGSI(18),
    STAT_ACTIVE_RYUHYUN(19),
    UNRECOGNIZED(-1);

    public static final int STAT_ACTIVE_HONGSI_VALUE = 18;
    public static final int STAT_ACTIVE_RYUHYUN_VALUE = 19;
    public static final int STAT_BLOCK_VALUE = 1;
    public static final int STAT_CHEMICAL2_VALUE = 11;
    public static final int STAT_CHEMICAL3_VALUE = 12;
    public static final int STAT_CHEMICAL4_VALUE = 16;
    public static final int STAT_DIRECT_VALUE = 9;
    public static final int STAT_FAINT_VALUE = 4;
    public static final int STAT_NORMAL_VALUE = 0;
    public static final int STAT_PASSFAINT_VALUE = 8;
    public static final int STAT_RECEIVE_VALUE = 6;
    public static final int STAT_SERVE_VALUE = 13;
    public static final int STAT_STRONGBLOCK_VALUE = 2;
    public static final int STAT_STRONGSPIKE_VALUE = 7;
    public static final int STAT_SUPERBALL_VALUE = 14;
    public static final int STAT_TOSS_VALUE = 5;
    public static final int STAT_WEAKSPIKE_VALUE = 3;
    private static final BallState[] VALUES;
    private static final Internal.EnumLiteMap<BallState> internalValueMap;
    private final int value;

    BallState(int i) {
        this.value = i;
    }

    public static BallState forNumber(int i) {
        switch (i) {
            case 0:
                return STAT_NORMAL;
            case 1:
                return STAT_BLOCK;
            case 2:
                return STAT_STRONGBLOCK;
            case 3:
                return STAT_WEAKSPIKE;
            case 4:
                return STAT_FAINT;
            case 5:
                return STAT_TOSS;
            case 6:
                return STAT_RECEIVE;
            case 7:
                return STAT_STRONGSPIKE;
            case 8:
                return STAT_PASSFAINT;
            case 9:
                return STAT_DIRECT;
            case 10:
            case 15:
            case 17:
            default:
                return null;
            case 11:
                return STAT_CHEMICAL2;
            case 12:
                return STAT_CHEMICAL3;
            case 13:
                return STAT_SERVE;
            case 14:
                return STAT_SUPERBALL;
            case 16:
                return STAT_CHEMICAL4;
            case 18:
                return STAT_ACTIVE_HONGSI;
            case 19:
                return STAT_ACTIVE_RYUHYUN;
        }
    }

    public static final Descriptors.EnumDescriptor getDescriptor() {
        return TheSpikeCrossLog.getDescriptor().getEnumTypes().get(3);
    }

    public static Internal.EnumLiteMap<BallState> internalGetValueMap() {
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
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 29, 5, "", BallState.class.getName());
        internalValueMap = new Internal.EnumLiteMap<BallState>() { // from class: com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.BallState.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public BallState findValueByNumber(int i) {
                return BallState.forNumber(i);
            }
        };
        VALUES = values();
    }

    @Deprecated
    public static BallState valueOf(int i) {
        return forNumber(i);
    }

    public static BallState valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
        if (enumValueDescriptor.getType() == getDescriptor()) {
            if (enumValueDescriptor.getIndex() == -1) {
                return UNRECOGNIZED;
            }
            return VALUES[enumValueDescriptor.getIndex()];
        }
        throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
    }
}
