package com.protosstechnology.train.bootexamine.controller;

import com.protosstechnology.train.bootexamine.models.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller()
@RequestMapping("/document")
public class DocumentController {

    @Autowired
    DocumentService documentService;

    @GetMapping("{id}")
    public ResponseEntity<Document> getDocument(
            @PathVariable("id") String id
    ) {
        Document result = documentService.getDocument(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
