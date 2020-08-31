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

    public Document getDocument(Integer id) {
        Optional<Document> byId = documentRepository.findById(id);
        if (byId.isPresent()) {
            return byId.get();
        }
        else {
            return null;
        }
    }

    public Document updateDocument(Document request) {
        Optional<Document> byId = documentRepository.findById(request.getId());
        if (byId.isPresent()) {
            Document documentUpdate = byId.get();
            documentUpdate.setDocumentNumber(request.getDocumentNumber());
            documentUpdate.setDescription(request.getDescription());
            documentUpdate = documentRepository.save(documentUpdate);
            return documentUpdate;
        }
        else {
            return null;
        }
    }

    public Boolean deleteDocument(Integer id) {
        Optional<Document> byId = documentRepository.findById(id);
        if (byId.isPresent()) {
            documentRepository.deleteById(id);
            return true;
        }
        else {
            return false;
        }
    }

    public Document createDocument(Document document) {
        try {
            Document save = documentRepository.save(document);
            return save;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
