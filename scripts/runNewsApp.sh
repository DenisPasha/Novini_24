SCRIPT_DIR=$(dirname "$0")


PROJECT_DIR="Novini_24"

# Set the name of your Spring Boot JAR file
JAR_FILE="Novini_24-0.0.1-SNAPSHOT.jar"

# Navigate to the project directory
PROJECT_DIR="$SCRIPT_DIR/.."

cd "$PROJECT_DIR" || exit

# Build and install the Spring Boot project using Maven
mvn clean install

# Check if the JAR file exists
if [ ! -f "target/$JAR_FILE" ]; then
   echo "Error: $JAR_FILE not found."
   exit 1
fi

# Run the Spring Boot application
java -jar "target/$JAR_FILE"
