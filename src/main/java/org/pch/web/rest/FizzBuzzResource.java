package org.pch.web.rest;

import org.pch.service.FizzBuzzService;
import org.pch.web.rest.dto.FizzBuzzReq;
import org.pch.web.rest.dto.FizzBuzzRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/fizzbuzz-api")
public class FizzBuzzResource {

  @Autowired
  private FizzBuzzService fizzBuzzService;

  @RequestMapping(value = "/fizzbuzz", method = RequestMethod.POST)
  public ResponseEntity<FizzBuzzRes> fizzbuzzPost(@RequestBody FizzBuzzReq message) {
    FizzBuzzRes res = new FizzBuzzRes(fizzBuzzService.calculateFizzBuzz(message.getNumbers()));
    return new ResponseEntity<>(res, HttpStatus.CREATED);
  }

  @RequestMapping(value = "/fizzbuzz", method = RequestMethod.GET)
  public ResponseEntity<FizzBuzzRes> fizzbuzzGet(@RequestParam(value = "numbers") String numbers) {
    FizzBuzzRes res = new FizzBuzzRes(fizzBuzzService.calculateFizzBuzz(numbers));
    return new ResponseEntity<>(res, HttpStatus.CREATED);
  }

}
