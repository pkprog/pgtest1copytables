package ru.pk.testpg1.model.modelsrc;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema = "NRIV", name = "SERVICE_ORDER")
public class ServiceOrderOra {

    @Id
    @Column(name = "SERVICE_ORDER_ID", nullable = false)
    private Long id;

    @Column(name = "STATUS_ID", nullable = false)
    private int statusId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }
}
