package ru.pk.testpg1;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import ru.pk.testpg1.copy.so.ServiceOrderReadSrc;
import ru.pk.testpg1.model.modelsrc.ServiceOrderOra;
import ru.pk.testpg1.repository.reposdsc.ServiceOrderPgRepository;
import ru.pk.testpg1.repository.repossrc.ServiceOrderOraRepository;

@EnableTransactionManagement
@SpringBootTest
class Testpg1ApplicationTests {

    @Autowired
    private ServiceOrderOraRepository serviceOrderOraRepository;
    @Autowired
    private ServiceOrderPgRepository serviceOrderPgRepository;
    @Autowired
    private ServiceOrderReadSrc serviceOrderReadSrc;

    @Test
    @Transactional(value = "primaryTm")
    void test1() {
        long result = serviceOrderOraRepository.count();
        System.out.println("Result count (ora)=" + result);
    }

    @Test
    @Transactional(value = "secondaryTm")
    void test2() {
        long result = serviceOrderPgRepository.count();
        System.out.println("Result count (pg)=" + result);
    }

    @Test
    void test3_copy() {
        PageRequest request = PageRequest.of(0, 500);

        Page<ServiceOrderOra> page = serviceOrderReadSrc.readPage(request);
        System.out.println("Result count (pg)=" + page.getContent().size());
    }

}
