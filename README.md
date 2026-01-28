# 📘 API Test Platform

> A **scalable, modular, future-ready API automation framework platform** built in Java.  
> Designed with **clean architecture, pluggable engines, and tool-independent core**.

---

## 🎯 Project Goal

This project is **not a simple RestAssured test project**.

It is a:

> 🏗️ **Test Automation Platform**

Which means:

- Core logic is **tool-independent**
- Tools (RestAssured, WireMock, DB, etc.) are **adapters/plugins**
- Framework supports:
    - Data-driven testing
    - Schema validation
    - Custom assertion engine
    - Plugins
    - Events
    - Context management
    - Future AI integration

---

## 🧠 Architecture Principles

- ✅ Clean separation of concerns
- ✅ Core platform does NOT depend on tools
- ✅ Tools depend on platform
- ✅ Everything is:
    - Replaceable
    - Pluggable
    - Extendable


## Project structure (detailed)

Below is the canonical architecture layout used by the project. Add new modules or packages to these folders following the same conventions.
/api-test-platform
├── .gitignore
├── pom.xml
├── README.md
├── STRUCTURE.md
├── allure-results/
│   ├── allure.properties
│   ├── 0105b7f5-2aa1-4947-b91e-65a38830876b-container.json
│   ├── 02a9a979-cab7-478f-812f-4b5b61022e74-container.json
│   ├── 04390918-bc17-46d6-8983-d4217ee994f3-result.json
│   ├── ... (multiple result and container json files)
│   └── 6e33a440-4081-43b1-8c09-e6ee6874d87b-result.json
├── scripts/
│   └── generate-allure.sh
├── src/
│   ├── main/
│   │   ├── java/org/example/
│   │   │   ├── core/
│   │   │   │   ├── auth/
│   │   │   │   │   └── .gitkeep
│   │   │   │   ├── config/
│   │   │   │   │   ├── .gitkeep
│   │   │   │   │   └── ConfigManager.java
│   │   │   │   ├── context/
│   │   │   │   │   ├── .gitkeep
│   │   │   │   │   └── TestExecutionContext.java
│   │   │   │   ├── db/
│   │   │   │   │   └── .gitkeep
│   │   │   │   ├── env/
│   │   │   │   │   └── .gitkeep
│   │   │   │   ├── event/
│   │   │   │   │   ├── .gitkeep
│   │   │   │   │   ├── Event.java
│   │   │   │   │   ├── EventBus.java
│   │   │   │   │   ├── EventListener.java
│   │   │   │   │   └── events/
│   │   │   │   │       ├── ApiRequestFinishedEvent.java
│   │   │   │   │       ├── ApiRequestStartedEvent.java
│   │   │   │   │       ├── FrameworkStartedEvent.java
│   │   │   │   │       └── FrameworkStoppedEvent.java
│   │   │   │   ├── http/
│   │   │   │   │   ├── .gitkeep
│   │   │   │   │   ├── HttpClient.java
│   │   │   │   │   └── impl/
│   │   │   │   │       └── RestAssuredHttpClient.java
│   │   │   │   ├── plugin/
│   │   │   │   │   ├── .gitkeep
│   │   │   │   │   ├── PlugIn.java
│   │   │   │   │   └── PluginManager.java
│   │   │   │   ├── report/
│   │   │   │   │   └── .gitkeep
│   │   │   │   └── retry/
│   │   │   │       └── .gitkeep
│   │   │   ├── engine/
│   │   │   │   ├── data/
│   │   │   │   │   ├── .gitkeep
│   │   │   │   │   ├── DataProviderFactory.java
│   │   │   │   │   ├── JsonDataProvider.java
│   │   │   │   │   ├── TestData.java
│   │   │   │   │   └── TestDataProvider.java
│   │   │   │   ├── flow/
│   │   │   │   │   └── .gitkeep
│   │   │   │   ├── mock/
│   │   │   │   │   └── .gitkeep
│   │   │   │   └── schema/
│   │   │   │       ├── .gitkeep
│   │   │   │       ├── JsonSchemaValidator.java
│   │   │   │       ├── SchemaValidationResult.java
│   │   │   │       ├── SchemaValidator.java
│   │   │   │       └── SchemaValidatorFactory.java
│   │   │   ├── model/
│   │   │   │   ├── internal/
│   │   │   │   │   └── HttpMethod.java
│   │   │   │   ├── request/
│   │   │   │   │   ├── .gitkeep
│   │   │   │   │   └── ApiRequest.java
│   │   │   │   └── response/
│   │   │   │       ├── .gitkeep
│   │   │   │       └── ApiResponse.java
│   │   │   ├── repository/
│   │   │   │   └── .gitkeep
│   │   │   ├── service/
│   │   │   │   ├── auth/
│   │   │   │   │   ├── AuthService.java
│   │   │   │   │   └── impl/
│   │   │   │   │       └── AuthServiceImpl.java
│   │   │   │   ├── booking/
│   │   │   │   │   ├── .gitkeep
│   │   │   │   │   ├── BookingService.java
│   │   │   │   │   └── impl/
│   │   │   │   │       └── BookingServiceImpl.java
│   │   │   └── util/
│   │   │       ├── .gitkeep
│   │   │       ├── FileUtils.java
│   │   │       ├── JsonUtils.java
│   │   │       ├── RandomDataUtils.java
│   │   │       ├── ResourceUtils.java
│   │   │       └── TimeUtils.java
│   │   └── resources/
│   │       ├── config.yaml
│   │       ├── logback.xml
│   │       ├── testdata.json
│   │       └── schemas/
│   │           └── user.json
│   └── test/
│       ├── java/org/example/
│       │   ├── base/
│       │   │   ├── .gitkeep
│       │   │   └── BaseTest.java
│       │   ├── suites/
│       │   │   └── .gitkeep
│       │   └── tests/
│       │       ├── .gitkeep
│       │       ├── DataEngineSanityTest.java
│       │       ├── PlatformSanityTest.java
│       │       ├── SchemaEngineSanityTest.java
│       │       ├── UtilitySanityTest.java
│       │       ├── auth/
│       │       │   └── AuthTokenTest.java
│       │       ├── booking/
│       │       │   ├── BookingE2ETest.java
│       │       │   └── CreateBookingTest.java
│       │       ├── listeners/
│       │       │   ├── FrameworkStartedLogger.java
│       │       │   └── FrameworkStoppedLogger.java
│       │       └── plugins/
│       │           ├── AllureReportingPlugin.java
│       │           ├── ApiLoggingPlugin.java
│       │           ├── LifecycleLoggingPlugin.java
│       │           └── RetryPlugin.java
│       └── resources/
│           └── testng.xml
---

## ✅ What Is Already Implemented

---

### 1️⃣ Config System

- YAML-based configuration
- `ConfigManager` loads config from:
- Supports:
- Environment switching
- Nested config keys
- Centralized config access

Usage:

```java
ConfigManager.getEnv();
ConfigManager.get("qa.baseUrl");


2️⃣ TestExecutionContext (Runtime Container)

Acts like a lightweight dependency container.

Stores:

Runtime objects

Shared resources

Tokens, clients, plugins, DB connections (future)

Usage:

TestExecutionContext.put("token", token);
String token = TestExecutionContext.get("token");

3️⃣ Event System

Event-driven architecture

Components can:

Publish events

Listen to events

Decouples core logic from extensions

Components:

Event

EventListener

EventBus

4️⃣ Plugin System

Supports:

Modular features

Lifecycle control (start/stop)

Plugins can:

Register listeners

Initialize resources

Store things in context

Components:

Plugin

PluginManager

5️⃣ Utility Layer

Central reusable utilities:

ResourceUtils → load classpath resources

FileUtils → read files from resources

JsonUtils → JSON serialize/deserialize (Jackson)

RandomDataUtils → random strings, numbers

TimeUtils → timestamps, sleep

6️⃣ Data Engine (Test Data Abstraction)

Tests do NOT care where data comes from.

Components:

TestData → wrapper over Map

TestDataProvider → interface

JsonDataProvider → implementation

DataProviderFactory → entry point

Test data file:

src/test/resources/testdata.json


Usage:

TestData data = DataProviderFactory.get().get("createBooking");
data.getString("firstname");
data.getInt("price");

7️⃣ Schema Engine (JSON Schema Validation)

Framework-level schema validation, not coupled to RestAssured.

Components:

SchemaValidator

JsonSchemaValidator (networknt 2.x)

SchemaValidationResult

SchemaValidatorFactory

Schemas stored in:

src/main/resources/schemas/


Usage:

SchemaValidationResult result =
    SchemaValidatorFactory.get().validate(json, "schemas/user.json");

8️⃣ Assertion Engine (Framework-Owned)

Tests should NOT use TestNG/JUnit assertions directly.

Components:
AssertionType
AssertionResult
AssertEngine
Assertions (facade)
Supports:
assertEquals
assertNotNull
assertTrue
assertFalse
assertSchema
Usage:

Assertions.assertEquals(a, b, "values should match");
Assertions.assertSchema(result, "schema should be valid");

9️⃣ Test Lifecycle (BaseTest)

Centralized:
Framework startup
Plugin startup
Engine initialization
Framework shutdown
All tests extend:

BaseTest
🧪 Current Tests (Sanity)
UtilitySanityTest
DataEngineSanityTest
SchemaEngineSanityTest
AssertionEngineSanityTest

All are:
✅ Platform capability tests
❌ No API calls yet

🧱 What Is NOT Built Yet (Next Steps)
⏳ HTTP Engine (RestAssured adapter)
⏳ Request / Response model
⏳ Service layer
⏳ Flow engine
⏳ Mock engine (WireMock)
⏳ DB engine
⏳ Reporting plugins
⏳ AI diagnostics plugin
🚀 Roadmap

HTTP Engine (RestAssured adapter)
Service abstraction layer
Flow engine
Mock engine
DB engine
Reporting plugin
AI diagnostics plugin

## Generating Allure reports

If you already have `allure-results/` (the test run artifacts) in the project root, you can generate an HTML report using the Allure CLI.

Preferred (if you have Allure installed):

```bash
allure generate ./allure-results -o ./target/allure-report
allure open ./target/allure-report
```

Quick helper script (macOS/Linux):

```bash
./scripts/generate-allure.sh
```

Common issue on Java 11+:
- The Allure commandline may fail with `NoClassDefFoundError: javax/xml/bind/annotation/XmlElement`. This happens because JAXB (javax.xml.bind) was removed from the JDK since Java 11. Solutions:
  - Install Allure CLI via Homebrew which bundles a compatible commandline: `brew install allure` (macOS).
  - Use Java 8 to run the Allure commandline, or install `org.glassfish.jaxb:jaxb-runtime` and run the commandline with that on the classpath (advanced).

Note: The project includes the Allure TestNG adapter dependency. The Maven plugin `io.qameta.allure:allure-maven` may be used if you prefer generating reports via Maven; however plugin resolution and the commandline it downloads can fail under Java 11 unless Allure CLI or JAXB is available. Using the system `allure` CLI is most robust.

