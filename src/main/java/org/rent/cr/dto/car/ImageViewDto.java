package org.rent.cr.dto.car;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;
import org.rent.cr.dto.view.View;
import org.rent.cr.entity.GeneralEntity;
import org.rent.cr.entity.car.Image;

import java.io.IOException;
import java.util.Properties;

@Data
@JsonView(View.Public.class)
public class ImageViewDto extends GeneralEntity {
    private Integer position;
    private String downloadUrl;

    public void toDto(Image image) {
        Properties properties = new Properties();
        final String propertiesName = "path.properties";
        final String valueName = "path.download-img";
        try {
            properties.load(ClassLoader.getSystemResourceAsStream(propertiesName));
        } catch (IOException e) {

        }
        this.position = image.getPosition();
        this.downloadUrl = properties.getProperty(valueName).replace("{id}", image.getId().toString());
        this.setId(image.getId());
    }
}
