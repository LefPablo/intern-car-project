package org.rent.cr.service.impl.car;

import org.rent.cr.entity.car.Image;
import org.rent.cr.dao.repo.car.ImageRepository;
import org.rent.cr.service.ImageService;
import org.rent.cr.service.impl.CrudServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ImageServiceImpl extends CrudServiceImpl<Image, ImageRepository> implements ImageService {

    @Autowired
    public ImageServiceImpl(ImageRepository imageRepository) {
        super(imageRepository);
    }
}
