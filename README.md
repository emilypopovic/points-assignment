<h2>Points Assignment</h2>

- Install Java 8, Node.js 8, and Yarn

<hr>
<h3>How to run program</h3>

Docker:

`docker run --init -p 5000:5000 -it ptsdocker16/interview-test-server`

Backend:

`./mvnw spring-boot:run`

Frontend:

`cd src/main/ui/app/`

`yarn start`

Then will open up to localhost webpage home

<hr/>

<h3>How to run tests via Maven</h3>

`mvn clean`

`mvn install`

`mvn test`

Run single test class:

`mvn -Dtest=className test` where className is the class file you want to run the tests for