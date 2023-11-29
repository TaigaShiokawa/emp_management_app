package model.test;

import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;

import model.map.PostMap;

public class PostMapTest {

    @Test
    public void whenKnownIdThenReturnsPost() {
        assertEquals("一般社員", PostMap.getpost(1));
        assertEquals("主任", PostMap.getpost(2));
        assertEquals("係長", PostMap.getpost(3));
        assertEquals("課長", PostMap.getpost(4));
    }

    @Test
    public void whenUnknownIdThenReturnsDefault() {
        assertEquals("一般社員", PostMap.getpost(999));
    }

}
