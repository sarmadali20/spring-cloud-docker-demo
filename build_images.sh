cd dashboard
mvn clean install
mvn docker:build
cd ../
cd edge
mvn clean install
mvn docker:build
cd ../
cd eureka
mvn clean install
mvn docker:build
cd ../
cd notes_ms
mvn clean install
mvn docker:build
cd ../
