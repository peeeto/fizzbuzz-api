# fizzbuzz-api

## clone 
>git clone https://github.com/peeeto/fizzbuzz-api.git

## build locally
>mvn clean install

## start local
>mvn spring-boot:run
>
>java -jar target/fizzbuzz-api-1.0.0-SNAPSHOT.jar

## test local
>export URL="http://localhost:8080/fizzbuzz-api/fizzbuzz"
>
>curl "${URL}?numbers=1,2;33|444"
>
>curl -XPOST -H 'Content-Type: application/json' -H 'Accept: application/json' -H 'Accept-Language: en' -d '{"numbers":[1,15,22,333,4444]}' "${URL}"
>
>curl -XPOST -H 'Content-Type: application/json' -H 'Accept: application/json' -H 'Accept-Language: en' -d '{"numbers":["1","15","22","333","4444"]}' "${URL}"
>
>curl -XPOST -H 'Content-Type: application/json' -H 'Accept: application/json' -H 'Accept-Language: en' -d '{"numbers":["1",15, 2,"33",444]}' "${URL}"

## start remote
>cf login -a https://api.run.pivotal.io
>
>Email: p xxx z
>
>Password: ••••••••
>
>cf push fizzbuzz-api -p target/fizzbuzz-api-1.0.0-SNAPSHOT.jar
>
>cf apps

## test remote
>export URL="http://fizzbuzz-api.cfapps.io/fizzbuzz-api/fizzbuzz"
>
>curl "${URL}?numbers=1,2;33|444"
>
>curl -XPOST -H 'Content-Type: application/json' -H 'Accept: application/json' -H 'Accept-Language: en' -d '{"numbers":[1,15,22,333,4444]}' "${URL}"
>
>curl -XPOST -H 'Content-Type: application/json' -H 'Accept: application/json' -H 'Accept-Language: en' -d '{"numbers":["1","15","22","333","4444"]}' "${URL}"
>
>curl -XPOST -H 'Content-Type: application/json' -H 'Accept: application/json' -H 'Accept-Language: en' -d '{"numbers":["1",15, 2,"33",444]}' "${URL}"

https://travis-ci.org/peeeto/fizzbuzz-api.svg
