#!/usr/bin/env bash
set -euo pipefail

SRC_FILE="sc"
OUT_DIR="dist"
OUT_FILE="$OUT_DIR/index.html"

if [[ ! -f "$SRC_FILE" ]]; then
  echo "Source file '$SRC_FILE' not found." >&2
  exit 1
fi

if [[ ! -s "$SRC_FILE" ]]; then
  echo "Source file '$SRC_FILE' is empty." >&2
  exit 1
fi

mkdir -p "$OUT_DIR"
cp "$SRC_FILE" "$OUT_FILE"

echo "Built $OUT_FILE from $SRC_FILE"
