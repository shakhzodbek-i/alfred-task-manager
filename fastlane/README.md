fastlane documentation
----

# Installation

Make sure you have the latest version of the Xcode command line tools installed:

```sh
xcode-select --install
```

For _fastlane_ installation instructions, see [Installing _fastlane_](https://docs.fastlane.tools/#installing-fastlane)

# Available Actions

## Android

### android runTests

```sh
[bundle exec] fastlane android runTests
```

Runs all the tests

### android getLatestVersionAndUpgrade

```sh
[bundle exec] fastlane android getLatestVersionAndUpgrade
```

Get latest build version from Firebase App Distribution

### android uploadApkToFirebase

```sh
[bundle exec] fastlane android uploadApkToFirebase
```

Upload release apk on firebase app distribution

----

This README.md is auto-generated and will be re-generated every time [_fastlane_](https://fastlane.tools) is run.

More information about _fastlane_ can be found on [fastlane.tools](https://fastlane.tools).

The documentation of _fastlane_ can be found on [docs.fastlane.tools](https://docs.fastlane.tools).
