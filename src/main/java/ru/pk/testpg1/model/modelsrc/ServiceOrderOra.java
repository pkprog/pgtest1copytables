package ru.pk.testpg1.model.modelsrc;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
import ru.pk.testpg1.model.shared.ActivityType;

@Entity
@Table(schema = "NRIV", name = "SERVICE_ORDER")
public class ServiceOrderOra {

    @Id
    @Column(name = "SERVICE_ORDER_ID", nullable = false)
    private Long id;

    @Column(name = "STATUS_ID", nullable = false)
    private int statusId;

    @Column(name = "SERVICE_TYPE_ID", nullable = false)
    private int serviceTypeId;

    @Column(name = "COM_ORDER_ID")
    private Long comOrderId;

    @Column(name = "MSS_EWO_ID", nullable = false)
    private Long mssEwoId;

    @Enumerated(EnumType.STRING)
    @Column(name = "ACTIVITY_TYPE", nullable = false)
    private ActivityType activityType;

    @Column(name = "SELECTOR", nullable = false)
    private String selector;

    @Column(name = "CREATED_AT")
    private Date createdAt;

    public Long getId() {
        return id;
    }

    public int getStatusId() {
        return statusId;
    }

    public int getServiceTypeId() {
        return serviceTypeId;
    }

    public Long getComOrderId() {
        return comOrderId;
    }

    public Long getMssEwoId() {
        return mssEwoId;
    }

    public ActivityType getActivityType() {
        return activityType;
    }

    public String getSelector() {
        return selector;
    }

    public Date getCreatedAt() {
        return createdAt;
    }
}
