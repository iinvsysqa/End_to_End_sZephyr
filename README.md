# End-to-End sZephyr Test Scripts

This repository contains **End-to-End Test Scripts** for the sZephyr application, used for testing various features of the sZephyr platform.

## Prerequisites

- Java 8 or higher
- Maven (for dependency management)
- TestNG (for running tests)

## Repository Structure

- **src/test**: Contains all test scripts
- **test-output**: Output logs and results from test executions
- **config.properties**: Configuration for setting environment variables
- **pom.xml**: Maven configuration file
- **testng.xml**: TestNG configuration for organizing test suites

## Setup Instructions

1. Clone the repository:
   ```bash
   git clone https://github.com/iinvsysqa/End_to_End_sZephyr.git
   cd End_to_End_sZephyr

   Install dependencies using Maven:

2. Running the Tests
To execute the test suite, run the following Maven command:

mvn test -DsuiteXmlFile=testng.xml
