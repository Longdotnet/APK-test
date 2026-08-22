package okio;

import com.google.zxing.BarcodeFormat$EnumUnboxingLocalUtility;
import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;
import java.util.zip.CRC32;
import java.util.zip.Inflater;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class GzipSource implements Source {
    public final CRC32 crc;
    public final Inflater inflater;
    public final InflaterSource inflaterSource;
    public byte section;
    public final RealBufferedSource source;

    public GzipSource(Source source) {
        Intrinsics.checkNotNullParameter(source, "source");
        RealBufferedSource realBufferedSource = new RealBufferedSource(source);
        this.source = realBufferedSource;
        Inflater inflater = new Inflater(true);
        this.inflater = inflater;
        this.inflaterSource = new InflaterSource(realBufferedSource, inflater);
        this.crc = new CRC32();
    }

    public static void checkEqual(int i, int i2, String str) throws IOException {
        if (i2 != i) {
            throw new IOException(String.format("%s: actual 0x%08x != expected 0x%08x", Arrays.copyOf(new Object[]{str, Integer.valueOf(i2), Integer.valueOf(i)}, 3)));
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.inflaterSource.close();
    }

    @Override // okio.Source
    public final long read(Buffer sink, long j) throws IOException {
        Buffer buffer;
        long j2;
        Intrinsics.checkNotNullParameter(sink, "sink");
        if (j < 0) {
            throw new IllegalArgumentException(BarcodeFormat$EnumUnboxingLocalUtility.m(j, "byteCount < 0: ").toString());
        }
        if (j == 0) {
            return 0L;
        }
        byte b = this.section;
        CRC32 crc32 = this.crc;
        RealBufferedSource realBufferedSource = this.source;
        if (b == 0) {
            realBufferedSource.require(10L);
            Buffer buffer2 = realBufferedSource.bufferField;
            byte b2 = buffer2.getByte(3L);
            boolean z = ((b2 >> 1) & 1) == 1;
            if (z) {
                updateCrc(buffer2, 0L, 10L);
            }
            checkEqual(8075, realBufferedSource.readShort(), "ID1ID2");
            realBufferedSource.skip(8L);
            if (((b2 >> 2) & 1) == 1) {
                realBufferedSource.require(2L);
                if (z) {
                    updateCrc(buffer2, 0L, 2L);
                }
                short s = buffer2.readShort();
                long j3 = (short) (((s & 255) << 8) | ((s & 65280) >>> 8));
                realBufferedSource.require(j3);
                if (z) {
                    updateCrc(buffer2, 0L, j3);
                    j2 = j3;
                } else {
                    j2 = j3;
                }
                realBufferedSource.skip(j2);
            }
            if (((b2 >> 3) & 1) == 1) {
                buffer = buffer2;
                long jIndexOf = realBufferedSource.indexOf((byte) 0, 0L, Long.MAX_VALUE);
                if (jIndexOf == -1) {
                    throw new EOFException();
                }
                if (z) {
                    updateCrc(buffer, 0L, jIndexOf + 1);
                }
                
                /*  JADX ERROR: Method code generation error
                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x00c3: INVOKE (r4v6 ?? I:??[OBJECT, ARRAY]), (wrap long:0x00c1: ARITH (r14v3 'jIndexOf' long) + (1 long) A[WRAPPED] (LINE:194)) VIRTUAL call: okio.RealBufferedSource.skip(long):void A[MD:(long):void (m)] (LINE:196) in method: okio.GzipSource.read(okio.Buffer, long):long, file: classes3.dex
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
                    	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:94)
                    	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                    	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                    	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                    	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:291)
                    	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:270)
                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
                    	at java.base/java.util.ArrayList.forEach(Unknown Source)
                    	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
                    	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
                    	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(Unknown Source)
                    	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
                    	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(Unknown Source)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(Unknown Source)
                    	at java.base/java.util.stream.AbstractPipeline.evaluate(Unknown Source)
                    	at java.base/java.util.stream.ReferencePipeline.forEach(Unknown Source)
                    	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
                    	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
                    	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
                    	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
                    	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
                    	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
                    	at jadx.core.ProcessClass.process(ProcessClass.java:89)
                    	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
                    	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
                    	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
                    	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:311)
                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r4v6 ??
                    	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
                    */
                /*
                    Method dump skipped, instruction units count: 415
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: okio.GzipSource.read(okio.Buffer, long):long");
            }

            @Override // okio.Source
            public final Timeout timeout() {
                return this.source.source.timeout();
            }

            public final void updateCrc(Buffer buffer, long j, long j2) {
                Segment segment = buffer.head;
                Intrinsics.checkNotNull(segment);
                while (true) {
                    int i = segment.limit;
                    int i2 = segment.pos;
                    if (j < i - i2) {
                        break;
                    }
                    j -= (long) (i - i2);
                    segment = segment.next;
                    Intrinsics.checkNotNull(segment);
                }
                while (j2 > 0) {
                    int i3 = (int) (((long) segment.pos) + j);
                    int iMin = (int) Math.min(segment.limit - i3, j2);
                    this.crc.update(segment.data, i3, iMin);
                    j2 -= (long) iMin;
                    segment = segment.next;
                    Intrinsics.checkNotNull(segment);
                    j = 0;
                }
            }
        }
