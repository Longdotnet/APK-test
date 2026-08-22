package com.google.firebase.encoders.proto;

/* JADX INFO: loaded from: classes.dex */
public final class AtProtobuf {
    private Protobuf.IntEncoding intEncoding = Protobuf.IntEncoding.DEFAULT;
    private int tag;

    public final class ProtobufImpl implements Protobuf {
        public final Protobuf.IntEncoding intEncoding;
        public final int tag;

        public ProtobufImpl(int i, Protobuf.IntEncoding intEncoding) {
            this.tag = i;
            this.intEncoding = intEncoding;
        }

        @Override // java.lang.annotation.Annotation
        public final Class annotationType() {
            return Protobuf.class;
        }

        @Override // java.lang.annotation.Annotation
        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Protobuf)) {
                return false;
            }
            Protobuf protobuf = (Protobuf) obj;
            return this.tag == ((ProtobufImpl) protobuf).tag && this.intEncoding.equals(((ProtobufImpl) protobuf).intEncoding);
        }

        @Override // java.lang.annotation.Annotation
        public final int hashCode() {
            return (14552422 ^ this.tag) + (this.intEncoding.hashCode() ^ 2041407134);
        }

        @Override // com.google.firebase.encoders.proto.Protobuf
        public final Protobuf.IntEncoding intEncoding() {
            return this.intEncoding;
        }

        @Override // com.google.firebase.encoders.proto.Protobuf
        public final int tag() {
            return this.tag;
        }

        @Override // java.lang.annotation.Annotation
        public final String toString() {
            return "@com.google.firebase.encoders.proto.Protobuf(tag=" + this.tag + "intEncoding=" + this.intEncoding + ')';
        }
    }

    public static AtProtobuf builder() {
        return new AtProtobuf();
    }

    public Protobuf build() {
        return new ProtobufImpl(this.tag, this.intEncoding);
    }

    public AtProtobuf intEncoding(Protobuf.IntEncoding intEncoding) {
        this.intEncoding = intEncoding;
        return this;
    }

    public AtProtobuf tag(int i) {
        this.tag = i;
        return this;
    }
}
