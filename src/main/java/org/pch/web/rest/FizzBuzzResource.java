package org.pch.web.rest;

import org.pch.service.FizzBuzzService;
import org.pch.web.rest.dto.FizzBuzzReq;
import org.pch.web.rest.dto.FizzBuzzRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping(value = "/")
public class FizzBuzzResource {

  public static final String REQUEST_FIZZBUZZ = "/fizzbuzz-api/fizzbuzz";

  @Autowired
  private FizzBuzzService fizzBuzzService;

  @RequestMapping(value = REQUEST_FIZZBUZZ, method = RequestMethod.POST)
  public ResponseEntity<FizzBuzzRes> fizzbuzzPost(@RequestBody FizzBuzzReq message) {
    FizzBuzzRes res = new FizzBuzzRes(fizzBuzzService.calculateFizzBuzz(message.getNumbers()));
    return new ResponseEntity<>(res, HttpStatus.CREATED);
  }

  @RequestMapping(value = REQUEST_FIZZBUZZ, method = RequestMethod.GET)
  public ResponseEntity<FizzBuzzRes> fizzbuzzGet(@RequestParam(value = "numbers", defaultValue = "") String numbers) {
    FizzBuzzRes res = new FizzBuzzRes(fizzBuzzService.calculateFizzBuzz(numbers));
    return new ResponseEntity<>(res, HttpStatus.CREATED);
  }

  @RequestMapping(value = "/", method = RequestMethod.GET)
  public void root(HttpServletResponse response) throws IOException {
    response.sendRedirect(REQUEST_FIZZBUZZ);
  }

}
