# Java HTTP Gradle Demo

A Gradle-managed Java project demonstrating HTTP API client usage with clean separation of concerns.

## Structure

- `api/`: HTTP client
- `model/`: Data models
- `service/`: Business logic
- `Main.java`: Demo entry point

## Prerequisites

- Java 17: Install with `brew install openjdk@17` (macOS) or download from [Adoptium](https://adoptium.net/)
- Gradle: Install with `brew install gradle` (macOS) or use the included wrapper `./gradlew`

Ensure Java 17 is in your PATH. On macOS, add to ~/.zshrc:
```bash
export PATH="/opt/homebrew/opt/openjdk@17/bin:$PATH"
```

## Usage

```bash
./gradlew build    # Build project
./gradlew run      # Run demo
./gradlew dependencyUpdates  # Check updates
```