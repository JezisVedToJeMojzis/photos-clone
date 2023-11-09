package com.jetbrains.moses.photosclone.repository;

import com.jetbrains.moses.photosclone.model.Photo;
import org.springframework.data.repository.CrudRepository;

public interface PhotosRepository extends CrudRepository<Photo, Integer> {

}
