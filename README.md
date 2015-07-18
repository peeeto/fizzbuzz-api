# fizzbuzz-api

## clone 
>git clone https://github.com/peeeto/fizzbuzz-api.git

## build locally
>mvn clean install

## start local
>mvn spring-boot:run
>
>java -jar target/fizzbuzz-api-1.0.0-SNAPSHOT.jar
>
>PORT=8080 foreman start
>
>http://localhost:8080/fizzbuzz-api/fizzbuzz?numbers=1,15,222;3333|44444

## start heroku remote
>heroku login
>
>git push heroku master
>
>heroku logs --tail --app fizzbuzz-api
>
>heroku ps:scale web=1 --app fizzbuzz-api
>
>heroku ps --app fizzbuzz-api
>
>http://fizzbuzz-api.herokuapp.com/fizzbuzz-api/fizzbuzz?numbers=1,15,222;3333|44444

## start cloudfoundry remote
>cf login -a https://api.run.pivotal.io
>
>Email: p xxx z
>
>Password: ••••••••
>
>cf push fizzbuzz-api -p target/fizzbuzz-api-1.0.0-SNAPSHOT.jar
>
>cf apps
>
>http://fizzbuzz-api.cfapps.io/fizzbuzz-api/fizzbuzz?numbers=1,15,222;3333|44444

## run tests
> bash -x src/test/scripts/test.sh

[![codeship - fizzbuzz-api](https://codeship.com/projects/12a96f00-0f9d-0133-d4b2-1e6fe7bb1028/status?branch=master)]

[![Heroku](http://heroku-badge.herokuapp.com/?app=fizzbuzz-api&style=flat)]

[![Heroku](http://heroku-badge.herokuapp.com/?app=fizzbuzz-api&root=projects.html)]
