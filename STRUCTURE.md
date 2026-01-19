# Project structure (template)

Instructions to produce an accurate structure locally:
- If you have `tree` installed:
  - cd /Users/anuragupadhyay/Documents/api-test-platform
  - tree -a -I 'node_modules|.git' -L 4 > structure.txt
  - paste the contents of `structure.txt` here or replace the diagram below.
- Fallback without `tree`:
  - cd /Users/anuragupadhyay/Documents/api-test-platform
  - find . -maxdepth 4 | sed 's|[^/]*/|  |g' > structure.txt
  - paste the contents of `structure.txt` here or replace the diagram below.

Actual project structure (generated):

/api-test-platform
├─ pom.xml
├─ STRUCTURE.md
├─ src
│  ├─ main
│  │  ├─ java
│  │  │  └─ org
│  │  │     └─ example
│  │  │        ├─ Main.java
│  │  │        ├─ core
│  │  │        │  ├─ auth/
│  │  │        │  ├─ config/
│  │  │        │  │  └─ ConfigManager.java
│  │  │        │  ├─ context/
│  │  │        │  ├─ db/
│  │  │        │  ├─ env/
│  │  │        │  ├─ event/
│  │  │        │  ├─ http/
│  │  │        │  │  ├─ HttpClient.java
│  │  │        │  │  └─ impl/
│  │  │        │  │     └─ RestAssuredHttpClient.java
│  │  │        │  ├─ plugin/
│  │  │        │  ├─ report/
│  │  │        │  └─ retry/
│  │  │        ├─ engine
│  │  │        │  ├─ assertion/
│  │  │        │  ├─ data/
│  │  │        │  ├─ flow/
│  │  │        │  ├─ mock/
│  │  │        │  └─ schema/
│  │  │        ├─ model
│  │  │        │  ├─ internal/
│  │  │        │  │  └─ HttpMethod.java
│  │  │        │  ├─ request/
│  │  │        │  │  └─ ApiRequest.java
│  │  │        │  └─ response/
│  │  │        │     └─ ApiResponse.java
│  │  │        ├─ repository/
│  │  │        ├─ service
│  │  │        │  └─ booking/
│  │  │        └─ util/
│  │  └─ resources
│  │     ├─ config.yaml
│  │     └─ logback.xml
│  └─ test
│     ├─ java
│     │  └─ org
│     │     └─ example
│     │        ├─ base/
│     │        ├─ suites/
│     │        └─ tests/
│     └─ resources
│        └─ config.yaml
└─ target
   ├─ classes
   │  ├─ config.yaml
   │  ├─ logback.xml
   │  └─ org
   │     └─ example
   │        ├─ Main.class
   │        └─ core
   │           └─ config
   │              └─ ConfigManager.class
   └─ generated-sources
      └─ annotations

Notes:
- This diagram reflects current files and packages under `src/main/java/org/example` and `src/test/java/org/example`.
- If you want the tree in a different format or to include deeper levels, I can regenerate it.

Placeholder / example structure (original):

/placeholder - replaced with actual structure above

Notes:
- Replace the placeholder tree above with your real `tree` output to capture the exact structure.
- If you want, paste the `tree` output here or add the repository files to the working set and I will update this file with the exact diagram.
