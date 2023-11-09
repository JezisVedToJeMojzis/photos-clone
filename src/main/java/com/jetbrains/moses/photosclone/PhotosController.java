package com.jetbrains.moses.photosclone;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.*;

@RestController
public class PhotosController {

    private Map<String, Photo> db = new HashMap<>() {{
        put("1", new Photo("1", "hello.jpg"));
    }};
   // private List<Photo> db = List.of(new Photo("1", "hello.jpg"));

    @GetMapping("/")
    public String hello(){
        return "Hello World!";

    }

    @GetMapping("/photos")
    public Collection<Photo> get(){
        return db.values();
    }

    @GetMapping("/photos/{id}")
    public Photo get(@PathVariable String id){
        Photo photo = db.get(id);
        if (photo == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return db.get(id);
    }

    @DeleteMapping("/photos/{id}")
    public void delete(@PathVariable String id){
        Photo photo = db.remove(id);
        if (photo == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/photos")
    public Photo create(@RequestPart("data") MultipartFile file) throws IOException {
        Photo photo = new Photo();
        photo.setId(UUID.randomUUID().toString());
        photo.setFileName(file.getOriginalFilename());
        photo.setData(file.getBytes());
        db.put(photo.getId(), photo);
        return photo;
    }
}
