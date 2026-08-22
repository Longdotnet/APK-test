package com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1;

import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.AbstractParser;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.Parser;
import com.google.protobuf.RuntimeVersion;
import com.google.protobuf.SingleFieldBuilder;
import com.google.protobuf.UninitializedMessageException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public final class PointCommonData extends GeneratedMessage implements PointCommonDataOrBuilder {
    public static final int CONTINUOUS_SERVE_ACE_FIELD_NUMBER = 1;
    private static final PointCommonData DEFAULT_INSTANCE;
    public static final int LEFT_TEAM_DATA_FIELD_NUMBER = 5;
    private static final Parser<PointCommonData> PARSER;
    public static final int POINT_PLAYER_DATA_FIELD_NUMBER = 3;
    public static final int POINT_TYPE_FIELD_NUMBER = 4;
    public static final int RIGHT_TEAM_DATA_FIELD_NUMBER = 6;
    public static final int TOTAL_TOUCH_COUNT_FIELD_NUMBER = 2;
    private static final long serialVersionUID = 0;
    private int bitField0_;
    private int continuousServeAce_;
    private LeftTeamData leftTeamData_;
    private byte memoizedIsInitialized;
    private PlayerData pointPlayerData_;
    private int pointType_;
    private RightTeamData rightTeamData_;
    private int totalTouchCount_;

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 29, 5, "", PointCommonData.class.getName());
        DEFAULT_INSTANCE = new PointCommonData();
        PARSER = new AbstractParser<PointCommonData>() { // from class: com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.PointCommonData.1
            @Override // com.google.protobuf.Parser
            public PointCommonData parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                Builder builderNewBuilder = PointCommonData.newBuilder();
                try {
                    builderNewBuilder.mergeFrom(codedInputStream, extensionRegistryLite);
                    return builderNewBuilder.buildPartial();
                } catch (InvalidProtocolBufferException e) {
                    throw e.setUnfinishedMessage(builderNewBuilder.buildPartial());
                } catch (UninitializedMessageException e2) {
                    throw e2.asInvalidProtocolBufferException().setUnfinishedMessage(builderNewBuilder.buildPartial());
                } catch (IOException e3) {
                    throw new InvalidProtocolBufferException(e3).setUnfinishedMessage(builderNewBuilder.buildPartial());
                }
            }
        };
    }

    public static /* synthetic */ int access$1076(PointCommonData pointCommonData, int i) {
        int i2 = i | pointCommonData.bitField0_;
        pointCommonData.bitField0_ = i2;
        return i2;
    }

    public static PointCommonData getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return TheSpikeCrossLog.internal_static_com_suncyan_thespikecross_log_v1_PointCommonData_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static PointCommonData parseDelimitedFrom(InputStream inputStream) {
        return (PointCommonData) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static PointCommonData parseFrom(ByteBuffer byteBuffer) {
        return PARSER.parseFrom(byteBuffer);
    }

    public static Parser<PointCommonData> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PointCommonData)) {
            return super.equals(obj);
        }
        PointCommonData pointCommonData = (PointCommonData) obj;
        if (getContinuousServeAce() != pointCommonData.getContinuousServeAce() || getTotalTouchCount() != pointCommonData.getTotalTouchCount() || hasPointPlayerData() != pointCommonData.hasPointPlayerData()) {
            return false;
        }
        if ((hasPointPlayerData() && !getPointPlayerData().equals(pointCommonData.getPointPlayerData())) || this.pointType_ != pointCommonData.pointType_ || hasLeftTeamData() != pointCommonData.hasLeftTeamData()) {
            return false;
        }
        if ((!hasLeftTeamData() || getLeftTeamData().equals(pointCommonData.getLeftTeamData())) && hasRightTeamData() == pointCommonData.hasRightTeamData()) {
            return (!hasRightTeamData() || getRightTeamData().equals(pointCommonData.getRightTeamData())) && getUnknownFields().equals(pointCommonData.getUnknownFields());
        }
        return false;
    }

    @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.PointCommonDataOrBuilder
    public int getContinuousServeAce() {
        return this.continuousServeAce_;
    }

    @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.PointCommonDataOrBuilder
    public LeftTeamData getLeftTeamData() {
        LeftTeamData leftTeamData = this.leftTeamData_;
        return leftTeamData == null ? LeftTeamData.getDefaultInstance() : leftTeamData;
    }

    @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.PointCommonDataOrBuilder
    public LeftTeamDataOrBuilder getLeftTeamDataOrBuilder() {
        LeftTeamData leftTeamData = this.leftTeamData_;
        return leftTeamData == null ? LeftTeamData.getDefaultInstance() : leftTeamData;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<PointCommonData> getParserForType() {
        return PARSER;
    }

    @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.PointCommonDataOrBuilder
    public PlayerData getPointPlayerData() {
        PlayerData playerData = this.pointPlayerData_;
        return playerData == null ? PlayerData.getDefaultInstance() : playerData;
    }

    @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.PointCommonDataOrBuilder
    public PlayerDataOrBuilder getPointPlayerDataOrBuilder() {
        PlayerData playerData = this.pointPlayerData_;
        return playerData == null ? PlayerData.getDefaultInstance() : playerData;
    }

    @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.PointCommonDataOrBuilder
    public PointType getPointType() {
        PointType pointTypeForNumber = PointType.forNumber(this.pointType_);
        return pointTypeForNumber == null ? PointType.UNRECOGNIZED : pointTypeForNumber;
    }

    @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.PointCommonDataOrBuilder
    public int getPointTypeValue() {
        return this.pointType_;
    }

    @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.PointCommonDataOrBuilder
    public RightTeamData getRightTeamData() {
        RightTeamData rightTeamData = this.rightTeamData_;
        return rightTeamData == null ? RightTeamData.getDefaultInstance() : rightTeamData;
    }

    @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.PointCommonDataOrBuilder
    public RightTeamDataOrBuilder getRightTeamDataOrBuilder() {
        RightTeamData rightTeamData = this.rightTeamData_;
        return rightTeamData == null ? RightTeamData.getDefaultInstance() : rightTeamData;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.memoizedSize;
        if (i != -1) {
            return i;
        }
        int i2 = this.continuousServeAce_;
        int iComputeInt32Size = i2 != 0 ? CodedOutputStream.computeInt32Size(1, i2) : 0;
        int i3 = this.totalTouchCount_;
        if (i3 != 0) {
            iComputeInt32Size += CodedOutputStream.computeInt32Size(2, i3);
        }
        if ((1 & this.bitField0_) != 0) {
            iComputeInt32Size += CodedOutputStream.computeMessageSize(3, getPointPlayerData());
        }
        if (this.pointType_ != PointType.POINT_TYPE_NONE.getNumber()) {
            iComputeInt32Size += CodedOutputStream.computeEnumSize(4, this.pointType_);
        }
        if ((this.bitField0_ & 2) != 0) {
            iComputeInt32Size += CodedOutputStream.computeMessageSize(5, getLeftTeamData());
        }
        if ((this.bitField0_ & 4) != 0) {
            iComputeInt32Size += CodedOutputStream.computeMessageSize(6, getRightTeamData());
        }
        int serializedSize = getUnknownFields().getSerializedSize() + iComputeInt32Size;
        this.memoizedSize = serializedSize;
        return serializedSize;
    }

    @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.PointCommonDataOrBuilder
    public int getTotalTouchCount() {
        return this.totalTouchCount_;
    }

    @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.PointCommonDataOrBuilder
    public boolean hasLeftTeamData() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.PointCommonDataOrBuilder
    public boolean hasPointPlayerData() {
        return (this.bitField0_ & 1) != 0;
    }

    @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.PointCommonDataOrBuilder
    public boolean hasRightTeamData() {
        return (this.bitField0_ & 4) != 0;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public int hashCode() {
        int i = this.memoizedHashCode;
        if (i != 0) {
            return i;
        }
        int totalTouchCount = getTotalTouchCount() + ((((getContinuousServeAce() + ((((getDescriptor().hashCode() + 779) * 37) + 1) * 53)) * 37) + 2) * 53);
        if (hasPointPlayerData()) {
            totalTouchCount = CoroutineAdapterKt$$ExternalSyntheticLambda0.m(totalTouchCount, 37, 3, 53) + getPointPlayerData().hashCode();
        }
        int iM = CoroutineAdapterKt$$ExternalSyntheticLambda0.m(totalTouchCount, 37, 4, 53) + this.pointType_;
        if (hasLeftTeamData()) {
            iM = CoroutineAdapterKt$$ExternalSyntheticLambda0.m(iM, 37, 5, 53) + getLeftTeamData().hashCode();
        }
        if (hasRightTeamData()) {
            iM = CoroutineAdapterKt$$ExternalSyntheticLambda0.m(iM, 37, 6, 53) + getRightTeamData().hashCode();
        }
        int iHashCode = getUnknownFields().hashCode() + (iM * 29);
        this.memoizedHashCode = iHashCode;
        return iHashCode;
    }

    @Override // com.google.protobuf.GeneratedMessage
    public GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return TheSpikeCrossLog.internal_static_com_suncyan_thespikecross_log_v1_PointCommonData_fieldAccessorTable.ensureFieldAccessorsInitialized(PointCommonData.class, Builder.class);
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b = this.memoizedIsInitialized;
        if (b == 1) {
            return true;
        }
        if (b == 0) {
            return false;
        }
        this.memoizedIsInitialized = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) {
        int i = this.continuousServeAce_;
        if (i != 0) {
            codedOutputStream.writeInt32(1, i);
        }
        int i2 = this.totalTouchCount_;
        if (i2 != 0) {
            codedOutputStream.writeInt32(2, i2);
        }
        if ((this.bitField0_ & 1) != 0) {
            codedOutputStream.writeMessage(3, getPointPlayerData());
        }
        if (this.pointType_ != PointType.POINT_TYPE_NONE.getNumber()) {
            codedOutputStream.writeEnum(4, this.pointType_);
        }
        if ((this.bitField0_ & 2) != 0) {
            codedOutputStream.writeMessage(5, getLeftTeamData());
        }
        if ((this.bitField0_ & 4) != 0) {
            codedOutputStream.writeMessage(6, getRightTeamData());
        }
        getUnknownFields().writeTo(codedOutputStream);
    }

    public static final class Builder extends GeneratedMessage.Builder<Builder> implements PointCommonDataOrBuilder {
        private int bitField0_;
        private int continuousServeAce_;
        private SingleFieldBuilder<LeftTeamData, LeftTeamData.Builder, LeftTeamDataOrBuilder> leftTeamDataBuilder_;
        private LeftTeamData leftTeamData_;
        private SingleFieldBuilder<PlayerData, PlayerData.Builder, PlayerDataOrBuilder> pointPlayerDataBuilder_;
        private PlayerData pointPlayerData_;
        private int pointType_;
        private SingleFieldBuilder<RightTeamData, RightTeamData.Builder, RightTeamDataOrBuilder> rightTeamDataBuilder_;
        private RightTeamData rightTeamData_;
        private int totalTouchCount_;

        private void buildPartial0(PointCommonData pointCommonData) {
            int i;
            int i2 = this.bitField0_;
            if ((i2 & 1) != 0) {
                pointCommonData.continuousServeAce_ = this.continuousServeAce_;
            }
            if ((i2 & 2) != 0) {
                pointCommonData.totalTouchCount_ = this.totalTouchCount_;
            }
            if ((i2 & 4) != 0) {
                SingleFieldBuilder<PlayerData, PlayerData.Builder, PlayerDataOrBuilder> singleFieldBuilder = this.pointPlayerDataBuilder_;
                pointCommonData.pointPlayerData_ = singleFieldBuilder == null ? this.pointPlayerData_ : (PlayerData) singleFieldBuilder.build();
                i = 1;
            } else {
                i = 0;
            }
            if ((i2 & 8) != 0) {
                pointCommonData.pointType_ = this.pointType_;
            }
            if ((i2 & 16) != 0) {
                SingleFieldBuilder<LeftTeamData, LeftTeamData.Builder, LeftTeamDataOrBuilder> singleFieldBuilder2 = this.leftTeamDataBuilder_;
                pointCommonData.leftTeamData_ = singleFieldBuilder2 == null ? this.leftTeamData_ : (LeftTeamData) singleFieldBuilder2.build();
                i |= 2;
            }
            if ((i2 & 32) != 0) {
                SingleFieldBuilder<RightTeamData, RightTeamData.Builder, RightTeamDataOrBuilder> singleFieldBuilder3 = this.rightTeamDataBuilder_;
                pointCommonData.rightTeamData_ = singleFieldBuilder3 == null ? this.rightTeamData_ : (RightTeamData) singleFieldBuilder3.build();
                i |= 4;
            }
            PointCommonData.access$1076(pointCommonData, i);
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return TheSpikeCrossLog.internal_static_com_suncyan_thespikecross_log_v1_PointCommonData_descriptor;
        }

        private SingleFieldBuilder<LeftTeamData, LeftTeamData.Builder, LeftTeamDataOrBuilder> getLeftTeamDataFieldBuilder() {
            if (this.leftTeamDataBuilder_ == null) {
                this.leftTeamDataBuilder_ = new SingleFieldBuilder<>(getLeftTeamData(), getParentForChildren(), isClean());
                this.leftTeamData_ = null;
            }
            return this.leftTeamDataBuilder_;
        }

        private SingleFieldBuilder<PlayerData, PlayerData.Builder, PlayerDataOrBuilder> getPointPlayerDataFieldBuilder() {
            if (this.pointPlayerDataBuilder_ == null) {
                this.pointPlayerDataBuilder_ = new SingleFieldBuilder<>(getPointPlayerData(), getParentForChildren(), isClean());
                this.pointPlayerData_ = null;
            }
            return this.pointPlayerDataBuilder_;
        }

        private SingleFieldBuilder<RightTeamData, RightTeamData.Builder, RightTeamDataOrBuilder> getRightTeamDataFieldBuilder() {
            if (this.rightTeamDataBuilder_ == null) {
                this.rightTeamDataBuilder_ = new SingleFieldBuilder<>(getRightTeamData(), getParentForChildren(), isClean());
                this.rightTeamData_ = null;
            }
            return this.rightTeamDataBuilder_;
        }

        private void maybeForceBuilderInitialization() {
            if (GeneratedMessage.alwaysUseFieldBuilders) {
                getPointPlayerDataFieldBuilder();
                getLeftTeamDataFieldBuilder();
                getRightTeamDataFieldBuilder();
            }
        }

        public Builder clearContinuousServeAce() {
            this.bitField0_ &= -2;
            this.continuousServeAce_ = 0;
            onChanged();
            return this;
        }

        public Builder clearLeftTeamData() {
            this.bitField0_ &= -17;
            this.leftTeamData_ = null;
            SingleFieldBuilder<LeftTeamData, LeftTeamData.Builder, LeftTeamDataOrBuilder> singleFieldBuilder = this.leftTeamDataBuilder_;
            if (singleFieldBuilder != null) {
                singleFieldBuilder.dispose();
                this.leftTeamDataBuilder_ = null;
            }
            onChanged();
            return this;
        }

        public Builder clearPointPlayerData() {
            this.bitField0_ &= -5;
            this.pointPlayerData_ = null;
            SingleFieldBuilder<PlayerData, PlayerData.Builder, PlayerDataOrBuilder> singleFieldBuilder = this.pointPlayerDataBuilder_;
            if (singleFieldBuilder != null) {
                singleFieldBuilder.dispose();
                this.pointPlayerDataBuilder_ = null;
            }
            onChanged();
            return this;
        }

        public Builder clearPointType() {
            this.bitField0_ &= -9;
            this.pointType_ = 0;
            onChanged();
            return this;
        }

        public Builder clearRightTeamData() {
            this.bitField0_ &= -33;
            this.rightTeamData_ = null;
            SingleFieldBuilder<RightTeamData, RightTeamData.Builder, RightTeamDataOrBuilder> singleFieldBuilder = this.rightTeamDataBuilder_;
            if (singleFieldBuilder != null) {
                singleFieldBuilder.dispose();
                this.rightTeamDataBuilder_ = null;
            }
            onChanged();
            return this;
        }

        public Builder clearTotalTouchCount() {
            this.bitField0_ &= -3;
            this.totalTouchCount_ = 0;
            onChanged();
            return this;
        }

        @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.PointCommonDataOrBuilder
        public int getContinuousServeAce() {
            return this.continuousServeAce_;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return TheSpikeCrossLog.internal_static_com_suncyan_thespikecross_log_v1_PointCommonData_descriptor;
        }

        @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.PointCommonDataOrBuilder
        public LeftTeamData getLeftTeamData() {
            SingleFieldBuilder<LeftTeamData, LeftTeamData.Builder, LeftTeamDataOrBuilder> singleFieldBuilder = this.leftTeamDataBuilder_;
            if (singleFieldBuilder != null) {
                return (LeftTeamData) singleFieldBuilder.getMessage();
            }
            LeftTeamData leftTeamData = this.leftTeamData_;
            return leftTeamData == null ? LeftTeamData.getDefaultInstance() : leftTeamData;
        }

        public LeftTeamData.Builder getLeftTeamDataBuilder() {
            this.bitField0_ |= 16;
            onChanged();
            return (LeftTeamData.Builder) getLeftTeamDataFieldBuilder().getBuilder();
        }

        @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.PointCommonDataOrBuilder
        public LeftTeamDataOrBuilder getLeftTeamDataOrBuilder() {
            SingleFieldBuilder<LeftTeamData, LeftTeamData.Builder, LeftTeamDataOrBuilder> singleFieldBuilder = this.leftTeamDataBuilder_;
            if (singleFieldBuilder != null) {
                return (LeftTeamDataOrBuilder) singleFieldBuilder.getMessageOrBuilder();
            }
            LeftTeamData leftTeamData = this.leftTeamData_;
            return leftTeamData == null ? LeftTeamData.getDefaultInstance() : leftTeamData;
        }

        @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.PointCommonDataOrBuilder
        public PlayerData getPointPlayerData() {
            SingleFieldBuilder<PlayerData, PlayerData.Builder, PlayerDataOrBuilder> singleFieldBuilder = this.pointPlayerDataBuilder_;
            if (singleFieldBuilder != null) {
                return (PlayerData) singleFieldBuilder.getMessage();
            }
            PlayerData playerData = this.pointPlayerData_;
            return playerData == null ? PlayerData.getDefaultInstance() : playerData;
        }

        public PlayerData.Builder getPointPlayerDataBuilder() {
            this.bitField0_ |= 4;
            onChanged();
            return (PlayerData.Builder) getPointPlayerDataFieldBuilder().getBuilder();
        }

        @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.PointCommonDataOrBuilder
        public PlayerDataOrBuilder getPointPlayerDataOrBuilder() {
            SingleFieldBuilder<PlayerData, PlayerData.Builder, PlayerDataOrBuilder> singleFieldBuilder = this.pointPlayerDataBuilder_;
            if (singleFieldBuilder != null) {
                return (PlayerDataOrBuilder) singleFieldBuilder.getMessageOrBuilder();
            }
            PlayerData playerData = this.pointPlayerData_;
            return playerData == null ? PlayerData.getDefaultInstance() : playerData;
        }

        @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.PointCommonDataOrBuilder
        public PointType getPointType() {
            PointType pointTypeForNumber = PointType.forNumber(this.pointType_);
            return pointTypeForNumber == null ? PointType.UNRECOGNIZED : pointTypeForNumber;
        }

        @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.PointCommonDataOrBuilder
        public int getPointTypeValue() {
            return this.pointType_;
        }

        @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.PointCommonDataOrBuilder
        public RightTeamData getRightTeamData() {
            SingleFieldBuilder<RightTeamData, RightTeamData.Builder, RightTeamDataOrBuilder> singleFieldBuilder = this.rightTeamDataBuilder_;
            if (singleFieldBuilder != null) {
                return (RightTeamData) singleFieldBuilder.getMessage();
            }
            RightTeamData rightTeamData = this.rightTeamData_;
            return rightTeamData == null ? RightTeamData.getDefaultInstance() : rightTeamData;
        }

        public RightTeamData.Builder getRightTeamDataBuilder() {
            this.bitField0_ |= 32;
            onChanged();
            return (RightTeamData.Builder) getRightTeamDataFieldBuilder().getBuilder();
        }

        @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.PointCommonDataOrBuilder
        public RightTeamDataOrBuilder getRightTeamDataOrBuilder() {
            SingleFieldBuilder<RightTeamData, RightTeamData.Builder, RightTeamDataOrBuilder> singleFieldBuilder = this.rightTeamDataBuilder_;
            if (singleFieldBuilder != null) {
                return (RightTeamDataOrBuilder) singleFieldBuilder.getMessageOrBuilder();
            }
            RightTeamData rightTeamData = this.rightTeamData_;
            return rightTeamData == null ? RightTeamData.getDefaultInstance() : rightTeamData;
        }

        @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.PointCommonDataOrBuilder
        public int getTotalTouchCount() {
            return this.totalTouchCount_;
        }

        @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.PointCommonDataOrBuilder
        public boolean hasLeftTeamData() {
            return (this.bitField0_ & 16) != 0;
        }

        @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.PointCommonDataOrBuilder
        public boolean hasPointPlayerData() {
            return (this.bitField0_ & 4) != 0;
        }

        @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.PointCommonDataOrBuilder
        public boolean hasRightTeamData() {
            return (this.bitField0_ & 32) != 0;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder
        public GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return TheSpikeCrossLog.internal_static_com_suncyan_thespikecross_log_v1_PointCommonData_fieldAccessorTable.ensureFieldAccessorsInitialized(PointCommonData.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }

        public Builder mergeLeftTeamData(LeftTeamData leftTeamData) {
            LeftTeamData leftTeamData2;
            SingleFieldBuilder<LeftTeamData, LeftTeamData.Builder, LeftTeamDataOrBuilder> singleFieldBuilder = this.leftTeamDataBuilder_;
            if (singleFieldBuilder != null) {
                singleFieldBuilder.mergeFrom(leftTeamData);
            } else if ((this.bitField0_ & 16) == 0 || (leftTeamData2 = this.leftTeamData_) == null || leftTeamData2 == LeftTeamData.getDefaultInstance()) {
                this.leftTeamData_ = leftTeamData;
            } else {
                getLeftTeamDataBuilder().mergeFrom(leftTeamData);
            }
            if (this.leftTeamData_ != null) {
                this.bitField0_ |= 16;
                onChanged();
            }
            return this;
        }

        public Builder mergePointPlayerData(PlayerData playerData) {
            PlayerData playerData2;
            SingleFieldBuilder<PlayerData, PlayerData.Builder, PlayerDataOrBuilder> singleFieldBuilder = this.pointPlayerDataBuilder_;
            if (singleFieldBuilder != null) {
                singleFieldBuilder.mergeFrom(playerData);
            } else if ((this.bitField0_ & 4) == 0 || (playerData2 = this.pointPlayerData_) == null || playerData2 == PlayerData.getDefaultInstance()) {
                this.pointPlayerData_ = playerData;
            } else {
                getPointPlayerDataBuilder().mergeFrom(playerData);
            }
            if (this.pointPlayerData_ != null) {
                this.bitField0_ |= 4;
                onChanged();
            }
            return this;
        }

        public Builder mergeRightTeamData(RightTeamData rightTeamData) {
            RightTeamData rightTeamData2;
            SingleFieldBuilder<RightTeamData, RightTeamData.Builder, RightTeamDataOrBuilder> singleFieldBuilder = this.rightTeamDataBuilder_;
            if (singleFieldBuilder != null) {
                singleFieldBuilder.mergeFrom(rightTeamData);
            } else if ((this.bitField0_ & 32) == 0 || (rightTeamData2 = this.rightTeamData_) == null || rightTeamData2 == RightTeamData.getDefaultInstance()) {
                this.rightTeamData_ = rightTeamData;
            } else {
                getRightTeamDataBuilder().mergeFrom(rightTeamData);
            }
            if (this.rightTeamData_ != null) {
                this.bitField0_ |= 32;
                onChanged();
            }
            return this;
        }

        public Builder setContinuousServeAce(int i) {
            this.continuousServeAce_ = i;
            this.bitField0_ |= 1;
            onChanged();
            return this;
        }

        public Builder setLeftTeamData(LeftTeamData leftTeamData) {
            SingleFieldBuilder<LeftTeamData, LeftTeamData.Builder, LeftTeamDataOrBuilder> singleFieldBuilder = this.leftTeamDataBuilder_;
            if (singleFieldBuilder == null) {
                leftTeamData.getClass();
                this.leftTeamData_ = leftTeamData;
            } else {
                singleFieldBuilder.setMessage(leftTeamData);
            }
            this.bitField0_ |= 16;
            onChanged();
            return this;
        }

        public Builder setPointPlayerData(PlayerData playerData) {
            SingleFieldBuilder<PlayerData, PlayerData.Builder, PlayerDataOrBuilder> singleFieldBuilder = this.pointPlayerDataBuilder_;
            if (singleFieldBuilder == null) {
                playerData.getClass();
                this.pointPlayerData_ = playerData;
            } else {
                singleFieldBuilder.setMessage(playerData);
            }
            this.bitField0_ |= 4;
            onChanged();
            return this;
        }

        public Builder setPointType(PointType pointType) {
            pointType.getClass();
            this.bitField0_ |= 8;
            this.pointType_ = pointType.getNumber();
            onChanged();
            return this;
        }

        public Builder setPointTypeValue(int i) {
            this.pointType_ = i;
            this.bitField0_ |= 8;
            onChanged();
            return this;
        }

        public Builder setRightTeamData(RightTeamData rightTeamData) {
            SingleFieldBuilder<RightTeamData, RightTeamData.Builder, RightTeamDataOrBuilder> singleFieldBuilder = this.rightTeamDataBuilder_;
            if (singleFieldBuilder == null) {
                rightTeamData.getClass();
                this.rightTeamData_ = rightTeamData;
            } else {
                singleFieldBuilder.setMessage(rightTeamData);
            }
            this.bitField0_ |= 32;
            onChanged();
            return this;
        }

        public Builder setTotalTouchCount(int i) {
            this.totalTouchCount_ = i;
            this.bitField0_ |= 2;
            onChanged();
            return this;
        }

        private Builder() {
            this.pointType_ = 0;
            maybeForceBuilderInitialization();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public PointCommonData build() {
            PointCommonData pointCommonDataBuildPartial = buildPartial();
            if (pointCommonDataBuildPartial.isInitialized()) {
                return pointCommonDataBuildPartial;
            }
            throw AbstractMessage.Builder.newUninitializedMessageException((Message) pointCommonDataBuildPartial);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public PointCommonData buildPartial() {
            PointCommonData pointCommonData = new PointCommonData(this);
            if (this.bitField0_ != 0) {
                buildPartial0(pointCommonData);
            }
            onBuilt();
            return pointCommonData;
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public PointCommonData getDefaultInstanceForType() {
            return PointCommonData.getDefaultInstance();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.bitField0_ = 0;
            this.continuousServeAce_ = 0;
            this.totalTouchCount_ = 0;
            this.pointPlayerData_ = null;
            SingleFieldBuilder<PlayerData, PlayerData.Builder, PlayerDataOrBuilder> singleFieldBuilder = this.pointPlayerDataBuilder_;
            if (singleFieldBuilder != null) {
                singleFieldBuilder.dispose();
                this.pointPlayerDataBuilder_ = null;
            }
            this.pointType_ = 0;
            this.leftTeamData_ = null;
            SingleFieldBuilder<LeftTeamData, LeftTeamData.Builder, LeftTeamDataOrBuilder> singleFieldBuilder2 = this.leftTeamDataBuilder_;
            if (singleFieldBuilder2 != null) {
                singleFieldBuilder2.dispose();
                this.leftTeamDataBuilder_ = null;
            }
            this.rightTeamData_ = null;
            SingleFieldBuilder<RightTeamData, RightTeamData.Builder, RightTeamDataOrBuilder> singleFieldBuilder3 = this.rightTeamDataBuilder_;
            if (singleFieldBuilder3 != null) {
                singleFieldBuilder3.dispose();
                this.rightTeamDataBuilder_ = null;
            }
            return this;
        }

        private Builder(AbstractMessage.BuilderParent builderParent) {
            super(builderParent);
            this.pointType_ = 0;
            maybeForceBuilderInitialization();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message message) {
            if (message instanceof PointCommonData) {
                return mergeFrom((PointCommonData) message);
            }
            super.mergeFrom(message);
            return this;
        }

        public Builder setLeftTeamData(LeftTeamData.Builder builder) {
            SingleFieldBuilder<LeftTeamData, LeftTeamData.Builder, LeftTeamDataOrBuilder> singleFieldBuilder = this.leftTeamDataBuilder_;
            if (singleFieldBuilder == null) {
                this.leftTeamData_ = builder.build();
            } else {
                singleFieldBuilder.setMessage(builder.build());
            }
            this.bitField0_ |= 16;
            onChanged();
            return this;
        }

        public Builder setPointPlayerData(PlayerData.Builder builder) {
            SingleFieldBuilder<PlayerData, PlayerData.Builder, PlayerDataOrBuilder> singleFieldBuilder = this.pointPlayerDataBuilder_;
            if (singleFieldBuilder == null) {
                this.pointPlayerData_ = builder.build();
            } else {
                singleFieldBuilder.setMessage(builder.build());
            }
            this.bitField0_ |= 4;
            onChanged();
            return this;
        }

        public Builder setRightTeamData(RightTeamData.Builder builder) {
            SingleFieldBuilder<RightTeamData, RightTeamData.Builder, RightTeamDataOrBuilder> singleFieldBuilder = this.rightTeamDataBuilder_;
            if (singleFieldBuilder == null) {
                this.rightTeamData_ = builder.build();
            } else {
                singleFieldBuilder.setMessage(builder.build());
            }
            this.bitField0_ |= 32;
            onChanged();
            return this;
        }

        public Builder mergeFrom(PointCommonData pointCommonData) {
            if (pointCommonData == PointCommonData.getDefaultInstance()) {
                return this;
            }
            if (pointCommonData.getContinuousServeAce() != 0) {
                setContinuousServeAce(pointCommonData.getContinuousServeAce());
            }
            if (pointCommonData.getTotalTouchCount() != 0) {
                setTotalTouchCount(pointCommonData.getTotalTouchCount());
            }
            if (pointCommonData.hasPointPlayerData()) {
                mergePointPlayerData(pointCommonData.getPointPlayerData());
            }
            if (pointCommonData.pointType_ != 0) {
                setPointTypeValue(pointCommonData.getPointTypeValue());
            }
            if (pointCommonData.hasLeftTeamData()) {
                mergeLeftTeamData(pointCommonData.getLeftTeamData());
            }
            if (pointCommonData.hasRightTeamData()) {
                mergeRightTeamData(pointCommonData.getRightTeamData());
            }
            mergeUnknownFields(pointCommonData.getUnknownFields());
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            extensionRegistryLite.getClass();
            boolean z = false;
            while (!z) {
                try {
                    try {
                        int tag = codedInputStream.readTag();
                        if (tag != 0) {
                            if (tag == 8) {
                                this.continuousServeAce_ = codedInputStream.readInt32();
                                this.bitField0_ |= 1;
                            } else if (tag == 16) {
                                this.totalTouchCount_ = codedInputStream.readInt32();
                                this.bitField0_ |= 2;
                            } else if (tag == 26) {
                                codedInputStream.readMessage(getPointPlayerDataFieldBuilder().getBuilder(), extensionRegistryLite);
                                this.bitField0_ |= 4;
                            } else if (tag == 32) {
                                this.pointType_ = codedInputStream.readEnum();
                                this.bitField0_ |= 8;
                            } else if (tag == 42) {
                                codedInputStream.readMessage(getLeftTeamDataFieldBuilder().getBuilder(), extensionRegistryLite);
                                this.bitField0_ |= 16;
                            } else if (tag != 50) {
                                if (!super.parseUnknownField(codedInputStream, extensionRegistryLite, tag)) {
                                }
                            } else {
                                codedInputStream.readMessage(getRightTeamDataFieldBuilder().getBuilder(), extensionRegistryLite);
                                this.bitField0_ |= 32;
                            }
                        }
                        z = true;
                    } catch (InvalidProtocolBufferException e) {
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    onChanged();
                    throw th;
                }
            }
            onChanged();
            return this;
        }
    }

    private PointCommonData(GeneratedMessage.Builder<?> builder) {
        super(builder);
        this.continuousServeAce_ = 0;
        this.totalTouchCount_ = 0;
        this.pointType_ = 0;
        this.memoizedIsInitialized = (byte) -1;
    }

    public static Builder newBuilder(PointCommonData pointCommonData) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(pointCommonData);
    }

    public static PointCommonData parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static PointCommonData parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (PointCommonData) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static PointCommonData parseFrom(ByteString byteString) {
        return PARSER.parseFrom(byteString);
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public PointCommonData getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
    }

    public static PointCommonData parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static PointCommonData parseFrom(byte[] bArr) {
        return PARSER.parseFrom(bArr);
    }

    @Override // com.google.protobuf.AbstractMessage
    public Builder newBuilderForType(AbstractMessage.BuilderParent builderParent) {
        return new Builder(builderParent);
    }

    public static PointCommonData parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    private PointCommonData() {
        this.continuousServeAce_ = 0;
        this.totalTouchCount_ = 0;
        this.memoizedIsInitialized = (byte) -1;
        this.pointType_ = 0;
    }

    public static PointCommonData parseFrom(InputStream inputStream) {
        return (PointCommonData) GeneratedMessage.parseWithIOException(PARSER, inputStream);
    }

    public static PointCommonData parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (PointCommonData) GeneratedMessage.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static PointCommonData parseFrom(CodedInputStream codedInputStream) {
        return (PointCommonData) GeneratedMessage.parseWithIOException(PARSER, codedInputStream);
    }

    public static PointCommonData parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (PointCommonData) GeneratedMessage.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }
}
