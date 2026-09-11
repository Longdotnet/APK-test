# Microsoft ONNX Runtime

RobloxPiano uses Microsoft ONNX Runtime for native .NET inference of the Basic Pitch ONNX model.

- Upstream: `microsoft/onnxruntime`
- NuGet package: `Microsoft.ML.OnnxRuntime` 1.29.0
- License: MIT
- Copyright: Microsoft Corporation and contributors
- Purpose here: CPU ONNX inference with reusable `InferenceSession` and managed tensor buffers.

No ONNX Runtime training stack or Python runtime is required by this integration. Canonical performance state and Roblox playback remain repository-owned deterministic components.

When ONNX Runtime binaries are distributed with the client, retain the upstream MIT copyright and permission notice as required by the license.
