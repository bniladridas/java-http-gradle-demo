# Java HTTP Gradle Demonstration

A refined Gradle-managed Java endeavor exemplifying HTTP API client utilization with elegant separation of concerns.

## Structure

- `api/`: HTTP client implementation
- `model/`: Data models of distinction
- `service/`: Business logic orchestration
- `Main.java`: Principal demonstration entry point

## Prerequisites

- Java 17: One may procure via `brew install openjdk@17` (macOS) or from the [Adoptium](https://adoptium.net/) repository
- Gradle: Acquire through `brew install gradle` (macOS) or employ the included wrapper `./gradlew`

Kindly ensure Java 17 resides within your PATH. On macOS, append to ~/.zshrc:
```bash
export PATH="/opt/homebrew/opt/openjdk@17/bin:$PATH"
```

## Usage

```bash
./gradlew build    # Assemble the project
./gradlew run      # Execute the demonstration
./gradlew dependencyUpdates  # Inspect for updates
```
