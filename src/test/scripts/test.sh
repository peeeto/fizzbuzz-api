#!/bin/bash
URLS=("http://localhost:8080/fizzbuzz-api/fizzbuzz" "http://fizzbuzz-api.cfapps.io/fizzbuzz-api/fizzbuzz" "http://fizzbuzz-api.herokuapp.com/fizzbuzz-api/fizzbuzz")
for URL in "${URLS[@]}"
do
  echo "URL: ${URL}"
  curl "${URL}?numbers=1,15,222;3333|44444" && echo OK || echo FAIL
  curl -XPOST -H 'Content-Type: application/json' -H 'Accept: application/json' -H 'Accept-Language: en' -d '{"numbers":[1,15,222,3333,44444]}' "${URL}" && echo OK || echo FAIL
  curl -XPOST -H 'Content-Type: application/json' -H 'Accept: application/json' -H 'Accept-Language: en' -d '{"numbers":["1","15","222","3333","44444"]}' "${URL}" && echo OK || echo FAIL
  curl -XPOST -H 'Content-Type: application/json' -H 'Accept: application/json' -H 'Accept-Language: en' -d '{"numbers":["1",15,222,"3333",44444]}' "${URL}" && echo OK || echo FAIL
  echo
done
