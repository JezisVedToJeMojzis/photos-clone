package com.jetbrains.moses.photosclone.service;

import com.jetbrains.moses.photosclone.model.Photo;
import com.jetbrains.moses.photosclone.repository.PhotosRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class PhotosService {

    private final PhotosRepository photosRepository;

  //  private Map<String, Photo> db = new HashMap<>() {{
//        put("1", new Photo("1", "hello.jpg"));
 //   }};

    public PhotosService(PhotosRepository photosRepository) {
        this.photosRepository = photosRepository;
    }

    public Iterable<Photo> get() {
        return photosRepository.findAll();
    }


    public Photo get(Integer id) {
        return photosRepository.findById(id).orElse(null);
    }

    public void remove(Integer id) {
        photosRepository.deleteById(id);
    }

    public Photo save(String fileName, String contentType, byte[] data) {
        Photo photo = new Photo();
        photo.setContentType(contentType);
      //  photo.setId(UUID.randomUUID().toString());
        photo.setFileName(fileName);
        photo.setData(data);
        photosRepository.save(photo);
        return photo;
    }
}
