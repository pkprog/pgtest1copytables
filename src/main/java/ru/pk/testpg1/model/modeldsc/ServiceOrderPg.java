package ru.pk.testpg1.model.modeldsc;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema = "NRIV", name = "SERVICE_ORDER")
public class ServiceOrderPg {

    @Id
    @Column(name = "SERVICE_ORDER_ID")
    private Long id;



}
