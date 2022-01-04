package ru.pk.testpg1.model.modeldsc;

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
public class ServiceOrderPg {

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

    public void setId(Long id) {
        this.id = id;
    }

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public int getServiceTypeId() {
        return serviceTypeId;
    }

    public void setServiceTypeId(int serviceTypeId) {
        this.serviceTypeId = serviceTypeId;
    }

    public Long getComOrderId() {
        return comOrderId;
    }

    public void setComOrderId(Long comOrderId) {
        this.comOrderId = comOrderId;
    }

    public Long getMssEwoId() {
        return mssEwoId;
    }

    public void setMssEwoId(Long mssEwoId) {
        this.mssEwoId = mssEwoId;
    }

    public ActivityType getActivityType() {
        return activityType;
    }

    public void setActivityType(ActivityType activityType) {
        this.activityType = activityType;
    }

    public String getSelector() {
        return selector;
    }

    public void setSelector(String selector) {
        this.selector = selector;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
