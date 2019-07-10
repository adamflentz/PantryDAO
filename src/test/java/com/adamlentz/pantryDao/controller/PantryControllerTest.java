package com.adamlentz.pantryDao.controller;

import com.adamlentz.pantryDao.repositories.PantryRepository;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PantryControllerTest {

    @Mock
    PantryRepository pantryRepository;

    @InjectMocks
    PantryController pantryController;
}
