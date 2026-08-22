package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzcro implements zzgdj {
    final /* synthetic */ zzgdj zza;
    final /* synthetic */ zzcrp zzb;

    public zzcro(zzcrp zzcrpVar, zzgdj zzgdjVar) {
        this.zza = zzgdjVar;
        Objects.requireNonNull(zzcrpVar);
        this.zzb = zzcrpVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgdj
    public final void zza(Throwable th) {
        zzcaf.zzf.execute(new Runnable
        /*  JADX ERROR: Method code generation error
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0002: INVOKE 
              (wrap com.google.android.gms.internal.ads.zzgdy:0x0000: SGET  A[WRAPPED] (LINE:1) com.google.android.gms.internal.ads.zzcaf.zzf com.google.android.gms.internal.ads.zzgdy)
              (wrap java.lang.Runnable:0x0004: CONSTRUCTOR 
              (wrap com.google.android.gms.internal.ads.zzcrp:0x0000: IGET (r1v0 'this' com.google.android.gms.internal.ads.zzcro A[IMMUTABLE_TYPE, THIS]) A[WRAPPED] (LINE:1) com.google.android.gms.internal.ads.zzcro.zzb com.google.android.gms.internal.ads.zzcrp)
             A[MD:(com.google.android.gms.internal.ads.zzcrp):void (m), WRAPPED] (LINE:5) call: com.google.android.gms.internal.ads.zzcrj.<init>(com.google.android.gms.internal.ads.zzcrp):void type: CONSTRUCTOR)
             INTERFACE call: java.util.concurrent.Executor.execute(java.lang.Runnable):void A[MD:(java.lang.Runnable):void (c)] (LINE:8) in method: com.google.android.gms.internal.ads.zzcro.zza(java.lang.Throwable):void, file: classes.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:94)
            	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
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
            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: com.google.android.gms.internal.ads.zzcrj.<init>(com.google.android.gms.internal.ads.zzcrp):void, class status: GENERATED_AND_UNLOADED
            	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:309)
            	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:829)
            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:730)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:418)
            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:145)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:121)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:108)
            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:1143)
            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:910)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:422)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:303)
            	... 35 more
            */
        /*
            this = this;
            com.google.android.gms.internal.ads.zzcrp r0 = r1.zzb
            com.google.android.gms.internal.ads.zzcrp.zzd(r0)
            com.google.android.gms.internal.ads.zzgdj r0 = r1.zza
            r0.zza(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcro.zza(java.lang.Throwable):void");
    }

    @Override // com.google.android.gms.internal.ads.zzgdj
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzcaf.zzf.execute(new Runnable
        /*  JADX ERROR: Method code generation error
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0004: INVOKE 
              (wrap com.google.android.gms.internal.ads.zzgdy:0x0000: SGET  A[WRAPPED] (LINE:1) com.google.android.gms.internal.ads.zzcaf.zzf com.google.android.gms.internal.ads.zzgdy)
              (wrap java.lang.Runnable:0x0004: CONSTRUCTOR 
              (wrap com.google.android.gms.internal.ads.zzcrp:0x0000: IGET (r1v0 'this' com.google.android.gms.internal.ads.zzcro A[IMMUTABLE_TYPE, THIS]) A[WRAPPED] (LINE:1) com.google.android.gms.internal.ads.zzcro.zzb com.google.android.gms.internal.ads.zzcrp)
             A[MD:(com.google.android.gms.internal.ads.zzcrp):void (m), WRAPPED] (LINE:5) call: com.google.android.gms.internal.ads.zzcrj.<init>(com.google.android.gms.internal.ads.zzcrp):void type: CONSTRUCTOR)
             INTERFACE call: java.util.concurrent.Executor.execute(java.lang.Runnable):void A[MD:(java.lang.Runnable):void (c)] (LINE:8) in method: com.google.android.gms.internal.ads.zzcro.zzb(java.lang.Object):void, file: classes.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:94)
            	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
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
            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: com.google.android.gms.internal.ads.zzcrj.<init>(com.google.android.gms.internal.ads.zzcrp):void, class status: GENERATED_AND_UNLOADED
            	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:309)
            	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:829)
            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:730)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:418)
            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:145)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:121)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:108)
            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:1143)
            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:910)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:422)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:303)
            	... 35 more
            */
        /*
            this = this;
            com.google.android.gms.internal.ads.zzcrp r0 = r1.zzb
            com.google.android.gms.internal.ads.zzcra r2 = (com.google.android.gms.internal.ads.zzcra) r2
            com.google.android.gms.internal.ads.zzcrp.zzd(r0)
            com.google.android.gms.internal.ads.zzgdj r0 = r1.zza
            r0.zzb(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcro.zzb(java.lang.Object):void");
    }
}
