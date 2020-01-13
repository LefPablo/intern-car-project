package org.rent.cr.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "reservs")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "reservname")
    private String name;

    @Column(name = "reservphone")
    private String phone;

    @Column(name = "reservstart")
    private LocalDateTime start;

    @Column(name = "reservend")
    private LocalDateTime end;

    @Column(name = "reservupd")
    private LocalDateTime updated;

    @Column(name = "reservproces")
    private boolean processed;

    public Reservation() {
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public void setEnd(LocalDateTime end) {
        this.end = end;
    }

    public LocalDateTime getUpdated() {
        return updated;
    }

    public void setUpdated(LocalDateTime updated) {
        this.updated = updated;
    }

    public boolean isProcessed() {
        return processed;
    }

    public void setProcessed(boolean processed) {
        this.processed = processed;
    }
}
