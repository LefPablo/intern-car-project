package org.rent.cr.service.impl;

import org.rent.cr.entity.Characteristic;
import org.rent.cr.dao.repo.CharacteristicRepository;
import org.rent.cr.service.CharacteristicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CharacteristicServiceImpl extends CrudServiceImpl<Characteristic, CharacteristicRepository> implements CharacteristicService {

    @Autowired
    public CharacteristicServiceImpl(CharacteristicRepository characteristicRepository) {
        super(characteristicRepository);
    }
}
