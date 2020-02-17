package org.rent.cr.dto.car;

import lombok.Data;
import org.rent.cr.entity.GeneralEntity;
import org.rent.cr.entity.car.Car;
import org.rent.cr.entity.car.Image;

@Data
public class ImageDto extends GeneralEntity {
    private Car car;
    private Integer position;
    private String encodedString;
    private String name;

    public Image toImage() {
        Image image = new Image();
        image.setPosition(position);
        image.setCar(car);
        return image;
    }

    public void toDto(Image image) {
        this.position = image.getPosition();
        this.car = image.getCar();
        this.name = image.getPath();
        this.setId(image.getId());
    }
}
