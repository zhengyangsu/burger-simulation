# Burger Simulation

This is a Java-based burger-making simulation project (Eclipse-style project) containing source code, assets, and libraries needed to build and run the simulation.

## Summary

- Project files are in the `burger-simulation` subfolder.
- Key folders:
  - `src/assets/` — images & sound files used by the app (png, wav, fonts).
  - `src/button/`, `src/main/`, `src/fx/`, `src/sound/`, `src/util/` — Java packages with source code.
  - `src/lib/` — third-party JARs required at runtime (core.jar, minim, mp3spi, tritonus, etc.).
  - `.classpath`, `.project`, `.settings/` — Eclipse project metadata.

## Requirements

- Java JDK (8 or newer recommended).
- No build system is included; project is set up for Eclipse/IDE usage.

## Recommended: Open in an IDE (Eclipse / IntelliJ)

1. Open your IDE and choose "Import > Existing project" (Eclipse) or "Open" (IntelliJ).
2. If required, add all JARs from `src/lib/` to the project's classpath/module dependencies.
3. Run the main application class: `BurgerApp` (found in `src/main/`).

## Quick command-line (example)

From the `burger-simulation` project folder (adjust paths if necessary):

- Compile (example, Windows PowerShell/CMD):
  javac -cp "src\lib\*;" -d out src\\**\\*.java

- Run (example):
  java -cp "out;src\lib\*" BurgerApp

Note: If the source files use package declarations, include the package-qualified main class name when running (e.g., `com.example.BurgerApp`). Using an IDE is simpler.

## Notes

- Audio playback uses third-party audio libraries in `src/lib/` (Minim/tritonus). Ensure those JARs are present on the runtime classpath.
- Assets are loaded from `src/assets/`. Run the app from the project root or configure your IDE so the working directory includes the `src/assets` path.

## Licensing

No license included.
