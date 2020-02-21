package org.rent.cr.controller;

import com.fasterxml.jackson.annotation.JsonView;
import org.rent.cr.dto.car.ImageUploadDto;
import org.rent.cr.dto.car.ImageViewDto;
import org.rent.cr.dto.view.View;
import org.rent.cr.entity.car.Image;
import org.rent.cr.exception.IllegalActionException;
import org.rent.cr.exception.NoEntityException;
import org.rent.cr.exception.NotSavedException;
import org.rent.cr.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.stream.Collectors;

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

    @Override
    public Object getPage(@RequestParam(name = "page", defaultValue = "1") Integer page, @RequestParam(name = "per_page", defaultValue = "20") Integer size, @RequestParam(name = "sort", required = false) String field, @RequestParam(name = "filter", required = false) String filter) {
        Page<Image> source = (Page<Image>) super.getPage(page, size, field, filter);
        Page<ImageViewDto> result = new PageImpl<ImageViewDto>(source.getContent().stream().map(image -> {
            ImageViewDto imageViewDto = new ImageViewDto();
            imageViewDto.toDto(image);
            return imageViewDto;
        }).collect(Collectors.toList()));
        return result;
    }

    @Override
    public Object findById(@PathVariable("id") int id) throws NoEntityException {
        ImageViewDto imageViewDto = new ImageViewDto();
        imageViewDto.toDto((Image) super.findById(id));
        return imageViewDto;
    }

    @PostMapping("upload")
    public Image save(@RequestBody ImageUploadDto imageUploadDto) throws IOException, NotSavedException {
        String imageName = service.writeEncodedStringToFile(imageUploadDto.getEncodedString());
        Image image = imageUploadDto.toImage();
        image.setName(imageName);
        return service.save(image);
    }

    @JsonView(View.Public.class)
    @GetMapping("{id}/download")
    public ImageUploadDto testDownloadFile(@PathVariable("id") Image image) throws IOException {
        ImageUploadDto imageUploadDto = new ImageUploadDto();
        imageUploadDto.toDto(image);
        imageUploadDto.setEncodedString(service.readFileToEncodedString(image.getName()));
        return imageUploadDto;
    }

}
