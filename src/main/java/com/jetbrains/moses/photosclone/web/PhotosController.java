package com.jetbrains.moses.photosclone.web;

import com.jetbrains.moses.photosclone.model.Photo;
import com.jetbrains.moses.photosclone.service.PhotosService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.*;

@RestController
public class PhotosController {

   // @Autowired
    private final PhotosService photosService;
   // private List<Photo> db = List.of(new Photo("1", "hello.jpg"));

    public PhotosController(PhotosService photosService){
        this.photosService = photosService;
    }

    @GetMapping("/")
    public String hello(){
        return "Hello World!";

    }

    @GetMapping("/photos")
    public Collection<Photo> get(){
        return photosService.get();
    }

    @GetMapping("/photos/{id}")
    public Photo get(@PathVariable String id){
        Photo photo = photosService.get(id);
        if (photo == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return photosService.get(id);
    }

    @DeleteMapping("/photos/{id}")
    public void delete(@PathVariable String id){
        Photo photo = photosService.remove(id);
        if (photo == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/photos")
    public Photo create(@RequestPart("data") MultipartFile file) throws IOException {
        return photosService.save(file.getOriginalFilename(), file.getContentType(), file.getBytes());

    }
}
