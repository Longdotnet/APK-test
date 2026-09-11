param(
    [string]$DestinationDirectory = (Join-Path $env:RUNNER_TEMP 'basic-pitch')
)

$ErrorActionPreference = 'Stop'

$expectedBlob = 'c30e5f9438e798604b7177aa26be1fe64482f767'
$expectedLength = 230444
$sourceUrl = 'https://raw.githubusercontent.com/spotify/basic-pitch/fa5997af0a8210982619003269994a1be25eddf3/basic_pitch/saved_models/icassp_2022/nmp.onnx'

New-Item -ItemType Directory -Force -Path $DestinationDirectory | Out-Null
$modelPath = Join-Path $DestinationDirectory 'nmp.onnx'
Invoke-WebRequest -Uri $sourceUrl -OutFile $modelPath

$blob = (git hash-object $modelPath).Trim()
if ($blob -ne $expectedBlob) {
    throw "Basic Pitch model provenance check failed. Expected git blob $expectedBlob, got $blob."
}

$length = (Get-Item $modelPath).Length
if ($length -ne $expectedLength) {
    throw "Basic Pitch model size check failed. Expected $expectedLength bytes, got $length."
}

if ([string]::IsNullOrWhiteSpace($env:GITHUB_ENV)) {
    throw 'GITHUB_ENV is unavailable; refusing to prepare an untracked production model path.'
}

"BASIC_PITCH_MODEL_PATH=$modelPath" | Out-File -FilePath $env:GITHUB_ENV -Encoding utf8 -Append
Write-Host "Pinned Spotify Basic Pitch model verified: blob=$blob bytes=$length"
