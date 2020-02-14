package org.rent.cr.controller;

import org.rent.cr.entity.car.Image;
import org.rent.cr.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("images")
public class ImageController extends CrudController<Image, ImageService> {

    @Autowired
    public ImageController(ImageService service) {
        super(service);
    }
}
