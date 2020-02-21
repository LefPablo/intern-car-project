package org.rent.cr.service.impl.car;

import org.apache.commons.io.FileUtils;
import org.rent.cr.dao.repo.car.ImageRepository;
import org.rent.cr.entity.car.Image;
import org.rent.cr.service.ImageService;
import org.rent.cr.service.impl.CrudServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.io.IOException;
import java.util.Base64;
import java.util.UUID;

@Service
@Transactional
@PropertySource("classpath:path.properties")
public class ImageServiceImpl extends CrudServiceImpl<Image, ImageRepository> implements ImageService {

    @Value("${path.image-source}")
    private String IMAGE_PATH;

    @Autowired
    public ImageServiceImpl(ImageRepository imageRepository) {
        super(imageRepository);
    }

    @Override
    public String writeEncodedStringToFile(String encodedString) throws IOException {
        String fileName = UUID.randomUUID().toString();
        String filePath =  IMAGE_PATH + fileName;
        byte[] decodedBytes = Base64
                .getDecoder()
                .decode(encodedString);

        File outputFile = new File(filePath);
        FileUtils.writeByteArrayToFile(outputFile , decodedBytes);
        return fileName;
    }

    @Override
    public String readFileToEncodedString(String fileName) throws IOException {
        ResourceLoader resourceLoader = new DefaultResourceLoader();
        Resource resource = resourceLoader.getResource("file:" + IMAGE_PATH + fileName);

        byte[] fileContent = FileUtils.readFileToByteArray(resource.getFile());
        String encodedString = Base64
                .getEncoder()
                .encodeToString(fileContent);
        return encodedString;
    }
}
