package model.test;

import static org.junit.Assert.*;

import org.junit.Test;

import model.map.DepartmentMap;

public class DepartmentMaoTest {

	@Test
    public void whenKnownIdThenReturnsDepartment() {
        assertEquals("企画課", DepartmentMap.getDepartment(1));
        assertEquals("情報システム課", DepartmentMap.getDepartment(2));
        assertEquals("財務課", DepartmentMap.getDepartment(3));
    }

    @Test
    public void whenUnknownIdThenReturnsDefault() {
        assertEquals("無所属", DepartmentMap.getDepartment(999));
    }

}
