package pl.mw.zuul.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Foo {
    private long id;
    private String name;

    public Foo(long parseLong, String randomAlphabetic) {
        setId(parseLong);
        setName(randomAlphabetic);
    }
}
