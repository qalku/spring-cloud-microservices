package pl.mw.zuul.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import pl.mw.zuul.model.Foo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.apache.commons.lang.RandomStringUtils.randomAlphabetic;
import static org.apache.commons.lang.RandomStringUtils.randomNumeric;


@RestController
public class FooController {

    @GetMapping("/foos/{id}")
    public Foo findById(
            @PathVariable long id, HttpServletRequest req, HttpServletResponse res) {
        return new Foo(Long.parseLong(randomNumeric(2)), randomAlphabetic(4)
        );
    }
}
