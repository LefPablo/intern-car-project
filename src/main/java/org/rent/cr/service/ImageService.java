package org.rent.cr.service;

import org.rent.cr.entity.car.Image;

import java.io.IOException;

public interface ImageService extends CrudService<Image> {
    String writeEncodedStringToFile(String name, String encoded) throws IOException;
    String readFileToEncodedString(String filePath) throws IOException;
}
