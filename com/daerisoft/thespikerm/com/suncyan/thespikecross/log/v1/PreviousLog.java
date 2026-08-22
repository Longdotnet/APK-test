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
public final class PreviousLog extends GeneratedMessage implements PreviousLogOrBuilder {
    public static final int BALL_DATA_FIELD_NUMBER = 4;
    private static final PreviousLog DEFAULT_INSTANCE;
    public static final int ENEMY_HP_FIELD_NUMBER = 2;
    public static final int LAST_TOUCH_PLAYER_DATA_FIELD_NUMBER = 5;
    private static final Parser<PreviousLog> PARSER;
    public static final int TEAM_HP_FIELD_NUMBER = 1;
    public static final int TRIGGER_PLAYER_DATA_FIELD_NUMBER = 3;
    private static final long serialVersionUID = 0;
    private BallData ballData_;
    private int bitField0_;
    private float enemyHp_;
    private PlayerData lastTouchPlayerData_;
    private byte memoizedIsInitialized;
    private float teamHp_;
    private PlayerData triggerPlayerData_;

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 29, 5, "", PreviousLog.class.getName());
        DEFAULT_INSTANCE = new PreviousLog();
        PARSER = new AbstractParser<PreviousLog>() { // from class: com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.PreviousLog.1
            @Override // com.google.protobuf.Parser
            public PreviousLog parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                Builder builderNewBuilder = PreviousLog.newBuilder();
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

    public static /* synthetic */ int access$976(PreviousLog previousLog, int i) {
        int i2 = i | previousLog.bitField0_;
        previousLog.bitField0_ = i2;
        return i2;
    }

    public static PreviousLog getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return TheSpikeCrossLog.internal_static_com_suncyan_thespikecross_log_v1_PreviousLog_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static PreviousLog parseDelimitedFrom(InputStream inputStream) {
        return (PreviousLog) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static PreviousLog parseFrom(ByteBuffer byteBuffer) {
        return PARSER.parseFrom(byteBuffer);
    }

    public static Parser<PreviousLog> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PreviousLog)) {
            return super.equals(obj);
        }
        PreviousLog previousLog = (PreviousLog) obj;
        if (Float.floatToIntBits(getTeamHp()) != Float.floatToIntBits(previousLog.getTeamHp()) || Float.floatToIntBits(getEnemyHp()) != Float.floatToIntBits(previousLog.getEnemyHp()) || hasTriggerPlayerData() != previousLog.hasTriggerPlayerData()) {
            return false;
        }
        if ((hasTriggerPlayerData() && !getTriggerPlayerData().equals(previousLog.getTriggerPlayerData())) || hasBallData() != previousLog.hasBallData()) {
            return false;
        }
        if ((!hasBallData() || getBallData().equals(previousLog.getBallData())) && hasLastTouchPlayerData() == previousLog.hasLastTouchPlayerData()) {
            return (!hasLastTouchPlayerData() || getLastTouchPlayerData().equals(previousLog.getLastTouchPlayerData())) && getUnknownFields().equals(previousLog.getUnknownFields());
        }
        return false;
    }

    @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.PreviousLogOrBuilder
    public BallData getBallData() {
        BallData ballData = this.ballData_;
        return ballData == null ? BallData.getDefaultInstance() : ballData;
    }

    @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.PreviousLogOrBuilder
    public BallDataOrBuilder getBallDataOrBuilder() {
        BallData ballData = this.ballData_;
        return ballData == null ? BallData.getDefaultInstance() : ballData;
    }

    @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.PreviousLogOrBuilder
    public float getEnemyHp() {
        return this.enemyHp_;
    }

    @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.PreviousLogOrBuilder
    public PlayerData getLastTouchPlayerData() {
        PlayerData playerData = this.lastTouchPlayerData_;
        return playerData == null ? PlayerData.getDefaultInstance() : playerData;
    }

    @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.PreviousLogOrBuilder
    public PlayerDataOrBuilder getLastTouchPlayerDataOrBuilder() {
        PlayerData playerData = this.lastTouchPlayerData_;
        return playerData == null ? PlayerData.getDefaultInstance() : playerData;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<PreviousLog> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.memoizedSize;
        if (i != -1) {
            return i;
        }
        int iComputeFloatSize = Float.floatToRawIntBits(this.teamHp_) != 0 ? CodedOutputStream.computeFloatSize(1, this.teamHp_) : 0;
        if (Float.floatToRawIntBits(this.enemyHp_) != 0) {
            iComputeFloatSize += CodedOutputStream.computeFloatSize(2, this.enemyHp_);
        }
        if ((1 & this.bitField0_) != 0) {
            iComputeFloatSize += CodedOutputStream.computeMessageSize(3, getTriggerPlayerData());
        }
        if ((this.bitField0_ & 2) != 0) {
            iComputeFloatSize += CodedOutputStream.computeMessageSize(4, getBallData());
        }
        if ((this.bitField0_ & 4) != 0) {
            iComputeFloatSize += CodedOutputStream.computeMessageSize(5, getLastTouchPlayerData());
        }
        int serializedSize = getUnknownFields().getSerializedSize() + iComputeFloatSize;
        this.memoizedSize = serializedSize;
        return serializedSize;
    }

    @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.PreviousLogOrBuilder
    public float getTeamHp() {
        return this.teamHp_;
    }

    @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.PreviousLogOrBuilder
    public PlayerData getTriggerPlayerData() {
        PlayerData playerData = this.triggerPlayerData_;
        return playerData == null ? PlayerData.getDefaultInstance() : playerData;
    }

    @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.PreviousLogOrBuilder
    public PlayerDataOrBuilder getTriggerPlayerDataOrBuilder() {
        PlayerData playerData = this.triggerPlayerData_;
        return playerData == null ? PlayerData.getDefaultInstance() : playerData;
    }

    @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.PreviousLogOrBuilder
    public boolean hasBallData() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.PreviousLogOrBuilder
    public boolean hasLastTouchPlayerData() {
        return (this.bitField0_ & 4) != 0;
    }

    @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.PreviousLogOrBuilder
    public boolean hasTriggerPlayerData() {
        return (this.bitField0_ & 1) != 0;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public int hashCode() {
        int i = this.memoizedHashCode;
        if (i != 0) {
            return i;
        }
        int iFloatToIntBits = Float.floatToIntBits(getEnemyHp()) + ((((Float.floatToIntBits(getTeamHp()) + ((((getDescriptor().hashCode() + 779) * 37) + 1) * 53)) * 37) + 2) * 53);
        if (hasTriggerPlayerData()) {
            iFloatToIntBits = CoroutineAdapterKt$$ExternalSyntheticLambda0.m(iFloatToIntBits, 37, 3, 53) + getTriggerPlayerData().hashCode();
        }
        if (hasBallData()) {
            iFloatToIntBits = CoroutineAdapterKt$$ExternalSyntheticLambda0.m(iFloatToIntBits, 37, 4, 53) + getBallData().hashCode();
        }
        if (hasLastTouchPlayerData()) {
            iFloatToIntBits = CoroutineAdapterKt$$ExternalSyntheticLambda0.m(iFloatToIntBits, 37, 5, 53) + getLastTouchPlayerData().hashCode();
        }
        int iHashCode = getUnknownFields().hashCode() + (iFloatToIntBits * 29);
        this.memoizedHashCode = iHashCode;
        return iHashCode;
    }

    @Override // com.google.protobuf.GeneratedMessage
    public GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return TheSpikeCrossLog.internal_static_com_suncyan_thespikecross_log_v1_PreviousLog_fieldAccessorTable.ensureFieldAccessorsInitialized(PreviousLog.class, Builder.class);
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
        if (Float.floatToRawIntBits(this.teamHp_) != 0) {
            codedOutputStream.writeFloat(1, this.teamHp_);
        }
        if (Float.floatToRawIntBits(this.enemyHp_) != 0) {
            codedOutputStream.writeFloat(2, this.enemyHp_);
        }
        if ((this.bitField0_ & 1) != 0) {
            codedOutputStream.writeMessage(3, getTriggerPlayerData());
        }
        if ((this.bitField0_ & 2) != 0) {
            codedOutputStream.writeMessage(4, getBallData());
        }
        if ((this.bitField0_ & 4) != 0) {
            codedOutputStream.writeMessage(5, getLastTouchPlayerData());
        }
        getUnknownFields().writeTo(codedOutputStream);
    }

    public static final class Builder extends GeneratedMessage.Builder<Builder> implements PreviousLogOrBuilder {
        private SingleFieldBuilder<BallData, BallData.Builder, BallDataOrBuilder> ballDataBuilder_;
        private BallData ballData_;
        private int bitField0_;
        private float enemyHp_;
        private SingleFieldBuilder<PlayerData, PlayerData.Builder, PlayerDataOrBuilder> lastTouchPlayerDataBuilder_;
        private PlayerData lastTouchPlayerData_;
        private float teamHp_;
        private SingleFieldBuilder<PlayerData, PlayerData.Builder, PlayerDataOrBuilder> triggerPlayerDataBuilder_;
        private PlayerData triggerPlayerData_;

        private void buildPartial0(PreviousLog previousLog) {
            int i;
            int i2 = this.bitField0_;
            if ((i2 & 1) != 0) {
                previousLog.teamHp_ = this.teamHp_;
            }
            if ((i2 & 2) != 0) {
                previousLog.enemyHp_ = this.enemyHp_;
            }
            if ((i2 & 4) != 0) {
                SingleFieldBuilder<PlayerData, PlayerData.Builder, PlayerDataOrBuilder> singleFieldBuilder = this.triggerPlayerDataBuilder_;
                previousLog.triggerPlayerData_ = singleFieldBuilder == null ? this.triggerPlayerData_ : (PlayerData) singleFieldBuilder.build();
                i = 1;
            } else {
                i = 0;
            }
            if ((i2 & 8) != 0) {
                SingleFieldBuilder<BallData, BallData.Builder, BallDataOrBuilder> singleFieldBuilder2 = this.ballDataBuilder_;
                previousLog.ballData_ = singleFieldBuilder2 == null ? this.ballData_ : (BallData) singleFieldBuilder2.build();
                i |= 2;
            }
            if ((i2 & 16) != 0) {
                SingleFieldBuilder<PlayerData, PlayerData.Builder, PlayerDataOrBuilder> singleFieldBuilder3 = this.lastTouchPlayerDataBuilder_;
                previousLog.lastTouchPlayerData_ = singleFieldBuilder3 == null ? this.lastTouchPlayerData_ : (PlayerData) singleFieldBuilder3.build();
                i |= 4;
            }
            PreviousLog.access$976(previousLog, i);
        }

        private SingleFieldBuilder<BallData, BallData.Builder, BallDataOrBuilder> getBallDataFieldBuilder() {
            if (this.ballDataBuilder_ == null) {
                this.ballDataBuilder_ = new SingleFieldBuilder<>(getBallData(), getParentForChildren(), isClean());
                this.ballData_ = null;
            }
            return this.ballDataBuilder_;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return TheSpikeCrossLog.internal_static_com_suncyan_thespikecross_log_v1_PreviousLog_descriptor;
        }

        private SingleFieldBuilder<PlayerData, PlayerData.Builder, PlayerDataOrBuilder> getLastTouchPlayerDataFieldBuilder() {
            if (this.lastTouchPlayerDataBuilder_ == null) {
                this.lastTouchPlayerDataBuilder_ = new SingleFieldBuilder<>(getLastTouchPlayerData(), getParentForChildren(), isClean());
                this.lastTouchPlayerData_ = null;
            }
            return this.lastTouchPlayerDataBuilder_;
        }

        private SingleFieldBuilder<PlayerData, PlayerData.Builder, PlayerDataOrBuilder> getTriggerPlayerDataFieldBuilder() {
            if (this.triggerPlayerDataBuilder_ == null) {
                this.triggerPlayerDataBuilder_ = new SingleFieldBuilder<>(getTriggerPlayerData(), getParentForChildren(), isClean());
                this.triggerPlayerData_ = null;
            }
            return this.triggerPlayerDataBuilder_;
        }

        private void maybeForceBuilderInitialization() {
            if (GeneratedMessage.alwaysUseFieldBuilders) {
                getTriggerPlayerDataFieldBuilder();
                getBallDataFieldBuilder();
                getLastTouchPlayerDataFieldBuilder();
            }
        }

        public Builder clearBallData() {
            this.bitField0_ &= -9;
            this.ballData_ = null;
            SingleFieldBuilder<BallData, BallData.Builder, BallDataOrBuilder> singleFieldBuilder = this.ballDataBuilder_;
            if (singleFieldBuilder != null) {
                singleFieldBuilder.dispose();
                this.ballDataBuilder_ = null;
            }
            onChanged();
            return this;
        }

        public Builder clearEnemyHp() {
            this.bitField0_ &= -3;
            this.enemyHp_ = 0.0f;
            onChanged();
            return this;
        }

        public Builder clearLastTouchPlayerData() {
            this.bitField0_ &= -17;
            this.lastTouchPlayerData_ = null;
            SingleFieldBuilder<PlayerData, PlayerData.Builder, PlayerDataOrBuilder> singleFieldBuilder = this.lastTouchPlayerDataBuilder_;
            if (singleFieldBuilder != null) {
                singleFieldBuilder.dispose();
                this.lastTouchPlayerDataBuilder_ = null;
            }
            onChanged();
            return this;
        }

        public Builder clearTeamHp() {
            this.bitField0_ &= -2;
            this.teamHp_ = 0.0f;
            onChanged();
            return this;
        }

        public Builder clearTriggerPlayerData() {
            this.bitField0_ &= -5;
            this.triggerPlayerData_ = null;
            SingleFieldBuilder<PlayerData, PlayerData.Builder, PlayerDataOrBuilder> singleFieldBuilder = this.triggerPlayerDataBuilder_;
            if (singleFieldBuilder != null) {
                singleFieldBuilder.dispose();
                this.triggerPlayerDataBuilder_ = null;
            }
            onChanged();
            return this;
        }

        @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.PreviousLogOrBuilder
        public BallData getBallData() {
            SingleFieldBuilder<BallData, BallData.Builder, BallDataOrBuilder> singleFieldBuilder = this.ballDataBuilder_;
            if (singleFieldBuilder != null) {
                return (BallData) singleFieldBuilder.getMessage();
            }
            BallData ballData = this.ballData_;
            return ballData == null ? BallData.getDefaultInstance() : ballData;
        }

        public BallData.Builder getBallDataBuilder() {
            this.bitField0_ |= 8;
            onChanged();
            return (BallData.Builder) getBallDataFieldBuilder().getBuilder();
        }

        @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.PreviousLogOrBuilder
        public BallDataOrBuilder getBallDataOrBuilder() {
            SingleFieldBuilder<BallData, BallData.Builder, BallDataOrBuilder> singleFieldBuilder = this.ballDataBuilder_;
            if (singleFieldBuilder != null) {
                return (BallDataOrBuilder) singleFieldBuilder.getMessageOrBuilder();
            }
            BallData ballData = this.ballData_;
            return ballData == null ? BallData.getDefaultInstance() : ballData;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return TheSpikeCrossLog.internal_static_com_suncyan_thespikecross_log_v1_PreviousLog_descriptor;
        }

        @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.PreviousLogOrBuilder
        public float getEnemyHp() {
            return this.enemyHp_;
        }

        @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.PreviousLogOrBuilder
        public PlayerData getLastTouchPlayerData() {
            SingleFieldBuilder<PlayerData, PlayerData.Builder, PlayerDataOrBuilder> singleFieldBuilder = this.lastTouchPlayerDataBuilder_;
            if (singleFieldBuilder != null) {
                return (PlayerData) singleFieldBuilder.getMessage();
            }
            PlayerData playerData = this.lastTouchPlayerData_;
            return playerData == null ? PlayerData.getDefaultInstance() : playerData;
        }

        public PlayerData.Builder getLastTouchPlayerDataBuilder() {
            this.bitField0_ |= 16;
            onChanged();
            return (PlayerData.Builder) getLastTouchPlayerDataFieldBuilder().getBuilder();
        }

        @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.PreviousLogOrBuilder
        public PlayerDataOrBuilder getLastTouchPlayerDataOrBuilder() {
            SingleFieldBuilder<PlayerData, PlayerData.Builder, PlayerDataOrBuilder> singleFieldBuilder = this.lastTouchPlayerDataBuilder_;
            if (singleFieldBuilder != null) {
                return (PlayerDataOrBuilder) singleFieldBuilder.getMessageOrBuilder();
            }
            PlayerData playerData = this.lastTouchPlayerData_;
            return playerData == null ? PlayerData.getDefaultInstance() : playerData;
        }

        @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.PreviousLogOrBuilder
        public float getTeamHp() {
            return this.teamHp_;
        }

        @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.PreviousLogOrBuilder
        public PlayerData getTriggerPlayerData() {
            SingleFieldBuilder<PlayerData, PlayerData.Builder, PlayerDataOrBuilder> singleFieldBuilder = this.triggerPlayerDataBuilder_;
            if (singleFieldBuilder != null) {
                return (PlayerData) singleFieldBuilder.getMessage();
            }
            PlayerData playerData = this.triggerPlayerData_;
            return playerData == null ? PlayerData.getDefaultInstance() : playerData;
        }

        public PlayerData.Builder getTriggerPlayerDataBuilder() {
            this.bitField0_ |= 4;
            onChanged();
            return (PlayerData.Builder) getTriggerPlayerDataFieldBuilder().getBuilder();
        }

        @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.PreviousLogOrBuilder
        public PlayerDataOrBuilder getTriggerPlayerDataOrBuilder() {
            SingleFieldBuilder<PlayerData, PlayerData.Builder, PlayerDataOrBuilder> singleFieldBuilder = this.triggerPlayerDataBuilder_;
            if (singleFieldBuilder != null) {
                return (PlayerDataOrBuilder) singleFieldBuilder.getMessageOrBuilder();
            }
            PlayerData playerData = this.triggerPlayerData_;
            return playerData == null ? PlayerData.getDefaultInstance() : playerData;
        }

        @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.PreviousLogOrBuilder
        public boolean hasBallData() {
            return (this.bitField0_ & 8) != 0;
        }

        @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.PreviousLogOrBuilder
        public boolean hasLastTouchPlayerData() {
            return (this.bitField0_ & 16) != 0;
        }

        @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.PreviousLogOrBuilder
        public boolean hasTriggerPlayerData() {
            return (this.bitField0_ & 4) != 0;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder
        public GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return TheSpikeCrossLog.internal_static_com_suncyan_thespikecross_log_v1_PreviousLog_fieldAccessorTable.ensureFieldAccessorsInitialized(PreviousLog.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }

        public Builder mergeBallData(BallData ballData) {
            BallData ballData2;
            SingleFieldBuilder<BallData, BallData.Builder, BallDataOrBuilder> singleFieldBuilder = this.ballDataBuilder_;
            if (singleFieldBuilder != null) {
                singleFieldBuilder.mergeFrom(ballData);
            } else if ((this.bitField0_ & 8) == 0 || (ballData2 = this.ballData_) == null || ballData2 == BallData.getDefaultInstance()) {
                this.ballData_ = ballData;
            } else {
                getBallDataBuilder().mergeFrom(ballData);
            }
            if (this.ballData_ != null) {
                this.bitField0_ |= 8;
                onChanged();
            }
            return this;
        }

        public Builder mergeLastTouchPlayerData(PlayerData playerData) {
            PlayerData playerData2;
            SingleFieldBuilder<PlayerData, PlayerData.Builder, PlayerDataOrBuilder> singleFieldBuilder = this.lastTouchPlayerDataBuilder_;
            if (singleFieldBuilder != null) {
                singleFieldBuilder.mergeFrom(playerData);
            } else if ((this.bitField0_ & 16) == 0 || (playerData2 = this.lastTouchPlayerData_) == null || playerData2 == PlayerData.getDefaultInstance()) {
                this.lastTouchPlayerData_ = playerData;
            } else {
                getLastTouchPlayerDataBuilder().mergeFrom(playerData);
            }
            if (this.lastTouchPlayerData_ != null) {
                this.bitField0_ |= 16;
                onChanged();
            }
            return this;
        }

        public Builder mergeTriggerPlayerData(PlayerData playerData) {
            PlayerData playerData2;
            SingleFieldBuilder<PlayerData, PlayerData.Builder, PlayerDataOrBuilder> singleFieldBuilder = this.triggerPlayerDataBuilder_;
            if (singleFieldBuilder != null) {
                singleFieldBuilder.mergeFrom(playerData);
            } else if ((this.bitField0_ & 4) == 0 || (playerData2 = this.triggerPlayerData_) == null || playerData2 == PlayerData.getDefaultInstance()) {
                this.triggerPlayerData_ = playerData;
            } else {
                getTriggerPlayerDataBuilder().mergeFrom(playerData);
            }
            if (this.triggerPlayerData_ != null) {
                this.bitField0_ |= 4;
                onChanged();
            }
            return this;
        }

        public Builder setBallData(BallData ballData) {
            SingleFieldBuilder<BallData, BallData.Builder, BallDataOrBuilder> singleFieldBuilder = this.ballDataBuilder_;
            if (singleFieldBuilder == null) {
                ballData.getClass();
                this.ballData_ = ballData;
            } else {
                singleFieldBuilder.setMessage(ballData);
            }
            this.bitField0_ |= 8;
            onChanged();
            return this;
        }

        public Builder setEnemyHp(float f) {
            this.enemyHp_ = f;
            this.bitField0_ |= 2;
            onChanged();
            return this;
        }

        public Builder setLastTouchPlayerData(PlayerData playerData) {
            SingleFieldBuilder<PlayerData, PlayerData.Builder, PlayerDataOrBuilder> singleFieldBuilder = this.lastTouchPlayerDataBuilder_;
            if (singleFieldBuilder == null) {
                playerData.getClass();
                this.lastTouchPlayerData_ = playerData;
            } else {
                singleFieldBuilder.setMessage(playerData);
            }
            this.bitField0_ |= 16;
            onChanged();
            return this;
        }

        public Builder setTeamHp(float f) {
            this.teamHp_ = f;
            this.bitField0_ |= 1;
            onChanged();
            return this;
        }

        public Builder setTriggerPlayerData(PlayerData playerData) {
            SingleFieldBuilder<PlayerData, PlayerData.Builder, PlayerDataOrBuilder> singleFieldBuilder = this.triggerPlayerDataBuilder_;
            if (singleFieldBuilder == null) {
                playerData.getClass();
                this.triggerPlayerData_ = playerData;
            } else {
                singleFieldBuilder.setMessage(playerData);
            }
            this.bitField0_ |= 4;
            onChanged();
            return this;
        }

        private Builder() {
            maybeForceBuilderInitialization();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public PreviousLog build() {
            PreviousLog previousLogBuildPartial = buildPartial();
            if (previousLogBuildPartial.isInitialized()) {
                return previousLogBuildPartial;
            }
            throw AbstractMessage.Builder.newUninitializedMessageException((Message) previousLogBuildPartial);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public PreviousLog buildPartial() {
            PreviousLog previousLog = new PreviousLog(this);
            if (this.bitField0_ != 0) {
                buildPartial0(previousLog);
            }
            onBuilt();
            return previousLog;
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public PreviousLog getDefaultInstanceForType() {
            return PreviousLog.getDefaultInstance();
        }

        private Builder(AbstractMessage.BuilderParent builderParent) {
            super(builderParent);
            maybeForceBuilderInitialization();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.bitField0_ = 0;
            this.teamHp_ = 0.0f;
            this.enemyHp_ = 0.0f;
            this.triggerPlayerData_ = null;
            SingleFieldBuilder<PlayerData, PlayerData.Builder, PlayerDataOrBuilder> singleFieldBuilder = this.triggerPlayerDataBuilder_;
            if (singleFieldBuilder != null) {
                singleFieldBuilder.dispose();
                this.triggerPlayerDataBuilder_ = null;
            }
            this.ballData_ = null;
            SingleFieldBuilder<BallData, BallData.Builder, BallDataOrBuilder> singleFieldBuilder2 = this.ballDataBuilder_;
            if (singleFieldBuilder2 != null) {
                singleFieldBuilder2.dispose();
                this.ballDataBuilder_ = null;
            }
            this.lastTouchPlayerData_ = null;
            SingleFieldBuilder<PlayerData, PlayerData.Builder, PlayerDataOrBuilder> singleFieldBuilder3 = this.lastTouchPlayerDataBuilder_;
            if (singleFieldBuilder3 != null) {
                singleFieldBuilder3.dispose();
                this.lastTouchPlayerDataBuilder_ = null;
            }
            return this;
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message message) {
            if (message instanceof PreviousLog) {
                return mergeFrom((PreviousLog) message);
            }
            super.mergeFrom(message);
            return this;
        }

        public Builder setBallData(BallData.Builder builder) {
            SingleFieldBuilder<BallData, BallData.Builder, BallDataOrBuilder> singleFieldBuilder = this.ballDataBuilder_;
            if (singleFieldBuilder == null) {
                this.ballData_ = builder.build();
            } else {
                singleFieldBuilder.setMessage(builder.build());
            }
            this.bitField0_ |= 8;
            onChanged();
            return this;
        }

        public Builder setLastTouchPlayerData(PlayerData.Builder builder) {
            SingleFieldBuilder<PlayerData, PlayerData.Builder, PlayerDataOrBuilder> singleFieldBuilder = this.lastTouchPlayerDataBuilder_;
            if (singleFieldBuilder == null) {
                this.lastTouchPlayerData_ = builder.build();
            } else {
                singleFieldBuilder.setMessage(builder.build());
            }
            this.bitField0_ |= 16;
            onChanged();
            return this;
        }

        public Builder setTriggerPlayerData(PlayerData.Builder builder) {
            SingleFieldBuilder<PlayerData, PlayerData.Builder, PlayerDataOrBuilder> singleFieldBuilder = this.triggerPlayerDataBuilder_;
            if (singleFieldBuilder == null) {
                this.triggerPlayerData_ = builder.build();
            } else {
                singleFieldBuilder.setMessage(builder.build());
            }
            this.bitField0_ |= 4;
            onChanged();
            return this;
        }

        public Builder mergeFrom(PreviousLog previousLog) {
            if (previousLog == PreviousLog.getDefaultInstance()) {
                return this;
            }
            if (previousLog.getTeamHp() != 0.0f) {
                setTeamHp(previousLog.getTeamHp());
            }
            if (previousLog.getEnemyHp() != 0.0f) {
                setEnemyHp(previousLog.getEnemyHp());
            }
            if (previousLog.hasTriggerPlayerData()) {
                mergeTriggerPlayerData(previousLog.getTriggerPlayerData());
            }
            if (previousLog.hasBallData()) {
                mergeBallData(previousLog.getBallData());
            }
            if (previousLog.hasLastTouchPlayerData()) {
                mergeLastTouchPlayerData(previousLog.getLastTouchPlayerData());
            }
            mergeUnknownFields(previousLog.getUnknownFields());
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
                            if (tag == 13) {
                                this.teamHp_ = codedInputStream.readFloat();
                                this.bitField0_ |= 1;
                            } else if (tag == 21) {
                                this.enemyHp_ = codedInputStream.readFloat();
                                this.bitField0_ |= 2;
                            } else if (tag == 26) {
                                codedInputStream.readMessage(getTriggerPlayerDataFieldBuilder().getBuilder(), extensionRegistryLite);
                                this.bitField0_ |= 4;
                            } else if (tag == 34) {
                                codedInputStream.readMessage(getBallDataFieldBuilder().getBuilder(), extensionRegistryLite);
                                this.bitField0_ |= 8;
                            } else if (tag != 42) {
                                if (!super.parseUnknownField(codedInputStream, extensionRegistryLite, tag)) {
                                }
                            } else {
                                codedInputStream.readMessage(getLastTouchPlayerDataFieldBuilder().getBuilder(), extensionRegistryLite);
                                this.bitField0_ |= 16;
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

    private PreviousLog(GeneratedMessage.Builder<?> builder) {
        super(builder);
        this.teamHp_ = 0.0f;
        this.enemyHp_ = 0.0f;
        this.memoizedIsInitialized = (byte) -1;
    }

    public static Builder newBuilder(PreviousLog previousLog) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(previousLog);
    }

    public static PreviousLog parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static PreviousLog parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (PreviousLog) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static PreviousLog parseFrom(ByteString byteString) {
        return PARSER.parseFrom(byteString);
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public PreviousLog getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
    }

    public static PreviousLog parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static PreviousLog parseFrom(byte[] bArr) {
        return PARSER.parseFrom(bArr);
    }

    @Override // com.google.protobuf.AbstractMessage
    public Builder newBuilderForType(AbstractMessage.BuilderParent builderParent) {
        return new Builder(builderParent);
    }

    private PreviousLog() {
        this.teamHp_ = 0.0f;
        this.enemyHp_ = 0.0f;
        this.memoizedIsInitialized = (byte) -1;
    }

    public static PreviousLog parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static PreviousLog parseFrom(InputStream inputStream) {
        return (PreviousLog) GeneratedMessage.parseWithIOException(PARSER, inputStream);
    }

    public static PreviousLog parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (PreviousLog) GeneratedMessage.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static PreviousLog parseFrom(CodedInputStream codedInputStream) {
        return (PreviousLog) GeneratedMessage.parseWithIOException(PARSER, codedInputStream);
    }

    public static PreviousLog parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (PreviousLog) GeneratedMessage.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }
}
