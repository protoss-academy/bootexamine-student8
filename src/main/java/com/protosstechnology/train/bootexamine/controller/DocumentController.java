package com.protosstechnology.train.bootexamine.controller;

import com.protosstechnology.train.bootexamine.models.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller()
@RequestMapping("/document")
public class DocumentController {

    @Autowired
    DocumentService documentService;

    @GetMapping("/{id}")
    public ResponseEntity<Document> getDocument(
            @PathVariable("id") Integer id
    ) {
        Document result = documentService.getDocument(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Document> updateDocument(
            @RequestBody Document request
    ) {
        Document result = documentService.updateDocument(request);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> updateDocument(
            @PathVariable("id") Integer id
    ) {
        Boolean result = documentService.deleteDocument(id);
        if (result){
            return new ResponseEntity<>("Delete Success", HttpStatus.OK);
        }
        return new ResponseEntity<>("Delete Fail", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PostMapping
    public ResponseEntity<Document> createDocument(
            @RequestBody Document document
    ) {
        Document result = documentService.createDocument(document);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
