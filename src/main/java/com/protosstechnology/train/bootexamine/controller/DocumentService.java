package com.protosstechnology.train.bootexamine.controller;

import com.protosstechnology.train.bootexamine.models.Document;
import com.protosstechnology.train.bootexamine.repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DocumentService {

    @Autowired
    DocumentRepository documentRepository;

    public Document getDocument(String id) {
        Optional<Document> byId = documentRepository.findById(Integer.valueOf(id));
        if (byId.isPresent()) {
            return byId.get();
        }
        else {
            return null;
        }
    }
}
