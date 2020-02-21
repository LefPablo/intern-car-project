package org.rent.cr.dto.car;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;
import org.rent.cr.dto.view.View;
import org.rent.cr.entity.GeneralEntity;
import org.rent.cr.entity.car.Car;
import org.rent.cr.entity.car.Image;

@Data
public class ImageUploadDto extends GeneralEntity {
    private Integer position;
    private String encodedString;
    @JsonView(View.Exclude.class)
    private Car car;

    public Image toImage() {
        Image image = new Image();
        image.setPosition(position);
        image.setCar(car);
        return image;
    }

    public void toDto(Image image) {
        this.car = image.getCar();
        this.position = image.getPosition();
        this.setId(image.getId());
    }
}
