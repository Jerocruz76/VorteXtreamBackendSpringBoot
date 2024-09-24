package com.riwi.VorteXtream_BACK_END_SpringBoot.Adapters.Controllers;

import com.riwi.VorteXtream_BACK_END_SpringBoot.Domain.Entities.ImageEntity;
import com.riwi.VorteXtream_BACK_END_SpringBoot.Domain.Services.Impl.CloudinaryService;
import com.riwi.VorteXtream_BACK_END_SpringBoot.Domain.Services.Impl.ImageService;
import com.riwi.VorteXtream_BACK_END_SpringBoot.Application.dto.MessageError;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/images")
public class ImageController {

    @Autowired
    CloudinaryService cloudinaryService;

    @Autowired
    ImageService imageService;

    @GetMapping("/list")
    @Operation(summary = "List Image", description = "an endpoint to List Image")
    @ApiResponse(responseCode = "200", description = "the Image was Listed successfully")
    public ResponseEntity<List<ImageEntity>> List(){
        List<ImageEntity> list =  imageService.List();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping("/uploadImage")
    @Operation(summary = "upload Image", description = "an endpoint to upload Image")
    @ApiResponse(responseCode = "200", description = "the Image was upload successfully")
    public ResponseEntity<?> upload(@RequestParam MultipartFile multipartFile) throws IOException {
        BufferedImage bi = ImageIO.read(multipartFile.getInputStream());
        if (bi == null){
            return new ResponseEntity(new MessageError("Invalid image format"), HttpStatus.BAD_REQUEST);
        }
        Map result = cloudinaryService.upload(multipartFile);
        ImageEntity imageEntity = new ImageEntity((String)result.get("original_filename"),
                (String) result.get("url"),
                (String) result.get("public_id"));
        imageService.save(imageEntity);
        return new ResponseEntity<>(new MessageError("Image saved"), HttpStatus.OK);
    }

    @DeleteMapping("/deleteImage/{idImage}")
    @Operation(summary = "Delete Image by Id", description = "an endpoint to Delete Image by Id")
    @ApiResponse(responseCode = "204", description = "Delete the Image by Id successfully")
    public ResponseEntity<?> deleteImage(@PathVariable("idImage") int id) throws IOException {
        if (!imageService.exists(id)) return new ResponseEntity<>(new MessageError("this img doesn't exists"), HttpStatus.BAD_REQUEST) ;
        ImageEntity imageEntity = imageService.getOne(id).get();
        Map result = cloudinaryService.delete(imageEntity.getPublic_id());
        imageService.delete(id);
        return new ResponseEntity<>(new MessageError("Image deleted"), HttpStatus.OK);
    }
}
