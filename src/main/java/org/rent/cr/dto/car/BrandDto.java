package org.rent.cr.dto.car;

import org.rent.cr.entity.car.Brand;
import org.springframework.beans.BeanUtils;

public class BrandDto {
    private Integer id;
    private String name;
    private String secure;

    public BrandDto() {
    }

    public static BrandDto brandToDto(Brand brand) {
        BrandDto brandDto = new BrandDto();
        BeanUtils.copyProperties(brand, brandDto);
        brandDto.secure = "Special";
        return brandDto;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecure() {
        return secure;
    }

    public void setSecure(String secure) {
        this.secure = secure;
    }
}
