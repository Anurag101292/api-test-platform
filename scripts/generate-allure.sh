#!/usr/bin/env bash
# Simple helper to generate Allure report from ./allure-results
# Usage: ./scripts/generate-allure.sh

set -euo pipefail

RESULTS_DIR="$(pwd)/allure-results"
REPORT_DIR="$(pwd)/target/allure-report"

if [ ! -d "$RESULTS_DIR" ]; then
  echo "No allure-results directory found at $RESULTS_DIR"
  exit 1
fi

if command -v allure >/dev/null 2>&1; then
  echo "Using system 'allure' command to generate report"
  allure generate "$RESULTS_DIR" -o "$REPORT_DIR" || { echo "allure generate failed"; exit 2; }
  echo "Report generated at $REPORT_DIR/index.html"
  exit 0
fi

# If Allure CLI not installed, provide instructions
cat <<'EOF'
Allure CLI not found on PATH.
Install it via Homebrew (macOS):
  brew install allure

Or download binary from https://github.com/allure-framework/allure2/releases and unpack to a folder in PATH.

After installation, run:
  allure generate ./allure-results -o ./target/allure-report
  allure open ./target/allure-report

If running on Java 11+ and you see errors about javax.xml.bind, install JAXB runtime:
  brew install openjdk@8   # or use a Java 8 installation
  or add 'org.glassfish.jaxb:jaxb-runtime' to the classpath when running allure commandline

This script cannot auto-download Allure CLI in this environment. Please install Allure and re-run.
EOF

exit 3

