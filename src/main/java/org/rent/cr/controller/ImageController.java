package org.rent.cr.controller;

import org.rent.cr.dto.car.ImageDto;
import org.rent.cr.entity.car.Image;
import org.rent.cr.exception.IllegalActionException;
import org.rent.cr.exception.NoEntityException;
import org.rent.cr.exception.NotSavedException;
import org.rent.cr.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.io.IOException;

@RestController
@RequestMapping("images")
public class ImageController extends CrudController<Image, ImageService> {

    @Autowired
    public ImageController(ImageService service) {
        super(service);
    }

    @Override
    @ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "No message available")
    public Object save(Image entity) throws NotSavedException, IllegalActionException, NoEntityException {
        return super.save(entity);
    }

    @PostMapping("upload")
    public Image save(@RequestBody ImageDto imageDto) throws IOException, NotSavedException {
        String imagePath = service.writeEncodedStringToFile(imageDto.getName() ,imageDto.getEncodedString());
        Image image = imageDto.toImage();
        image.setPath(imagePath);
        return service.save(image);
    }

    @GetMapping("{id}/download")
    public ImageDto testDownloadFile(@PathVariable("id") Image image) throws IOException {
        ImageDto imageDto = new ImageDto();
        imageDto.toDto(image);
        imageDto.setEncodedString(service.readFileToEncodedString(image.getPath()));
        return imageDto;
    }

}
