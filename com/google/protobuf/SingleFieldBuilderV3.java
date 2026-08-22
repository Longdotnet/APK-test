package com.google.protobuf;

import com.google.protobuf.AbstractMessage;
import com.google.protobuf.AbstractMessage.Builder;
import com.google.protobuf.MessageOrBuilder;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public class SingleFieldBuilderV3<MType extends AbstractMessage, BType extends AbstractMessage.Builder, IType extends MessageOrBuilder> implements AbstractMessage.BuilderParent {
    private BType builder;
    private boolean isClean;
    private MType message;
    private AbstractMessage.BuilderParent parent;

    @Deprecated
    public SingleFieldBuilderV3(MType mtype, AbstractMessage.BuilderParent builderParent, boolean z) {
        this.message = (MType) Internal.checkNotNull(mtype);
        this.parent = builderParent;
        this.isClean = z;
    }

    @Deprecated
    private void onChanged() {
        AbstractMessage.BuilderParent builderParent;
        if (this.builder != null) {
            this.message = null;
        }
        if (!this.isClean || (builderParent = this.parent) == null) {
            return;
        }
        builderParent.markDirty();
        this.isClean = false;
    }

    @Deprecated
    public MType build() {
        this.isClean = true;
        return (MType) getMessage();
    }

    @Deprecated
    public SingleFieldBuilderV3<MType, BType, IType> clear() {
        MType mtype = this.message;
        this.message = (MType) (mtype != null ? mtype.getDefaultInstanceForType() : this.builder.getDefaultInstanceForType());
        BType btype = this.builder;
        if (btype != null) {
            btype.dispose();
            this.builder = null;
        }
        onChanged();
        this.isClean = true;
        return this;
    }

    @Deprecated
    public void dispose() {
        this.parent = null;
    }

    @Deprecated
    public BType getBuilder() {
        if (this.builder == null) {
            BType btype = (BType) this.message.newBuilderForType(this);
            this.builder = btype;
            btype.mergeFrom(this.message);
            this.builder.markClean();
        }
        return this.builder;
    }

    @Deprecated
    public MType getMessage() {
        if (this.message == null) {
            this.message = (MType) this.builder.buildPartial();
        }
        return this.message;
    }

    @Deprecated
    public IType getMessageOrBuilder() {
        BType btype = this.builder;
        return btype != null ? btype : this.message;
    }

    @Override // com.google.protobuf.AbstractMessage.BuilderParent
    @Deprecated
    public void markDirty() {
        onChanged();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x000f  */
    @Deprecated
    public SingleFieldBuilderV3<MType, BType, IType> mergeFrom(MType mtype) {
        if (this.builder == null) {
            Message message = this.message;
            if (message == message.getDefaultInstanceForType()) {
                this.message = mtype;
            } else {
                getBuilder().mergeFrom((Message) mtype);
            }
        } else {
            getBuilder().mergeFrom((Message) mtype);
        }
        onChanged();
        return this;
    }

    @Deprecated
    public SingleFieldBuilderV3<MType, BType, IType> setMessage(MType mtype) {
        this.message = (MType) Internal.checkNotNull(mtype);
        BType btype = this.builder;
        if (btype != null) {
            btype.dispose();
            this.builder = null;
        }
        onChanged();
        return this;
    }
}
