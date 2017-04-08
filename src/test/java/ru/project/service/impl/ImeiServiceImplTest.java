package ru.project.service.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import ru.project.exception.GroupNotFoundException;
import ru.project.repository.ImeiRepository;

import static org.mockito.Mockito.when;

/**
 * Тест
 * Created by aw on 08.04.2017.
 */

@RunWith(MockitoJUnitRunner.class)
public class ImeiServiceImplTest {

    @InjectMocks
    private ImeiServiceImpl imeiService;

    @Mock
    private ImeiRepository imeiRepository;

    @Before
    public void init() {
        imeiService = new ImeiServiceImpl();
    }

    @Test
    public void testGetGroupByImei() {
        MockitoAnnotations.initMocks(this);
        when(imeiRepository.getGroup("11223344")).thenReturn("TEST_GROUP");

        String group = imeiService.getGroupByImei("112233440000000");
        Assert.assertEquals("TEST_GROUP", group);
    }

    @Test(expected = GroupNotFoundException.class)
    public void testGetGroupByImeiNotFound() {
        MockitoAnnotations.initMocks(this);
        when(imeiRepository.getGroup("11223344")).thenReturn("TEST_GROUP");
        imeiService.getGroupByImei("5432100000000");
    }
}