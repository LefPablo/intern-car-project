package org.rent.cr.entity;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;
import org.rent.cr.dto.view.View;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@Data
@MappedSuperclass
public abstract class GeneralEntity {
    @JsonView({View.Public.class})
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
}
