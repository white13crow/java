MedicalCenter LR7 - Serialization (JSON & YAML)
-----------------------------------------------

How to build and run:

- Using Gradle (if installed):
  gradle clean build
  gradle run

- Or open the project in IntelliJ/VS Code and run the main class: ua.app.MainLR7

What is included:
- Entities: Patient, Doctor (records)
- Repositories for each entity
- SerializationService (JSON + YAML) with JavaTimeModule
- config.properties for file paths and test data count
- DataSerializationException for unified error handling
- Unit tests with JUnit 5 (round-trip JSON/YAML)
