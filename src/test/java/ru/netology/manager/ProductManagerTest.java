package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)

public class ProductManagerTest {

    @Mock
            private ProductRepository repository;

    @InjectMocks
            ProductManager manager;

    Product first = new Book(1, "Anna Karenina", 1, "Tolstoy");
    Product second = new Book(2, "Lolita", 2, "Nabokov");
    Product third = new Smartphone(3, "HRY-LX1T", 3, "Honor");
    Product forth = new Smartphone(4, "ANE-LX1", 4, "Huawei");

    @BeforeEach
    public void SetUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(forth);
    }

    @Test
    public void searchByBookName() {
        Product[] returned = new Product[] {first, second, third, forth};
        doReturn(returned).when(repository).findAll();
        Product[] actual = manager.searchBy("Anna Karenina");
        Product[] expected = new Product[] {first};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void searchByBookAuthor() {
        Product[] returned = new Product[] {first, second, third, forth};
        doReturn(returned).when(repository).findAll();
        Product[] actual = manager.searchBy("Nabokov");
        Product[] expected = new Product[] {second};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void searchBySmartphoneName() {
        Product[] returned = new Product[] {first, second, third, forth};
        doReturn(returned).when(repository).findAll();
        Product[] actual = manager.searchBy("HRY-LX1T");
        Product[] expected = new Product[] {third};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void searchBySmartphoneManufacturer() {
        Product[] returned = new Product[] {first, second, third, forth};
        doReturn(returned).when(repository).findAll();
        Product[] actual = manager.searchBy("Huawei");
        Product[] expected = new Product[] {forth};
        assertArrayEquals(expected, actual);
    }

}